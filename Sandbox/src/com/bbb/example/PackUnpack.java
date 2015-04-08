package com.bbb.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PackUnpack {

	/** Logging */
	static Logger log4j = Logger.getLogger(PackUnpack.class);
	static final String LOG_PROPERTIES_FILE = "C:\\Users\\Scott\\Documents\\Programs\\ByteByByte\\Sandbox\\log4j\\log4j.properties";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initLogger();
		
		LogMonMessage logMonMessage = new LogMonMessage();
		logMonMessage.setTimestamp(Calendar.getInstance());
		logMonMessage.setMsg("This is a test");

		Details details = new Details();
		details.setApp("MyApp");
		details.setFacility(8);
		details.setLineNumber(9999);
		details.setModule("MyModule");
		details.setSeverity(Severity.ERROR);

		logMonMessage.setDetails(details);

		try {
			byte[] bytes = logMonMessage.pack();

			System.out.println("size: " + bytes.length);
			
			HexDump.hexDump(bytes);
			
			//System.out.println("Details hexdump:");
			//HexDump.hexDump(details.pack());

			LogMonMessage tmp = new LogMonMessage();
			LogMonMessage msg2 = tmp.unpack(bytes);
			System.out.println("msg: " + msg2.getMsg());
			
			Details d = msg2.getDetails();
			System.out.println("app: " + d.getApp());
			System.out.println("facility: " + d.getFacility());
			System.out.println("line: " + d.getLineNumber());
			System.out.println("module: " + d.getModule());
			System.out.println("severity: " + d.getSeverity());
		} catch (MissingAttributeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * This method initializes the logging subsystem.
	 */
	private static void initLogger() {

		Properties logProperties = new Properties();
		try {
			// url = new URL(LOG_PROPERTIES_URL);
			// logProperties.load(url.openConnection().getInputStream());
			logProperties.load(new FileInputStream(
					new File(LOG_PROPERTIES_FILE)));
			PropertyConfigurator.configure(logProperties);
			log4j.info("Logging initialized");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
