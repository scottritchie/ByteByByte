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
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.Model#getGrammarName <em>Grammar Name</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.Model#getPackage <em>Package</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.Model#getRootClass <em>Root Class</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.Model#getDateTimeFormat <em>Date Time Format</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.Model#getMessages <em>Messages</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.Model#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.Model#getPenums <em>Penums</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Grammar Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Grammar Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Grammar Name</em>' containment reference.
   * @see #setGrammarName(GrammarName)
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getModel_GrammarName()
   * @model containment="true"
   * @generated
   */
  GrammarName getGrammarName();

  /**
   * Sets the value of the '{@link com.viacron.utils.bbb.byteByByte.Model#getGrammarName <em>Grammar Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Grammar Name</em>' containment reference.
   * @see #getGrammarName()
   * @generated
   */
  void setGrammarName(GrammarName value);

  /**
   * Returns the value of the '<em><b>Package</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' containment reference.
   * @see #setPackage(PackageDeclaration)
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getModel_Package()
   * @model containment="true"
   * @generated
   */
  PackageDeclaration getPackage();

  /**
   * Sets the value of the '{@link com.viacron.utils.bbb.byteByByte.Model#getPackage <em>Package</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' containment reference.
   * @see #getPackage()
   * @generated
   */
  void setPackage(PackageDeclaration value);

  /**
   * Returns the value of the '<em><b>Root Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root Class</em>' containment reference.
   * @see #setRootClass(RootClass)
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getModel_RootClass()
   * @model containment="true"
   * @generated
   */
  RootClass getRootClass();

  /**
   * Sets the value of the '{@link com.viacron.utils.bbb.byteByByte.Model#getRootClass <em>Root Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root Class</em>' containment reference.
   * @see #getRootClass()
   * @generated
   */
  void setRootClass(RootClass value);

  /**
   * Returns the value of the '<em><b>Date Time Format</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Date Time Format</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date Time Format</em>' containment reference.
   * @see #setDateTimeFormat(DateTimeFormat)
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getModel_DateTimeFormat()
   * @model containment="true"
   * @generated
   */
  DateTimeFormat getDateTimeFormat();

  /**
   * Sets the value of the '{@link com.viacron.utils.bbb.byteByByte.Model#getDateTimeFormat <em>Date Time Format</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date Time Format</em>' containment reference.
   * @see #getDateTimeFormat()
   * @generated
   */
  void setDateTimeFormat(DateTimeFormat value);

  /**
   * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
   * The list contents are of type {@link com.viacron.utils.bbb.byteByByte.Message}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Messages</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Messages</em>' containment reference list.
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getModel_Messages()
   * @model containment="true"
   * @generated
   */
  EList<Message> getMessages();

  /**
   * Returns the value of the '<em><b>Sub Types</b></em>' containment reference list.
   * The list contents are of type {@link com.viacron.utils.bbb.byteByByte.SubType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Types</em>' containment reference list.
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getModel_SubTypes()
   * @model containment="true"
   * @generated
   */
  EList<SubType> getSubTypes();

  /**
   * Returns the value of the '<em><b>Penums</b></em>' containment reference list.
   * The list contents are of type {@link com.viacron.utils.bbb.byteByByte.PEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Penums</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Penums</em>' containment reference list.
   * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage#getModel_Penums()
   * @model containment="true"
   * @generated
   */
  EList<PEnum> getPenums();

} // Model
