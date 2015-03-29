/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte.impl;

import com.viacron.utils.bbb.byteByByte.ByteByBytePackage;
import com.viacron.utils.bbb.byteByByte.DateTimeFormat;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Date Time Format</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.DateTimeFormatImpl#getDateTimeFormat <em>Date Time Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DateTimeFormatImpl extends MinimalEObjectImpl.Container implements DateTimeFormat
{
  /**
   * The default value of the '{@link #getDateTimeFormat() <em>Date Time Format</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateTimeFormat()
   * @generated
   * @ordered
   */
  protected static final String DATE_TIME_FORMAT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDateTimeFormat() <em>Date Time Format</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateTimeFormat()
   * @generated
   * @ordered
   */
  protected String dateTimeFormat = DATE_TIME_FORMAT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DateTimeFormatImpl()
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
    return ByteByBytePackage.Literals.DATE_TIME_FORMAT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDateTimeFormat()
  {
    return dateTimeFormat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDateTimeFormat(String newDateTimeFormat)
  {
    String oldDateTimeFormat = dateTimeFormat;
    dateTimeFormat = newDateTimeFormat;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.DATE_TIME_FORMAT__DATE_TIME_FORMAT, oldDateTimeFormat, dateTimeFormat));
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
      case ByteByBytePackage.DATE_TIME_FORMAT__DATE_TIME_FORMAT:
        return getDateTimeFormat();
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
      case ByteByBytePackage.DATE_TIME_FORMAT__DATE_TIME_FORMAT:
        setDateTimeFormat((String)newValue);
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
      case ByteByBytePackage.DATE_TIME_FORMAT__DATE_TIME_FORMAT:
        setDateTimeFormat(DATE_TIME_FORMAT_EDEFAULT);
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
      case ByteByBytePackage.DATE_TIME_FORMAT__DATE_TIME_FORMAT:
        return DATE_TIME_FORMAT_EDEFAULT == null ? dateTimeFormat != null : !DATE_TIME_FORMAT_EDEFAULT.equals(dateTimeFormat);
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
    result.append(" (dateTimeFormat: ");
    result.append(dateTimeFormat);
    result.append(')');
    return result.toString();
  }

} //DateTimeFormatImpl
