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
 * The InitializeDatatype class initializes an Element object with a Datatype object.
 */
public class InitializeDatatype {
private static Logger log4j = Logger.getLogger(InitializeDatatype.class);

private String theErrorMsg;
private Datatype datatype;

public InitializeDatatype(Datatype datatype) {
this.datatype = datatype;
}

/**
 * The initialize method returns an Element object initialized with data from a
 * Datatype object.
 * @param elementName The name of the element.
 * @return The element.
 * @throws MissingAttributeException
 */
protected Element initialize(String elementName) 
    throws MissingAttributeException {
final String METHOD = "initialize()";
log4j.debug("Entered " + METHOD);
Element element = null;

if (datatype != null) {
log4j.debug("Creating new element: " + elementName);
element = new Element(elementName);

if (datatype.getName() != null) {
   AbstractAttribute abstractAttribute = initializeName(datatype.getName());
   element.getAbstractAttributes().add(abstractAttribute);
} else {
   // Missing required attribute, generate an error message and throw an exception
   setErrorMsg("Error packing object. The attribute \"name\" is required, but no value was provided.");
   log4j.error(getErrorMsg());
   throw new MissingAttributeException(getErrorMsg());
}

}

log4j.debug("Leaving " + METHOD);
return element;
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
   else {
      // Missing required attribute, generate an error message and throw an exception
      setErrorMsg("Error packing object. The attribute \"name\" is required, but no value was provided.");
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
