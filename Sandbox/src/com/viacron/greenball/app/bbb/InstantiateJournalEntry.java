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

public class InstantiateJournalEntry {
   private static Logger log4j = Logger.getLogger(InstantiateJournalEntry.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isUserUpdated = false;
   private boolean isTimestampUpdated = false;
   private boolean isActionUpdated = false;
   private boolean isDescriptionUpdated = false;

   private Element element;
   private JournalEntry journalEntry;

   /**
    * The InstantiateJournalEntry class instantiates the JournalEntry object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the JournalEntry.
    */
   public InstantiateJournalEntry(Element element) {
      this.element = element;   
      this.journalEntry = new JournalEntry();
   }

   /**
    * This method instantiates the JournalEntry.
    *
    * @return The JournalEntry.
    */
   public JournalEntry instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("JournalEntry: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateJournalEntryAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateJournalEntrySubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return journalEntry;
      }

      /*
       * This method instantiates the JournalEntry attributes.
       * 
       * @param Element element
       */
      private void instantiateJournalEntryAttributes(Element element) {
      final String METHOD = "instantiateJournalEntryAttributes()";
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
               journalEntry.setUser(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("metaModelId")) {
               log4j.debug("setting value of \"metaModelId\" to: " + kvp.getValue());
               journalEntry.setMetaModelId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("timestamp")) {
               log4j.debug("setting value of \"timestamp\" to: " + kvp.getValue());
               this.isTimestampUpdated = true;
               journalEntry.setTimestamp(Long.parseLong(kvp.getValue()));
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("action")) {
               log4j.debug("setting value of \"action\" to: " + kvp.getValue());
               this.isActionUpdated = true;
               journalEntry.setAction(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("description")) {
               log4j.debug("setting value of \"description\" to: " + kvp.getValue());
               this.isDescriptionUpdated = true;
               journalEntry.setDescription(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the JournalEntry SubType references.
    * 
    * @param Element element
    */
   private void instantiateJournalEntrySubTypeRefs(Element element) {
      final String METHOD = "instantiateJournalEntrySubTypeRefs()";
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

      if (!this.isTimestampUpdated) {
         String msg = "Timestamp is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isActionUpdated) {
         String msg = "Action is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isDescriptionUpdated) {
         String msg = "Description is required, but no value was provided.";
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
