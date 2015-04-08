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

public class InstantiateResponseLoadModel {
   private static Logger log4j = Logger.getLogger(InstantiateResponseLoadModel.class);

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
   private boolean isTreeNodeUpdated = false;
   private boolean isIdUpdated = false;

   private Element element;
   private ResponseLoadModel responseLoadModel;

   /**
    * The InstantiateResponseLoadModel class instantiates the ResponseLoadModel object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the ResponseLoadModel.
    */
   public InstantiateResponseLoadModel(Element element) {
      this.element = element;   
      this.responseLoadModel = new ResponseLoadModel();
   }

   /**
    * This method instantiates the ResponseLoadModel.
    *
    * @return The ResponseLoadModel.
    */
   public ResponseLoadModel instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("ResponseLoadModel: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateResponseLoadModelAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateResponseLoadModelSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return responseLoadModel;
      }

      /*
       * This method instantiates the ResponseLoadModel attributes.
       * 
       * @param Element element
       */
      private void instantiateResponseLoadModelAttributes(Element element) {
      final String METHOD = "instantiateResponseLoadModelAttributes()";
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
               responseLoadModel.setOrgId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("orgName")) {
               log4j.debug("setting value of \"orgName\" to: " + kvp.getValue());
               this.isOrgNameUpdated = true;
               responseLoadModel.setOrgName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("name")) {
               log4j.debug("setting value of \"name\" to: " + kvp.getValue());
               responseLoadModel.setName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("id")) {
               log4j.debug("setting value of \"id\" to: " + kvp.getValue());
               this.isIdUpdated = true;
               responseLoadModel.setId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("sessionId")) {
               log4j.debug("setting value of \"sessionId\" to: " + kvp.getValue());
               responseLoadModel.setSessionId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the ResponseLoadModel SubType references.
    * 
    * @param Element element
    */
   private void instantiateResponseLoadModelSubTypeRefs(Element element) {
      final String METHOD = "instantiateResponseLoadModelSubTypeRefs()";
      log4j.debug("Entered " + METHOD);

      // Entered instantiateMessageSubTypeRefList()
      if (element.getName().startsWith("rules[")) {
         log4j.debug("found element: rules");
         instantiateRules(element);
         return;
      }
      // Leaving instantiateMessageSubTypeRefList()

            // Entered instantiateMessageSubTypeRef()
      if (element.getName().equals("treeNode")) {
         log4j.debug("found element: treeNode");
         this.isTreeNodeUpdated = true;
         instantiateTreeNode(element);
         return;
      }
      // Leaving instantiateMessageSubTypeRef()


      log4j.debug("Leaving " + METHOD);
   }

/*
 * This method instantiates the rules attribute which is a list of Rule
 * @param Element element
 */
private void instantiateRules(Element element) {
      // Entered instantiateSubTypeRefList()
   final String METHOD = "instantiateRules()";
   log4j.debug("Entered " + METHOD);

   if (responseLoadModel.getRules() == null) {
   responseLoadModel.setRules(new ArrayList<Rule>());
   }

   InstantiateRule instantiateRule = new InstantiateRule(element);
   Rule rule = instantiateRule.instantiate();
   responseLoadModel.getRules().add(rule);
   log4j.debug("Leaving " + METHOD);
   // Leaving instantiateSubTypeRefList()
}
/*
 * This method instantiates the treeNode attribute.
 * @param Element element
 */
private void instantiateTreeNode(Element element) {
      // Entered instantiateSubTypeRef()
   final String METHOD = "instantiateTreeNode()";
   log4j.debug("Entered " + METHOD);

   InstantiateTreeNodeType instantiateTreeNodeType = new InstantiateTreeNodeType(element);
   responseLoadModel.setTreeNode(instantiateTreeNodeType.instantiate());

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

      if (!this.isTreeNodeUpdated) {
         String msg = "TreeNode is required, but no value was provided.";
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


      if (result != null) {
         log4j.debug("result: " + result);
      }

      log4j.debug("Leaving " + METHOD);
      return result;
   }
}