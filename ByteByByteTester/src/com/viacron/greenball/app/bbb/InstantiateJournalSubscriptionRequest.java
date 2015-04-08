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

public class InstantiateJournalSubscriptionRequest {
   private static Logger log4j = Logger.getLogger(InstantiateJournalSubscriptionRequest.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isUserUpdated = false;
   private boolean isOrgIdUpdated = false;
   private boolean isOrgNameUpdated = false;

   private Element element;
   private JournalSubscriptionRequest journalSubscriptionRequest;

   /**
    * The InstantiateJournalSubscriptionRequest class instantiates the JournalSubscriptionRequest object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the JournalSubscriptionRequest.
    */
   public InstantiateJournalSubscriptionRequest(Element element) {
      this.element = element;   
      this.journalSubscriptionRequest = new JournalSubscriptionRequest();
   }

   /**
    * This method instantiates the JournalSubscriptionRequest.
    *
    * @return The JournalSubscriptionRequest.
    */
   public JournalSubscriptionRequest instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("JournalSubscriptionRequest: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateJournalSubscriptionRequestAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateJournalSubscriptionRequestSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return journalSubscriptionRequest;
      }

      /*
       * This method instantiates the JournalSubscriptionRequest attributes.
       * 
       * @param Element element
       */
      private void instantiateJournalSubscriptionRequestAttributes(Element element) {
      final String METHOD = "instantiateJournalSubscriptionRequestAttributes()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element name: " + element.getName());
      for (AbstractAttribute attr : element.getAbstractAttributes()) {
         for (KeyValuePair kvp : attr.getKeyValuePairs()) {
            log4j.debug("key: " + kvp.getKey());
            log4j.debug("value: " + kvp.getValue());
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("user")) {
               log4j.debug("setting value of \"user\" to: " + kvp.getValue());
               this.isUserUpdated = true;
               journalSubscriptionRequest.setUser(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("orgId")) {
               log4j.debug("setting value of \"orgId\" to: " + kvp.getValue());
               this.isOrgIdUpdated = true;
               journalSubscriptionRequest.setOrgId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("orgName")) {
               log4j.debug("setting value of \"orgName\" to: " + kvp.getValue());
               this.isOrgNameUpdated = true;
               journalSubscriptionRequest.setOrgName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the JournalSubscriptionRequest SubType references.
    * 
    * @param Element element
    */
   private void instantiateJournalSubscriptionRequestSubTypeRefs(Element element) {
      final String METHOD = "instantiateJournalSubscriptionRequestSubTypeRefs()";
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
      if (!this.isUserUpdated) {
         String msg = "User is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
      }

      if (!this.isOrgIdUpdated) {
         String msg = "OrgId is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
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


      if (result != null) {
         log4j.debug("result: " + result);
      }

      log4j.debug("Leaving " + METHOD);
      return result;
   }
}