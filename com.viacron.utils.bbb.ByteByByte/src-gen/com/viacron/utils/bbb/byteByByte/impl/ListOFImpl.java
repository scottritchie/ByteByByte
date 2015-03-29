/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte.impl;

import com.viacron.utils.bbb.byteByByte.ByteByBytePackage;
import com.viacron.utils.bbb.byteByByte.ListOF;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List OF</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.ListOFImpl#getListOf <em>List Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ListOFImpl extends MinimalEObjectImpl.Container implements ListOF
{
  /**
   * The default value of the '{@link #getListOf() <em>List Of</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getListOf()
   * @generated
   * @ordered
   */
  protected static final String LIST_OF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getListOf() <em>List Of</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getListOf()
   * @generated
   * @ordered
   */
  protected String listOf = LIST_OF_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ListOFImpl()
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
    return ByteByBytePackage.Literals.LIST_OF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getListOf()
  {
    return listOf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setListOf(String newListOf)
  {
    String oldListOf = listOf;
    listOf = newListOf;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.LIST_OF__LIST_OF, oldListOf, listOf));
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
      case ByteByBytePackage.LIST_OF__LIST_OF:
        return getListOf();
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
      case ByteByBytePackage.LIST_OF__LIST_OF:
        setListOf((String)newValue);
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
      case ByteByBytePackage.LIST_OF__LIST_OF:
        setListOf(LIST_OF_EDEFAULT);
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
      case ByteByBytePackage.LIST_OF__LIST_OF:
        return LIST_OF_EDEFAULT == null ? listOf != null : !LIST_OF_EDEFAULT.equals(listOf);
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
    result.append(" (listOf: ");
    result.append(listOf);
    result.append(')');
    return result.toString();
  }

} //ListOFImpl
