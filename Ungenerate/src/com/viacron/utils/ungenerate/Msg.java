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

public class Msg {
private String name;
private List<InstanceVariable> attributes;
private List<MsgSubType> subTypes;
private List<MsgEnum> enumerations;

/**
 * This class defines a message.
 * 
 * @author Scott Ritchie
 * 
 * @history sritchie Mar 28, 2015 : Initial creation.
 */
public Msg (String name, List<InstanceVariable> attributes, List<MsgSubType> subTypes, List<MsgEnum> enumerations) {
	this.setName(name);
	this.setAttributes(attributes);
	this.setSubTypes(subTypes);
	this.setEnumerations(enumerations);
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<InstanceVariable> getAttributes() {
	return attributes;
}

public void setAttributes(List<InstanceVariable> attributes) {
	this.attributes = attributes;
}

public List<MsgSubType> getSubTypes() {
	return subTypes;
}

public void setSubTypes(List<MsgSubType> subTypes) {
	this.subTypes = subTypes;
}

public List<MsgEnum> getEnumerations() {
	return enumerations;
}

public void setEnumerations(List<MsgEnum> enumerations) {
	this.enumerations = enumerations;
}

}
