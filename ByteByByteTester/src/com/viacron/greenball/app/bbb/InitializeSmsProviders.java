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
 * The InitializeSmsProviders class initializes the element object with the SmsProviders object.
 *
 */
public class InitializeSmsProviders {
   private static Logger log4j = Logger.getLogger(InitializeSmsProviders.class);
   private String theErrorMsg;
   private Element element;
   private SmsProviders smsProviders;

   /**
    * The InitializeSmsProviders class initializes the element object with the SmsProviders object.
    *
    * @param smsProviders The object which will be used to initialize the element object.
    */
   public InitializeSmsProviders(SmsProviders smsProviders) {
      this.smsProviders = smsProviders;

      this.element = new Element("SmsProviders");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): SmsProviders");

      if (smsProviders.getSmsProvider() != null) {
         AbstractAttribute abstractAttribute = initializeSmsProvider(smsProviders.getSmsProvider());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"smsProvider\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (smsProviders.getSessionId() != null) {
         AbstractAttribute abstractAttribute = initializeSessionId(smsProviders.getSessionId());
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
    * This method initializes the smsProvider attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeSmsProvider(List<SmsProviderSubType> smsProviderList)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      if (smsProviderList != null) {
         int indexsmsProvider = 0;
         for (SmsProviderSubType smsProvider : smsProviderList) {
         InitializeSmsProviderSubType initializeSmsProviderSubType = new InitializeSmsProviderSubType(smsProvider);
         Element smsProviderElement = initializeSmsProviderSubType.initialize("smsProvider[" + indexsmsProvider + "]");
         abstractAttribute.getElements().add(smsProviderElement);
         indexsmsProvider++;
         }
      }
   else {
      // Missing required attribute, generate an error message and throw an exception
      setErrorMsg("Error packing object. The attribute \"smsProvider\" is required, but no value was provided.");
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
