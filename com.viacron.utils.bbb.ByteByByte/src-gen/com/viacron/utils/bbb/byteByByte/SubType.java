/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.SubType#getName <em>Name</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.SubType#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.SubType#getEnums <em>Enums</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getSubType()
 * @model
 * @generated
 */
public interface SubType extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getSubType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.viacron.utils.bbb.byteByByte.SubType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link com.viacron.utils.bbb.byteByByte.AbstractAttribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getSubType_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<AbstractAttribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Enums</b></em>' containment reference list.
   * The list contents are of type {@link com.viacron.utils.bbb.byteByByte.PEnumRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enums</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enums</em>' containment reference list.
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getSubType_Enums()
   * @model containment="true"
   * @generated
   */
  EList<PEnumRef> getEnums();

} // SubType
