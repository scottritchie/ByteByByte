/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.AbstractAttribute#getName <em>Name</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.AbstractAttribute#getListOf <em>List Of</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.AbstractAttribute#getOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getAbstractAttribute()
 * @model
 * @generated
 */
public interface AbstractAttribute extends EObject
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
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getAbstractAttribute_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.viacron.utils.bbb.byteByByte.AbstractAttribute#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>List Of</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>List Of</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>List Of</em>' containment reference.
   * @see #setListOf(ListOF)
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getAbstractAttribute_ListOf()
   * @model containment="true"
   * @generated
   */
  ListOF getListOf();

  /**
   * Sets the value of the '{@link com.viacron.utils.bbb.byteByByte.AbstractAttribute#getListOf <em>List Of</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List Of</em>' containment reference.
   * @see #getListOf()
   * @generated
   */
  void setListOf(ListOF value);

  /**
   * Returns the value of the '<em><b>Optional</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Optional</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Optional</em>' containment reference.
   * @see #setOptional(Optional)
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getAbstractAttribute_Optional()
   * @model containment="true"
   * @generated
   */
  Optional getOptional();

  /**
   * Sets the value of the '{@link com.viacron.utils.bbb.byteByByte.AbstractAttribute#getOptional <em>Optional</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Optional</em>' containment reference.
   * @see #getOptional()
   * @generated
   */
  void setOptional(Optional value);

} // AbstractAttribute
