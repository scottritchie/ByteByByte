/*
 * WARNING: This file was generated by BitByBitGenerator.xtend (see
 * generateInstantiationFile()). 
 * Do not edit.
 */
package com.viacron.greenball.app.bbb;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.viacron.utils.StringMessageBuffer.parser.AbstractAttribute;
import com.viacron.utils.StringMessageBuffer.parser.Element;
import com.viacron.utils.StringMessageBuffer.parser.KeyValuePair;

public class InstantiateFileTransfer {
   private static Logger log4j = Logger.getLogger(InstantiateFileTransfer.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isFileNameUpdated = false;
   private boolean isUuidUpdated = false;
   private boolean isOrgIdUpdated = false;
   private boolean isOrgNameUpdated = false;
   private boolean isUserNameUpdated = false;
   private boolean isChunkNumberUpdated = false;
   private boolean isLastChunkUpdated = false;
   private boolean isChunkUpdated = false;

   private Element element;
   private FileTransfer fileTransfer;

   /**
    * The InstantiateFileTransfer class instantiates the FileTransfer object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the FileTransfer.
    */
   public InstantiateFileTransfer(Element element) {
      this.element = element;   
      this.fileTransfer = new FileTransfer();
   }

   /**
    * This method instantiates the FileTransfer.
    *
    * @return The FileTransfer.
    */
   public FileTransfer instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("FileTransfer: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateFileTransferAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateFileTransferSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return fileTransfer;
      }

      /*
       * This method instantiates the FileTransfer attributes.
       * 
       * @param Element element
       */
      private void instantiateFileTransferAttributes(Element element) {
      final String METHOD = "instantiateFileTransferAttributes()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element name: " + element.getName());
      for (AbstractAttribute attr : element.getAbstractAttributes()) {
         for (KeyValuePair kvp : attr.getKeyValuePairs()) {
            log4j.debug("key: " + kvp.getKey());
            log4j.debug("value: " + kvp.getValue());
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("fileName")) {
               log4j.debug("setting value of \"fileName\" to: " + kvp.getValue());
               this.isFileNameUpdated = true;
               fileTransfer.setFileName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("uuid")) {
               log4j.debug("setting value of \"uuid\" to: " + kvp.getValue());
               this.isUuidUpdated = true;
               fileTransfer.setUuid(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("orgId")) {
               log4j.debug("setting value of \"orgId\" to: " + kvp.getValue());
               this.isOrgIdUpdated = true;
               fileTransfer.setOrgId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("orgName")) {
               log4j.debug("setting value of \"orgName\" to: " + kvp.getValue());
               this.isOrgNameUpdated = true;
               fileTransfer.setOrgName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("userName")) {
               log4j.debug("setting value of \"userName\" to: " + kvp.getValue());
               this.isUserNameUpdated = true;
               fileTransfer.setUserName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("chunkNumber")) {
               log4j.debug("setting value of \"chunkNumber\" to: " + kvp.getValue());
               this.isChunkNumberUpdated = true;
               fileTransfer.setChunkNumber(Integer.parseInt(kvp.getValue()));
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("lastChunk")) {
               log4j.debug("setting value of \"lastChunk\" to: " + kvp.getValue());
               this.isLastChunkUpdated = true;
               fileTransfer.setLastChunk(kvp.getValue().equals("true"));
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttributeList()
            if (kvp.getKey().startsWith("chunk[")) {
               this.isChunkUpdated = true;
               if(fileTransfer.getChunk() == null) {
               fileTransfer.setChunk(new ArrayList<Byte>());
               }
               fileTransfer.getChunk().add(Byte.parseByte(kvp.getValue()));
            }
            // Leaving instantiateMsgAttributeList()
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the FileTransfer SubType references.
    * 
    * @param Element element
    */
   private void instantiateFileTransferSubTypeRefs(Element element) {
      final String METHOD = "instantiateFileTransferSubTypeRefs()";
      log4j.debug("Entered " + METHOD);


      log4j.debug("Leaving " + METHOD);
   }


   /**
    * The validate method checks that a value was provided for all required 
    * attributes.
    *
    * @return The error message or null if no error occurred.
    */
   protected String validate() {
      final String METHOD = "validate()";
      log4j.debug("Entered " + METHOD);

      String result = null;

      // Entered buildValidationMethod()
      if (!this.isFileNameUpdated) {
         String msg = "FileName is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
      }

      if (!this.isUuidUpdated) {
         String msg = "Uuid is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isOrgIdUpdated) {
         String msg = "OrgId is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isOrgNameUpdated) {
         String msg = "OrgName is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isUserNameUpdated) {
         String msg = "UserName is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isChunkNumberUpdated) {
         String msg = "ChunkNumber is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isLastChunkUpdated) {
         String msg = "LastChunk is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isChunkUpdated) {
         String msg = "Chunk is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }


      if (result != null) {
         log4j.debug("result: " + result);
      }

      log4j.debug("Leaving " + METHOD);
      return result;
   }
}
