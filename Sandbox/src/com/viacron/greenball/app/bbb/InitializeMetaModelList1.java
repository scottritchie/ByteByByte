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
 * The InitializeMetaModelList1 class initializes the element object with the MetaModelList1 object.
 *
 */
public class InitializeMetaModelList1 {
   private static Logger log4j = Logger.getLogger(InitializeMetaModelList1.class);
   private String theErrorMsg;
   private Element element;
   private MetaModelList1 metaModelList1;

   /**
    * The InitializeMetaModelList1 class initializes the element object with the MetaModelList1 object.
    *
    * @param metaModelList1 The object which will be used to initialize the element object.
    */
   public InitializeMetaModelList1(MetaModelList1 metaModelList1) {
      this.metaModelList1 = metaModelList1;

      this.element = new Element("MetaModelList1");
   }

   /**
    * This method initializes the element.
    */
   public Element initialize() throws MissingAttributeException {
      final String METHOD = "initialize()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element.getName(): MetaModelList1");

      if (metaModelList1.getMetaModels() != null) {
         AbstractAttribute abstractAttribute = initializeMetaModels(metaModelList1.getMetaModels());
         element.getAbstractAttributes().add(abstractAttribute);
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"metaModels\" is required, but no value was provided.");
         log4j.error(getErrorMsg());
         throw new MissingAttributeException(getErrorMsg());
      }


      log4j.debug("Leaving " + METHOD);
      return element;
   }

   /*
    * This method initializes the metaModels attribute.
    * Generated by initAttributeMethods()
    */
   private AbstractAttribute initializeMetaModels(List<MetaModel1> metaModelsList)
         throws MissingAttributeException {
      AbstractAttribute abstractAttribute = new AbstractAttribute();
      if (metaModelsList != null) {
         int indexMetaModels = 0;
         for (MetaModel1 metaModels : metaModelsList) {
            InitializeMetaModel1 initializeMetaModel1 = new InitializeMetaModel1(metaModels);
            Element metaModelsElement = initializeMetaModel1.initialize("metaModels[" + indexMetaModels + "]");
            abstractAttribute.getElements().add(metaModelsElement);
            indexMetaModels++;
         }
      }
      else {
         // Missing required attribute, generate an error message and throw an exception
         setErrorMsg("Error packing object. The attribute \"metaModels\" is required, but no value was provided.");
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