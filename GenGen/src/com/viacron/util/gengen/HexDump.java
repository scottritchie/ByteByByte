/*
 * File: HexDump.java
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

import java.io.UnsupportedEncodingException;

/**
 * This class creates a hex dump of a byte array.
 * 
 * @author Scott Ritchie
 * 
 * @history sritchie Mar 28, 2015 : Initial creation.
 */
public class HexDump {

	public static void hexDump(byte[] bytes) {
		int width = 16;
		if (bytes != null) {
			for (int index = 0; index < bytes.length; index += width) {
				printHex(bytes, index, width);
				try {
					printAscii(bytes, index, width);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void printHex(byte[] bytes, int offset, int width) {
		for (int index = 0; index < width; index++) {
			if (index + offset < bytes.length) {
				System.out.printf("%02x ", bytes[index + offset]);
			} else {
				System.out.print("	");
			}
		}
	}

	private static void printAscii(byte[] bytes, int index, int width)
			throws UnsupportedEncodingException {
		if (index < bytes.length) {
			width = Math.min(width, bytes.length - index);
			System.out.println(":"
					+ new String(bytes, index, width, "UTF-8").replaceAll(
							"\r\n", " ").replaceAll("\n", " "));
		} else {
			System.out.println();
		}
	}
}
