# ByteByByte
ByteByByte is a tool for creating message payloads. It generates Java classes for packing and unpacking classes into byte arrays or strings, and is based on Xtext (2.3.1), the Eclipse plugin for domain specific language development. It includes a nice editor with content assist, syntax highlighting, validation, and other editor features that make it easy to design message payloads. It currently runs as an Eclipse plugin. 

Here's what the message definitions looks like in the editor:
############################
grammar name Example

package com.bbb.example

root ExampleMessages

Message HelloWorld {
  greeting as string
}

Message ComplexMessage {
  opcode as integer
  
  /*
   * This attribute is optional. If a required attribute
   * is not provided, the MissingAttributeException is
   * thrown when the pack() method is called.
   */
  description as string (optional)
  
  // Lists are supported
  someBooleans as list of boolean
  someBytes as list of byte
  someChars as list of char
  someCalendars as list of calendar
  someDoubles as list of double
  someFloats as list of float
  someInts as list of integer
  someLongs as list of long
  someShorts as list of short
  someStrings as list of string
  
  // Sub-types are supported
  payload as Payload
  
  // Enumerations are supported
  action as enum Action
}

SubType Payload {
  aBoolean as boolean
  aByte as byte
  aCalendar as calendar
  
  // Nested sub-types are supported
  miniPayload as MiniPayload
}

SubType MiniPayload {
  moreStuff as string
}

// Enumerations are just lists of items.
Enum Action {
  StartUp
  Idle
  Active
  ShutDown
}
###########################

As you can see, the usual primitive types are supported. You can also define sub-types and enumerations. Lists of primitives and sub-types are supported. Sub-types can also be nested.

To use the generated classes to create a byte array containing the HelloWorld message you would do this:
HelloWorld hw = new HelloWorld();
hw.setGreeting("Hello World!");
try {
  byte[] byteArray = hw.pack();
}
catch (MissingAttributeException e) {
  e.printStackTrace();
}

Now that the message is packed into a byte array you can send it to a recipient using your favorite message system. The recipient receives the message, stores it in a byte array called byteArray, and unpacks it like this:
HelloWorld tmp = new HelloWorld();
HelloWorld hw = tmp.unpack(byteArray);
System.out.println("greeting: " + hw.getGreeting());
