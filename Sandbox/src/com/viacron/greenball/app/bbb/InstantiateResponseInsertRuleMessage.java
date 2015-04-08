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

public class InstantiateResponseInsertRuleMessage {
   private static Logger log4j = Logger.getLogger(InstantiateResponseInsertRuleMessage.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isOrgIdUpdated = false;
   private boolean isOrgNameUpdated = false;
   private boolean isModelNameUpdated = false;
   private boolean isRuleUpdated = false;
   private boolean isUserNameUpdated = false;

   private Element element;
   private ResponseInsertRuleMessage responseInsertRuleMessage;

   /**
    * The InstantiateResponseInsertRuleMessage class instantiates the ResponseInsertRuleMessage object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the ResponseInsertRuleMessage.
    */
   public InstantiateResponseInsertRuleMessage(Element element) {
      this.element = element;   
      this.responseInsertRuleMessage = new ResponseInsertRuleMessage();
   }

   /**
    * This method instantiates the ResponseInsertRuleMessage.
    *
    * @return The ResponseInsertRuleMessage.
    */
   public ResponseInsertRuleMessage instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("ResponseInsertRuleMessage: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateResponseInsertRuleMessageAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateResponseInsertRuleMessageSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return responseInsertRuleMessage;
      }

      /*
       * This method instantiates the ResponseInsertRuleMessage attributes.
       * 
       * @param Element element
       */
      private void instantiateResponseInsertRuleMessageAttributes(Element element) {
      final String METHOD = "instantiateResponseInsertRuleMessageAttributes()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element name: " + element.getName());
      for (AbstractAttribute attr : element.getAbstractAttributes()) {
         for (KeyValuePair kvp : attr.getKeyValuePairs()) {
            log4j.debug("key: " + kvp.getKey());
            log4j.debug("value: " + kvp.getValue());
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("orgId")) {
               log4j.debug("setting value of \"orgId\" to: " + kvp.getValue());
               this.isOrgIdUpdated = true;
               responseInsertRuleMessage.setOrgId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("orgName")) {
               log4j.debug("setting value of \"orgName\" to: " + kvp.getValue());
               this.isOrgNameUpdated = true;
               responseInsertRuleMessage.setOrgName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("modelName")) {
               log4j.debug("setting value of \"modelName\" to: " + kvp.getValue());
               this.isModelNameUpdated = true;
               responseInsertRuleMessage.setModelName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("userName")) {
               log4j.debug("setting value of \"userName\" to: " + kvp.getValue());
               this.isUserNameUpdated = true;
               responseInsertRuleMessage.setUserName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("sessionId")) {
               log4j.debug("setting value of \"sessionId\" to: " + kvp.getValue());
               responseInsertRuleMessage.setSessionId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the ResponseInsertRuleMessage SubType references.
    * 
    * @param Element element
    */
   private void instantiateResponseInsertRuleMessageSubTypeRefs(Element element) {
      final String METHOD = "instantiateResponseInsertRuleMessageSubTypeRefs()";
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
   responseInsertRuleMessage.setRule(instantiateRule.instantiate());

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
      if (!this.isOrgIdUpdated) {
         String msg = "OrgId is required, but no value was provided.";
         if (result == null) {
            result = msg;
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

      if (!this.isModelNameUpdated) {
         String msg = "ModelName is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isRuleUpdated) {
         String msg = "Rule is required, but no value was provided.";
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


      if (result != null) {
         log4j.debug("result: " + result);
      }

      log4j.debug("Leaving " + METHOD);
      return result;
   }
}