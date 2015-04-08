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
 * The InitializeModel class initializes the element object with the Model object.
 *
 */
public class InitializeModel {
   private static Logger log4j = Logger.getLogger(InitializeModel.class);
   private String theErrorMsg;
   private Element element;
   private Model model;

   /**
    * The InitializeModel class initializes the element object with the Model object.
    *
    * @param model The object which will be used to initialize the element object.
    */
   public InitializeModel(Model model) {
      this.model = model;

      this.element = new Element("Model");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): Model");

      if (model.getOrgId() != null) {
         AbstractAttribute abstractAttribute = initializeOrgId(model.getOrgId());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgId\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (model.getOrgName() != null) {
         AbstractAttribute abstractAttribute = initializeOrgName(model.getOrgName());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (model.getName() != null) {
         AbstractAttribute abstractAttribute = initializeName(model.getName());
         element.getAbstractAttributes().add(abstractAttribute);
      }


      if (model.getRules() != null) {
         AbstractAttribute abstractAttribute = initializeRules(model.getRules());
         element.getAbstractAttributes().add(abstractAttribute);
      }


      if (model.getTreeNode() != null) {
         AbstractAttribute abstractAttribute = initializeTreeNode(model.getTreeNode());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"treeNode\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (model.getId() != null) {
         AbstractAttribute abstractAttribute = initializeId(model.getId());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"id\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (model.getSessionId() != null) {
         AbstractAttribute abstractAttribute = initializeSessionId(model.getSessionId());
         element.getAbstractAttributes().add(abstractAttribute);
      }

      if (model.getAction() != null) {
         AbstractAttribute abstractAttribute = initializeAction(model.getAction());
         element.getAbstractAttributes().add(abstractAttribute);
      }


      log4j.debug("Leaving " + METHOD);
      return element;
   }

   /*
    * This method initializes the orgId attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeOrgId(String orgId)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (orgId != null) {
         log4j.debug("Creating new KeyValuePair: orgId");
         KeyValuePair kvp = new KeyValuePair("orgId", "<STRING_BEGIN>" + orgId + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgId\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the orgName attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeOrgName(String orgName)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (orgName != null) {
         log4j.debug("Creating new KeyValuePair: orgName");
         KeyValuePair kvp = new KeyValuePair("orgName", "<STRING_BEGIN>" + orgName + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"orgName\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the name attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeName(String name)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (name != null) {
         log4j.debug("Creating new KeyValuePair: name");
         KeyValuePair kvp = new KeyValuePair("name", "<STRING_BEGIN>" + name + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
      return abstractAttribute;
   }

   /*
    * This method initializes the rules attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeRules(List<Rule> rulesList)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      if (rulesList != null) {
         int indexRules = 0;
         for (Rule rules : rulesList) {
            InitializeRule initializeRule = new InitializeRule(rules);
            Element rulesElement = initializeRule.initialize("rules[" + indexRules + "]");
            abstractAttribute.getElements().add(rulesElement);
            indexRules++;
         }
      }
      return abstractAttribute;
   }

   /*
    * This method initializes the treeNode attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeTreeNode(TreeNodeType treeNode)
             throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      if (treeNode != null) {
         InitializeTreeNodeType initializeTreeNodeType = new InitializeTreeNodeType(treeNode);
         Element treeNodeElement = initializeTreeNodeType.initialize("treeNode");
         abstractAttribute.getElements().add(treeNodeElement);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"treeNode\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }
      return abstractAttribute;
   }

   /*
    * This method initializes the id attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeId(String id)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initAbstractAttributeValue()
      // Entered initAttributeValue()
      if (id != null) {
         log4j.debug("Creating new KeyValuePair: id");
         KeyValuePair kvp = new KeyValuePair("id", "<STRING_BEGIN>" + id + "<STRING_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"id\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      // Leaving initAttributeValue()
      // Leaving initAbstractAttributeValue()
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

   private AbstractAttribute initializeAction(ModelAction action)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      // Entered initPEnumRefValue()
      if (action != null) {
         log4j.debug("Creating new Key/Value pair: action");
         KeyValuePair kvp = new KeyValuePair("action", "<ENUM_BEGIN>" + action + "<ENUM_END>");
         abstractAttribute.getKeyValuePairs().add(kvp);
      }
      // Leaving initPEnumRefValue()
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