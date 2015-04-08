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

public class InstantiateRulePath {
private static Logger log4j = Logger.getLogger(InstantiateRulePath.class);

private Element element;
private RulePath rulePath;

/*
 * The isUpdated flags. If an attribute is required by the grammar then a value
 * must be provided, and the isUpdated flag will be set when the value is
 * obtained during unpacking. After the object is constructed during unpacking, 
 * validation will be performed to make sure a value was provided for all attributes
 * that are not optional. 
 * See buildFlags() in JBitByBitGenerator.java.
 */
private boolean isClassNameUpdated = false;
private boolean isIdUpdated = false;
private boolean isCrossReferenceUpdated = false;
private boolean isMultiUpdated = false;

/**
 * This method constructs a InstantiateRulePath object based on an Element
 * object.
 * 
 * @param element
 *            The Element.
 */
public InstantiateRulePath(Element element) {
this.element = element;
this.rulePath = new RulePath();
}

/**
 * The instantiate method instantiates a RulePath object.
 * 
 * @return The RulePath.
 */
protected RulePath instantiate() {
final String METHOD = "instantiate()";
log4j.debug("Entered " + METHOD);

log4j.debug("element: " + element.getName());

for (AbstractAttribute abstractAttribute : element.getAbstractAttributes()) {
      // Entered instantiateSubTypeElements()
   // Leaving instantiateSubTypeElements()


   for (KeyValuePair kvp : abstractAttribute.getKeyValuePairs()) {
         // Entered instantiateSubTypeAttributes()
   if (kvp.getKey().equals("className")) {
    this.isClassNameUpdated = true;
   log4j.debug("setting value of \"className\" to: " + kvp.getValue());
   rulePath.setClassName(kvp.getValue());
   }
   else if (kvp.getKey().equals("xrefClassName")) {
   log4j.debug("setting value of \"xrefClassName\" to: " + kvp.getValue());
   rulePath.setXrefClassName(kvp.getValue());
   }
   else if (kvp.getKey().equals("id")) {
    this.isIdUpdated = true;
   log4j.debug("setting value of \"id\" to: " + kvp.getValue());
   rulePath.setId(kvp.getValue());
   }
   else if (kvp.getKey().equals("crossReference")) {
    this.isCrossReferenceUpdated = true;
   log4j.debug("setting value of \"crossReference\" to: " + kvp.getValue());
   rulePath.setCrossReference(kvp.getValue().equals("true"));
   }
   else if (kvp.getKey().equals("multi")) {
    this.isMultiUpdated = true;
   log4j.debug("setting value of \"multi\" to: " + kvp.getValue());
   rulePath.setMulti(kvp.getValue().equals("true"));
   }
   // Leaving instantiateSubTypeAttributes()

   }
}

log4j.debug("Leaving " + METHOD);
return rulePath;
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
if (!this.isClassNameUpdated) {
   String msg = "ClassName is required, but no value was provided.";
   if (result == null) {
      result = msg;
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

if (!this.isCrossReferenceUpdated) {
   String msg = "CrossReference is required, but no value was provided.";
   if (result == null) {
      result = msg;
   }
   else {
      result = result.concat("\n" + msg);
   }
}

if (!this.isMultiUpdated) {
   String msg = "Multi is required, but no value was provided.";
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
