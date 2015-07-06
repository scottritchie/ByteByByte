/*
 * File: InstanceVariable.java
 * 
 * Copyright (C) 2015  Scott Ritchie
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package com.viacron.utils.ungenerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class can be used to recover a grammar that was accidentally deleted as
 * long as the generated class files are still available. The grammar is
 * "ungenerated" from the class files by reverse engineering the generated class
 * files.
 * 
 * @author Scott Ritchie
 * 
 * @history sritchie Mar 28, 2015 : Initial creation.
 */
public class Ungenerate {

	private static String theRootClass;

	//
	private static final String BBB_INSTANCE_VARIABLES_MARKER = "* See buildInstanceVariables() in JBitByBitGenerator.java.";
	private static final String SMB_INSTANCE_VARIABLES_MARKER = "* See buildInstanceVariables() in StringMessageBufferGenerator.xtend.";

	private static final String BBB_END_OF_INSTANCE_VARIABLES_MARKER = "* This method gets the";
	private static final String SMB_END_OF_INSTANCE_VARIABLES_MARKER = "private String element";
	
	private static List<Msg> theMessages = new ArrayList<Msg>();
	private static List<MsgSubType> theSubTypes = new ArrayList<MsgSubType>();
	private static List<MsgEnum> theEnums = new ArrayList<MsgEnum>();

	private enum SearchState {
		SEARCHING, FOUND_BUILD_INSTANCE_VARIABLES, FOUND_END_OF_COMMENT, FOUND_END_OF_INSTANCE_VARIABLES, FOUND_ENUM, PROCESSING_ENUM
	}

	static SearchState searchState;

	private static boolean isDebug = true;
	private static String theVersion = "BBB";

	private static String theInstanceVariableMarker;
	private static String theEndOfInstanceVariablesMarker;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		theRootClass = "C:/Users/Scott/Greenball/workspace/Snippets/src/com/viacron/greenball/messsages/com/viacron/greenball/app/bbb/GreenballMessages.java";
		theRootClass = "C:/Users/Scott/Documents/Programs/Guictl.08.21.2013/GuictlMessaging/src/com/viacron/guictl/guictl_message/msgs/GuictlMessages.java";
		int index = 0;
		for (String arg : args) {
			if (arg.equals("-root")) {
				theRootClass = args[index + 1];
			}
			else if (arg.equals("-BBB")) {
				theVersion = "BBB";
			}
			else if (arg.equals("-SMB")) {
				theVersion = "SMB";
			}

			index++;
		}
		
		theVersion = "SMB";

		if (theRootClass == null) {
			printUsage();
			System.exit(0);
		}
		
		initMarkers();

		List<Element> elements = getListOfFiles();
		if (isDebug)
			System.out.println("Found " + elements.size() + " elements.");

		File f = new File(theRootClass);
		String dir = f.getParent();
		if (isDebug)
			System.out.println("dir: " + dir);

		for (Element element : elements) {
			processElements(dir, element);
		}
		if (isDebug)
			System.out.println("Found " + theMessages.size() + " messages.");
		if (isDebug)
			System.out.println("Found " + theSubTypes.size() + " sub-types.");
		if (isDebug)
			System.out.println("Found " + theEnums.size() + " enums.");

		dumpMessages();
	//	dumpSubTypes();
	//	dumpEnums();

	}
	
	private static void initMarkers() {
		if (theVersion.equals("BBB")) {
			theInstanceVariableMarker = BBB_INSTANCE_VARIABLES_MARKER;
			theEndOfInstanceVariablesMarker = BBB_END_OF_INSTANCE_VARIABLES_MARKER;
		}
		else if(theVersion.equals("SMB")) {			
			theInstanceVariableMarker = SMB_INSTANCE_VARIABLES_MARKER;
			theEndOfInstanceVariablesMarker = SMB_END_OF_INSTANCE_VARIABLES_MARKER;
		}
	}

	private static void dumpMessages() {

		for (Msg msg : theMessages) {
			System.out.println("Message " + msg.getName() + " {");
			for (InstanceVariable attr : msg.getAttributes()) {
				System.out.println("   " + attr.getAttributeName() + " as "
						+ attr.getAttributeType()
						+ (attr.isOptional() == true ? " (optional)" : ""));
			}
			System.out.println("}\n");
		}
	}

	private static void dumpSubTypes() {

		for (MsgSubType subtype : theSubTypes) {
			System.out.println("SubType " + subtype.getSubTypeName() + " {");
			for (InstanceVariable attr : subtype.getMsgAttributes()) {
				System.out.println("   " + attr.getAttributeName() + " as "
						+ attr.getAttributeType());
			}
			System.out.println("}\n");
		}
	}

	private static void dumpEnums() {

		for (MsgEnum enumeration : theEnums) {
			System.out.println("Enum " + enumeration.getName() + " {");
			for (String str : enumeration.getEnumerations()) {
				System.out.println("   " + str);
			}
			System.out.println("}\n");
		}
	}

	/*
	 * This method processes the elements. An element is just a ByteByByte file.
	 */
	private static void processElements(String dir, Element element) {
		List<InstanceVariable> instanceVariables = new ArrayList<InstanceVariable>();
		List<String> enumerations = new ArrayList<String>();

		searchState = SearchState.SEARCHING;
		BufferedReader br;
		String str;
		String pathToFile = dir + File.separatorChar + element.getFileName();
		boolean isMsg = false;
		boolean isSubType = false;
		boolean isEnum = false;
		boolean isTypeUnknown = true;

		File f = new File(pathToFile);

		if (isDebug)
			System.out.println("processing " + element.getName());

		if (f.exists() == true) {
			try {
				boolean isDone = false;
				br = new BufferedReader(new FileReader(pathToFile));

				try {
					while ((str = br.readLine()) != null && isDone == false) {
						/*
						 * Determine if the file contains a message, subtype, or
						 * enum.
						 */
						if (str.trim()
								.equals("* The "
										+ element.getName()
										+ " class defines a message of the messaging system defined")) {
							isMsg = true;
							isTypeUnknown = false;
							if (isDebug)
								System.out.println("isMsg: "
										+ element.getName());
						} else if (str
								.trim()
								.equals("* The "
										+ element.getName()
										+ " class is a SubType referenced by message objects defined")) {
							isSubType = true;
							isTypeUnknown = false;
							if (isDebug)
								System.out.println("isSubType: "
										+ element.getName());
						} else if (str.trim().equals(
								"public enum " + element.getName() + " {")) {
							isEnum = true;
							isTypeUnknown = false;
							if (isDebug)
								System.out.println("isEnum: "
										+ element.getName());
						}

						if (isMsg == true) {
							isDone = processInstanceVariables(str,
									instanceVariables);

							if (isDone == true) {
								Msg msg = new Msg(element.getName(),
										instanceVariables, null, null);
								theMessages.add(msg);
							}
						} else if (isSubType == true) {
							isDone = processInstanceVariables(str,
									instanceVariables);

							if (isDone == true) {
								MsgSubType subType = new MsgSubType(
										element.getName(), instanceVariables);
								theSubTypes.add(subType);
							}
						} else if (isEnum == true) {
							isDone = processEnum(str, enumerations,
									element.getName());

							if (isDone == true) {
								MsgEnum msgEnum = new MsgEnum(
										element.getName(), enumerations);
								theEnums.add(msgEnum);
							}
						}
					}

					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		if (isTypeUnknown == true) {
			if (isDebug)
				System.out.println("Unknown/unsupported file type: "
						+ element.getName());
		}
	}

	private static boolean processInstanceVariables(String str,
			List<InstanceVariable> instanceVariables) {
		boolean isDone = false;

		if (str.trim().equals(theInstanceVariableMarker)) {
			if (isDebug)
				System.out.println("ok1");
			searchState = SearchState.FOUND_BUILD_INSTANCE_VARIABLES;
		} else if (searchState == SearchState.FOUND_END_OF_INSTANCE_VARIABLES) {
			if (str.trim().length() > 22
					&& str.trim().substring(0, 22)
							.equals("* This method sets the")) {
				String[] tokens = str.trim().split(" ");
				String variableName = tokens[5];
				if (isDebug)
					System.out.println("ok5");
				if (isDebug)
					System.out.println("variableName: " + variableName);
				for (InstanceVariable instanceVariable : instanceVariables) {
					if (instanceVariable.getAttributeName()
							.equals(variableName)) {
						if (str.contains("required")) {
							instanceVariable.setOptional(false);
						} else {
							if (isDebug)
								System.out.println("optional");
							instanceVariable.setOptional(true);
						}
						break;
					}
				}
				searchState = SearchState.FOUND_BUILD_INSTANCE_VARIABLES;
			} else if (str.trim().length() > 22
					&& str.trim().substring(0, 22)
							.equals(theEndOfInstanceVariablesMarker)) {
				if (isDebug)
					System.out.println("ok6");
				isDone = true;
			}
		} else if (searchState == SearchState.FOUND_BUILD_INSTANCE_VARIABLES) {
			if (isDebug)
				System.out.println("ok2");
			searchState = SearchState.FOUND_END_OF_COMMENT;
		} else if (searchState == SearchState.FOUND_END_OF_COMMENT) {
			if (isDebug)
				System.out.println("ok3");
			String[] tokens = str.trim().split(" ");
			
			if (isDebug)
				System.out.println("# of tokens: " + tokens.length);
			

			// BBB
			if (tokens.length == 3) {
				int tokenLen = tokens[2].length();
				String variableType = fixCase(tokens[1]);

				String variableName = tokens[2].substring(0, tokenLen - 1);

				if (variableType.startsWith("List<")) {
					int len = tokens[1].length();
					variableType = fixCase(tokens[1].substring(5, len - 1));

					variableType = "list of " + variableType;
				}

				if (isDebug)
					System.out.println("variableType: " + variableType);
				if (isDebug)
					System.out.println("variableName: " + variableName);
				
				InstanceVariable msgAttr = new InstanceVariable(variableType,
						variableName);
				instanceVariables.add(msgAttr);
			} else if (tokens.length == 5) {
				// SMB
				String variableType = fixCase(tokens[1]);

				String variableName = tokens[2];

				if (variableType.startsWith("List<")) {
					int len = tokens[1].length();
					variableType = fixCase(tokens[1].substring(5, len - 1));

					variableType = "list of " + variableType;
				}

				if (isDebug)
					System.out.println("variableType: " + variableType);
				if (isDebug)
					System.out.println("variableName: " + variableName);
				
				InstanceVariable msgAttr = new InstanceVariable(variableType,
						variableName);
				instanceVariables.add(msgAttr);
			} else {
				searchState = SearchState.FOUND_END_OF_INSTANCE_VARIABLES;
				if (isDebug)
					System.out.println("ok4");
			}
		}

		return isDone;
	}

	private static boolean processEnum(String str, List<String> enumerations,
			String enumName) {
		boolean isDone = false;

		if (str.trim().equals("public enum " + enumName + " {")) {
			searchState = SearchState.PROCESSING_ENUM;
		} else if (searchState == SearchState.PROCESSING_ENUM) {
			String[] tokens = str.trim().split(" ");

			if (tokens.length == 2) {
				int tokenLen = tokens[1].length();
				String value = tokens[1].substring(1, tokenLen - 3);
				enumerations.add(value);
			} else {
				isDone = true;
			}
		}
		return isDone;
	}

	private static List<Element> getListOfFiles() {
		BufferedReader br;
		String str;
		List<Element> elements = new ArrayList<Element>();

		File file = new File(theRootClass);

		String parent = file.getParent();
		File dir = new File(parent);
		File[] files = dir.listFiles();

		for (File f : files) {
			String fileName = f.getName();
			String[] tokens = fileName.split("\\.");

			Element element = new Element(tokens[0], fileName);
			elements.add(element);
		}

		return elements;
	}

	private static String fixCase(String variableType) {
		if (variableType.equals("String")) {
			variableType = "string";
		} else if (variableType.equals("int")) {
			variableType = "integer";
		} else if (variableType.equals("Integer")) {
			variableType = "integer";
		} else if (variableType.equals("Calendar")) {
			variableType = "calendar";
		} else if (variableType.equals("Character")) {
			variableType = "char";
		} else if (variableType.equals("Boolean")) {
			variableType = "boolean";
		} else if (variableType.equals("Byte")) {
			variableType = "byte";
		} else if (variableType.equals("Double")) {
			variableType = "double";
		} else if (variableType.equals("Float")) {
			variableType = "float";
		} else if (variableType.equals("Long")) {
			variableType = "long";
		} else if (variableType.equals("Short")) {
			variableType = "short";
		}

		return variableType;
	}

	private static void printUsage() {
		System.out.println("usage:");
		System.out.println("  root class -root <root class>");
	}

}
