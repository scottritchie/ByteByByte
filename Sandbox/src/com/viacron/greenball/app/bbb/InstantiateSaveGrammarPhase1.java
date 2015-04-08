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

public class InstantiateSaveGrammarPhase1 {
   private static Logger log4j = Logger.getLogger(InstantiateSaveGrammarPhase1.class);

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
   private boolean isUserNameUpdated = false;
   private boolean isBufferUpdated = false;

   private Element element;
   private SaveGrammarPhase1 saveGrammarPhase1;

   /**
    * The InstantiateSaveGrammarPhase1 class instantiates the SaveGrammarPhase1 object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the SaveGrammarPhase1.
    */
   public InstantiateSaveGrammarPhase1(Element element) {
      this.element = element;   
      this.saveGrammarPhase1 = new SaveGrammarPhase1();
   }

   /**
    * This method instantiates the SaveGrammarPhase1.
    *
    * @return The SaveGrammarPhase1.
    */
   public SaveGrammarPhase1 instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("SaveGrammarPhase1: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateSaveGrammarPhase1Attributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateSaveGrammarPhase1SubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return saveGrammarPhase1;
      }

      /*
       * This method instantiates the SaveGrammarPhase1 attributes.
       * 
       * @param Element element
       */
      private void instantiateSaveGrammarPhase1Attributes(Element element) {
      final String METHOD = "instantiateSaveGrammarPhase1Attributes()";
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
               saveGrammarPhase1.setOrgId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("orgName")) {
               log4j.debug("setting value of \"orgName\" to: " + kvp.getValue());
               this.isOrgNameUpdated = true;
               saveGrammarPhase1.setOrgName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("userName")) {
               log4j.debug("setting value of \"userName\" to: " + kvp.getValue());
               this.isUserNameUpdated = true;
               saveGrammarPhase1.setUserName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("buffer")) {
               log4j.debug("setting value of \"buffer\" to: " + kvp.getValue());
               this.isBufferUpdated = true;
               saveGrammarPhase1.setBuffer(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("sessionId")) {
               log4j.debug("setting value of \"sessionId\" to: " + kvp.getValue());
               saveGrammarPhase1.setSessionId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the SaveGrammarPhase1 SubType references.
    * 
    * @param Element element
    */
   private void instantiateSaveGrammarPhase1SubTypeRefs(Element element) {
      final String METHOD = "instantiateSaveGrammarPhase1SubTypeRefs()";
      log4j.debug("Entered " + METHOD);


      log4j.debug("Leaving " + METHOD);
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

      if (!this.isUserNameUpdated) {
         String msg = "UserName is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isBufferUpdated) {
         String msg = "Buffer is required, but no value was provided.";
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