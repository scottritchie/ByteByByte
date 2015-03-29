/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte.impl;

import com.viacron.utils.bbb.byteByByte.ByteByBytePackage;
import com.viacron.utils.bbb.byteByByte.Optional;
import com.viacron.utils.bbb.byteByByte.PEnum;
import com.viacron.utils.bbb.byteByByte.PEnumRef;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PEnum Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.PEnumRefImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.PEnumRefImpl#getPenum <em>Penum</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.PEnumRefImpl#getOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PEnumRefImpl extends MinimalEObjectImpl.Container implements PEnumRef
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
   * The cached value of the '{@link #getPenum() <em>Penum</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPenum()
   * @generated
   * @ordered
   */
  protected PEnum penum;

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
  protected PEnumRefImpl()
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
    return ByteByBytePackage.Literals.PENUM_REF;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.PENUM_REF__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PEnum getPenum()
  {
    if (penum != null && penum.eIsProxy())
    {
      InternalEObject oldPenum = (InternalEObject)penum;
      penum = (PEnum)eResolveProxy(oldPenum);
      if (penum != oldPenum)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ByteByBytePackage.PENUM_REF__PENUM, oldPenum, penum));
      }
    }
    return penum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PEnum basicGetPenum()
  {
    return penum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPenum(PEnum newPenum)
  {
    PEnum oldPenum = penum;
    penum = newPenum;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.PENUM_REF__PENUM, oldPenum, penum));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByteByBytePackage.PENUM_REF__OPTIONAL, oldOptional, newOptional);
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
        msgs = ((InternalEObject)optional).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.PENUM_REF__OPTIONAL, null, msgs);
      if (newOptional != null)
        msgs = ((InternalEObject)newOptional).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.PENUM_REF__OPTIONAL, null, msgs);
      msgs = basicSetOptional(newOptional, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.PENUM_REF__OPTIONAL, newOptional, newOptional));
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
      case ByteByBytePackage.PENUM_REF__OPTIONAL:
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
      case ByteByBytePackage.PENUM_REF__NAME:
        return getName();
      case ByteByBytePackage.PENUM_REF__PENUM:
        if (resolve) return getPenum();
        return basicGetPenum();
      case ByteByBytePackage.PENUM_REF__OPTIONAL:
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
      case ByteByBytePackage.PENUM_REF__NAME:
        setName((String)newValue);
        return;
      case ByteByBytePackage.PENUM_REF__PENUM:
        setPenum((PEnum)newValue);
        return;
      case ByteByBytePackage.PENUM_REF__OPTIONAL:
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
      case ByteByBytePackage.PENUM_REF__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ByteByBytePackage.PENUM_REF__PENUM:
        setPenum((PEnum)null);
        return;
      case ByteByBytePackage.PENUM_REF__OPTIONAL:
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
      case ByteByBytePackage.PENUM_REF__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ByteByBytePackage.PENUM_REF__PENUM:
        return penum != null;
      case ByteByBytePackage.PENUM_REF__OPTIONAL:
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

} //PEnumRefImpl
