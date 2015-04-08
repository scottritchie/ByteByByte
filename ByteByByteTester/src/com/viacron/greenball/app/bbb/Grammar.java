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
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.viacron.utils.StringMessageBuffer.parser.AbstractAttribute;
import com.viacron.utils.StringMessageBuffer.parser.Element;
import com.viacron.utils.StringMessageBuffer.parser.KeyValuePair;
import com.viacron.utils.StringMessageBuffer.parser.SMBGLexer;
import com.viacron.utils.StringMessageBuffer.parser.SMBGParser;

/**
 * The Grammar class defines a message of the messaging system defined
 * by the GreenballMessages grammar. It provides methods for packing a Grammar object
 * into a byte array or string, and for unpacking a byte array or string
 * back into a Grammar object.
 */
public class Grammar {
   private static final int ID = GreenballMessagesEnum.GRAMMAR.getId();

   /**
    * The number of bits required to represent the GrammarEnum IDs.
    * # of attributes: 4
    * # of PEnumRefs: 0
    */
   private static final int ID_BITS = 2;

   private static GreenballMessagesDirectoryEntry[] theDirectory;
   private static final int DIRECTORY_OFFSET = 2;

   private static Logger log4j = Logger.getLogger(Grammar.class);

   // Entered buildClassEnum()
   private enum GrammarEnum {
      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      ORG_ID(0, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      ORG_NAME(1, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      VALUE(2, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      SESSION_ID(3, -1, 0, true);

      private final int id;
      private final int offsetInBits;
      private int length;
      private boolean isDirectoryEntry;

      GrammarEnum(int id, int offsetInBits, int length, boolean isDirectoryEntry) {
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
   private String orgId;
   private String orgName;
   private String value;
   private String sessionId;

   private String theErrorMsg;

   /**
    * The Grammar no-arg constructor.
    */
   public Grammar() {}

   /**
    * The Grammar constructor.
    * See buildParameterAnnotations() in JBitByBitGenerator.java.
    *
    * @param orgId The orgId message attribute.
    * @param orgName The orgName message attribute.
    * @param value The value message attribute.
    * @param sessionId The sessionId message attribute.
    */
   public Grammar(String orgId,
                  String orgName,
                  String value,
                  String sessionId) {
      // Entered buildParameterAssignments()
      this.setOrgId(orgId);
      this.setOrgName(orgName);
      this.setValue(value);
      this.setSessionId(sessionId);
      // Leaving buildParameterAssignments()
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
    * This method packs a Grammar object into a byte array. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A byte array which represents a Grammar message object.
    * @throws MissingAttributeException
    */
   public byte[] pack() throws MissingAttributeException {
      final String METHOD = "pack()";
      log4j.debug("Entered " + METHOD);

      int byteArraySize = getGrammarSize();
      log4j.debug("byteArraySize: " + byteArraySize);
      byte[] bb = new byte[byteArraySize];

      /*
       * Convert object to byte array.
       */
      int offset = 0;

      bb = GreenballMessagesUtility.insertShort(bb, offset, (short) ID);
      offset += 2;


      GrammarEnum.ORG_ID.setLength(this.getOrgId().length());
      GrammarEnum.ORG_NAME.setLength(this.getOrgName().length());
      GrammarEnum.VALUE.setLength(this.getValue().length());
      GrammarEnum.SESSION_ID.setLength(this.getSessionId().length());

      int directorySize = getGrammarDirectorySize();
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

         for (GrammarEnum grammarEnum : GrammarEnum.values()) {
            if (grammarEnum.isDirectoryEntry == true) {
               int id = grammarEnum.getId();
               int length = grammarEnum.getLength();

               theDirectory[index].setId(id);
               theDirectory[index].setLength(length);
               theDirectory[index].setOffset(offset);

               // Insert the data
               if (id == GrammarEnum.ORG_ID.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "orgId", offset));
                  bb = GreenballMessagesUtility.insertString(bb, offset, getOrgId());
                  offset += length * 1;
               }
               else if (id == GrammarEnum.ORG_NAME.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "orgName", offset));
                  bb = GreenballMessagesUtility.insertString(bb, offset, getOrgName());
                  offset += length * 1;
               }
               else if (id == GrammarEnum.VALUE.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "value", offset));
                  bb = GreenballMessagesUtility.insertString(bb, offset, getValue());
                  offset += length * 1;
               }
               else if (id == GrammarEnum.SESSION_ID.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "sessionId", offset));
                  bb = GreenballMessagesUtility.insertString(bb, offset, getSessionId());
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

         // Calculate and insert the checksum
         long checksum = GreenballMessagesUtility.getChecksum(bb, bb.length - 8);
         bb = GreenballMessagesUtility.insertLong(bb, bb.length - 8, checksum);
      }
      log4j.debug("Leaving " + METHOD);
      return bb;
   }
   // Leaving buildPackMethod()

   // Entered buildUnpackMethod()
   /**
    * This method unpacks a byte array containing a Grammar object.
    *
    * @return The byte array as a Grammar message object.
    */
   public Grammar unpack(byte[] ba) {
      final String METHOD = "unpack()";
      log4j.debug("Entered " + METHOD);

      Grammar grammar = new Grammar();


      // Get the directory
      int directorySize = getGrammarDirectorySize();
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

         if (id == GrammarEnum.ORG_ID.getId()) {
            grammar.setOrgId(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == GrammarEnum.ORG_NAME.getId()) {
            grammar.setOrgName(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == GrammarEnum.VALUE.getId()) {
            grammar.setValue(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == GrammarEnum.SESSION_ID.getId()) {
            grammar.setSessionId(GreenballMessagesUtility.getString(ba, offset, length));
         }
      }

      log4j.debug("Leaving " + METHOD);
      return grammar;
   }
   // Leaving buildUnpackMethod()

   // Entered buildPackStrMethod()
   /**
    * This method packs a Grammar object into a String. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A String which represents a Grammar message object.
    * @throws MissingAttributeException
    */
   public String packStr() throws MissingAttributeException {
      final String METHOD = "packStr()";
      log4j.debug("Entered " + METHOD);

      String msg = null;
      setErrorMsg(null);
       
      /*
       * Initialize attribute values.
       */
      InitializeGrammar initializeGrammar = new InitializeGrammar(this);
      Element element = initializeGrammar.initialize();

      if (getErrorMsg() == null) {
         /*
          * Convert object to String.
          * See convertObjectToString() in JBitByBitGenerator.java.
          */
         msg = "{" + element.getName();
         for (AbstractAttribute attr : element.getAbstractAttributes()) {
            msg = buildString(attr, msg);
         }
         msg = msg.concat("}");

         log4j.debug("msg: " + msg);
      }

      log4j.debug("Leaving " + METHOD);
      return msg;
   }
   // Leaving buildPackStrMethod()

   // Entered buildUnpackStrMethod()
   /**
    * The unpack() method unpacks a String into an object. The String must conform to the
    * SMBG grammar.
    *
     * @return The message string as an object.
    */
   public Grammar unpack(String buffer) {
      final String METHOD = "unpack()";
      log4j.debug("Entered " + METHOD);

      setErrorMsg(null);

      // Create the lexer
      log4j.debug("lexing...");
      SMBGLexer lexer = new SMBGLexer(new ANTLRStringStream(buffer));

      int nbrOfSyntaxErrors = lexer.getNumberOfSyntaxErrors();
      log4j.debug("# of lexer errors: " + nbrOfSyntaxErrors);

      // Check for errors
      if (nbrOfSyntaxErrors != 0) {
         for (String error : lexer.getErrors()) {
            log4j.error(error);
         }

         return null;
      }

      // Wrap a token-stream around the lexer
      CommonTokenStream tokenStream = new CommonTokenStream(lexer);

      // Create the parser
      log4j.debug("parsing...");
      SMBGParser parser = new SMBGParser(tokenStream);

      // Check for errors
      nbrOfSyntaxErrors = parser.getNumberOfSyntaxErrors();
      log4j.debug("# of parse errors: " + nbrOfSyntaxErrors);

      if (nbrOfSyntaxErrors != 0) {
         for (String error : parser.getErrors()) {
               log4j.error(error);
         }

         return null;
      }

      // Unpack the string into objects
      log4j.debug("unpacking...");
      try {
         parser.unpack();
      } catch (RecognitionException e) {
         log4j.error("Error: " + e.getMessage());
         setErrorMsg(e.getMessage());
         return null;
      }
      
      Element element = parser.getElement();
      element.dump();

      /*
       * Instantiate the Grammar object.
       */
       InstantiateGrammar instantiateGrammar = new InstantiateGrammar(element);
       Grammar grammar = instantiateGrammar.instantiate();

      /*
       * Verify that a value was provided for all mandatory attributes.
       */
      String result = instantiateGrammar.validate();
      if (result != null) {
         log4j.error("Error: " + result);
         setErrorMsg(result);
         return null;
      }

      log4j.debug("Leaving " + METHOD);
      return grammar;
   }
   // Leaving buildUnpackStrMethod()

   private String buildString(AbstractAttribute attr, String msg) {
      for (KeyValuePair kvp : attr.getKeyValuePairs()) {
         msg = msg.concat(" " + kvp.getKey() + ":" + kvp.getValue());
      }

      for (Element element : attr.getElements()) {
         msg = msg.concat(" {" + element.getName());
         for (AbstractAttribute abstractAttribute : element.getAbstractAttributes()) {
            msg = buildString(abstractAttribute, msg);
         }
         msg = msg.concat("}");
      }

      return msg;
   }

   /**
    * This method sets the orgId attribute. Setting of this value is required.
    * @param orgId The orgId attribute.
    */
   public void setOrgId(String orgId) {
      this.orgId = orgId;
   }

   /**
    * This method sets the orgName attribute. Setting of this value is required.
    * @param orgName The orgName attribute.
    */
   public void setOrgName(String orgName) {
      this.orgName = orgName;
   }

   /**
    * This method sets the value attribute. Setting of this value is required.
    * @param value The value attribute.
    */
   public void setValue(String value) {
      this.value = value;
   }

   /**
    * This method sets the sessionId attribute. Setting of this value is optional.
    * @param sessionId The sessionId attribute.
    */
   public void setSessionId(String sessionId) {
      this.sessionId = sessionId;
   }

   /**
    * This method gets the orgId attribute. The orgId attribute is a required attribute.
    */
   public String getOrgId() {
      return this.orgId;
   }

   /**
    * This method gets the orgName attribute. The orgName attribute is a required attribute.
    */
   public String getOrgName() {
      return this.orgName;
   }

   /**
    * This method gets the value attribute. The value attribute is a required attribute.
    */
   public String getValue() {
      return this.value;
   }

   /**
    * This method gets the sessionId attribute. The sessionId attribute is an optional attribute.
    */
   public String getSessionId() {
      return this.sessionId;
   }

   /**
    * This method gets the size of the directory.
    */
   private int getGrammarDirectorySize() {
      int directorySize = 0;

      // orgId
      directorySize++;
      // orgName
      directorySize++;
      // value
      directorySize++;
      // sessionId
      directorySize++;

      return directorySize;
   }


   /**
    * This method gets the size of the Grammar object.
    * @return The size in bytes.
    */
   public int getGrammarSize() {
      int size = 0;

      int directorySize = getGrammarDirectorySize();
      size += directorySize * GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
      // Add two bytes for the ID
      size += 2;
      // Add eight bytes for the CRC
      size += 8;
      // Add size of orgId
      size += (getOrgId() != null ? getOrgId().length() : 0);
      // Add size of orgName
      size += (getOrgName() != null ? getOrgName().length() : 0);
      // Add size of value
      size += (getValue() != null ? getValue().length() : 0);
      // Add size of sessionId
      size += (getSessionId() != null ? getSessionId().length() : 0);

      return size;
   }

   @Override
   public String toString() {
      StringBuilder result = new StringBuilder();
      String NEW_LINE = System.getProperty("line.separator");

      result.append(this.getClass().getSimpleName() + " Object {" + NEW_LINE);
      result.append(" orgId: " + orgId + NEW_LINE);
      result.append(" orgName: " + orgName + NEW_LINE);
      result.append(" value: " + value + NEW_LINE);
      result.append(" sessionId: " + sessionId + NEW_LINE);

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
         + ((String) orgId).hashCode();
      result = prime * result
         + ((String) orgName).hashCode();
      result = prime * result
         + ((String) value).hashCode();
      result = prime * result
         + ((String) sessionId).hashCode();
      return result;
   }

   /**
    * The equals method checks for equality. 
    */
   public boolean equals(Object obj) {
      if (obj == this) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;

      Grammar grammar = (Grammar) obj;
      if (!grammar.getOrgId().equals(this.getOrgId())) {
         return false;
      }

      if (!grammar.getOrgName().equals(this.getOrgName())) {
         return false;
      }

      if (!grammar.getValue().equals(this.getValue())) {
         return false;
      }

      if (grammar.getSessionId() == null && this.getSessionId() != null) {
         return false;
      }
      else if (grammar.getSessionId() != null && this.getSessionId() == null) {
         return false;
      }
      else if (grammar.getSessionId() != null && 
      !grammar.getSessionId().equals(this.getSessionId())) {
         return false;
      }

      return true;
   }
}
