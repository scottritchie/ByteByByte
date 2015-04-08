/*
 * WARNING: This file was generated by BitByBitGenerator.xtend (see
 * generateRootClassEnumFile()).
 * Do not edit.
 */
package com.viacron.greenball.app.bbb;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * The GreenballMessagesEnum class is an enumeration of the root class of the
 * messaging system defined by the GreenballMessages grammar.
 */
public enum GreenballMessagesEnum {
   ADD_ORGANIZATION(0, "AddOrganization"),
   APPROVE_SUBSCRIPTION_REQUEST(1, "ApproveSubscriptionRequest"),
   A_TEST_MESSAGE(2, "ATestMessage"),
   CHAT(3, "Chat"),
   CHAT_USER(4, "ChatUser"),
   CONFIGURATION_CONSTANTS(5, "ConfigurationConstants"),
   DELETE_RULE_MESSAGE(6, "DeleteRuleMessage"),
   DELETE_RULE_MESSAGE_RESPONSE(7, "DeleteRuleMessageResponse"),
   DELETE_RULE_PHASE2_MESSAGE(8, "DeleteRulePhase2Message"),
   DELETE_RULES_MESSAGE(9, "DeleteRulesMessage"),
   DELETE_SUBSCRIPTION_REQUEST(10, "DeleteSubscriptionRequest"),
   DIRECTORY(11, "Directory"),
   EDIT_RULE_MESSAGE(12, "EditRuleMessage"),
   ERROR_MESSAGE(13, "ErrorMessage"),
   FILE_TRANSFER(14, "FileTransfer"),
   GRAMMAR(15, "Grammar"),
   HEARTBEAT(16, "Heartbeat"),
   INSERT_RULE_MESSAGE(17, "InsertRuleMessage"),
   INSERT_RULE_PHASE2_MESSAGE(18, "InsertRulePhase2Message"),
   JOURNAL_ENTRY(19, "JournalEntry"),
   JOURNAL_SUBSCRIPTION_REQUEST(20, "JournalSubscriptionRequest"),
   LIST_SUBSCRIPTIONS(21, "ListSubscriptions"),
   LOGIN(22, "Login"),
   META_MODEL(23, "MetaModel"),
   META_MODEL_LIST1(24, "MetaModelList1"),
   META_MODEL_LOAD_REQUEST(25, "MetaModelLoadRequest"),
   META_MODEL_LOCK_REQUEST(26, "MetaModelLockRequest"),
   META_MODEL_LOCK_RESPONSE(27, "MetaModelLockResponse"),
   MODEL(28, "Model"),
   MODEL_ELEMENT(29, "ModelElement"),
   NEW_SUBSCRIPTION(30, "NewSubscription"),
   ORGANIZATION_LIST(31, "OrganizationList"),
   ORGANIZATION_REQUEST(32, "OrganizationRequest"),
   REGISTER_NEW_USER(33, "RegisterNewUser"),
   REGISTER_NEW_USER_RESPONSE(34, "RegisterNewUserResponse"),
   REQUEST_CHANGE_PASSWORD(35, "RequestChangePassword"),
   REQUEST_CLOSE_CONNECTION(36, "RequestCloseConnection"),
   REQUEST_CONFIGURATION_CONSTANTS(37, "RequestConfigurationConstants"),
   REQUEST_DELETE_ORGANIZATION(38, "RequestDeleteOrganization"),
   REQUEST_GRAMMAR(39, "RequestGrammar"),
   REQUEST_LOAD_MODEL(40, "RequestLoadModel"),
   REQUEST_LOGIN(41, "RequestLogin"),
   REQUEST_MODEL(42, "RequestModel"),
   REQUEST_ORGANIZATION_LIST(43, "RequestOrganizationList"),
   REQUEST_SAVE_GRAMMAR(44, "RequestSaveGrammar"),
   REQUEST_SUBSCRIPTION(45, "RequestSubscription"),
   REQUEST_SUBSCRIPTION_PHASE2(46, "RequestSubscriptionPhase2"),
   REQUEST_UNSUBSCRIBE(47, "RequestUnsubscribe"),
   RESPONSE_CHANGE_PASSWORD(48, "ResponseChangePassword"),
   RESPONSE_CLOSE_CONNECTION(49, "ResponseCloseConnection"),
   RESPONSE_DELETE_ORGANIZATION(50, "ResponseDeleteOrganization"),
   RESPONSE_EDIT_RULE_MESSAGE(51, "ResponseEditRuleMessage"),
   RESPONSE_INSERT_RULE_MESSAGE(52, "ResponseInsertRuleMessage"),
   RESPONSE_LOAD_MODEL(53, "ResponseLoadModel"),
   RESPONSE_LOGIN(54, "ResponseLogin"),
   RESPONSE_MODEL_ELEMENT_INSERT(55, "ResponseModelElementInsert"),
   RESPONSE_MODEL_ELEMENT_UPDATE(56, "ResponseModelElementUpdate"),
   RESPONSE_SUBSCRIPTION_REQUEST(57, "ResponseSubscriptionRequest"),
   RESPONSE_UNSUBSCRIBE(58, "ResponseUnsubscribe"),
   RULE_EXPIRED(59, "RuleExpired"),
   RULE_MESSAGE(60, "RuleMessage"),
   RULE_SYNC_REQUEST(61, "RuleSyncRequest"),
   RULE_SYNC_RESPONSE(62, "RuleSyncResponse"),
   SAVE_GRAMMAR_PHASE1(63, "SaveGrammarPhase1"),
   SAVE_GRAMMAR_PHASE2(64, "SaveGrammarPhase2"),
   SIGN_UP(65, "SignUp"),
   SIGN_UP_RESPONSE(66, "SignUpResponse"),
   SMS_PROVIDER_REQUEST(67, "SmsProviderRequest"),
   SMS_PROVIDERS(68, "SmsProviders"),
   SUBSCRIBERS(69, "Subscribers"),
   SUBSCRIBERS_REQUEST(70, "SubscribersRequest"),
   SUBSCRIPTION_REQUEST(71, "SubscriptionRequest"),
   SUBSCRIPTION_REQUESTS(72, "SubscriptionRequests"),
   SUBSCRIPTIONS(73, "Subscriptions"),
   TEMPLATES(74, "Templates"),
   TERMINATE(75, "Terminate"),
   TOPIC_SUBSCRIPTION_REQUEST(76, "TopicSubscriptionRequest"),
   UPDATE_ORGANIZATION_LIST(77, "UpdateOrganizationList"),
   UPDATE_RULE_DEADLINE(78, "UpdateRuleDeadline"),
   ABSTRACT_TYPE(79, "AbstractType"),
   ATTRIBUTE(80, "Attribute"),
   CROSS_REFERENCE(81, "CrossReference"),
   DATATYPE(82, "Datatype"),
   IMPORT_SUB_TYPE(83, "ImportSubType"),
   INCLUDE(84, "Include"),
   META_MODEL1(85, "MetaModel1"),
   META_MODEL_ELEMENT(86, "MetaModelElement"),
   ORGANIZATION_SUB_TYPE(87, "OrganizationSubType"),
   PACKAGE_SUB_TYPE(88, "PackageSubType"),
   RULE(89, "Rule"),
   RULE_PATH(90, "RulePath"),
   SCOPE_ID_TYPE(91, "ScopeIdType"),
   SMS_PROVIDER_SUB_TYPE(92, "SmsProviderSubType"),
   SUBSCRIPTION_REQUEST_SUB_TYPE(93, "SubscriptionRequestSubType"),
   TEMPLATE(94, "Template"),
   TREE_NODE_TYPE(95, "TreeNodeType"),
   USER_SUB_TYPE(96, "UserSubType"),
   VARIABLE(97, "Variable");

   private final int id;
   private final String name;

   private static final Map<Integer, GreenballMessagesEnum> lookup = new HashMap<Integer, GreenballMessagesEnum>();

   static {
      for (GreenballMessagesEnum enumType : EnumSet.allOf(GreenballMessagesEnum.class)) {
         lookup.put(enumType.getId(), enumType);
      }
   }

   GreenballMessagesEnum(int id, String name) {
      this.id = id;
      this.name = name;
   }

   public GreenballMessagesEnum getId(String name) {
      for (GreenballMessagesEnum e : GreenballMessagesEnum.values()) {
         if (e.getName().equals(name)) {
            return e;
         }
      }

      return null;
   }

   public int getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public static GreenballMessagesEnum toEnum(int id) {
      return lookup.get(id);
   }

   public static GreenballMessagesEnum toEnum(String name) {
      for (GreenballMessagesEnum e : GreenballMessagesEnum.values()) {
         if (e.getName().equals(name)) {
            return e;
         }
      }

      return null;
   }
}