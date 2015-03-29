/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.viacron.utils.bbb.byteByByte.ByteByByteFactory
 * @model kind="package"
 * @generated
 */
public interface ByteByBytePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "byteByByte";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.viacron.com/utils/bbb/ByteByByte";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "byteByByte";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ByteByBytePackage eINSTANCE = com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl.init();

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.ModelImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Grammar Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__GRAMMAR_NAME = 0;

  /**
   * The feature id for the '<em><b>Package</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__PACKAGE = 1;

  /**
   * The feature id for the '<em><b>Root Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ROOT_CLASS = 2;

  /**
   * The feature id for the '<em><b>Date Time Format</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__DATE_TIME_FORMAT = 3;

  /**
   * The feature id for the '<em><b>Messages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MESSAGES = 4;

  /**
   * The feature id for the '<em><b>Sub Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__SUB_TYPES = 5;

  /**
   * The feature id for the '<em><b>Penums</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__PENUMS = 6;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.GrammarNameImpl <em>Grammar Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.GrammarNameImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getGrammarName()
   * @generated
   */
  int GRAMMAR_NAME = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAMMAR_NAME__NAME = 0;

  /**
   * The number of structural features of the '<em>Grammar Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAMMAR_NAME_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.PackageDeclarationImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getPackageDeclaration()
   * @generated
   */
  int PACKAGE_DECLARATION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__NAME = 0;

  /**
   * The number of structural features of the '<em>Package Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.RootClassImpl <em>Root Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.RootClassImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getRootClass()
   * @generated
   */
  int ROOT_CLASS = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_CLASS__NAME = 0;

  /**
   * The number of structural features of the '<em>Root Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_CLASS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.DateTimeFormatImpl <em>Date Time Format</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.DateTimeFormatImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getDateTimeFormat()
   * @generated
   */
  int DATE_TIME_FORMAT = 4;

  /**
   * The feature id for the '<em><b>Date Time Format</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TIME_FORMAT__DATE_TIME_FORMAT = 0;

  /**
   * The number of structural features of the '<em>Date Time Format</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TIME_FORMAT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.MessageImpl <em>Message</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.MessageImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getMessage()
   * @generated
   */
  int MESSAGE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE__NAME = 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE__ATTRIBUTES = 1;

  /**
   * The feature id for the '<em><b>Enums</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE__ENUMS = 2;

  /**
   * The number of structural features of the '<em>Message</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.AbstractAttributeImpl <em>Abstract Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.AbstractAttributeImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getAbstractAttribute()
   * @generated
   */
  int ABSTRACT_ATTRIBUTE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ATTRIBUTE__NAME = 0;

  /**
   * The feature id for the '<em><b>List Of</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ATTRIBUTE__LIST_OF = 1;

  /**
   * The feature id for the '<em><b>Optional</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ATTRIBUTE__OPTIONAL = 2;

  /**
   * The number of structural features of the '<em>Abstract Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ATTRIBUTE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.AttributeImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = ABSTRACT_ATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>List Of</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__LIST_OF = ABSTRACT_ATTRIBUTE__LIST_OF;

  /**
   * The feature id for the '<em><b>Optional</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__OPTIONAL = ABSTRACT_ATTRIBUTE__OPTIONAL;

  /**
   * The feature id for the '<em><b>Attribute Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__ATTRIBUTE_TYPE = ABSTRACT_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = ABSTRACT_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.ListOFImpl <em>List OF</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.ListOFImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getListOF()
   * @generated
   */
  int LIST_OF = 8;

  /**
   * The feature id for the '<em><b>List Of</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_OF__LIST_OF = 0;

  /**
   * The number of structural features of the '<em>List OF</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_OF_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.OptionalImpl <em>Optional</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.OptionalImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getOptional()
   * @generated
   */
  int OPTIONAL = 9;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONAL__OPTIONAL = 0;

  /**
   * The number of structural features of the '<em>Optional</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.SubTypeRefImpl <em>Sub Type Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.SubTypeRefImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getSubTypeRef()
   * @generated
   */
  int SUB_TYPE_REF = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_TYPE_REF__NAME = ABSTRACT_ATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>List Of</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_TYPE_REF__LIST_OF = ABSTRACT_ATTRIBUTE__LIST_OF;

  /**
   * The feature id for the '<em><b>Optional</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_TYPE_REF__OPTIONAL = ABSTRACT_ATTRIBUTE__OPTIONAL;

  /**
   * The feature id for the '<em><b>Sub Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_TYPE_REF__SUB_TYPE = ABSTRACT_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Sub Type Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_TYPE_REF_FEATURE_COUNT = ABSTRACT_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.PEnumRefImpl <em>PEnum Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.PEnumRefImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getPEnumRef()
   * @generated
   */
  int PENUM_REF = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENUM_REF__NAME = 0;

  /**
   * The feature id for the '<em><b>Penum</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENUM_REF__PENUM = 1;

  /**
   * The feature id for the '<em><b>Optional</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENUM_REF__OPTIONAL = 2;

  /**
   * The number of structural features of the '<em>PEnum Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENUM_REF_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.SubTypeImpl <em>Sub Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.SubTypeImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getSubType()
   * @generated
   */
  int SUB_TYPE = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_TYPE__NAME = 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_TYPE__ATTRIBUTES = 1;

  /**
   * The feature id for the '<em><b>Enums</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_TYPE__ENUMS = 2;

  /**
   * The number of structural features of the '<em>Sub Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_TYPE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.PEnumImpl <em>PEnum</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.PEnumImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getPEnum()
   * @generated
   */
  int PENUM = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENUM__NAME = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENUM__ELEMENTS = 1;

  /**
   * The number of structural features of the '<em>PEnum</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENUM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.impl.PEnumElementImpl <em>PEnum Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.impl.PEnumElementImpl
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getPEnumElement()
   * @generated
   */
  int PENUM_ELEMENT = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENUM_ELEMENT__NAME = 0;

  /**
   * The number of structural features of the '<em>PEnum Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENUM_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.viacron.utils.bbb.byteByByte.AttributeType <em>Attribute Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.viacron.utils.bbb.byteByByte.AttributeType
   * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getAttributeType()
   * @generated
   */
  int ATTRIBUTE_TYPE = 15;


  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link com.viacron.utils.bbb.byteByByte.Model#getGrammarName <em>Grammar Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Grammar Name</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Model#getGrammarName()
   * @see #getModel()
   * @generated
   */
  EReference getModel_GrammarName();

  /**
   * Returns the meta object for the containment reference '{@link com.viacron.utils.bbb.byteByByte.Model#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Package</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Model#getPackage()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Package();

  /**
   * Returns the meta object for the containment reference '{@link com.viacron.utils.bbb.byteByByte.Model#getRootClass <em>Root Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Root Class</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Model#getRootClass()
   * @see #getModel()
   * @generated
   */
  EReference getModel_RootClass();

  /**
   * Returns the meta object for the containment reference '{@link com.viacron.utils.bbb.byteByByte.Model#getDateTimeFormat <em>Date Time Format</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Date Time Format</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Model#getDateTimeFormat()
   * @see #getModel()
   * @generated
   */
  EReference getModel_DateTimeFormat();

  /**
   * Returns the meta object for the containment reference list '{@link com.viacron.utils.bbb.byteByByte.Model#getMessages <em>Messages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Messages</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Model#getMessages()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Messages();

  /**
   * Returns the meta object for the containment reference list '{@link com.viacron.utils.bbb.byteByByte.Model#getSubTypes <em>Sub Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub Types</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Model#getSubTypes()
   * @see #getModel()
   * @generated
   */
  EReference getModel_SubTypes();

  /**
   * Returns the meta object for the containment reference list '{@link com.viacron.utils.bbb.byteByByte.Model#getPenums <em>Penums</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Penums</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Model#getPenums()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Penums();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.GrammarName <em>Grammar Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Grammar Name</em>'.
   * @see com.viacron.utils.bbb.byteByByte.GrammarName
   * @generated
   */
  EClass getGrammarName();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.GrammarName#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.viacron.utils.bbb.byteByByte.GrammarName#getName()
   * @see #getGrammarName()
   * @generated
   */
  EAttribute getGrammarName_Name();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Declaration</em>'.
   * @see com.viacron.utils.bbb.byteByByte.PackageDeclaration
   * @generated
   */
  EClass getPackageDeclaration();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.PackageDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.viacron.utils.bbb.byteByByte.PackageDeclaration#getName()
   * @see #getPackageDeclaration()
   * @generated
   */
  EAttribute getPackageDeclaration_Name();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.RootClass <em>Root Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root Class</em>'.
   * @see com.viacron.utils.bbb.byteByByte.RootClass
   * @generated
   */
  EClass getRootClass();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.RootClass#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.viacron.utils.bbb.byteByByte.RootClass#getName()
   * @see #getRootClass()
   * @generated
   */
  EAttribute getRootClass_Name();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.DateTimeFormat <em>Date Time Format</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Date Time Format</em>'.
   * @see com.viacron.utils.bbb.byteByByte.DateTimeFormat
   * @generated
   */
  EClass getDateTimeFormat();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.DateTimeFormat#getDateTimeFormat <em>Date Time Format</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Date Time Format</em>'.
   * @see com.viacron.utils.bbb.byteByByte.DateTimeFormat#getDateTimeFormat()
   * @see #getDateTimeFormat()
   * @generated
   */
  EAttribute getDateTimeFormat_DateTimeFormat();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.Message <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Message</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Message
   * @generated
   */
  EClass getMessage();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.Message#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Message#getName()
   * @see #getMessage()
   * @generated
   */
  EAttribute getMessage_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.viacron.utils.bbb.byteByByte.Message#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Message#getAttributes()
   * @see #getMessage()
   * @generated
   */
  EReference getMessage_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link com.viacron.utils.bbb.byteByByte.Message#getEnums <em>Enums</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Enums</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Message#getEnums()
   * @see #getMessage()
   * @generated
   */
  EReference getMessage_Enums();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.AbstractAttribute <em>Abstract Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Attribute</em>'.
   * @see com.viacron.utils.bbb.byteByByte.AbstractAttribute
   * @generated
   */
  EClass getAbstractAttribute();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.AbstractAttribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.viacron.utils.bbb.byteByByte.AbstractAttribute#getName()
   * @see #getAbstractAttribute()
   * @generated
   */
  EAttribute getAbstractAttribute_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.viacron.utils.bbb.byteByByte.AbstractAttribute#getListOf <em>List Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List Of</em>'.
   * @see com.viacron.utils.bbb.byteByByte.AbstractAttribute#getListOf()
   * @see #getAbstractAttribute()
   * @generated
   */
  EReference getAbstractAttribute_ListOf();

  /**
   * Returns the meta object for the containment reference '{@link com.viacron.utils.bbb.byteByByte.AbstractAttribute#getOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Optional</em>'.
   * @see com.viacron.utils.bbb.byteByByte.AbstractAttribute#getOptional()
   * @see #getAbstractAttribute()
   * @generated
   */
  EReference getAbstractAttribute_Optional();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.Attribute#getAttributeType <em>Attribute Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Attribute Type</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Attribute#getAttributeType()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_AttributeType();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.ListOF <em>List OF</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List OF</em>'.
   * @see com.viacron.utils.bbb.byteByByte.ListOF
   * @generated
   */
  EClass getListOF();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.ListOF#getListOf <em>List Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>List Of</em>'.
   * @see com.viacron.utils.bbb.byteByByte.ListOF#getListOf()
   * @see #getListOF()
   * @generated
   */
  EAttribute getListOF_ListOf();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.Optional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Optional</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Optional
   * @generated
   */
  EClass getOptional();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.Optional#getOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optional</em>'.
   * @see com.viacron.utils.bbb.byteByByte.Optional#getOptional()
   * @see #getOptional()
   * @generated
   */
  EAttribute getOptional_Optional();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.SubTypeRef <em>Sub Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub Type Ref</em>'.
   * @see com.viacron.utils.bbb.byteByByte.SubTypeRef
   * @generated
   */
  EClass getSubTypeRef();

  /**
   * Returns the meta object for the reference '{@link com.viacron.utils.bbb.byteByByte.SubTypeRef#getSubType <em>Sub Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Sub Type</em>'.
   * @see com.viacron.utils.bbb.byteByByte.SubTypeRef#getSubType()
   * @see #getSubTypeRef()
   * @generated
   */
  EReference getSubTypeRef_SubType();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.PEnumRef <em>PEnum Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PEnum Ref</em>'.
   * @see com.viacron.utils.bbb.byteByByte.PEnumRef
   * @generated
   */
  EClass getPEnumRef();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.PEnumRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.viacron.utils.bbb.byteByByte.PEnumRef#getName()
   * @see #getPEnumRef()
   * @generated
   */
  EAttribute getPEnumRef_Name();

  /**
   * Returns the meta object for the reference '{@link com.viacron.utils.bbb.byteByByte.PEnumRef#getPenum <em>Penum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Penum</em>'.
   * @see com.viacron.utils.bbb.byteByByte.PEnumRef#getPenum()
   * @see #getPEnumRef()
   * @generated
   */
  EReference getPEnumRef_Penum();

  /**
   * Returns the meta object for the containment reference '{@link com.viacron.utils.bbb.byteByByte.PEnumRef#getOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Optional</em>'.
   * @see com.viacron.utils.bbb.byteByByte.PEnumRef#getOptional()
   * @see #getPEnumRef()
   * @generated
   */
  EReference getPEnumRef_Optional();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.SubType <em>Sub Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub Type</em>'.
   * @see com.viacron.utils.bbb.byteByByte.SubType
   * @generated
   */
  EClass getSubType();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.SubType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.viacron.utils.bbb.byteByByte.SubType#getName()
   * @see #getSubType()
   * @generated
   */
  EAttribute getSubType_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.viacron.utils.bbb.byteByByte.SubType#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see com.viacron.utils.bbb.byteByByte.SubType#getAttributes()
   * @see #getSubType()
   * @generated
   */
  EReference getSubType_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link com.viacron.utils.bbb.byteByByte.SubType#getEnums <em>Enums</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Enums</em>'.
   * @see com.viacron.utils.bbb.byteByByte.SubType#getEnums()
   * @see #getSubType()
   * @generated
   */
  EReference getSubType_Enums();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.PEnum <em>PEnum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PEnum</em>'.
   * @see com.viacron.utils.bbb.byteByByte.PEnum
   * @generated
   */
  EClass getPEnum();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.PEnum#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.viacron.utils.bbb.byteByByte.PEnum#getName()
   * @see #getPEnum()
   * @generated
   */
  EAttribute getPEnum_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.viacron.utils.bbb.byteByByte.PEnum#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see com.viacron.utils.bbb.byteByByte.PEnum#getElements()
   * @see #getPEnum()
   * @generated
   */
  EReference getPEnum_Elements();

  /**
   * Returns the meta object for class '{@link com.viacron.utils.bbb.byteByByte.PEnumElement <em>PEnum Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PEnum Element</em>'.
   * @see com.viacron.utils.bbb.byteByByte.PEnumElement
   * @generated
   */
  EClass getPEnumElement();

  /**
   * Returns the meta object for the attribute '{@link com.viacron.utils.bbb.byteByByte.PEnumElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.viacron.utils.bbb.byteByByte.PEnumElement#getName()
   * @see #getPEnumElement()
   * @generated
   */
  EAttribute getPEnumElement_Name();

  /**
   * Returns the meta object for enum '{@link com.viacron.utils.bbb.byteByByte.AttributeType <em>Attribute Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Attribute Type</em>'.
   * @see com.viacron.utils.bbb.byteByByte.AttributeType
   * @generated
   */
  EEnum getAttributeType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ByteByByteFactory getByteByByteFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.ModelImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Grammar Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__GRAMMAR_NAME = eINSTANCE.getModel_GrammarName();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__PACKAGE = eINSTANCE.getModel_Package();

    /**
     * The meta object literal for the '<em><b>Root Class</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ROOT_CLASS = eINSTANCE.getModel_RootClass();

    /**
     * The meta object literal for the '<em><b>Date Time Format</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__DATE_TIME_FORMAT = eINSTANCE.getModel_DateTimeFormat();

    /**
     * The meta object literal for the '<em><b>Messages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__MESSAGES = eINSTANCE.getModel_Messages();

    /**
     * The meta object literal for the '<em><b>Sub Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__SUB_TYPES = eINSTANCE.getModel_SubTypes();

    /**
     * The meta object literal for the '<em><b>Penums</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__PENUMS = eINSTANCE.getModel_Penums();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.GrammarNameImpl <em>Grammar Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.GrammarNameImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getGrammarName()
     * @generated
     */
    EClass GRAMMAR_NAME = eINSTANCE.getGrammarName();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GRAMMAR_NAME__NAME = eINSTANCE.getGrammarName_Name();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.PackageDeclarationImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getPackageDeclaration()
     * @generated
     */
    EClass PACKAGE_DECLARATION = eINSTANCE.getPackageDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGE_DECLARATION__NAME = eINSTANCE.getPackageDeclaration_Name();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.RootClassImpl <em>Root Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.RootClassImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getRootClass()
     * @generated
     */
    EClass ROOT_CLASS = eINSTANCE.getRootClass();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ROOT_CLASS__NAME = eINSTANCE.getRootClass_Name();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.DateTimeFormatImpl <em>Date Time Format</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.DateTimeFormatImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getDateTimeFormat()
     * @generated
     */
    EClass DATE_TIME_FORMAT = eINSTANCE.getDateTimeFormat();

    /**
     * The meta object literal for the '<em><b>Date Time Format</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATE_TIME_FORMAT__DATE_TIME_FORMAT = eINSTANCE.getDateTimeFormat_DateTimeFormat();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.MessageImpl <em>Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.MessageImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getMessage()
     * @generated
     */
    EClass MESSAGE = eINSTANCE.getMessage();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MESSAGE__NAME = eINSTANCE.getMessage_Name();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE__ATTRIBUTES = eINSTANCE.getMessage_Attributes();

    /**
     * The meta object literal for the '<em><b>Enums</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE__ENUMS = eINSTANCE.getMessage_Enums();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.AbstractAttributeImpl <em>Abstract Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.AbstractAttributeImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getAbstractAttribute()
     * @generated
     */
    EClass ABSTRACT_ATTRIBUTE = eINSTANCE.getAbstractAttribute();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_ATTRIBUTE__NAME = eINSTANCE.getAbstractAttribute_Name();

    /**
     * The meta object literal for the '<em><b>List Of</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_ATTRIBUTE__LIST_OF = eINSTANCE.getAbstractAttribute_ListOf();

    /**
     * The meta object literal for the '<em><b>Optional</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_ATTRIBUTE__OPTIONAL = eINSTANCE.getAbstractAttribute_Optional();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.AttributeImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Attribute Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__ATTRIBUTE_TYPE = eINSTANCE.getAttribute_AttributeType();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.ListOFImpl <em>List OF</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.ListOFImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getListOF()
     * @generated
     */
    EClass LIST_OF = eINSTANCE.getListOF();

    /**
     * The meta object literal for the '<em><b>List Of</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LIST_OF__LIST_OF = eINSTANCE.getListOF_ListOf();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.OptionalImpl <em>Optional</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.OptionalImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getOptional()
     * @generated
     */
    EClass OPTIONAL = eINSTANCE.getOptional();

    /**
     * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPTIONAL__OPTIONAL = eINSTANCE.getOptional_Optional();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.SubTypeRefImpl <em>Sub Type Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.SubTypeRefImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getSubTypeRef()
     * @generated
     */
    EClass SUB_TYPE_REF = eINSTANCE.getSubTypeRef();

    /**
     * The meta object literal for the '<em><b>Sub Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_TYPE_REF__SUB_TYPE = eINSTANCE.getSubTypeRef_SubType();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.PEnumRefImpl <em>PEnum Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.PEnumRefImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getPEnumRef()
     * @generated
     */
    EClass PENUM_REF = eINSTANCE.getPEnumRef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PENUM_REF__NAME = eINSTANCE.getPEnumRef_Name();

    /**
     * The meta object literal for the '<em><b>Penum</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PENUM_REF__PENUM = eINSTANCE.getPEnumRef_Penum();

    /**
     * The meta object literal for the '<em><b>Optional</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PENUM_REF__OPTIONAL = eINSTANCE.getPEnumRef_Optional();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.SubTypeImpl <em>Sub Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.SubTypeImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getSubType()
     * @generated
     */
    EClass SUB_TYPE = eINSTANCE.getSubType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUB_TYPE__NAME = eINSTANCE.getSubType_Name();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_TYPE__ATTRIBUTES = eINSTANCE.getSubType_Attributes();

    /**
     * The meta object literal for the '<em><b>Enums</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_TYPE__ENUMS = eINSTANCE.getSubType_Enums();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.PEnumImpl <em>PEnum</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.PEnumImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getPEnum()
     * @generated
     */
    EClass PENUM = eINSTANCE.getPEnum();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PENUM__NAME = eINSTANCE.getPEnum_Name();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PENUM__ELEMENTS = eINSTANCE.getPEnum_Elements();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.impl.PEnumElementImpl <em>PEnum Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.impl.PEnumElementImpl
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getPEnumElement()
     * @generated
     */
    EClass PENUM_ELEMENT = eINSTANCE.getPEnumElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PENUM_ELEMENT__NAME = eINSTANCE.getPEnumElement_Name();

    /**
     * The meta object literal for the '{@link com.viacron.utils.bbb.byteByByte.AttributeType <em>Attribute Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.viacron.utils.bbb.byteByByte.AttributeType
     * @see com.viacron.utils.bbb.byteByByte.impl.ByteByBytePackageImpl#getAttributeType()
     * @generated
     */
    EEnum ATTRIBUTE_TYPE = eINSTANCE.getAttributeType();

  }

} //ByteByBytePackage
