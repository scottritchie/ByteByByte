package com.viacron.greenball.app.bbb.sandbox;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Calendar;
import java.util.Date;

public class GetBoolean {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] ba = new byte[3];

		ba[0] = (byte) 0x01;
		ba[1] = (byte) 0x01;
		ba[2] = (byte) 0x04;

		System.out.println("boolean: " + getBoolean(ba, 8));
		System.out.println("byte: " + getByte(ba, 0));
		System.out.println("byte: " + getByte(ba, 1));
		System.out.println("byte: " + getByte(ba, 2));
		System.out.println("byte: " + getByte(ba, 3));
		System.out.println("byte: " + getByte(ba, 4));
		System.out.println("byte: " + getByte(ba, 5));
		System.out.println("byte: " + getByte(ba, 6));
		System.out.println("byte: " + getByte(ba, 7));
		System.out.println("byte: " + getByte(ba, 8));
		System.out.println("byte: " + getByte(ba, 9));
		System.out.println("byte: " + getByte(ba, 10));
		System.out.println("byte: " + getByte(ba, 11));
		System.out.println("byte: " + getByte(ba, 12));
		System.out.println("byte: " + getByte(ba, 13));
		System.out.println("byte: " + getByte(ba, 14));
		System.out.println("byte: " + getByte(ba, 15));

	}

	/**
	 * This method returns a boolean from a byte array given an offset in bits
	 * into the byte array.
	 */
	public static boolean getBoolean(byte[] byteArray, int offsetInBits) {

		int index = offsetInBits / 8;
		System.out.println("index: " + index);
		byte b = byteArray[index];
		int bitPosition = 7 - offsetInBits % 8;

		System.out.println("bitPosition: " + bitPosition);

		return ((b >> bitPosition) & 0x01) == 1 ? true : false;
	}

	/**
	 * This method returns a byte from a byte array given an offset in bits into
	 * the byte array.
	 */
	public static byte getByte(byte[] byteArray, int offsetInBits) {

		int index = offsetInBits / 8;
		int bitPosition = offsetInBits % 8;

		int upper = 0;
		int lower = 0;

		if (bitPosition == 0) {
			return byteArray[index];
		} else if (bitPosition == 1) {
			upper = (byteArray[index] & 0x7f) << 1;
			lower = (byteArray[index + 1] >> 7) & 0x01;
		} else if (bitPosition == 2) {
			upper = (byteArray[index] & 0x3f) << 2;
			lower = (byteArray[index + 1] >> 6) & 0x03;
		} else if (bitPosition == 3) {
			upper = (byteArray[index] & 0x1f) << 3;
			lower = (byteArray[index + 1] >> 5) & 0x07;
		} else if (bitPosition == 4) {
			upper = (byteArray[index] & 0x0f) << 4;
			lower = (byteArray[index + 1] >> 4) & 0x0f;
		} else if (bitPosition == 5) {
			upper = (byteArray[index] & 0x07) << 5;
			lower = (byteArray[index + 1] >> 3) & 0x1f;
		} else if (bitPosition == 6) {
			upper = (byteArray[index] & 0x03) << 6;
			lower = (byteArray[index + 1] >> 2) & 0x3f;
		} else if (bitPosition == 7) {
			upper = (byteArray[index] & 0x01) << 7;
			lower = (byteArray[index + 1] >> 1) & 0x7f;
		}

		return ((byte) (upper + lower));
	}

	   /**
	    * This method returns a date from a byte array given an offset
	    * into the byte array.
	    */
	   public static Calendar getCalendar(byte[] byteArray, int offset) {

	      long result = 0;
	      for (int i = 0; i < 8; i++) {
	         result |= (long) byteArray[offset + i] << ((7 - i) * 8);
	      }
	      
	      Date d = new Date(result);
	      
	      Calendar c = Calendar.getInstance();
	      c.setTime(d);

	      return c;
	   }

	/**
	 * This method returns an integer from a byte array given an offset in bits
	 * into the byte array.
	 */
	public static int getInteger(byte[] byteArray, int offsetInBits) {
		int result = 0;

		for (int i = 0; i < 4; i++) {
			byte b = getByte(byteArray, offsetInBits + i * 8);
			result += (int) b << ((4 - i) * 8);
		}

		return result;
	}

	/**
	 * This method returns a float from a byte array given an offset in bits
	 * into the byte array.
	 */
	public static float getFloat(byte[] byteArray, int offsetInBits) {
		byte[] bytes = new byte[4];

		for (int i = 0; i < 4; i++) {
			bytes[i] = getByte(byteArray, offsetInBits + i * 8);
		}
		
		return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();
	}

	/**
	 * This method returns a character from a byte array given an offset in bits
	 * into the byte array.
	 */
	public static char getCharacter(byte[] byteArray, int offsetInBits) {
		char result = 0;

		for (int i = 0; i < 2; i++) {
			byte b = getByte(byteArray, offsetInBits + i * 8);
			result += (char) b << ((2 - i) * 8);
		}

		return result;
	}
}
