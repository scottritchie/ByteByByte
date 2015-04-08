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
 * The InitializeRuleSyncResponse class initializes the element object with the RuleSyncResponse object.
 *
 */
public class InitializeRuleSyncResponse {
   private static Logger log4j = Logger.getLogger(InitializeRuleSyncResponse.class);
   private String theErrorMsg;
   private Element element;
   private RuleSyncResponse ruleSyncResponse;

   /**
    * The InitializeRuleSyncResponse class initializes the element object with the RuleSyncResponse object.
    *
    * @param ruleSyncResponse The object which will be used to initialize the element object.
    */
   public InitializeRuleSyncResponse(RuleSyncResponse ruleSyncResponse) {
      this.ruleSyncResponse = ruleSyncResponse;

      this.element = new Element("RuleSyncResponse");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): RuleSyncResponse");

      if (ruleSyncResponse.getRules() != null) {
         AbstractAttribute abstractAttribute = initializeRules(ruleSyncResponse.getRules());
         element.getAbstractAttributes().add(abstractAttribute);
      }



      log4j.debug("Leaving " + METHOD);
      return element;
   }

   /*
    * This method initializes the rules attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeRules(List<Rule> rulesList)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      if (rulesList != null) {
         int indexrules = 0;
         for (Rule rules : rulesList) {
         InitializeRule initializeRule = new InitializeRule(rules);
         Element rulesElement = initializeRule.initialize("rules[" + indexrules + "]");
         abstractAttribute.getElements().add(rulesElement);
         indexrules++;
         }
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
