package com.viacron.greenball.app.bbb.sandbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HexDump {
	private static final String LOG_PROPERTIES_FILE = "/home/goesrsr/workspace/Sandbox/log4j/log4j.properties";
	private static Logger log4j = Logger.getLogger(HexDump.class);

	private static final int BYTES_PER_ROW = 16;
	private static final int ROW_QTR1 = 3;
	private static final int ROW_HALF = 7;
	private static final int ROW_QTR2 = 11;

	private static final String LINE_SEPARATOR = System.lineSeparator();
	private static String[] hexChars = new String[] { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	public static String dumpHexData(String title, byte[] buf, int numBytes) {
		int rows;
		int residue;
		int i;
		int j;
		int labelSize;
		byte[] rowBuf = new byte[BYTES_PER_ROW + 2];
		String[] charBuf = new String[4];
		String result = title + " - " + numBytes + " bytes." + LINE_SEPARATOR;
		
		// There are 16 bytes per row.
		rows = numBytes >> 4;
		residue = numBytes & 0x0000000F;
		
		/*
		 * Calculate the number of hex characters required to represent the row label.
		 */
		labelSize = log16(numBytes);
		log4j.debug("rows: " + rows);
		log4j.debug("labelSize: " + labelSize);

		for (i = 0; i < rows; i++) {
			int byteCount = (i * BYTES_PER_ROW);
			String rowLabel = buildRowLabel(byteCount, labelSize);
			
			result = result.concat(rowLabel + ": ");

			for (j = 0; j < BYTES_PER_ROW; j++) {
				rowBuf[j] = buf[(i * BYTES_PER_ROW) + j];

				charBuf[0] = hexChars[(rowBuf[j] >> 4) & 0x0F];
				charBuf[1] = hexChars[rowBuf[j] & 0x0F];

				result = result.concat(charBuf[0]);
				result = result.concat(charBuf[1]);
				result = result.concat(" ");

				if (j == ROW_QTR1 || j == ROW_HALF || j == ROW_QTR2)
					result = result.concat(" ");

				if (rowBuf[j] < 0x20 || rowBuf[j] > 0xD9)
					rowBuf[j] = '.';
			}

			String saveStr = new String(rowBuf, 0, j);
			result = result.concat(" | " + saveStr + " |" + LINE_SEPARATOR);
		}

		if (residue > 0) {
			int byteCount = (i * BYTES_PER_ROW);
			String rowLabel = buildRowLabel(byteCount, labelSize);
			result = result.concat(rowLabel + ": ");

			for (j = 0; j < residue; j++) {
				rowBuf[j] = buf[(i * BYTES_PER_ROW) + j];

				charBuf[0] = hexChars[(rowBuf[j] >> 4) & 0x0F];
				charBuf[1] = hexChars[rowBuf[j] & 0x0F];

				result = result.concat(charBuf[0]);
				result = result.concat(charBuf[1]);
				result = result.concat(" ");

				if (j == ROW_QTR1 || j == ROW_HALF || j == ROW_QTR2)
					result = result.concat(" ");

				if (rowBuf[j] < 0x20 || rowBuf[j] > 0xD9)
					rowBuf[j] = '.';
			}

			for ( /* j INHERITED */; j < BYTES_PER_ROW; j++) {
				rowBuf[j] = ' ';
				result = result.concat("   ");
				if (j == ROW_QTR1 || j == ROW_HALF || j == ROW_QTR2)
					result = result.concat(" ");
			}

			String saveStr = new String(rowBuf, 0, j);
			result = result.concat(" | " + saveStr + " |" + LINE_SEPARATOR);
		}

		return result;
	}

	/*
	 * This method builds the label the proceeds each row of data. The index and
	 * shift are calculated on the fly to obtain a result like this:
	 * 
	 * idx_buf[0] = hexChars[((hexVal >> 12) & 0xf)];
	 * 
	 * idx_buf[1] = hexChars[((hexVal >> 8) & 0xf)];
	 * 
	 * idx_buf[2] = hexChars[((hexVal >> 4) & 0xf)];
	 * 
	 * idx_buf[3] = hexChars[(hexVal & 0xf)];
	 * 
	 * The array of bytes is then converted to a string and returned.
	 */
	private static String buildRowLabel(int byteCount,
			int labelSize) {
		
		String result = "";
		
		for (int c = 0; c < labelSize; c++) {
			int shift = c * 4;
			result = hexChars[((byteCount >> shift) & 0xf)] + result;
		}

		return result;
	}
	
	/*
	 * This method calculates the minimum number of hex characters required to 
	 * represent the given value.
	 */
	private static int log16(int value) {
		int bits = Integer.SIZE
				- Integer.numberOfLeadingZeros(value > 0 ? value - 1 : value);
		int hex = (bits - 1)/4 + 1;
		
		return hex;
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		initLogger();

		int size = 2048 * 2 + 128;
		byte[] data = new byte[size];
		for (int i = 0; i < size; ++i)
			data[i] = (byte) (i % 127);

		log4j.debug("begin HexDump test...");
		log4j.debug(HexDump.dumpHexData("Test HexDump", data, size));
		log4j.debug("...end HexDump test");
	}
}
