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
 * The InitializeResponseEditRuleMessage class initializes the element object with the ResponseEditRuleMessage object.
 *
 */
public class InitializeResponseEditRuleMessage {
   private static Logger log4j = Logger.getLogger(InitializeResponseEditRuleMessage.class);
   private String theErrorMsg;
   private Element element;
   private ResponseEditRuleMessage responseEditRuleMessage;

   /**
    * The InitializeResponseEditRuleMessage class initializes the element object with the ResponseEditRuleMessage object.
    *
    * @param responseEditRuleMessage The object which will be used to initialize the element object.
    */
   public InitializeResponseEditRuleMessage(ResponseEditRuleMessage responseEditRuleMessage) {
      this.responseEditRuleMessage = responseEditRuleMessage;

      this.element = new Element("ResponseEditRuleMessage");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): ResponseEditRuleMessage");

      if (responseEditRuleMessage.getOrgId() != null) {
         AbstractAttribute abstractAttribute = initializeOrgId(responseEditRuleMessage.getOrgId());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgId\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseEditRuleMessage.getOrgName() != null) {
         AbstractAttribute abstractAttribute = initializeOrgName(responseEditRuleMessage.getOrgName());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseEditRuleMessage.getModelName() != null) {
         AbstractAttribute abstractAttribute = initializeModelName(responseEditRuleMessage.getModelName());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"modelName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseEditRuleMessage.getNewRule() != null) {
         AbstractAttribute abstractAttribute = initializeNewRule(responseEditRuleMessage.getNewRule());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"newRule\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseEditRuleMessage.getOldRule() != null) {
         AbstractAttribute abstractAttribute = initializeOldRule(responseEditRuleMessage.getOldRule());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"oldRule\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseEditRuleMessage.getUserName() != null) {
         AbstractAttribute abstractAttribute = initializeUserName(responseEditRuleMessage.getUserName());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"userName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseEditRuleMessage.getSessionId() != null) {
         AbstractAttribute abstractAttribute = initializeSessionId(responseEditRuleMessage.getSessionId());
         element.getAbstractAttributes().add(abstractAttribute);
      }



      log4j.debug("Leaving " + METHOD);
      return element;
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
    * This method initializes the modelName attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeModelName(String modelName)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (modelName != null) {
         log4j.debug("Creating new KeyValuePair: modelName");
         KeyValuePair kvp = new KeyValuePair("modelName", "<STRING_BEGIN>" + modelName + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"modelName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the newRule attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeNewRule(Rule newRule)
             throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      if (newRule != null) {
         InitializeRule initializeRule = new InitializeRule(newRule);
         Element newRuleElement = initializeRule.initialize("newRule");
         abstractAttribute.getElements().add(newRuleElement);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"newRule\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }
      return abstractAttribute;
   }

   /*
    * This method initializes the oldRule attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeOldRule(Rule oldRule)
             throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      if (oldRule != null) {
         InitializeRule initializeRule = new InitializeRule(oldRule);
         Element oldRuleElement = initializeRule.initialize("oldRule");
         abstractAttribute.getElements().add(oldRuleElement);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"oldRule\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }
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
