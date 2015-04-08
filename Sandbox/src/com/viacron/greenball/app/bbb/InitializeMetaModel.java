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
 * The InitializeMetaModel class initializes the element object with the MetaModel object.
 *
 */
public class InitializeMetaModel {
   private static Logger log4j = Logger.getLogger(InitializeMetaModel.class);
   private String theErrorMsg;
   private Element element;
   private MetaModel metaModel;

   /**
    * The InitializeMetaModel class initializes the element object with the MetaModel object.
    *
    * @param metaModel The object which will be used to initialize the element object.
    */
   public InitializeMetaModel(MetaModel metaModel) {
      this.metaModel = metaModel;

      this.element = new Element("MetaModel");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): MetaModel");

      if (metaModel.getId() != null) {
         AbstractAttribute abstractAttribute = initializeId(metaModel.getId());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"id\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }

      if (metaModel.getPckg() != null) {
         AbstractAttribute abstractAttribute = initializePckg(metaModel.getPckg());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"pckg\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }


      log4j.debug("Leaving " + METHOD);
      return element;
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
    * This method initializes the pckg attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializePckg(List<PackageSubType> pckgList)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      if (pckgList != null) {
         int indexPckg = 0;
         for (PackageSubType pckg : pckgList) {
            InitializePackageSubType initializePackageSubType = new InitializePackageSubType(pckg);
            Element pckgElement = initializePackageSubType.initialize("pckg[" + indexPckg + "]");
            abstractAttribute.getElements().add(pckgElement);
            indexPckg++;
         }
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"pckg\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }
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
