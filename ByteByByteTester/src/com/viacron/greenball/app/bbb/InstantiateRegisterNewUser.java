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

public class InstantiateRegisterNewUser {
   private static Logger log4j = Logger.getLogger(InstantiateRegisterNewUser.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isUserUpdated = false;

   private Element element;
   private RegisterNewUser registerNewUser;

   /**
    * The InstantiateRegisterNewUser class instantiates the RegisterNewUser object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the RegisterNewUser.
    */
   public InstantiateRegisterNewUser(Element element) {
      this.element = element;   
      this.registerNewUser = new RegisterNewUser();
   }

   /**
    * This method instantiates the RegisterNewUser.
    *
    * @return The RegisterNewUser.
    */
   public RegisterNewUser instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("RegisterNewUser: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateRegisterNewUserAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateRegisterNewUserSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return registerNewUser;
      }

      /*
       * This method instantiates the RegisterNewUser attributes.
       * 
       * @param Element element
       */
      private void instantiateRegisterNewUserAttributes(Element element) {
      final String METHOD = "instantiateRegisterNewUserAttributes()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element name: " + element.getName());
      for (AbstractAttribute attr : element.getAbstractAttributes()) {
         for (KeyValuePair kvp : attr.getKeyValuePairs()) {
            log4j.debug("key: " + kvp.getKey());
            log4j.debug("value: " + kvp.getValue());
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("sessionId")) {
               log4j.debug("setting value of \"sessionId\" to: " + kvp.getValue());
               registerNewUser.setSessionId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the RegisterNewUser SubType references.
    * 
    * @param Element element
    */
   private void instantiateRegisterNewUserSubTypeRefs(Element element) {
      final String METHOD = "instantiateRegisterNewUserSubTypeRefs()";
      log4j.debug("Entered " + METHOD);

            // Entered instantiateMessageSubTypeRef()
      if (element.getName().equals("user")) {
         log4j.debug("found element: user");
         this.isUserUpdated = true;
         instantiateUser(element);
         return;
      }
      // Leaving instantiateMessageSubTypeRef()


      log4j.debug("Leaving " + METHOD);
   }

/*
 * This method instantiates the user attribute.
 * @param Element element
 */
private void instantiateUser(Element element) {
      // Entered instantiateSubTypeRef()
   final String METHOD = "instantiateUser()";
   log4j.debug("Entered " + METHOD);

   InstantiateUserSubType instantiateUserSubType = new InstantiateUserSubType(element);
   registerNewUser.setUser(instantiateUserSubType.instantiate());

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
      if (!this.isUserUpdated) {
         String msg = "User is required, but no value was provided.";
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
