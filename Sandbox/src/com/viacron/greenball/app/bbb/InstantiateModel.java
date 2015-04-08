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

public class InstantiateModel {
   private static Logger log4j = Logger.getLogger(InstantiateModel.class);

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
   private Model model;

   /**
    * The InstantiateModel class instantiates the Model object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the Model.
    */
   public InstantiateModel(Element element) {
      this.element = element;   
      this.model = new Model();
   }

   /**
    * This method instantiates the Model.
    *
    * @return The Model.
    */
   public Model instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("Model: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateModelAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateModelSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return model;
      }

      /*
       * This method instantiates the Model attributes.
       * 
       * @param Element element
       */
      private void instantiateModelAttributes(Element element) {
      final String METHOD = "instantiateModelAttributes()";
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
               model.setOrgId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("orgName")) {
               log4j.debug("setting value of \"orgName\" to: " + kvp.getValue());
               this.isOrgNameUpdated = true;
               model.setOrgName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("name")) {
               log4j.debug("setting value of \"name\" to: " + kvp.getValue());
               model.setName(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("id")) {
               log4j.debug("setting value of \"id\" to: " + kvp.getValue());
               this.isIdUpdated = true;
               model.setId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("sessionId")) {
               log4j.debug("setting value of \"sessionId\" to: " + kvp.getValue());
               model.setSessionId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
                        // Entered instantiatePEnumRef()
            if (kvp.getKey().equals("action")) {
            log4j.debug("setting value of \"action\" to: " + kvp.getValue());
            model.setAction(ModelAction.valueOf(kvp.getValue()));
            //this.action = ModelAction.valueOf(kvp.getValue());
            }
            // Leaving instantiatePEnumRef()

         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the Model SubType references.
    * 
    * @param Element element
    */
   private void instantiateModelSubTypeRefs(Element element) {
      final String METHOD = "instantiateModelSubTypeRefs()";
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

   if (model.getRules() == null) {
   model.setRules(new ArrayList<Rule>());
   }

   InstantiateRule instantiateRule = new InstantiateRule(element);
   Rule rule = instantiateRule.instantiate();
   model.getRules().add(rule);
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
   model.setTreeNode(instantiateTreeNodeType.instantiate());

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