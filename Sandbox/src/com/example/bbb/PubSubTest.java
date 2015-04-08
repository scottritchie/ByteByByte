package com.example.bbb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;

import com.example.test.Instrument;
import com.example.test.InstrumentCmd;
import com.example.test.MissingAttributeException;
import com.example.test.TestMessages;
import com.example.utils.Utils;

public class PubSubTest {

	private static final String CLAZZ = PubSubTest.class.getSimpleName();

	/** Logging */
	static Logger log4j = Logger.getLogger(PubSubTest.class);
	private static final String LOG_PROPERTIES_FILE = "/home/goesrsr/BitByBit/Sandbox/log4j/log4j.properties";
	private static final String HOSTNAME = "localhost";
	private static final Integer CONTROL_PORT = 7000;

	private static ZContext theContext;
	private static Socket theSubSocket = null;

	public static void main(String args[]) {
		initLogger();

		InstrumentCmd instrumentCmd = new InstrumentCmd();
		instrumentCmd.setDescription("This command clears the scanner memory");
		instrumentCmd.setHaltOnErr(true);
		instrumentCmd.setInstrument(Instrument.SCANNER);
		instrumentCmd.setOpcode(0);

		theContext = new ZContext();
		createSubscriber();
		sendControlCommand(instrumentCmd);

		System.out.println("P: exit");
		System.exit(0);
	}

	/**
	 * This method sends a control command to the Data Manager.
	 */
	public static void sendControlCommand(InstrumentCmd cmd) {
		final String METHOD = ".sendControlCommand()";
		System.out.println(CLAZZ + METHOD + "{");

		Socket socket = theContext.createSocket(ZMQ.PUB);

		/*
		 * Set the linger to zero so that the socket will not hang on close if
		 * the Subscriber fails to respond.
		 */
		socket.setLinger(1);

		String hostname = HOSTNAME;
		int port = CONTROL_PORT;

		String url = "tcp://" + hostname + ":" + port;
		System.out.println("url: " + url);

		/*
		 * From the 0MQ Guide: "...ØMQ socket connection is always biased
		 * towards one peer that binds to an endpoint, and another that connects
		 * to that. Further, that which side binds and which side connects is
		 * not arbitrary, but follows natural patterns. The side which we expect
		 * to "be there" binds: it'll be a server, a broker, a publisher, a
		 * collector. The side that "comes and goes" connects: it'll be clients
		 * and workers.". In this case, we are the application that "comes and
		 * goes" so we connect.
		 */
		socket.connect(url);

		/*
		 * The bind takes a finite amount of time to establish the connection so
		 * wait a bit before sending messages.
		 */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(Utils.stackTraceToString(e));
		}

		int count = 0;

		while (count < 15) {
			System.out.println("P: sending command");

			try {
				cmd.setOpcode(count);
				socket.sendMore(TestMessages.INSTRUMENT_CMD);

				byte[] bytes = cmd.pack();
				socket.send(bytes);

				Thread.sleep(1000);
			} catch (MissingAttributeException e) {
				System.out.println(Utils.stackTraceToString(e));
			} catch (InterruptedException e) {
				System.out.println(Utils.stackTraceToString(e));
			}

			count++;
		}

		System.out.println("P: closing the socket...");
		theContext.destroySocket(socket);

		System.out.println("} " + CLAZZ + METHOD);
	}

	private static void createSubscriber() {
		ScheduledExecutorService scheduler = Executors
				.newScheduledThreadPool(1);

		scheduler.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("Subscriber()");

				if (theSubSocket == null) {
					theSubSocket = theContext.createSocket(ZMQ.SUB);
					theSubSocket.setLinger(0);
					theSubSocket.subscribe(TestMessages.INSTRUMENT_CMD
							.getBytes());
					theSubSocket.bind(String.format("tcp://%s:%d", HOSTNAME,
							CONTROL_PORT));
				}

				InstrumentCmd instrumentCmd = new InstrumentCmd();
				int opcode = 0;
				while (opcode != 10) {
					String topic = theSubSocket.recvStr();
					System.out.println("S: topic: " + topic);
					byte[] bytes = theSubSocket.recv();

					InstrumentCmd cmd = instrumentCmd.unpack(bytes);
					System.out.println("S: cmd: " + cmd);
					opcode = cmd.getOpcode();

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println(Utils.stackTraceToString(e));
					}
				}

				System.out.println("S: done");
				theSubSocket.close();

				return;
			}
		}, 1, TimeUnit.SECONDS);
	}

	/*
	 * This method initializes the logging subsystem.
	 */
	private static void initLogger() {

		Properties logProperties = new Properties();
		try {
			logProperties.load(new FileInputStream(
					new File(LOG_PROPERTIES_FILE)));
			PropertyConfigurator.configure(logProperties);
			log4j.info("Logging initialized");
		} catch (FileNotFoundException e) {
			log4j.error(Utils.stackTraceToString(e));
		} catch (IOException e) {
			log4j.debug(Utils.stackTraceToString(e));
		}
	}

}
