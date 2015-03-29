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
 * A representation of the model object '<em><b>PEnum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.PEnum#getName <em>Name</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.PEnum#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getPEnum()
 * @model
 * @generated
 */
public interface PEnum extends EObject
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
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getPEnum_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.viacron.utils.bbb.byteByByte.PEnum#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link com.viacron.utils.bbb.byteByByte.PEnumElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getPEnum_Elements()
   * @model containment="true"
   * @generated
   */
  EList<PEnumElement> getElements();

} // PEnum
