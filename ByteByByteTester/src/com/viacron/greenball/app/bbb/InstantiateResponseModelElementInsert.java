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

public class InstantiateResponseModelElementInsert {
   private static Logger log4j = Logger.getLogger(InstantiateResponseModelElementInsert.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isOrgIdUpdated = false;
   private boolean isTreeNodeUpdated = false;

   private Element element;
   private ResponseModelElementInsert responseModelElementInsert;

   /**
    * The InstantiateResponseModelElementInsert class instantiates the ResponseModelElementInsert object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the ResponseModelElementInsert.
    */
   public InstantiateResponseModelElementInsert(Element element) {
      this.element = element;   
      this.responseModelElementInsert = new ResponseModelElementInsert();
   }

   /**
    * This method instantiates the ResponseModelElementInsert.
    *
    * @return The ResponseModelElementInsert.
    */
   public ResponseModelElementInsert instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("ResponseModelElementInsert: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateResponseModelElementInsertAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateResponseModelElementInsertSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return responseModelElementInsert;
      }

      /*
       * This method instantiates the ResponseModelElementInsert attributes.
       * 
       * @param Element element
       */
      private void instantiateResponseModelElementInsertAttributes(Element element) {
      final String METHOD = "instantiateResponseModelElementInsertAttributes()";
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
               responseModelElementInsert.setOrgId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("sessionId")) {
               log4j.debug("setting value of \"sessionId\" to: " + kvp.getValue());
               responseModelElementInsert.setSessionId(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the ResponseModelElementInsert SubType references.
    * 
    * @param Element element
    */
   private void instantiateResponseModelElementInsertSubTypeRefs(Element element) {
      final String METHOD = "instantiateResponseModelElementInsertSubTypeRefs()";
      log4j.debug("Entered " + METHOD);

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
 * This method instantiates the treeNode attribute.
 * @param Element element
 */
private void instantiateTreeNode(Element element) {
      // Entered instantiateSubTypeRef()
   final String METHOD = "instantiateTreeNode()";
   log4j.debug("Entered " + METHOD);

   InstantiateTreeNodeType instantiateTreeNodeType = new InstantiateTreeNodeType(element);
   responseModelElementInsert.setTreeNode(instantiateTreeNodeType.instantiate());

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

      if (!this.isTreeNodeUpdated) {
         String msg = "TreeNode is required, but no value was provided.";
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