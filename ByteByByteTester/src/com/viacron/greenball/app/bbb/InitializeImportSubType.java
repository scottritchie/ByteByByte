/*
 * WARNING: This file was generated by BitByBitGenerator.xtend (see
 * generateSubTypeInitializationFile()).
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
 * The InitializeImportSubType class initializes an Element object with a ImportSubType object.
 */
public class InitializeImportSubType {
private static Logger log4j = Logger.getLogger(InitializeImportSubType.class);

private String theErrorMsg;
private ImportSubType importSubType;

public InitializeImportSubType(ImportSubType importSubType) {
this.importSubType = importSubType;
}

/**
 * The initialize method returns an Element object initialized with data from a
 * ImportSubType object.
 * @param elementName The name of the element.
 * @return The element.
 * @throws MissingAttributeException
 */
protected Element initialize(String elementName) 
    throws MissingAttributeException {
final String METHOD = "initialize()";
log4j.debug("Entered " + METHOD);
Element element = null;

if (importSubType != null) {
log4j.debug("Creating new element: " + elementName);
element = new Element(elementName);

if (importSubType.getImportNameSpace() != null) {
AbstractAttribute abstractAttribute = initializeImportNameSpace(importSubType.getImportNameSpace());
element.getAbstractAttributes().add(abstractAttribute);
} else {
   // Missing required attribute, generate an error message and throw an exception
   setErrorMsg("Error packing object. The attribute \"importNameSpace\" is required, but no value was provided.");
   log4j.error(getErrorMsg());
   throw new MissingAttributeException(getErrorMsg());
}

}

log4j.debug("Leaving " + METHOD);
return element;
}

/*
 * This method initializes the importNameSpace attribute.
 * Generated by initAttributeMethods()
 */
private AbstractAttribute initializeImportNameSpace(String importNameSpace)
         throws MissingAttributeException {
   AbstractAttribute abstractAttribute = new AbstractAttribute();
   // Entered initAbstractAttributeValue()
   // Entered initAttributeValue()
   if (importNameSpace != null) {
      log4j.debug("Creating new KeyValuePair: importNameSpace");
      KeyValuePair kvp = new KeyValuePair("importNameSpace", "<STRING_BEGIN>" + importNameSpace + "<STRING_END>");
      abstractAttribute.getKeyValuePairs().add(kvp);
   }
   else {
      // Missing required attribute, generate an error message and throw an exception
      setErrorMsg("Error packing object. The attribute \"importNameSpace\" is required, but no value was provided.");
      log4j.error(getErrorMsg());
      throw new MissingAttributeException(getErrorMsg());
   }

   // Leaving initAttributeValue()
   // Leaving initAbstractAttributeValue()
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
