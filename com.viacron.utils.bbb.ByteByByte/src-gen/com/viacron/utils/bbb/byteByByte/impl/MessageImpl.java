/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte.impl;

import com.viacron.utils.bbb.byteByByte.AbstractAttribute;
import com.viacron.utils.bbb.byteByByte.ByteByBytePackage;
import com.viacron.utils.bbb.byteByByte.Message;
import com.viacron.utils.bbb.byteByByte.PEnumRef;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.MessageImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.MessageImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.MessageImpl#getEnums <em>Enums</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageImpl extends MinimalEObjectImpl.Container implements Message
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
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<AbstractAttribute> attributes;

  /**
   * The cached value of the '{@link #getEnums() <em>Enums</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnums()
   * @generated
   * @ordered
   */
  protected EList<PEnumRef> enums;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MessageImpl()
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
    return ByteByBytePackage.Literals.MESSAGE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.MESSAGE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractAttribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<AbstractAttribute>(AbstractAttribute.class, this, ByteByBytePackage.MESSAGE__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PEnumRef> getEnums()
  {
    if (enums == null)
    {
      enums = new EObjectContainmentEList<PEnumRef>(PEnumRef.class, this, ByteByBytePackage.MESSAGE__ENUMS);
    }
    return enums;
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
      case ByteByBytePackage.MESSAGE__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case ByteByBytePackage.MESSAGE__ENUMS:
        return ((InternalEList<?>)getEnums()).basicRemove(otherEnd, msgs);
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
      case ByteByBytePackage.MESSAGE__NAME:
        return getName();
      case ByteByBytePackage.MESSAGE__ATTRIBUTES:
        return getAttributes();
      case ByteByBytePackage.MESSAGE__ENUMS:
        return getEnums();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ByteByBytePackage.MESSAGE__NAME:
        setName((String)newValue);
        return;
      case ByteByBytePackage.MESSAGE__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends AbstractAttribute>)newValue);
        return;
      case ByteByBytePackage.MESSAGE__ENUMS:
        getEnums().clear();
        getEnums().addAll((Collection<? extends PEnumRef>)newValue);
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
      case ByteByBytePackage.MESSAGE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ByteByBytePackage.MESSAGE__ATTRIBUTES:
        getAttributes().clear();
        return;
      case ByteByBytePackage.MESSAGE__ENUMS:
        getEnums().clear();
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
      case ByteByBytePackage.MESSAGE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ByteByBytePackage.MESSAGE__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case ByteByBytePackage.MESSAGE__ENUMS:
        return enums != null && !enums.isEmpty();
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

} //MessageImpl
