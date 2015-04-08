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

public class InstantiateMetaModelLockResponse {
   private static Logger log4j = Logger.getLogger(InstantiateMetaModelLockResponse.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isUserUpdated = false;
   private boolean isMetaModelIdUpdated = false;
   private boolean isLockUpdated = false;
   private boolean isSessionIdUpdated = false;

   private Element element;
   private MetaModelLockResponse metaModelLockResponse;

   /**
    * The InstantiateMetaModelLockResponse class instantiates the MetaModelLockResponse object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the MetaModelLockResponse.
    */
   public InstantiateMetaModelLockResponse(Element element) {
      this.element = element;   
      this.metaModelLockResponse = new MetaModelLockResponse();
   }

   /**
    * This method instantiates the MetaModelLockResponse.
    *
    * @return The MetaModelLockResponse.
    */
   public MetaModelLockResponse instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("MetaModelLockResponse: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateMetaModelLockResponseAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateMetaModelLockResponseSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return metaModelLockResponse;
      }

      /*
       * This method instantiates the MetaModelLockResponse attributes.
       * 
       * @param Element element
       */
      private void instantiateMetaModelLockResponseAttributes(Element element) {
      final String METHOD = "instantiateMetaModelLockResponseAttributes()";
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
               metaModelLockResponse.setUser(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("metaModelId")) {
               log4j.debug("setting value of \"metaModelId\" to: " + kvp.getValue());
               this.isMetaModelIdUpdated = true;
               metaModelLockResponse.setMetaModelId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("lock")) {
               log4j.debug("setting value of \"lock\" to: " + kvp.getValue());
               this.isLockUpdated = true;
               metaModelLockResponse.setLock(kvp.getValue().equals("true"));
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("sessionId")) {
               log4j.debug("setting value of \"sessionId\" to: " + kvp.getValue());
               this.isSessionIdUpdated = true;
               metaModelLockResponse.setSessionId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the MetaModelLockResponse SubType references.
    * 
    * @param Element element
    */
   private void instantiateMetaModelLockResponseSubTypeRefs(Element element) {
      final String METHOD = "instantiateMetaModelLockResponseSubTypeRefs()";
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

      if (!this.isMetaModelIdUpdated) {
         String msg = "MetaModelId is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isLockUpdated) {
         String msg = "Lock is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isSessionIdUpdated) {
         String msg = "SessionId is required, but no value was provided.";
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