/*
 * File: ByteByByteJavaValidator.java
 * Description: The Java validator for the ByteByByte DSL.
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
package com.viacron.utils.bbb.validation;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;

import com.viacron.utils.bbb.byteByByte.ByteByBytePackage;
import com.viacron.utils.bbb.byteByByte.Message;
import com.viacron.utils.bbb.byteByByte.PEnum;
import com.viacron.utils.bbb.byteByByte.PEnumElement;
import com.viacron.utils.bbb.byteByByte.SubType;

/**
 * This class performs validation on ByteByByte grammars.
 * 
 * @author Scott Ritchie
 * 
 * @history sritchie Mar 28, 2015 : Initial creation.
 * 
 */
public class ByteByByteJavaValidator extends AbstractByteByByteJavaValidator {

	@Check
	public void checkMessageNameIsValid(Message msg) {
		if (msg.getName().contains("_")) {
			error("The underscore character is not allowed in Message names.",
					ByteByBytePackage.Literals.MESSAGE__NAME);
		}
	}

	@Check
	public void checkSubTypeNameIsValid(SubType subType) {
		if (subType.getName().contains("_")) {
			error("The underscore character is not allowed in SubType names.",
					ByteByBytePackage.Literals.SUB_TYPE__NAME);
		}
	}

	@Check
	public void checkEnumNameIsValid(PEnum penum) {
		if (penum.getName().contains("_")) {
			error("The underscore character is not allowed in Enum names.",
					ByteByBytePackage.Literals.PENUM__NAME);
		}
	}

	@Check
	public void checkMessageNameIsUnique(Message msg) {
		int occurrences = 0;
		EList<EObject> allSiblings = msg.eContainer().eContents();
		List<Message> allMessages = EcoreUtil2.typeSelect(allSiblings,
				Message.class);

		for (Message message : allMessages) {
			if (message.getName().equals(msg.getName())) {
				occurrences++;
			}

			if (occurrences > 1) {
				error("Duplicate Message name.",
						ByteByBytePackage.Literals.MESSAGE__NAME);
			}
		}
	}

	@Check
	public void checkSubTypeNameIsUnique(SubType subType) {
		int occurrences = 0;
		EList<EObject> allSiblings = subType.eContainer().eContents();
		List<SubType> allSubTypes = EcoreUtil2.typeSelect(allSiblings,
				SubType.class);

		for (SubType st : allSubTypes) {
			if (st.getName().equals(subType.getName())) {
				occurrences++;
			}

			if (occurrences > 1) {
				error("Duplicate SubType name.",
						ByteByBytePackage.Literals.SUB_TYPE__NAME);
			}
		}
	}

	@Check
	public void checkEnumNameIsUnique(PEnum penum) {
		int occurrences = 0;
		EList<EObject> allSiblings = penum.eContainer().eContents();
		List<PEnum> allPenums = EcoreUtil2.typeSelect(allSiblings, PEnum.class);

		for (PEnum p : allPenums) {
			if (p.getName().equals(penum.getName())) {
				occurrences++;
			}

			if (occurrences > 1) {
				error("Duplicate Enum name.",
						ByteByBytePackage.Literals.PENUM__NAME);
			}
		}
	}

	@Check
	public void checkEnumElementsAreUnique(PEnum penum) {
		List<String> elements = new ArrayList<String>();

		for (PEnumElement p : penum.getElements()) {
			if (elements.contains(p.getName()) == true) {
				error("Duplicate element: " + p.getName(), ByteByBytePackage.Literals.PENUM__NAME, ByteByBytePackage.PENUM_ELEMENT);
				break;
			} else {
				elements.add(p.getName());
			}
		}
		
	}

}
