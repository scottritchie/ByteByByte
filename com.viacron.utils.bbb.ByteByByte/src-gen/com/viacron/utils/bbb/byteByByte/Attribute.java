/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.Attribute#getAttributeType <em>Attribute Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends AbstractAttribute
{
  /**
   * Returns the value of the '<em><b>Attribute Type</b></em>' attribute.
   * The literals are from the enumeration {@link com.viacron.utils.bbb.byteByByte.AttributeType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Type</em>' attribute.
   * @see com.viacron.utils.bbb.byteByByte.AttributeType
   * @see #setAttributeType(AttributeType)
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getAttribute_AttributeType()
   * @model
   * @generated
   */
  AttributeType getAttributeType();

  /**
   * Sets the value of the '{@link com.viacron.utils.bbb.byteByByte.Attribute#getAttributeType <em>Attribute Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute Type</em>' attribute.
   * @see com.viacron.utils.bbb.byteByByte.AttributeType
   * @see #getAttributeType()
   * @generated
   */
  void setAttributeType(AttributeType value);

} // Attribute
