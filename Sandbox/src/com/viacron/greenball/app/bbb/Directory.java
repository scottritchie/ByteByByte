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
 * The Directory class defines a message of the messaging system defined
 * by the GreenballMessages grammar. It provides methods for packing a Directory object
 * into a byte array or string, and for unpacking a byte array or string
 * back into a Directory object.
 */
public class Directory {
   private static final int ID = GreenballMessagesEnum.DIRECTORY.getId();

   /**
    * The number of bits required to represent the DirectoryEnum IDs.
    * # of attributes: 2
    * # of PEnumRefs: 0
    */
   private static final int ID_BITS = 1;

   private static GreenballMessagesDirectoryEntry[] theDirectory;
   private static final int DIRECTORY_OFFSET = 2;

   private static Logger log4j = Logger.getLogger(Directory.class);

   // Entered buildClassEnum()
   private enum DirectoryEnum {
      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      USER_NAME(0, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      SESSION_ID(1, -1, 0, true);

      private final int id;
      private final int offsetInBits;
      private int length;
      private boolean isDirectoryEntry;

      DirectoryEnum(int id, int offsetInBits, int length, boolean isDirectoryEntry) {
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
   private String userName;
   private String sessionId;

   private String theErrorMsg;

   /**
    * The Directory no-arg constructor.
    */
   public Directory() {}

   /**
    * The Directory constructor.
    * See buildParameterAnnotations() in JBitByBitGenerator.java.
    *
    * @param userName The userName message attribute.
    * @param sessionId The sessionId message attribute.
    */
   public Directory(String userName,
                    String sessionId) {
      // Entered buildParameterAssignments()
      this.setUserName(userName);
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
    * This method packs a Directory object into a byte array. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A byte array which represents a Directory message object.
    * @throws MissingAttributeException
    */
   public byte[] pack() throws MissingAttributeException {
      final String METHOD = "pack()";
      log4j.debug("Entered " + METHOD);

      int byteArraySize = getDirectorySize();
      log4j.debug("byteArraySize: " + byteArraySize);
      byte[] bb = new byte[byteArraySize];

      /*
       * Convert object to byte array.
       */
      int offset = 0;

      bb = GreenballMessagesUtility.insertShort(bb, offset, (short) ID);
      offset += 2;


      DirectoryEnum.USER_NAME.setLength(this.getUserName() != null ? this.getUserName().length() : 0);
      DirectoryEnum.SESSION_ID.setLength(this.getSessionId() != null ? this.getSessionId().length() : 0);

      int directorySize = getDirectoryDirectorySize();
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

         for (DirectoryEnum directoryEnum : DirectoryEnum.values()) {
            if (directoryEnum.isDirectoryEntry == true) {
               int id = directoryEnum.getId();
               int length = directoryEnum.getLength();

               theDirectory[index].setId(id);
               theDirectory[index].setLength(length);
               theDirectory[index].setOffset(offset);

               // Insert the data
               if (id == DirectoryEnum.USER_NAME.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "userName", offset));
                  if (getUserName() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getUserName());
                     offset += length * 1;
                  }
               }
               else if (id == DirectoryEnum.SESSION_ID.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "sessionId", offset));
                  if (getSessionId() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getSessionId());
                     offset += length * 1;
                  }
               }
               index++;
            }
         }

         // Insert the directory
         log4j.debug(String.format("inserting the directory at offset %d", DIRECTORY_OFFSET));
         offset = DIRECTORY_OFFSET;
         index = 0;
         for (GreenballMessagesDirectoryEntry directoryEntry : theDirectory) {
            log4j.debug(String.format("index[%d]: ", index));
            log4j.debug(String.format("  ID:     %d", directoryEntry.getId()));
            log4j.debug(String.format("  length: %d", directoryEntry.getLength()));
            log4j.debug(String.format("  offset: %d", directoryEntry.getOffset()));
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
    * This method unpacks a byte array containing a Directory object.
    *
    * @return The byte array as a Directory message object.
    */
   public Directory unpack(byte[] ba) {
      final String METHOD = "unpack()";
      log4j.debug("Entered " + METHOD);

      Directory directory = new Directory();


      // Get the directory
      int directorySize = getDirectoryDirectorySize();
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

         if (id == DirectoryEnum.USER_NAME.getId()) {
            directory.setUserName(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == DirectoryEnum.SESSION_ID.getId()) {
            directory.setSessionId(GreenballMessagesUtility.getString(ba, offset, length));
         }
      }

      log4j.debug("Leaving " + METHOD);
      return directory;
   }
   // Leaving buildUnpackMethod()

   // Entered buildPackStrMethod()
   /**
    * This method packs a Directory object into a String. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A String which represents a Directory message object.
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
      InitializeDirectory initializeDirectory = new InitializeDirectory(this);
      Element element = initializeDirectory.initialize();

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
   public Directory unpack(String buffer) {
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
       * Instantiate the Directory object.
       */
       InstantiateDirectory instantiateDirectory = new InstantiateDirectory(element);
       Directory directory = instantiateDirectory.instantiate();

      /*
       * Verify that a value was provided for all mandatory attributes.
       */
      String result = instantiateDirectory.validate();
      if (result != null) {
         log4j.error("Error: " + result);
         setErrorMsg(result);
         return null;
      }

      log4j.debug("Leaving " + METHOD);
      return directory;
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
    * This method sets the userName attribute. Setting of this value is required.
    * @param userName The userName attribute.
    */
   public void setUserName(String userName) {
      this.userName = userName;
   }

   /**
    * This method sets the sessionId attribute. Setting of this value is required.
    * @param sessionId The sessionId attribute.
    */
   public void setSessionId(String sessionId) {
      this.sessionId = sessionId;
   }

   /**
    * This method gets the userName attribute. The userName attribute is a required attribute.
    */
   public String getUserName() {
      return this.userName;
   }

   /**
    * This method gets the sessionId attribute. The sessionId attribute is a required attribute.
    */
   public String getSessionId() {
      return this.sessionId;
   }

   /**
    * This method gets the size of the directory.
    */
   private int getDirectoryDirectorySize() {
      int directorySize = 0;

      // userName
      directorySize++;
      // sessionId
      directorySize++;

      return directorySize;
   }


   /**
    * This method gets the size of the Directory object.
    * @return The size in bytes.
    */
   public int getDirectorySize() {
      int size = 0;

      int directorySize = getDirectoryDirectorySize();
      size += directorySize * GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
      // Add two bytes for the ID
      size += 2;
      // Add eight bytes for the CRC
      size += 8;
      // Add size of userName
      size += (getUserName() != null ? getUserName().length() : 0);
      // Add size of sessionId
      size += (getSessionId() != null ? getSessionId().length() : 0);

      return size;
   }

   @Override
   public String toString() {
      StringBuilder result = new StringBuilder();
      String NEW_LINE = System.getProperty("line.separator");

      result.append(this.getClass().getSimpleName() + " Object {" + NEW_LINE);
      result.append(" userName: " + userName + NEW_LINE);
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
         + ((String) userName).hashCode();
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

      Directory directory = (Directory) obj;
      if (!directory.getUserName().equals(this.getUserName())) {
         return false;
      }

      if (!directory.getSessionId().equals(this.getSessionId())) {
         return false;
      }

      return true;
   }
}
