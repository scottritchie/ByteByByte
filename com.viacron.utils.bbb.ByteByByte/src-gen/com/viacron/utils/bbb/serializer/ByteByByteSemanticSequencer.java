package com.viacron.utils.bbb.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.viacron.utils.bbb.byteByByte.Attribute;
import com.viacron.utils.bbb.byteByByte.ByteByBytePackage;
import com.viacron.utils.bbb.byteByByte.DateTimeFormat;
import com.viacron.utils.bbb.byteByByte.GrammarName;
import com.viacron.utils.bbb.byteByByte.ListOF;
import com.viacron.utils.bbb.byteByByte.Message;
import com.viacron.utils.bbb.byteByByte.Model;
import com.viacron.utils.bbb.byteByByte.Optional;
import com.viacron.utils.bbb.byteByByte.PEnum;
import com.viacron.utils.bbb.byteByByte.PEnumElement;
import com.viacron.utils.bbb.byteByByte.PEnumRef;
import com.viacron.utils.bbb.byteByByte.PackageDeclaration;
import com.viacron.utils.bbb.byteByByte.RootClass;
import com.viacron.utils.bbb.byteByByte.SubType;
import com.viacron.utils.bbb.byteByByte.SubTypeRef;
import com.viacron.utils.bbb.services.ByteByByteGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ByteByByteSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ByteByByteGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ByteByBytePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ByteByBytePackage.ATTRIBUTE:
				if(context == grammarAccess.getAbstractAttributeRule() ||
				   context == grammarAccess.getAttributeRule()) {
					sequence_Attribute(context, (Attribute) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.DATE_TIME_FORMAT:
				if(context == grammarAccess.getDateTimeFormatRule()) {
					sequence_DateTimeFormat(context, (DateTimeFormat) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.GRAMMAR_NAME:
				if(context == grammarAccess.getGrammarNameRule()) {
					sequence_GrammarName(context, (GrammarName) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.LIST_OF:
				if(context == grammarAccess.getListOfRule()) {
					sequence_ListOf(context, (ListOF) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.MESSAGE:
				if(context == grammarAccess.getMessageRule()) {
					sequence_Message(context, (Message) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.OPTIONAL:
				if(context == grammarAccess.getOptionalRule()) {
					sequence_Optional(context, (Optional) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.PENUM:
				if(context == grammarAccess.getPEnumRule()) {
					sequence_PEnum(context, (PEnum) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.PENUM_ELEMENT:
				if(context == grammarAccess.getPEnumElementRule()) {
					sequence_PEnumElement(context, (PEnumElement) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.PENUM_REF:
				if(context == grammarAccess.getPEnumRefRule()) {
					sequence_PEnumRef(context, (PEnumRef) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.PACKAGE_DECLARATION:
				if(context == grammarAccess.getPackageDeclarationRule()) {
					sequence_PackageDeclaration(context, (PackageDeclaration) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.ROOT_CLASS:
				if(context == grammarAccess.getRootClassRule()) {
					sequence_RootClass(context, (RootClass) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.SUB_TYPE:
				if(context == grammarAccess.getSubTypeRule()) {
					sequence_SubType(context, (SubType) semanticObject); 
					return; 
				}
				else break;
			case ByteByBytePackage.SUB_TYPE_REF:
				if(context == grammarAccess.getAbstractAttributeRule() ||
				   context == grammarAccess.getSubTypeRefRule()) {
					sequence_SubTypeRef(context, (SubTypeRef) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID listOf=ListOf? attributeType=AttributeType optional=Optional?)
	 */
	protected void sequence_Attribute(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     dateTimeFormat=STRING
	 */
	protected void sequence_DateTimeFormat(EObject context, DateTimeFormat semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ByteByBytePackage.Literals.DATE_TIME_FORMAT__DATE_TIME_FORMAT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ByteByBytePackage.Literals.DATE_TIME_FORMAT__DATE_TIME_FORMAT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDateTimeFormatAccess().getDateTimeFormatSTRINGTerminalRuleCall_1_0(), semanticObject.getDateTimeFormat());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_GrammarName(EObject context, GrammarName semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ByteByBytePackage.Literals.GRAMMAR_NAME__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ByteByBytePackage.Literals.GRAMMAR_NAME__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGrammarNameAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     listOf='list'
	 */
	protected void sequence_ListOf(EObject context, ListOF semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ByteByBytePackage.Literals.LIST_OF__LIST_OF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ByteByBytePackage.Literals.LIST_OF__LIST_OF));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getListOfAccess().getListOfListKeyword_0_0(), semanticObject.getListOf());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID attributes+=AbstractAttribute* enums+=PEnumRef*)
	 */
	protected void sequence_Message(EObject context, Message semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         grammarName=GrammarName 
	 *         package=PackageDeclaration 
	 *         rootClass=RootClass 
	 *         dateTimeFormat=DateTimeFormat? 
	 *         messages+=Message* 
	 *         subTypes+=SubType* 
	 *         penums+=PEnum*
	 *     )
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     optional='('
	 */
	protected void sequence_Optional(EObject context, Optional semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ByteByBytePackage.Literals.OPTIONAL__OPTIONAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ByteByBytePackage.Literals.OPTIONAL__OPTIONAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOptionalAccess().getOptionalLeftParenthesisKeyword_0_0(), semanticObject.getOptional());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_PEnumElement(EObject context, PEnumElement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ByteByBytePackage.Literals.PENUM_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ByteByBytePackage.Literals.PENUM_ELEMENT__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPEnumElementAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID penum=[PEnum|ID] optional=Optional?)
	 */
	protected void sequence_PEnumRef(EObject context, PEnumRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID elements+=PEnumElement*)
	 */
	protected void sequence_PEnum(EObject context, PEnum semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=QualifiedName
	 */
	protected void sequence_PackageDeclaration(EObject context, PackageDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ByteByBytePackage.Literals.PACKAGE_DECLARATION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ByteByBytePackage.Literals.PACKAGE_DECLARATION__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_RootClass(EObject context, RootClass semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ByteByBytePackage.Literals.ROOT_CLASS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ByteByBytePackage.Literals.ROOT_CLASS__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRootClassAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID listOf=ListOf? subType=[SubType|ID] optional=Optional?)
	 */
	protected void sequence_SubTypeRef(EObject context, SubTypeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID attributes+=AbstractAttribute* enums+=PEnumRef*)
	 */
	protected void sequence_SubType(EObject context, SubType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
