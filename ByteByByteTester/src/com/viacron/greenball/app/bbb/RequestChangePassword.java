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
 * The RequestChangePassword class defines a message of the messaging system defined
 * by the GreenballMessages grammar. It provides methods for packing a RequestChangePassword object
 * into a byte array or string, and for unpacking a byte array or string
 * back into a RequestChangePassword object.
 */
public class RequestChangePassword {
   private static final int ID = GreenballMessagesEnum.REQUEST_CHANGE_PASSWORD.getId();

   /**
    * The number of bits required to represent the RequestChangePasswordEnum IDs.
    * # of attributes: 4
    * # of PEnumRefs: 0
    */
   private static final int ID_BITS = 2;

   private static GreenballMessagesDirectoryEntry[] theDirectory;
   private static final int DIRECTORY_OFFSET = 2;

   private static Logger log4j = Logger.getLogger(RequestChangePassword.class);

   // Entered buildClassEnum()
   private enum RequestChangePasswordEnum {
      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      USER(0, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      OLD_PASSWORD(1, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      NEW_PASSWORD(2, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      SESSION_ID(3, -1, 0, true);

      private final int id;
      private final int offsetInBits;
      private int length;
      private boolean isDirectoryEntry;

      RequestChangePasswordEnum(int id, int offsetInBits, int length, boolean isDirectoryEntry) {
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
   private String user;
   private String oldPassword;
   private String newPassword;
   private String sessionId;

   private String theErrorMsg;

   /**
    * The RequestChangePassword no-arg constructor.
    */
   public RequestChangePassword() {}

   /**
    * The RequestChangePassword constructor.
    * See buildParameterAnnotations() in JBitByBitGenerator.java.
    *
    * @param user The user message attribute.
    * @param oldPassword The oldPassword message attribute.
    * @param newPassword The newPassword message attribute.
    * @param sessionId The sessionId message attribute.
    */
   public RequestChangePassword(String user,
                                String oldPassword,
                                String newPassword,
                                String sessionId) {
      // Entered buildParameterAssignments()
      this.setUser(user);
      this.setOldPassword(oldPassword);
      this.setNewPassword(newPassword);
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
    * This method packs a RequestChangePassword object into a byte array. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A byte array which represents a RequestChangePassword message object.
    * @throws MissingAttributeException
    */
   public byte[] pack() throws MissingAttributeException {
      final String METHOD = "pack()";
      log4j.debug("Entered " + METHOD);

      int byteArraySize = getRequestChangePasswordSize();
      log4j.debug("byteArraySize: " + byteArraySize);
      byte[] bb = new byte[byteArraySize];

      /*
       * Convert object to byte array.
       */
      int offset = 0;

      bb = GreenballMessagesUtility.insertShort(bb, offset, (short) ID);
      offset += 2;


      RequestChangePasswordEnum.USER.setLength(this.getUser().length());
      RequestChangePasswordEnum.OLD_PASSWORD.setLength(this.getOldPassword().length());
      RequestChangePasswordEnum.NEW_PASSWORD.setLength(this.getNewPassword().length());
      RequestChangePasswordEnum.SESSION_ID.setLength(this.getSessionId().length());

      int directorySize = getRequestChangePasswordDirectorySize();
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

         for (RequestChangePasswordEnum requestChangePasswordEnum : RequestChangePasswordEnum.values()) {
            if (requestChangePasswordEnum.isDirectoryEntry == true) {
               int id = requestChangePasswordEnum.getId();
               int length = requestChangePasswordEnum.getLength();

               theDirectory[index].setId(id);
               theDirectory[index].setLength(length);
               theDirectory[index].setOffset(offset);

               // Insert the data
               if (id == RequestChangePasswordEnum.USER.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "user", offset));
                  bb = GreenballMessagesUtility.insertString(bb, offset, getUser());
                  offset += length * 1;
               }
               else if (id == RequestChangePasswordEnum.OLD_PASSWORD.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "oldPassword", offset));
                  bb = GreenballMessagesUtility.insertString(bb, offset, getOldPassword());
                  offset += length * 1;
               }
               else if (id == RequestChangePasswordEnum.NEW_PASSWORD.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "newPassword", offset));
                  bb = GreenballMessagesUtility.insertString(bb, offset, getNewPassword());
                  offset += length * 1;
               }
               else if (id == RequestChangePasswordEnum.SESSION_ID.getId()) {
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
    * This method unpacks a byte array containing a RequestChangePassword object.
    *
    * @return The byte array as a RequestChangePassword message object.
    */
   public RequestChangePassword unpack(byte[] ba) {
      final String METHOD = "unpack()";
      log4j.debug("Entered " + METHOD);

      RequestChangePassword requestChangePassword = new RequestChangePassword();


      // Get the directory
      int directorySize = getRequestChangePasswordDirectorySize();
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

         if (id == RequestChangePasswordEnum.USER.getId()) {
            requestChangePassword.setUser(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == RequestChangePasswordEnum.OLD_PASSWORD.getId()) {
            requestChangePassword.setOldPassword(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == RequestChangePasswordEnum.NEW_PASSWORD.getId()) {
            requestChangePassword.setNewPassword(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == RequestChangePasswordEnum.SESSION_ID.getId()) {
            requestChangePassword.setSessionId(GreenballMessagesUtility.getString(ba, offset, length));
         }
      }

      log4j.debug("Leaving " + METHOD);
      return requestChangePassword;
   }
   // Leaving buildUnpackMethod()

   // Entered buildPackStrMethod()
   /**
    * This method packs a RequestChangePassword object into a String. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A String which represents a RequestChangePassword message object.
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
      InitializeRequestChangePassword initializeRequestChangePassword = new InitializeRequestChangePassword(this);
      Element element = initializeRequestChangePassword.initialize();

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
   public RequestChangePassword unpack(String buffer) {
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
       * Instantiate the RequestChangePassword object.
       */
       InstantiateRequestChangePassword instantiateRequestChangePassword = new InstantiateRequestChangePassword(element);
       RequestChangePassword requestChangePassword = instantiateRequestChangePassword.instantiate();

      /*
       * Verify that a value was provided for all mandatory attributes.
       */
      String result = instantiateRequestChangePassword.validate();
      if (result != null) {
         log4j.error("Error: " + result);
         setErrorMsg(result);
         return null;
      }

      log4j.debug("Leaving " + METHOD);
      return requestChangePassword;
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
    * This method sets the user attribute. Setting of this value is required.
    * @param user The user attribute.
    */
   public void setUser(String user) {
      this.user = user;
   }

   /**
    * This method sets the oldPassword attribute. Setting of this value is required.
    * @param oldPassword The oldPassword attribute.
    */
   public void setOldPassword(String oldPassword) {
      this.oldPassword = oldPassword;
   }

   /**
    * This method sets the newPassword attribute. Setting of this value is required.
    * @param newPassword The newPassword attribute.
    */
   public void setNewPassword(String newPassword) {
      this.newPassword = newPassword;
   }

   /**
    * This method sets the sessionId attribute. Setting of this value is optional.
    * @param sessionId The sessionId attribute.
    */
   public void setSessionId(String sessionId) {
      this.sessionId = sessionId;
   }

   /**
    * This method gets the user attribute. The user attribute is a required attribute.
    */
   public String getUser() {
      return this.user;
   }

   /**
    * This method gets the oldPassword attribute. The oldPassword attribute is a required attribute.
    */
   public String getOldPassword() {
      return this.oldPassword;
   }

   /**
    * This method gets the newPassword attribute. The newPassword attribute is a required attribute.
    */
   public String getNewPassword() {
      return this.newPassword;
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
   private int getRequestChangePasswordDirectorySize() {
      int directorySize = 0;

      // user
      directorySize++;
      // oldPassword
      directorySize++;
      // newPassword
      directorySize++;
      // sessionId
      directorySize++;

      return directorySize;
   }


   /**
    * This method gets the size of the RequestChangePassword object.
    * @return The size in bytes.
    */
   public int getRequestChangePasswordSize() {
      int size = 0;

      int directorySize = getRequestChangePasswordDirectorySize();
      size += directorySize * GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
      // Add two bytes for the ID
      size += 2;
      // Add eight bytes for the CRC
      size += 8;
      // Add size of user
      size += (getUser() != null ? getUser().length() : 0);
      // Add size of oldPassword
      size += (getOldPassword() != null ? getOldPassword().length() : 0);
      // Add size of newPassword
      size += (getNewPassword() != null ? getNewPassword().length() : 0);
      // Add size of sessionId
      size += (getSessionId() != null ? getSessionId().length() : 0);

      return size;
   }

   @Override
   public String toString() {
      StringBuilder result = new StringBuilder();
      String NEW_LINE = System.getProperty("line.separator");

      result.append(this.getClass().getSimpleName() + " Object {" + NEW_LINE);
      result.append(" user: " + user + NEW_LINE);
      result.append(" oldPassword: " + oldPassword + NEW_LINE);
      result.append(" newPassword: " + newPassword + NEW_LINE);
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
         + ((String) user).hashCode();
      result = prime * result
         + ((String) oldPassword).hashCode();
      result = prime * result
         + ((String) newPassword).hashCode();
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

      RequestChangePassword requestChangePassword = (RequestChangePassword) obj;
      if (!requestChangePassword.getUser().equals(this.getUser())) {
         return false;
      }

      if (!requestChangePassword.getOldPassword().equals(this.getOldPassword())) {
         return false;
      }

      if (!requestChangePassword.getNewPassword().equals(this.getNewPassword())) {
         return false;
      }

      if (requestChangePassword.getSessionId() == null && this.getSessionId() != null) {
         return false;
      }
      else if (requestChangePassword.getSessionId() != null && this.getSessionId() == null) {
         return false;
      }
      else if (requestChangePassword.getSessionId() != null && 
      !requestChangePassword.getSessionId().equals(this.getSessionId())) {
         return false;
      }

      return true;
   }
}