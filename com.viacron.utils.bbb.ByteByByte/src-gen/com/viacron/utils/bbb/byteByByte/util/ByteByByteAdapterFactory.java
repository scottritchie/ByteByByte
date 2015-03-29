/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte.util;

import com.viacron.utils.bbb.byteByByte.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.viacron.utils.bbb.byteByByte.ByteByBytePackage
 * @generated
 */
public class ByteByByteAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ByteByBytePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ByteByByteAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ByteByBytePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ByteByByteSwitch<Adapter> modelSwitch =
    new ByteByByteSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseGrammarName(GrammarName object)
      {
        return createGrammarNameAdapter();
      }
      @Override
      public Adapter casePackageDeclaration(PackageDeclaration object)
      {
        return createPackageDeclarationAdapter();
      }
      @Override
      public Adapter caseRootClass(RootClass object)
      {
        return createRootClassAdapter();
      }
      @Override
      public Adapter caseDateTimeFormat(DateTimeFormat object)
      {
        return createDateTimeFormatAdapter();
      }
      @Override
      public Adapter caseMessage(Message object)
      {
        return createMessageAdapter();
      }
      @Override
      public Adapter caseAbstractAttribute(AbstractAttribute object)
      {
        return createAbstractAttributeAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseListOF(ListOF object)
      {
        return createListOFAdapter();
      }
      @Override
      public Adapter caseOptional(Optional object)
      {
        return createOptionalAdapter();
      }
      @Override
      public Adapter caseSubTypeRef(SubTypeRef object)
      {
        return createSubTypeRefAdapter();
      }
      @Override
      public Adapter casePEnumRef(PEnumRef object)
      {
        return createPEnumRefAdapter();
      }
      @Override
      public Adapter caseSubType(SubType object)
      {
        return createSubTypeAdapter();
      }
      @Override
      public Adapter casePEnum(PEnum object)
      {
        return createPEnumAdapter();
      }
      @Override
      public Adapter casePEnumElement(PEnumElement object)
      {
        return createPEnumElementAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.GrammarName <em>Grammar Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.GrammarName
   * @generated
   */
  public Adapter createGrammarNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.PackageDeclaration
   * @generated
   */
  public Adapter createPackageDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.RootClass <em>Root Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.RootClass
   * @generated
   */
  public Adapter createRootClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.DateTimeFormat <em>Date Time Format</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.DateTimeFormat
   * @generated
   */
  public Adapter createDateTimeFormatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.Message <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.Message
   * @generated
   */
  public Adapter createMessageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.AbstractAttribute <em>Abstract Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.AbstractAttribute
   * @generated
   */
  public Adapter createAbstractAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.ListOF <em>List OF</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.ListOF
   * @generated
   */
  public Adapter createListOFAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.Optional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.Optional
   * @generated
   */
  public Adapter createOptionalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.SubTypeRef <em>Sub Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.SubTypeRef
   * @generated
   */
  public Adapter createSubTypeRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.PEnumRef <em>PEnum Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.PEnumRef
   * @generated
   */
  public Adapter createPEnumRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.SubType <em>Sub Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.SubType
   * @generated
   */
  public Adapter createSubTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.PEnum <em>PEnum</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.PEnum
   * @generated
   */
  public Adapter createPEnumAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.viacron.utils.bbb.byteByByte.PEnumElement <em>PEnum Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.viacron.utils.bbb.byteByByte.PEnumElement
   * @generated
   */
  public Adapter createPEnumElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //ByteByByteAdapterFactory
