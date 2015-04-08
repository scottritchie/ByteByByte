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
 * The InitializeResponseChangePassword class initializes the element object with the ResponseChangePassword object.
 *
 */
public class InitializeResponseChangePassword {
   private static Logger log4j = Logger.getLogger(InitializeResponseChangePassword.class);
   private String theErrorMsg;
   private Element element;
   private ResponseChangePassword responseChangePassword;

   /**
    * The InitializeResponseChangePassword class initializes the element object with the ResponseChangePassword object.
    *
    * @param responseChangePassword The object which will be used to initialize the element object.
    */
   public InitializeResponseChangePassword(ResponseChangePassword responseChangePassword) {
      this.responseChangePassword = responseChangePassword;

      this.element = new Element("ResponseChangePassword");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): ResponseChangePassword");

      if (responseChangePassword.getUser() != null) {
         AbstractAttribute abstractAttribute = initializeUser(responseChangePassword.getUser());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"user\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseChangePassword.getNewPassword() != null) {
         AbstractAttribute abstractAttribute = initializeNewPassword(responseChangePassword.getNewPassword());
         element.getAbstractAttributes().add(abstractAttribute);
      }


      if (responseChangePassword.getChanged() != null) {
         AbstractAttribute abstractAttribute = initializeChanged(responseChangePassword.getChanged());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"changed\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (responseChangePassword.getSessionId() != null) {
         AbstractAttribute abstractAttribute = initializeSessionId(responseChangePassword.getSessionId());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"sessionId\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }


      log4j.debug("Leaving " + METHOD);
      return element;
   }

   /*
    * This method initializes the user attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeUser(String user)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (user != null) {
         log4j.debug("Creating new KeyValuePair: user");
         KeyValuePair kvp = new KeyValuePair("user", "<STRING_BEGIN>" + user + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"user\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the newPassword attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeNewPassword(String newPassword)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (newPassword != null) {
         log4j.debug("Creating new KeyValuePair: newPassword");
         KeyValuePair kvp = new KeyValuePair("newPassword", "<STRING_BEGIN>" + newPassword + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the changed attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeChanged(Boolean changed)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (changed != null) {
         log4j.debug("Creating new KeyValuePair: changed");
         KeyValuePair kvp = new KeyValuePair("changed", changed.toString());
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"changed\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the sessionId attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeSessionId(String sessionId)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (sessionId != null) {
         log4j.debug("Creating new KeyValuePair: sessionId");
         KeyValuePair kvp = new KeyValuePair("sessionId", "<STRING_BEGIN>" + sessionId + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"sessionId\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
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