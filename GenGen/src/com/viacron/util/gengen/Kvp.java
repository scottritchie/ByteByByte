/*
 * File: Kvp.java
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
package com.viacron.util.gengen;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * This class defines a key-value pair.
 * 
 * @author Scott Ritchie
 *
 * @history sritchie Mar 28, 2015 : Initial creation.
 */
public class Kvp {
	private String key;
	private String value;

	public Kvp(String key, String value) {
		this.setKey(key);
		this.setValue(value);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * This method returns the size of a packed key-value pair object in bytes.
	 * 
	 * @return The size in bytes.
	 */
	public int size() {
		int keyLength = key.getBytes(Charset.forName("UTF-8")).length;
		int valLength = value.getBytes(Charset.forName("UTF-8")).length;
		return 16 + keyLength + valLength;
	}

	/**
	 * This method packs the key-value pair into a byte array. The data is
	 * arranged as follows: [header][key as bytes][value as bytes]
	 * 
	 * The header bytes are as follows:
	 * 
	 * 0-3: length of key
	 * 
	 * 4-7: offset of key
	 * 
	 * 8-11: length of value
	 * 
	 * 12-15: offset of value
	 * 
	 * @return The key-value pair as a byte array.
	 */
	public byte[] pack() {
		System.out.println("Entered pack()");

		System.out.println("key: " + key);
		System.out.println("value: " + value);

		byte[] keyBytes = key.getBytes(Charset.forName("UTF-8"));
		byte[] valBytes = value.getBytes(Charset.forName("UTF-8"));
		int keyLength = keyBytes.length;
		int valLength = valBytes.length;

		System.out.println("keyLength: " + keyLength);
		System.out.println("valLength: " + valLength);

		int keyOffset = 16;
		int valOffset = keyOffset + keyLength;

		System.out.println("keyOffset: " + keyOffset);
		System.out.println("valOffset: " + valOffset);

		byte[] result = new byte[4 * 4 + keyLength + valLength];

		byte[] keyLengthBytes = ByteBuffer.allocate(4).putInt(keyLength)
				.array();
		byte[] keyOffsetBytes = ByteBuffer.allocate(4).putInt(keyOffset)
				.array();
		byte[] valLengthBytes = ByteBuffer.allocate(4).putInt(valLength)
				.array();
		byte[] valOffsetBytes = ByteBuffer.allocate(4).putInt(valOffset)
				.array();

		// Insert the length of the key
		int index = 0;
		for (byte b : keyLengthBytes) {
			result[index] = b;
			index++;
		}

		// Insert the offset of the key
		for (byte b : keyOffsetBytes) {
			result[index] = b;
			index++;
		}

		// Insert the length of the value
		for (byte b : valLengthBytes) {
			result[index] = b;
			index++;
		}

		// Insert the offset of the value
		for (byte b : valOffsetBytes) {
			result[index] = b;
			index++;
		}

		// Insert the key
		for (byte b : keyBytes) {
			result[index] = b;
			index++;
		}

		// Insert the value
		for (byte b : valBytes) {
			result[index] = b;
			index++;
		}

		HexDump.hexDump(result);

		System.out.println("Leaving pack()");
		return result;
	}

	/**
	 * This method unpacks a byte array into a key-value pair object.
	 * 
	 * @param bytes
	 *            The byte array.
	 * @return The key-value pair.
	 */
	public static Kvp unpack(byte[] bytes) {
		Kvp result = unpack(0, bytes);
		return result;
	}

	/**
	 * This method unpacks a byte array into a key-value pair object.
	 * 
	 * @param startingByte
	 *            The byte at which to start unpacking.
	 * @param bytes
	 *            The byte array.
	 * @return The key-value pair.
	 */
	public static Kvp unpack(final int startingByte, byte[] bytes) {
		System.out.println("Entered unpack()");

		System.out.println("startingByte: " + startingByte);

		byte[] keyOffsetBytes = new byte[4];

		if (startingByte < bytes.length) {
			int offset = startingByte;
			byte[] keyLengthBytes = new byte[4];
			// Key length
			for (int i = 0; i < 4; i++) {
				keyLengthBytes[i] = bytes[offset + i];
			}
			int keyLength = ByteBuffer.wrap(keyLengthBytes).getInt();
			offset += 4;

			// Key offset
			for (int i = 0; i < 4; i++) {
				keyOffsetBytes[i] = bytes[offset + i];
			}
			int keyOffset = ByteBuffer.wrap(keyOffsetBytes).getInt();
			offset += 4;

			// Val length
			byte[] valLengthBytes = new byte[4];
			for (int i = 0; i < 4; i++) {
				valLengthBytes[i] = bytes[offset + i];
			}
			int valLength = ByteBuffer.wrap(valLengthBytes).getInt();
			offset += 4;

			// Val offset
			byte[] valOffsetBytes = new byte[4];
			for (int i = 0; i < 4; i++) {
				valOffsetBytes[i] = bytes[offset + i];
			}
			int valOffset = ByteBuffer.wrap(valOffsetBytes).getInt();

			// Key
			byte[] keyBytes = new byte[keyLength];
			for (int i = 0; i < keyLength; i++) {
				keyBytes[i] = bytes[startingByte + keyOffset + i];
			}
			String key = new String(keyBytes);

			// Value
			byte[] valBytes = new byte[valLength];
			for (int i = 0; i < valLength; i++) {
				valBytes[i] = bytes[startingByte + valOffset + i];
			}
			String val = new String(valBytes);

			System.out.println("keyLength: " + keyLength);
			System.out.println("valLength: " + valLength);

			System.out.println("keyOffset: " + keyOffset);
			System.out.println("valOffset: " + valOffset);

			System.out.println("key: " + key);
			System.out.println("value: " + val);

			System.out.println("Leaving unpack()");
			return new Kvp(key, val);
		}

		System.out.println("Leaving unpack()");
		return null;
	}
}
