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
 * The InitializeSubscribers class initializes the element object with the Subscribers object.
 *
 */
public class InitializeSubscribers {
   private static Logger log4j = Logger.getLogger(InitializeSubscribers.class);
   private String theErrorMsg;
   private Element element;
   private Subscribers subscribers;

   /**
    * The InitializeSubscribers class initializes the element object with the Subscribers object.
    *
    * @param subscribers The object which will be used to initialize the element object.
    */
   public InitializeSubscribers(Subscribers subscribers) {
      this.subscribers = subscribers;

      this.element = new Element("Subscribers");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): Subscribers");

      if (subscribers.getOrganization() != null) {
         AbstractAttribute abstractAttribute = initializeOrganization(subscribers.getOrganization());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"organization\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (subscribers.getUsers() != null) {
         AbstractAttribute abstractAttribute = initializeUsers(subscribers.getUsers());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"users\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (subscribers.getSessionId() != null) {
         AbstractAttribute abstractAttribute = initializeSessionId(subscribers.getSessionId());
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
    * This method initializes the organization attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeOrganization(String organization)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (organization != null) {
         log4j.debug("Creating new KeyValuePair: organization");
         KeyValuePair kvp = new KeyValuePair("organization", "<STRING_BEGIN>" + organization + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"organization\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the users attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeUsers(List<UserSubType> usersList)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      if (usersList != null) {
         int indexUsers = 0;
         for (UserSubType users : usersList) {
            InitializeUserSubType initializeUserSubType = new InitializeUserSubType(users);
            Element usersElement = initializeUserSubType.initialize("users[" + indexUsers + "]");
            abstractAttribute.getElements().add(usersElement);
            indexUsers++;
         }
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"users\" is required, but no value was provided.");
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
