/*
 * WARNING: This file was generated by BitByBitGenerator.xtend (see
 * generateSubTypeInstantiationFile()).
 * Do not edit.
 */
package com.viacron.greenball.app.bbb;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.viacron.utils.StringMessageBuffer.parser.AbstractAttribute;
import com.viacron.utils.StringMessageBuffer.parser.Element;
import com.viacron.utils.StringMessageBuffer.parser.KeyValuePair;

public class InstantiatePackageSubType {
private static Logger log4j = Logger.getLogger(InstantiatePackageSubType.class);

private Element element;
private PackageSubType packageSubType;

/*
 * The isUpdated flags. If an attribute is required by the grammar then a value
 * must be provided, and the isUpdated flag will be set when the value is
 * obtained during unpacking. After the object is constructed during unpacking, 
 * validation will be performed to make sure a value was provided for all attributes
 * that are not optional. 
 * See buildFlags() in JBitByBitGenerator.java.
 */
private boolean isNameUpdated = false;
private boolean isDataTypeUpdated = false;
private boolean isImprtUpdated = false;
private boolean isElementUpdated = false;

/**
 * This method constructs a InstantiatePackageSubType object based on an Element
 * object.
 * 
 * @param element
 *            The Element.
 */
public InstantiatePackageSubType(Element element) {
this.element = element;
this.packageSubType = new PackageSubType();
}

/**
 * The instantiate method instantiates a PackageSubType object.
 * 
 * @return The PackageSubType.
 */
protected PackageSubType instantiate() {
final String METHOD = "instantiate()";
log4j.debug("Entered " + METHOD);

log4j.debug("element: " + element.getName());

for (AbstractAttribute abstractAttribute : element.getAbstractAttributes()) {
      // Entered instantiateSubTypeElements()
   for (Element e : abstractAttribute.getElements()) {
      if (e.getName().startsWith("dataType[")) {
         this.isDataTypeUpdated = true;
         log4j.debug("found element: dataType");
         if (packageSubType.getDataType() == null) {
         List<Datatype> dataType = new ArrayList<Datatype>();
         packageSubType.setDataType(dataType);
         }

         InstantiateDatatype instantiateDatatype =
                  new InstantiateDatatype(e);
         Datatype datatype =
                  instantiateDatatype.instantiate();
         packageSubType.getDataType().add(datatype);
      }
      else if (e.getName().startsWith("imprt[")) {
         this.isImprtUpdated = true;
         log4j.debug("found element: imprt");
         if (packageSubType.getImprt() == null) {
         List<ImportSubType> imprt = new ArrayList<ImportSubType>();
         packageSubType.setImprt(imprt);
         }

         InstantiateImportSubType instantiateImportSubType =
                  new InstantiateImportSubType(e);
         ImportSubType importSubType =
                  instantiateImportSubType.instantiate();
         packageSubType.getImprt().add(importSubType);
      }
      else if (e.getName().startsWith("element[")) {
         this.isElementUpdated = true;
         log4j.debug("found element: element");
         if (packageSubType.getElement() == null) {
         List<MetaModelElement> element = new ArrayList<MetaModelElement>();
         packageSubType.setElement(element);
         }

         InstantiateMetaModelElement instantiateMetaModelElement =
                  new InstantiateMetaModelElement(e);
         MetaModelElement metaModelElement =
                  instantiateMetaModelElement.instantiate();
         packageSubType.getElement().add(metaModelElement);
      }
   }
   // Leaving instantiateSubTypeElements()


   for (KeyValuePair kvp : abstractAttribute.getKeyValuePairs()) {
         // Entered instantiateSubTypeAttributes()
   if (kvp.getKey().equals("name")) {
    this.isNameUpdated = true;
   log4j.debug("setting value of \"name\" to: " + kvp.getValue());
   packageSubType.setName(kvp.getValue());
   }
   // Leaving instantiateSubTypeAttributes()

   }
}

log4j.debug("Leaving " + METHOD);
return packageSubType;
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
if (!this.isNameUpdated) {
   String msg = "Name is required, but no value was provided.";
   if (result == null) {
      result = msg;
   }
}

if (!this.isDataTypeUpdated) {
   String msg = "DataType is required, but no value was provided.";
   if (result == null) {
      result = msg;
   }
   else {
      result = result.concat("\n" + msg);
   }
}

if (!this.isImprtUpdated) {
   String msg = "Imprt is required, but no value was provided.";
   if (result == null) {
      result = msg;
   }
   else {
      result = result.concat("\n" + msg);
   }
}

if (!this.isElementUpdated) {
   String msg = "Element is required, but no value was provided.";
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