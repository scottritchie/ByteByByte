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

public class InstantiateRequestChangePassword {
   private static Logger log4j = Logger.getLogger(InstantiateRequestChangePassword.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isUserUpdated = false;
   private boolean isOldPasswordUpdated = false;
   private boolean isNewPasswordUpdated = false;

   private Element element;
   private RequestChangePassword requestChangePassword;

   /**
    * The InstantiateRequestChangePassword class instantiates the RequestChangePassword object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the RequestChangePassword.
    */
   public InstantiateRequestChangePassword(Element element) {
      this.element = element;   
      this.requestChangePassword = new RequestChangePassword();
   }

   /**
    * This method instantiates the RequestChangePassword.
    *
    * @return The RequestChangePassword.
    */
   public RequestChangePassword instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("RequestChangePassword: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateRequestChangePasswordAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateRequestChangePasswordSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return requestChangePassword;
      }

      /*
       * This method instantiates the RequestChangePassword attributes.
       * 
       * @param Element element
       */
      private void instantiateRequestChangePasswordAttributes(Element element) {
      final String METHOD = "instantiateRequestChangePasswordAttributes()";
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
               requestChangePassword.setUser(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("oldPassword")) {
               log4j.debug("setting value of \"oldPassword\" to: " + kvp.getValue());
               this.isOldPasswordUpdated = true;
               requestChangePassword.setOldPassword(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("newPassword")) {
               log4j.debug("setting value of \"newPassword\" to: " + kvp.getValue());
               this.isNewPasswordUpdated = true;
               requestChangePassword.setNewPassword(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("sessionId")) {
               log4j.debug("setting value of \"sessionId\" to: " + kvp.getValue());
               requestChangePassword.setSessionId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the RequestChangePassword SubType references.
    * 
    * @param Element element
    */
   private void instantiateRequestChangePasswordSubTypeRefs(Element element) {
      final String METHOD = "instantiateRequestChangePasswordSubTypeRefs()";
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

      if (!this.isOldPasswordUpdated) {
         String msg = "OldPassword is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isNewPasswordUpdated) {
         String msg = "NewPassword is required, but no value was provided.";
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
