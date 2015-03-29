/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte.impl;

import com.viacron.utils.bbb.byteByByte.AbstractAttribute;
import com.viacron.utils.bbb.byteByByte.ByteByBytePackage;
import com.viacron.utils.bbb.byteByByte.ListOF;
import com.viacron.utils.bbb.byteByByte.Optional;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.AbstractAttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.AbstractAttributeImpl#getListOf <em>List Of</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.AbstractAttributeImpl#getOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractAttributeImpl extends MinimalEObjectImpl.Container implements AbstractAttribute
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getListOf() <em>List Of</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getListOf()
   * @generated
   * @ordered
   */
  protected ListOF listOf;

  /**
   * The cached value of the '{@link #getOptional() <em>Optional</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOptional()
   * @generated
   * @ordered
   */
  protected Optional optional;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractAttributeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ByteByBytePackage.Literals.ABSTRACT_ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.ABSTRACT_ATTRIBUTE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListOF getListOf()
  {
    return listOf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetListOf(ListOF newListOf, NotificationChain msgs)
  {
    ListOF oldListOf = listOf;
    listOf = newListOf;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByteByBytePackage.ABSTRACT_ATTRIBUTE__LIST_OF, oldListOf, newListOf);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setListOf(ListOF newListOf)
  {
    if (newListOf != listOf)
    {
      NotificationChain msgs = null;
      if (listOf != null)
        msgs = ((InternalEObject)listOf).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.ABSTRACT_ATTRIBUTE__LIST_OF, null, msgs);
      if (newListOf != null)
        msgs = ((InternalEObject)newListOf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.ABSTRACT_ATTRIBUTE__LIST_OF, null, msgs);
      msgs = basicSetListOf(newListOf, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.ABSTRACT_ATTRIBUTE__LIST_OF, newListOf, newListOf));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Optional getOptional()
  {
    return optional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOptional(Optional newOptional, NotificationChain msgs)
  {
    Optional oldOptional = optional;
    optional = newOptional;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByteByBytePackage.ABSTRACT_ATTRIBUTE__OPTIONAL, oldOptional, newOptional);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOptional(Optional newOptional)
  {
    if (newOptional != optional)
    {
      NotificationChain msgs = null;
      if (optional != null)
        msgs = ((InternalEObject)optional).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.ABSTRACT_ATTRIBUTE__OPTIONAL, null, msgs);
      if (newOptional != null)
        msgs = ((InternalEObject)newOptional).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.ABSTRACT_ATTRIBUTE__OPTIONAL, null, msgs);
      msgs = basicSetOptional(newOptional, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.ABSTRACT_ATTRIBUTE__OPTIONAL, newOptional, newOptional));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__LIST_OF:
        return basicSetListOf(null, msgs);
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__OPTIONAL:
        return basicSetOptional(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__NAME:
        return getName();
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__LIST_OF:
        return getListOf();
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__OPTIONAL:
        return getOptional();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__NAME:
        setName((String)newValue);
        return;
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__LIST_OF:
        setListOf((ListOF)newValue);
        return;
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__OPTIONAL:
        setOptional((Optional)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__LIST_OF:
        setListOf((ListOF)null);
        return;
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__OPTIONAL:
        setOptional((Optional)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__LIST_OF:
        return listOf != null;
      case ByteByBytePackage.ABSTRACT_ATTRIBUTE__OPTIONAL:
        return optional != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //AbstractAttributeImpl
