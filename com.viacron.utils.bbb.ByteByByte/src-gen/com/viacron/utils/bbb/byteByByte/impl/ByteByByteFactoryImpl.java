/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte.impl;

import com.viacron.utils.bbb.byteByByte.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ByteByByteFactoryImpl extends EFactoryImpl implements ByteByByteFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ByteByByteFactory init()
  {
    try
    {
      ByteByByteFactory theByteByByteFactory = (ByteByByteFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.viacron.com/utils/bbb/ByteByByte"); 
      if (theByteByByteFactory != null)
      {
        return theByteByByteFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ByteByByteFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ByteByByteFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ByteByBytePackage.MODEL: return createModel();
      case ByteByBytePackage.GRAMMAR_NAME: return createGrammarName();
      case ByteByBytePackage.PACKAGE_DECLARATION: return createPackageDeclaration();
      case ByteByBytePackage.ROOT_CLASS: return createRootClass();
      case ByteByBytePackage.DATE_TIME_FORMAT: return createDateTimeFormat();
      case ByteByBytePackage.MESSAGE: return createMessage();
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE: return createAbstractAttribute();
      case ByteByBytePackage.ATTRIBUTE: return createAttribute();
      case ByteByBytePackage.LIST_OF: return createListOF();
      case ByteByBytePackage.OPTIONAL: return createOptional();
      case ByteByBytePackage.SUB_TYPE_REF: return createSubTypeRef();
      case ByteByBytePackage.PENUM_REF: return createPEnumRef();
      case ByteByBytePackage.SUB_TYPE: return createSubType();
      case ByteByBytePackage.PENUM: return createPEnum();
      case ByteByBytePackage.PENUM_ELEMENT: return createPEnumElement();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ByteByBytePackage.ATTRIBUTE_TYPE:
        return createAttributeTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ByteByBytePackage.ATTRIBUTE_TYPE:
        return convertAttributeTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GrammarName createGrammarName()
  {
    GrammarNameImpl grammarName = new GrammarNameImpl();
    return grammarName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDeclaration createPackageDeclaration()
  {
    PackageDeclarationImpl packageDeclaration = new PackageDeclarationImpl();
    return packageDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RootClass createRootClass()
  {
    RootClassImpl rootClass = new RootClassImpl();
    return rootClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DateTimeFormat createDateTimeFormat()
  {
    DateTimeFormatImpl dateTimeFormat = new DateTimeFormatImpl();
    return dateTimeFormat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Message createMessage()
  {
    MessageImpl message = new MessageImpl();
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractAttribute createAbstractAttribute()
  {
    AbstractAttributeImpl abstractAttribute = new AbstractAttributeImpl();
    return abstractAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListOF createListOF()
  {
    ListOFImpl listOF = new ListOFImpl();
    return listOF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Optional createOptional()
  {
    OptionalImpl optional = new OptionalImpl();
    return optional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubTypeRef createSubTypeRef()
  {
    SubTypeRefImpl subTypeRef = new SubTypeRefImpl();
    return subTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PEnumRef createPEnumRef()
  {
    PEnumRefImpl pEnumRef = new PEnumRefImpl();
    return pEnumRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubType createSubType()
  {
    SubTypeImpl subType = new SubTypeImpl();
    return subType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PEnum createPEnum()
  {
    PEnumImpl pEnum = new PEnumImpl();
    return pEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PEnumElement createPEnumElement()
  {
    PEnumElementImpl pEnumElement = new PEnumElementImpl();
    return pEnumElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeType createAttributeTypeFromString(EDataType eDataType, String initialValue)
  {
    AttributeType result = AttributeType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAttributeTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ByteByBytePackage getByteByBytePackage()
  {
    return (ByteByBytePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ByteByBytePackage getPackage()
  {
    return ByteByBytePackage.eINSTANCE;
  }

} //ByteByByteFactoryImpl
