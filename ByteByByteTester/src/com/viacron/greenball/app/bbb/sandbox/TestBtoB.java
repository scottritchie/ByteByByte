package com.viacron.greenball.app.bbb.sandbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.viacron.greenball.app.bbb.Chat;
import com.viacron.greenball.app.bbb.ChatAction;
import com.viacron.greenball.app.bbb.GreenballMessages;
import com.viacron.greenball.app.bbb.GreenballMessagesEnum;
import com.viacron.greenball.app.bbb.GreenballMessagesUtility;
import com.viacron.greenball.app.bbb.MissingAttributeException;
import com.viacron.greenball.app.bbb.Variable;

public class TestBtoB {

	static final String LOG_PROPERTIES_FILE = "C:\\Users\\Scott\\Documents\\Programs\\ByteByByte\\ByteByByteTester\\log4j\\log4j.properties";
	/** Logging */
	static Logger log4j = Logger.getLogger(TestBtoB.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initLogger();

		Chat chat = new Chat();

		chat.setUser("the user");
		Date date = new Date();
		long timestamp = 305419896L;
		// chat.setTimestamp(date.getTime());
		chat.setTimestamp(timestamp);
		chat.setDud1(255);
		chat.setDud2(123.45f);
		chat.setDud3(6.789);
		chat.setDud4('x');
		chat.setDud5(true);
		chat.setDud6((byte) 0xff);
		chat.setDud7(Calendar.getInstance());
		chat.setMsg("test message");

		chat.setAction(ChatAction.DELETE);

		chat.getSomeBooleans().add(true);
		chat.getSomeBooleans().add(false);
		chat.getSomeBooleans().add(true);
		chat.getSomeBooleans().add(false);
		chat.getSomeBooleans().add(true);

		chat.getSomeBytes().add((byte) 0x0a);
		chat.getSomeBytes().add((byte) 0x0b);
		chat.getSomeBytes().add((byte) 0x0c);
		chat.getSomeBytes().add((byte) 0x0d);
		chat.getSomeBytes().add((byte) 0x0e);

		chat.getSomeChars().add('a');
		chat.getSomeChars().add('b');
		chat.getSomeChars().add('c');
		chat.getSomeChars().add('d');
		chat.getSomeChars().add('e');

		chat.getSomeInts().add(1);
		chat.getSomeInts().add(2);
		chat.getSomeInts().add(3);
		chat.getSomeInts().add(4);
		chat.getSomeInts().add(5);

		chat.getSomeFloats().add(1.0F);
		chat.getSomeFloats().add(2.0F);
		chat.getSomeFloats().add(3.0F);
		chat.getSomeFloats().add(4.0F);
		chat.getSomeFloats().add(5.0F);

		chat.getSomeShorts().add((short) 1);
		chat.getSomeShorts().add((short) 2);
		chat.getSomeShorts().add((short) 3);
		chat.getSomeShorts().add((short) 4);
		chat.getSomeShorts().add((short) 5);

		chat.getSomeDoubles().add(-6.0);
		chat.getSomeDoubles().add(7.0);
		chat.getSomeDoubles().add(-8.0);
		chat.getSomeDoubles().add(9.0);
		chat.getSomeDoubles().add(-10.0);

		chat.getSomeLongs().add(-1L);
		chat.getSomeLongs().add(-2L);
		chat.getSomeLongs().add(-3L);
		chat.getSomeLongs().add(-4L);
		chat.getSomeLongs().add(-5L);

		chat.getSomeStrings().add("1string");
		chat.getSomeStrings().add("2string");
		chat.getSomeStrings().add("3string");
		chat.getSomeStrings().add("4string");
		chat.getSomeStrings().add("5string");

		Variable variable = new Variable();
		variable.setDatatype("Some datatype1");
		variable.setMulti(true);
		variable.setName("My Name1");
		chat.getVariables().add(variable);
		
		variable = new Variable();
		variable.setDatatype("Some datatype2");
		variable.setMulti(true);
		variable.setName("My Name2");
		chat.getVariables().add(variable);

		log4j.debug("user: " + chat.getUser());
		log4j.debug("msg: " + chat.getMsg());
		log4j.debug("timestamp: " + chat.getTimestamp());
		log4j.debug("dud1: " + chat.getDud1());
		log4j.debug("dud2: " + chat.getDud2());
		log4j.debug("dud3: " + chat.getDud3());
		log4j.debug("dud4: " + chat.getDud4());
		log4j.debug("dud5: " + chat.getDud5());
		log4j.debug("dud6: " + chat.getDud6());
		log4j.debug("dud7: " + chat.getDud7().getTimeInMillis());
		log4j.debug("action: " + chat.getAction());

		for (Variable v : chat.getVariables()) {
			log4j.debug("variable.datatype: " + v.getDatatype());
			log4j.debug("variable.multi: " + v.getMulti());
			log4j.debug("variable.name: " + v.getName());
		}

		int index = 0;
		for (Boolean b : chat.getSomeBooleans()) {
			log4j.debug(String.format("someBooleans[%d]: %s", index, b));
			index++;
		}

		index = 0;
		for (Byte b : chat.getSomeBytes()) {
			log4j.debug(String.format("someBytes[%d]: %s", index, b));
			index++;
		}

		index = 0;
		for (Character c : chat.getSomeChars()) {
			log4j.debug(String.format("someChars[%d]: %s", index, c));
			index++;
		}

		index = 0;
		for (int i : chat.getSomeInts()) {
			log4j.debug(String.format("someInts[%d]: %d", index, i));
			index++;
		}

		index = 0;
		for (Float f : chat.getSomeFloats()) {
			log4j.debug(String.format("someFloats[%d]: %f", index, f));
			index++;
		}

		index = 0;
		for (Long l : chat.getSomeLongs()) {
			log4j.debug(String.format("someLongs[%d]: %d", index, l));
			index++;
		}

		index = 0;
		for (Short s : chat.getSomeShorts()) {
			log4j.debug(String.format("someShorts[%d]: %d", index, s));
			index++;
		}

		index = 0;
		for (Double d : chat.getSomeDoubles()) {
			log4j.debug(String.format("someDoubles[%d]: %f", index, d));
			index++;
		}

		index = 0;
		for (String s : chat.getSomeStrings()) {
			log4j.debug(String.format("someStrings[%d]: %s", index, s));
			index++;
		}

		try {
			byte[] ba = chat.pack();
			GreenballMessagesEnum gme = GreenballMessages.peek(ba);
			log4j.debug(String.format("ID: %d (%s)", gme.getId(), gme.getName()));
			
			if (gme.CHAT.getId() == GreenballMessagesEnum.CHAT.getId()) {
				Chat c = new Chat().unpack(ba);
				dumpChat(c, ba);
				
			}
			
			String str = chat. packStr();
			log4j.debug("str: " + str.length());
			log4j.debug(GreenballMessagesUtility.dumpHexData("ba", ba,
					ba.length));

			Chat chat2 = chat.unpack(ba);
			
			dumpChat(chat2, ba);
		} catch (MissingAttributeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void dumpChat(Chat chat2, byte[] ba) {

		log4j.debug("user: " + chat2.getUser());
		log4j.debug("msg: " + chat2.getMsg());
		log4j.debug("timestamp: " + chat2.getTimestamp());
		log4j.debug("dud1: " + chat2.getDud1());
		log4j.debug("dud2: " + chat2.getDud2());
		log4j.debug("dud3: " + chat2.getDud3());
		log4j.debug("dud4: " + chat2.getDud4());
		log4j.debug("dud5: " + chat2.getDud5());
		log4j.debug("dud6: " + chat2.getDud6());
		log4j.debug("dud7: " + chat2.getDud7().getTimeInMillis());
		log4j.debug("action: " + chat2.getAction());

		for (Variable v : chat2.getVariables()) {
			log4j.debug("variable.datatype: " + v.getDatatype());
			log4j.debug("variable.multi: " + v.getMulti());
			log4j.debug("variable.name: " + v.getName());
		}

		log4j.debug("valid checksum: "
				+ GreenballMessagesUtility.verifyChecksum(ba));

		int index = 0;
		log4j.debug("chat2.getSomeBooleans().size: "
				+ chat2.getSomeBooleans().size());
		for (Boolean b : chat2.getSomeBooleans()) {
			log4j.debug(String.format("someBooleans[%d]: %s", index, b));
			index++;
		}

		index = 0;
		log4j.debug("chat2.getSomeBytes().size: "
				+ chat2.getSomeBytes().size());
		for (Byte b : chat2.getSomeBytes()) {
			log4j.debug(String.format("someBytes[%d]: %s", index, b));
			index++;
		}

		index = 0;
		for (Character c : chat2.getSomeChars()) {
			log4j.debug(String.format("someChars[%d]: %s", index, c));
			index++;
		}

		index = 0;
		log4j.debug("chat2.getSomeInts().size: "
				+ chat2.getSomeInts().size());
		for (int i : chat2.getSomeInts()) {
			log4j.debug(String.format("someInts[%d]: %d", index, i));
			index++;
		}

		index = 0;
		log4j.debug("chat2.getSomeShorts().size: "
				+ chat2.getSomeShorts().size());
		for (short s : chat2.getSomeShorts()) {
			log4j.debug(String.format("someShorts[%d]: %d", index, s));
			index++;
		}

		index = 0;
		log4j.debug("chat2.getSomeFloats().size: "
				+ chat2.getSomeFloats().size());
		for (Float f : chat2.getSomeFloats()) {
			log4j.debug(String.format("someFloats[%d]: %f", index, f));
			index++;
		}

		index = 0;
		for (Long l : chat2.getSomeLongs()) {
			log4j.debug(String.format("someLongs[%d]: %d", index, l));
			index++;
		}

		index = 0;
		for (Double d : chat2.getSomeDoubles()) {
			log4j.debug(String.format("someDoubles[%d]: %f", index, d));
			index++;
		}

		index = 0;
		for (String s : chat2.getSomeStrings()) {
			log4j.debug(String.format("someStrings[%d]: %s", index, s));
			index++;
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
