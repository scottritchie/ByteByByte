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
 * The InitializeErrorMessage class initializes the element object with the ErrorMessage object.
 *
 */
public class InitializeErrorMessage {
   private static Logger log4j = Logger.getLogger(InitializeErrorMessage.class);
   private String theErrorMsg;
   private Element element;
   private ErrorMessage errorMessage;

   /**
    * The InitializeErrorMessage class initializes the element object with the ErrorMessage object.
    *
    * @param errorMessage The object which will be used to initialize the element object.
    */
   public InitializeErrorMessage(ErrorMessage errorMessage) {
      this.errorMessage = errorMessage;

      this.element = new Element("ErrorMessage");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): ErrorMessage");

      if (errorMessage.getId() != null) {
         AbstractAttribute abstractAttribute = initializeId(errorMessage.getId());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"id\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (errorMessage.getMsg() != null) {
         AbstractAttribute abstractAttribute = initializeMsg(errorMessage.getMsg());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"msg\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (errorMessage.getDetails() != null) {
         AbstractAttribute abstractAttribute = initializeDetails(errorMessage.getDetails());
         element.getAbstractAttributes().add(abstractAttribute);
      }


      if (errorMessage.getSessionId() != null) {
         AbstractAttribute abstractAttribute = initializeSessionId(errorMessage.getSessionId());
         element.getAbstractAttributes().add(abstractAttribute);
      }



      log4j.debug("Leaving " + METHOD);
      return element;
   }

   /*
    * This method initializes the id attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeId(Integer id)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (id != null) {
         log4j.debug("Creating new KeyValuePair: id");
         KeyValuePair kvp = new KeyValuePair("id", Integer.toString(id));
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"id\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the msg attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeMsg(String msg)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (msg != null) {
         log4j.debug("Creating new KeyValuePair: msg");
         KeyValuePair kvp = new KeyValuePair("msg", "<STRING_BEGIN>" + msg + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"msg\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the details attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeDetails(String details)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (details != null) {
         log4j.debug("Creating new KeyValuePair: details");
         KeyValuePair kvp = new KeyValuePair("details", "<STRING_BEGIN>" + details + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the sessionId attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeSessionId(String sessionId)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (sessionId != null) {
         log4j.debug("Creating new KeyValuePair: sessionId");
         KeyValuePair kvp = new KeyValuePair("sessionId", "<STRING_BEGIN>" + sessionId + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }

      // Leaving initAttributeValue()
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