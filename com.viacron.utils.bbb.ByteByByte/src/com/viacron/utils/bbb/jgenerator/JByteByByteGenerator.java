package com.viacron.utils.bbb.jgenerator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

import com.viacron.utils.bbb.byteByByte.AbstractAttribute;
import com.viacron.utils.bbb.byteByByte.Attribute;
import com.viacron.utils.bbb.byteByByte.AttributeType;
import com.viacron.utils.bbb.byteByByte.DateTimeFormat;
import com.viacron.utils.bbb.byteByByte.GrammarName;
import com.viacron.utils.bbb.byteByByte.Message;
import com.viacron.utils.bbb.byteByByte.PEnum;
import com.viacron.utils.bbb.byteByByte.PEnumElement;
import com.viacron.utils.bbb.byteByByte.PEnumRef;
import com.viacron.utils.bbb.byteByByte.PackageDeclaration;
import com.viacron.utils.bbb.byteByByte.RootClass;
import com.viacron.utils.bbb.byteByByte.SubType;
import com.viacron.utils.bbb.byteByByte.SubTypeRef;

public class JByteByByteGenerator implements IGenerator {

	private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	private static final String INDENTATION_STRING = "   ";
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	private static String theDateTimeFormat = DEFAULT_DATE_TIME_FORMAT;
	private static List<Message> theMessageList;
	private static List<SubType> theSubTypeList;

	private Resource theResource;
	private String grammarName = "";
	private String rootClass = "";
	// private boolean isFirst = true;
	private String attributeInitString = "";
	private String instantiationString = "";
	private String classSearchString = "";
	private String objectString = "";
	private String flagString = "";
	private String prefix = "";
	private String objectName = "";
	private String method = "";
	private String packageName = "";
	private int theLevel = 0;

	private boolean isDebug = false;

	public void doGenerate(Resource resource, IFileSystemAccess fsa) {
		String className = "";
		String penumName = "";
		String fullPath = packagePath(resource);
		if (isDebug)
			System.out.println("fullPath: " + fullPath);

		theResource = resource;

		theMessageList = toMessageList(resource.getAllContents());
		theSubTypeList = toSubTypeList(resource.getAllContents());

		for (GrammarName e : toGrammarNameList(resource.getAllContents())) {
			grammarName = e.getName();
			if (isDebug)
				System.out.println("grammar " + grammarName);
		}

		for (DateTimeFormat e : toDateTimeFormatList(resource.getAllContents())) {
			theDateTimeFormat = e.getDateTimeFormat();
			if (isDebug)
				System.out.println("dateTimeFormat " + theDateTimeFormat);
		}

		for (PackageDeclaration e : toPackageDeclarationList(resource
				.getAllContents())) {
			packageName = e.getName();
			if (isDebug)
				System.out.println("package " + packageName);
		}

		// Generate the MissingAttributeException class
		String exceptionClassName = "MissingAttributeException";
		fsa.generateFile(
				fullPath + "/" + exceptionClassName + ".java",
				generateMissingAttributeExceptionClass(packageName,
						exceptionClassName));

		// Generate the root class file
		for (RootClass e : toRootClassList(resource.getAllContents())) {
			rootClass = e.getName();
			if (isDebug)
				System.out.println("root class " + rootClass);
			fsa.generateFile(fullPath + "/" + rootClass + ".java",
					generateRootClassFile(packageName, rootClass, resource));
		}

		// Generate the root DirectoryEntry class
		String directoryEntryClassName = rootClass + "DirectoryEntry";
		fsa.generateFile(
				fullPath + "/" + directoryEntryClassName + ".java",
				generateDirectoryEntryClass(packageName,
						directoryEntryClassName));

		// Generate the root DirectoryInfoItem class
		String directoryInfoItemClassName = grammarName + "DirectoryInfoItem";
		fsa.generateFile(
				fullPath + "/" + directoryInfoItemClassName + ".java",
				generateDirectoryInfoItemClass(packageName,
						directoryInfoItemClassName));

		// Generate the utility class file
		fsa.generateFile(fullPath + "/" + rootClass + "Utility.java",
				generateUtilityClassFile(packageName, rootClass));

		// Generate the root class enum file
		fsa.generateFile(fullPath + "/" + rootClass + "Enum.java",
				generateRootClassEnumFile(packageName, rootClass, resource));

		// Generate a class file for each Message
		for (Message msg : theMessageList) {
			className = msg.getName();

			dumpMessage(msg);
			fsa.generateFile(
					fullPath + "/" + className + ".java",
					generateMessageClassFile(packageName, msg,
							theDateTimeFormat));
		}

		// Generate a class file for each SubType
		for (SubType subType : theSubTypeList) {
			if (isDebug)
				System.out.println("subtype: " + subType.getName());
			printAttributes(subType.getAttributes());
			fsa.generateFile(
					fullPath + "/" + subType.getName() + ".java",
					generateClassFile(packageName, subType.getName(),
							subType.getAttributes(), subType.getEnums(), true,
							theDateTimeFormat));
		}

		// Generate a file for each PEnum
		for (PEnum penum : toPEnumList(resource.getAllContents())) {
			penumName = toFirstUpper(penum.getName());
			penumName = penum.getName();

			if (isDebug)
				System.out.println("penum: " + penumName);
			printEnum(penum);
			fsa.generateFile(
					fullPath + "/" + penumName + ".java",
					generateEnumFile(packageName, penumName,
							penum.getElements()));
		}

		// Generate the Initialization class file
		for (Message msg : theMessageList) {
			fsa.generateFile(
					fullPath + "/Initialize" + msg.getName() + ".java",
					generateInitializationFile(packageName, msg));
		}

		// Generate an initialization class file for each SubType
		for (SubType subType : theSubTypeList) {
			if (isDebug)
				System.out.println("subtype: " + subType.getName());
			printAttributes(subType.getAttributes());
			fsa.generateFile(fullPath + "/" + "Initialize" + subType.getName()
					+ ".java",
					generateSubTypeInitializationFile(packageName, subType));
		}

		// Generate the Instantiation class file
		for (Message msg : theMessageList) {
			fsa.generateFile(fullPath + "/Instantiate" + msg.getName()
					+ ".java", generateInstantiationFile(packageName, msg));
		}

		// Generate an instantiation class file for each SubType
		for (SubType subType : theSubTypeList) {
			if (isDebug)
				System.out.println("subtype: " + subType.getName());
			printAttributes(subType.getAttributes());
			fsa.generateFile(fullPath + "/" + "Instantiate" + subType.getName()
					+ ".java",
					generateSubTypeInstantiationFile(packageName, subType));
		}

		if (isDebug)
			System.out.println("grammar " + grammarName);
	}

	private String toFirstUpper(String str) {
		String result = null;

		if (str != null) {
			if (str.length() > 1) {
				result = str.substring(0, 1).toUpperCase() + str.substring(1);
			} else {
				result = str.toUpperCase();
			}
		}

		return result;
	}

	private String toFirstLower(String str) {
		String result = null;

		if (str != null) {
			if (str.length() > 1) {
				result = str.substring(0, 1).toLowerCase() + str.substring(1);
			} else {
				result = str.toLowerCase();
			}
		}

		return result;
	}

	private List<GrammarName> toGrammarNameList(TreeIterator<EObject> iter) {
		List<GrammarName> list = new ArrayList<GrammarName>();

		while (iter.hasNext()) {
			EObject obj = iter.next();
			if (obj instanceof GrammarName) {
				list.add((GrammarName) obj);
			}
		}

		return list;
	}

	private List<DateTimeFormat> toDateTimeFormatList(TreeIterator<EObject> iter) {
		List<DateTimeFormat> list = new ArrayList<DateTimeFormat>();

		while (iter.hasNext()) {
			EObject obj = iter.next();
			if (obj instanceof DateTimeFormat) {
				list.add((DateTimeFormat) obj);
			}
		}

		return list;
	}

	private List<PackageDeclaration> toPackageDeclarationList(
			TreeIterator<EObject> iter) {
		List<PackageDeclaration> list = new ArrayList<PackageDeclaration>();

		while (iter.hasNext()) {
			EObject obj = iter.next();
			if (obj instanceof PackageDeclaration) {
				list.add((PackageDeclaration) obj);
			}
		}

		return list;
	}

	private List<RootClass> toRootClassList(TreeIterator<EObject> iter) {
		List<RootClass> list = new ArrayList<RootClass>();

		while (iter.hasNext()) {
			EObject obj = iter.next();
			if (obj instanceof RootClass) {
				list.add((RootClass) obj);
			}
		}

		return list;
	}

	private List<Message> toMessageList(TreeIterator<EObject> iter) {
		List<Message> list = new ArrayList<Message>();

		while (iter.hasNext()) {
			EObject obj = iter.next();
			if (obj instanceof Message) {
				list.add((Message) obj);
			}
		}

		return list;
	}

	private List<Attribute> toAttributeList(EList<AbstractAttribute> attributes) {
		List<Attribute> list = new ArrayList<Attribute>();

		for (AbstractAttribute abstractAttribute : attributes) {

			if (abstractAttribute instanceof Attribute) {
				list.add((Attribute) abstractAttribute);
			}
		}

		return list;
	}

	private List<SubType> toSubTypeList(TreeIterator<EObject> iter) {
		List<SubType> list = new ArrayList<SubType>();

		while (iter.hasNext()) {
			EObject obj = iter.next();
			if (obj instanceof SubType) {
				list.add((SubType) obj);
			}
		}

		return list;
	}

	private List<SubType> toSubTypeList(EList<AbstractAttribute> elist) {
		List<SubType> list = new ArrayList<SubType>();

		for (AbstractAttribute abstractAttribute : elist) {
			if (abstractAttribute instanceof SubType) {
				list.add((SubType) abstractAttribute);
			}
		}

		return list;
	}

	private List<SubTypeRef> toSubTypeRefList(EList<AbstractAttribute> elist) {
		List<SubTypeRef> list = new ArrayList<SubTypeRef>();

		for (AbstractAttribute abstractAttribute : elist) {
			if (abstractAttribute instanceof SubTypeRef) {
				list.add((SubTypeRef) abstractAttribute);
			}
		}

		return list;
	}

	private List<PEnum> toPEnumList(TreeIterator<EObject> iter) {
		List<PEnum> list = new ArrayList<PEnum>();

		while (iter.hasNext()) {
			EObject obj = iter.next();
			if (obj instanceof PEnum) {
				list.add((PEnum) obj);
			}
		}

		return list;
	}

	private void dumpMessage(Message msg) {
		if (isDebug)
			System.out.println("message: " + msg.getName());
		printAttributes(msg.getAttributes());
		printEnum(msg.getEnums());
	}

	private void printAttributes(EList<AbstractAttribute> attributes) {
		for (AbstractAttribute attribute : attributes) {
			if (attribute instanceof Attribute) {
				Attribute attr = (Attribute) attribute;
				if (isDebug)
					System.out.println("  attribute: " + attr.getName()
							+ ", type: " + attr.getAttributeType().getName()
							+ ", optional: " + attr.getOptional());
			} else if (attribute instanceof SubTypeRef) {
				SubTypeRef subTypeRef = (SubTypeRef) attribute;
				if (isDebug)
					System.out.println("  attribute: " + subTypeRef.getName()
							+ ", type: " + subTypeRef.getSubType().getName()
							+ ", optional: " + subTypeRef.getOptional());
			}
		}
	}

	private void printSubTypeAttributes(EList<AbstractAttribute> attributes) {
		for (SubType subMsg : toSubTypeList(attributes)) {

		}
		for (SubType subMsg : toSubTypeList(attributes)) {
			if (isDebug)
				System.out.println("  SubType: " + subMsg.getName());
			printSubTypeAttributes(subMsg.getAttributes());
		}
	}

	private void printEnum(List<PEnumRef> penumRefs) {
		if (isDebug)
			System.out.println("All enums: " + penumRefs.size());
		for (PEnumRef penumRef : penumRefs) {
			if (isDebug)
				System.out.println("  enum: " + penumRef.getName() + ", type: "
						+ penumRef.getPenum().getName());
		}
	}

	private void printEnum(PEnum penum) {

		if (isDebug)
			System.out.println("ENUM: " + penum.getName());
		for (PEnumElement element : penum.getElements()) {
			if (isDebug)
				System.out.println("  enum: " + element.getName());
		}
	}

	private String packagePath(Resource res) {
		String packageName = packageName(res);
		packageName = packageName.replaceAll("\\.", "/");
		return packageName;
	}

	private String packageName(Resource res) {
		String name = "";
		for (PackageDeclaration packageDeclaration : toPackageDeclarationList(res
				.getAllContents())) {
			name = packageDeclaration.getName();
		}

		String[] tokens = name.split("\\.");
		int nbrOfTokens = tokens.length;
		int count = 0;
		for (String t : tokens) {
			if (count == nbrOfTokens) {
				return name;
			} else if (count == 0) {
				name = t;
			} else {
				name = name + "." + t;
			}
			count = count + 1;
		}

		return name;
	}

	private String buildParameterAnnotations(
			List<AbstractAttribute> attributes, EList<PEnumRef> penumRefs) {
		String toString = buildParameterAnnotations(attributes);
		toString = toString.concat(buildParameterAnnotations(penumRefs));

		return toString;
	}

	private String buildParameterAnnotations(List<AbstractAttribute> attributes) {
		String toString = "";

		for (AbstractAttribute attribute : attributes) {
			if (attribute instanceof Attribute) {
				toString = toString.concat(getPad() + " "
						+ buildAttributeAnnotation((Attribute) attribute));
			} else if (attribute instanceof SubTypeRef) {
				toString = toString.concat(getPad() + " "
						+ buildSubTypeAnnotation((SubTypeRef) attribute));
			}
		}
		return toString;
	}

	private String buildParameterAnnotations(EList<PEnumRef> penumRefs) {
		String toString = "";

		for (PEnumRef penumRef : penumRefs) {
			toString = toString.concat(getPad() + " "
					+ buildEnumAnnotation(penumRef));
		}

		return toString;
	}

	private String buildAttributeAnnotation(Attribute attribute) {
		return "* @param " + attribute.getName() + " The "
				+ attribute.getName() + " message attribute." + LINE_SEPARATOR;
	}

	private String buildSubTypeAnnotation(SubTypeRef subTypeRef) {
		return "* @param " + subTypeRef.getName() + " The "
				+ subTypeRef.getName() + " message attribute." + LINE_SEPARATOR;
	}

	private String buildEnumAnnotation(PEnumRef penumRef) {
		return "* @param " + penumRef.getName() + " The "
				+ penumRef.getPenum().getName() + " message attribute."
				+ LINE_SEPARATOR;
	}

	private String buildObjectInstanceSearcher(Resource resource,
			String packMethod) {
		classSearchString = "";
		boolean isFirst = true;
		for (Message e : theMessageList) {
			classSearchString = classSearchString.concat(getPad()
					+ (isFirst ? "" : "else ") + "if (obj instanceof "
					+ e.getName() + ") {" + LINE_SEPARATOR);
			isFirst = false;

			classSearchString = classSearchString.concat(getPad()
					+ "   log4j.debug(\"Found it\");" + LINE_SEPARATOR);
			classSearchString = classSearchString.concat(getPad()
					+ "   result = ((" + e.getName() + ") obj)." + packMethod
					+ "();" + LINE_SEPARATOR);
			classSearchString = classSearchString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		}

		classSearchString = classSearchString.concat(getPad() + "else {"
				+ LINE_SEPARATOR);
		classSearchString = classSearchString
				.concat(getPad()
						+ "   setErrorMsg(\"Unknown/unsupported class: \" + obj.getClass().getSimpleName());"
						+ LINE_SEPARATOR);
		classSearchString = classSearchString.concat(getPad()
				+ "   log4j.error(getErrorMsg());" + LINE_SEPARATOR);
		classSearchString = classSearchString.concat(getPad() + "}"
				+ LINE_SEPARATOR);

		return classSearchString;
	}

	private String buildIdSearcher(Resource resource, String enumName) {
		String toString = "";
		boolean isFirst = true;

		for (Message e : theMessageList) {
			toString = toString.concat(getPad() + (isFirst ? "" : "else ")
					+ "if (" + enumName + ".getId() == " + rootClass + "Enum."
					+ handleCamelCase(e.getName()) + ".getId()) {"
					+ LINE_SEPARATOR);
			isFirst = false;

			theLevel++;
			toString = toString.concat(getPad() + "log4j.debug(\"Found it\");"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + e.getName() + " "
					+ toFirstLower(e.getName()) + " = new " + e.getName()
					+ "();" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "result = "
					+ toFirstLower(e.getName()) + ".unpack(buffer);"
					+ LINE_SEPARATOR);
			theLevel--;
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		}

		return toString;
	}

	private String buildClassSearcher(Resource resource) {
		classSearchString = "";
		boolean isFirst = true;

		for (Message e : theMessageList) {
			classSearchString = classSearchString.concat(getPad()
					+ (isFirst ? "" : "else ") + "if (className.equals(\""
					+ e.getName() + "\")) {" + LINE_SEPARATOR);
			isFirst = false;

			classSearchString = classSearchString.concat(getPad()
					+ "   log4j.debug(\"Found it\");" + LINE_SEPARATOR);
			classSearchString = classSearchString.concat(getPad() + e.getName()
					+ " " + toFirstLower(e.getName()) + " = new " + e.getName()
					+ "();" + LINE_SEPARATOR);
			classSearchString = classSearchString.concat(getPad()
					+ "   result = " + toFirstLower(e.getName())
					+ ".unpack(buffer);" + LINE_SEPARATOR);
			classSearchString = classSearchString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		}

		return classSearchString;
	}

	private String buildParameterList(int pad,
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs) {
		String parameterList = "";
		boolean isFirst = true;

		parameterList = parameterList.concat("// Entered buildParameterList()");

		for (AbstractAttribute attribute : attributes) {
			parameterList = parameterList.concat((isFirst ? "" : ",")
					+ LINE_SEPARATOR + getPad() + "        ");
			isFirst = false;

			int i = 0;
			while (i < pad) {
				parameterList = parameterList.concat(" ");
				i++;
			}

			if (attribute instanceof Attribute) {
				Attribute attr = (Attribute) attribute;

				if (attr.getListOf() != null) {
					if (attr.getAttributeType() == AttributeType.CHAR) {
						parameterList = parameterList.concat("List<Character>")
								+ attr.getName();
					} else {
						parameterList = parameterList.concat("List<"
								+ toFirstUpper(attr.getAttributeType()
										.getLiteral()))
								+ "> " + attr.getName();
					}
				} else {
					String attributeType = attr.getAttributeType().getLiteral();

					if (attributeType.equals(AttributeType.CHAR.toString())) {
						attributeType = "Character";
					} else if (attributeType.equals(AttributeType.CALENDAR
							.toString())) {
						attributeType = toFirstUpper(attr.getAttributeType()
								.getLiteral());
					}

					parameterList = parameterList
							.concat(toFirstUpper(attributeType) + " "
									+ attr.getName());
				}
			} else if (attribute instanceof SubTypeRef) {
				SubTypeRef subTypeRef = (SubTypeRef) attribute;

				if (subTypeRef.getListOf() != null) {
					parameterList = parameterList.concat("List<"
							+ subTypeRef.getSubType().getName())
							+ "> " + subTypeRef.getName();
				} else {
					parameterList = parameterList.concat(subTypeRef
							.getSubType().getName())
							+ " "
							+ subTypeRef.getName();
				}
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			parameterList = parameterList.concat((isFirst ? "" : ",")
					+ LINE_SEPARATOR + getPad() + "        ");
			isFirst = false;

			int i = 0;
			while (i < pad) {
				parameterList = parameterList.concat(" ");
				i++;
			}

			parameterList = parameterList.concat(penumRef.getPenum().getName())
					+ " " + penumRef.getName();
		}

		parameterList = parameterList
				.concat(") { // Leaving buildParameterList()");
		return parameterList;
	}

	private String buildToStringMethod(EList<AbstractAttribute> attributes,
			EList<PEnumRef> penumRefs) {
		String toString = "";

		for (AbstractAttribute attribute : attributes) {
			if (attribute instanceof Attribute) {
				Attribute attr = (Attribute) attribute;

				if (attr.getListOf() != null) {
					toString = toString.concat(LINE_SEPARATOR);
					toString = toString.concat(getPad() + "if ("
							+ attr.getName() + " != null) {" + LINE_SEPARATOR);
					theLevel++;
					toString = toString.concat(getPad() + "int i = 0;"
							+ LINE_SEPARATOR);
					toString = toString
							.concat(getPad()
									+ "for ("
									+ toFirstUpper(attr.getAttributeType() == AttributeType.CHAR ? "Character"
											: attr.getAttributeType()
													.getLiteral())
									+ " "
									+ attr.getName()
									+ toFirstUpper(attr.getAttributeType()
											.getLiteral()) + " : "
									+ attr.getName() + ") {" + LINE_SEPARATOR);
					theLevel++;
					toString = toString
							.concat(getPad()
									+ "result.append(\" "
									+ attr.getName()
									+ "[\" + i + \"]: \" + "
									+ attr.getName()
									+ toFirstUpper(attr.getAttributeType()
											.getLiteral())
									+ ".toString() + NEW_LINE);"
									+ LINE_SEPARATOR);
					toString = toString.concat(getPad() + "i++;"
							+ LINE_SEPARATOR);
					theLevel--;
					toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
					theLevel--;
					toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
				} else {
					toString = toString.concat(getPad() + "result.append(\" "
							+ attr.getName() + ": \" + " + attr.getName()
							+ " + NEW_LINE);" + LINE_SEPARATOR);
				}
			} else if (attribute instanceof SubTypeRef) {
				SubTypeRef subTypeRef = (SubTypeRef) attribute;

				if (subTypeRef.getListOf() != null) {
					toString = toString.concat(LINE_SEPARATOR);
					toString = toString.concat(getPad() + "if ("
							+ subTypeRef.getName() + " != null) {"
							+ LINE_SEPARATOR);
					theLevel++;
					toString = toString.concat(getPad() + "for ("
							+ subTypeRef.getSubType().getName() + " "
							+ subTypeRef.getName()
							+ subTypeRef.getSubType().getName() + " : "
							+ subTypeRef.getName() + ") {" + LINE_SEPARATOR);
					theLevel++;
					toString = toString.concat(getPad() + "result.append("
							+ subTypeRef.getName()
							+ subTypeRef.getSubType().getName()
							+ ".toString());" + LINE_SEPARATOR);
					theLevel--;
					toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
					theLevel--;
					toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
				} else {
					toString = toString.concat(getPad() + "result.append(\" "
							+ subTypeRef.getName() + ": \" + "
							+ subTypeRef.getName() + " + NEW_LINE);"
							+ LINE_SEPARATOR);
				}
			}
		}

		toString = toString.concat(LINE_SEPARATOR);
		for (PEnumRef penumRef : penumRefs) {
			toString = toString.concat(getPad() + "result.append(\" "
					+ penumRef.getName() + ": \" + " + penumRef.getName()
					+ " + NEW_LINE);" + LINE_SEPARATOR);
		}

		return toString;
	}

	private String buildParameterAssignments(
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs) {
		String parameterAssignments = "";
		parameterAssignments = parameterAssignments.concat(getPad()
				+ "// Entered buildParameterAssignments()" + LINE_SEPARATOR);

		for (AbstractAttribute attribute : attributes) {
			if (attribute instanceof Attribute) {
				Attribute attr = (Attribute) attribute;
				parameterAssignments = parameterAssignments.concat(getPad()
						+ "this.set" + toFirstUpper(attr.getName()) + "("
						+ attr.getName() + ");" + LINE_SEPARATOR);
			} else if (attribute instanceof SubTypeRef) {
				SubTypeRef subTypeRef = (SubTypeRef) attribute;
				parameterAssignments = parameterAssignments.concat(getPad()
						+ "this.set" + toFirstUpper(subTypeRef.getName()) + "("
						+ subTypeRef.getName() + ");" + LINE_SEPARATOR);
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			parameterAssignments = parameterAssignments.concat(getPad()
					+ "this.set" + toFirstUpper(penumRef.getName()) + "("
					+ penumRef.getName() + ");" + LINE_SEPARATOR);
		}

		parameterAssignments = parameterAssignments.concat(getPad()
				+ "// Leaving buildParameterAssignments()");
		return parameterAssignments;
	}

	private String buildCopyConstructorParameterAssignments(String className,
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs) {
		String parameterAssignments = "";
		parameterAssignments = parameterAssignments.concat(getPad()
				+ "// Entered buildCopyConstructorParameterAssignments()"
				+ LINE_SEPARATOR);

		for (AbstractAttribute attribute : attributes) {
			if (attribute instanceof Attribute) {
				Attribute attr = (Attribute) attribute;
				parameterAssignments = parameterAssignments.concat(getPad()
						+ "this.set" + toFirstUpper(attr.getName()) + "("
						+ toFirstLower(className) + ".get"
						+ toFirstUpper(attr.getName()) + "());"
						+ LINE_SEPARATOR);
			} else if (attribute instanceof SubTypeRef) {
				SubTypeRef subTypeRef = (SubTypeRef) attribute;
				if (subTypeRef.getListOf() != null) {
					parameterAssignments = parameterAssignments.concat(getPad()
							+ "for(" + subTypeRef.getSubType().getName()
							+ " tmp" + subTypeRef.getSubType().getName()
							+ " : " + toFirstLower(className) + ".get"
							+ toFirstUpper(subTypeRef.getName()) + "()) {"
							+ LINE_SEPARATOR);
					parameterAssignments = parameterAssignments
							.concat(getPad(1) + "this.get"
									+ toFirstUpper(subTypeRef.getName())
									+ "().add(new "
									+ subTypeRef.getSubType().getName()
									+ "(tmp"
									+ subTypeRef.getSubType().getName() + "));"
									+ LINE_SEPARATOR);
					parameterAssignments = parameterAssignments.concat(getPad()
							+ "}" + LINE_SEPARATOR);
				} else {
					if (subTypeRef.getOptional() != null) {
						parameterAssignments = parameterAssignments
								.concat(getPad() + "if ("
										+ toFirstLower(className) + ".get"
										+ toFirstUpper(subTypeRef.getName())
										+ "() != null) {" + LINE_SEPARATOR);
						theLevel++;
					}

					parameterAssignments = parameterAssignments.concat(getPad()
							+ toFirstUpper(subTypeRef.getSubType().getName())
							+ " " + "_"
							+ toFirstLower(subTypeRef.getSubType().getName())
							+ " = new "
							+ toFirstUpper(subTypeRef.getSubType().getName())
							+ "(" + toFirstLower(className) + ".get"
							+ toFirstUpper(subTypeRef.getName()) + "());"
							+ LINE_SEPARATOR);
					parameterAssignments = parameterAssignments.concat(getPad()
							+ "this.set" + toFirstUpper(subTypeRef.getName())
							+ "(_"
							+ toFirstLower(subTypeRef.getSubType().getName())
							+ ");" + LINE_SEPARATOR);

					if (subTypeRef.getOptional() != null) {
						theLevel--;
						parameterAssignments = parameterAssignments
								.concat(getPad() + "}" + LINE_SEPARATOR);
					}
				}
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			parameterAssignments = parameterAssignments.concat(getPad()
					+ "this.set" + toFirstUpper(penumRef.getName()) + "("
					+ toFirstLower(className) + ".get"
					+ toFirstUpper(penumRef.getName()) + "());"
					+ LINE_SEPARATOR);
		}

		parameterAssignments = parameterAssignments.concat(getPad()
				+ "// Leaving buildCopyConstructorParameterAssignments()");
		return parameterAssignments;
	}

	/*
	 * This method determines if an abstract attribute belongs in the directory.
	 */
	private boolean isDirectoryEntry(AbstractAttribute abstractAttribute) {
		final String METHOD = "isDirectoryEntry()";
		if (isDebug)
			System.out.println("Entered " + METHOD);

		boolean isDirEntry = false;

		if (abstractAttribute instanceof Attribute) {
			Attribute attribute = (Attribute) abstractAttribute;
			if (attribute.getAttributeType() == AttributeType.STRING) {
				isDirEntry = true;
			} else if (attribute.getOptional() != null) {
				isDirEntry = true;
			} else if (attribute.getListOf() != null) {
				isDirEntry = true;
			}
		} else if (abstractAttribute instanceof SubTypeRef) {
			isDirEntry = true;
		}

		return isDirEntry;
	}

	/*
	 * This method returns the offset of the directory in bytes.
	 */
	private int getDirectoryOffset(EList<AbstractAttribute> attributes,
			EList<PEnumRef> penumRefs, boolean isSubType) {
		final String METHOD = "getDirectoryOffset()";
		if (isDebug)
			System.out.println("Entered " + METHOD);

		int offsetInBits = 0;

		if (isSubType == false) {
			// The first two bytes are reserved for the message ID.
			offsetInBits = 16;
		}

		for (AbstractAttribute abstractAttribute : attributes) {
			if (abstractAttribute instanceof Attribute) {
				Attribute attribute = (Attribute) abstractAttribute;
				if (attribute.getOptional() == null
						&& attribute.getListOf() == null) {
					offsetInBits += getPrimitiveSizeInBits(attribute
							.getAttributeType().getLiteral());
				}
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			if (penumRef.getOptional() == null) {
				// offsetInBits +=
				// log8(penumRef.getPenum().getElements().size());
				offsetInBits += 32;
			}
		}

		/*
		 * Calculate the offset in bytes by dividing the offset in bits by 8 and
		 * then adding one byte if the offset in bits is not evenly divisible by
		 * 8.
		 */
		int offsetInBytes = Math.round(offsetInBits / 8)
				+ (offsetInBits % 8 == 0 ? 0 : 1);

		/*
		 * Now set the offset to a 4 byte word boundary
		 */
		// int remainder = offsetInBytes % 4;
		// int pad = (remainder == 0 ? 0 : 4 - remainder);

		// Add 4 bytes for the size of the directory
		int pad = 4;

		return offsetInBytes + pad;
	}

	private boolean hasAttribute(AbstractAttribute parent,
			EList<AbstractAttribute> attributes, AttributeType attributeType) {
		final String METHOD = "hasAttribute()";
		if (isDebug)
			System.out.println("Entered " + METHOD);

		boolean isAttribute = false;

		if (attributes.size() != 0) {
			if (parent != null && parent instanceof SubTypeRef) {
				SubTypeRef parentSubType = (SubTypeRef) parent;
				if (isDebug)
					System.out.println("parent: " + parentSubType.getName());
				if (isDebug)
					System.out.println("parent type: "
							+ parentSubType.getSubType().getName());
			}

			for (AbstractAttribute attribute : attributes) {
				if (isDebug)
					System.out
							.println("attribute name: " + attribute.getName());

				if (attribute instanceof Attribute) {
					Attribute attr = (Attribute) attribute;
					if (isDebug)
						System.out.println("attribute type: "
								+ attr.getAttributeType().getName());

					if (attr.getAttributeType().getLiteral()
							.equals(attributeType.toString())) {
						isAttribute = true;
						if (isDebug)
							System.out.println("isAttribute: " + isAttribute);
						if (isDebug)
							System.out.println("Leaving " + METHOD);
						return true;
					}
				} else if (attribute instanceof SubTypeRef) {
					SubTypeRef subTypeRef = (SubTypeRef) attribute;
					if (isDebug)
						System.out.println("this: " + subTypeRef.getName());
					if (isDebug)
						System.out.println("this subType: "
								+ subTypeRef.getSubType().getName());

					// Catch models that have recursive attributes
					boolean skipIt = false;
					if (parent != null && parent instanceof SubTypeRef) {
						SubTypeRef parentSubType = (SubTypeRef) parent;
						if (parentSubType.getSubType().getName()
								.equals(subTypeRef.getSubType().getName())) {
							skipIt = true;
						}
					}

					if (skipIt == false) {
						isAttribute = hasAttribute(subTypeRef, subTypeRef
								.getSubType().getAttributes(), attributeType);
						if (isAttribute == true) {
							if (isDebug)
								System.out.println("isAttribute: "
										+ isAttribute);
							if (isDebug)
								System.out.println("Leaving " + METHOD);
							return true;
						}
					} else {
						if (isDebug)
							System.out.println("skip it");
					}
				}
			}
		}

		if (isDebug)
			System.out.println("isAttribute: " + isAttribute);
		if (isDebug)
			System.out.println("Leaving " + METHOD);
		return isAttribute;
	}

	/*
	 * This method returns a pad String which corresponds to the specified
	 * level.
	 */
	private String getPad() {
		String pad = "";
		int i = 0;

		while (i < theLevel) {
			pad = pad.concat(INDENTATION_STRING);
			i++;
		}

		return pad;
	}

	/*
	 * This method returns a pad String which corresponds to the specified level
	 * plus an adjustment.
	 * 
	 * @param adjust The adjustment.
	 */
	private String getPad(int adjust) {
		String pad = "";
		int i = 0;

		while (i < theLevel + adjust) {
			pad = pad.concat(INDENTATION_STRING);
			i++;
		}

		return pad;
	}

	private String convertObjectToByteArray(String className,
			Boolean isAttributes) {
		objectString = getPad() + "msg = \"{\" + element.getName();"
				+ LINE_SEPARATOR;

		objectString = objectString
				.concat(getPad()
						+ "for (AbstractAttribute attr : element.getAbstractAttributes()) {"
						+ LINE_SEPARATOR);
		objectString = objectString.concat(getPad()
				+ "   msg = buildString(attr, msg);" + LINE_SEPARATOR);
		objectString = objectString.concat(getPad() + "}" + LINE_SEPARATOR);
		objectString = objectString.concat(getPad()
				+ "msg = msg.concat(\"}\");" + LINE_SEPARATOR);
		objectString = objectString.concat(LINE_SEPARATOR);
		objectString = objectString.concat(getPad()
				+ "log4j.debug(\"msg: \" + msg);" + LINE_SEPARATOR);

		return objectString;
	}

	private String convertObjectToString(String className, Boolean isAttributes) {
		objectString = getPad() + "msg = \"{\" + element.getName();"
				+ LINE_SEPARATOR;

		objectString = objectString
				.concat(getPad()
						+ "for (AbstractAttribute attr : element.getAbstractAttributes()) {"
						+ LINE_SEPARATOR);
		objectString = objectString.concat(getPad()
				+ "   msg = buildString(attr, msg);" + LINE_SEPARATOR);
		objectString = objectString.concat(getPad() + "}" + LINE_SEPARATOR);
		objectString = objectString.concat(getPad()
				+ "msg = msg.concat(\"}\");" + LINE_SEPARATOR);
		objectString = objectString.concat(LINE_SEPARATOR);
		objectString = objectString.concat(getPad()
				+ "log4j.debug(\"msg: \" + msg);" + LINE_SEPARATOR);

		return objectString;
	}

	private String buildFlags(EList<AbstractAttribute> attributes,
			EList<PEnumRef> penumRefs) {
		String toString = "";

		for (AbstractAttribute abstractAttribute : attributes) {
			if (abstractAttribute.getOptional() == null) {
				toString = toString.concat(getPad() + "private boolean is"
						+ toFirstUpper(abstractAttribute.getName())
						+ "Updated = false;" + LINE_SEPARATOR);
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			if (penumRef.getOptional() == null) {
				toString = toString.concat(getPad() + "private boolean is"
						+ toFirstUpper(penumRef.getName()) + "Updated = false;"
						+ LINE_SEPARATOR);
			}
		}

		return toString;
	}

	private String getPrimitiveSize(String primitive) {
		String primitiveSize = "";

		if (primitive.equals(AttributeType.INT.toString())) {
			primitiveSize = "4";
		} else if (primitive.equals(AttributeType.LONG.toString())) {
			primitiveSize = "8";
		} else if (primitive.equals(AttributeType.SHORT.toString())) {
			primitiveSize = "2";
		} else if (primitive.equals(AttributeType.FLOAT.toString())) {
			primitiveSize = "4";
		} else if (primitive.equals(AttributeType.DOUBLE.toString())) {
			primitiveSize = "8";
		} else if (primitive.equals(AttributeType.BOOLEAN.toString())) {
			primitiveSize = "1";
		} else if (primitive.equals(AttributeType.BYTE.toString())) {
			primitiveSize = "1";
		} else if (primitive.equals(AttributeType.CALENDAR.toString())) {
			primitiveSize = "8";
		} else if (primitive.equals(AttributeType.CHAR.toString())) {
			primitiveSize = "2";
		} else {
			if (isReallyPrimitive(primitive) == true) {
				primitiveSize = "ERROR: Unknown/unsupported primitive: "
						+ primitive;
			}
		}

		return primitiveSize;
	}

	/*
	 * Check if the primitive is really a primitive.
	 */
	private boolean isReallyPrimitive(String primitive) {
		boolean isPrimitive = false;
		for (AttributeType attr : AttributeType.values()) {
			if (primitive.equals(attr.getLiteral())) {
				isPrimitive = true;
				break;
			}
		}

		return isPrimitive;
	}

	private Integer getPrimitiveSizeInBits(String primitive) {
		Integer primitiveSize = 0;

		if (primitive.equals(AttributeType.INT.toString())) {
			primitiveSize = 4 * 8;
		} else if (primitive.equals(AttributeType.LONG.toString())) {
			primitiveSize = 8 * 8;
		} else if (primitive.equals(AttributeType.SHORT.toString())) {
			primitiveSize = 2 * 8;
		} else if (primitive.equals(AttributeType.FLOAT.toString())) {
			primitiveSize = 4 * 8;
		} else if (primitive.equals(AttributeType.DOUBLE.toString())) {
			primitiveSize = 8 * 8;
		} else if (primitive.equals(AttributeType.BOOLEAN.toString())) {
			primitiveSize = 1 * 8;
		} else if (primitive.equals(AttributeType.BYTE.toString())) {
			primitiveSize = 1 * 8;
		} else if (primitive.equals(AttributeType.CALENDAR.toString())) {
			primitiveSize = 8 * 8;
		} else if (primitive.equals(AttributeType.CHAR.toString())) {
			primitiveSize = 2 * 8;
		} else if (primitive.equals(AttributeType.STRING.toString())) {
			// Can only be determined at run time so set to 0
			primitiveSize = 0;
		} else {
			if (isReallyPrimitive(primitive) == true) {
				System.out.println("Error: Unknown/unsupported primitive: "
						+ primitive);
			}
			primitiveSize = 0;
		}

		return primitiveSize;
	}

	private String buildValidationMethod(EList<AbstractAttribute> attributes,
			EList<PEnumRef> penumRefs) {
		final String METHOD = "buildValidationMethod()";

		instantiationString = instantiationString.concat(getPad()
				+ "// Entered " + METHOD + LINE_SEPARATOR);
		boolean isFirst = true;
		for (AbstractAttribute abstractAttribute : attributes) {
			if (abstractAttribute.getOptional() == null) {
				instantiationString = instantiationString.concat(isFirst ? ""
						: LINE_SEPARATOR);

				instantiationString = instantiationString.concat(getPad()
						+ "if (!this.is"
						+ toFirstUpper(abstractAttribute.getName())
						+ "Updated) {" + LINE_SEPARATOR);
				theLevel++;
				instantiationString = instantiationString.concat(getPad()
						+ "String msg = \""
						+ toFirstUpper(abstractAttribute.getName())
						+ " is required, but no value was provided.\";"
						+ LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad()
						+ "if (result == null) {" + LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad(1)
						+ "result = msg;" + LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
				if (isFirst == false) {
					instantiationString = instantiationString.concat(getPad()
							+ "else {" + LINE_SEPARATOR);
					instantiationString = instantiationString.concat(getPad(1)
							+ "result = result.concat(\"\\n\" + msg);"
							+ LINE_SEPARATOR);
					instantiationString = instantiationString.concat(getPad()
							+ "}" + LINE_SEPARATOR);
				} else {
					isFirst = false;
				}
				theLevel--;
				instantiationString = instantiationString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			if (penumRef.getOptional() == null) {
				instantiationString = instantiationString.concat(getPad()
						+ "if (!this.is" + toFirstUpper(penumRef.getName())
						+ "Updated) {" + LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad()
						+ "   String msg = \""
						+ toFirstUpper(penumRef.getName())
						+ " is required, but no value was provided.\";"
						+ LINE_SEPARATOR);
				theLevel++;
				instantiationString = instantiationString.concat(getPad()
						+ "if (result == null) {" + LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad(1)
						+ "result = msg;" + LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad()
						+ "else {" + LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad(1)
						+ "result = result.concat(\"\\n\" + msg);"
						+ LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
				theLevel--;
				instantiationString = instantiationString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
			}
		}

		instantiationString = instantiationString.concat(getPad()
				+ "// Leaving " + METHOD + LINE_SEPARATOR);

		return instantiationString;
	}

	private void buildSubTypeRefValidationLogic(
			AbstractAttribute abstractAttribute) {
		if (abstractAttribute instanceof SubTypeRef) {
			flagString = flagString.concat(getPad() + "} else {"
					+ LINE_SEPARATOR);
			theLevel++;
			SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;
			String oldPrefix = prefix;

			prefix = prefix.concat(toFirstUpper(abstractAttribute.getName()));
			buildValidationLogic(subTypeRef, subTypeRef.getSubType()
					.getAttributes(), subTypeRef.getSubType().getEnums());
			prefix = oldPrefix;

			theLevel--;
		}
	}

	private String buildMissingAttributeExceptionString(String attribute) {
		theLevel++;
		String exceptionString = getPad()
				+ "// Missing required attribute, generate an error message and throw an exception"
				+ LINE_SEPARATOR;
		exceptionString = exceptionString.concat(getPad()
				+ "setErrorMsg(\"Error packing object. The attribute \\\""
				+ attribute
				+ "\\\" is required, but no value was provided.\");"
				+ LINE_SEPARATOR);
		exceptionString = exceptionString.concat(getPad()
				+ "log4j.error(getErrorMsg());" + LINE_SEPARATOR);
		exceptionString = exceptionString.concat(getPad()
				+ "throw new MissingAttributeException(getErrorMsg());"
				+ LINE_SEPARATOR);
		theLevel--;

		return exceptionString;
	}

	private String buildMissingAttributeExceptionString(String attribute,
			String element) {
		theLevel++;
		String exceptionString = getPad()
				+ "// Missing required attribute, generate an error message and throw an exception"
				+ LINE_SEPARATOR;
		exceptionString = exceptionString
				.concat(getPad()
						+ "setErrorMsg(String.format(\"Error packing object. "
						+ "The attribute \\\"%s\\\" of element \\\"%s\\\" is required, but no value was provided.\", \""
						+ attribute + "\", \"" + element + "\"));"
						+ LINE_SEPARATOR);
		exceptionString = exceptionString.concat(getPad()
				+ "log4j.error(getErrorMsg());" + LINE_SEPARATOR);
		exceptionString = exceptionString.concat(getPad()
				+ "throw new MissingAttributeException(getErrorMsg());"
				+ LINE_SEPARATOR);
		theLevel--;

		return exceptionString;
	}

	private String buildValidationLogic(AbstractAttribute parent,
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs) {
		if (prefix.length() == 0) {
			flagString = "";
			prefix = "";
			theLevel = 0;
		}

		boolean isFirst = true;
		for (AbstractAttribute abstractAttribute : attributes) {
			if (abstractAttribute.getOptional() == null) {
				flagString = flagString.concat(getPad()
						+ (isFirst ? "" : "else ") + "if (is" + prefix
						+ toFirstUpper(abstractAttribute.getName())
						+ "Updated == false) {" + LINE_SEPARATOR);
				isFirst = false;

				flagString = flagString.concat(getPad() + "return \"" + prefix
						+ toFirstUpper(abstractAttribute.getName())
						+ " is required, but no value was provided.\";"
						+ LINE_SEPARATOR);

				// Catch models that have recursive attributes
				boolean skipIt = false;
				if (parent != null && parent instanceof SubTypeRef
						&& abstractAttribute instanceof SubTypeRef) {
					SubTypeRef parentSubType = (SubTypeRef) parent;
					SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;

					if (parentSubType.getSubType().getName()
							.equals(subTypeRef.getSubType().getName())) {
						skipIt = true;
					}
				}

				if (skipIt == false) {
					buildSubTypeRefValidationLogic(abstractAttribute);
				}

				flagString = flagString.concat(getPad() + "}" + LINE_SEPARATOR);
			} else {
				if (abstractAttribute instanceof SubTypeRef) {
					flagString = flagString.concat(getPad() + "if (is" + prefix
							+ toFirstUpper(abstractAttribute.getName())
							+ "Updated == true) {" + LINE_SEPARATOR);
					SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;
					String oldPrefix = prefix;

					theLevel++;
					prefix = prefix.concat(toFirstUpper(abstractAttribute
							.getName()));

					// Catch models that have recursive attributes
					boolean skipIt = false;
					if (parent != null && parent instanceof SubTypeRef) {
						SubTypeRef parentSubType = (SubTypeRef) parent;
						if (parentSubType.getSubType().getName()
								.equals(subTypeRef.getSubType().getName())) {
							skipIt = true;
						}
					}

					if (skipIt == false) {
						buildValidationLogic(subTypeRef, subTypeRef
								.getSubType().getAttributes(), subTypeRef
								.getSubType().getEnums());
					}

					prefix = oldPrefix;
					theLevel--;
					flagString = flagString.concat(getPad() + "}"
							+ LINE_SEPARATOR);
				}
			}

		}

		for (PEnumRef penumRef : penumRefs) {
			if (penumRef.getOptional() == null) {
				if (isFirst == true) {
					flagString = flagString.concat(getPad() + "if (is" + prefix
							+ toFirstUpper(penumRef.getName())
							+ "Updated == false) {" + LINE_SEPARATOR);
					isFirst = false;
				} else {
					flagString = flagString.concat(getPad() + "else if (is"
							+ prefix + toFirstUpper(penumRef.getName())
							+ "Updated == false) {" + LINE_SEPARATOR);
				}

				flagString = flagString.concat(getPad(1) + "return \"" + prefix
						+ toFirstUpper(penumRef.getName())
						+ " is required, but no value was provided.\";"
						+ LINE_SEPARATOR);
				flagString = flagString.concat(getPad() + "}" + LINE_SEPARATOR);
			}
		}

		return flagString;
	}

	private String buildInstanceVariables(EList<AbstractAttribute> attributes,
			EList<PEnumRef> penumRefs) {
		String toString = "";
		for (AbstractAttribute attribute : attributes) {
			if (attribute instanceof Attribute) {
				toString = toString
						.concat(buildAttributeInstanceVariable((Attribute) attribute)
								+ LINE_SEPARATOR);
			} else if (attribute instanceof SubTypeRef) {
				toString = toString
						.concat(buildSubTypeInstanceVariable((SubTypeRef) attribute)
								+ LINE_SEPARATOR);
			}
		}
		for (PEnumRef penumRef : penumRefs) {
			toString = toString.concat(buildEnumInstanceVariable(penumRef)
					+ LINE_SEPARATOR);
		}

		return toString;
	}

	private String buildAttributeInstanceVariable(Attribute attribute) {
		String toString = "";

		if (attribute.getListOf() != null) {
			if (attribute.getAttributeType() == AttributeType.CHAR) {
				toString = "   private List<Character>" + " "
						+ attribute.getName() + ";";
			} else {
				toString = "   private List<"
						+ toFirstUpper(attribute.getAttributeType()
								.getLiteral()) + ">" + " "
						+ attribute.getName() + ";";
			}
		} else {
			String attributeType = attribute.getAttributeType().getLiteral();

			if (attribute.getAttributeType() == AttributeType.CALENDAR) {
				attributeType = toFirstUpper(attribute.getAttributeType()
						.getLiteral());
			} else if (attribute.getAttributeType() == AttributeType.INT) {
				attributeType = "int";
			} else if (attribute.getAttributeType() == AttributeType.STRING) {
				attributeType = toFirstUpper(attribute.getAttributeType()
						.getLiteral());
			}
			toString = "   private " + attributeType + " "
					+ attribute.getName() + ";";
		}

		return toString;
	}

	private String buildSubTypeInstanceVariable(SubTypeRef subTypeRef) {
		return "   private "
				+ (subTypeRef.getListOf() != null ? "List<"
						+ subTypeRef.getSubType().getName() + ">" : subTypeRef
						.getSubType().getName()) + " " + subTypeRef.getName()
				+ ";";
	}

	private String buildEnumInstanceVariable(PEnumRef penumRef) {
		return "   private " + penumRef.getPenum().getName() + " "
				+ penumRef.getName() + ";" + LINE_SEPARATOR;
	}

	private String buildPackMethod(String className,
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs,
			boolean isSubType) {
		final String METHOD = "buildPackMethod()";
		String toString = "";

		theLevel = 1;

		toString = toString.concat(getPad() + "// Entered " + METHOD
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * This method packs a "
				+ className
				+ " object into a byte array. If a required attribute is not"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * provided an exception will be thrown." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @return A byte array which represents a " + className
				+ " message object." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @throws MissingAttributeException" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public byte[] pack() throws MissingAttributeException {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \".pack()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + CLAZZ + METHOD);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "int byteArraySize = get"
				+ className + "Size();" + LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "log4j.debug(\"byteArraySize: \" + byteArraySize);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byte[] bb = new byte[byteArraySize];" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * Convert object to byte array. The offset is in bytes."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "int offset = 0;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		if (isSubType != true) {
			toString = toString.concat(getPad() + "bb = " + rootClass
					+ "Utility.insertShort(bb, offset, (short) ID);"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + "offset += 2;"
					+ LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
		}

		for (AbstractAttribute abstractAttribute : attributes) {
			if (abstractAttribute instanceof Attribute) {
				Attribute attribute = (Attribute) abstractAttribute;
				AttributeType attributeType = attribute.getAttributeType();
				String primitiveType = attributeType.getLiteral();
				String typeName = toFirstUpper(primitiveType
						.equals(AttributeType.CHAR.toString()) ? "Character"
						: attribute.getAttributeType().getLiteral());
				boolean isOptional = (attribute.getOptional() != null);

				if (isDirectoryEntry(abstractAttribute) == false) {
					if (isOptional == false) {
						toString = toString.concat(getPad() + "if (this.get"
								+ toFirstUpper(attribute.getName())
								+ "() != null) {" + LINE_SEPARATOR);
						theLevel++;
					}

					toString = toString
							.concat(getPad()
									+ "log4j.debug(String.format(\"inserting %s at offset %d\", \""
									+ attribute.getName() + "\", offset));"
									+ LINE_SEPARATOR);

					if (attributeType == AttributeType.BOOLEAN) {
						toString = toString.concat(getPad() + "bb = "
								+ rootClass + "Utility.insertBitfield"
								+ "(bb, offset * 8, 1, this.get"
								+ toFirstUpper(attribute.getName())
								+ "() == true ? 1 : 0);" + LINE_SEPARATOR);
						toString = toString.concat(getPad() + "offset += 1;"
								+ LINE_SEPARATOR);
					} else if (attributeType == AttributeType.BYTE) {
						toString = toString.concat(getPad() + "bb = "
								+ rootClass + "Utility.insertBitfield"
								+ "(bb, offset * 8, 8, this.get"
								+ toFirstUpper(attribute.getName()) + "());"
								+ LINE_SEPARATOR);
						toString = toString.concat(getPad() + "offset += 1;"
								+ LINE_SEPARATOR);
					} else {
						toString = toString.concat(getPad() + "bb = "
								+ rootClass + "Utility.insert" + typeName
								+ "(bb, offset, this.get"
								+ toFirstUpper(attribute.getName()) + "());"
								+ LINE_SEPARATOR);
						toString = toString.concat(getPad() + "offset += "
								+ getPrimitiveSize(primitiveType) + ";"
								+ LINE_SEPARATOR);
					}

					if (isOptional == false) {
						theLevel--;
						toString = toString.concat(getPad() + "} else {"
								+ LINE_SEPARATOR);
						theLevel++;
						toString = toString.concat(getPad() + "/*"
								+ LINE_SEPARATOR);
						toString = toString
								.concat(getPad()
										+ " * Missing required attribute, generate an error message and throw"
										+ LINE_SEPARATOR);
						toString = toString.concat(getPad()
								+ " * an exception." + LINE_SEPARATOR);
						toString = toString.concat(getPad() + " */"
								+ LINE_SEPARATOR);

						toString = toString
								.concat(getPad()
										+ "setErrorMsg(\"Error packing object. The attribute \\\""
										+ attribute.getName()
										+ "\\\" is required, but no value was provided.\");"
										+ LINE_SEPARATOR);
						toString = toString.concat(getPad()
								+ "log4j.error(getErrorMsg());"
								+ LINE_SEPARATOR);
						toString = toString
								.concat(getPad()
										+ "throw new MissingAttributeException(getErrorMsg());"
										+ LINE_SEPARATOR);

						theLevel--;
						toString = toString.concat(getPad() + "}"
								+ LINE_SEPARATOR);
					}
					toString = toString.concat(LINE_SEPARATOR);
				}
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			boolean isOptional = (penumRef.getOptional() != null);
			if (isOptional == false) {
				int sizeInBytes = log8(penumRef.getPenum().getElements().size());
				// TODO always an integer for now
				sizeInBytes = 4;

				toString = toString
						.concat(getPad()
								+ "log4j.debug(String.format(\"inserting %s at offset %d\", \""
								+ penumRef.getName() + "\", offset));"
								+ LINE_SEPARATOR);

				if (sizeInBytes == 1) {
					toString = toString.concat(getPad() + "bb = " + rootClass
							+ "Utility.insertByte(bb, offset, (byte) this.get"
							+ toFirstUpper(penumRef.getName()) + "().getId());"
							+ LINE_SEPARATOR);
				} else if (sizeInBytes == 2) {
					toString = toString
							.concat(getPad()
									+ "bb = "
									+ rootClass
									+ "Utility.insertShort(bb, offset, (short) this.get"
									+ toFirstUpper(penumRef.getName())
									+ "().getId());" + LINE_SEPARATOR);
				} else if (sizeInBytes > 2) {
					toString = toString.concat(getPad() + "bb = " + rootClass
							+ "Utility.insertInteger(bb, offset, this.get"
							+ toFirstUpper(penumRef.getName()) + "().getId());"
							+ LINE_SEPARATOR);
				}

				toString = toString.concat(getPad() + "offset += "
						+ sizeInBytes + ";" + LINE_SEPARATOR);
			} else {
				toString = toString.concat(getPad() + "// "
						+ penumRef.getName() + " is optional" + LINE_SEPARATOR);
			}
		}

		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(buildArrayOfDirectoryInfoItems(className,
				attributes, penumRefs));

		toString = toString.concat(LINE_SEPARATOR);

		toString = toString
				.concat(getPad() + "int directorySize = get"
						+ toFirstUpper(className) + "DirectorySize();"
						+ LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "log4j.debug(\"directorySize: \" + directorySize);"
				+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "if (directorySize != 0) {"
				+ LINE_SEPARATOR);
		theLevel++;

		// Insert the directory size
		toString = toString.concat(getPad() + "// Inserting directory size"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "log4j.debug(String.format(\"inserting directory size at offset %d\", (DIRECTORY_OFFSET - 4)));"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "bb = "
						+ grammarName
						+ "Utility.insertInteger(bb, DIRECTORY_OFFSET - 4, directorySize);"
						+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * Create the directory
		 */
		toString = toString.concat(getPad() + "// Create the directory"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "theDirectory = new " + rootClass
				+ "DirectoryEntry[directorySize];" + LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "for (int i = 0; i < directorySize; i++) {" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "theDirectory[i] = new "
				+ rootClass + "DirectoryEntry();" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * Fill the directory
		 */
		toString = toString.concat(getPad() + "// Fill the directory"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int index = 0;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "offset = DIRECTORY_OFFSET"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(2) + "+ " + rootClass
				+ "DirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(2) + "* theDirectory.length;"
				+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);

		if (attributes.size() > 0) {
			toString = toString.concat(getPad() + "for (" + grammarName
					+ "DirectoryInfoItem " + toFirstLower(grammarName)
					+ "DirectoryInfoItem : " + toFirstLower(grammarName)
					+ "DirectoryInfoItems) {" + LINE_SEPARATOR);
			theLevel++;
			toString = toString.concat(getPad() + "if ("
					+ toFirstLower(grammarName)
					+ "DirectoryInfoItem.isDirectoryEntry() == true) {"
					+ LINE_SEPARATOR);
			theLevel++;
			toString = toString.concat(getPad() + "int id = "
					+ toFirstLower(grammarName) + "DirectoryInfoItem.getId();"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + "String name = "
					+ toFirstLower(grammarName)
					+ "DirectoryInfoItem.getName();" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "int length = "
					+ toFirstLower(grammarName)
					+ "DirectoryInfoItem.getLength();" + LINE_SEPARATOR);

			toString = toString.concat(LINE_SEPARATOR);

			toString = toString.concat(getPad()
					+ "log4j.debug(\"index: \" + index);" + LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ "log4j.debug(\"   id: \" + id);" + LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ "log4j.debug(\"   name: \" + name);" + LINE_SEPARATOR);
			toString = toString
					.concat(getPad() + "log4j.debug(\"   length: \" + length);"
							+ LINE_SEPARATOR);

			toString = toString.concat(LINE_SEPARATOR);

			toString = toString.concat(getPad()
					+ "if (index >= directorySize) {" + LINE_SEPARATOR);
			toString = toString
					.concat(getPad(1)
							+ "log4j.error(\"index out of bounds!\");"
							+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

			toString = toString.concat(getPad()
					+ "theDirectory[index].setId(id);" + LINE_SEPARATOR);
			toString = toString
					.concat(getPad() + "theDirectory[index].setLength(length);"
							+ LINE_SEPARATOR);
			toString = toString
					.concat(getPad() + "theDirectory[index].setOffset(offset);"
							+ LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);

			// Continue if the length is 0
			toString = toString.concat(getPad()
					+ "if (offset > byteArraySize) {" + LINE_SEPARATOR);
			toString = toString.concat(getPad(1)
					+ "log4j.error(\"offset greater than array size!\");"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);

			// Continue if the length is 0
			toString = toString.concat(getPad() + "if (length == 0) {"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad(1) + "index++;" + LINE_SEPARATOR);
			toString = toString
					.concat(getPad(1) + "continue;" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);

			// Insert the data
			toString = toString.concat(getPad() + "// Insert the data"
					+ LINE_SEPARATOR);
			boolean isFirst = true;

			for (AbstractAttribute abstractAttribute : attributes) {
				if (abstractAttribute instanceof Attribute) {
					if (isDirectoryEntry(abstractAttribute) == true) {
						Attribute attribute = (Attribute) abstractAttribute;
						boolean isList = attribute.getListOf() != null;
						boolean isOptional = attribute.getOptional() != null;
						String attributeType = attribute.getAttributeType()
								.getLiteral();

						if (attributeType.equals(AttributeType.CALENDAR
								.toString())) {
							attributeType = toFirstUpper(attributeType);
						} else if (attributeType.equals(AttributeType.STRING
								.toString())) {
							attributeType = toFirstUpper(attributeType);
						} else if (attributeType.equals(AttributeType.INT
								.toString())) {
							attributeType = AttributeType.INT.getName()
									.toLowerCase();
						}

						String typeName = toFirstUpper(attribute
								.getAttributeType() == AttributeType.CHAR ? "Character"
								: attribute.getAttributeType().getLiteral());

						if (isFirst == true) {
							toString = toString.concat(getPad() + "if (id == ");
							isFirst = false;
						} else {
							toString = toString.concat(getPad()
									+ "else if (id == ");
						}

						toString = toString.concat(handleCamelCase(className)
								+ "_" + handleCamelCase(attribute.getName())
								+ ") {" + LINE_SEPARATOR);
						theLevel++;

						if (isOptional) {
							toString = toString.concat(getPad() + "if (get"
									+ toFirstUpper(attribute.getName())
									+ "() != null) {" + LINE_SEPARATOR);
							theLevel++;
						}

						toString = toString
								.concat(getPad()
										+ "log4j.debug(String.format(\"inserting %s at offset %d\", \""
										+ attribute.getName() + "\", offset));"
										+ LINE_SEPARATOR);

						if (isList == false) {
							if (attribute.getAttributeType() == AttributeType.STRING) {
								// Check for null string
								toString = toString.concat(getPad() + "if (get"
										+ toFirstUpper(attribute.getName())
										+ "() != null) {" + LINE_SEPARATOR);
								theLevel++;
							}
							toString = toString.concat(getPad() + "bb = "
									+ rootClass + "Utility.insert" + typeName
									+ "(bb, offset, get"
									+ toFirstUpper(attribute.getName())
									+ "());" + LINE_SEPARATOR);
							toString = toString
									.concat(getPad()
											+ "offset += "
											+ (attribute.getAttributeType() == AttributeType.STRING == true ? "length * 1"
													: getPrimitiveSize(attribute
															.getAttributeType()
															.getLiteral()))
											+ ";" + LINE_SEPARATOR);

							if (attribute.getAttributeType() == AttributeType.STRING) {
								theLevel--;
								toString = toString.concat(getPad() + "}"
										+ LINE_SEPARATOR);
							}

							theLevel--;
							toString = toString.concat(getPad() + "}"
									+ LINE_SEPARATOR);
						} else {
							/*
							 * Handle lists of strings
							 */
							if (attribute.getAttributeType() == AttributeType.STRING) {
								toString = toString.concat(getPad()
										+ "for (String s : get"
										+ toFirstUpper(attribute.getName())
										+ "()) {" + LINE_SEPARATOR);
								theLevel++;
								toString = toString.concat(getPad() + "bb = "
										+ rootClass + "Utility.insert"
										+ typeName + "(bb, offset, s);"
										+ LINE_SEPARATOR);
								toString = toString.concat(getPad()
										+ "int strLen = s.getBytes(Charset"
										+ LINE_SEPARATOR);
								toString = toString.concat(getPad(2)
										+ ".forName(\"UTF-8\")).length;"
										+ LINE_SEPARATOR);
								toString = toString.concat(LINE_SEPARATOR);
								toString = toString.concat(getPad()
										+ "theDirectory[index].setId(id);"
										+ LINE_SEPARATOR);
								toString = toString
										.concat(getPad()
												+ "theDirectory[index].setLength(strLen);"
												+ LINE_SEPARATOR);
								toString = toString
										.concat(getPad()
												+ "theDirectory[index].setOffset(offset);"
												+ LINE_SEPARATOR);
								toString = toString.concat(LINE_SEPARATOR);
								toString = toString.concat(getPad()
										+ "offset += strLen;" + LINE_SEPARATOR);
								toString = toString.concat(getPad()
										+ "index++;" + LINE_SEPARATOR);
								theLevel--;
								toString = toString.concat(getPad() + "}"
										+ LINE_SEPARATOR);
								toString = toString.concat(getPad()
										+ "index--;" + LINE_SEPARATOR);
								theLevel--;
								toString = toString.concat(getPad() + "}"
										+ LINE_SEPARATOR);
							} else {
								toString = toString.concat(getPad() + "bb = "
										+ rootClass + "Utility.insert"
										+ typeName + "s(bb, offset, get"
										+ toFirstUpper(attribute.getName())
										+ "());" + LINE_SEPARATOR);
								toString = toString
										.concat(getPad()
												+ "offset += "
												+ (attribute.getAttributeType() == AttributeType.STRING == true ? "1"
														: getPrimitiveSize(attribute
																.getAttributeType()
																.getLiteral()))
												+ ";" + LINE_SEPARATOR);
								theLevel--;
								toString = toString.concat(getPad() + "}"
										+ LINE_SEPARATOR);
							}
						}

						if (isOptional) {
							theLevel--;
							toString = toString.concat(getPad() + "}"
									+ LINE_SEPARATOR);
						}
					}
				} else if (abstractAttribute instanceof SubTypeRef) {
					SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;
					boolean isList = subTypeRef.getListOf() != null;
					boolean isOptional = subTypeRef.getOptional() != null;

					if (isFirst == true) {
						toString = toString.concat(getPad() + "if (id == ");
						isFirst = false;
					} else {
						toString = toString
								.concat(getPad() + "else if (id == ");
					}

					toString = toString.concat(handleCamelCase(className) + "_"
							+ handleCamelCase(subTypeRef.getName()) + ") {"
							+ LINE_SEPARATOR);
					theLevel++;

					if (isOptional) {
						toString = toString.concat(getPad() + "if (get"
								+ toFirstUpper(subTypeRef.getName())
								+ "() != null) {" + LINE_SEPARATOR);
						theLevel++;
					}

					toString = toString
							.concat(getPad()
									+ "log4j.debug(String.format(\"inserting %s at offset %d\", \""
									+ subTypeRef.getName() + "\", offset));"
									+ LINE_SEPARATOR);

					if (isList == false) {
						toString = toString.concat(getPad()
								+ "byte[] bytes = this.get"
								+ toFirstUpper(subTypeRef.getName())
								+ "().pack();" + LINE_SEPARATOR);

						toString = toString.concat(getPad() + "bb = "
								+ rootClass + "Utility.insertBytes"
								+ "(bb, offset, bytes);" + LINE_SEPARATOR);
						toString = toString.concat(getPad()
								+ "offset += bytes.length;" + LINE_SEPARATOR);
					} else {
						toString = toString.concat(getPad()
								+ "for ("
								+ subTypeRef.getSubType().getName()
								+ " "
								+ toFirstLower(subTypeRef.getSubType()
										.getName()
										+ " : this."
										+ subTypeRef.getName()
										+ ") {"
										+ LINE_SEPARATOR));
						theLevel++;
						toString = toString.concat(getPad()
								+ "byte[] bytes = "
								+ toFirstLower(subTypeRef.getSubType()
										.getName()) + ".pack();"
								+ LINE_SEPARATOR);

						toString = toString.concat(getPad() + "bb = "
								+ rootClass + "Utility.insertBytes"
								+ "(bb, offset, bytes);" + LINE_SEPARATOR);

						toString = toString.concat(LINE_SEPARATOR);
						toString = toString.concat(getPad()
								+ "theDirectory[index].setId(id);"
								+ LINE_SEPARATOR);
						toString = toString
								.concat(getPad()
										+ "theDirectory[index].setLength(bytes.length);"
										+ LINE_SEPARATOR);
						toString = toString.concat(getPad()
								+ "theDirectory[index].setOffset(offset);"
								+ LINE_SEPARATOR);
						toString = toString.concat(LINE_SEPARATOR);

						toString = toString.concat(getPad()
								+ "offset += bytes.length;" + LINE_SEPARATOR);
						toString = toString.concat(getPad() + "index++;"
								+ LINE_SEPARATOR);
						theLevel--;
						toString = toString.concat(getPad() + "}"
								+ LINE_SEPARATOR);
						toString = toString.concat(getPad() + "index--;"
								+ LINE_SEPARATOR);
					}

					if (isOptional) {
						theLevel--;
						toString = toString.concat(getPad() + "}"
								+ LINE_SEPARATOR);
					}

					theLevel--;
					toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
				}
			}

			for (PEnumRef penumRef : penumRefs) {
				// TODO for now, store enums as an integer
				boolean isOptional = penumRef.getOptional() != null;

				if (isFirst == true) {
					toString = toString.concat(getPad() + "if (id == ");
					isFirst = false;
				} else {
					toString = toString.concat(getPad() + "else if (id == ");
				}

				toString = toString.concat(handleCamelCase(className) + "_"
						+ handleCamelCase(penumRef.getName()) + ") {"
						+ LINE_SEPARATOR);
				theLevel++;

				if (isOptional) {
					toString = toString.concat(getPad() + "if (get"
							+ toFirstUpper(penumRef.getName())
							+ "() != null) {" + LINE_SEPARATOR);
					theLevel++;
				}

				toString = toString
						.concat(getPad()
								+ "log4j.debug(String.format(\"inserting %s at offset %d\", \""
								+ penumRef.getName() + "\", offset));"
								+ LINE_SEPARATOR);
				int sizeInBytes = log8(penumRef.getPenum().getElements().size());
				int sizeInBits = log2(penumRef.getPenum().getElements().size());
				sizeInBytes = 4;

				toString = toString.concat(getPad() + "// bb = " + rootClass
						+ "Utility.insertBitfield(bb, offset * 8, "
						+ sizeInBits + ", get"
						+ toFirstUpper(penumRef.getName()) + "().getId());"
						+ LINE_SEPARATOR);

				toString = toString.concat(getPad() + "bb = " + rootClass
						+ "Utility.insertInteger(bb, offset, get"
						+ toFirstUpper(penumRef.getName()) + "().getId());"
						+ LINE_SEPARATOR);

				toString = toString.concat(getPad() + "offset += "
						+ sizeInBytes + ";" + LINE_SEPARATOR);

				if (isOptional) {
					theLevel--;
					toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
				}
				theLevel--;
				toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			}

			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat(getPad() + "index++;" + LINE_SEPARATOR);
			theLevel--;
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			theLevel--;
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
		}

		// Insert the directory
		toString = toString.concat(getPad() + "// Insert the directory"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "log4j.debug(String.format(\"inserting the directory at offset %d\", DIRECTORY_OFFSET));"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "offset = DIRECTORY_OFFSET;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "index = 0;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (" + rootClass
				+ "DirectoryEntry directoryEntry : theDirectory) {"
				+ LINE_SEPARATOR);
		theLevel++;

		toString = toString.concat(getPad()
				+ "log4j.debug(String.format(\"index[%d]: \", index));"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "log4j.debug(String.format(\"  ID:     %d\", directoryEntry.getId()));"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "log4j.debug(String.format(\"  length: %d\", directoryEntry.getLength()));"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "log4j.debug(String.format(\"  offset: %d\", directoryEntry.getOffset()));"
						+ LINE_SEPARATOR);

		toString = toString.concat(getPad() + "bb = " + rootClass
				+ "Utility.insertInteger(bb, offset, directoryEntry.getId());"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "bb = "
						+ rootClass
						+ "Utility.insertInteger(bb, offset + 4, directoryEntry.getLength());"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "bb = "
						+ rootClass
						+ "Utility.insertInteger(bb, offset + 8, directoryEntry.getOffset());"
						+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "offset += " + rootClass
				+ "DirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "index++;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// Calculate and insert the checksum
		if (isSubType == false) {
			toString = toString.concat(getPad()
					+ "// Calculate and insert the checksum" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "long checksum = "
					+ rootClass + "Utility.getChecksum(bb, bb.length - 8);"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + "bb = " + rootClass
					+ "Utility.insertLong(bb, bb.length - 8, checksum);"
					+ LINE_SEPARATOR);
		}

		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + CLAZZ + METHOD);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return bb;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		
		toString = toString.concat(getPad() + "// Leaving " + METHOD
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		return toString;
	}

	private String buildUnpackMethod(String className,
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs,
			boolean isSubType) {
		final String METHOD = "buildUnpackMethod()";
		String toString = "";

		theLevel = 1;

		toString = toString.concat(getPad() + "// Entered " + METHOD
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * This method unpacks a byte array containing a "
				+ className + " object." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array as a "
				+ className + " message object." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public " + className
				+ " unpack(byte[] ba) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \".unpack()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + CLAZZ + METHOD);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + className + " "
				+ toFirstLower(className) + " = new " + className + "();"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		for (AbstractAttribute abstractAttribute : attributes) {
			if (abstractAttribute instanceof Attribute) {
				if (isDirectoryEntry(abstractAttribute) == false) {
					Attribute attribute = (Attribute) abstractAttribute;
					String typeName = toFirstUpper(attribute.getAttributeType() == AttributeType.CHAR ? "Character"
							: attribute.getAttributeType().getLiteral());
					toString = toString.concat(getPad()
							+ toFirstLower(className) + ".set"
							+ toFirstUpper(attribute.getName()) + "("
							+ rootClass + "Utility.get" + typeName + "(ba, ");
					toString = toString.concat(toFirstLower(grammarName)
							+ "DirectoryInfoItems["
							+ handleCamelCase(className) + "_"
							+ handleCamelCase(attribute.getName())
							+ "].getOffsetInBits()));" + LINE_SEPARATOR);
				}
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			// TODO for now, enums are stored as integers
			if (penumRef.getOptional() == null) {
				int sizeInBits = log2(penumRef.getPenum().getElements().size());
				int sizeInBytes = log8(penumRef.getPenum().getElements().size());
				sizeInBytes = 4;

				if (sizeInBytes == 1) {
					toString = toString.concat(getPad()
							+ toFirstLower(className) + ".set"
							+ toFirstUpper(penumRef.getName()) + "("
							+ penumRef.getPenum().getName() + ".toEnum("
							+ rootClass + "Utility.getByte(ba, ");
				} else if (sizeInBytes == 2) {
					toString = toString.concat(getPad()
							+ toFirstLower(className) + ".set"
							+ toFirstUpper(penumRef.getName()) + "("
							+ penumRef.getPenum().getName() + ".toEnum("
							+ rootClass + "Utility.getShort(ba, ");
				} else if (sizeInBytes > 2) {
					toString = toString.concat(getPad()
							+ toFirstLower(className) + ".set"
							+ toFirstUpper(penumRef.getName()) + "("
							+ penumRef.getPenum().getName() + ".toEnum("
							+ rootClass + "Utility.getInteger(ba, ");
				}

				toString = toString.concat(toFirstLower(grammarName)
						+ "DirectoryInfoItems[" + handleCamelCase(className)
						+ "_" + handleCamelCase(penumRef.getName())
						+ "].getOffsetInBits())));" + LINE_SEPARATOR);
			}
		}

		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "// Get the directory size"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int directorySize = get"
						+ toFirstUpper(className) + "DirectorySize();"
						+ LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "log4j.debug(\"directorySize: \" + directorySize);"
				+ LINE_SEPARATOR);
		
		toString = toString.concat(getPad() + "if (directorySize != 0) {"
				+ LINE_SEPARATOR);
		theLevel++;
		
		toString = toString
				.concat(getPad()
						+ "log4j.debug(\"DIRECTORY_OFFSET - 4: \" + (DIRECTORY_OFFSET - 4));"
						+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);

		// Get the directory
		toString = toString
				.concat(getPad()
						+ "// Get the directory from the byte array and build a directory."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "theDirectory = new " + rootClass
				+ "DirectoryEntry[directorySize];" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "int dirOffset = DIRECTORY_OFFSET;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "// Get each item in the directory. The offset is in bytes."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "for (int entry = 0 ; entry < directorySize; entry++) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + rootClass
				+ "DirectoryEntry directoryEntry = new " + rootClass
				+ "DirectoryEntry();" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "int id = " + rootClass
				+ "Utility.getInteger(ba, dirOffset * 8);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "directoryEntry.setId(id);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "int length = " + rootClass
				+ "Utility.getInteger(ba, (dirOffset + 4) * 8);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "directoryEntry.setLength(length);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "int offset = " + rootClass
				+ "Utility.getInteger(ba, (dirOffset + 8) * 8);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "directoryEntry.setOffset(offset);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "theDirectory[entry] = directoryEntry;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "dirOffset += " + rootClass
				+ "DirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString
				.concat(getPad()
						+ "// Use the directory to extract each item from the byte array."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (" + rootClass
				+ "DirectoryEntry directoryEntry : theDirectory) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "int id = directoryEntry.getId();" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "int offset = directoryEntry.getOffset();" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "int length = directoryEntry.getLength();" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "log4j.debug(\"id: \" + id);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"   offset: \" + offset);" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"   length: \" + length);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "if (length == 0) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "continue;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		boolean isFirst = true;
		for (AbstractAttribute abstractAttribute : attributes) {
			if (abstractAttribute instanceof Attribute) {
				if (isDirectoryEntry(abstractAttribute) == true) {
					Attribute attribute = (Attribute) abstractAttribute;
					String attributeType = attribute.getAttributeType()
							.getLiteral();
					if (attributeType.equals(AttributeType.CALENDAR.toString())) {
						attributeType = toFirstUpper(attributeType);
					} else if (attributeType.equals(AttributeType.STRING
							.toString())) {
						attributeType = toFirstUpper(attributeType);
					} else if (attributeType.equals(AttributeType.INT
							.toString())) {
						attributeType = AttributeType.INT.getName()
								.toLowerCase();
					}

					String typeName = toFirstUpper(attribute.getAttributeType() == AttributeType.CHAR ? "Character"
							: attribute.getAttributeType().getLiteral());
					String getter = rootClass + "Utility.get" + typeName;
					int sizeInBits = getPrimitiveSizeInBits(attribute
							.getAttributeType().getLiteral());

					if (isFirst == true) {
						toString = toString.concat(getPad() + "if (id == ");
						isFirst = false;
					} else {
						toString = toString
								.concat(getPad() + "else if (id == ");
					}

					toString = toString.concat(handleCamelCase(className) + "_"
							+ handleCamelCase(attribute.getName()) + ") {"
							+ LINE_SEPARATOR);
					if (attribute.getListOf() == null) {
						toString = toString.concat(getPad(1)
								+ toFirstLower(className) + ".set"
								+ toFirstUpper(attribute.getName()) + "("
								+ getter + "(ba, offset");

						/*
						 * The String object is a special case.
						 */
						if (attribute.getAttributeType() == AttributeType.STRING) {
							toString = toString.concat(", length));"
									+ LINE_SEPARATOR);
						} else {
							toString = toString.concat("* 8));"
									+ LINE_SEPARATOR);
						}
						toString = toString.concat(getPad(0) + "}"
								+ LINE_SEPARATOR);
					} else {
						if (attribute.getAttributeType() == AttributeType.STRING) {
							toString = toString.concat(getPad(1)
									+ attributeType
									+ " "
									+ attributeType.toLowerCase().substring(0,
											1) + " = " + getter
									+ "(ba, offset, length);" + LINE_SEPARATOR);
							toString = toString.concat(getPad(1)
									+ toFirstLower(className) + ".get"
									+ toFirstUpper(attribute.getName())
									+ "().add("
									+ typeName.toLowerCase().substring(0, 1)
									+ ");" + LINE_SEPARATOR);
						} else {
							toString = toString
									.concat(getPad(1)
											+ "for (int index = 0; index < length; index++) {"
											+ LINE_SEPARATOR);
							toString = toString.concat(getPad(2)
									+ attributeType
									+ " "
									+ attributeType.toLowerCase().substring(0,
											1) + " = " + getter
									+ "(ba, offset * 8 + index * " + sizeInBits
									+ ");" + LINE_SEPARATOR);

							toString = toString.concat(getPad(2)
									+ toFirstLower(className) + ".get"
									+ toFirstUpper(attribute.getName())
									+ "().add("
									+ typeName.toLowerCase().substring(0, 1)
									+ ");" + LINE_SEPARATOR);

							toString = toString.concat(getPad(1) + "}"
									+ LINE_SEPARATOR);
						}
						toString = toString.concat(getPad() + "}"
								+ LINE_SEPARATOR);
					}
				}
			}
		}

		for (AbstractAttribute abstractAttribute : attributes) {
			if (abstractAttribute instanceof SubTypeRef) {
				SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;
				boolean isList = (subTypeRef.getListOf() != null);

				if (isFirst == true) {
					toString = toString.concat(getPad() + "if (id == ");
					isFirst = false;
				} else {
					toString = toString.concat(getPad() + "else if (id == ");
				}

				toString = toString.concat(handleCamelCase(className) + "_"
						+ handleCamelCase(subTypeRef.getName()) + ") {"
						+ LINE_SEPARATOR);
				theLevel++;

				if (isList == false) {
					toString = toString.concat(getPad()
							+ "byte[] bytes = new byte[length];"
							+ LINE_SEPARATOR);
					toString = toString.concat(LINE_SEPARATOR);
					toString = toString.concat(getPad()
							+ "for (int index = 0; index < length; index++) {"
							+ LINE_SEPARATOR);
					theLevel++;
					toString = toString.concat(getPad() + "bytes[index] = "
							+ rootClass
							+ "Utility.getByte(ba, (offset + index) * 8);"
							+ LINE_SEPARATOR);
					theLevel--;
					toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
					toString = toString.concat(LINE_SEPARATOR);
					toString = toString.concat(getPad()
							+ toFirstLower(className) + ".set"
							+ toFirstUpper(subTypeRef.getName()) + "(new "
							+ toFirstUpper(subTypeRef.getSubType().getName())
							+ "().unpack(bytes));" + LINE_SEPARATOR);
				} else {
					toString = toString.concat(getPad()
							+ "byte[] bytes = new byte[length];"
							+ LINE_SEPARATOR);
					toString = toString.concat(getPad()
							+ "for (int index = 0; index < length; index++) {"
							+ LINE_SEPARATOR);
					theLevel++;
					toString = toString.concat(getPad() + "bytes[index] = "
							+ rootClass
							+ "Utility.getByte(ba, (offset + index) * 8);"
							+ LINE_SEPARATOR);
					theLevel--;
					toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
					toString = toString.concat(getPad()
							+ toFirstLower(className) + ".get"
							+ toFirstUpper(subTypeRef.getName())
							+ "().add(new "
							+ toFirstUpper(subTypeRef.getSubType().getName())
							+ "().unpack(bytes));" + LINE_SEPARATOR);
				}
				theLevel--;
				toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			if (penumRef.getOptional() != null) {
				if (isFirst == true) {
					toString = toString.concat(getPad() + "if (id == ");
					isFirst = false;
				} else {
					toString = toString.concat(getPad() + "else if (id == ");
				}

				toString = toString.concat(handleCamelCase(className) + "_"
						+ handleCamelCase(penumRef.getName()) + ") {"
						+ LINE_SEPARATOR);
				theLevel++;

				// TODO for now, enums are stored as integers
				toString = toString.concat(getPad() + "int _id = "
						+ grammarName + "Utility.getInteger(ba,  offset * 8);"
						+ LINE_SEPARATOR);
				toString = toString.concat(getPad() + toFirstLower(className)
						+ ".set" + toFirstUpper(penumRef.getName()) + "("
						+ penumRef.getPenum().getName() + ".toEnum(_id));"
						+ LINE_SEPARATOR);

				theLevel--;
				toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			}
		}

		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + CLAZZ + METHOD);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return "
				+ toFirstLower(className) + ";" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "// Leaving " + METHOD
				+ LINE_SEPARATOR);

		return toString;
	}

	private String buildPackMethod(String className, int nbrOfAttributes,
			int nbrOfPEnumRefs) {
		final String METHOD = "buildPackMethod()";
		String toString = "";

		toString = toString.concat(getPad() + "// Entered " + METHOD
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * This method packs a "
				+ className
				+ " object into a byte array. If a required attribute is not"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * provided an exception will be thrown." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @return A byte array which represents a " + className
				+ " message object." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @throws MissingAttributeException" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public byte[] pack() throws MissingAttributeException {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"pack()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "byte[] byteArray = null;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "setErrorMsg(null);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " " + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * Initialize attribute values."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "Initialize" + className
				+ " initialize" + className + " = new Initialize" + className
				+ "(this);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "Element element = initialize"
				+ className + ".initialize();" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (getErrorMsg() == null) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * Convert object to byte array." + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * See convertObjectToByteArray() in JByteByByteGenerator.java."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(convertObjectToByteArray(className,
				nbrOfAttributes != 0 || nbrOfPEnumRefs != 0));
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return msg;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(getPad() + "// Leaving " + METHOD
				+ LINE_SEPARATOR);

		return toString;
	}

	private String buildPackStrMethod(String className, int nbrOfAttributes,
			int nbrOfPEnumRefs) {
		final String METHOD = "buildPackStrMethod()";
		String toString = "";

		toString = toString.concat(getPad() + "// Entered " + METHOD
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * This method packs a "
				+ className
				+ " object into a String. If a required attribute is not"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * provided an exception will be thrown." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @return A String which represents a " + className
				+ " message object." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @throws MissingAttributeException" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public String packStr() throws MissingAttributeException {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"packStr()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "String msg = null;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "setErrorMsg(null);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " " + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * Initialize attribute values."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "Initialize" + className
				+ " initialize" + className + " = new Initialize" + className
				+ "(this);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "Element element = initialize"
				+ className + ".initialize();" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (getErrorMsg() == null) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * Convert object to String."
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * See convertObjectToString() in JByteByByteGenerator.java."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(convertObjectToString(className,
				nbrOfAttributes != 0 || nbrOfPEnumRefs != 0));
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return msg;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(getPad() + "// Leaving " + METHOD
				+ LINE_SEPARATOR);

		return toString;
	}

	private String buildUnpackStrMethod(String className, int nbrOfAttributes,
			int nbrOfPEnumRefs) {
		final String METHOD = "buildUnpackStrMethod()";
		String toString = "";

		toString = toString.concat(getPad() + "// Entered " + METHOD
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * The unpack() method unpacks a String into an object. The String must conform to the"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * SMBG grammar."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "  * @return The message string as an object."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public " + className
				+ " unpack(String buffer) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"unpack()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "setErrorMsg(null);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "// Create the lexer"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "log4j.debug(\"lexing...\");"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "SMBGLexer lexer = new SMBGLexer(new ANTLRStringStream(buffer));"
						+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "int nbrOfSyntaxErrors = lexer.getNumberOfSyntaxErrors();"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"# of lexer errors: \" + nbrOfSyntaxErrors);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "// Check for errors"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (nbrOfSyntaxErrors != 0) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "for (String error : lexer.getErrors()) {" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "log4j.error(error);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return null;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "// Wrap a token-stream around the lexer" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "CommonTokenStream tokenStream = new CommonTokenStream(lexer);"
						+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "// Create the parser"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "log4j.debug(\"parsing...\");"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "SMBGParser parser = new SMBGParser(tokenStream);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "// Check for errors"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "nbrOfSyntaxErrors = parser.getNumberOfSyntaxErrors();"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"# of parse errors: \" + nbrOfSyntaxErrors);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (nbrOfSyntaxErrors != 0) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "for (String error : parser.getErrors()) {" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "   log4j.error(error);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return null;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "// Unpack the string into objects" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "log4j.debug(\"unpacking...\");"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "try {" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "parser.unpack();"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "} catch (RecognitionException e) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString
				.concat(getPad() + "log4j.error(\"Error: \" + e.getMessage());"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "setErrorMsg(e.getMessage());"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return null;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "Element element = parser.getElement();" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "element.dump();"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * Instantiate the " + className
				+ " object." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " Instantiate" + className
				+ " instantiate" + className + " = new Instantiate" + className
				+ "(element);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " " + className + " "
				+ toFirstLower(className) + " = instantiate" + className
				+ ".instantiate();" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		if (nbrOfAttributes != 0 || nbrOfPEnumRefs != 0) {
			toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
			toString = toString
					.concat(getPad()
							+ " * Verify that a value was provided for all mandatory attributes."
							+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "String result = instantiate"
					+ className + ".validate();" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "if (result != null) {"
					+ LINE_SEPARATOR);
			theLevel++;
			toString = toString.concat(getPad()
					+ "log4j.error(\"Error: \" + result);" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "setErrorMsg(result);"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + "return null;"
					+ LINE_SEPARATOR);
			theLevel--;
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		}
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return "
				+ toFirstLower(className) + ";" + LINE_SEPARATOR);

		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(getPad() + "// Leaving " + METHOD
				+ LINE_SEPARATOR);

		return toString;
	}

	private String buildGetErrorMsgMethod() {
		final String METHOD = "buildGetErrorMsgMethod()";
		String toString = "";

		toString = toString.concat(getPad() + "// Entered " + METHOD
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns the error message or null if no error"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * occurred." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public String getErrorMsg() {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return theErrorMsg;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(getPad() + "// Leaving " + METHOD
				+ LINE_SEPARATOR);

		return toString;

	}

	private String buildSetErrorMsgMethod() {
		final String METHOD = "buildSetErrorMsgMethod()";
		String toString = "";

		toString = toString.concat(getPad() + "// Entered " + METHOD
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "private void setErrorMsg(String errorMsg) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "theErrorMsg = errorMsg;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(getPad() + "// Leaving " + METHOD
				+ LINE_SEPARATOR);

		return toString;
	}

	private void instantiateAbstractAttribute(String className,
			String elementName, String attributeName,
			AbstractAttribute abstractAttribute, EList<PEnumRef> penumRefs,
			EList<AbstractAttribute> attributes, String elementAttributeName,
			String subElementName) {

		if (abstractAttribute.getListOf() != null) {
			if (abstractAttribute instanceof Attribute) {
				Attribute attr = (Attribute) abstractAttribute;
				instantiationString = instantiationString.concat(getPad()
						+ "for ("
						+ toFirstUpper(attr.getAttributeType().getName())
						+ attr.getAttributeType().getName() + " : "
						+ attr.getName() + ".getAbstractAttributes()) {"
						+ LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
			} else if (abstractAttribute instanceof SubTypeRef) {
				instantiationString = instantiationString.concat(getPad()
						+ "ERROR!" + LINE_SEPARATOR);
			}
		} else if (abstractAttribute instanceof Attribute) {
			String abstractAttributeName = "abstractAttribute";

			if (attributeName != null) {
				abstractAttributeName = attributeName + "AbstractAttribute";
			}

			instantiationString = instantiationString.concat(getPad()
					+ "for (KeyValuePair kvp : " + abstractAttributeName
					+ ".getKeyValuePairs()) {" + LINE_SEPARATOR);
			theLevel++;
			instantiationString = instantiationString.concat(getPad()
					+ "log4j.debug(\"searching for key: \" + kvp.getKey());"
					+ LINE_SEPARATOR);

			boolean isFirst = true;
			for (PEnumRef penumRef : penumRefs) {
				instantiatePEnumRef(className, penumRef, isFirst);
				isFirst = false;
			}

			isFirst = true;
			for (AbstractAttribute aa : attributes) {
				if (aa.getListOf() == null) {
					instantiateKeyValuePair(className, aa, isFirst);
					isFirst = false;
				}
			}

			instantiationString = instantiationString.concat(getPad()
					+ "else {" + LINE_SEPARATOR);
			theLevel++;
			instantiationString = instantiationString
					.concat(getPad()
							+ "log4j.error(\"Unknown/unsupported key/value pair! Key: \" + kvp.getKey());"
							+ LINE_SEPARATOR);
			theLevel--;
			instantiationString = instantiationString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
			theLevel--;
			instantiationString = instantiationString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		} else if (abstractAttribute instanceof SubTypeRef) {
			SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;
			instantiationString = instantiationString.concat(getPad()
					+ "   for (Element " + subElementName + " : "
					+ subTypeRef.getName() + ".getElements()) {"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "      log4j.debug(\"searching for element: \" + "
					+ subElementName + ".getName());" + LINE_SEPARATOR);

			theLevel++;

			boolean isFirst = true;
			for (AbstractAttribute aa : attributes) {
				if (abstractAttribute instanceof SubTypeRef) {
					instantiateAttribute(className, subElementName,
							aa.getName(), aa, abstractAttribute, isFirst);
					isFirst = false;
				}
			}

			theLevel--;
			instantiationString = instantiationString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		} else {
			instantiationString = instantiationString
					.concat("ERROR: unknown/unsupported attribute type:"
							+ abstractAttribute.eClass().getName());
		}
	}

	private String initializeDirectoryInfoItems(boolean isSubType,
			List<AbstractAttribute> attributes, List<PEnumRef> penumRefs) {
		final String METHOD = "initializeDirectoryInfoItems()";

		String toString = getPad() + "// Initialize directory info items"
				+ LINE_SEPARATOR;
		toString = toString.concat(getPad() + "// Entered " + METHOD
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private " + grammarName
				+ "DirectoryInfoItem[] " + toFirstLower(grammarName)
				+ "DirectoryInfoItems = new " + grammarName
				+ "DirectoryInfoItem[] {" + LINE_SEPARATOR);

		theLevel++;
		int id = 0;

		int offsetInBits = 0;
		if (isSubType == false) {
			// Reserve 2 bytes for the message ID.
			offsetInBits = 16;
		}

		for (AbstractAttribute abstractAttribute : attributes) {
			Attribute attribute = null;
			SubTypeRef subTypeRef = null;
			String name = null;
			String attributeType = null;
			int sizeInBits = 0;
			boolean isDirectoryEntry = isDirectoryEntry(abstractAttribute);

			if (abstractAttribute instanceof Attribute) {
				attribute = (Attribute) abstractAttribute;
				name = attribute.getName();
				attributeType = attribute.getAttributeType().getLiteral();
			} else if (abstractAttribute instanceof SubTypeRef) {
				subTypeRef = (SubTypeRef) abstractAttribute;
				name = subTypeRef.getName();
				attributeType = subTypeRef.getSubType().getName();
			}
			sizeInBits = getPrimitiveSizeInBits(attributeType);

			if (id != 0) {
				toString = toString.concat("," + LINE_SEPARATOR
						+ LINE_SEPARATOR);
			}

			if (isDirectoryEntry == false) {
				toString = toString.concat(getPad() + "// sizeInBits: "
						+ sizeInBits + LINE_SEPARATOR);
			} else {
				toString = toString
						.concat(getPad()
								+ "// This is a directory item. It's offset and length cannot be determined"
								+ LINE_SEPARATOR);
				toString = toString.concat(getPad() + "// until runtime."
						+ LINE_SEPARATOR);
			}
			toString = toString.concat(getPad() + "new " + grammarName
					+ "DirectoryInfoItem(" + id + ", \"" + name + "\", "
					+ (isDirectoryEntry == false ? offsetInBits : -1) + ", 0, "
					+ isDirectoryEntry + ")");

			if (isDirectoryEntry == false) {
				offsetInBits += sizeInBits;
			}

			id++;
		}

		for (PEnumRef penumRef : penumRefs) {
			String name = penumRef.getName();
			int sizeInBits = log2(penumRef.getPenum().getElements().size());
			int sizeInBytes = log8(penumRef.getPenum().getElements().size());
			sizeInBytes = 4;
			boolean isOptional = (penumRef.getOptional() != null);

			if (id != 0) {
				toString = toString.concat("," + LINE_SEPARATOR
						+ LINE_SEPARATOR);
			}

			if (isOptional == false) {
				toString = toString.concat(getPad() + "// sizeInBits: "
						+ sizeInBits + LINE_SEPARATOR);
				toString = toString.concat(getPad() + "// sizeInBytes: "
						+ sizeInBytes + LINE_SEPARATOR);
			} else {
				toString = toString
						.concat(getPad()
								+ "// This is a directory item. It's offset and length cannot be determined"
								+ LINE_SEPARATOR);
				toString = toString.concat(getPad() + "// until runtime."
						+ LINE_SEPARATOR);
			}

			toString = toString.concat(getPad() + "new " + grammarName
					+ "DirectoryInfoItem(" + id + ", \"" + name + "\", "
					+ (isOptional == false ? offsetInBits : -1) + ", 0, ");

			if (isOptional == false) {
				offsetInBits += sizeInBytes * 8;
				toString = toString.concat("false)");
			} else {
				toString = toString.concat("true)");
			}

			id++;
		}
		theLevel--;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "};" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "// Leaving " + METHOD
				+ LINE_SEPARATOR);

		return toString;
	}

	private void instantiateAbstractAttributes(String className,
			String elementName, String attributeName, AbstractAttribute parent,
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs,
			String elementAttributeName, String subElementName) {
		final String METHOD = "instantiateAbstractAttributes()";
		instantiationString = instantiationString.concat(getPad()
				+ "// Entered " + METHOD + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// className:            " + className + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// attributeName:        " + attributeName + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// elementAttributeName: " + elementAttributeName
				+ LINE_SEPARATOR);
		instantiationString = instantiationString
				.concat(getPad() + "// subElementName:       " + subElementName
						+ LINE_SEPARATOR);

		String abstractAttributeName = "abstractAttribute";
		boolean isHandledKvp = false;

		if (attributeName != null) {
			abstractAttributeName = attributeName + "AbstractAttribute";
		}
		for (AbstractAttribute abstractAttribute : attributes) {
			instantiationString = instantiationString.concat(getPad() + "// "
					+ abstractAttribute.getName() + LINE_SEPARATOR);
		}

		instantiationString = instantiationString.concat(getPad()
				+ "for (AbstractAttribute " + abstractAttributeName + " : "
				+ elementAttributeName + ".getAbstractAttributes()) {"
				+ LINE_SEPARATOR);

		boolean isFirst = true;
		for (AbstractAttribute abstractAttribute : attributes) {

			instantiationString = instantiationString.concat(getPad()
					+ "// ok1" + LINE_SEPARATOR);
			if (abstractAttribute.getListOf() != null) {
				if (abstractAttribute instanceof Attribute) {
					instantiationString = instantiationString.concat(getPad()
							+ "// ok2" + LINE_SEPARATOR);
					Attribute attr = (Attribute) abstractAttribute;
					instantiationString = instantiationString
							.concat(getPad(1)
									+ "// "
									+ abstractAttribute.getName()
									+ " is a list of "
									+ toFirstUpper(attr.getAttributeType()
											.getLiteral()) + LINE_SEPARATOR);
					instantiationString = instantiationString.concat(getPad()
							+ "// ok3" + LINE_SEPARATOR);
				} else if (abstractAttribute instanceof SubTypeRef) {
					instantiationString = instantiationString.concat(getPad()
							+ "// ok4" + LINE_SEPARATOR);
					SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;
					theLevel++;
					instantiationString = instantiationString.concat(getPad()
							+ "// " + subTypeRef.getName() + " is a list of "
							+ subTypeRef.getSubType().getName()
							+ LINE_SEPARATOR);

					instantiationString = instantiationString.concat(getPad()
							+ "for (Element " + subElementName + " : "
							+ abstractAttributeName + ".getElements()) {"
							+ LINE_SEPARATOR);
					instantiationString = instantiationString.concat(getPad()
							+ "   log4j.debug(\"searching for element: \" + "
							+ subElementName + ".getName());" + LINE_SEPARATOR);
					theLevel++;
					instantiateAttribute(className, subElementName,
							abstractAttributeName, parent, abstractAttribute,
							isFirst);
					isFirst = false;
					theLevel--;
					instantiationString = instantiationString.concat(getPad()
							+ "}" + LINE_SEPARATOR);
					theLevel--;
				} else {
					instantiationString = instantiationString
							.concat("ERROR: unknown/unsupported attribute type:"
									+ abstractAttribute.eClass().getName());
				}
			} else {
				instantiationString = instantiationString.concat(getPad()
						+ "// ok5" + LINE_SEPARATOR);
				if (abstractAttribute instanceof Attribute) {
					if (isHandledKvp == false) {

						instantiationString = instantiationString
								.concat(getPad() + "// ok6" + LINE_SEPARATOR);
						Attribute attr = (Attribute) abstractAttribute;
						theLevel++;
						instantiateAbstractAttribute(className, elementName,
								attributeName, attr, penumRefs, attributes,
								elementAttributeName, subElementName);
						theLevel--;
						isHandledKvp = true;
					}
				} else if (abstractAttribute instanceof SubTypeRef) {

					instantiationString = instantiationString.concat(getPad()
							+ "// ok7" + LINE_SEPARATOR);
					SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;
					theLevel++;
					instantiationString = instantiationString.concat(getPad()
							+ "// " + subTypeRef.getName()
							+ " is a subType of type "
							+ subTypeRef.getSubType().getName()
							+ LINE_SEPARATOR);
					;
					instantiationString = instantiationString.concat(getPad()
							+ "for (Element " + subElementName + " : "
							+ abstractAttributeName + ".getElements()) {"
							+ LINE_SEPARATOR);
					instantiationString = instantiationString.concat(getPad()
							+ "   log4j.debug(\"searching for element: \" + "
							+ subElementName + ".getName());" + LINE_SEPARATOR);
					isFirst = true;
					theLevel++;

					instantiateAttribute(className, subElementName,
							abstractAttributeName, parent, abstractAttribute,
							isFirst);
					theLevel--;
					instantiationString = instantiationString.concat(getPad()
							+ "}" + LINE_SEPARATOR);
					theLevel--;
				} else {
					instantiationString = instantiationString
							.concat("ERROR: unknown/unsupported attribute type:"
									+ abstractAttribute.eClass().getName());
				}

				instantiationString = instantiationString.concat(getPad()
						+ "// ok8" + LINE_SEPARATOR);
			}
			instantiationString = instantiationString.concat(getPad()
					+ "// ok9" + LINE_SEPARATOR);
		}

		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// Leaving " + METHOD + LINE_SEPARATOR);

	}

	private String instantiateMsgAttributeList(String className,
			Attribute attribute, boolean isFirst) {
		final String METHOD = "instantiateMsgAttributeList()";
		instantiationString = instantiationString.concat(getPad()
				+ "// Entered " + METHOD + LINE_SEPARATOR);

		String typeName = toFirstUpper(attribute.getAttributeType() == AttributeType.CHAR ? "Character"
				: attribute.getAttributeType().getLiteral());

		String attrNameFirstUpper = toFirstUpper(attribute.getName());
		instantiationString = instantiationString.concat(getPad()
				+ (isFirst == true ? "" : "else ")
				+ "if (kvp.getKey().startsWith(\"" + attribute.getName()
				+ "[\")) {" + LINE_SEPARATOR);

		theLevel++;
		if (attribute.getOptional() == null) {
			instantiationString = instantiationString.concat(getPad()
					+ "this.is" + attrNameFirstUpper + "Updated = true;"
					+ LINE_SEPARATOR);
		}

		instantiationString = instantiationString.concat(getPad() + "if("
				+ className + ".get" + attrNameFirstUpper + "() == null) {"
				+ LINE_SEPARATOR);
		theLevel++;
		instantiationString = instantiationString.concat(getPad() + className
				+ ".set" + attrNameFirstUpper + "(new ArrayList<" + typeName
				+ ">());" + LINE_SEPARATOR);
		theLevel--;
		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);

		if (attribute.getAttributeType() == AttributeType.STRING) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".get" + attrNameFirstUpper
					+ "().add(kvp.getValue());" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.INT) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".get" + attrNameFirstUpper
					+ "().add(Integer.parseInt(kvp.getValue()));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.CHAR) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".get" + attrNameFirstUpper
					+ "().add(kvp.getValue().toCharArray()[0]);"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.LONG) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".get" + attrNameFirstUpper
					+ "().add(Long.parseLong(kvp.getValue()));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.SHORT) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".get" + attrNameFirstUpper
					+ "().add(Short.parseShort(kvp.getValue()));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.FLOAT) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".get" + attrNameFirstUpper
					+ "().add(Float.parseFloat(kvp.getValue()));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.DOUBLE) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".get" + attrNameFirstUpper
					+ "().add(Double.parseDouble(kvp.getValue()));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.BOOLEAN) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".get" + attrNameFirstUpper
					+ "().add(kvp.getValue().equals(\"true\"));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.BYTE) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".get" + attrNameFirstUpper
					+ "().add(Byte.parseByte(kvp.getValue()));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.CALENDAR) {
			instantiationString = instantiationString.concat(getPad()
					+ "Date date;" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad() + "try {"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "   SimpleDateFormat formatter = new SimpleDateFormat(\""
					+ theDateTimeFormat + "\");" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "   date = formatter.parse(kvp.getValue());"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "   Calendar cal = Calendar.getInstance();"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "   cal.setTime(date);" + LINE_SEPARATOR);
			;
			instantiationString = instantiationString.concat(getPad()
					+ className + ".get" + attrNameFirstUpper + "().add(cal);"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "} catch (ParseException ex) {" + LINE_SEPARATOR);
			instantiationString = instantiationString
					.concat(getPad()
							+ "   log4j.error(\"Invalid date format: \" + kvp.getValue());"
							+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		} else {
			instantiationString = instantiationString.concat("ERROR: "
					+ className + ".get" + attrNameFirstUpper + ".add()"
					+ " is not supported" + LINE_SEPARATOR);
		}

		theLevel--;
		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// Leaving " + METHOD + LINE_SEPARATOR);

		return instantiationString;
	}

	private String instantiateSubTypeElements(SubType subType) {
		final String METHOD = "instantiateSubTypeElements()";

		boolean isSubTypeRef = false;

		instantiationString = "";
		instantiationString = instantiationString.concat(getPad()
				+ "// Entered " + METHOD + LINE_SEPARATOR);

		for (AbstractAttribute abstractAttribute : subType.getAttributes()) {
			if (abstractAttribute instanceof SubTypeRef) {
				isSubTypeRef = true;
			}
		}

		if (isSubTypeRef == true) {
			boolean isFirst = true;
			instantiationString = instantiationString.concat(getPad()
					+ "for (Element e : abstractAttribute.getElements()) {"
					+ LINE_SEPARATOR);
			theLevel++;

			for (AbstractAttribute abstractAttribute : subType.getAttributes()) {
				if (abstractAttribute instanceof SubTypeRef) {
					SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;
					if (subTypeRef.getListOf() == null) {
						boolean isRecursive = instantiateSubTypeRef(
								subType.getName(), subTypeRef, isFirst);

						if (isRecursive == false) {
							isFirst = false;
						}
					} else {
						instantiateSubTypeRefList(subType.getName(),
								subTypeRef, isFirst);
						isFirst = false;
					}
				}
			}

			theLevel--;
			instantiationString = instantiationString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		}

		instantiationString = instantiationString.concat(getPad()
				+ "// Leaving " + METHOD + LINE_SEPARATOR);
		return instantiationString;
	}

	private boolean instantiateSubTypeRef(String name, SubTypeRef subTypeRef,
			boolean isFirst) {

		boolean isRecursive = false;

		if (subTypeRef.getSubType().getName().equals(name)) {
			instantiationString = instantiationString.concat(getPad()
					+ "// Recursive attribute detected..." + LINE_SEPARATOR);
			isRecursive = true;
		} else {
			instantiationString = instantiationString.concat(getPad()
					+ (isFirst ? "" : "else ") + "if (e.getName().equals(\""
					+ subTypeRef.getName() + "\")) {" + LINE_SEPARATOR);

			theLevel++;
			if (subTypeRef.getOptional() == null) {
				instantiationString = instantiationString.concat(getPad()
						+ "this.is" + toFirstUpper(subTypeRef.getName())
						+ "Updated = true;" + LINE_SEPARATOR);
			}

			instantiationString = instantiationString.concat(getPad()
					+ "log4j.debug(\"found element: " + subTypeRef.getName()
					+ "\");" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "Instantiate" + subTypeRef.getSubType().getName()
					+ " instantiate" + subTypeRef.getSubType().getName() + " ="
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "         new Instantiate"
					+ subTypeRef.getSubType().getName() + "(e);"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ subTypeRef.getSubType().getName() + " "
					+ toFirstLower(subTypeRef.getSubType().getName()) + " ="
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "         instantiate"
					+ subTypeRef.getSubType().getName() + ".instantiate();"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(name) + ".set"
					+ toFirstUpper(subTypeRef.getName()) + "("
					+ toFirstLower(subTypeRef.getSubType().getName()) + ");"
					+ LINE_SEPARATOR);
			theLevel--;
			instantiationString = instantiationString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		}

		return isRecursive;
	}

	private void instantiateSubTypeRefList(String name, SubTypeRef subTypeRef,
			boolean isFirst) {
		instantiationString = instantiationString.concat(getPad()
				+ (isFirst ? "" : "else ") + "if (e.getName().startsWith(\""
				+ subTypeRef.getName() + "[\")) {" + LINE_SEPARATOR);

		theLevel++;
		if (subTypeRef.getOptional() == null) {
			instantiationString = instantiationString.concat(getPad()
					+ "this.is" + toFirstUpper(subTypeRef.getName())
					+ "Updated = true;" + LINE_SEPARATOR);
		}

		instantiationString = instantiationString.concat(getPad()
				+ "log4j.debug(\"found element: " + subTypeRef.getName()
				+ "\");" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad() + "if ("
				+ toFirstLower(name) + ".get"
				+ toFirstUpper(subTypeRef.getName()) + "() == null) {"
				+ LINE_SEPARATOR);
		theLevel++;
		instantiationString = instantiationString.concat(getPad() + "List<"
				+ subTypeRef.getSubType().getName() + "> "
				+ subTypeRef.getName() + " = new ArrayList<"
				+ subTypeRef.getSubType().getName() + ">();" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ toFirstLower(name) + ".set"
				+ toFirstUpper(subTypeRef.getName()) + "("
				+ subTypeRef.getName() + ");" + LINE_SEPARATOR);
		theLevel--;
		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);

		instantiationString = instantiationString.concat(LINE_SEPARATOR);

		if (subTypeRef.getSubType().getName().equals(name)) {
			instantiationString = instantiationString.concat(getPad()
					+ "// Recursive list detected..." + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "Instantiate" + subTypeRef.getSubType().getName()
					+ " instantiate" + subTypeRef.getSubType().getName()
					+ " = new Instantiate" + subTypeRef.getSubType().getName()
					+ "(e);" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ subTypeRef.getSubType().getName() + " a"
					+ subTypeRef.getSubType().getName() + " = instantiate"
					+ subTypeRef.getSubType().getName() + ".instantiate();"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString
					.concat(getPad()
							+ toFirstLower(subTypeRef.getSubType().getName())
							+ ".get" + toFirstUpper(subTypeRef.getName())
							+ "().add(a" + subTypeRef.getSubType().getName()
							+ ");" + LINE_SEPARATOR);
		} else {
			instantiationString = instantiationString.concat(getPad()
					+ "Instantiate" + subTypeRef.getSubType().getName()
					+ " instantiate" + subTypeRef.getSubType().getName() + " ="
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "         new Instantiate"
					+ subTypeRef.getSubType().getName() + "(e);"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ subTypeRef.getSubType().getName() + " "
					+ toFirstLower(subTypeRef.getSubType().getName()) + " ="
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "         instantiate"
					+ subTypeRef.getSubType().getName() + ".instantiate();"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(name) + ".get"
					+ toFirstUpper(subTypeRef.getName()) + "().add("
					+ toFirstLower(subTypeRef.getSubType().getName()) + ");"
					+ LINE_SEPARATOR);
		}

		theLevel--;
		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);
	}

	private String instantiateSubTypeAttributes(SubType subType) {
		final String METHOD = "instantiateSubTypeAttributes()";

		instantiationString = getPad() + "// Entered " + METHOD
				+ LINE_SEPARATOR;
		boolean isFirst = true;
		for (AbstractAttribute abstractAttribute : subType.getAttributes()) {
			if (abstractAttribute instanceof Attribute) {
				Attribute attribute = (Attribute) abstractAttribute;
				if (attribute.getListOf() == null) {
					instantiateSubTypeAttribute(subType.getName(), attribute,
							isFirst);
					isFirst = false;
				} else {
					instantiateSubTypeAttributeList(subType.getName(),
							attribute, isFirst);
					isFirst = false;
				}
			}
		}

		isFirst = true;
		for (PEnumRef penumRef : subType.getEnums()) {
			instantiatePEnumRef(subType.getName(), penumRef, isFirst);
			isFirst = false;
		}

		instantiationString = instantiationString.concat(getPad()
				+ "// Leaving " + METHOD + LINE_SEPARATOR);
		return instantiationString;
	}

	private void instantiateSubTypeAttribute(String className, Attribute attr,
			boolean isFirst) {
		instantiationString = instantiationString.concat(getPad()
				+ (isFirst == true ? "" : "else ")
				+ "if (kvp.getKey().equals(\"" + attr.getName() + "\")) {"
				+ LINE_SEPARATOR);
		theLevel++;

		if (attr.getOptional() == null) {
			instantiationString = instantiationString.concat(getPad() + " "
					+ "this.is" + toFirstUpper(attr.getName())
					+ "Updated = true;" + LINE_SEPARATOR);
		}
		instantiationString = instantiationString.concat(getPad()
				+ "log4j.debug(\"setting value of \\\"" + attr.getName()
				+ "\\\" to: \" + kvp.getValue());" + LINE_SEPARATOR);

		if (attr.getAttributeType() == AttributeType.STRING) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(className) + ".set"
					+ toFirstUpper(attr.getName()) + "(kvp.getValue());"
					+ LINE_SEPARATOR);
		} else if (attr.getAttributeType() == AttributeType.CHAR) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(className) + ".set"
					+ toFirstUpper(attr.getName())
					+ "(kvp.getValue().charAt(0));" + LINE_SEPARATOR);
		} else if (attr.getAttributeType() == AttributeType.INT) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(className) + ".set"
					+ toFirstUpper(attr.getName())
					+ "(Integer.parseInt(kvp.getValue()));" + LINE_SEPARATOR);
		} else if (attr.getAttributeType() == AttributeType.LONG) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(className) + ".set"
					+ toFirstUpper(attr.getName())
					+ "(Long.parseLong(kvp.getValue()));" + LINE_SEPARATOR);
		} else if (attr.getAttributeType() == AttributeType.SHORT) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(className) + ".set"
					+ toFirstUpper(attr.getName())
					+ "(Short.parseShort(kvp.getValue()));" + LINE_SEPARATOR);
		} else if (attr.getAttributeType() == AttributeType.FLOAT) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(className) + ".set"
					+ toFirstUpper(attr.getName())
					+ "(Float.parseFloat(kvp.getValue()));" + LINE_SEPARATOR);
		} else if (attr.getAttributeType() == AttributeType.DOUBLE) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(className) + ".set"
					+ toFirstUpper(attr.getName())
					+ "(Double.parseDouble(kvp.getValue()));" + LINE_SEPARATOR);
		} else if (attr.getAttributeType() == AttributeType.BOOLEAN) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(className) + ".set"
					+ toFirstUpper(attr.getName())
					+ "(kvp.getValue().equals(\"true\"));" + LINE_SEPARATOR);
		} else if (attr.getAttributeType() == AttributeType.BYTE) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(className) + ".set"
					+ toFirstUpper(attr.getName())
					+ "(Byte.parseByte(kvp.getValue()));" + LINE_SEPARATOR);
		} else if (attr.getAttributeType() == AttributeType.CALENDAR) {
			instantiationString = instantiationString.concat(getPad()
					+ "Date date;" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad() + "try {"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString
					.concat(getPad()
							+ "           SimpleDateFormat formatter = new SimpleDateFormat(\""
							+ theDateTimeFormat + "\");" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "   date = formatter.parse(kvp.getValue());"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "   Calendar cal = Calendar.getInstance();"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "   cal.setTime(date);" + LINE_SEPARATOR);
			;
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(className) + ".set"
					+ toFirstUpper(attr.getName()) + "(cal);" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "} catch (ParseException ex) {" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()

			+ "   log4j.error(\"Invalid date format: \" + kvp.getValue());"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		} else {
			instantiationString = instantiationString.concat("ERROR: "
					+ toFirstLower(className) + ".set"
					+ toFirstUpper(attr.getName()) + "()" + " is not supported"
					+ LINE_SEPARATOR);
		}

		theLevel--;
		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);
	}

	private String instantiateSubTypeAttributeList(String name,
			Attribute attribute, boolean isFirst) {
		String typeName = toFirstUpper(attribute.getAttributeType()
				.getLiteral());
		if (typeName.equals("Char")) {
			typeName = "Character";
		}

		String attrNameFirstUpper = toFirstUpper(attribute.getName());
		instantiationString = instantiationString.concat(getPad()
				+ (isFirst == true ? "" : "else ")
				+ "if (kvp.getKey().startsWith(\"" + attribute.getName()
				+ "[\")) {" + LINE_SEPARATOR);

		theLevel++;
		if (attribute.getOptional() == null) {
			instantiationString = instantiationString.concat(getPad()
					+ "this.is" + attrNameFirstUpper + "Updated = true;"
					+ LINE_SEPARATOR);
		}
		instantiationString = instantiationString.concat(getPad() + "if("
				+ toFirstLower(name) + ".get" + attrNameFirstUpper
				+ "() == null) {" + LINE_SEPARATOR);
		theLevel++;
		instantiationString = instantiationString.concat(getPad()
				+ toFirstLower(name) + ".set" + attrNameFirstUpper
				+ "(new ArrayList<" + typeName + ">());" + LINE_SEPARATOR);
		theLevel--;
		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);

		if (attribute.getAttributeType() == AttributeType.STRING) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(name) + ".get" + attrNameFirstUpper
					+ "().add(kvp.getValue());" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.INT) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(name) + ".get" + attrNameFirstUpper
					+ "().add(Integer.parseInt(kvp.getValue()));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.LONG) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(name) + ".get" + attrNameFirstUpper
					+ "().add(Long.parseLong(kvp.getValue()));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.SHORT) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(name) + ".get" + attrNameFirstUpper
					+ "().add(Short.parseShort(kvp.getValue()));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.FLOAT) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(name) + ".get" + attrNameFirstUpper
					+ "().add(Float.parseFloat(kvp.getValue()));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.DOUBLE) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(name) + ".get" + attrNameFirstUpper
					+ "().add(Double.parseDouble(kvp.getValue()));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.BOOLEAN) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(name) + ".get" + attrNameFirstUpper
					+ "().add(kvp.getValue().equals(\"true\"));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.BYTE) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(name) + ".get" + attrNameFirstUpper
					+ "().add(Byte.parseByte(kvp.getValue()));"
					+ LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.CALENDAR) {
			instantiationString = instantiationString.concat(getPad()
					+ "Date date;" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad() + "try {"
					+ LINE_SEPARATOR);
			theLevel++;
			instantiationString = instantiationString.concat(getPad()
					+ "SimpleDateFormat formatter = new SimpleDateFormat(\""
					+ theDateTimeFormat + "\");" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "date = formatter.parse(kvp.getValue());"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString
					.concat(getPad() + "Calendar cal = Calendar.getInstance();"
							+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "cal.setTime(date);" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(name) + ".get" + attrNameFirstUpper
					+ ".add(cal);" + LINE_SEPARATOR);
			theLevel--;
			instantiationString = instantiationString.concat(getPad()
					+ "} catch (ParseException ex) {" + LINE_SEPARATOR);
			theLevel++;
			instantiationString = instantiationString
					.concat(getPad()
							+ "log4j.error(\"Invalid date format: \" + kvp.getValue());"
							+ LINE_SEPARATOR);
			theLevel--;
			instantiationString = instantiationString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		} else {
			instantiationString = instantiationString.concat("ERROR: "
					+ toFirstLower(name) + ".get" + attrNameFirstUpper
					+ "().add()" + " is not supported" + LINE_SEPARATOR);
		}

		theLevel--;
		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);

		return instantiationString;
	}

	private String instantiateMsgAttribute(String className,
			Attribute attribute, boolean isFirst) {
		final String METHOD = "instantiateMsgAttribute()";
		instantiationString = instantiationString.concat(getPad()
				+ "// Entered " + METHOD + LINE_SEPARATOR);

		instantiationString = instantiationString.concat(getPad()
				+ (isFirst == true ? "" : "else ")
				+ "if (kvp.getKey().equals(\"" + attribute.getName() + "\")) {"
				+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "   log4j.debug(\"setting value of \\\""
				+ attribute.getName() + "\\\" to: \" + kvp.getValue());"
				+ LINE_SEPARATOR);
		theLevel++;

		String attrNameFirstUpper = toFirstUpper(attribute.getName());
		if (attribute.getOptional() == null) {
			instantiationString = instantiationString.concat(getPad()
					+ "this.is" + attrNameFirstUpper + "Updated = true;"
					+ LINE_SEPARATOR);
		}
		if (attribute.getAttributeType() == AttributeType.STRING) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".set" + attrNameFirstUpper
					+ "(kvp.getValue());" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.CHAR) {
			instantiationString = instantiationString.concat(getPad()
					+ toFirstLower(className) + ".set"
					+ toFirstUpper(attribute.getName())
					+ "(kvp.getValue().charAt(0));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.INT) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".set" + attrNameFirstUpper
					+ "(Integer.parseInt(kvp.getValue()));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.LONG) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".set" + attrNameFirstUpper
					+ "(Long.parseLong(kvp.getValue()));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.SHORT) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".set" + attrNameFirstUpper
					+ "(Short.parseShort(kvp.getValue()));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.FLOAT) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".set" + attrNameFirstUpper
					+ "(Float.parseFloat(kvp.getValue()));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.DOUBLE) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".set" + attrNameFirstUpper
					+ "(Double.parseDouble(kvp.getValue()));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.BOOLEAN) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".set" + attrNameFirstUpper
					+ "(kvp.getValue().equals(\"true\"));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.BYTE) {
			instantiationString = instantiationString.concat(getPad()
					+ className + ".set" + attrNameFirstUpper
					+ "(Byte.parseByte(kvp.getValue()));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.CALENDAR) {
			instantiationString = instantiationString.concat(getPad()
					+ "Date date;" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad() + "try {"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "   SimpleDateFormat formatter = new SimpleDateFormat(\""
					+ theDateTimeFormat + "\");" + LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "   date = formatter.parse(kvp.getValue());"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "   Calendar cal = Calendar.getInstance();"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "   cal.setTime(date);" + LINE_SEPARATOR);
			;
			instantiationString = instantiationString.concat(getPad()
					+ className + ".set" + attrNameFirstUpper + "(cal);"
					+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad()
					+ "} catch (ParseException ex) {" + LINE_SEPARATOR);
			instantiationString = instantiationString
					.concat(getPad()
							+ "   log4j.error(\"Invalid date format: \" + kvp.getValue());"
							+ LINE_SEPARATOR);
			instantiationString = instantiationString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		} else {
			instantiationString = instantiationString.concat("ERROR: "
					+ className + "." + attrNameFirstUpper
					+ " is unknown/not supported." + LINE_SEPARATOR);
		}

		theLevel--;
		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// Leaving " + METHOD + LINE_SEPARATOR);

		return instantiationString;
	}

	private String instantiateMessageSubTypeRefList(Message msg,
			SubTypeRef subTypeRef) {
		final String METHOD = "instantiateMessageSubTypeRefList()";

		instantiationString = instantiationString.concat(getPad()
				+ "// Entered " + METHOD + LINE_SEPARATOR);

		instantiationString = instantiationString.concat(getPad()
				+ "if (element.getName().startsWith(\"" + subTypeRef.getName()
				+ "[\")) {" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "   log4j.debug(\"found element: " + subTypeRef.getName()
				+ "\");" + LINE_SEPARATOR);
		if (subTypeRef.getOptional() == null) {
			instantiationString = instantiationString.concat(getPad()
					+ "   this.is" + toFirstUpper(subTypeRef.getName())
					+ "Updated = true;" + LINE_SEPARATOR);
		}
		instantiationString = instantiationString.concat(getPad()
				+ "   instantiate" + toFirstUpper(subTypeRef.getName())
				+ "(element);" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "   return;" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// Leaving " + METHOD + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(LINE_SEPARATOR);

		return instantiationString;
	}

	private String instantiateSubTypeRefList(Message msg, SubTypeRef subTypeRef) {
		final String METHOD = "instantiateSubTypeRefList()";
		String subTypeName = subTypeRef.getSubType().getName();

		instantiationString = instantiationString.concat(getPad()
				+ "// Entered " + METHOD + LINE_SEPARATOR);
		instantiationString = instantiationString
				.concat(getPad() + "final String METHOD = \"instantiate"
						+ toFirstUpper(subTypeRef.getName()) + "()\";"
						+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad() + "if ("
				+ toFirstLower(msg.getName()) + ".get"
				+ toFirstUpper(subTypeRef.getName()) + "() == null) {"
				+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ toFirstLower(msg.getName()) + ".set"
				+ toFirstUpper(subTypeRef.getName()) + "(new ArrayList<"
				+ subTypeName + ">());" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(LINE_SEPARATOR);

		instantiationString = instantiationString.concat(getPad()
				+ "Instantiate" + subTypeName + " instantiate" + subTypeName
				+ " = new Instantiate" + subTypeName + "(element);"
				+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad() + subTypeName
				+ " " + toFirstLower(subTypeName) + " = instantiate"
				+ subTypeName + ".instantiate();" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ toFirstLower(msg.getName()) + ".get"
				+ toFirstUpper(subTypeRef.getName()) + "().add("
				+ toFirstLower(subTypeName) + ");" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// Leaving " + METHOD + LINE_SEPARATOR);

		return instantiationString;
	}

	private String instantiateMessageSubTypeRef(Message msg,
			SubTypeRef subTypeRef) {
		final String METHOD = "instantiateMessageSubTypeRef()";

		instantiationString = instantiationString.concat(getPad()
				+ "// Entered " + METHOD + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "if (element.getName().equals(\"" + subTypeRef.getName()
				+ "\")) {" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "   log4j.debug(\"found element: " + subTypeRef.getName()
				+ "\");" + LINE_SEPARATOR);
		if (subTypeRef.getOptional() == null) {
			instantiationString = instantiationString.concat(getPad()
					+ "   this.is" + toFirstUpper(subTypeRef.getName())
					+ "Updated = true;" + LINE_SEPARATOR);
		}
		instantiationString = instantiationString.concat(getPad()
				+ "   instantiate" + toFirstUpper(subTypeRef.getName())
				+ "(element);" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "   return;" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// Leaving " + METHOD + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(LINE_SEPARATOR);
		return instantiationString;
	}

	private String instantiateSubTypeRef(Message msg, SubType subType,
			SubTypeRef subTypeRef) {
		final String METHOD = "instantiateSubTypeRef()";

		String subTypeName = subTypeRef.getSubType().getName();

		instantiationString = instantiationString.concat(getPad()
				+ "// Entered " + METHOD + LINE_SEPARATOR);
		instantiationString = instantiationString
				.concat(getPad() + "final String METHOD = \"instantiate"
						+ toFirstUpper(subTypeRef.getName()) + "()\";"
						+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "Instantiate" + subTypeName + " instantiate" + subTypeName
				+ " = new Instantiate" + subTypeName + "(element);"
				+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ toFirstLower(msg.getName()) + ".set"
				+ toFirstUpper(subTypeRef.getName()) + "(instantiate"
				+ subTypeName + ".instantiate());" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// Leaving " + METHOD + LINE_SEPARATOR);

		return instantiationString;
	}

	private void instantiateKeyValuePair(String className,
			AbstractAttribute abstractAttribute, boolean isFirst) {
		if (abstractAttribute instanceof Attribute) {
			Attribute attr = (Attribute) abstractAttribute;
			instantiationString = instantiationString.concat(getPad()
					+ (isFirst ? "" : "else ")
					+ "else if (kvp.getKey().equals(\"" + attr.getName()
					+ "\")) {" + LINE_SEPARATOR);

			theLevel++;

			instantiationString = instantiationString.concat(getPad()
					+ "log4j.debug(\"setting value of \\\"" + attr.getName()
					+ "\\\" to: \" + kvp.getValue());" + LINE_SEPARATOR);

			if (attr.getListOf() != null) {
				// instantiationString = instantiationString.concat(getPad() +
				// "      for () {" + LINE_SEPARATOR);
				// instantiationString = instantiationString.concat(getPad() +
				// "      }" + LINE_SEPARATOR);
			}

			if (attr.getAttributeType() == AttributeType.STRING) {
				instantiationString = instantiationString.concat(getPad()
						+ toFirstLower(className) + ".set"
						+ toFirstUpper(attr.getName()) + "(kvp.getValue());"
						+ LINE_SEPARATOR);
			} else if (attr.getAttributeType() == AttributeType.INT) {
				instantiationString = instantiationString.concat(getPad()
						+ toFirstLower(className) + ".set"
						+ toFirstUpper(attr.getName())
						+ "(Integer.parseInt(kvp.getValue()));"
						+ LINE_SEPARATOR);
			} else if (attr.getAttributeType() == AttributeType.LONG) {
				instantiationString = instantiationString.concat(getPad()
						+ toFirstLower(className) + ".set"
						+ toFirstUpper(attr.getName())
						+ "(Long.parseLong(kvp.getValue()));" + LINE_SEPARATOR);
			} else if (attr.getAttributeType() == AttributeType.SHORT) {
				instantiationString = instantiationString.concat(getPad()
						+ toFirstLower(className) + ".set"
						+ toFirstUpper(attr.getName())
						+ "(Short.parseShort(kvp.getValue()));"
						+ LINE_SEPARATOR);
			} else if (attr.getAttributeType() == AttributeType.FLOAT) {
				instantiationString = instantiationString.concat(getPad()
						+ toFirstLower(className) + ".set"
						+ toFirstUpper(attr.getName())
						+ "(Float.parseFloat(kvp.getValue()));"
						+ LINE_SEPARATOR);
			} else if (attr.getAttributeType() == AttributeType.DOUBLE) {
				instantiationString = instantiationString.concat(getPad()
						+ toFirstLower(className) + ".set"
						+ toFirstUpper(attr.getName())
						+ "(Double.parseDouble(kvp.getValue()));"
						+ LINE_SEPARATOR);
			} else if (attr.getAttributeType() == AttributeType.BOOLEAN) {
				instantiationString = instantiationString
						.concat(getPad() + toFirstLower(className) + ".set"
								+ toFirstUpper(attr.getName())
								+ "(kvp.getValue().equals(\"true\"));"
								+ LINE_SEPARATOR);
			} else if (attr.getAttributeType() == AttributeType.BYTE) {
				instantiationString = instantiationString.concat(getPad()
						+ toFirstLower(className) + ".set"
						+ toFirstUpper(attr.getName())
						+ "(Byte.parseByte(kvp.getValue()));" + LINE_SEPARATOR);
			} else if (attr.getAttributeType() == AttributeType.CALENDAR) {
				instantiationString = instantiationString.concat(getPad()
						+ "Date date;" + LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad()
						+ "try {" + LINE_SEPARATOR);
				theLevel++;
				instantiationString = instantiationString.concat(getPad()

				+ "SimpleDateFormat formatter = new SimpleDateFormat(\""
						+ theDateTimeFormat + "\");" + LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad()
						+ "date = formatter.parse(kvp.getValue());"
						+ LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad()
						+ "Calendar cal = Calendar.getInstance();"
						+ LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad()
						+ "cal.setTime(date);" + LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad()
						+ toFirstLower(className) + ".set"
						+ toFirstUpper(attr.getName()) + "(cal);"
						+ LINE_SEPARATOR);
				theLevel--;
				instantiationString = instantiationString.concat(getPad()
						+ "} catch (ParseException ex) {" + LINE_SEPARATOR);
				theLevel++;
				instantiationString = instantiationString
						.concat(getPad()
								+ "log4j.error(\"Invalid date format: \" + kvp.getValue());"
								+ LINE_SEPARATOR);
				theLevel--;
				instantiationString = instantiationString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
			} else {
				instantiationString = instantiationString.concat("ERROR: "
						+ toFirstLower(className) + ".set"
						+ toFirstUpper(attr.getName()) + "()"
						+ " is not supported" + LINE_SEPARATOR);
			}

			if (abstractAttribute.getOptional() == null) {
				instantiationString = instantiationString.concat(getPad()
						+ "      " + "this.is" + prefix
						+ toFirstUpper(attr.getName()) + "Updated = true;"
						+ LINE_SEPARATOR);
			}

			theLevel--;
			instantiationString = instantiationString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		}
	}

	private void instantiateAttribute(String className, String elementName,
			String attributeName, AbstractAttribute parent,
			AbstractAttribute abstractAttribute, boolean isFirst) {
		final String METHOD = "instantiateAttribute()";
		instantiationString = instantiationString.concat(getPad()
				+ "// Entered " + METHOD + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// className:         " + className + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// elementName:       " + elementName + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// abstractAttribute: " + abstractAttribute.getName()
				+ LINE_SEPARATOR);

		if (abstractAttribute instanceof SubTypeRef) {
			SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;

			if (subTypeRef.getListOf() != null) {
				instantiationString = instantiationString.concat(getPad()
						+ (isFirst == true ? "" : "else ") + "if ("
						+ elementName + ".getName().startsWith(\""
						+ subTypeRef.getName() + "[\")) {" + LINE_SEPARATOR);
			} else {
				instantiationString = instantiationString.concat(getPad()
						+ (isFirst == true ? "" : "else ") + "if ("
						+ elementName + ".getName().equals(\""
						+ subTypeRef.getName() + "\")) {" + LINE_SEPARATOR);
			}

			if (subTypeRef.getListOf() != null) {
				instantiationString = instantiationString.concat(getPad()
						+ "   " + "List<" + subTypeRef.getSubType().getName()
						+ "> " + subTypeRef.getName() + " = new "
						+ "ArrayList<" + subTypeRef.getSubType().getName()
						+ ">();" + LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad()
						+ "   " + toFirstLower(className) + ".set"
						+ toFirstUpper(subTypeRef.getName()) + "("
						+ subTypeRef.getName() + ");" + LINE_SEPARATOR);
			} else {
				instantiationString = instantiationString.concat(getPad()
						+ "   " + subTypeRef.getSubType().getName() + " "
						+ toFirstLower(subTypeRef.getSubType().getName())
						+ " = new " + subTypeRef.getSubType().getName() + "();"
						+ LINE_SEPARATOR);
				instantiationString = instantiationString.concat(getPad()
						+ "   " + toFirstLower(className) + ".set"
						+ toFirstUpper(subTypeRef.getName()) + "("
						+ toFirstLower(subTypeRef.getSubType().getName())
						+ ");" + LINE_SEPARATOR);
			}

			instantiationString = instantiationString.concat(LINE_SEPARATOR);
			if (subTypeRef.getOptional() == null) {
				instantiationString = instantiationString.concat(getPad()
						+ "   this.is" + prefix
						+ toFirstUpper(subTypeRef.getName())
						+ "Updated = true;" + LINE_SEPARATOR);
			}

			if (subTypeRef.getListOf() != null) {
				instantiationString = instantiationString
						.concat(getPad()
								+ "   for ("
								+ subTypeRef.getSubType().getName()
								+ " "
								+ toFirstLower(subTypeRef.getSubType()
										.getName()) + " : "
								+ subTypeRef.getName() + ") {" + LINE_SEPARATOR);
				theLevel++;
			}

			theLevel++;
			String oldPrefix = prefix;
			prefix = prefix.concat(toFirstUpper(subTypeRef.getName()));

			// Catch models that have recursive attributes
			boolean skipIt = false;
			if (parent != null && parent instanceof SubTypeRef) {
				SubTypeRef parentSubType = (SubTypeRef) parent;
				if (parentSubType.getSubType().getName()
						.equals(subTypeRef.getSubType().getName())) {
					skipIt = true;
				}
			}

			if (skipIt == false) {
				instantiateAbstractAttributes(
						subTypeRef.getSubType().getName(), elementName,
						toFirstLower(subTypeRef.getSubType().getName()),
						subTypeRef, subTypeRef.getSubType().getAttributes(),
						subTypeRef.getSubType().getEnums(), elementName,
						toFirstLower(subTypeRef.getSubType().getName())
								+ "Element");
			}

			prefix = oldPrefix;
			theLevel--;
			instantiationString = instantiationString.concat(getPad() + "}"
					+ LINE_SEPARATOR);

			if (subTypeRef.getListOf() != null) {
				theLevel--;
				instantiationString = instantiationString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
			}
		}
		instantiationString = instantiationString.concat(getPad()
				+ "// Leaving " + METHOD + LINE_SEPARATOR);
	}

	private String buildArrayOfDirectoryInfoItems(String className,
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs) {
		final String METHOD = "buildArrayOfDirectoryInfoItems()";

		String toString = getPad() + "// Entered " + METHOD + LINE_SEPARATOR;

		for (AbstractAttribute abstractAttribute : attributes) {
			if (abstractAttribute instanceof Attribute) {
				Attribute attribute = (Attribute) abstractAttribute;
				AttributeType primitiveType = attribute.getAttributeType();
				boolean isList = attribute.getListOf() != null;

				if (isDirectoryEntry(abstractAttribute) == true) {
					/*
					 * By default, build the method that gets the length of the
					 * attribute if the attribute is a string, otherwise use the
					 * length of the primitive type.
					 */
					String getter = "this.get"
							+ toFirstUpper(attribute.getName()) + "()";
					String getLengthString = getter + " != null ? " + getter
							+ "." + (isList == false ? "length" : "size")
							+ "() : 0";

					/*
					 * Handle optional primitives that aren't in lists and
					 * aren't strings.
					 */
					if (isList == false
							&& primitiveType != AttributeType.STRING) {
						getLengthString = getPrimitiveSize(primitiveType
								.getLiteral());
					}

					toString = toString.concat(getPad()
							+ toFirstLower(grammarName) + "DirectoryInfoItems["
							+ handleCamelCase(className) + "_"
							+ handleCamelCase(attribute.getName())
							+ "].setLength(" + getLengthString + ");"
							+ LINE_SEPARATOR);
				}
			} else if (abstractAttribute instanceof SubTypeRef) {
				SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;
				boolean isList = subTypeRef.getListOf() != null;
				boolean isSelfReference = false;
				boolean isOptional = subTypeRef.getOptional() != null;

				if (toFirstUpper(subTypeRef.getSubType().getName()).equals(
						className) == true
						&& isList == false) {
					isSelfReference = true;
					toString = toString.concat(getPad()
							+ "// Ignoring self-reference: "
							+ subTypeRef.getName() + LINE_SEPARATOR);
				}

				String getLengthString = "this.get"
						+ toFirstUpper(subTypeRef.getName())
						+ "()."
						+ (isList == false ? "get"
								+ toFirstUpper(subTypeRef.getSubType()
										.getName()) + "Size()" : "size()");

				if (isSelfReference) {
					toString = toString.concat(getPad()
							+ "// Set self-references to length 0"
							+ LINE_SEPARATOR);
					toString = toString.concat(getPad()
							+ toFirstLower(grammarName) + "DirectoryInfoItems["
							+ handleCamelCase(className) + "_"
							+ handleCamelCase(subTypeRef.getName())
							+ "].setLength(0);" + LINE_SEPARATOR);
				} else {
					toString = toString.concat(getPad()
							+ toFirstLower(grammarName) + "DirectoryInfoItems["
							+ handleCamelCase(className) + "_"
							+ handleCamelCase(subTypeRef.getName())
							+ "].setLength(" + "this.get"
							+ toFirstUpper(subTypeRef.getName())
							+ "() != null ? " + getLengthString + " : 0);"
							+ LINE_SEPARATOR);
				}
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			// TODO store enums as integers for now
			if (penumRef.getOptional() != null) {
				toString = toString.concat(getPad() + toFirstLower(grammarName)
						+ "DirectoryInfoItems[" + handleCamelCase(className)
						+ "_" + handleCamelCase(penumRef.getName())
						+ "].setLength(4);" + LINE_SEPARATOR);
			}
		}

		toString = toString.concat(getPad() + "// Leaving " + METHOD
				+ LINE_SEPARATOR);
		return toString;
	}

	private String instantiatePEnumRef(String className, PEnumRef penumRef,
			boolean isFirst) {
		final String METHOD = "instantiatePEnumRef()";
		instantiationString = instantiationString.concat(getPad()
				+ "// Entered " + METHOD + LINE_SEPARATOR);

		String penumRefName = toFirstUpper(penumRef.getName());

		instantiationString = instantiationString.concat(getPad()
				+ (isFirst == true ? "" : "else ")
				+ "if (kvp.getKey().equals(\"" + penumRef.getName() + "\")) {"
				+ LINE_SEPARATOR);

		theLevel++;

		if (penumRef.getOptional() == null) {
			instantiationString = instantiationString.concat(getPad()
					+ "this.is" + prefix + penumRefName + "Updated = true;"
					+ LINE_SEPARATOR);
		}

		instantiationString = instantiationString.concat(getPad()
				+ "log4j.debug(\"setting value of \\\"" + penumRef.getName()
				+ "\\\" to: \" + kvp.getValue());" + LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ toFirstLower(className) + ".set" + penumRefName + "("
				+ penumRef.getPenum().getName() + ".valueOf(kvp.getValue()));"
				+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad() + "//this."
				+ penumRef.getName() + " = " + penumRef.getPenum().getName()
				+ ".valueOf(kvp.getValue());" + LINE_SEPARATOR);
		theLevel--;
		instantiationString = instantiationString.concat(getPad() + "}"
				+ LINE_SEPARATOR);
		instantiationString = instantiationString.concat(getPad()
				+ "// Leaving " + METHOD + LINE_SEPARATOR);
		return instantiationString;
	}

	private String initAttributeMethodCalls(String name,
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs) {
		boolean isFirst = true;

		attributeInitString = "";
		for (AbstractAttribute abstractAttribute : attributes) {
			String attributeName = abstractAttribute.getName();

			if (isFirst == true) {
				isFirst = false;
			} else {
				attributeInitString = attributeInitString
						.concat(LINE_SEPARATOR);
			}

			attributeInitString = attributeInitString.concat(getPad() + "if ("
					+ name + ".get" + toFirstUpper(attributeName)
					+ "() != null) {" + LINE_SEPARATOR);
			theLevel++;
			attributeInitString = attributeInitString.concat(getPad()
					+ "AbstractAttribute abstractAttribute = initialize"
					+ toFirstUpper(attributeName) + "(" + name + ".get"
					+ toFirstUpper(attributeName) + "());" + LINE_SEPARATOR);
			attributeInitString = attributeInitString.concat(getPad()
					+ "element.getAbstractAttributes().add(abstractAttribute);"
					+ LINE_SEPARATOR);

			theLevel--;
			attributeInitString = attributeInitString.concat(getPad() + "}"
					+ LINE_SEPARATOR);

			if (abstractAttribute.getOptional() != null) {
				attributeInitString = attributeInitString
						.concat(LINE_SEPARATOR);
			} else {
				attributeInitString = attributeInitString.concat(getPad()
						+ "else {" + LINE_SEPARATOR);
				theLevel++;
				attributeInitString = attributeInitString
						.concat(getPad()
								+ "// Missing required attribute, generate an error message and throw an exception"
								+ LINE_SEPARATOR);
				attributeInitString = attributeInitString
						.concat(getPad()
								+ "setErrorMsg(\"Error packing object. The attribute \\\""
								+ toFirstLower(attributeName)
								+ "\\\" is required, but no value was provided.\");"
								+ LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad()
						+ "log4j.error(getErrorMsg());" + LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad()
						+ "throw new MissingAttributeException(getErrorMsg());"
						+ LINE_SEPARATOR);

				theLevel--;
				attributeInitString = attributeInitString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			String penumRefName = toFirstUpper(penumRef.getName());
			attributeInitString = attributeInitString.concat(getPad() + "if ("
					+ name + ".get" + penumRefName + "() != null) {"
					+ LINE_SEPARATOR);
			theLevel++;
			attributeInitString = attributeInitString.concat(getPad()
					+ "AbstractAttribute abstractAttribute = initialize"
					+ penumRefName + "(" + name + ".get" + penumRefName
					+ "());" + LINE_SEPARATOR);
			attributeInitString = attributeInitString.concat(getPad()
					+ "element.getAbstractAttributes().add(abstractAttribute);"
					+ LINE_SEPARATOR);
			theLevel--;
			attributeInitString = attributeInitString.concat(getPad() + "}");

			if (penumRef.getOptional() != null) {
				attributeInitString = attributeInitString
						.concat(LINE_SEPARATOR);
			} else {
				attributeInitString = attributeInitString.concat(getPad()
						+ "else {" + LINE_SEPARATOR);
				theLevel++;
				attributeInitString = attributeInitString
						.concat(getPad()
								+ "// Missing required attribute, generate an error message and throw an exception"
								+ LINE_SEPARATOR);
				attributeInitString = attributeInitString
						.concat(getPad()
								+ "setErrorMsg(\"Error packing object. The attribute \\\""
								+ penumRef.getName()
								+ "\\\" is required, but no value was provided.\");"
								+ LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad()
						+ "log4j.error(getErrorMsg());" + LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad()
						+ "throw new MissingAttributeException(getErrorMsg());"
						+ LINE_SEPARATOR);
				theLevel--;
				attributeInitString = attributeInitString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
			}
		}

		return attributeInitString;
	}

	private String initAttributeMethods(String name,
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs) {
		attributeInitString = "";

		boolean isFirst = true;

		for (AbstractAttribute abstractAttribute : attributes) {
			String attributeName = abstractAttribute.getName();

			objectName = "abstractAttribute";
			prefix = "";

			if (isFirst == true) {
				isFirst = false;
			} else {
				attributeInitString = attributeInitString
						.concat(LINE_SEPARATOR);
			}

			String headerString = getPad() + "/*" + LINE_SEPARATOR;
			headerString = headerString.concat(getPad()
					+ " * This method initializes the "
					+ abstractAttribute.getName() + " attribute."
					+ LINE_SEPARATOR);
			headerString = headerString
					.concat(getPad() + " * Generated by initAttributeMethods()"
							+ LINE_SEPARATOR);
			headerString = headerString.concat(getPad() + " */"
					+ LINE_SEPARATOR);

			if (abstractAttribute instanceof Attribute) {
				Attribute attribute = (Attribute) abstractAttribute;

				attributeInitString = attributeInitString.concat(headerString);
				if (attribute.getListOf() != null) {
					attributeInitString = attributeInitString
							.concat(getPad()
									+ "private AbstractAttribute initialize"
									+ toFirstUpper(attributeName)
									+ "(List<"
									+ toFirstUpper(attribute.getAttributeType() == AttributeType.CHAR ? "Character"
											: attribute.getAttributeType()
													.getLiteral())
									+ "> "
									+ toFirstLower(attributeName)
									+ "List)"
									+ LINE_SEPARATOR
									+ getPad()
									+ "        throws MissingAttributeException {"
									+ LINE_SEPARATOR);
					theLevel++;
					attributeInitString = attributeInitString
							.concat(getPad()
									+ "AbstractAttribute abstractAttribute = new AbstractAttribute();"
									+ LINE_SEPARATOR);
					initAbstractAttributeValue(toFirstLower(name), name, null,
							abstractAttribute, true);
					attributeInitString = attributeInitString.concat(getPad()
							+ "return abstractAttribute;" + LINE_SEPARATOR);
					theLevel--;
					attributeInitString = attributeInitString.concat(getPad()
							+ "}" + LINE_SEPARATOR);
				} else {
					attributeInitString = attributeInitString
							.concat(getPad()
									+ "private AbstractAttribute initialize"
									+ toFirstUpper(attributeName)
									+ "("
									+ toFirstUpper(attribute.getAttributeType() == AttributeType.CHAR ? "Character"
											: attribute.getAttributeType()
													.getLiteral()) + " "
									+ toFirstLower(attributeName) + ")"
									+ LINE_SEPARATOR + "         "
									+ "throws MissingAttributeException {"
									+ LINE_SEPARATOR);
					theLevel++;
					attributeInitString = attributeInitString
							.concat(getPad()
									+ "AbstractAttribute abstractAttribute = new AbstractAttribute();"
									+ LINE_SEPARATOR);
					initAbstractAttributeValue(toFirstLower(name), name, null,
							abstractAttribute, false);
					attributeInitString = attributeInitString.concat(getPad()
							+ "return abstractAttribute;" + LINE_SEPARATOR);
					theLevel--;
					attributeInitString = attributeInitString.concat(getPad()
							+ "}" + LINE_SEPARATOR);
				}
			} else if (abstractAttribute instanceof SubTypeRef) {
				SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;

				// Don't generate a method for recursive structures
				if (toFirstUpper(name)
						.equals(subTypeRef.getSubType().getName()) == false
						|| abstractAttribute.getListOf() == null) {
					attributeInitString = attributeInitString
							.concat(headerString);
					if (subTypeRef.getListOf() != null) {
						attributeInitString = attributeInitString
								.concat(getPad()
										+ "private AbstractAttribute initialize"
										+ toFirstUpper(attributeName)
										+ "(List<"
										+ subTypeRef.getSubType().getName()
										+ "> " + toFirstLower(attributeName)
										+ "List)" + LINE_SEPARATOR
										+ "         "
										+ "throws MissingAttributeException {"
										+ LINE_SEPARATOR);
						theLevel++;
						attributeInitString = attributeInitString
								.concat(getPad()
										+ "AbstractAttribute abstractAttribute = new AbstractAttribute();"
										+ LINE_SEPARATOR);
						attributeInitString = attributeInitString
								.concat(getPad() + "if ("
										+ toFirstLower(attributeName)
										+ "List != null) {" + LINE_SEPARATOR);
						theLevel++;
						attributeInitString = attributeInitString
								.concat(getPad() + "int index"
										+ toFirstUpper(attributeName) + " = 0;"
										+ LINE_SEPARATOR);
						attributeInitString = attributeInitString
								.concat(getPad() + "for ("
										+ subTypeRef.getSubType().getName()
										+ " " + toFirstLower(attributeName)
										+ " : " + toFirstLower(attributeName)
										+ "List) {" + LINE_SEPARATOR);
						theLevel++;
						attributeInitString = attributeInitString
								.concat(getPad() + "Initialize"
										+ subTypeRef.getSubType().getName()
										+ " initialize"
										+ subTypeRef.getSubType().getName()
										+ " = new Initialize"
										+ subTypeRef.getSubType().getName()
										+ "(" + toFirstLower(attributeName)
										+ ");" + LINE_SEPARATOR);
						attributeInitString = attributeInitString
								.concat(getPad() + "Element "
										+ toFirstLower(attributeName)
										+ "Element = initialize"
										+ subTypeRef.getSubType().getName()
										+ ".initialize(\""
										+ toFirstLower(attributeName)
										+ "[\" + index"
										+ toFirstUpper(attributeName)
										+ " + \"]\");" + LINE_SEPARATOR);
						attributeInitString = attributeInitString
								.concat(getPad()
										+ "abstractAttribute.getElements().add("
										+ toFirstLower(attributeName)
										+ "Element);" + LINE_SEPARATOR);
						attributeInitString = attributeInitString
								.concat(getPad() + "index"
										+ toFirstUpper(attributeName) + "++;"
										+ LINE_SEPARATOR);
						theLevel--;
						attributeInitString = attributeInitString
								.concat(getPad() + "}" + LINE_SEPARATOR);
						theLevel--;
						attributeInitString = attributeInitString
								.concat(getPad() + "}" + LINE_SEPARATOR);

						if (subTypeRef.getOptional() == null) {
							attributeInitString = attributeInitString
									.concat(getPad() + "else {"
											+ LINE_SEPARATOR);
							attributeInitString = attributeInitString
									.concat(buildMissingAttributeExceptionString(attributeName));
							attributeInitString = attributeInitString
									.concat(getPad() + "}" + LINE_SEPARATOR);
						}
						attributeInitString = attributeInitString
								.concat(getPad() + "return abstractAttribute;"
										+ LINE_SEPARATOR);
						theLevel--;
						attributeInitString = attributeInitString
								.concat(getPad() + "}" + LINE_SEPARATOR);
					} else {
						attributeInitString = attributeInitString
								.concat(getPad()
										+ "private AbstractAttribute initialize"
										+ toFirstUpper(attributeName) + "("
										+ subTypeRef.getSubType().getName()
										+ " " + toFirstLower(attributeName)
										+ ")" + LINE_SEPARATOR
										+ "             "
										+ "throws MissingAttributeException {"
										+ LINE_SEPARATOR);
						theLevel++;
						attributeInitString = attributeInitString
								.concat(getPad()
										+ "AbstractAttribute abstractAttribute = new AbstractAttribute();"
										+ LINE_SEPARATOR);
						attributeInitString = attributeInitString
								.concat(getPad() + "if ("
										+ toFirstLower(attributeName)
										+ " != null) {" + LINE_SEPARATOR);
						theLevel++;
						attributeInitString = attributeInitString
								.concat(getPad() + "Initialize"
										+ subTypeRef.getSubType().getName()
										+ " initialize"
										+ subTypeRef.getSubType().getName()
										+ " = new Initialize"
										+ subTypeRef.getSubType().getName()
										+ "(" + toFirstLower(attributeName)
										+ ");" + LINE_SEPARATOR);
						attributeInitString = attributeInitString
								.concat(getPad() + "Element "
										+ toFirstLower(attributeName)
										+ "Element = initialize"
										+ subTypeRef.getSubType().getName()
										+ ".initialize(\""
										+ toFirstLower(attributeName) + "\");"
										+ LINE_SEPARATOR);
						attributeInitString = attributeInitString
								.concat(getPad()
										+ "abstractAttribute.getElements().add("
										+ toFirstLower(attributeName)
										+ "Element);" + LINE_SEPARATOR);
						theLevel--;
						attributeInitString = attributeInitString
								.concat(getPad() + "}" + LINE_SEPARATOR);
						if (subTypeRef.getOptional() == null) {
							attributeInitString = attributeInitString
									.concat(getPad() + "else {"
											+ LINE_SEPARATOR);
							attributeInitString = attributeInitString
									.concat(buildMissingAttributeExceptionString(attributeName));
							attributeInitString = attributeInitString
									.concat(getPad() + "}" + LINE_SEPARATOR);
						}
						attributeInitString = attributeInitString
								.concat(getPad() + "return abstractAttribute;"
										+ LINE_SEPARATOR);
						theLevel--;
						attributeInitString = attributeInitString
								.concat(getPad() + "}" + LINE_SEPARATOR);
					}
				}
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			attributeInitString = attributeInitString.concat(LINE_SEPARATOR);
			attributeInitString = attributeInitString.concat(getPad()
					+ "private AbstractAttribute initialize"
					+ toFirstUpper(penumRef.getName()) + "("
					+ penumRef.getPenum().getName() + " " + penumRef.getName()
					+ ")" + LINE_SEPARATOR + "         "
					+ "throws MissingAttributeException {" + LINE_SEPARATOR);
			theLevel++;
			attributeInitString = attributeInitString
					.concat(getPad()
							+ "AbstractAttribute abstractAttribute = new AbstractAttribute();"
							+ LINE_SEPARATOR);
			initPEnumRefValue(toFirstLower(name), null, penumRef, false);
			attributeInitString = attributeInitString.concat(getPad()
					+ "return abstractAttribute;" + LINE_SEPARATOR);
			theLevel--;
			attributeInitString = attributeInitString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		}

		attributeInitString = attributeInitString.concat(LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(getPad() + "/**"
				+ LINE_SEPARATOR);
		attributeInitString = attributeInitString
				.concat(getPad()
						+ "* This method returns the error message or null if no error occurred."
						+ LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(getPad() + "*/"
				+ LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(getPad()
				+ "public String getErrorMsg() {" + LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(getPad(1)
				+ "return theErrorMsg;" + LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(getPad() + "}"
				+ LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(getPad()
				+ "private void setErrorMsg(String errorMsg) {"
				+ LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(getPad(1)
				+ "theErrorMsg = errorMsg;" + LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(getPad() + "}"
				+ LINE_SEPARATOR);

		return attributeInitString;
	}

	private void initAttributeValue(String className, Attribute attribute,
			boolean isList) {
		attributeInitString = attributeInitString.concat(getPad()
				+ "// Entered initAttributeValue()" + LINE_SEPARATOR);
		String key = attribute.getName();
		String value = "";
		String attrNameFirstUpper = toFirstUpper(attribute.getName());

		if (prefix.length() == 0) {
			value = attribute.getName();
		} else {
			value = prefix + ".get" + attrNameFirstUpper + "()";
		}

		if (isList == true) {
			if (attribute.getListOf() != null) {
				key = key.concat("[\" + " + key + "Index + \"]");
			}
		} else {
			if (attribute.getListOf() != null) {
				prefix = toFirstLower(attribute.getName());
				key = key.concat("[\" + " + key + "Index + \"]");
			}
		}

		attributeInitString = attributeInitString.concat(getPad() + "if ("
				+ value + " != null) {" + LINE_SEPARATOR);
		theLevel++;
		attributeInitString = attributeInitString.concat(getPad()
				+ "log4j.debug(\"Creating new KeyValuePair: " + key + "\");"
				+ LINE_SEPARATOR);
		if (attribute.getAttributeType() == AttributeType.STRING) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "KeyValuePair kvp = new KeyValuePair(\"" + key
					+ "\", \"<STRING_BEGIN>\" + " + value
					+ " + \"<STRING_END>\");" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.INT) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "KeyValuePair kvp = new KeyValuePair(\"" + key
					+ "\", Integer.toString(" + value + "));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.CHAR) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "KeyValuePair kvp = new KeyValuePair(\"" + key + "\", "
					+ value + ".toString());" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.LONG) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "KeyValuePair kvp = new KeyValuePair(\"" + key
					+ "\", Long.toString(" + value + "));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.SHORT) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "KeyValuePair kvp = new KeyValuePair(\"" + key
					+ "\", Short.toString(" + value + "));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.FLOAT) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "KeyValuePair kvp = new KeyValuePair(\"" + key
					+ "\", Float.toString(" + value + "));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.DOUBLE) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "KeyValuePair kvp = new KeyValuePair(\"" + key
					+ "\", Double.toString(" + value + "));" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.BOOLEAN) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "KeyValuePair kvp = new KeyValuePair(\"" + key + "\", "
					+ value + ".toString());" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.BYTE) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "KeyValuePair kvp = new KeyValuePair(\"" + key + "\", "
					+ value + ".toString());" + LINE_SEPARATOR);
		} else if (attribute.getAttributeType() == AttributeType.CALENDAR) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "SimpleDateFormat formatter = new SimpleDateFormat(\""
					+ theDateTimeFormat + "\");" + LINE_SEPARATOR);
			attributeInitString = attributeInitString.concat(getPad()
					+ "KeyValuePair kvp = new KeyValuePair(\"" + key
					+ "\",  \"<DATE_TIME_BEGIN>\" + formatter.format(" + value
					+ ".getTime()) + \"<DATE_TIME_END>\");" + LINE_SEPARATOR);
		} else {
			attributeInitString = attributeInitString.concat(getPad()
					+ "ERROR: attribute type: "
					+ toFirstUpper(attribute.getAttributeType().getLiteral())
					+ " is not supported" + LINE_SEPARATOR);
		}

		attributeInitString = attributeInitString.concat(getPad() + objectName
				+ ".getKeyValuePairs().add(kvp);" + LINE_SEPARATOR);
		theLevel--;
		attributeInitString = attributeInitString.concat(getPad() + "}"
				+ LINE_SEPARATOR);

		/*
		 * If this is a required attribute and no value was provided, then
		 * generate an error.
		 */
		if (attribute.getOptional() == null) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "else {" + LINE_SEPARATOR);
			attributeInitString = attributeInitString
					.concat(buildMissingAttributeExceptionString(attribute
							.getName()));
			attributeInitString = attributeInitString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		}

		attributeInitString = attributeInitString.concat(LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(getPad()
				+ "// Leaving initAttributeValue()" + LINE_SEPARATOR);
	}

	private void initSubTypeRef(String variableName, SubTypeRef subTypeRef,
			String name, AbstractAttribute parent, String className,
			boolean isList) {
		attributeInitString = attributeInitString.concat(getPad()
				+ "// Entered initSubTypeRef()" + LINE_SEPARATOR);
		prefix = "";

		String test = subTypeRef.getName();

		if (isList) {
			prefix = subTypeRef.getName();
			test = variableName;
		} else {
			prefix = "this" + method;

			if (name != null) {
				test = name + ".get" + toFirstUpper(subTypeRef.getName())
						+ "()";
			}
		}

		attributeInitString = attributeInitString.concat(getPad() + "if ("
				+ test + " != null) {" + LINE_SEPARATOR);
		theLevel++;
		if (isList == true) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "log4j.debug(\"Creating new element: "
					+ subTypeRef.getName() + "\" + \"[\" + " + "index"
					+ toFirstUpper(subTypeRef.getName()) + " + \"]\"" + ");"
					+ LINE_SEPARATOR);
			attributeInitString = attributeInitString.concat(getPad()
					+ "Element " + subTypeRef.getName()
					+ "Element = new Element(\"" + subTypeRef.getName()
					+ "\" + \"[\" + " + "index"
					+ toFirstUpper(subTypeRef.getName()) + " + \"]\"" + ");"
					+ LINE_SEPARATOR);
		} else {
			attributeInitString = attributeInitString.concat(getPad()
					+ "log4j.debug(\"Creating new element: "
					+ subTypeRef.getName() + "\");" + LINE_SEPARATOR);
			attributeInitString = attributeInitString.concat(getPad()
					+ "Element " + subTypeRef.getName()
					+ "Element = new Element(\"" + subTypeRef.getName()
					+ "\");" + LINE_SEPARATOR);
		}

		attributeInitString = attributeInitString.concat(getPad() + objectName
				+ ".getElements().add(" + subTypeRef.getName() + "Element);"
				+ LINE_SEPARATOR);

		attributeInitString = attributeInitString
				.concat(getPad()
						+ "// OBSOLETE "
						+ subTypeRef.getName()
						+ "Element.setAbstractAttributes(new ArrayList<AbstractAttribute>());"
						+ LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(getPad()
				+ "AbstractAttribute " + subTypeRef.getName()
				+ "AbstractAttribute = new AbstractAttribute();"
				+ LINE_SEPARATOR);
		attributeInitString = attributeInitString
				.concat(getPad() + subTypeRef.getName()
						+ "Element.getAbstractAttributes().add("
						+ subTypeRef.getName() + "AbstractAttribute);"
						+ LINE_SEPARATOR);

		if (isList == true) {
			attributeInitString = attributeInitString.concat(getPad() + "index"
					+ toFirstUpper(subTypeRef.getName()) + "++;"
					+ LINE_SEPARATOR);
		}
		attributeInitString = attributeInitString.concat(LINE_SEPARATOR);
		theLevel++;
		prefix = test;

		// Catch models that have recursive attributes
		boolean skipIt = false;
		if (parent != null && parent instanceof SubTypeRef) {
			SubTypeRef parentSubType = (SubTypeRef) parent;
			if (parentSubType.getSubType().getName()
					.equals(subTypeRef.getSubType().getName())) {
				skipIt = true;
			}
		}

		if (skipIt == false) {
			for (AbstractAttribute aa : subTypeRef.getSubType().getAttributes()) {
				initAbstractAttributeValue(className, subTypeRef.getName(),
						subTypeRef, aa, isList);
			}
		}

		for (PEnumRef penumRef : subTypeRef.getSubType().getEnums()) {
			initPEnumRefValue(className, subTypeRef.getSubType().getName(),
					penumRef, isList);
		}

		theLevel--;
		attributeInitString = attributeInitString.concat(getPad() + "}"
				+ LINE_SEPARATOR);

		attributeInitString = attributeInitString.concat(getPad()
				+ "// Leaving initSubTypeRef()" + LINE_SEPARATOR);
	}

	private String initAbstractAttributes(String name,
			List<AbstractAttribute> abstractAttributes, List<PEnumRef> penumRefs) {
		boolean isFirst = true;

		attributeInitString = "";
		for (AbstractAttribute abstractAttribute : abstractAttributes) {
			String attributeName = toFirstUpper(abstractAttribute.getName());
			boolean isRecursive = false;
			boolean isRecursiveList = false;

			if (isFirst == true) {
				isFirst = false;
			} else {
				attributeInitString = attributeInitString
						.concat(LINE_SEPARATOR);
			}

			if (abstractAttribute instanceof SubTypeRef) {
				SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;

				if (toFirstUpper(name)
						.equals(subTypeRef.getSubType().getName())) {
					if (abstractAttribute.getListOf() != null) {
						attributeInitString = attributeInitString
								.concat(getPad() + "// Recursive list detected"
										+ LINE_SEPARATOR);
						isRecursiveList = true;
					} else {
						attributeInitString = attributeInitString
								.concat(getPad()
										+ "// Recursive attribute detected"
										+ LINE_SEPARATOR);
						isRecursive = true;
					}
				}
			}

			if (isRecursive == false && isRecursiveList == false) {
				attributeInitString = attributeInitString.concat(getPad()
						+ "if (" + name + ".get" + attributeName
						+ "() != null) {" + LINE_SEPARATOR);
				theLevel++;
				attributeInitString = attributeInitString.concat(getPad()
						+ "AbstractAttribute abstractAttribute = initialize"
						+ attributeName + "(" + name + ".get" + attributeName
						+ "());" + LINE_SEPARATOR);
				attributeInitString = attributeInitString
						.concat(getPad()
								+ "element.getAbstractAttributes().add(abstractAttribute);"
								+ LINE_SEPARATOR);
				theLevel--;
				attributeInitString = attributeInitString
						.concat(getPad() + "}");

				if (abstractAttribute.getOptional() != null) {
					attributeInitString = attributeInitString
							.concat(LINE_SEPARATOR);
				} else {
					attributeInitString = attributeInitString.concat(" else {"
							+ LINE_SEPARATOR);
					attributeInitString = attributeInitString
							.concat(buildMissingAttributeExceptionString(
									toFirstLower(attributeName),
									toFirstLower(name)));
					attributeInitString = attributeInitString.concat(getPad()
							+ "}" + LINE_SEPARATOR);
				}
			} else if (isRecursiveList == true) {
				attributeInitString = attributeInitString.concat(getPad()
						+ "if (" + name + ".get" + attributeName
						+ "() != null) {" + LINE_SEPARATOR);
				theLevel++;
				attributeInitString = attributeInitString.concat(getPad()
						+ "int " + abstractAttribute.getName() + "Index = 0;"
						+ LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad()
						+ "for (" + toFirstUpper(name) + " " + name
						+ attributeName + " : " + name + ".get" + attributeName
						+ "()) {" + LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad()
						+ "   Initialize" + toFirstUpper(name) + " initialize"
						+ toFirstUpper(name) + " = new Initialize"
						+ toFirstUpper(name) + "(" + LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad()
						+ "         " + name + attributeName + ");"
						+ LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad()
						+ "   Element a" + toFirstUpper(name)
						+ "Element = initialize" + toFirstUpper(name)
						+ LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad()
						+ "         .initialize(\""
						+ abstractAttribute.getName() + "[\" + "
						+ abstractAttribute.getName() + "Index + \"]\");"
						+ LINE_SEPARATOR);
				attributeInitString = attributeInitString
						.concat(getPad()
								+ "   AbstractAttribute aAbstractAttribute = new AbstractAttribute();"
								+ LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad()
						+ "   aAbstractAttribute.getElements().add(a"
						+ toFirstUpper(name) + "Element);" + LINE_SEPARATOR);
				attributeInitString = attributeInitString
						.concat(getPad()
								+ "   element.getAbstractAttributes().add(aAbstractAttribute);"
								+ LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad()
						+ "   " + abstractAttribute.getName() + "Index++;"
						+ LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
				theLevel--;
				attributeInitString = attributeInitString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			String penumRefName = toFirstUpper(penumRef.getName());
			attributeInitString = attributeInitString.concat(LINE_SEPARATOR);
			attributeInitString = attributeInitString.concat(getPad() + "if ("
					+ name + ".get" + penumRefName + "() != null) {"
					+ LINE_SEPARATOR);
			attributeInitString = attributeInitString.concat(getPad()
					+ "AbstractAttribute abstractAttribute = initialize"
					+ penumRefName + "(" + name + ".get" + penumRefName
					+ "());" + LINE_SEPARATOR);
			attributeInitString = attributeInitString.concat(getPad()
					+ "element.getAbstractAttributes().add(abstractAttribute);"
					+ LINE_SEPARATOR);
			attributeInitString = attributeInitString.concat(getPad() + "}");

			if (penumRef.getOptional() != null) {
				attributeInitString = attributeInitString
						.concat(LINE_SEPARATOR);
			} else {
				attributeInitString = attributeInitString.concat(getPad()
						+ " else {" + LINE_SEPARATOR);
				attributeInitString = attributeInitString
						.concat(buildMissingAttributeExceptionString(penumRef
								.getName()));
				attributeInitString = attributeInitString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
			}
		}

		return attributeInitString;
	}

	private void initAbstractAttributeValue(String className, String name,
			AbstractAttribute parent, AbstractAttribute abstractAttribute,
			boolean isList) {
		attributeInitString = attributeInitString.concat(getPad()
				+ "// Entered initAbstractAttributeValue()" + LINE_SEPARATOR);
		String collectionSource = "";

		if (prefix.length() == 0) {
			if (isList) {
				collectionSource = toFirstLower(name) + "List";
			} else {
				collectionSource = name;
			}
		} else {
			collectionSource = prefix + ".get" + name + "()";
		}

		if (abstractAttribute instanceof Attribute) {
			Attribute attribute = (Attribute) abstractAttribute;
			collectionSource = toFirstLower(attribute.getName()) + "List";

			if (attribute.getListOf() != null) {
				attributeInitString = attributeInitString.concat(getPad()
						+ "int " + attribute.getName() + "Index = 0;"
						+ LINE_SEPARATOR);

				attributeInitString = attributeInitString
						.concat(getPad()
								+ "for ("
								+ toFirstUpper(attribute.getAttributeType() == AttributeType.CHAR ? "Character"
										: attribute.getAttributeType()
												.getLiteral()) + " "
								+ toFirstLower(attribute.getName()) + " : "
								+ toFirstLower(attribute.getName()) + "List"
								+ ") {" + LINE_SEPARATOR);
				theLevel++;

				initAttributeValue(className, attribute, isList);
				attributeInitString = attributeInitString.concat(getPad()
						+ attribute.getName() + "Index++;" + LINE_SEPARATOR);
				theLevel--;
				attributeInitString = attributeInitString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
			} else {
				initAttributeValue(className, attribute, isList);
			}
		} else if (abstractAttribute instanceof SubTypeRef) {
			SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;
			String newMethod = ".get" + toFirstUpper(subTypeRef.getName())
					+ "()";
			String oldPrefix = prefix;
			String oldMethod = method;

			if (prefix.length() == 0) {
				collectionSource = toFirstLower(subTypeRef.getName()) + "List";
			} else {
				collectionSource = prefix + ".get"
						+ toFirstUpper(subTypeRef.getName()) + "()";
			}

			if (method.endsWith(newMethod) == false) {
				method = method.concat(newMethod);
			}

			attributeInitString = attributeInitString.concat(getPad()
					+ "// subTypeRef.getName(): " + subTypeRef.getName()
					+ LINE_SEPARATOR);
			attributeInitString = attributeInitString.concat(getPad()
					+ "// subTypeRef.getListOf() == null: "
					+ (subTypeRef.getListOf() == null) + LINE_SEPARATOR);

			if (subTypeRef.getListOf() != null) {
				attributeInitString = attributeInitString.concat(getPad()
						+ "int index" + toFirstUpper(subTypeRef.getName())
						+ " = 0;" + LINE_SEPARATOR);
				attributeInitString = attributeInitString.concat(getPad()
						+ "for ("
						+ toFirstUpper(subTypeRef.getSubType().getName()) + " "
						+ toFirstLower(subTypeRef.getName()) + " : "
						+ collectionSource + ") {" + LINE_SEPARATOR);
				theLevel++;

				initSubTypeRef(toFirstLower(subTypeRef.getName()), subTypeRef,
						name, parent, className, true);

				attributeInitString = attributeInitString.concat(getPad()
						+ "index" + toFirstUpper(subTypeRef.getName()) + "++;"
						+ LINE_SEPARATOR);
				theLevel--;
				attributeInitString = attributeInitString.concat(getPad() + "}"
						+ LINE_SEPARATOR);
			} else {
				initSubTypeRef(className, subTypeRef, name, parent, className,
						false);

				/*
				 * Restore the method name and prefix to what they were before
				 * descending into the sub-type.
				 */
				method = oldMethod;
				prefix = oldPrefix;
			}
		}

		attributeInitString = attributeInitString.concat(getPad()
				+ "// Leaving initAbstractAttributeValue()" + LINE_SEPARATOR);
	}

	private void initPEnumRefValue(String className, String name,
			PEnumRef penumRef, boolean isList) {
		attributeInitString = attributeInitString.concat(getPad()
				+ "// Entered initPEnumRefValue()" + LINE_SEPARATOR);

		if (name != null) {
			String newMethod = ".get" + name + "()";
			if (method.endsWith(newMethod) == false) {
				method = method.concat(newMethod);
			}
		}

		String ifTest = "";
		if (isList) {
			ifTest = name;
		} else {
			ifTest = "this" + method;
		}

		attributeInitString = attributeInitString.concat(getPad() + "if ("
				+ penumRef.getName() + "" + " != null) {" + LINE_SEPARATOR);
		theLevel++;
		attributeInitString = attributeInitString.concat(getPad()
				+ "log4j.debug(\"Creating new Key/Value pair: "
				+ penumRef.getName() + "\");" + LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(getPad()
				+ "KeyValuePair kvp = new KeyValuePair(\"" + penumRef.getName()
				+ "\", \"<ENUM_BEGIN>\" + " + penumRef.getName()
				+ " + \"<ENUM_END>\");" + LINE_SEPARATOR);
		attributeInitString = attributeInitString.concat(getPad()
				+ "abstractAttribute.getKeyValuePairs().add(kvp);"
				+ LINE_SEPARATOR);
		theLevel--;
		attributeInitString = attributeInitString.concat(getPad() + "}"
				+ LINE_SEPARATOR);

		/*
		 * If this is a required attribute and no value was provided, then
		 * generate an error.
		 */
		if (penumRef.getOptional() == null) {
			attributeInitString = attributeInitString.concat(getPad()
					+ "else {" + LINE_SEPARATOR);
			attributeInitString = attributeInitString
					.concat(buildMissingAttributeExceptionString(penumRef
							.getName()));
			attributeInitString = attributeInitString.concat(getPad() + "}"
					+ LINE_SEPARATOR);
		}

		attributeInitString = attributeInitString.concat(getPad()
				+ "// Leaving initPEnumRefValue()" + LINE_SEPARATOR);
	}

	private String handleCamelCase(String str) {
		String toString = "";

		int index = 0;
		while (index < str.length()) {
			if (index != 0 && Character.isUpperCase(str.charAt(index))) {
				toString = toString.concat("_");
			}
			toString = toString.concat(str.substring(index, index + 1)
					.toUpperCase());
			index++;
		}

		return toString;
	}

	private String generateMissingAttributeExceptionClass(String packageName,
			String className) {
		theLevel = 0;
		String toString = "";

		toString = toString.concat("/*" + LINE_SEPARATOR);
		toString = toString
				.concat(" * WARNING: This file was generated by ByteByByteGenerator.xtend (see"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(" * generateMissingAttributeExceptionClass())."
						+ LINE_SEPARATOR);
		toString = toString.concat(" * Do not edit." + LINE_SEPARATOR);
		toString = toString.concat(" */" + LINE_SEPARATOR);
		toString = toString.concat("package " + packageName + ";"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat("/**" + LINE_SEPARATOR);
		toString = toString.concat(" * The" + className
				+ " class generates an exception when a required attribute (as"
				+ LINE_SEPARATOR);
		toString = toString.concat(" * defined by the " + grammarName
				+ " grammar) is not provided." + LINE_SEPARATOR);
		toString = toString.concat(" */" + LINE_SEPARATOR);
		toString = toString.concat("public class " + className
				+ " extends Exception {" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private static final long serialVersionUID = 1L;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public " + className + "() {}"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public " + className
				+ "(String description) {" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "super(description);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat("}" + LINE_SEPARATOR);

		return toString;
	}

	private String generateDirectoryInfoItemClass(String packageName,
			String className) {
		theLevel = 0;
		String toString = "";
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * WARNING: This file was generated by JByteByByteGenerator.java (see"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * generateClassFile())."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * Do not edit."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "*/" + LINE_SEPARATOR);
		toString = toString.concat("package " + packageName + ";"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(" * The"
						+ className
						+ " class contains information used to build a directory entry."
						+ LINE_SEPARATOR);

		toString = toString
				.concat(getPad()
						+ " * Directory entries contain information used to pack and unpack attributes of messages and SubTypes"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * defined by the "
				+ grammarName + "  grammar." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "*/" + LINE_SEPARATOR);
		toString = toString.concat("public class " + className + " {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "private final int id;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private final String name;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private final int offsetInBits;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private int length;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private boolean isDirectoryEntry;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public "
						+ className
						+ "(int id, String name, int offsetInBits, int length, boolean isDirectoryEntry) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "this.id = id;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "this.name = name;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "this.offsetInBits = offsetInBits;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "this.length = length;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "this.setDirectoryEntry(isDirectoryEntry);" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public int getId() {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "return this.id;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public String getName() {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "return this.name;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public int getOffsetInBits() {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "return this.offsetInBits;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public int getLength() {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "return this.length;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public void setLength(int length) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "this.length = length;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public boolean isDirectoryEntry() {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "return isDirectoryEntry;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public void setDirectoryEntry(boolean isDirectoryEntry) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "this.isDirectoryEntry = isDirectoryEntry;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		return toString;
	}

	private String generateDirectoryEntryClass(String packageName,
			String className) {
		theLevel = 0;
		String toString = "";
		toString = toString.concat("/*" + LINE_SEPARATOR);
		toString = toString
				.concat(" * WARNING: This file was generated by JByteByByteGenerator.java (see"
						+ LINE_SEPARATOR);
		toString = toString.concat(" * generateDirectoryEntryClass())."
				+ LINE_SEPARATOR);
		toString = toString.concat(" * Do not edit." + LINE_SEPARATOR);
		toString = toString.concat(" */" + LINE_SEPARATOR);
		toString = toString.concat("package " + packageName + ";"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat("/**" + LINE_SEPARATOR);
		toString = toString.concat(" * The " + className
				+ " class defines a directory entry." + LINE_SEPARATOR);
		toString = toString.concat(" */" + LINE_SEPARATOR);
		toString = toString.concat("public class " + className + " {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "private int id;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private int offset;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private int length;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public static int DIRECTORY_ENTRY_SIZE_IN_BYTES = 12;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getId()
		toString = toString.concat(getPad() + "public int getId() {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return id;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// setId()
		toString = toString.concat(getPad() + "public void setId(int id) {"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad(1) + "this.id = id;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getOffset()
		toString = toString.concat(getPad() + "public int getOffset() {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return offset;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// setOffset()
		toString = toString.concat(getPad()
				+ "public void setOffset(int offset) {" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "this.offset = offset;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getLength()
		toString = toString.concat(getPad() + "public int getLength() {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return length;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// setLength()
		toString = toString.concat(getPad()
				+ "public void setLength(int length) {" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "this.length = length;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat("}" + LINE_SEPARATOR);

		return toString;
	}

	/*
	 * This method builds a constant ID for each message attribute.
	 */
	private String buildAttributeIDs(String className,
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs) {
		final String METHOD = "buildAttributeIDs()";
		String toString = getPad() + "// Entered " + METHOD + LINE_SEPARATOR;

		int id = 0;

		for (AbstractAttribute abstractAttribute : attributes) {
			Attribute attribute = null;
			SubTypeRef subTypeRef = null;
			String name = null;

			if (abstractAttribute instanceof Attribute) {
				attribute = (Attribute) abstractAttribute;
				name = attribute.getName();
			} else if (abstractAttribute instanceof SubTypeRef) {
				subTypeRef = (SubTypeRef) abstractAttribute;
				name = subTypeRef.getName();
			}

			toString = toString.concat(getPad() + "private static final int "
					+ handleCamelCase(className) + "_" + handleCamelCase(name)
					+ " = " + id + ";" + LINE_SEPARATOR);
			id++;
		}

		for (PEnumRef penumRef : penumRefs) {
			String name = penumRef.getName();
			toString = toString.concat(getPad() + "private static final int "
					+ handleCamelCase(className) + "_" + handleCamelCase(name)
					+ " = " + id + ";" + LINE_SEPARATOR);
			id++;
		}

		toString = toString.concat(getPad() + "// Leaving " + METHOD
				+ LINE_SEPARATOR);

		return toString;
	}

	/*
	 * This method builds an enumeration that stores information about each
	 * instance variable that is needed for packing and unpacking.
	 */
	private String buildClassEnum(String className, boolean isSubType,
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs) {
		final String METHOD = "buildClassEnum()";
		String toString = getPad() + "// Entered " + METHOD + LINE_SEPARATOR;

		/*
		 * Attribute enums
		 */
		int id = 0;
		toString = toString.concat(getPad() + "private enum " + className
				+ "Enum {" + LINE_SEPARATOR);
		theLevel++;

		int offsetInBits = 0;
		if (isSubType == false) {
			// Reserve 2 bytes for the message ID.
			offsetInBits = 16;
		}

		for (AbstractAttribute abstractAttribute : attributes) {
			Attribute attribute = null;
			SubTypeRef subTypeRef = null;
			String name = null;
			String attributeType = null;
			int sizeInBits = 0;
			boolean isDirectoryEntry = isDirectoryEntry(abstractAttribute);

			if (abstractAttribute instanceof Attribute) {
				attribute = (Attribute) abstractAttribute;
				name = attribute.getName();
				attributeType = attribute.getAttributeType().getLiteral();
			} else if (abstractAttribute instanceof SubTypeRef) {
				subTypeRef = (SubTypeRef) abstractAttribute;
				name = subTypeRef.getName();
				attributeType = subTypeRef.getSubType().getName();
			}
			sizeInBits = getPrimitiveSizeInBits(attributeType);

			if (id != 0) {
				toString = toString.concat("," + LINE_SEPARATOR
						+ LINE_SEPARATOR);
			}

			if (isDirectoryEntry == false) {
				toString = toString.concat(getPad() + "// sizeInBits: "
						+ sizeInBits + LINE_SEPARATOR);
			} else {
				toString = toString
						.concat(getPad()
								+ "// This is a directory item. It's offset and length cannot be determined"
								+ LINE_SEPARATOR);
				toString = toString.concat(getPad() + "// until runtime."
						+ LINE_SEPARATOR);
			}
			toString = toString.concat(getPad() + handleCamelCase(name) + "("
					+ id + ", \"" + name + "\", "
					+ (isDirectoryEntry == false ? offsetInBits : -1) + ", 0, "
					+ isDirectoryEntry + ")");

			if (isDirectoryEntry == false) {
				offsetInBits += sizeInBits;
			}

			id++;
		}

		for (PEnumRef penumRef : penumRefs) {
			String name = penumRef.getName();
			int sizeInBits = log2(penumRef.getPenum().getElements().size());
			int sizeInBytes = log8(penumRef.getPenum().getElements().size());
			sizeInBytes = 4;
			boolean isOptional = (penumRef.getOptional() != null);

			if (id != 0) {
				toString = toString.concat("," + LINE_SEPARATOR
						+ LINE_SEPARATOR);
			}

			if (isOptional == false) {
				toString = toString.concat(getPad() + "// sizeInBits: "
						+ sizeInBits + LINE_SEPARATOR);
				toString = toString.concat(getPad() + "// sizeInBytes: "
						+ sizeInBytes + LINE_SEPARATOR);
			} else {
				toString = toString
						.concat(getPad()
								+ "// This is a directory item. It's offset and length cannot be determined"
								+ LINE_SEPARATOR);
				toString = toString.concat(getPad() + "// until runtime."
						+ LINE_SEPARATOR);
			}
			toString = toString.concat(getPad() + handleCamelCase(name) + "("
					+ id + ", \"" + name + "\", "
					+ (isOptional == false ? offsetInBits : -1) + ", 0, ");

			if (isOptional == false) {
				offsetInBits += sizeInBytes * 8;
				toString = toString.concat("false)");
			} else {
				toString = toString.concat("true)");
			}

			id++;
		}

		toString = toString.concat(";" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "private final int id;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private final String name;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private final int offsetInBits;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private int length;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private boolean isDirectoryEntry;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString
				.concat(getPad()
						+ className
						+ "Enum(int id, String name, int offsetInBits, int length, boolean isDirectoryEntry) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "this.id = id;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "this.name = name;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "this.offsetInBits = offsetInBits;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "this.length = length;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "this.isDirectoryEntry = isDirectoryEntry;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "public int getId() {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return this.id;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "public String getName() {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return this.name;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "public int getOffsetInBits() {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return this.offsetInBits;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "public int getLength() {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return this.length;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "public void setLength(int length) {" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "this.length = length;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		theLevel--;
		toString = toString.concat(getPad() + "}");

		toString = toString.concat(getPad() + "// Leaving " + METHOD
				+ LINE_SEPARATOR);

		return toString;
	}

	private String generateRootClassEnumFile(String packageName,
			String className, Resource resource) {
		theLevel = 0;
		String toString = "";
		toString = toString.concat("/*" + LINE_SEPARATOR);
		toString = toString
				.concat(" * WARNING: This file was generated by JByteByByteGenerator.java (see"
						+ LINE_SEPARATOR);
		toString = toString.concat(" * generateRootClassEnumFile())."
				+ LINE_SEPARATOR);
		toString = toString.concat(" * Do not edit." + LINE_SEPARATOR);
		toString = toString.concat(" */" + LINE_SEPARATOR);
		toString = toString.concat("package " + packageName + ";"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString
				.concat("import java.util.EnumSet;" + LINE_SEPARATOR);
		toString = toString
				.concat("import java.util.HashMap;" + LINE_SEPARATOR);
		toString = toString.concat("import java.util.Map;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat("/**" + LINE_SEPARATOR);
		toString = toString.concat(" * The " + className
				+ "Enum class is an enumeration of the root class of the"
				+ LINE_SEPARATOR);
		toString = toString.concat(" * messaging system defined by the "
				+ grammarName + " grammar." + LINE_SEPARATOR);
		toString = toString.concat(" */" + LINE_SEPARATOR);

		/*
		 * Message enums
		 */
		int id = 0;
		toString = toString.concat("public enum " + className + "Enum {"
				+ LINE_SEPARATOR);

		theLevel++;
		for (Message e : theMessageList) {
			if (id != 0) {
				toString = toString.concat("," + LINE_SEPARATOR);
			}
			toString = toString.concat(getPad() + handleCamelCase(e.getName())
					+ "(" + id + ", \"" + e.getName() + "\")");
			id++;
		}

		for (SubType e : theSubTypeList) {
			if (id != 0) {
				toString = toString.concat("," + LINE_SEPARATOR);
			}
			toString = toString.concat(getPad() + handleCamelCase(e.getName())
					+ "(" + id + ", \"" + e.getName() + "\")");
			id++;
		}

		toString = toString.concat(";" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private final int id;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private final String name;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "private static final Map<Integer, " + className
				+ "Enum> lookup = new HashMap<Integer, " + className
				+ "Enum>();" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "static {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "for (" + className
				+ "Enum enumType : EnumSet.allOf(" + className
				+ "Enum.class)) {" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "lookup.put(enumType.getId(), enumType);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + className
				+ "Enum(int id, String name) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "this.id = id;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "this.name = name;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "public " + className
				+ "Enum getId(String name) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "for (" + className + "Enum e : "
				+ className + "Enum.values()) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "if (e.getName().equals(name)) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return e;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return null;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "public int getId() {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return this.id;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public String getName() {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return this.name;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "public static " + className
				+ "Enum" + " toEnum(int id) {" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return lookup.get(id);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public static " + className
				+ "Enum toEnum(String name) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "for (" + className + "Enum e : "
				+ className + "Enum.values()) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "if (e.getName().equals(name)) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "return e;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return null;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		theLevel--;
		toString = toString.concat(getPad() + "}");

		return toString;
	}

	private String generateUtilityClassFile(String packageName, String className) {
		theLevel = 0;
		String toString = "";
		toString = toString.concat("/*" + LINE_SEPARATOR);
		toString = toString
				.concat(" * WARNING: This file was generated by JByteByByteGenerator.java (see"
						+ LINE_SEPARATOR);
		toString = toString.concat(" * generateUtilityClassFile())."
				+ LINE_SEPARATOR);
		toString = toString.concat(" * Do not edit." + LINE_SEPARATOR);
		toString = toString.concat(" */" + LINE_SEPARATOR);
		toString = toString.concat("package " + packageName + ";"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat("import java.nio.ByteBuffer;"
				+ LINE_SEPARATOR);
		toString = toString.concat("import java.nio.ByteOrder;"
				+ LINE_SEPARATOR);
		toString = toString.concat("import java.nio.charset.Charset;"
				+ LINE_SEPARATOR);
		toString = toString.concat("import java.util.Calendar;"
				+ LINE_SEPARATOR);
		toString = toString.concat("import java.util.Date;" + LINE_SEPARATOR);
		toString = toString.concat("import java.util.List;" + LINE_SEPARATOR);
		toString = toString.concat("import java.util.zip.CRC32;"
				+ LINE_SEPARATOR);
		toString = toString.concat("import java.util.zip.Checksum;"
				+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat("import org.apache.log4j.Logger;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat("/**" + LINE_SEPARATOR);
		toString = toString
				.concat(" * The "
						+ className
						+ "Utility class provides utility methods for the messaging system defined"
						+ LINE_SEPARATOR);
		toString = toString.concat(" * by the " + grammarName + " grammar."
				+ LINE_SEPARATOR);
		toString = toString.concat(" */" + LINE_SEPARATOR);
		toString = toString.concat("public class " + className + "Utility {"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "private static Logger log4j = Logger.getLogger(" + className
				+ "Utility.class);" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "private static final char[] hexArray = \"0123456789ABCDEF\".toCharArray();"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private static final int BYTES_PER_ROW = 16;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private static final int ROW_QTR1 = 3;" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private static final int ROW_HALF = 7;" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private static final int ROW_QTR2 = 11;" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "private static final String LINE_SEPARATOR = System.lineSeparator();"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "private static String[] hexChars = new String[] { \"0\", \"1\", \"2\", \"3\", \"4\", \"5\","
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad(3)
						+ "\"6\", \"7\", \"8\", \"9\", \"A\", \"B\", \"C\", \"D\", \"E\", \"F\" };"
						+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// bytesToHex()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * This method converts an array of bytes to a hex string."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public static String bytesToHex(byte[] bytes) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "char[] hexChars = new char[bytes.length * 3];"
				+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "for (int index = 0; index < bytes.length; index++) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "int v = bytes[index] & 0xFF;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "hexChars[index * 3] = hexArray[v >>> 4];" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "hexChars[index * 3 + 1] = hexArray[v & 0x0F];"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "hexChars[index * 3 + 2] = ' ';"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return new String(hexChars);"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getString()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns a string from a byte array given an offset"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * and a length."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static String getString(byte[] byteArray, int offset, int len) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "String result = \"\";"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "for (int i = 0; i < len; i++) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "result += (char) byteArray[offset + i];" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "return result;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getBoolean()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns a boolean from a byte array given an offset in bits."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static boolean getBoolean(byte[] byteArray, int offset) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "byte b = byteArray[offset / 8];"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return (b == 1 ? true : false);"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getByte()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns a byte from a byte array given an offset in bits into"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * the byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte getByte(byte[] byteArray, int offsetInBits) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "int index = offsetInBits / 8;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "int bitPosition = offsetInBits % 8;" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int upper = 0;" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int lower = 0;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (bitPosition == 0) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "upper = byteArray[index];"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "} else if (bitPosition == 1) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "upper = (byteArray[index] & 0x7f) << 1;" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "lower = (byteArray[index + 1] >> 7) & 0x01;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "} else if (bitPosition == 2) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "upper = (byteArray[index] & 0x3f) << 2;" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "lower = (byteArray[index + 1] >> 6) & 0x03;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "} else if (bitPosition == 3) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "upper = (byteArray[index] & 0x1f) << 3;" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "lower = (byteArray[index + 1] >> 5) & 0x07;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "} else if (bitPosition == 4) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "upper = (byteArray[index] & 0x0f) << 4;" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "lower = (byteArray[index + 1] >> 4) & 0x0f;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "} else if (bitPosition == 5) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "upper = (byteArray[index] & 0x07) << 5;" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "lower = (byteArray[index + 1] >> 3) & 0x1f;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "} else if (bitPosition == 6) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "upper = (byteArray[index] & 0x03) << 6;" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "lower = (byteArray[index + 1] >> 2) & 0x3f;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "} else if (bitPosition == 7) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "upper = (byteArray[index] & 0x01) << 7;" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "lower = (byteArray[index + 1] >> 1) & 0x7f;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return (byte) (upper + lower);"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getCharacter()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns a character from a byte array given an offset in bits."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static char getCharacter(byte[] byteArray, int offsetInBits) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "byte[] bytes = new byte[2];"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (int i = 0; i < 2; i++) {"
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad(1)
				+ "bytes[i] = getByte(byteArray, offsetInBits + i * 8);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getChar();"
						+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getShort()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns a short from a byte array given an offset in bits."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static short getShort(byte[] byteArray, int offsetInBits) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "byte[] bytes = new byte[2];"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (int i = 0; i < 2; i++) {"
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad(1)
				+ "bytes[i] = getByte(byteArray, offsetInBits + i * 8);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getShort();"
						+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getInteger()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns an integer from a byte array given an offset in bits."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static int getInteger(byte[] byteArray, int offsetInBits) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "byte[] bytes = new byte[4];"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (int i = 0; i < 4; i++) {"
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad(1)
				+ "bytes[i] = getByte(byteArray, offsetInBits + i * 8);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getInt();"
						+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getLong()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns a long from a byte array given an offset in bits into"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * the byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static long getLong(byte[] byteArray, int offsetInBits) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "byte[] bytes = new byte[8];"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (int i = 0; i < 8; i++) {"
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad(1)
				+ "bytes[i] = getByte(byteArray, offsetInBits + i * 8);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getLong();"
						+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getFloat()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns a float from a byte array given an offset in bits into"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * the byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static float getFloat(byte[] byteArray, int offsetInBits) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "byte[] bytes = new byte[4];"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (int i = 0; i < 4; i++) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "bytes[i] = getByte(byteArray, offsetInBits + i * 8);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getFloat();"
						+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getCalendar()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns a Calendar from a byte array given an offset in bits."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static Calendar getCalendar(byte[] byteArray, int offsetInBits) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "long result = getLong(byteArray, offsetInBits);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "Date date = new Date(result);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "Calendar cal = Calendar.getInstance();" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "cal.setTime(date);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return cal;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getDate()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns a date from a byte array given an offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public static Date getDate(byte[] byteArray, int offset) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "long result = getLong(byteArray, offset);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return new Date(result);"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getDouble()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns a double from a byte array given an offset in bits."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static double getDouble(byte[] byteArray, int offsetInBits) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "byte[] bytes = new byte[8];"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (int i = 0; i < 8; i++) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "bytes[i] = getByte(byteArray, offsetInBits + i * 8);"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getDouble();"
						+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertBitfield()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a bit field into a byte array at a given offset in bits."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bits." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param length The length of the bit field in bits."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param value The value to be inserted." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertBitfield(byte[] byteArray, int offsetInBits, int length, int value) {"
						+ LINE_SEPARATOR);
		theLevel++;

		toString = toString.concat(getPad()
				+ "if (offsetInBits % 8 == 0 && length == 1) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "byteArray[offsetInBits/8] = (byte) value;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "else {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "String binaryString = Integer.toBinaryString(value);"
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "if (binaryString.length() > length) {" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "binaryString = binaryString.substring(0, length);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "String paddedBinaryString = binaryString;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "if ((length - binaryString.length()) > 1) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "paddedBinaryString = String.format(" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad(2)
						+ "\"%0\" + (length - binaryString.length()) + \"d\" + \"%s\", 0,"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad(2) + "binaryString);"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "int bitCounter = offsetInBits;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "for (char c : paddedBinaryString.toCharArray()) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "int index = bitCounter / 8;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "int shift = 7 - bitCounter % 8;"
				+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "if (c == '1') {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "byteArray[index] |= 1 << shift;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "} else {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "byteArray[index] &= ~(1 << shift);" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "bitCounter++;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertCalendar()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a calendar into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param calendar The calendar to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertCalendar(byte[] byteArray, int offset, Calendar calendar) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "long lng = calendar.getTimeInMillis();" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byteArray = insertLong(byteArray, offset, lng);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertDate()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a date into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param date The date to be inserted." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertDate(byte[] byteArray, int offset, Date date) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "long lng = date.getTime();"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byteArray = insertLong(byteArray, offset, lng);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertCalendars()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a list of calendars into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param calendars The list of calendars to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertCalendars(byte[] byteArray, int offset, List<Calendar> calendars) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString
				.concat(getPad() + "int index = 0;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (Calendar c : calendars) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString
				.concat(getPad()
						+ "byteArray = insertDate(byteArray, offset + index * 8, c.getTime());"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "index++;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertByte()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a byte into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + " * @param b The byte value to be inserted."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertByte(byte[] byteArray, int offset, byte b) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byte[] bytes = ByteBuffer.allocate(1).put(b).array();"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byteArray = insertBytes(byteArray, offset, bytes);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertBytes()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a list of bytes into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param bytes The bytes to be inserted." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertBytes(byte[] byteArray, int offset, List<Byte> bytes) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "for (int i = 0; i < bytes.size(); i++) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "byteArray[offset + i] = bytes.get(i);" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertBytes()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts an array of bytes into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param bytes The bytes to be inserted." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertBytes(byte[] byteArray, int offset, byte[] bytes) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int index = 0;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (byte b : bytes) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "byteArray[offset + index] = b;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "index++;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertBoolean()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a Boolean into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param b The Boolean value to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertBoolean(byte[] byteArray, int offset, Boolean b) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "byteArray[offset] = (byte) (b == true ? 1 : 0);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertBooleans()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a list of booleans into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * @param booleans The list of boolean values to be inserted."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertBooleans(byte[] byteArray, int offset, List<Boolean> booleans) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int index = 0;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (Boolean b : booleans) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString
				.concat(getPad()
						+ "byteArray = insertBitfield(byteArray, (offset + index) * 8, 1, (b == true ? 1 : 0));"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "index++;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertDouble()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a double into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param d The double value to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertDouble(byte[] byteArray, int offset, double d) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "long lng = Double.doubleToLongBits(d);" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byteArray = insertLong(byteArray, offset, lng);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertDoubles()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a list of doubles into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param doubles The list of double values to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertDoubles(byte[] byteArray, int offset, List<Double> doubles) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int index = 0;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (Double d : doubles) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "byteArray = insertDouble(byteArray, offset + index * 8, d);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "index++;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertLong()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a long into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param lng The long value to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertLong(byte[] byteArray, int offset, long lng) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byte[] bytes = ByteBuffer.allocate(8).putLong(lng).array();"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byteArray = insertBytes(byteArray, offset, bytes);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertLongs()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a list of longs into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param longs The list of long values to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertLongs(byte[] byteArray, int offset, List<Long> longs) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int index = 0;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (Long lng : longs) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "byteArray = insertLong(byteArray, offset + index * 8, lng);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "index++;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertInteger()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts an integer into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param integer The integer value to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertInteger(byte[] byteArray, int offset, int integer) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "byte[] bytes = ByteBuffer.allocate(4).putInt(integer).array();"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byteArray = insertBytes(byteArray, offset, bytes);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertIntegers()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a list of integers into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * @param integers The list of integer values to be inserted."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertIntegers(byte[] byteArray, int offset, List<Integer> integers) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int index = 0;" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "for (Integer integer : integers) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString
				.concat(getPad()
						+ "byteArray = insertInteger(byteArray, offset + index * 4, integer);"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "index++;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertShort()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a short into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param shrt The short value to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertShort(byte[] byteArray, int offset, short shrt) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "byte[] bytes = ByteBuffer.allocate(2).putShort(shrt).array();"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byteArray = insertBytes(byteArray, offset, bytes);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertShorts()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a list of shorts into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param shorts The list of short values to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertShorts(byte[] byteArray, int offset, List<Short> shorts) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int index = 0;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (Short shrt : shorts) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString
				.concat(getPad()
						+ "byteArray = insertShort(byteArray, offset + index * 2, shrt);"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "index++;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertFloat()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a float into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param flt The float value to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertFloat(byte[] byteArray, int offset, float flt) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "byte[] bytes = ByteBuffer.allocate(4).putFloat(flt).array();"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byteArray = insertBytes(byteArray, offset, bytes);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertFloats()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a list of floats into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param floats The list of float values to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertFloats(byte[] byteArray, int offset, List<Float> floats) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int index = 0;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (Float f : floats) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "byteArray = insertFloat(byteArray, offset + index * 4, f);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "index++;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertCharacter()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a char into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param c The integer value to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertCharacter(byte[] byteArray, int offset, char c) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (int i = 0; i < 2; i++) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "byte b = (byte) ((c >> (1 - i) * 8) & 0xff);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byteArray = setByte(byteArray, offset + i, b);"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertCharacters()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a list of chars into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param chars The list of char values to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertCharacters(byte[] byteArray, int offset, List<Character> chars) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int index = 0;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (Character c : chars) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString
				.concat(getPad()
						+ "byteArray = insertCharacter(byteArray, offset + index * 2, c);"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "index++;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertString()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a string into a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param string The string to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertString(byte[] byteArray, int offset, String string) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byte[] bytes = string.getBytes(Charset.forName(\"UTF-8\"));"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int index = 0;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (byte b : bytes) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "byteArray[offset + index] = b;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "index++;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// insertStrings()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method inserts a list of strings into a byte array at a given an offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param offset The offset in bytes." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param strings The list of string to be inserted."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] insertStrings(byte[] byteArray, int offset, List<String> strings) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (String string : strings) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "byteArray = insertString(byteArray, offset, string);"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "offset += string.getBytes(Charset.forName(\"UTF-8\")).length;"
						+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// setByte()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method sets a byte in a byte array at a given offset."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The byte array."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static byte[] setByte(byte[] byteArray, int offset, byte b) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "byteArray[offset] = b;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return byteArray;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// getChecksum()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method calculates a CRC-32 checksum for the specified array of bytes."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * @param The number of bytes to consider when calculating the checksum."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The checksum."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static long getChecksum(byte[] byteArray, int length) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "Checksum checksum = new CRC32();" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "checksum.update(byteArray, 0, length);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return checksum.getValue();"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// verifyChecksum()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method verifies a CRC-32 checksum for the specified array of bytes."
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * First the current checksum embedded in the last 8 bytes of the byte array"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * is retrieved. Then the checksum for the array is calculated and compared."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteArray The byte array." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @return True if the checksum is valid." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public static boolean verifyChecksum(byte[] byteArray) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString
				.concat(getPad()
						+ "long checksum1 = getLong(byteArray, byteArray.length * 8 - 64);"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "long checksum2 = getChecksum(byteArray, byteArray.length - 8);"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return checksum1 == checksum2;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// dumbHexData()
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * This method dumps a byte array as hex characters."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @param title The title."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param buf The byte array buffer." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param numBytes The number of bytes to dump."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param return A string containing the dumped bytes."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public static String dumpHexData(String title, byte[] buf, int numBytes) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "int rows;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "int residue;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "int i;" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "int j;" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "int labelSize;" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "byte[] rowBuf = new byte[BYTES_PER_ROW + 2];"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "String[] charBuf = new String[4];" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "String result = title + \" - \" + numBytes + \" bytes.\" + LINE_SEPARATOR;"
						+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "// There are 16 bytes per row."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "rows = numBytes >> 4;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "residue = numBytes & 0x0000000F;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * Calculate the number of hex characters required to represent the row"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * label." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "labelSize = log16(numBytes);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (i = 0; i < rows; i++) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "int byteCount = (i * BYTES_PER_ROW);" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "String rowLabel = buildRowLabel(byteCount, labelSize);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "result = result.concat(rowLabel + \": \");"
						+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "for (j = 0; j < BYTES_PER_ROW; j++) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "rowBuf[j] = buf[(i * BYTES_PER_ROW) + j];" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "charBuf[0] = hexChars[(rowBuf[j] >> 4) & 0x0F];"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "charBuf[1] = hexChars[rowBuf[j] & 0x0F];" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "result = result.concat(charBuf[0]);" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "result = result.concat(charBuf[1]);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "result = result.concat(\" \");"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "if (j == ROW_QTR1 || j == ROW_HALF || j == ROW_QTR2) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "result = result.concat(\" \");"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "if (rowBuf[j] < 0x20 || rowBuf[j] > 0xD9) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "rowBuf[j] = '.';"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "String saveStr = new String(rowBuf, 0, j);"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "result = result.concat(\" | \" + saveStr + \" |\" + LINE_SEPARATOR);"
						+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (residue > 0) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "int byteCount = (i * BYTES_PER_ROW);" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "String rowLabel = buildRowLabel(byteCount, labelSize);"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "result = result.concat(rowLabel + \": \");"
						+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "for (j = 0; j < residue; j++) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "rowBuf[j] = buf[(i * BYTES_PER_ROW) + j];" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "charBuf[0] = hexChars[(rowBuf[j] >> 4) & 0x0F];"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "charBuf[1] = hexChars[rowBuf[j] & 0x0F];" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "result = result.concat(charBuf[0]);" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "result = result.concat(charBuf[1]);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "result = result.concat(\" \");"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "if (j == ROW_QTR1 || j == ROW_HALF || j == ROW_QTR2) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "result = result.concat(\" \");"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "if (rowBuf[j] < 0x20 || rowBuf[j] > 0xD9) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "rowBuf[j] = '.';"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "for ( /* j INHERITED */; j < BYTES_PER_ROW; j++) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "rowBuf[j] = ' ';"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "result = result.concat(\"   \");" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "if (j == ROW_QTR1 || j == ROW_HALF || j == ROW_QTR2) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "result = result.concat(\" \");"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "String saveStr = new String(rowBuf, 0, j);"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "result = result.concat(\" | \" + saveStr + \" |\" + LINE_SEPARATOR);"
						+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "return result;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// buildRowLabel()
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method builds the label the proceeds each row of data. The index and"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * shift are calculated on the fly to obtain a result like this:"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * idx_buf[0] = hexChars[((hexVal >> 12) & 0xf)];"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * idx_buf[1] = hexChars[((hexVal >> 8) & 0xf)];"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * idx_buf[2] = hexChars[((hexVal >> 4) & 0xf)];"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * idx_buf[3] = hexChars[(hexVal & 0xf)];" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * The array of bytes is then converted to a string and returned."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param byteCount The byte count." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param labelSize The label size." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "private static String buildRowLabel(int byteCount, int labelSize) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "String result = \"\";"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "for (int c = 0; c < labelSize; c++) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "int shift = c * 4;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "result = hexChars[((byteCount >> shift) & 0xf)] + result;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "return result;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		// log16
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method calculates the minimum number of hex characters required to"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * represent the given value."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private static int log16(int value) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "int bits = Integer.SIZE"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad(2)
						+ "- Integer.numberOfLeadingZeros(value > 0 ? value - 1 : value);"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "int hex = (bits - 1) / 4 + 1;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return hex;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		return toString;
	}

	private String generateRootClassFile(String packageName, String className,
			Resource resource) {
		theLevel = 0;
		String toString = "";
		toString = toString.concat("/*" + LINE_SEPARATOR);
		toString = toString
				.concat(" * WARNING: This file was generated by JByteByByteGenerator.java (see"
						+ LINE_SEPARATOR);
		toString = toString.concat(" * generateRootClassFile())."
				+ LINE_SEPARATOR);
		toString = toString.concat(" * Do not edit." + LINE_SEPARATOR);
		toString = toString.concat(" */" + LINE_SEPARATOR);
		toString = toString.concat("package " + packageName + ";"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat("import org.apache.log4j.Logger;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat("/**" + LINE_SEPARATOR);
		toString = toString.concat(" * The " + className
				+ " class is the root class of the messaging system defined"
				+ LINE_SEPARATOR);
		toString = toString.concat(" * by the " + grammarName + " grammar."
				+ LINE_SEPARATOR);
		toString = toString.concat(" */" + LINE_SEPARATOR);
		toString = toString.concat("public class " + className + " {"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "private static Logger log4j = Logger.getLogger(" + className
				+ ".class);" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private String theErrorMsg = null;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * The " + className
				+ " constructor." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public " + className + "() {}"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * The number of bits required to represent the message and sub-type IDs."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public static final int ID_BITS = "
				+ log2(theMessageList.size() + theSubTypeList.size()) + ";"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * Available messages...
		 */
		toString = toString.concat(getPad() + "// The messages available in "
				+ className + ":" + LINE_SEPARATOR);

		for (Message e : theMessageList) {
			toString = toString.concat(getPad() + "public static final String "
					+ handleCamelCase(e.getName()) + " = \"" + e.getName()
					+ "\";" + LINE_SEPARATOR);
		}

		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * pack()
		 */
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * The pack() method packs an object into a byte array. The byte array will be in"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * ByteByByte format. The object must be one of the following classes:"
						+ LINE_SEPARATOR);
		for (Message e : theMessageList) {
			toString = toString.concat(getPad() + " *   " + e.getName()
					+ LINE_SEPARATOR);
		}
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @param obj The object."
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * @return A byte array which represents the message object in ByteByByte"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *         format."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @throws MissingAttributeException" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public byte[] pack(Object obj) throws MissingAttributeException {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"pack()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "byte[] result = null;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "setErrorMsg(null);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (obj != null) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString
				.concat(getPad()
						+ "log4j.debug(\"Searching for class: \" + obj.getClass().getSimpleName());"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(buildObjectInstanceSearcher(resource, "pack"));
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "else {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "setErrorMsg(\"The object to be packed is null\"); "
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "log4j.error(getErrorMsg());"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "return result;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * packStr()
		 */
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * The packStr() method packs an object into a String. The String will be in"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * ByteByByte format. The object must be one of the following classes:"
						+ LINE_SEPARATOR);
		for (Message e : theMessageList) {
			toString = toString.concat(getPad() + " *   " + e.getName()
					+ LINE_SEPARATOR);
		}
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @param obj The object."
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * @return A String which represents the message object in ByteByByte"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *         format."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @throws MissingAttributeException" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public String packStr(Object obj) throws MissingAttributeException {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"packStr()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "String result = null;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "setErrorMsg(null);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (obj != null) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString
				.concat(getPad()
						+ "log4j.debug(\"Searching for class: \" + obj.getClass().getSimpleName());"
						+ LINE_SEPARATOR);
		toString = toString.concat(buildObjectInstanceSearcher(resource,
				"packStr"));
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "else {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "setErrorMsg(\"The object to be packed is null\"); "
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "log4j.error(getErrorMsg());"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "return result;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * unpack()
		 */
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * The unpack() method unpacks a byte array into an object. The byte array must be in "
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * ByteByByte format. The returned object will be one of the following"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * classes:" + LINE_SEPARATOR);
		for (Message e : theMessageList) {
			toString = toString.concat(getPad() + " * " + e.getName()
					+ LINE_SEPARATOR);
		}

		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @return The byte array as an object." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public Object unpack(byte[] buffer) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"unpack()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + rootClass + "Enum gme = "
				+ rootClass + ".peek(buffer);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "Object result = null;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (gme != null) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Searching for ID: \" + gme.getId());"
				+ LINE_SEPARATOR);
		toString = toString.concat(buildIdSearcher(resource, "gme"));
		toString = toString.concat(getPad() + "else {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "log4j.error(\"Error unpacking byte array.\");"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "return result;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * unpackStr()
		 */
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * The unpackStr() method unpacks a String into an object. The String must be in "
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * ByteByByte format. The returned object will be one of the following"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * classes:" + LINE_SEPARATOR);
		for (Message e : theMessageList) {
			toString = toString.concat(getPad() + " * " + e.getName()
					+ LINE_SEPARATOR);
		}

		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @return The message string as an object."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public Object unpackStr(String buffer) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"unpackStr()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "String className = null;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "Object result = null;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "setErrorMsg(null);"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (buffer == null) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "setErrorMsg(\"No string was provided to unpack\");"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "log4j.error(getErrorMsg());"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "else if (buffer.startsWith(\"{\") == false) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "setErrorMsg(\"Invalid string format\");" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "log4j.error(getErrorMsg());"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "else {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "String tokens[] = buffer.split(\" \");" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"# of tokens: \" + tokens.length);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"tokens[0]: \" + tokens[0]);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (tokens.length == 1) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "className = tokens[0].substring(1, tokens[0].length() - 1);"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "else {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "className = tokens[0].substring(1);" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Searching for class: \" + className);"
				+ LINE_SEPARATOR);
		toString = toString.concat(buildClassSearcher(resource));
		toString = toString.concat(getPad() + "else {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString
				.concat(getPad()
						+ "setErrorMsg(\"Unknown/unsupported class name: \" + className);"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "log4j.error(getErrorMsg());"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "return result;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * setErrorMsg()
		 */
		toString = toString.concat(getPad()
				+ "private void setErrorMsg(String errorMsg) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "theErrorMsg = errorMsg;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * getErrorMessage()
		 */
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method returns the error message or null if no error occurred."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public String getErrorMsg() {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "return theErrorMsg;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * peek()
		 */
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "* This method takes a \"peek\" at the message buffer without fully parsing"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "* it. It returns the enum of the message." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "*" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "* @param buffer"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "*            The byte array containing the message."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "* @return The enum of the object within the message buffer."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "*/" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public static " + rootClass
				+ "Enum peek(byte[] buffer) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"peek()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "" + rootClass + "Enum "
				+ toFirstLower(rootClass) + "Enum = null;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (buffer != null) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "short id = " + rootClass
				+ "Utility.getShort(buffer, 0);" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(String.format(\"id: %d\", id));"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "" + toFirstLower(rootClass)
				+ "Enum = " + rootClass + "Enum.toEnum(id);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (" + toFirstLower(rootClass)
				+ "Enum != null) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "log4j.debug(String.format(\"ID: %d (%s)\", "
				+ toFirstLower(rootClass) + "Enum.getId()," + LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "" + toFirstLower(rootClass)
				+ "Enum.getName()));" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return "
				+ toFirstLower(rootClass) + "Enum;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * This method takes a \"peek\" at the message buffer without fully parsing"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * it. It returns the class name of the message buffer."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param buffer The string message buffer."
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * @return The class name of the object within the message buffer."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "public static String peek(String buffer) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"peek()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "String className = null;"
				+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (buffer != null) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "if (buffer.startsWith(\"{\")) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "String tokens[] = buffer.split(\" \");" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"# of tokens: \" + tokens.length);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"tokens[0]: \" + tokens[0]);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "if (tokens.length == 1) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "className = tokens[0].substring(1, tokens[0].length() - 1);"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "} else {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "className = tokens[0].substring(1);" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "log4j.debug(\"className: \" + className);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return className;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat("}" + LINE_SEPARATOR);

		return toString;
	}

	private String generateMessageClassFile(String packageName, Message msg,
			String dateFormatString) {
		return generateClassFile(packageName, msg.getName(),
				msg.getAttributes(), msg.getEnums(), false, dateFormatString);
	}

	private String generateClassFile(String packageName, String className,
			EList<AbstractAttribute> attributes, EList<PEnumRef> penumRefs,
			Boolean isSubType, String dateFormatString) {
		final String METHOD = "generateClassFile()";

		theLevel = 0;
		String toString = "";
		List<SubTypeRef> listOfSubTypes = toSubTypeRefList(attributes);
		List<Attribute> listOfAttributes = toAttributeList(attributes);

		toString = toString.concat("/*" + LINE_SEPARATOR);
		toString = toString
				.concat(" * WARNING: This file was generated by JByteByByteGenerator.java (see"
						+ LINE_SEPARATOR);
		toString = toString.concat(" * " + METHOD + "). " + LINE_SEPARATOR);
		toString = toString.concat(" * Do not edit." + LINE_SEPARATOR);
		toString = toString.concat(" */" + LINE_SEPARATOR);
		toString = toString.concat("package " + packageName + ";"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		if (attributes.size() != 0
				&& hasAttribute(null, attributes, AttributeType.CALENDAR) == true) {
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat("import java.text.ParseException;"
					+ LINE_SEPARATOR);
			toString = toString.concat("import java.text.SimpleDateFormat;"
					+ LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat("import java.util.Calendar;"
					+ LINE_SEPARATOR);
			toString = toString.concat("import java.util.Date;"
					+ LINE_SEPARATOR);
		}

		if (hasAttribute(null, attributes, AttributeType.STRING) == true) {
			toString = toString.concat("import java.nio.charset.Charset;"
					+ LINE_SEPARATOR);
		}

		toString = toString.concat("import java.util.ArrayList;"
				+ LINE_SEPARATOR);
		toString = toString
				.concat("import java.util.EnumSet;" + LINE_SEPARATOR);
		toString = toString
				.concat("import java.util.HashMap;" + LINE_SEPARATOR);
		toString = toString.concat("import java.util.List;" + LINE_SEPARATOR);
		toString = toString.concat("import java.util.Map;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat("import org.apache.log4j.Logger;"
				+ LINE_SEPARATOR);

		if (isSubType == false) {
			toString = toString
					.concat("import org.antlr.runtime.ANTLRStringStream;"
							+ LINE_SEPARATOR);
			toString = toString
					.concat("import org.antlr.runtime.CommonTokenStream;"
							+ LINE_SEPARATOR);
			toString = toString
					.concat("import org.antlr.runtime.RecognitionException;"
							+ LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString
					.concat("import com.viacron.utils.StringMessageBuffer.parser.AbstractAttribute;"
							+ LINE_SEPARATOR);
			toString = toString
					.concat("import com.viacron.utils.StringMessageBuffer.parser.Element;"
							+ LINE_SEPARATOR);
			toString = toString
					.concat("import com.viacron.utils.StringMessageBuffer.parser.KeyValuePair;"
							+ LINE_SEPARATOR);
			toString = toString
					.concat("import com.viacron.utils.StringMessageBuffer.parser.SMBGLexer;"
							+ LINE_SEPARATOR);
			toString = toString
					.concat("import com.viacron.utils.StringMessageBuffer.parser.SMBGParser;"
							+ LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat("/**" + LINE_SEPARATOR);
			toString = toString
					.concat(" * The "
							+ className
							+ " class defines a message of the messaging system defined"
							+ LINE_SEPARATOR);
			toString = toString.concat(" * by the " + grammarName
					+ " grammar. It provides methods for packing a "
					+ className + " object" + LINE_SEPARATOR);
			toString = toString
					.concat(" * into a byte array or string, and for unpacking a byte array or string"
							+ LINE_SEPARATOR);
			toString = toString.concat(" * back into a " + className
					+ " object." + LINE_SEPARATOR);
			toString = toString.concat(" */" + LINE_SEPARATOR);
		} else {
			toString = toString.concat("/**" + LINE_SEPARATOR);
			toString = toString
					.concat(" * The "
							+ className
							+ " class is a SubType referenced by message objects defined"
							+ LINE_SEPARATOR);
			toString = toString.concat(" * by the " + grammarName + " grammar."
					+ LINE_SEPARATOR);
			toString = toString.concat(" */" + LINE_SEPARATOR);
		}

		toString = toString.concat("public class " + className + " {"
				+ LINE_SEPARATOR);
		theLevel++;

		toString = toString.concat(getPad()
				+ "private static final String CLAZZ = \"" + className + "\";"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private static final int ID = "
				+ rootClass + "Enum." + handleCamelCase(className)
				+ ".getId();" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * The number of bits required to represent the "
				+ className + "Enum IDs." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * # of attributes: "
				+ attributes.size() + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * # of PEnumRefs: "
				+ penumRefs.size() + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private static final int ID_BITS = "
				+ log2(attributes.size() + penumRefs.size()) + ";"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(initializeDirectoryInfoItems(isSubType,
				attributes, penumRefs));
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad() + "private " + rootClass
				+ "DirectoryEntry[] theDirectory;" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private static final int DIRECTORY_OFFSET = "
				+ getDirectoryOffset(attributes, penumRefs, isSubType) + ";"
				+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(getPad()
				+ "private static Logger log4j = Logger.getLogger(" + className
				+ ".class);" + LINE_SEPARATOR);

		if (hasAttribute(null, attributes, AttributeType.CALENDAR) == true) {
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ "SimpleDateFormat formatter = new SimpleDateFormat(\""
					+ dateFormatString + "\");" + LINE_SEPARATOR);
		}

		if (attributes.size() != 0 || penumRefs.size() != 0) {
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat(getPad() + "// The attribute IDs."
					+ LINE_SEPARATOR);
			toString = toString.concat(buildAttributeIDs(className, attributes,
					penumRefs));

			toString = toString.concat(LINE_SEPARATOR);

			toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + " * The instance variables."
					+ LINE_SEPARATOR);
			toString = toString
					.concat(getPad()
							+ " * See buildInstanceVariables() in JByteByByteGenerator.java."
							+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
			toString = toString.concat(buildInstanceVariables(attributes,
					penumRefs));
		}

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private String theErrorMsg;"
				+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * The " + className
				+ " no-arg constructor." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public " + className + "() {}"
				+ LINE_SEPARATOR);

		if (attributes.size() != 0 || penumRefs.size() != 0) {
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + " * The " + className
					+ " constructor." + LINE_SEPARATOR);
			toString = toString
					.concat(getPad()
							+ " * See buildParameterAnnotations() in JByteByByteGenerator.java."
							+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
			toString = toString.concat(buildParameterAnnotations(attributes,
					penumRefs));
			toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ "public "
					+ className
					+ "("
					+ buildParameterList(className.length(), attributes,
							penumRefs) + LINE_SEPARATOR);
			theLevel++;
			toString = toString.concat(buildParameterAssignments(attributes,
					penumRefs) + LINE_SEPARATOR);
			theLevel--;
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);

			if (isSubType == true) {
				toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
				toString = toString.concat(getPad() + " * The " + className
						+ " copy constructor." + LINE_SEPARATOR);
				toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
				toString = toString.concat(getPad() + "public " + className
						+ "(" + className + " " + toFirstLower(className)
						+ ") {" + LINE_SEPARATOR);
				theLevel++;
				toString = toString
						.concat(buildCopyConstructorParameterAssignments(
								className, attributes, penumRefs)
								+ LINE_SEPARATOR);
				theLevel--;
				toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			}
		}

		toString = toString.concat(buildSetErrorMsgMethod());
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(buildGetErrorMsgMethod());
		toString = toString.concat(LINE_SEPARATOR);

		toString = toString.concat(buildPackMethod(className, attributes,
				penumRefs, isSubType));

		toString = toString.concat(buildUnpackMethod(className, attributes,
				penumRefs, isSubType));

		if (isSubType == false) {
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat(buildPackStrMethod(className,
					attributes.size(), penumRefs.size()));
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat(buildUnpackStrMethod(className,
					attributes.size(), penumRefs.size()));

			toString = toString.concat(LINE_SEPARATOR);
			toString = toString
					.concat(getPad()
							+ "private String buildString(AbstractAttribute attr, String msg) {"
							+ LINE_SEPARATOR);
			theLevel++;
			toString = toString.concat(getPad()
					+ "for (KeyValuePair kvp : attr.getKeyValuePairs()) {"
					+ LINE_SEPARATOR);
			toString = toString
					.concat(getPad(1)
							+ "msg = msg.concat(\" \" + kvp.getKey() + \":\" + kvp.getValue());"
							+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ "for (Element element : attr.getElements()) {"
					+ LINE_SEPARATOR);
			theLevel++;
			toString = toString.concat(getPad()
					+ "msg = msg.concat(\" {\" + element.getName());"
					+ LINE_SEPARATOR);
			toString = toString
					.concat(getPad()
							+ "for (AbstractAttribute abstractAttribute : element.getAbstractAttributes()) {"
							+ LINE_SEPARATOR);
			toString = toString.concat(getPad(1)
					+ "msg = buildString(abstractAttribute, msg);"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "msg = msg.concat(\"}\");"
					+ LINE_SEPARATOR);
			theLevel--;
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat(getPad() + "return msg;"
					+ LINE_SEPARATOR);

			theLevel--;
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		}
		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * Generate the attribute setters
		 */
		for (Attribute attribute : listOfAttributes) {
			String attrNameFirstUpper = toFirstUpper(attribute.getName());
			toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ " * This method sets the "
					+ attribute.getName()
					+ " attribute. Setting of this value is "
					+ (attribute.getOptional() == null ? "required"
							: "optional") + "." + LINE_SEPARATOR);
			toString = toString.concat(getPad() + " * @param "
					+ attribute.getName() + " The " + attribute.getName()
					+ " attribute." + LINE_SEPARATOR);
			toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);

			String attributeType = toFirstUpper(attribute.getAttributeType()
					.getLiteral());
			if (attributeType
					.equals(toFirstUpper(AttributeType.CHAR.toString()))) {
				attributeType = "Character";
			}

			toString = toString.concat(getPad()
					+ "public void set"
					+ attrNameFirstUpper
					+ "("
					+ (attribute.getListOf() != null ? "List<" + attributeType
							+ ">" : attributeType) + " " + attribute.getName()
					+ ") {" + LINE_SEPARATOR);
			toString = toString.concat(getPad(1) + "this."
					+ attribute.getName() + " = " + attribute.getName() + ";"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
		}

		/*
		 * Generate the attribute getters
		 */
		for (Attribute attribute : listOfAttributes) {
			String attrNameFirstUpper = toFirstUpper(attribute.getName());
			String attributeType = toFirstUpper(attribute.getAttributeType()
					.getLiteral());
			if (attributeType
					.equals(toFirstUpper(AttributeType.CHAR.toString()))) {
				attributeType = "Character";
			}
			toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ " * This method gets the "
					+ attribute.getName()
					+ " attribute. The "
					+ attribute.getName()
					+ " attribute is "
					+ (attribute.getOptional() == null ? "a required"
							: "an optional") + " attribute." + LINE_SEPARATOR);
			toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ "public "
					+ (attribute.getListOf() != null ? "List<" + attributeType
							+ ">" : attributeType) + " get"
					+ attrNameFirstUpper + "() {" + LINE_SEPARATOR);
			theLevel++;

			if (attribute.getListOf() != null) {
				toString = toString.concat(getPad() + "if (this."
						+ attribute.getName() + " == null) {" + LINE_SEPARATOR);
				toString = toString
						.concat(getPad(1)
								+ "this."
								+ attribute.getName()
								+ " = new ArrayList<"
								+ toFirstUpper(attribute.getAttributeType() == AttributeType.CHAR ? "Character"
										: attribute.getAttributeType()
												.getLiteral()) + ">();"
								+ LINE_SEPARATOR);
				toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			}

			toString = toString.concat(getPad() + "return this."
					+ attribute.getName() + ";" + LINE_SEPARATOR);
			theLevel--;
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
		}

		/*
		 * Generate the sub-type setters
		 */
		for (SubTypeRef subTypeRef : listOfSubTypes) {
			toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ " * This method sets the "
					+ subTypeRef.getName()
					+ " attribute. Setting of this value is "
					+ (subTypeRef.getOptional() == null ? "required"
							: "optional") + "." + LINE_SEPARATOR);
			toString = toString.concat(getPad() + " * @param "
					+ subTypeRef.getName() + " The " + subTypeRef.getName()
					+ "." + LINE_SEPARATOR);
			toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);

			if (subTypeRef.getListOf() != null) {
				toString = toString.concat(getPad() + "public void set"
						+ toFirstUpper(subTypeRef.getName()) + "(List<"
						+ subTypeRef.getSubType().getName() + "> "
						+ subTypeRef.getName() + ") {" + LINE_SEPARATOR);
				toString = toString.concat(getPad(1) + "this."
						+ subTypeRef.getName() + " = " + subTypeRef.getName()
						+ ";" + LINE_SEPARATOR);
			} else {
				toString = toString.concat(getPad() + "public void set"
						+ toFirstUpper(subTypeRef.getName()) + "("
						+ subTypeRef.getSubType().getName() + " "
						+ subTypeRef.getName() + ") {" + LINE_SEPARATOR);
				toString = toString.concat(getPad(1) + "this."
						+ subTypeRef.getName() + " = " + subTypeRef.getName()
						+ ";" + LINE_SEPARATOR);
			}

			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
		}

		/*
		 * Generate the sub-type getters
		 */
		for (SubTypeRef subTypeRef : listOfSubTypes) {
			toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ " * This method gets the "
					+ subTypeRef.getName()
					+ " attribute. The "
					+ subTypeRef.getName()
					+ " attribute is "
					+ (subTypeRef.getOptional() == null ? "a required"
							: "an optional") + " attribute." + LINE_SEPARATOR);
			toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);

			if (subTypeRef.getListOf() != null) {
				toString = toString.concat(getPad() + "public List<"
						+ subTypeRef.getSubType().getName() + "> get"
						+ toFirstUpper(subTypeRef.getName()) + "() {"
						+ LINE_SEPARATOR);
				theLevel++;
				toString = toString
						.concat(getPad() + "if (this." + subTypeRef.getName()
								+ " == null) {" + LINE_SEPARATOR);
				toString = toString.concat(getPad(1) + "this."
						+ subTypeRef.getName() + " = new ArrayList<"
						+ subTypeRef.getSubType().getName() + ">();"
						+ LINE_SEPARATOR);
				toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
				toString = toString.concat(getPad() + "return this."
						+ subTypeRef.getName() + ";" + LINE_SEPARATOR);
			} else {
				toString = toString.concat(getPad() + "public "
						+ subTypeRef.getSubType().getName() + " get"
						+ toFirstUpper(subTypeRef.getName()) + "() {"
						+ LINE_SEPARATOR);
				theLevel++;
				toString = toString.concat(getPad() + "return this."
						+ subTypeRef.getName() + ";" + LINE_SEPARATOR);
			}

			theLevel--;
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
		}

		/*
		 * Generate the enum setters
		 */
		for (PEnumRef penumRef : penumRefs) {
			toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
			toString = toString
					.concat(getPad()
							+ " * This method sets the "
							+ penumRef.getName()
							+ " attribute. Setting of this value is "
							+ (penumRef.getOptional() == null ? "required"
									: "optional") + "." + LINE_SEPARATOR);
			toString = toString.concat(getPad() + " * @param "
					+ penumRef.getName() + " The " + penumRef.getName() + "."
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "public void set"
					+ toFirstUpper(penumRef.getName()) + "("
					+ penumRef.getPenum().getName() + " " + penumRef.getName()
					+ ") {" + LINE_SEPARATOR);
			toString = toString.concat(getPad(1) + "this." + penumRef.getName()
					+ " = " + penumRef.getName() + ";" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
		}

		/*
		 * Generate the enum getters
		 */
		for (PEnumRef penumRef : penumRefs) {
			toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ " * This method gets the "
					+ penumRef.getName()
					+ " attribute. The "
					+ penumRef.getName()
					+ " attribute is "
					+ (penumRef.getOptional() == null ? "a required"
							: "an optional") + " attribute." + LINE_SEPARATOR);
			toString = toString.concat(getPad() + " * @return The "
					+ penumRef.getName() + " attribute." + LINE_SEPARATOR);
			toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "public "
					+ penumRef.getPenum().getName() + " get"
					+ toFirstUpper(penumRef.getName()) + "() {"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad(1) + "return this."
					+ penumRef.getName() + ";" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
		}

		/*
		 * Generate a method that returns the size of the directory.
		 */
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * This method gets the size of the directory."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private int get" + className
				+ "DirectorySize() {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "int directorySize = 0;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		for (AbstractAttribute abstractAttribute : attributes) {
			if (abstractAttribute instanceof Attribute) {
				Attribute attribute = (Attribute) abstractAttribute;
				AttributeType primitiveType = attribute.getAttributeType();
				boolean isList = attribute.getListOf() != null;

				if (isDirectoryEntry(abstractAttribute) == true) {
					toString = toString.concat(getPad() + "// "
							+ attribute.getName() + LINE_SEPARATOR);
					/*
					 * Handle optional primitives that aren't in lists and
					 * aren't strings.
					 */
					if (isList == true && primitiveType == AttributeType.STRING) {
						toString = toString.concat(getPad()
								+ "directorySize += (get"
								+ toFirstUpper(attribute.getName())
								+ "().size() == 0 ? 1 : get"
								+ toFirstUpper(attribute.getName())
								+ "().size());" + LINE_SEPARATOR);
					} else {
						toString = toString.concat(getPad()
								+ "directorySize++;" + LINE_SEPARATOR);
					}
				}
			} else if (abstractAttribute instanceof SubTypeRef) {
				SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;
				toString = toString.concat(getPad() + "// "
						+ subTypeRef.getName() + LINE_SEPARATOR);

				if (subTypeRef.getListOf() == null) {
					toString = toString.concat(getPad() + "directorySize++;"
							+ LINE_SEPARATOR);
				} else {
					toString = toString.concat(getPad()
							+ "directorySize += (get"
							+ toFirstUpper(subTypeRef.getName())
							+ "().size() == 0 ? 1 : get"
							+ toFirstUpper(subTypeRef.getName())
							+ "().size());" + LINE_SEPARATOR);
				}
			}
		}

		for (PEnumRef penumRef : penumRefs) {
			if (penumRef.getOptional() != null) {
				toString = toString.concat(getPad() + "// "
						+ penumRef.getName() + LINE_SEPARATOR);
				toString = toString.concat(getPad() + "directorySize++;"
						+ LINE_SEPARATOR);
			}
		}

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return directorySize;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * Build the get<ClassName>Size() method
		 */
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * This method gets the size of the " + className
				+ " object." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The size in bytes."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public int get" + className
				+ "Size() {" + LINE_SEPARATOR);
		theLevel++;

		toString = toString.concat(getPad() + "final String METHOD = \"get"
				+ className + "Size()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);

		String sizeVariable = "_" + toFirstLower(className) + "Size";
		toString = toString.concat(getPad() + "int " + sizeVariable + " = 0;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "int size = 0;" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		boolean isDirectory = false;
		for (AbstractAttribute abstractAttribute : attributes) {
			if (isDirectoryEntry(abstractAttribute) == true) {
				isDirectory = true;
				break;
			}
		}

		toString = toString.concat(getPad() + "// isDirectory = " + isDirectory
				+ LINE_SEPARATOR);

		if (isDirectory) {
			toString = toString.concat(getPad() + "int directorySize = get"
					+ className + "DirectorySize();" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + sizeVariable
					+ " = DIRECTORY_OFFSET;" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + sizeVariable
					+ " += directorySize * " + rootClass
					+ "DirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;"
					+ LINE_SEPARATOR);

			for (AbstractAttribute abstractAttribute : attributes) {
				if (abstractAttribute instanceof Attribute) {
					Attribute attribute = (Attribute) abstractAttribute;
					AttributeType primitiveType = attribute.getAttributeType();
					boolean isList = attribute.getListOf() != null;

					if (isDirectoryEntry(abstractAttribute) == true) {
						toString = toString.concat(getPad() + "// "
								+ attribute.getName()
								+ (isList == true ? " is a list" : "")
								+ LINE_SEPARATOR);

						if (isList == false) {
							String getLengthString;
							/*
							 * By default, build the method that gets the length
							 * of the attribute if the attribute is a string,
							 * otherwise use the length of the primitive type.
							 */
							if (primitiveType == AttributeType.STRING) {
								String getter = "this.get"
										+ toFirstUpper(attribute.getName())
										+ "()";
								getLengthString = getter + " != null ? "
										+ getter + ".length() : 0";
							} else {
								/*
								 * Handle optional primitives that aren't
								 * strings.
								 */
								getLengthString = getPrimitiveSize(primitiveType
										.getLiteral());
							}

							toString = toString.concat(getPad() + "size = "
									+ getLengthString + ";" + LINE_SEPARATOR);
							toString = toString
									.concat(getPad()
											+ "log4j.debug(String.format(\" %s size: %d\", \""
											+ attribute.getName()
											+ "\", size));" + LINE_SEPARATOR);
							toString = toString.concat(getPad() + sizeVariable
									+ " += size;" + LINE_SEPARATOR);
						} else {
							/*
							 * Handle lists of strings
							 */
							if (primitiveType == AttributeType.STRING) {
								toString = toString.concat(getPad()
										+ "if (this.get"
										+ toFirstUpper(attribute.getName())
										+ "().size() != 0) {" + LINE_SEPARATOR);
								theLevel++;
								toString = toString.concat(getPad()
										+ "for (String " + attribute.getName()
										+ " : this.get"
										+ toFirstUpper(attribute.getName())
										+ "()) {" + LINE_SEPARATOR);
								theLevel++;

								toString = toString.concat(getPad() + "size = "
										+ attribute.getName() + ".length();"
										+ LINE_SEPARATOR);
								toString = toString
										.concat(getPad()
												+ "log4j.debug(String.format(\" %s size: %d\", \""
												+ attribute.getName()
												+ "\", size));"
												+ LINE_SEPARATOR);
								toString = toString.concat(getPad()
										+ sizeVariable + " += size;"
										+ LINE_SEPARATOR);

								theLevel--;
								toString = toString.concat(getPad() + "}"
										+ LINE_SEPARATOR);
								theLevel--;
								toString = toString.concat(getPad() + "}"
										+ LINE_SEPARATOR);
							} else {
								/*
								 * Handle lists of primitives
								 */toString = toString.concat(getPad() + "if ("
										+ attribute.getName() + " != null && "
										+ attribute.getName()
										+ ".size() != 0) {" + LINE_SEPARATOR);
								theLevel++;

								toString = toString
										.concat(getPad()
												+ "// size: "
												+ attribute.getName()
												+ ".size() * "
												+ getPrimitiveSize(primitiveType
														.getLiteral())
												+ LINE_SEPARATOR);

								toString = toString.concat(getPad()
										+ "size = "
										+ attribute.getName()
										+ ".size() * "
										+ getPrimitiveSize(primitiveType
												.getLiteral()) + ";"
										+ LINE_SEPARATOR);
								toString = toString
										.concat(getPad()
												+ "log4j.debug(String.format(\" %s size: %d\", \""
												+ attribute.getName()
												+ "\", size));"
												+ LINE_SEPARATOR);
								toString = toString.concat(getPad()
										+ sizeVariable + " += size;"
										+ LINE_SEPARATOR);

								theLevel--;
								toString = toString.concat(getPad() + "}"
										+ LINE_SEPARATOR);
							}
						}
					}
				} else if (abstractAttribute instanceof SubTypeRef) {
					SubTypeRef subTypeRef = (SubTypeRef) abstractAttribute;
					boolean isList = subTypeRef.getListOf() != null;
					toString = toString.concat(getPad() + "// isList: "
							+ isList + LINE_SEPARATOR);

					if (toFirstUpper(subTypeRef.getSubType().getName()).equals(
							className) == true
							&& isList == false) {
						toString = toString.concat(getPad()
								+ "// Ignoring self-reference: "
								+ subTypeRef.getName() + LINE_SEPARATOR);
					} else {
						toString = toString.concat(getPad() + "// "
								+ subTypeRef.getName() + LINE_SEPARATOR);
						if (isList == false) {
							toString = toString.concat(getPad()
									+ "size = this.get"
									+ toFirstUpper(subTypeRef.getName())
									+ "() != null ? this.get"
									+ toFirstUpper(subTypeRef.getName())
									+ "().get"
									+ toFirstUpper(subTypeRef.getSubType()
											.getName()) + "Size() : 0;"
									+ LINE_SEPARATOR);
							toString = toString
									.concat(getPad()
											+ "log4j.debug(String.format(\" %s size: %d\", \""
											+ subTypeRef.getSubType().getName()
											+ "\", size));" + LINE_SEPARATOR);
							toString = toString.concat(getPad() + sizeVariable
									+ " += size;" + LINE_SEPARATOR);
						} else {
							toString = toString.concat(getPad()
									+ "if (this.get"
									+ toFirstUpper(subTypeRef.getName())
									+ "().size() != 0) {" + LINE_SEPARATOR);
							theLevel++;
							toString = toString.concat(getPad() + "for ("
									+ subTypeRef.getSubType().getName() + " "
									+ subTypeRef.getName()
									+ subTypeRef.getSubType().getName()
									+ " : this.get"
									+ toFirstUpper(subTypeRef.getName())
									+ "()) {" + LINE_SEPARATOR);

							toString = toString.concat(getPad(1) + "size = "
									+ subTypeRef.getName()
									+ subTypeRef.getSubType().getName()
									+ ".get"
									+ subTypeRef.getSubType().getName()
									+ "Size();" + LINE_SEPARATOR);
							toString = toString
									.concat(getPad(1)
											+ "log4j.debug(String.format(\" %s size: %d\", \""
											+ subTypeRef.getSubType().getName()
											+ "\", size));" + LINE_SEPARATOR);
							toString = toString.concat(getPad(1) + sizeVariable
									+ " += size;" + LINE_SEPARATOR);
							toString = toString.concat(getPad() + "}"
									+ LINE_SEPARATOR);
							theLevel--;

							toString = toString.concat(getPad() + "}"
									+ LINE_SEPARATOR);
						}
					}
				}
			}

			for (PEnumRef penumRef : penumRefs) {
				// TODO for now, enums are stored in an integer
				toString = toString.concat(getPad() + "// "
						+ penumRef.getName() + ";" + LINE_SEPARATOR);
				int sizeInBytes = log8(penumRef.getPenum().getElements().size());
				sizeInBytes = 4;

				toString = toString.concat(getPad() + "size = " + sizeInBytes
						+ ";" + LINE_SEPARATOR);
				toString = toString.concat(getPad()
						+ "log4j.debug(String.format(\" %s size: %d\", \""
						+ penumRef.getName() + "\", size));" + LINE_SEPARATOR);
				toString = toString.concat(getPad() + sizeVariable
						+ " += size;" + LINE_SEPARATOR);
			}
		} else {
			toString = toString.concat(getPad() + sizeVariable + " = 0;"
					+ LINE_SEPARATOR);

			for (AbstractAttribute abstractAttribute : attributes) {
				if (abstractAttribute instanceof Attribute) {
					Attribute attribute = (Attribute) abstractAttribute;
					AttributeType attributeType = attribute.getAttributeType();
					String primitiveType = attributeType.getLiteral();
					String typeName = toFirstUpper(primitiveType
							.equals(AttributeType.CHAR.toString()) ? "Character"
							: attribute.getAttributeType().getLiteral());
					boolean isOptional = (attribute.getOptional() != null);

					if (isDirectoryEntry(abstractAttribute) == false) {
						if (isOptional == false) {
							toString = toString.concat(getPad()
									+ "if (this.get"
									+ toFirstUpper(attribute.getName())
									+ "() != null) {" + LINE_SEPARATOR);
							theLevel++;
						}

						toString = toString.concat(getPad() + "// "
								+ attribute.getName() + LINE_SEPARATOR);

						if (attributeType == AttributeType.BOOLEAN) {
							toString = toString.concat(getPad() + sizeVariable
									+ " += 1;" + LINE_SEPARATOR);
						} else if (attributeType == AttributeType.BYTE) {
							toString = toString.concat(getPad() + sizeVariable
									+ " += 1;" + LINE_SEPARATOR);
						} else {
							toString = toString.concat(getPad() + sizeVariable
									+ " += " + getPrimitiveSize(primitiveType)
									+ ";" + LINE_SEPARATOR);
						}
						theLevel--;
						toString = toString.concat(getPad() + "}"
								+ LINE_SEPARATOR);

						toString = toString.concat(LINE_SEPARATOR);
					}
				}
			}

			for (PEnumRef penumRef : penumRefs) {
				toString = toString.concat(getPad() + "// "
						+ penumRef.getName() + ";" + LINE_SEPARATOR);
				boolean isOptional = (penumRef.getOptional() != null);
				if (isOptional == false) {
					int sizeInBytes = log8(penumRef.getPenum().getElements()
							.size());
					sizeInBytes = 4;

					toString = toString.concat(getPad() + sizeVariable + " += "
							+ sizeInBytes + ";" + LINE_SEPARATOR);
				}
			}
		}

		if (isSubType == false) {
			toString = toString.concat(getPad() + "// Add two bytes for the ID"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + sizeVariable + " += 2;"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ "// Add eight bytes for the CRC" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + sizeVariable + " += 8;"
					+ LINE_SEPARATOR);
		}

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return " + sizeVariable + ";"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		/*
		 * Build the toString() method
		 */
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "@Override" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public String toString() {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "StringBuilder result = new StringBuilder();"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "String NEW_LINE = System.getProperty(\"line.separator\");"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "result.append(this.getClass().getSimpleName() + \" Object {\" + NEW_LINE);"
						+ LINE_SEPARATOR);
		toString = toString.concat(buildToStringMethod(attributes, penumRefs));
		toString = toString.concat(getPad() + "result.append(\"} \");"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return result.toString();"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * Build the hashCode method
		 */
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * The hashCode method returns this object's hashCode."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "@Override" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public int hashCode() {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "final int prime = 31;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "int result = 1;"
				+ LINE_SEPARATOR);

		for (Attribute attribute : listOfAttributes) {
			String attributeType = attribute.getAttributeType().getLiteral();

			if (attributeType.equals(AttributeType.CHAR.toString())) {
				attributeType = "Character";
			} else {
				attributeType = toFirstUpper(attribute.getAttributeType()
						.getLiteral());
			}

			toString = toString.concat(LINE_SEPARATOR);

			if (attribute.getAttributeType() == AttributeType.STRING) {
				toString = toString.concat(getPad() + "if ("
						+ attribute.getName() + " != null) {" + LINE_SEPARATOR);
				theLevel++;
			}

			if (attribute.getListOf() == null) {
				toString = toString.concat(getPad() + "result = prime * result"
						+ LINE_SEPARATOR);
				toString = toString.concat(getPad(1) + "+ ((" + attributeType
						+ ") " + attribute.getName() + ").hashCode();"
						+ LINE_SEPARATOR);

			} else {
				toString = toString.concat(getPad() + "for (" + attributeType
						+ " " + attributeType.toLowerCase().substring(0, 1)
						+ " : " + attribute.getName() + ") {" + LINE_SEPARATOR);

				toString = toString.concat(getPad(1)
						+ "result = prime * result + "
						+ attributeType.toLowerCase().substring(0, 1)
						+ ".hashCode();" + LINE_SEPARATOR);

				toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			}

			if (attribute.getAttributeType() == AttributeType.STRING) {
				theLevel--;
				toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			}
		}

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "return result;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		/*
		 * Build the equals() method
		 */
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + " * The equals method checks for equality. "
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "public boolean equals(Object obj) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "if (obj == this) return true;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (obj == null) return false;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "if (getClass() != obj.getClass()) return false;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + className + " "
				+ toFirstLower(className) + " = (" + className + ") obj;"
				+ LINE_SEPARATOR);

		for (Attribute attribute : listOfAttributes) {
			String attrNameFirstUpper = toFirstUpper(attribute.getName());
			if (attribute.getAttributeType() == AttributeType.STRING) {
				if (attribute.getOptional() != null) {
					toString = toString.concat(getPad() + "if ("
							+ toFirstLower(className) + ".get"
							+ attrNameFirstUpper + "() == null && this.get"
							+ attrNameFirstUpper + "() != null) {"
							+ LINE_SEPARATOR);
					toString = toString.concat(getPad(1) + "return false;"
							+ LINE_SEPARATOR);
					toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
					toString = toString.concat(getPad() + "else if ("
							+ toFirstLower(className) + ".get"
							+ attrNameFirstUpper + "() != null && this.get"
							+ attrNameFirstUpper + "() == null) {"
							+ LINE_SEPARATOR);
					toString = toString.concat(getPad(1) + "return false;"
							+ LINE_SEPARATOR);
					toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
					toString = toString.concat(getPad() + "else if ("
							+ toFirstLower(className) + ".get"
							+ attrNameFirstUpper + "() != null && "
							+ LINE_SEPARATOR);
					toString = toString.concat(getPad() + "!"
							+ toFirstLower(className) + ".get"
							+ attrNameFirstUpper + "().equals(this.get"
							+ attrNameFirstUpper + "())) {" + LINE_SEPARATOR);
					toString = toString.concat(getPad(1) + "return false;"
							+ LINE_SEPARATOR);
					toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
				} else {
					toString = toString.concat(getPad() + "if (!"
							+ toFirstLower(className) + ".get"
							+ attrNameFirstUpper + "().equals(this.get"
							+ attrNameFirstUpper + "())) {" + LINE_SEPARATOR);
					toString = toString.concat(getPad(1) + "return false;"
							+ LINE_SEPARATOR);
					toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
				}
			} else {
				toString = toString.concat(getPad() + "if ("
						+ toFirstLower(className) + ".get" + attrNameFirstUpper
						+ "() != this.get" + attrNameFirstUpper + "()) {"
						+ LINE_SEPARATOR);
				toString = toString.concat(getPad(1) + "return false;"
						+ LINE_SEPARATOR);
				toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			}
			toString = toString.concat(LINE_SEPARATOR);
		}

		for (PEnumRef penumRef : penumRefs) {
			toString = toString.concat(getPad() + "if ("
					+ toFirstLower(className) + ".get"
					+ toFirstUpper(penumRef.getName()) + "() != this.get"
					+ toFirstUpper(penumRef.getName()) + "()) {"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad(1) + "return false;"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
		}
		toString = toString.concat(getPad() + "return true;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat("}" + LINE_SEPARATOR);

		return toString;
	}

	private String generateEnumFile(String packageName, String enumName,
			EList<PEnumElement> elements) {
		theLevel = 0;
		String toString = "";
		toString = toString.concat("/*" + LINE_SEPARATOR);
		toString = toString
				.concat(" * WARNING: This file was generated by JByteByByteGenerator.java (see"
						+ LINE_SEPARATOR);
		toString = toString.concat(" * generateEnumFile()). " + LINE_SEPARATOR);
		toString = toString.concat(" * Do not edit." + LINE_SEPARATOR);
		toString = toString.concat(" */" + LINE_SEPARATOR);
		toString = toString.concat("package " + packageName + ";"
				+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "import java.util.EnumSet;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "import java.util.HashMap;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "import java.util.Map;"
				+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat("public enum " + enumName + " {"
				+ LINE_SEPARATOR);
		theLevel++;

		int id = 0;
		for (PEnumElement element : elements) {
			toString = toString.concat(getPad() + " "
					+ handleCamelCase(element.getName()) + "(" + id + ", \""
					+ element.getName() + "\")")
					+ (elements.get(elements.size() - 1).getName()
							.equals(element.getName()) == false ? "," : ";");
			toString = toString.concat(LINE_SEPARATOR);
			id++;
		}

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private static final Map<Integer, " + enumName
				+ "> lookup = new HashMap<Integer, " + enumName + ">();"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "static {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "for (" + enumName
				+ " enumType : EnumSet.allOf(" + enumName + ".class)) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "lookup.put(enumType.getId(), enumType);" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private final int id;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private final String value;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + enumName + "(int id, String v) {"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad(1) + "this.id = id;" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "this.value = v;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public int getId() {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "return this.id;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public String value() {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "return this.value;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public static " + enumName
				+ " fromValue(String v) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "for (" + enumName + " "
				+ toFirstLower(enumName) + " : " + enumName + ".values()) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "if (" + toFirstLower(enumName)
				+ ".value.equals(v)) {" + LINE_SEPARATOR);
		toString = toString.concat(getPad(1) + "   return "
				+ toFirstLower(enumName) + ";" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "throw new IllegalArgumentException(v);" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public static " + enumName
				+ " toEnum(int id) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "return lookup.get(id);"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		theLevel--;
		toString = toString.concat("}" + LINE_SEPARATOR);

		return toString;
	}

	private String generateInitializationFile(String packageName, Message msg) {
		theLevel = 0;
		String toString = "";

		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * WARNING: This file was generated by JByteByByteGenerator.java (see"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * generateInitializationFile()). " + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * Do not edit."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "package " + packageName + ";"
				+ LINE_SEPARATOR);
		if (msg.getAttributes().size() != 0) {
			if (hasAttribute(null, msg.getAttributes(), AttributeType.CALENDAR) == true) {
				toString = toString.concat(LINE_SEPARATOR);
				toString = toString.concat(getPad()
						+ "import java.text.ParseException;" + LINE_SEPARATOR);
				toString = toString
						.concat(getPad() + "import java.text.SimpleDateFormat;"
								+ LINE_SEPARATOR);
				toString = toString.concat(LINE_SEPARATOR);
				toString = toString.concat(getPad()
						+ "import java.util.Calendar;" + LINE_SEPARATOR);
				toString = toString.concat(getPad() + "import java.util.Date;"
						+ LINE_SEPARATOR);
			}
		}
		toString = toString.concat(getPad() + "import java.util.ArrayList;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "import java.util.List;"
				+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "import org.apache.log4j.Logger;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "import com.viacron.utils.StringMessageBuffer.parser.AbstractAttribute;"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "import com.viacron.utils.StringMessageBuffer.parser.Element;"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "import com.viacron.utils.StringMessageBuffer.parser.KeyValuePair;"
						+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * The Initialize"
				+ msg.getName()
				+ " class initializes the element object with the "
				+ msg.getName() + " object." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public class Initialize"
				+ msg.getName() + " {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "private static Logger log4j = Logger.getLogger(Initialize"
				+ msg.getName() + ".class);" + LINE_SEPARATOR);

		toString = toString.concat(getPad() + "private String theErrorMsg;"
				+ LINE_SEPARATOR);

		toString = toString.concat(getPad() + "private Element element;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private " + msg.getName() + " "
				+ toFirstLower(msg.getName()) + ";" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * The Initialize"
				+ msg.getName()
				+ " class initializes the element object with the "
				+ msg.getName() + " object." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * @param "
						+ toFirstLower(msg.getName())
						+ " The object which will be used to initialize the element object."
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public Initialize"
				+ msg.getName() + "(" + msg.getName() + " "
				+ toFirstLower(msg.getName()) + ") {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "this."
				+ toFirstLower(msg.getName()) + " = "
				+ toFirstLower(msg.getName()) + ";" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "this.element = new Element(\""
				+ msg.getName() + "\");" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * This method initializes the element." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "public Element initialize() throws MissingAttributeException {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"initialize()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"element.getName(): " + msg.getName() + "\");"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(initAttributeMethodCalls(
				toFirstLower(msg.getName()), msg.getAttributes(),
				msg.getEnums())
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return element;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(initAttributeMethods(
				toFirstLower(msg.getName()), msg.getAttributes(),
				msg.getEnums()));
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		return toString;
	}

	private String generateInstantiationFile(String packageName, Message msg) {
		theLevel = 0;
		String toString = "";
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * WARNING: This file was generated by JByteByByteGenerator.java (see"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * generateInstantiationFile()). " + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * Do not edit."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "package " + packageName + ";"
				+ LINE_SEPARATOR);

		if (msg.getAttributes().size() != 0) {
			if (hasAttribute(null, msg.getAttributes(), AttributeType.CALENDAR) == true) {
				toString = toString.concat(LINE_SEPARATOR);
				toString = toString.concat(getPad()
						+ "import java.text.ParseException;" + LINE_SEPARATOR);
				toString = toString
						.concat(getPad() + "import java.text.SimpleDateFormat;"
								+ LINE_SEPARATOR);
				toString = toString.concat(LINE_SEPARATOR);
				toString = toString.concat(getPad()
						+ "import java.util.Calendar;" + LINE_SEPARATOR);
				toString = toString.concat(getPad() + "import java.util.Date;"
						+ LINE_SEPARATOR);
			}
		}

		toString = toString.concat(getPad() + "import java.util.ArrayList;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "import java.util.List;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "import org.apache.log4j.Logger;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "import com.viacron.utils.StringMessageBuffer.parser.AbstractAttribute;"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "import com.viacron.utils.StringMessageBuffer.parser.Element;"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "import com.viacron.utils.StringMessageBuffer.parser.KeyValuePair;"
						+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public class Instantiate"
				+ msg.getName() + " {" + LINE_SEPARATOR);

		theLevel++;

		toString = toString.concat(getPad()
				+ "private static Logger log4j = Logger.getLogger(Instantiate"
				+ msg.getName() + ".class);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * The isUpdated flags. If an attribute is required by the grammar then a value"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * must be provided, and the isUpdated flag will be set when the value is"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * obtained during unpacking. After the object is constructed during unpacking, "
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * validation will be performed to make sure a value was provided for all attributes"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * that are not optional. "
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * See buildFlags() in JByteByByteGenerator.java."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(buildFlags(msg.getAttributes(),
				msg.getEnums()));
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private Element element;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private " + msg.getName() + " "
				+ toFirstLower(msg.getName()) + ";" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * The Instantiate"
				+ msg.getName() + " class instantiates the " + msg.getName()
				+ " object." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * @param element The root element returned by the parser after parsing the string"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " *                representing the " + msg.getName() + "."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public Instantiate"
				+ msg.getName() + "(Element element) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "this.element = element;   "
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "this."
				+ toFirstLower(msg.getName()) + " = new " + msg.getName()
				+ "();" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * This method instantiates the " + msg.getName() + "."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The " + msg.getName()
				+ "." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public " + msg.getName()
				+ " instantiate() {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"instantiate()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "log4j.debug(\"" + msg.getName()
				+ ": \" + element.getName());" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "log4j.debug(\"# of attributes: \" + element.getAbstractAttributes().size());"
						+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "instantiate" + msg.getName()
				+ "Attributes(element);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "for (AbstractAttribute abstractAttribute : element.getAbstractAttributes()) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "for (Element e : abstractAttribute.getElements()) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "log4j.debug(\"element name: \" + e.getName());"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "instantiate" + msg.getName()
				+ "SubTypeRefs(e);" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return "
				+ toFirstLower(msg.getName()) + ";" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * This method instantiates the " + msg.getName()
				+ " attributes." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * " + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @param Element element"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private void instantiate"
				+ msg.getName() + "Attributes(Element element) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"instantiate" + msg.getName()
				+ "Attributes()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"element name: \" + element.getName());"
				+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "for (AbstractAttribute attr : element.getAbstractAttributes()) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "for (KeyValuePair kvp : attr.getKeyValuePairs()) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "log4j.debug(\"key: \" + kvp.getKey());" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "log4j.debug(\"value: \" + kvp.getValue());"
						+ LINE_SEPARATOR);

		boolean isFirst = true;
		for (Attribute attribute : toAttributeList(msg.getAttributes())) {
			instantiationString = "";
			if (attribute.getListOf() != null) {
				toString = toString.concat(instantiateMsgAttributeList(
						toFirstLower(msg.getName()), attribute, isFirst));
			} else {
				toString = toString.concat(instantiateMsgAttribute(
						toFirstLower(msg.getName()), attribute, isFirst));
			}
			isFirst = false;
		}

		isFirst = true;
		for (PEnumRef penumRef : msg.getEnums()) {
			instantiationString = "";
			toString = toString.concat(getPad()
					+ instantiatePEnumRef(msg.getName(), penumRef, isFirst)
					+ LINE_SEPARATOR);
			isFirst = false;
		}

		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * This method instantiates the " + msg.getName()
				+ " SubType references." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * " + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @param Element element"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private void instantiate"
				+ msg.getName() + "SubTypeRefs(Element element) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"instantiate" + msg.getName()
				+ "SubTypeRefs()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);

		for (SubTypeRef subTypeRef : toSubTypeRefList(msg.getAttributes())) {
			instantiationString = "";
			if (subTypeRef.getListOf() != null) {
				toString = toString.concat(instantiateMessageSubTypeRefList(
						msg, subTypeRef));
			} else {
				toString = toString.concat(getPad()
						+ instantiateMessageSubTypeRef(msg, subTypeRef));
			}
		}

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(LINE_SEPARATOR);

		isFirst = true;
		for (SubTypeRef subTypeRef : toSubTypeRefList(msg.getAttributes())) {
			toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ " * This method instantiates the "
					+ subTypeRef.getName()
					+ " attribute"
					+ (subTypeRef.getListOf() != null ? " which is a list of "
							+ subTypeRef.getSubType().getName() : ".")
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + " * @param Element element"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
			toString = toString.concat(getPad() + "private void instantiate"
					+ toFirstUpper(subTypeRef.getName())
					+ "(Element element) {" + LINE_SEPARATOR);
			theLevel++;

			instantiationString = "";

			if (subTypeRef.getListOf() != null) {
				toString = toString.concat(getPad()
						+ instantiateSubTypeRefList(msg, subTypeRef));
			} else {
				toString = toString.concat(getPad()
						+ instantiateSubTypeRef(msg, subTypeRef.getSubType(),
								subTypeRef));
			}
			theLevel--;
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		}

		theLevel++;

		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * The validate method checks that a value was provided for all required "
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + " * attributes." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @return The error message or null if no error occurred."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "protected String validate() {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"validate()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "String result = null;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		instantiationString = "";
		toString = toString.concat(buildValidationMethod(msg.getAttributes(),
				msg.getEnums()) + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (result != null) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "log4j.debug(\"result: \" + result);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "return result;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		return toString;
	}

	private String generateSubTypeInstantiationFile(String packageName,
			SubType subType) {
		theLevel = 0;
		String toString = "";
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * WARNING: This file was generated by JByteByByteGenerator.java (see"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * generateSubTypeInstantiationFile())." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * Do not edit."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "package " + packageName + ";"
				+ LINE_SEPARATOR);

		if (subType.getAttributes().size() != 0
				&& hasAttribute(null, subType.getAttributes(),
						AttributeType.CALENDAR) == true) {
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ "import java.text.ParseException;" + LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ "import java.text.SimpleDateFormat;" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat(getPad() + "import java.util.Calendar;"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + "import java.util.Date;"
					+ LINE_SEPARATOR);
		}

		toString = toString.concat(getPad() + "import java.util.ArrayList;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "import java.util.List;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "import org.apache.log4j.Logger;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "import com.viacron.utils.StringMessageBuffer.parser.AbstractAttribute;"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "import com.viacron.utils.StringMessageBuffer.parser.Element;"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "import com.viacron.utils.StringMessageBuffer.parser.KeyValuePair;"
						+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public class Instantiate"
				+ subType.getName() + " {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "private static Logger log4j = Logger.getLogger(Instantiate"
				+ subType.getName() + ".class);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private Element element;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private " + subType.getName()
				+ " " + toFirstLower(subType.getName()) + ";" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * The isUpdated flags. If an attribute is required by the grammar then a value"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * must be provided, and the isUpdated flag will be set when the value is"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * obtained during unpacking. After the object is constructed during unpacking, "
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * validation will be performed to make sure a value was provided for all attributes"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * that are not optional. "
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * See buildFlags() in JByteByByteGenerator.java."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(buildFlags(subType.getAttributes(),
				subType.getEnums()));
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * This method constructs a Instantiate" + subType.getName()
				+ " object based on an Element" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * object." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * " + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @param element"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *            The Element."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public Instantiate"
				+ subType.getName() + "(Element element) {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "this.element = element;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "this."
				+ toFirstLower(subType.getName()) + " = new "
				+ subType.getName() + "();" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * The instantiate method instantiates a "
				+ subType.getName() + " object." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * " + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The "
				+ subType.getName() + "." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "protected " + subType.getName()
				+ " instantiate() {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"instantiate()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"element: \" + element.getName());"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "for (AbstractAttribute abstractAttribute : element.getAbstractAttributes()) {"
						+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(instantiateSubTypeElements(subType)
				+ LINE_SEPARATOR);

		toString = toString.concat(LINE_SEPARATOR);
		if (subType.getAttributes().size() != 0
				|| subType.getEnums().size() != 0) {
			toString = toString
					.concat(getPad()
							+ "for (KeyValuePair kvp : abstractAttribute.getKeyValuePairs()) {"
							+ LINE_SEPARATOR);
			theLevel++;
			toString = toString.concat(instantiateSubTypeAttributes(subType)
					+ LINE_SEPARATOR);
			theLevel--;
			toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		}
		theLevel--;

		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return "
				+ toFirstLower(subType.getName()) + ";" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * The validate method checks that a value was provided for all required "
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + " * attributes." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " *" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @return The error message or null if no error occurred."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "protected String validate() {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"validate()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "String result = null;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		instantiationString = "";
		toString = toString.concat(buildValidationMethod(
				subType.getAttributes(), subType.getEnums())
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if (result != null) {"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad(1)
				+ "log4j.debug(\"result: \" + result);" + LINE_SEPARATOR);

		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad() + "return result;" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);

		return toString;
	}

	private String generateSubTypeInitializationFile(String packageName,
			SubType subType) {
		theLevel = 0;
		String toString = "";
		toString = toString.concat(getPad() + "/*" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * WARNING: This file was generated by JByteByByteGenerator.java (see"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * generateSubTypeInitializationFile())." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * Do not edit."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "package " + packageName + ";"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		if (subType.getAttributes().size() != 0
				&& hasAttribute(null, subType.getAttributes(),
						AttributeType.CALENDAR) == true) {
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ "import java.text.ParseException;" + LINE_SEPARATOR);
			toString = toString.concat(getPad()
					+ "import java.text.SimpleDateFormat;" + LINE_SEPARATOR);
			toString = toString.concat(LINE_SEPARATOR);
			toString = toString.concat(getPad() + "import java.util.Calendar;"
					+ LINE_SEPARATOR);
			toString = toString.concat(getPad() + "import java.util.Date;"
					+ LINE_SEPARATOR);
		}
		toString = toString.concat(getPad() + "import java.util.ArrayList;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "import java.util.List;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "import org.apache.log4j.Logger;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "import com.viacron.utils.StringMessageBuffer.parser.AbstractAttribute;"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "import com.viacron.utils.StringMessageBuffer.parser.Element;"
						+ LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ "import com.viacron.utils.StringMessageBuffer.parser.KeyValuePair;"
						+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * The Initialize"
				+ subType.getName()
				+ " class initializes an Element object with a "
				+ subType.getName() + " object." + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public class Initialize"
				+ subType.getName() + " {" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "private static Logger log4j = Logger.getLogger(Initialize"
				+ subType.getName() + ".class);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private String theErrorMsg;"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + "private " + subType.getName()
				+ " " + toFirstLower(subType.getName()) + ";" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "public Initialize"
				+ subType.getName() + "(" + subType.getName() + " "
				+ toFirstLower(subType.getName()) + ") {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad() + "this."
				+ toFirstLower(subType.getName()) + " = "
				+ toFirstLower(subType.getName()) + ";" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "/**" + LINE_SEPARATOR);
		toString = toString
				.concat(getPad()
						+ " * The initialize method returns an Element object initialized with data from a"
						+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * " + subType.getName()
				+ " object." + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @param elementName The name of the element."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad() + " * @return The element."
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ " * @throws MissingAttributeException" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + " */" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "protected Element initialize(String elementName) "
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "    throws MissingAttributeException {" + LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "final String METHOD = \"initialize()\";" + LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Entered \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "Element element = null;"
				+ LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad() + "if ("
				+ toFirstLower(subType.getName()) + " != null) {"
				+ LINE_SEPARATOR);
		theLevel++;
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Creating new element: \" + elementName);"
				+ LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "element = new Element(elementName);" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(initAbstractAttributes(
				toFirstLower(subType.getName()), subType.getAttributes(),
				subType.getEnums()) + "" + LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ "log4j.debug(\"Leaving \" + METHOD);" + LINE_SEPARATOR);
		toString = toString.concat(getPad() + "return element;"
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		toString = toString.concat(LINE_SEPARATOR);
		toString = toString.concat(getPad()
				+ initAttributeMethods(toFirstLower(subType.getName()),
						subType.getAttributes(), subType.getEnums()) + ""
				+ LINE_SEPARATOR);
		theLevel--;
		toString = toString.concat(getPad() + "}" + LINE_SEPARATOR);
		return toString;
	}

	/*
	 * This method calculates the minimum number of bits required to represent a
	 * value.
	 */
	private int log2(int value) {
		return Integer.SIZE
				- Integer.numberOfLeadingZeros(value > 0 ? value - 1 : value);
	}

	/*
	 * This method calculates the minimum number of bytes required to represent
	 * a value.
	 */
	private int log8(int value) {
		int nbrOfBits = Integer.SIZE
				- Integer.numberOfLeadingZeros(value > 0 ? value - 1 : value);
		return (int) (Math.floor(nbrOfBits / 8) + 1);
	}
}