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
 * The InitializeResponseInsertRuleMessage class initializes the element object with the ResponseInsertRuleMessage object.
 *
 */
public class InitializeResponseInsertRuleMessage {
   private static Logger log4j = Logger.getLogger(InitializeResponseInsertRuleMessage.class);
   private String theErrorMsg;
   private Element element;
   private ResponseInsertRuleMessage responseInsertRuleMessage;

   /**
    * The InitializeResponseInsertRuleMessage class initializes the element object with the ResponseInsertRuleMessage object.
    *
    * @param responseInsertRuleMessage The object which will be used to initialize the element object.
    */
   public InitializeResponseInsertRuleMessage(ResponseInsertRuleMessage responseInsertRuleMessage) {
      this.responseInsertRuleMessage = responseInsertRuleMessage;

      this.element = new Element("ResponseInsertRuleMessage");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): ResponseInsertRuleMessage");

      if (responseInsertRuleMessage.getOrgId() != null) {
         AbstractAttribute abstractAttribute = initializeOrgId(responseInsertRuleMessage.getOrgId());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgId\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseInsertRuleMessage.getOrgName() != null) {
         AbstractAttribute abstractAttribute = initializeOrgName(responseInsertRuleMessage.getOrgName());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseInsertRuleMessage.getModelName() != null) {
         AbstractAttribute abstractAttribute = initializeModelName(responseInsertRuleMessage.getModelName());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"modelName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseInsertRuleMessage.getRule() != null) {
         AbstractAttribute abstractAttribute = initializeRule(responseInsertRuleMessage.getRule());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"rule\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseInsertRuleMessage.getUserName() != null) {
         AbstractAttribute abstractAttribute = initializeUserName(responseInsertRuleMessage.getUserName());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"userName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseInsertRuleMessage.getSessionId() != null) {
         AbstractAttribute abstractAttribute = initializeSessionId(responseInsertRuleMessage.getSessionId());
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
    * This method initializes the rule attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeRule(Rule rule)
             throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      if (rule != null) {
         InitializeRule initializeRule = new InitializeRule(rule);
         Element ruleElement = initializeRule.initialize("rule");
         abstractAttribute.getElements().add(ruleElement);
      }
   else {
      // Missing required attribute, generate an error message and throw an exception
      setErrorMsg("Error packing object. The attribute \"rule\" is required, but no value was provided.");
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
