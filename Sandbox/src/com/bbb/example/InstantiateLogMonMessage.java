/*
 * WARNING: This file was generated by BitByBitGenerator.xtend (see
 * generateInstantiationFile()). 
 * Do not edit.
 */
package com.bbb.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.viacron.utils.StringMessageBuffer.parser.AbstractAttribute;
import com.viacron.utils.StringMessageBuffer.parser.Element;
import com.viacron.utils.StringMessageBuffer.parser.KeyValuePair;

public class InstantiateLogMonMessage {
   private static Logger log4j = Logger.getLogger(InstantiateLogMonMessage.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isTimestampUpdated = false;
   private boolean isMsgUpdated = false;
   private boolean isDetailsUpdated = false;

   private Element element;
   private LogMonMessage logMonMessage;

   /**
    * The InstantiateLogMonMessage class instantiates the LogMonMessage object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the LogMonMessage.
    */
   public InstantiateLogMonMessage(Element element) {
      this.element = element;   
      this.logMonMessage = new LogMonMessage();
   }

   /**
    * This method instantiates the LogMonMessage.
    *
    * @return The LogMonMessage.
    */
   public LogMonMessage instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("LogMonMessage: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateLogMonMessageAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateLogMonMessageSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return logMonMessage;
      }

      /*
       * This method instantiates the LogMonMessage attributes.
       * 
       * @param Element element
       */
      private void instantiateLogMonMessageAttributes(Element element) {
      final String METHOD = "instantiateLogMonMessageAttributes()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element name: " + element.getName());
      for (AbstractAttribute attr : element.getAbstractAttributes()) {
         for (KeyValuePair kvp : attr.getKeyValuePairs()) {
            log4j.debug("key: " + kvp.getKey());
            log4j.debug("value: " + kvp.getValue());
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("timestamp")) {
               log4j.debug("setting value of \"timestamp\" to: " + kvp.getValue());
               this.isTimestampUpdated = true;
               Date date;
               try {
                  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
                  date = formatter.parse(kvp.getValue());
                  Calendar cal = Calendar.getInstance();
                  cal.setTime(date);
               logMonMessage.setTimestamp(cal);
               } catch (ParseException ex) {
                  log4j.error("Invalid date format: " + kvp.getValue());
               }
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("msg")) {
               log4j.debug("setting value of \"msg\" to: " + kvp.getValue());
               this.isMsgUpdated = true;
               logMonMessage.setMsg(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the LogMonMessage SubType references.
    * 
    * @param Element element
    */
   private void instantiateLogMonMessageSubTypeRefs(Element element) {
      final String METHOD = "instantiateLogMonMessageSubTypeRefs()";
      log4j.debug("Entered " + METHOD);

            // Entered instantiateMessageSubTypeRef()
      if (element.getName().equals("details")) {
         log4j.debug("found element: details");
         this.isDetailsUpdated = true;
         instantiateDetails(element);
         return;
      }
      // Leaving instantiateMessageSubTypeRef()


      log4j.debug("Leaving " + METHOD);
   }

/*
 * This method instantiates the details attribute.
 * @param Element element
 */
private void instantiateDetails(Element element) {
      // Entered instantiateSubTypeRef()
   final String METHOD = "instantiateDetails()";
   log4j.debug("Entered " + METHOD);

   InstantiateDetails instantiateDetails = new InstantiateDetails(element);
   logMonMessage.setDetails(instantiateDetails.instantiate());

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
      if (!this.isTimestampUpdated) {
         String msg = "Timestamp is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
      }

      if (!this.isMsgUpdated) {
         String msg = "Msg is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isDetailsUpdated) {
         String msg = "Details is required, but no value was provided.";
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
