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

public class InstantiateRuleSyncResponse {
   private static Logger log4j = Logger.getLogger(InstantiateRuleSyncResponse.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */

   private Element element;
   private RuleSyncResponse ruleSyncResponse;

   /**
    * The InstantiateRuleSyncResponse class instantiates the RuleSyncResponse object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the RuleSyncResponse.
    */
   public InstantiateRuleSyncResponse(Element element) {
      this.element = element;   
      this.ruleSyncResponse = new RuleSyncResponse();
   }

   /**
    * This method instantiates the RuleSyncResponse.
    *
    * @return The RuleSyncResponse.
    */
   public RuleSyncResponse instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("RuleSyncResponse: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateRuleSyncResponseAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateRuleSyncResponseSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return ruleSyncResponse;
      }

      /*
       * This method instantiates the RuleSyncResponse attributes.
       * 
       * @param Element element
       */
      private void instantiateRuleSyncResponseAttributes(Element element) {
      final String METHOD = "instantiateRuleSyncResponseAttributes()";
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
    * This method instantiates the RuleSyncResponse SubType references.
    * 
    * @param Element element
    */
   private void instantiateRuleSyncResponseSubTypeRefs(Element element) {
      final String METHOD = "instantiateRuleSyncResponseSubTypeRefs()";
      log4j.debug("Entered " + METHOD);

      // Entered instantiateMessageSubTypeRefList()
      if (element.getName().startsWith("rules[")) {
         log4j.debug("found element: rules");
         instantiateRules(element);
         return;
      }
      // Leaving instantiateMessageSubTypeRefList()


      log4j.debug("Leaving " + METHOD);
   }

/*
 * This method instantiates the rules attribute which is a list of Rule
 * @param Element element
 */
private void instantiateRules(Element element) {
      // Entered instantiateSubTypeRefList()
   final String METHOD = "instantiateRules()";
   log4j.debug("Entered " + METHOD);

   if (ruleSyncResponse.getRules() == null) {
   ruleSyncResponse.setRules(new ArrayList<Rule>());
   }

   InstantiateRule instantiateRule = new InstantiateRule(element);
   Rule rule = instantiateRule.instantiate();
   ruleSyncResponse.getRules().add(rule);
   log4j.debug("Leaving " + METHOD);
   // Leaving instantiateSubTypeRefList()
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


      if (result != null) {
         log4j.debug("result: " + result);
      }

      log4j.debug("Leaving " + METHOD);
      return result;
   }
}
