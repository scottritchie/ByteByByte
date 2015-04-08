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
 * The DeleteRuleMessageResponse class defines a message of the messaging system defined
 * by the GreenballMessages grammar. It provides methods for packing a DeleteRuleMessageResponse object
 * into a byte array or string, and for unpacking a byte array or string
 * back into a DeleteRuleMessageResponse object.
 */
public class DeleteRuleMessageResponse {
   private static final int ID = GreenballMessagesEnum.DELETE_RULE_MESSAGE_RESPONSE.getId();

   /**
    * The number of bits required to represent the DeleteRuleMessageResponseEnum IDs.
    * # of attributes: 8
    * # of PEnumRefs: 0
    */
   private static final int ID_BITS = 3;

   private static GreenballMessagesDirectoryEntry[] theDirectory;
   private static final int DIRECTORY_OFFSET = 3;

   private static Logger log4j = Logger.getLogger(DeleteRuleMessageResponse.class);

   // Entered buildClassEnum()
   private enum DeleteRuleMessageResponseEnum {
      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      ORG_ID(0, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      ORG_NAME(1, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      MODEL_NAME(2, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      RULE_ID(3, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      RULE_NAME(4, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      USER_NAME(5, -1, 0, true),

      // sizeInBits: 8
      IS_DELETED(6, 16, 0, false),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      SESSION_ID(7, -1, 0, true);

      private final int id;
      private final int offsetInBits;
      private int length;
      private boolean isDirectoryEntry;

      DeleteRuleMessageResponseEnum(int id, int offsetInBits, int length, boolean isDirectoryEntry) {
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
   private String modelName;
   private String ruleId;
   private String ruleName;
   private String userName;
   private boolean isDeleted;
   private String sessionId;

   private String theErrorMsg;

   /**
    * The DeleteRuleMessageResponse no-arg constructor.
    */
   public DeleteRuleMessageResponse() {}

   /**
    * The DeleteRuleMessageResponse constructor.
    * See buildParameterAnnotations() in JBitByBitGenerator.java.
    *
    * @param orgId The orgId message attribute.
    * @param orgName The orgName message attribute.
    * @param modelName The modelName message attribute.
    * @param ruleId The ruleId message attribute.
    * @param ruleName The ruleName message attribute.
    * @param userName The userName message attribute.
    * @param isDeleted The isDeleted message attribute.
    * @param sessionId The sessionId message attribute.
    */
   public DeleteRuleMessageResponse(String orgId,
                                    String orgName,
                                    String modelName,
                                    String ruleId,
                                    String ruleName,
                                    String userName,
                                    Boolean isDeleted,
                                    String sessionId) {
      // Entered buildParameterAssignments()
      this.setOrgId(orgId);
      this.setOrgName(orgName);
      this.setModelName(modelName);
      this.setRuleId(ruleId);
      this.setRuleName(ruleName);
      this.setUserName(userName);
      this.setIsDeleted(isDeleted);
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
    * This method packs a DeleteRuleMessageResponse object into a byte array. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A byte array which represents a DeleteRuleMessageResponse message object.
    * @throws MissingAttributeException
    */
   public byte[] pack() throws MissingAttributeException {
      final String METHOD = "pack()";
      log4j.debug("Entered " + METHOD);

      int byteArraySize = getDeleteRuleMessageResponseSize();
      log4j.debug("byteArraySize: " + byteArraySize);
      byte[] bb = new byte[byteArraySize];

      /*
       * Convert object to byte array.
       */
      int offset = 0;

      bb = GreenballMessagesUtility.insertShort(bb, offset, (short) ID);
      offset += 2;

      if (this.getIsDeleted() != null) {
         log4j.debug(String.format("inserting %s at offset %d", "isDeleted", offset));
         bb = GreenballMessagesUtility.insertBitfield(bb, offset * 8, 1, this.getIsDeleted() == true ? 1 : 0);
         offset += 1;
      } else {
         /*
          * Missing required attribute, generate an error message and throw
          * an exception.
          */
         setErrorMsg("Error packing object. The attribute \"isDeleted\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }


      DeleteRuleMessageResponseEnum.ORG_ID.setLength(this.getOrgId() != null ? this.getOrgId().length() : 0);
      DeleteRuleMessageResponseEnum.ORG_NAME.setLength(this.getOrgName() != null ? this.getOrgName().length() : 0);
      DeleteRuleMessageResponseEnum.MODEL_NAME.setLength(this.getModelName() != null ? this.getModelName().length() : 0);
      DeleteRuleMessageResponseEnum.RULE_ID.setLength(this.getRuleId() != null ? this.getRuleId().length() : 0);
      DeleteRuleMessageResponseEnum.RULE_NAME.setLength(this.getRuleName() != null ? this.getRuleName().length() : 0);
      DeleteRuleMessageResponseEnum.USER_NAME.setLength(this.getUserName() != null ? this.getUserName().length() : 0);
      DeleteRuleMessageResponseEnum.SESSION_ID.setLength(this.getSessionId() != null ? this.getSessionId().length() : 0);

      int directorySize = getDeleteRuleMessageResponseDirectorySize();
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

         for (DeleteRuleMessageResponseEnum deleteRuleMessageResponseEnum : DeleteRuleMessageResponseEnum.values()) {
            if (deleteRuleMessageResponseEnum.isDirectoryEntry == true) {
               int id = deleteRuleMessageResponseEnum.getId();
               int length = deleteRuleMessageResponseEnum.getLength();

               theDirectory[index].setId(id);
               theDirectory[index].setLength(length);
               theDirectory[index].setOffset(offset);

               // Insert the data
               if (id == DeleteRuleMessageResponseEnum.ORG_ID.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "orgId", offset));
                  if (getOrgId() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getOrgId());
                     offset += length * 1;
                  }
               }
               else if (id == DeleteRuleMessageResponseEnum.ORG_NAME.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "orgName", offset));
                  if (getOrgName() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getOrgName());
                     offset += length * 1;
                  }
               }
               else if (id == DeleteRuleMessageResponseEnum.MODEL_NAME.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "modelName", offset));
                  if (getModelName() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getModelName());
                     offset += length * 1;
                  }
               }
               else if (id == DeleteRuleMessageResponseEnum.RULE_ID.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "ruleId", offset));
                  if (getRuleId() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getRuleId());
                     offset += length * 1;
                  }
               }
               else if (id == DeleteRuleMessageResponseEnum.RULE_NAME.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "ruleName", offset));
                  if (getRuleName() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getRuleName());
                     offset += length * 1;
                  }
               }
               else if (id == DeleteRuleMessageResponseEnum.USER_NAME.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "userName", offset));
                  if (getUserName() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getUserName());
                     offset += length * 1;
                  }
               }
               else if (id == DeleteRuleMessageResponseEnum.SESSION_ID.getId()) {
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
    * This method unpacks a byte array containing a DeleteRuleMessageResponse object.
    *
    * @return The byte array as a DeleteRuleMessageResponse message object.
    */
   public DeleteRuleMessageResponse unpack(byte[] ba) {
      final String METHOD = "unpack()";
      log4j.debug("Entered " + METHOD);

      DeleteRuleMessageResponse deleteRuleMessageResponse = new DeleteRuleMessageResponse();

      deleteRuleMessageResponse.setIsDeleted(GreenballMessagesUtility.getBoolean(ba, DeleteRuleMessageResponseEnum.IS_DELETED.getOffsetInBits()));

      // Get the directory
      int directorySize = getDeleteRuleMessageResponseDirectorySize();
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

         if (id == DeleteRuleMessageResponseEnum.ORG_ID.getId()) {
            deleteRuleMessageResponse.setOrgId(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == DeleteRuleMessageResponseEnum.ORG_NAME.getId()) {
            deleteRuleMessageResponse.setOrgName(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == DeleteRuleMessageResponseEnum.MODEL_NAME.getId()) {
            deleteRuleMessageResponse.setModelName(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == DeleteRuleMessageResponseEnum.RULE_ID.getId()) {
            deleteRuleMessageResponse.setRuleId(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == DeleteRuleMessageResponseEnum.RULE_NAME.getId()) {
            deleteRuleMessageResponse.setRuleName(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == DeleteRuleMessageResponseEnum.USER_NAME.getId()) {
            deleteRuleMessageResponse.setUserName(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == DeleteRuleMessageResponseEnum.SESSION_ID.getId()) {
            deleteRuleMessageResponse.setSessionId(GreenballMessagesUtility.getString(ba, offset, length));
         }
      }

      log4j.debug("Leaving " + METHOD);
      return deleteRuleMessageResponse;
   }
   // Leaving buildUnpackMethod()

   // Entered buildPackStrMethod()
   /**
    * This method packs a DeleteRuleMessageResponse object into a String. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A String which represents a DeleteRuleMessageResponse message object.
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
      InitializeDeleteRuleMessageResponse initializeDeleteRuleMessageResponse = new InitializeDeleteRuleMessageResponse(this);
      Element element = initializeDeleteRuleMessageResponse.initialize();

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
   public DeleteRuleMessageResponse unpack(String buffer) {
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
       * Instantiate the DeleteRuleMessageResponse object.
       */
       InstantiateDeleteRuleMessageResponse instantiateDeleteRuleMessageResponse = new InstantiateDeleteRuleMessageResponse(element);
       DeleteRuleMessageResponse deleteRuleMessageResponse = instantiateDeleteRuleMessageResponse.instantiate();

      /*
       * Verify that a value was provided for all mandatory attributes.
       */
      String result = instantiateDeleteRuleMessageResponse.validate();
      if (result != null) {
         log4j.error("Error: " + result);
         setErrorMsg(result);
         return null;
      }

      log4j.debug("Leaving " + METHOD);
      return deleteRuleMessageResponse;
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
    * This method sets the modelName attribute. Setting of this value is required.
    * @param modelName The modelName attribute.
    */
   public void setModelName(String modelName) {
      this.modelName = modelName;
   }

   /**
    * This method sets the ruleId attribute. Setting of this value is required.
    * @param ruleId The ruleId attribute.
    */
   public void setRuleId(String ruleId) {
      this.ruleId = ruleId;
   }

   /**
    * This method sets the ruleName attribute. Setting of this value is required.
    * @param ruleName The ruleName attribute.
    */
   public void setRuleName(String ruleName) {
      this.ruleName = ruleName;
   }

   /**
    * This method sets the userName attribute. Setting of this value is required.
    * @param userName The userName attribute.
    */
   public void setUserName(String userName) {
      this.userName = userName;
   }

   /**
    * This method sets the isDeleted attribute. Setting of this value is required.
    * @param isDeleted The isDeleted attribute.
    */
   public void setIsDeleted(Boolean isDeleted) {
      this.isDeleted = isDeleted;
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
    * This method gets the modelName attribute. The modelName attribute is a required attribute.
    */
   public String getModelName() {
      return this.modelName;
   }

   /**
    * This method gets the ruleId attribute. The ruleId attribute is a required attribute.
    */
   public String getRuleId() {
      return this.ruleId;
   }

   /**
    * This method gets the ruleName attribute. The ruleName attribute is a required attribute.
    */
   public String getRuleName() {
      return this.ruleName;
   }

   /**
    * This method gets the userName attribute. The userName attribute is a required attribute.
    */
   public String getUserName() {
      return this.userName;
   }

   /**
    * This method gets the isDeleted attribute. The isDeleted attribute is a required attribute.
    */
   public Boolean getIsDeleted() {
      return this.isDeleted;
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
   private int getDeleteRuleMessageResponseDirectorySize() {
      int directorySize = 0;

      // orgId
      directorySize++;
      // orgName
      directorySize++;
      // modelName
      directorySize++;
      // ruleId
      directorySize++;
      // ruleName
      directorySize++;
      // userName
      directorySize++;
      // sessionId
      directorySize++;

      return directorySize;
   }


   /**
    * This method gets the size of the DeleteRuleMessageResponse object.
    * @return The size in bytes.
    */
   public int getDeleteRuleMessageResponseSize() {
      int size = 0;

      int directorySize = getDeleteRuleMessageResponseDirectorySize();
      size += directorySize * GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
      // Add two bytes for the ID
      size += 2;
      // Add eight bytes for the CRC
      size += 8;
      // Add size of orgId
      size += (getOrgId() != null ? getOrgId().length() : 0);
      // Add size of orgName
      size += (getOrgName() != null ? getOrgName().length() : 0);
      // Add size of modelName
      size += (getModelName() != null ? getModelName().length() : 0);
      // Add size of ruleId
      size += (getRuleId() != null ? getRuleId().length() : 0);
      // Add size of ruleName
      size += (getRuleName() != null ? getRuleName().length() : 0);
      // Add size of userName
      size += (getUserName() != null ? getUserName().length() : 0);
      // Add size of isDeleted
      size += 1;
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
      result.append(" modelName: " + modelName + NEW_LINE);
      result.append(" ruleId: " + ruleId + NEW_LINE);
      result.append(" ruleName: " + ruleName + NEW_LINE);
      result.append(" userName: " + userName + NEW_LINE);
      result.append(" isDeleted: " + isDeleted + NEW_LINE);
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
         + ((String) modelName).hashCode();
      result = prime * result
         + ((String) ruleId).hashCode();
      result = prime * result
         + ((String) ruleName).hashCode();
      result = prime * result
         + ((String) userName).hashCode();
      result = prime * result
         + ((Boolean) isDeleted).hashCode();
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

      DeleteRuleMessageResponse deleteRuleMessageResponse = (DeleteRuleMessageResponse) obj;
      if (!deleteRuleMessageResponse.getOrgId().equals(this.getOrgId())) {
         return false;
      }

      if (!deleteRuleMessageResponse.getOrgName().equals(this.getOrgName())) {
         return false;
      }

      if (!deleteRuleMessageResponse.getModelName().equals(this.getModelName())) {
         return false;
      }

      if (!deleteRuleMessageResponse.getRuleId().equals(this.getRuleId())) {
         return false;
      }

      if (!deleteRuleMessageResponse.getRuleName().equals(this.getRuleName())) {
         return false;
      }

      if (!deleteRuleMessageResponse.getUserName().equals(this.getUserName())) {
         return false;
      }

      if (deleteRuleMessageResponse.getIsDeleted() != this.getIsDeleted()) {
         return false;
      }

      if (deleteRuleMessageResponse.getSessionId() == null && this.getSessionId() != null) {
         return false;
      }
      else if (deleteRuleMessageResponse.getSessionId() != null && this.getSessionId() == null) {
         return false;
      }
      else if (deleteRuleMessageResponse.getSessionId() != null && 
      !deleteRuleMessageResponse.getSessionId().equals(this.getSessionId())) {
         return false;
      }

      return true;
   }
}
