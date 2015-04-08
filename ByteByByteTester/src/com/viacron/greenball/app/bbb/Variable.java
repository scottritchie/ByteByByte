/*
 * WARNING: This file was generated by BitByBitGenerator.xtend (see
 * generateClassFile()). 
 * Do not edit.
 */
package com.viacron.greenball.app.bbb;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
/**
 * The Variable class is a SubType referenced by message objects defined
 * by the GreenballMessages grammar.
 */
public class Variable {
   private static final int ID = GreenballMessagesEnum.VARIABLE.getId();

   /**
    * The number of bits required to represent the VariableEnum IDs.
    * # of attributes: 3
    * # of PEnumRefs: 0
    */
   private static final int ID_BITS = 2;

   private static GreenballMessagesDirectoryEntry[] theDirectory;
   private static final int DIRECTORY_OFFSET = 1;

   private static Logger log4j = Logger.getLogger(Variable.class);

   // Entered buildClassEnum()
   private enum VariableEnum {
      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      NAME(0, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      DATATYPE(1, -1, 0, true),

      // sizeInBits: 8
      MULTI(2, 2, 0, false);

      private final int id;
      private final int offsetInBits;
      private int length;
      private boolean isDirectoryEntry;

      VariableEnum(int id, int offsetInBits, int length, boolean isDirectoryEntry) {
         this.id = id;
         this.offsetInBits = offsetInBits;
         this.length = length;
         this.isDirectoryEntry = isDirectoryEntry;
      }

      public int getId() {
         return this.id;
      }

      public int getOffsetInBits() {
         return this.offsetInBits;
      }

      public int getLength() {
         return this.length;
      }

      public void setLength(int length) {
         this.length = length;
      }
   } // Leaving buildClassEnum()

   /*
    * The instance variables.
    * See buildInstanceVariables() in JBitByBitGenerator.java.
    */
   private String name;
   private String datatype;
   private boolean multi;

   private String theErrorMsg;

   /**
    * The Variable no-arg constructor.
    */
   public Variable() {}

   /**
    * The Variable constructor.
    * See buildParameterAnnotations() in JBitByBitGenerator.java.
    *
    * @param name The name message attribute.
    * @param datatype The datatype message attribute.
    * @param multi The multi message attribute.
    */
   public Variable(String name,
                   String datatype,
                   Boolean multi) {
      // Entered buildParameterAssignments()
      this.setName(name);
      this.setDatatype(datatype);
      this.setMulti(multi);
      // Leaving buildParameterAssignments()
   }

   /**
    * The Variable copy constructor.
    */
   public Variable(Variable variable) {
      // Entered buildCopyConstructorParameterAssignments()
      this.setName(variable.getName());
      this.setDatatype(variable.getDatatype());
      this.setMulti(variable.getMulti());
      // Leaving buildCopyConstructorParameterAssignments()
   }

   // Entered buildSetErrorMsgMethod()
   private void setErrorMsg(String errorMsg) {
      theErrorMsg = errorMsg;
   }
   // Leaving buildSetErrorMsgMethod()

   // Entered buildGetErrorMsgMethod()
   /**
    * This method returns the error message or null if no error
    * occurred.
    */
   public String getErrorMsg() {
      return theErrorMsg;
   }
   // Leaving buildGetErrorMsgMethod()

   // Entered buildPackMethod()
   /**
    * This method packs a Variable object into a byte array. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A byte array which represents a Variable message object.
    * @throws MissingAttributeException
    */
   public byte[] pack() throws MissingAttributeException {
      final String METHOD = "pack()";
      log4j.debug("Entered " + METHOD);

      int byteArraySize = getVariableSize();
      log4j.debug("byteArraySize: " + byteArraySize);
      byte[] bb = new byte[byteArraySize];

      /*
       * Convert object to byte array.
       */
      int offset = 0;

      if (this.getMulti() != null) {
         bb = GreenballMessagesUtility.insertBitfield(bb, offset * 8, 1, this.getMulti() == true ? 1 : 0);
         offset += 1;
      } else {
         /*
          * Missing required attribute, generate an error message and throw
          * an exception.
          */
         setErrorMsg("Error packing object. The attribute \"multi\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }


      VariableEnum.NAME.setLength(this.getName().length());
      VariableEnum.DATATYPE.setLength(this.getDatatype().length());

      int directorySize = getVariableDirectorySize();
      if (directorySize != 0) {
         // Create the directory
         theDirectory = new GreenballMessagesDirectoryEntry[directorySize];
         for (int i = 0; i < directorySize; i++) {
            theDirectory[i] = new GreenballMessagesDirectoryEntry();
         }

         // Fill the directory
         int index = 0;
         offset = DIRECTORY_OFFSET
               + GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES
               * theDirectory.length;

         for (VariableEnum variableEnum : VariableEnum.values()) {
            if (variableEnum.isDirectoryEntry == true) {
               int id = variableEnum.getId();
               int length = variableEnum.getLength();

               theDirectory[index].setId(id);
               theDirectory[index].setLength(length);
               theDirectory[index].setOffset(offset);

               // Insert the data
               if (id == VariableEnum.NAME.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "name", offset));
                  bb = GreenballMessagesUtility.insertString(bb, offset, getName());
                  offset += length * 1;
               }
               else if (id == VariableEnum.DATATYPE.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "datatype", offset));
                  bb = GreenballMessagesUtility.insertString(bb, offset, getDatatype());
                  offset += length * 1;
               }
               index++;
            }
         }

         // Insert the directory
         offset = DIRECTORY_OFFSET;
         for (GreenballMessagesDirectoryEntry directoryEntry : theDirectory) {
            bb = GreenballMessagesUtility.insertInteger(bb, offset, directoryEntry.getId());
            bb = GreenballMessagesUtility.insertInteger(bb, offset + 4, directoryEntry.getLength());
            bb = GreenballMessagesUtility.insertInteger(bb, offset + 8, directoryEntry.getOffset());

            offset += GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
            index++;
         }

      }
      log4j.debug("Leaving " + METHOD);
      return bb;
   }
   // Leaving buildPackMethod()

   // Entered buildUnpackMethod()
   /**
    * This method unpacks a byte array containing a Variable object.
    *
    * @return The byte array as a Variable message object.
    */
   public Variable unpack(byte[] ba) {
      final String METHOD = "unpack()";
      log4j.debug("Entered " + METHOD);

      Variable variable = new Variable();

      variable.setMulti(GreenballMessagesUtility.getBoolean(ba, VariableEnum.MULTI.getOffsetInBits()));

      // Get the directory
      int directorySize = getVariableDirectorySize();
      theDirectory = new GreenballMessagesDirectoryEntry[directorySize];
      int dirOffset = DIRECTORY_OFFSET;

      for (int entry = 0 ; entry < directorySize; entry++) {
         GreenballMessagesDirectoryEntry directoryEntry = new GreenballMessagesDirectoryEntry();

         int id = GreenballMessagesUtility.getInteger(ba, dirOffset * 8);
         directoryEntry.setId(id);
         int length = GreenballMessagesUtility.getInteger(ba, (dirOffset + 4) * 8);
         directoryEntry.setLength(length);
         int offset = GreenballMessagesUtility.getInteger(ba, (dirOffset + 8) * 8);
         directoryEntry.setOffset(offset);

         theDirectory[entry] = directoryEntry;

         dirOffset += GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
      }

      for (GreenballMessagesDirectoryEntry directoryEntry : theDirectory) {
         int id = directoryEntry.getId();
         int offset = directoryEntry.getOffset();
         int length = directoryEntry.getLength();

         if (id == VariableEnum.NAME.getId()) {
            variable.setName(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == VariableEnum.DATATYPE.getId()) {
            variable.setDatatype(GreenballMessagesUtility.getString(ba, offset, length));
         }
      }

      log4j.debug("Leaving " + METHOD);
      return variable;
   }
   // Leaving buildUnpackMethod()

   /**
    * This method sets the name attribute. Setting of this value is required.
    * @param name The name attribute.
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * This method sets the datatype attribute. Setting of this value is required.
    * @param datatype The datatype attribute.
    */
   public void setDatatype(String datatype) {
      this.datatype = datatype;
   }

   /**
    * This method sets the multi attribute. Setting of this value is required.
    * @param multi The multi attribute.
    */
   public void setMulti(Boolean multi) {
      this.multi = multi;
   }

   /**
    * This method gets the name attribute. The name attribute is a required attribute.
    */
   public String getName() {
      return this.name;
   }

   /**
    * This method gets the datatype attribute. The datatype attribute is a required attribute.
    */
   public String getDatatype() {
      return this.datatype;
   }

   /**
    * This method gets the multi attribute. The multi attribute is a required attribute.
    */
   public Boolean getMulti() {
      return this.multi;
   }

   /**
    * This method gets the size of the directory.
    */
   private int getVariableDirectorySize() {
      int directorySize = 0;

      // name
      directorySize++;
      // datatype
      directorySize++;

      return directorySize;
   }


   /**
    * This method gets the size of the Variable object.
    * @return The size in bytes.
    */
   public int getVariableSize() {
      int size = 0;

      int directorySize = getVariableDirectorySize();
      size += directorySize * GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
      // Add size of name
      size += (getName() != null ? getName().length() : 0);
      // Add size of datatype
      size += (getDatatype() != null ? getDatatype().length() : 0);
      // Add size of multi
      size += 1;

      return size;
   }

   @Override
   public String toString() {
      StringBuilder result = new StringBuilder();
      String NEW_LINE = System.getProperty("line.separator");

      result.append(this.getClass().getSimpleName() + " Object {" + NEW_LINE);
      result.append(" name: " + name + NEW_LINE);
      result.append(" datatype: " + datatype + NEW_LINE);
      result.append(" multi: " + multi + NEW_LINE);

      result.append("} ");

      return result.toString();
   }

   /**
    * The hashCode method returns this object's hashCode.
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result
         + ((String) name).hashCode();
      result = prime * result
         + ((String) datatype).hashCode();
      result = prime * result
         + ((Boolean) multi).hashCode();
      return result;
   }

   /**
    * The equals method checks for equality. 
    */
   public boolean equals(Object obj) {
      if (obj == this) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;

      Variable variable = (Variable) obj;
      if (!variable.getName().equals(this.getName())) {
         return false;
      }

      if (!variable.getDatatype().equals(this.getDatatype())) {
         return false;
      }

      if (variable.getMulti() != this.getMulti()) {
         return false;
      }

      return true;
   }
}
