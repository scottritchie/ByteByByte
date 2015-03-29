/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage
 * @generated
 */
public interface ByteByByteFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ByteByByteFactory eINSTANCE = com.viacron.utils.bbb.byteByByte.impl.ByteByByteFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Grammar Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Grammar Name</em>'.
   * @generated
   */
  GrammarName createGrammarName();

  /**
   * Returns a new object of class '<em>Package Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Declaration</em>'.
   * @generated
   */
  PackageDeclaration createPackageDeclaration();

  /**
   * Returns a new object of class '<em>Root Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root Class</em>'.
   * @generated
   */
  RootClass createRootClass();

  /**
   * Returns a new object of class '<em>Date Time Format</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Date Time Format</em>'.
   * @generated
   */
  DateTimeFormat createDateTimeFormat();

  /**
   * Returns a new object of class '<em>Message</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message</em>'.
   * @generated
   */
  Message createMessage();

  /**
   * Returns a new object of class '<em>Abstract Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Attribute</em>'.
   * @generated
   */
  AbstractAttribute createAbstractAttribute();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>List OF</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List OF</em>'.
   * @generated
   */
  ListOF createListOF();

  /**
   * Returns a new object of class '<em>Optional</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Optional</em>'.
   * @generated
   */
  Optional createOptional();

  /**
   * Returns a new object of class '<em>Sub Type Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub Type Ref</em>'.
   * @generated
   */
  SubTypeRef createSubTypeRef();

  /**
   * Returns a new object of class '<em>PEnum Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PEnum Ref</em>'.
   * @generated
   */
  PEnumRef createPEnumRef();

  /**
   * Returns a new object of class '<em>Sub Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub Type</em>'.
   * @generated
   */
  SubType createSubType();

  /**
   * Returns a new object of class '<em>PEnum</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PEnum</em>'.
   * @generated
   */
  PEnum createPEnum();

  /**
   * Returns a new object of class '<em>PEnum Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PEnum Element</em>'.
   * @generated
   */
  PEnumElement createPEnumElement();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ByteByBytePackage getByteByBytePackage();

} //ByteByByteFactory
