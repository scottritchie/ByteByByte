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
 * The RequestSubscription class defines a message of the messaging system defined
 * by the GreenballMessages grammar. It provides methods for packing a RequestSubscription object
 * into a byte array or string, and for unpacking a byte array or string
 * back into a RequestSubscription object.
 */
public class RequestSubscription {
   private static final int ID = GreenballMessagesEnum.REQUEST_SUBSCRIPTION.getId();

   /**
    * The number of bits required to represent the RequestSubscriptionEnum IDs.
    * # of attributes: 5
    * # of PEnumRefs: 0
    */
   private static final int ID_BITS = 3;

   private static GreenballMessagesDirectoryEntry[] theDirectory;
   private static final int DIRECTORY_OFFSET = 2;

   private static Logger log4j = Logger.getLogger(RequestSubscription.class);

   // Entered buildClassEnum()
   private enum RequestSubscriptionEnum {
      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      REQUESTOR(0, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      MESSAGE(1, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      ORG_ID(2, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      ORG_NAME(3, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      SESSION_ID(4, -1, 0, true);

      private final int id;
      private final int offsetInBits;
      private int length;
      private boolean isDirectoryEntry;

      RequestSubscriptionEnum(int id, int offsetInBits, int length, boolean isDirectoryEntry) {
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
   private String requestor;
   private String message;
   private String orgId;
   private String orgName;
   private String sessionId;

   private String theErrorMsg;

   /**
    * The RequestSubscription no-arg constructor.
    */
   public RequestSubscription() {}

   /**
    * The RequestSubscription constructor.
    * See buildParameterAnnotations() in JBitByBitGenerator.java.
    *
    * @param requestor The requestor message attribute.
    * @param message The message message attribute.
    * @param orgId The orgId message attribute.
    * @param orgName The orgName message attribute.
    * @param sessionId The sessionId message attribute.
    */
   public RequestSubscription(String requestor,
                              String message,
                              String orgId,
                              String orgName,
                              String sessionId) {
      // Entered buildParameterAssignments()
      this.setRequestor(requestor);
      this.setMessage(message);
      this.setOrgId(orgId);
      this.setOrgName(orgName);
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
    * This method packs a RequestSubscription object into a byte array. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A byte array which represents a RequestSubscription message object.
    * @throws MissingAttributeException
    */
   public byte[] pack() throws MissingAttributeException {
      final String METHOD = "pack()";
      log4j.debug("Entered " + METHOD);

      int byteArraySize = getRequestSubscriptionSize();
      log4j.debug("byteArraySize: " + byteArraySize);
      byte[] bb = new byte[byteArraySize];

      /*
       * Convert object to byte array.
       */
      int offset = 0;

      bb = GreenballMessagesUtility.insertShort(bb, offset, (short) ID);
      offset += 2;


      RequestSubscriptionEnum.REQUESTOR.setLength(this.getRequestor() != null ? this.getRequestor().length() : 0);
      RequestSubscriptionEnum.MESSAGE.setLength(this.getMessage() != null ? this.getMessage().length() : 0);
      RequestSubscriptionEnum.ORG_ID.setLength(this.getOrgId() != null ? this.getOrgId().length() : 0);
      RequestSubscriptionEnum.ORG_NAME.setLength(this.getOrgName() != null ? this.getOrgName().length() : 0);
      RequestSubscriptionEnum.SESSION_ID.setLength(this.getSessionId() != null ? this.getSessionId().length() : 0);

      int directorySize = getRequestSubscriptionDirectorySize();
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

         for (RequestSubscriptionEnum requestSubscriptionEnum : RequestSubscriptionEnum.values()) {
            if (requestSubscriptionEnum.isDirectoryEntry == true) {
               int id = requestSubscriptionEnum.getId();
               int length = requestSubscriptionEnum.getLength();

               theDirectory[index].setId(id);
               theDirectory[index].setLength(length);
               theDirectory[index].setOffset(offset);

               // Insert the data
               if (id == RequestSubscriptionEnum.REQUESTOR.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "requestor", offset));
                  if (getRequestor() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getRequestor());
                     offset += length * 1;
                  }
               }
               else if (id == RequestSubscriptionEnum.MESSAGE.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "message", offset));
                  if (getMessage() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getMessage());
                     offset += length * 1;
                  }
               }
               else if (id == RequestSubscriptionEnum.ORG_ID.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "orgId", offset));
                  if (getOrgId() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getOrgId());
                     offset += length * 1;
                  }
               }
               else if (id == RequestSubscriptionEnum.ORG_NAME.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "orgName", offset));
                  if (getOrgName() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getOrgName());
                     offset += length * 1;
                  }
               }
               else if (id == RequestSubscriptionEnum.SESSION_ID.getId()) {
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
    * This method unpacks a byte array containing a RequestSubscription object.
    *
    * @return The byte array as a RequestSubscription message object.
    */
   public RequestSubscription unpack(byte[] ba) {
      final String METHOD = "unpack()";
      log4j.debug("Entered " + METHOD);

      RequestSubscription requestSubscription = new RequestSubscription();


      // Get the directory
      int directorySize = getRequestSubscriptionDirectorySize();
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

         if (id == RequestSubscriptionEnum.REQUESTOR.getId()) {
            requestSubscription.setRequestor(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == RequestSubscriptionEnum.MESSAGE.getId()) {
            requestSubscription.setMessage(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == RequestSubscriptionEnum.ORG_ID.getId()) {
            requestSubscription.setOrgId(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == RequestSubscriptionEnum.ORG_NAME.getId()) {
            requestSubscription.setOrgName(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == RequestSubscriptionEnum.SESSION_ID.getId()) {
            requestSubscription.setSessionId(GreenballMessagesUtility.getString(ba, offset, length));
         }
      }

      log4j.debug("Leaving " + METHOD);
      return requestSubscription;
   }
   // Leaving buildUnpackMethod()

   // Entered buildPackStrMethod()
   /**
    * This method packs a RequestSubscription object into a String. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A String which represents a RequestSubscription message object.
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
      InitializeRequestSubscription initializeRequestSubscription = new InitializeRequestSubscription(this);
      Element element = initializeRequestSubscription.initialize();

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
   public RequestSubscription unpack(String buffer) {
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
       * Instantiate the RequestSubscription object.
       */
       InstantiateRequestSubscription instantiateRequestSubscription = new InstantiateRequestSubscription(element);
       RequestSubscription requestSubscription = instantiateRequestSubscription.instantiate();

      /*
       * Verify that a value was provided for all mandatory attributes.
       */
      String result = instantiateRequestSubscription.validate();
      if (result != null) {
         log4j.error("Error: " + result);
         setErrorMsg(result);
         return null;
      }

      log4j.debug("Leaving " + METHOD);
      return requestSubscription;
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
    * This method sets the requestor attribute. Setting of this value is required.
    * @param requestor The requestor attribute.
    */
   public void setRequestor(String requestor) {
      this.requestor = requestor;
   }

   /**
    * This method sets the message attribute. Setting of this value is optional.
    * @param message The message attribute.
    */
   public void setMessage(String message) {
      this.message = message;
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
    * This method sets the sessionId attribute. Setting of this value is optional.
    * @param sessionId The sessionId attribute.
    */
   public void setSessionId(String sessionId) {
      this.sessionId = sessionId;
   }

   /**
    * This method gets the requestor attribute. The requestor attribute is a required attribute.
    */
   public String getRequestor() {
      return this.requestor;
   }

   /**
    * This method gets the message attribute. The message attribute is an optional attribute.
    */
   public String getMessage() {
      return this.message;
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
    * This method gets the sessionId attribute. The sessionId attribute is an optional attribute.
    */
   public String getSessionId() {
      return this.sessionId;
   }

   /**
    * This method gets the size of the directory.
    */
   private int getRequestSubscriptionDirectorySize() {
      int directorySize = 0;

      // requestor
      directorySize++;
      // message
      directorySize++;
      // orgId
      directorySize++;
      // orgName
      directorySize++;
      // sessionId
      directorySize++;

      return directorySize;
   }


   /**
    * This method gets the size of the RequestSubscription object.
    * @return The size in bytes.
    */
   public int getRequestSubscriptionSize() {
      int size = 0;

      int directorySize = getRequestSubscriptionDirectorySize();
      size += directorySize * GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
      // Add two bytes for the ID
      size += 2;
      // Add eight bytes for the CRC
      size += 8;
      // Add size of requestor
      size += (getRequestor() != null ? getRequestor().length() : 0);
      // Add size of message
      size += (getMessage() != null ? getMessage().length() : 0);
      // Add size of orgId
      size += (getOrgId() != null ? getOrgId().length() : 0);
      // Add size of orgName
      size += (getOrgName() != null ? getOrgName().length() : 0);
      // Add size of sessionId
      size += (getSessionId() != null ? getSessionId().length() : 0);

      return size;
   }

   @Override
   public String toString() {
      StringBuilder result = new StringBuilder();
      String NEW_LINE = System.getProperty("line.separator");

      result.append(this.getClass().getSimpleName() + " Object {" + NEW_LINE);
      result.append(" requestor: " + requestor + NEW_LINE);
      result.append(" message: " + message + NEW_LINE);
      result.append(" orgId: " + orgId + NEW_LINE);
      result.append(" orgName: " + orgName + NEW_LINE);
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
         + ((String) requestor).hashCode();
      result = prime * result
         + ((String) message).hashCode();
      result = prime * result
         + ((String) orgId).hashCode();
      result = prime * result
         + ((String) orgName).hashCode();
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

      RequestSubscription requestSubscription = (RequestSubscription) obj;
      if (!requestSubscription.getRequestor().equals(this.getRequestor())) {
         return false;
      }

      if (requestSubscription.getMessage() == null && this.getMessage() != null) {
         return false;
      }
      else if (requestSubscription.getMessage() != null && this.getMessage() == null) {
         return false;
      }
      else if (requestSubscription.getMessage() != null && 
      !requestSubscription.getMessage().equals(this.getMessage())) {
         return false;
      }

      if (!requestSubscription.getOrgId().equals(this.getOrgId())) {
         return false;
      }

      if (!requestSubscription.getOrgName().equals(this.getOrgName())) {
         return false;
      }

      if (requestSubscription.getSessionId() == null && this.getSessionId() != null) {
         return false;
      }
      else if (requestSubscription.getSessionId() != null && this.getSessionId() == null) {
         return false;
      }
      else if (requestSubscription.getSessionId() != null && 
      !requestSubscription.getSessionId().equals(this.getSessionId())) {
         return false;
      }

      return true;
   }
}
