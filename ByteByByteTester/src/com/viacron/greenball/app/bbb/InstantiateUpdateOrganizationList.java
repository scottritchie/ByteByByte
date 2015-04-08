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

public class InstantiateUpdateOrganizationList {
   private static Logger log4j = Logger.getLogger(InstantiateUpdateOrganizationList.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isOrganizationUpdated = false;
   private boolean isSessionIdUpdated = false;

   private Element element;
   private UpdateOrganizationList updateOrganizationList;

   /**
    * The InstantiateUpdateOrganizationList class instantiates the UpdateOrganizationList object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the UpdateOrganizationList.
    */
   public InstantiateUpdateOrganizationList(Element element) {
      this.element = element;   
      this.updateOrganizationList = new UpdateOrganizationList();
   }

   /**
    * This method instantiates the UpdateOrganizationList.
    *
    * @return The UpdateOrganizationList.
    */
   public UpdateOrganizationList instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("UpdateOrganizationList: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateUpdateOrganizationListAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateUpdateOrganizationListSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return updateOrganizationList;
      }

      /*
       * This method instantiates the UpdateOrganizationList attributes.
       * 
       * @param Element element
       */
      private void instantiateUpdateOrganizationListAttributes(Element element) {
      final String METHOD = "instantiateUpdateOrganizationListAttributes()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element name: " + element.getName());
      for (AbstractAttribute attr : element.getAbstractAttributes()) {
         for (KeyValuePair kvp : attr.getKeyValuePairs()) {
            log4j.debug("key: " + kvp.getKey());
            log4j.debug("value: " + kvp.getValue());
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("sessionId")) {
               log4j.debug("setting value of \"sessionId\" to: " + kvp.getValue());
               this.isSessionIdUpdated = true;
               updateOrganizationList.setSessionId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the UpdateOrganizationList SubType references.
    * 
    * @param Element element
    */
   private void instantiateUpdateOrganizationListSubTypeRefs(Element element) {
      final String METHOD = "instantiateUpdateOrganizationListSubTypeRefs()";
      log4j.debug("Entered " + METHOD);

            // Entered instantiateMessageSubTypeRef()
      if (element.getName().equals("organization")) {
         log4j.debug("found element: organization");
         this.isOrganizationUpdated = true;
         instantiateOrganization(element);
         return;
      }
      // Leaving instantiateMessageSubTypeRef()


      log4j.debug("Leaving " + METHOD);
   }

/*
 * This method instantiates the organization attribute.
 * @param Element element
 */
private void instantiateOrganization(Element element) {
      // Entered instantiateSubTypeRef()
   final String METHOD = "instantiateOrganization()";
   log4j.debug("Entered " + METHOD);

   InstantiateOrganizationSubType instantiateOrganizationSubType = new InstantiateOrganizationSubType(element);
   updateOrganizationList.setOrganization(instantiateOrganizationSubType.instantiate());

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
      if (!this.isOrganizationUpdated) {
         String msg = "Organization is required, but no value was provided.";
         if (result == null) {
            result = msg;
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