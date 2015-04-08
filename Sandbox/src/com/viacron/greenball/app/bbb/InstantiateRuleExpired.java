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

public class InstantiateRuleExpired {
   private static Logger log4j = Logger.getLogger(InstantiateRuleExpired.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isRuleUpdated = false;

   private Element element;
   private RuleExpired ruleExpired;

   /**
    * The InstantiateRuleExpired class instantiates the RuleExpired object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the RuleExpired.
    */
   public InstantiateRuleExpired(Element element) {
      this.element = element;   
      this.ruleExpired = new RuleExpired();
   }

   /**
    * This method instantiates the RuleExpired.
    *
    * @return The RuleExpired.
    */
   public RuleExpired instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("RuleExpired: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateRuleExpiredAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateRuleExpiredSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return ruleExpired;
      }

      /*
       * This method instantiates the RuleExpired attributes.
       * 
       * @param Element element
       */
      private void instantiateRuleExpiredAttributes(Element element) {
      final String METHOD = "instantiateRuleExpiredAttributes()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element name: " + element.getName());
      for (AbstractAttribute attr : element.getAbstractAttributes()) {
         for (KeyValuePair kvp : attr.getKeyValuePairs()) {
            log4j.debug("key: " + kvp.getKey());
            log4j.debug("value: " + kvp.getValue());
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the RuleExpired SubType references.
    * 
    * @param Element element
    */
   private void instantiateRuleExpiredSubTypeRefs(Element element) {
      final String METHOD = "instantiateRuleExpiredSubTypeRefs()";
      log4j.debug("Entered " + METHOD);

            // Entered instantiateMessageSubTypeRef()
      if (element.getName().equals("rule")) {
         log4j.debug("found element: rule");
         this.isRuleUpdated = true;
         instantiateRule(element);
         return;
      }
      // Leaving instantiateMessageSubTypeRef()


      log4j.debug("Leaving " + METHOD);
   }

/*
 * This method instantiates the rule attribute.
 * @param Element element
 */
private void instantiateRule(Element element) {
      // Entered instantiateSubTypeRef()
   final String METHOD = "instantiateRule()";
   log4j.debug("Entered " + METHOD);

   InstantiateRule instantiateRule = new InstantiateRule(element);
   ruleExpired.setRule(instantiateRule.instantiate());

   log4j.debug("Leaving " + METHOD);
   // Leaving instantiateSubTypeRef()
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
      if (!this.isRuleUpdated) {
         String msg = "Rule is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
      }


      if (result != null) {
         log4j.debug("result: " + result);
      }

      log4j.debug("Leaving " + METHOD);
      return result;
   }
}