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
 * The InitializeRegisterNewUser class initializes the element object with the RegisterNewUser object.
 *
 */
public class InitializeRegisterNewUser {
   private static Logger log4j = Logger.getLogger(InitializeRegisterNewUser.class);
   private String theErrorMsg;
   private Element element;
   private RegisterNewUser registerNewUser;

   /**
    * The InitializeRegisterNewUser class initializes the element object with the RegisterNewUser object.
    *
    * @param registerNewUser The object which will be used to initialize the element object.
    */
   public InitializeRegisterNewUser(RegisterNewUser registerNewUser) {
      this.registerNewUser = registerNewUser;

      this.element = new Element("RegisterNewUser");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): RegisterNewUser");

      if (registerNewUser.getUser() != null) {
         AbstractAttribute abstractAttribute = initializeUser(registerNewUser.getUser());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"user\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (registerNewUser.getSessionId() != null) {
         AbstractAttribute abstractAttribute = initializeSessionId(registerNewUser.getSessionId());
         element.getAbstractAttributes().add(abstractAttribute);
      }



      log4j.debug("Leaving " + METHOD);
      return element;
   }

   /*
    * This method initializes the user attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeUser(UserSubType user)
             throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      if (user != null) {
         InitializeUserSubType initializeUserSubType = new InitializeUserSubType(user);
         Element userElement = initializeUserSubType.initialize("user");
         abstractAttribute.getElements().add(userElement);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"user\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }
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