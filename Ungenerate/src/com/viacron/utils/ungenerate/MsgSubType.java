/*
 * File: InstanceVariable.java
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
package com.viacron.utils.ungenerate;

import java.util.List;

/**
 * This class defines a message sub-type.
 * 
 * @author Scott Ritchie
 * 
 * @history sritchie Mar 28, 2015 : Initial creation.
 */
public class MsgSubType {
	private String subTypeName;
	private List<InstanceVariable> msgAttributes;
	private List<MsgSubType> subTypes;
	
	public MsgSubType(String subTypeName, List<InstanceVariable> msgAttributes) {
		this.setSubTypeName(subTypeName);
		this.setMsgAttributes(msgAttributes);
	}

	public String getSubTypeName() {
		return subTypeName;
	}

	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}

	public List<InstanceVariable> getMsgAttributes() {
		return msgAttributes;
	}

	public void setMsgAttributes(List<InstanceVariable> msgAttributes) {
		this.msgAttributes = msgAttributes;
	}

	public List<MsgSubType> getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(List<MsgSubType> subTypes) {
		this.subTypes = subTypes;
	}
}
