/*
 * WARNING: This file was generated by BitByBitGenerator.xtend (see
 * generateInitializationFile()). 
 * Do not edit.
 */
package com.viacron.greenball.app.bbb;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.viacron.utils.StringMessageBuffer.parser.AbstractAttribute;
import com.viacron.utils.StringMessageBuffer.parser.Element;
import com.viacron.utils.StringMessageBuffer.parser.KeyValuePair;

/**
 * The InitializeFileTransfer class initializes the element object with the FileTransfer object.
 *
 */
public class InitializeFileTransfer {
   private static Logger log4j = Logger.getLogger(InitializeFileTransfer.class);
   private String theErrorMsg;
   private Element element;
   private FileTransfer fileTransfer;

   /**
    * The InitializeFileTransfer class initializes the element object with the FileTransfer object.
    *
    * @param fileTransfer The object which will be used to initialize the element object.
    */
   public InitializeFileTransfer(FileTransfer fileTransfer) {
      this.fileTransfer = fileTransfer;

      this.element = new Element("FileTransfer");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): FileTransfer");

      if (fileTransfer.getFileName() != null) {
         AbstractAttribute abstractAttribute = initializeFileName(fileTransfer.getFileName());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"fileName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (fileTransfer.getUuid() != null) {
         AbstractAttribute abstractAttribute = initializeUuid(fileTransfer.getUuid());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"uuid\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (fileTransfer.getOrgId() != null) {
         AbstractAttribute abstractAttribute = initializeOrgId(fileTransfer.getOrgId());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgId\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (fileTransfer.getOrgName() != null) {
         AbstractAttribute abstractAttribute = initializeOrgName(fileTransfer.getOrgName());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (fileTransfer.getUserName() != null) {
         AbstractAttribute abstractAttribute = initializeUserName(fileTransfer.getUserName());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"userName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (fileTransfer.getChunkNumber() != null) {
         AbstractAttribute abstractAttribute = initializeChunkNumber(fileTransfer.getChunkNumber());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"chunkNumber\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (fileTransfer.getLastChunk() != null) {
         AbstractAttribute abstractAttribute = initializeLastChunk(fileTransfer.getLastChunk());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"lastChunk\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (fileTransfer.getChunk() != null) {
         AbstractAttribute abstractAttribute = initializeChunk(fileTransfer.getChunk());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"chunk\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }


      log4j.debug("Leaving " + METHOD);
      return element;
   }

   /*
    * This method initializes the fileName attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeFileName(String fileName)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (fileName != null) {
         log4j.debug("Creating new KeyValuePair: fileName");
         KeyValuePair kvp = new KeyValuePair("fileName", "<STRING_BEGIN>" + fileName + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"fileName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the uuid attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeUuid(String uuid)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (uuid != null) {
         log4j.debug("Creating new KeyValuePair: uuid");
         KeyValuePair kvp = new KeyValuePair("uuid", "<STRING_BEGIN>" + uuid + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"uuid\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the orgId attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeOrgId(String orgId)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (orgId != null) {
         log4j.debug("Creating new KeyValuePair: orgId");
         KeyValuePair kvp = new KeyValuePair("orgId", "<STRING_BEGIN>" + orgId + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgId\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the orgName attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeOrgName(String orgName)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (orgName != null) {
         log4j.debug("Creating new KeyValuePair: orgName");
         KeyValuePair kvp = new KeyValuePair("orgName", "<STRING_BEGIN>" + orgName + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the userName attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeUserName(String userName)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (userName != null) {
         log4j.debug("Creating new KeyValuePair: userName");
         KeyValuePair kvp = new KeyValuePair("userName", "<STRING_BEGIN>" + userName + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"userName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the chunkNumber attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeChunkNumber(Integer chunkNumber)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (chunkNumber != null) {
         log4j.debug("Creating new KeyValuePair: chunkNumber");
         KeyValuePair kvp = new KeyValuePair("chunkNumber", Integer.toString(chunkNumber));
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"chunkNumber\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the lastChunk attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeLastChunk(Boolean lastChunk)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (lastChunk != null) {
         log4j.debug("Creating new KeyValuePair: lastChunk");
         KeyValuePair kvp = new KeyValuePair("lastChunk", lastChunk.toString());
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"lastChunk\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the chunk attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeChunk(List<Byte> chunkList)
           throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      int chunkIndex = 0;
      for (Byte chunk : chunkList) {
         // Entered initAttributeValue()
         if (chunk != null) {
            log4j.debug("Creating new KeyValuePair: chunk[" + chunkIndex + "]");
            KeyValuePair kvp = new KeyValuePair("chunk[" + chunkIndex + "]", chunk.toString());
            abstractAttribute.getKeyValuePairs().add(kvp);
         }
         else {
            // Missing required attribute, generate an error message and throw an exception
            setErrorMsg("Error packing object. The attribute \"chunk\" is required, but no value was provided.");
            log4j.error(getErrorMsg());
            throw new MissingAttributeException(getErrorMsg());
         }

         // Leaving initAttributeValue()
         chunkIndex++;
      }
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /**
   * This method returns the error message or null if no error occurred.
   */
   public String getErrorMsg() {
      return theErrorMsg;
   }

   private void setErrorMsg(String errorMsg) {
      theErrorMsg = errorMsg;
   }

}
