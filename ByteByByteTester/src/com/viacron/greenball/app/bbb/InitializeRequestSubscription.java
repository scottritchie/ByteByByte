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
 * The InitializeRequestSubscription class initializes the element object with the RequestSubscription object.
 *
 */
public class InitializeRequestSubscription {
   private static Logger log4j = Logger.getLogger(InitializeRequestSubscription.class);
   private String theErrorMsg;
   private Element element;
   private RequestSubscription requestSubscription;

   /**
    * The InitializeRequestSubscription class initializes the element object with the RequestSubscription object.
    *
    * @param requestSubscription The object which will be used to initialize the element object.
    */
   public InitializeRequestSubscription(RequestSubscription requestSubscription) {
      this.requestSubscription = requestSubscription;

      this.element = new Element("RequestSubscription");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): RequestSubscription");

      if (requestSubscription.getRequestor() != null) {
         AbstractAttribute abstractAttribute = initializeRequestor(requestSubscription.getRequestor());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"requestor\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (requestSubscription.getMessage() != null) {
         AbstractAttribute abstractAttribute = initializeMessage(requestSubscription.getMessage());
         element.getAbstractAttributes().add(abstractAttribute);
      }


      if (requestSubscription.getOrgId() != null) {
         AbstractAttribute abstractAttribute = initializeOrgId(requestSubscription.getOrgId());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgId\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (requestSubscription.getOrgName() != null) {
         AbstractAttribute abstractAttribute = initializeOrgName(requestSubscription.getOrgName());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (requestSubscription.getSessionId() != null) {
         AbstractAttribute abstractAttribute = initializeSessionId(requestSubscription.getSessionId());
         element.getAbstractAttributes().add(abstractAttribute);
      }



      log4j.debug("Leaving " + METHOD);
      return element;
   }

   /*
    * This method initializes the requestor attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeRequestor(String requestor)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (requestor != null) {
         log4j.debug("Creating new KeyValuePair: requestor");
         KeyValuePair kvp = new KeyValuePair("requestor", "<STRING_BEGIN>" + requestor + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"requestor\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the message attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeMessage(String message)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (message != null) {
         log4j.debug("Creating new KeyValuePair: message");
         KeyValuePair kvp = new KeyValuePair("message", "<STRING_BEGIN>" + message + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
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
