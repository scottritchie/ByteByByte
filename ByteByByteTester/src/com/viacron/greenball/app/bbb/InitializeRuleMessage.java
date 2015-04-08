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
 * The InitializeRuleMessage class initializes the element object with the RuleMessage object.
 *
 */
public class InitializeRuleMessage {
   private static Logger log4j = Logger.getLogger(InitializeRuleMessage.class);
   private String theErrorMsg;
   private Element element;
   private RuleMessage ruleMessage;

   /**
    * The InitializeRuleMessage class initializes the element object with the RuleMessage object.
    *
    * @param ruleMessage The object which will be used to initialize the element object.
    */
   public InitializeRuleMessage(RuleMessage ruleMessage) {
      this.ruleMessage = ruleMessage;

      this.element = new Element("RuleMessage");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): RuleMessage");

      if (ruleMessage.getRule() != null) {
         AbstractAttribute abstractAttribute = initializeRule(ruleMessage.getRule());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"rule\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }


      log4j.debug("Leaving " + METHOD);
      return element;
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
