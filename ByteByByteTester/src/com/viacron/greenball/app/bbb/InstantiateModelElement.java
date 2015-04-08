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

public class InstantiateModelElement {
   private static Logger log4j = Logger.getLogger(InstantiateModelElement.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isOrgIdUpdated = false;
   private boolean isOrgNameUpdated = false;
   private boolean isIdUpdated = false;
   private boolean isPathUpdated = false;
   private boolean isValueUpdated = false;
   private boolean isActionUpdated = false;

   private Element element;
   private ModelElement modelElement;

   /**
    * The InstantiateModelElement class instantiates the ModelElement object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the ModelElement.
    */
   public InstantiateModelElement(Element element) {
      this.element = element;   
      this.modelElement = new ModelElement();
   }

   /**
    * This method instantiates the ModelElement.
    *
    * @return The ModelElement.
    */
   public ModelElement instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("ModelElement: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateModelElementAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateModelElementSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return modelElement;
      }

      /*
       * This method instantiates the ModelElement attributes.
       * 
       * @param Element element
       */
      private void instantiateModelElementAttributes(Element element) {
      final String METHOD = "instantiateModelElementAttributes()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element name: " + element.getName());
      for (AbstractAttribute attr : element.getAbstractAttributes()) {
         for (KeyValuePair kvp : attr.getKeyValuePairs()) {
            log4j.debug("key: " + kvp.getKey());
            log4j.debug("value: " + kvp.getValue());
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("orgId")) {
               log4j.debug("setting value of \"orgId\" to: " + kvp.getValue());
               this.isOrgIdUpdated = true;
               modelElement.setOrgId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("orgName")) {
               log4j.debug("setting value of \"orgName\" to: " + kvp.getValue());
               this.isOrgNameUpdated = true;
               modelElement.setOrgName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("id")) {
               log4j.debug("setting value of \"id\" to: " + kvp.getValue());
               this.isIdUpdated = true;
               modelElement.setId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("path")) {
               log4j.debug("setting value of \"path\" to: " + kvp.getValue());
               this.isPathUpdated = true;
               modelElement.setPath(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("value")) {
               log4j.debug("setting value of \"value\" to: " + kvp.getValue());
               this.isValueUpdated = true;
               modelElement.setValue(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("sessionId")) {
               log4j.debug("setting value of \"sessionId\" to: " + kvp.getValue());
               modelElement.setSessionId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
                        // Entered instantiatePEnumRef()
            if (kvp.getKey().equals("action")) {
            this.isActionUpdated = true;
            log4j.debug("setting value of \"action\" to: " + kvp.getValue());
            modelElement.setAction(ModelElementAction.valueOf(kvp.getValue()));
            //this.action = ModelElementAction.valueOf(kvp.getValue());
            }
            // Leaving instantiatePEnumRef()

         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the ModelElement SubType references.
    * 
    * @param Element element
    */
   private void instantiateModelElementSubTypeRefs(Element element) {
      final String METHOD = "instantiateModelElementSubTypeRefs()";
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
      if (!this.isOrgIdUpdated) {
         String msg = "OrgId is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
      }

      if (!this.isOrgNameUpdated) {
         String msg = "OrgName is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isIdUpdated) {
         String msg = "Id is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isPathUpdated) {
         String msg = "Path is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isValueUpdated) {
         String msg = "Value is required, but no value was provided.";
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


      if (result != null) {
         log4j.debug("result: " + result);
      }

      log4j.debug("Leaving " + METHOD);
      return result;
   }
}
