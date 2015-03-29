/**
 * <copyright>
 * </copyright>
 *

 */
package com.viacron.utils.bbb.byteByByte.impl;

import com.viacron.utils.bbb.byteByByte.ByteByBytePackage;
import com.viacron.utils.bbb.byteByByte.DateTimeFormat;
import com.viacron.utils.bbb.byteByByte.GrammarName;
import com.viacron.utils.bbb.byteByByte.Message;
import com.viacron.utils.bbb.byteByByte.Model;
import com.viacron.utils.bbb.byteByByte.PEnum;
import com.viacron.utils.bbb.byteByByte.PackageDeclaration;
import com.viacron.utils.bbb.byteByByte.RootClass;
import com.viacron.utils.bbb.byteByByte.SubType;

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
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.ModelImpl#getGrammarName <em>Grammar Name</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.ModelImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.ModelImpl#getRootClass <em>Root Class</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.ModelImpl#getDateTimeFormat <em>Date Time Format</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.ModelImpl#getMessages <em>Messages</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.ModelImpl#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link com.viacron.utils.bbb.byteByByte.impl.ModelImpl#getPenums <em>Penums</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getGrammarName() <em>Grammar Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGrammarName()
   * @generated
   * @ordered
   */
  protected GrammarName grammarName;

  /**
   * The cached value of the '{@link #getPackage() <em>Package</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected PackageDeclaration package_;

  /**
   * The cached value of the '{@link #getRootClass() <em>Root Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRootClass()
   * @generated
   * @ordered
   */
  protected RootClass rootClass;

  /**
   * The cached value of the '{@link #getDateTimeFormat() <em>Date Time Format</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateTimeFormat()
   * @generated
   * @ordered
   */
  protected DateTimeFormat dateTimeFormat;

  /**
   * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessages()
   * @generated
   * @ordered
   */
  protected EList<Message> messages;

  /**
   * The cached value of the '{@link #getSubTypes() <em>Sub Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubTypes()
   * @generated
   * @ordered
   */
  protected EList<SubType> subTypes;

  /**
   * The cached value of the '{@link #getPenums() <em>Penums</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPenums()
   * @generated
   * @ordered
   */
  protected EList<PEnum> penums;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return ByteByBytePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GrammarName getGrammarName()
  {
    return grammarName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGrammarName(GrammarName newGrammarName, NotificationChain msgs)
  {
    GrammarName oldGrammarName = grammarName;
    grammarName = newGrammarName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByteByBytePackage.MODEL__GRAMMAR_NAME, oldGrammarName, newGrammarName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGrammarName(GrammarName newGrammarName)
  {
    if (newGrammarName != grammarName)
    {
      NotificationChain msgs = null;
      if (grammarName != null)
        msgs = ((InternalEObject)grammarName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.MODEL__GRAMMAR_NAME, null, msgs);
      if (newGrammarName != null)
        msgs = ((InternalEObject)newGrammarName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.MODEL__GRAMMAR_NAME, null, msgs);
      msgs = basicSetGrammarName(newGrammarName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.MODEL__GRAMMAR_NAME, newGrammarName, newGrammarName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDeclaration getPackage()
  {
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPackage(PackageDeclaration newPackage, NotificationChain msgs)
  {
    PackageDeclaration oldPackage = package_;
    package_ = newPackage;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByteByBytePackage.MODEL__PACKAGE, oldPackage, newPackage);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackage(PackageDeclaration newPackage)
  {
    if (newPackage != package_)
    {
      NotificationChain msgs = null;
      if (package_ != null)
        msgs = ((InternalEObject)package_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.MODEL__PACKAGE, null, msgs);
      if (newPackage != null)
        msgs = ((InternalEObject)newPackage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.MODEL__PACKAGE, null, msgs);
      msgs = basicSetPackage(newPackage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.MODEL__PACKAGE, newPackage, newPackage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RootClass getRootClass()
  {
    return rootClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRootClass(RootClass newRootClass, NotificationChain msgs)
  {
    RootClass oldRootClass = rootClass;
    rootClass = newRootClass;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByteByBytePackage.MODEL__ROOT_CLASS, oldRootClass, newRootClass);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRootClass(RootClass newRootClass)
  {
    if (newRootClass != rootClass)
    {
      NotificationChain msgs = null;
      if (rootClass != null)
        msgs = ((InternalEObject)rootClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.MODEL__ROOT_CLASS, null, msgs);
      if (newRootClass != null)
        msgs = ((InternalEObject)newRootClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.MODEL__ROOT_CLASS, null, msgs);
      msgs = basicSetRootClass(newRootClass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.MODEL__ROOT_CLASS, newRootClass, newRootClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DateTimeFormat getDateTimeFormat()
  {
    return dateTimeFormat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDateTimeFormat(DateTimeFormat newDateTimeFormat, NotificationChain msgs)
  {
    DateTimeFormat oldDateTimeFormat = dateTimeFormat;
    dateTimeFormat = newDateTimeFormat;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByteByBytePackage.MODEL__DATE_TIME_FORMAT, oldDateTimeFormat, newDateTimeFormat);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDateTimeFormat(DateTimeFormat newDateTimeFormat)
  {
    if (newDateTimeFormat != dateTimeFormat)
    {
      NotificationChain msgs = null;
      if (dateTimeFormat != null)
        msgs = ((InternalEObject)dateTimeFormat).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.MODEL__DATE_TIME_FORMAT, null, msgs);
      if (newDateTimeFormat != null)
        msgs = ((InternalEObject)newDateTimeFormat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ByteByBytePackage.MODEL__DATE_TIME_FORMAT, null, msgs);
      msgs = basicSetDateTimeFormat(newDateTimeFormat, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ByteByBytePackage.MODEL__DATE_TIME_FORMAT, newDateTimeFormat, newDateTimeFormat));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Message> getMessages()
  {
    if (messages == null)
    {
      messages = new EObjectContainmentEList<Message>(Message.class, this, ByteByBytePackage.MODEL__MESSAGES);
    }
    return messages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SubType> getSubTypes()
  {
    if (subTypes == null)
    {
      subTypes = new EObjectContainmentEList<SubType>(SubType.class, this, ByteByBytePackage.MODEL__SUB_TYPES);
    }
    return subTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PEnum> getPenums()
  {
    if (penums == null)
    {
      penums = new EObjectContainmentEList<PEnum>(PEnum.class, this, ByteByBytePackage.MODEL__PENUMS);
    }
    return penums;
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
      case ByteByBytePackage.MODEL__GRAMMAR_NAME:
        return basicSetGrammarName(null, msgs);
      case ByteByBytePackage.MODEL__PACKAGE:
        return basicSetPackage(null, msgs);
      case ByteByBytePackage.MODEL__ROOT_CLASS:
        return basicSetRootClass(null, msgs);
      case ByteByBytePackage.MODEL__DATE_TIME_FORMAT:
        return basicSetDateTimeFormat(null, msgs);
      case ByteByBytePackage.MODEL__MESSAGES:
        return ((InternalEList<?>)getMessages()).basicRemove(otherEnd, msgs);
      case ByteByBytePackage.MODEL__SUB_TYPES:
        return ((InternalEList<?>)getSubTypes()).basicRemove(otherEnd, msgs);
      case ByteByBytePackage.MODEL__PENUMS:
        return ((InternalEList<?>)getPenums()).basicRemove(otherEnd, msgs);
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
      case ByteByBytePackage.MODEL__GRAMMAR_NAME:
        return getGrammarName();
      case ByteByBytePackage.MODEL__PACKAGE:
        return getPackage();
      case ByteByBytePackage.MODEL__ROOT_CLASS:
        return getRootClass();
      case ByteByBytePackage.MODEL__DATE_TIME_FORMAT:
        return getDateTimeFormat();
      case ByteByBytePackage.MODEL__MESSAGES:
        return getMessages();
      case ByteByBytePackage.MODEL__SUB_TYPES:
        return getSubTypes();
      case ByteByBytePackage.MODEL__PENUMS:
        return getPenums();
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
      case ByteByBytePackage.MODEL__GRAMMAR_NAME:
        setGrammarName((GrammarName)newValue);
        return;
      case ByteByBytePackage.MODEL__PACKAGE:
        setPackage((PackageDeclaration)newValue);
        return;
      case ByteByBytePackage.MODEL__ROOT_CLASS:
        setRootClass((RootClass)newValue);
        return;
      case ByteByBytePackage.MODEL__DATE_TIME_FORMAT:
        setDateTimeFormat((DateTimeFormat)newValue);
        return;
      case ByteByBytePackage.MODEL__MESSAGES:
        getMessages().clear();
        getMessages().addAll((Collection<? extends Message>)newValue);
        return;
      case ByteByBytePackage.MODEL__SUB_TYPES:
        getSubTypes().clear();
        getSubTypes().addAll((Collection<? extends SubType>)newValue);
        return;
      case ByteByBytePackage.MODEL__PENUMS:
        getPenums().clear();
        getPenums().addAll((Collection<? extends PEnum>)newValue);
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
      case ByteByBytePackage.MODEL__GRAMMAR_NAME:
        setGrammarName((GrammarName)null);
        return;
      case ByteByBytePackage.MODEL__PACKAGE:
        setPackage((PackageDeclaration)null);
        return;
      case ByteByBytePackage.MODEL__ROOT_CLASS:
        setRootClass((RootClass)null);
        return;
      case ByteByBytePackage.MODEL__DATE_TIME_FORMAT:
        setDateTimeFormat((DateTimeFormat)null);
        return;
      case ByteByBytePackage.MODEL__MESSAGES:
        getMessages().clear();
        return;
      case ByteByBytePackage.MODEL__SUB_TYPES:
        getSubTypes().clear();
        return;
      case ByteByBytePackage.MODEL__PENUMS:
        getPenums().clear();
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
      case ByteByBytePackage.MODEL__GRAMMAR_NAME:
        return grammarName != null;
      case ByteByBytePackage.MODEL__PACKAGE:
        return package_ != null;
      case ByteByBytePackage.MODEL__ROOT_CLASS:
        return rootClass != null;
      case ByteByBytePackage.MODEL__DATE_TIME_FORMAT:
        return dateTimeFormat != null;
      case ByteByBytePackage.MODEL__MESSAGES:
        return messages != null && !messages.isEmpty();
      case ByteByBytePackage.MODEL__SUB_TYPES:
        return subTypes != null && !subTypes.isEmpty();
      case ByteByBytePackage.MODEL__PENUMS:
        return penums != null && !penums.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
