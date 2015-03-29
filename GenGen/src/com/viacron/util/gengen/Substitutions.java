/*
 * File: Substitutions.java
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

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines a list of substitutions.
 * 
 * @author Scott Ritchie
 * 
 * @history sritchie Mar 28, 2015 : Initial creation.
 */
public class Substitutions {

	private List<Kvp> theSubstitions = new ArrayList<Kvp>();

	public void add(Kvp kvp) {
		theSubstitions.add(kvp);
	}

	public void delete(Kvp kvp) {
		theSubstitions.remove(kvp);
	}

	public void edit(Kvp oldKvp, Kvp newKvp) {
		theSubstitions.remove(oldKvp);
		theSubstitions.add(newKvp);
	}

	public List<Kvp> get() {
		return theSubstitions;
	}

	public int size() {
		return theSubstitions.size();
	}

	/**
	 * This method packs the list of substitutions into a byte array.
	 * 
	 * @return The list of substitutions as a byte array.
	 */
	public byte[] pack() {
		int size = 0;
		for (Kvp kvp : theSubstitions) {
			size += kvp.size();
		}
		
		System.out.println("size: " + size);

		byte[] result = new byte[size];

		int offset = 0;
		for (Kvp kvp : theSubstitions) {
			byte[] bytes = kvp.pack();
			for (int i = 0; i < kvp.size(); i++) {
				result[offset + i] = bytes[i];
			}
			offset += kvp.size();
		}

		return result;
	}

	public void unpack(byte[] bytes) {
		int offset = 0;

		theSubstitions.clear();

		Kvp kvp;
		while ((kvp = Kvp.unpack(offset, bytes)) != null) {
			theSubstitions.add(kvp);
			offset += kvp.size();
		}
	}
}
