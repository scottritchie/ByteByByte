package com.viacron.utils.bbb.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.viacron.utils.bbb.services.ByteByByteGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalByteByByteParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar name'", "'package'", "'root'", "'date/time format:'", "'Message'", "'{'", "'}'", "'as'", "'list'", "'of'", "'('", "'optional'", "')'", "'enum'", "'SubType'", "'Enum'", "'.'", "'string'", "'byte'", "'char'", "'integer'", "'float'", "'double'", "'short'", "'long'", "'calendar'", "'boolean'", "'XREF'", "'ID'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__11=11;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalByteByByteParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalByteByByteParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalByteByByteParser.tokenNames; }
    public String getGrammarFileName() { return "../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g"; }



     	private ByteByByteGrammarAccess grammarAccess;
     	
        public InternalByteByByteParser(TokenStream input, ByteByByteGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected ByteByByteGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:69:2: (iv_ruleModel= ruleModel EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:77:1: ruleModel returns [EObject current=null] : ( ( (lv_grammarName_0_0= ruleGrammarName ) ) ( (lv_package_1_0= rulePackageDeclaration ) ) ( (lv_rootClass_2_0= ruleRootClass ) ) ( (lv_dateTimeFormat_3_0= ruleDateTimeFormat ) )? ( (lv_messages_4_0= ruleMessage ) )* ( (lv_subTypes_5_0= ruleSubType ) )* ( (lv_penums_6_0= rulePEnum ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_grammarName_0_0 = null;

        EObject lv_package_1_0 = null;

        EObject lv_rootClass_2_0 = null;

        EObject lv_dateTimeFormat_3_0 = null;

        EObject lv_messages_4_0 = null;

        EObject lv_subTypes_5_0 = null;

        EObject lv_penums_6_0 = null;


         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:80:28: ( ( ( (lv_grammarName_0_0= ruleGrammarName ) ) ( (lv_package_1_0= rulePackageDeclaration ) ) ( (lv_rootClass_2_0= ruleRootClass ) ) ( (lv_dateTimeFormat_3_0= ruleDateTimeFormat ) )? ( (lv_messages_4_0= ruleMessage ) )* ( (lv_subTypes_5_0= ruleSubType ) )* ( (lv_penums_6_0= rulePEnum ) )* ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:81:1: ( ( (lv_grammarName_0_0= ruleGrammarName ) ) ( (lv_package_1_0= rulePackageDeclaration ) ) ( (lv_rootClass_2_0= ruleRootClass ) ) ( (lv_dateTimeFormat_3_0= ruleDateTimeFormat ) )? ( (lv_messages_4_0= ruleMessage ) )* ( (lv_subTypes_5_0= ruleSubType ) )* ( (lv_penums_6_0= rulePEnum ) )* )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:81:1: ( ( (lv_grammarName_0_0= ruleGrammarName ) ) ( (lv_package_1_0= rulePackageDeclaration ) ) ( (lv_rootClass_2_0= ruleRootClass ) ) ( (lv_dateTimeFormat_3_0= ruleDateTimeFormat ) )? ( (lv_messages_4_0= ruleMessage ) )* ( (lv_subTypes_5_0= ruleSubType ) )* ( (lv_penums_6_0= rulePEnum ) )* )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:81:2: ( (lv_grammarName_0_0= ruleGrammarName ) ) ( (lv_package_1_0= rulePackageDeclaration ) ) ( (lv_rootClass_2_0= ruleRootClass ) ) ( (lv_dateTimeFormat_3_0= ruleDateTimeFormat ) )? ( (lv_messages_4_0= ruleMessage ) )* ( (lv_subTypes_5_0= ruleSubType ) )* ( (lv_penums_6_0= rulePEnum ) )*
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:81:2: ( (lv_grammarName_0_0= ruleGrammarName ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:82:1: (lv_grammarName_0_0= ruleGrammarName )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:82:1: (lv_grammarName_0_0= ruleGrammarName )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:83:3: lv_grammarName_0_0= ruleGrammarName
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getGrammarNameGrammarNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleGrammarName_in_ruleModel131);
            lv_grammarName_0_0=ruleGrammarName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"grammarName",
                    		lv_grammarName_0_0, 
                    		"GrammarName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:99:2: ( (lv_package_1_0= rulePackageDeclaration ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:100:1: (lv_package_1_0= rulePackageDeclaration )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:100:1: (lv_package_1_0= rulePackageDeclaration )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:101:3: lv_package_1_0= rulePackageDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getPackagePackageDeclarationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_rulePackageDeclaration_in_ruleModel152);
            lv_package_1_0=rulePackageDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"package",
                    		lv_package_1_0, 
                    		"PackageDeclaration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:117:2: ( (lv_rootClass_2_0= ruleRootClass ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:118:1: (lv_rootClass_2_0= ruleRootClass )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:118:1: (lv_rootClass_2_0= ruleRootClass )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:119:3: lv_rootClass_2_0= ruleRootClass
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getRootClassRootClassParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleRootClass_in_ruleModel173);
            lv_rootClass_2_0=ruleRootClass();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"rootClass",
                    		lv_rootClass_2_0, 
                    		"RootClass");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:135:2: ( (lv_dateTimeFormat_3_0= ruleDateTimeFormat ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:136:1: (lv_dateTimeFormat_3_0= ruleDateTimeFormat )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:136:1: (lv_dateTimeFormat_3_0= ruleDateTimeFormat )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:137:3: lv_dateTimeFormat_3_0= ruleDateTimeFormat
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getDateTimeFormatDateTimeFormatParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDateTimeFormat_in_ruleModel194);
                    lv_dateTimeFormat_3_0=ruleDateTimeFormat();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"dateTimeFormat",
                            		lv_dateTimeFormat_3_0, 
                            		"DateTimeFormat");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:153:3: ( (lv_messages_4_0= ruleMessage ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:154:1: (lv_messages_4_0= ruleMessage )
            	    {
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:154:1: (lv_messages_4_0= ruleMessage )
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:155:3: lv_messages_4_0= ruleMessage
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getMessagesMessageParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessage_in_ruleModel216);
            	    lv_messages_4_0=ruleMessage();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"messages",
            	            		lv_messages_4_0, 
            	            		"Message");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:171:3: ( (lv_subTypes_5_0= ruleSubType ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==25) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:172:1: (lv_subTypes_5_0= ruleSubType )
            	    {
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:172:1: (lv_subTypes_5_0= ruleSubType )
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:173:3: lv_subTypes_5_0= ruleSubType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getSubTypesSubTypeParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubType_in_ruleModel238);
            	    lv_subTypes_5_0=ruleSubType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subTypes",
            	            		lv_subTypes_5_0, 
            	            		"SubType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:189:3: ( (lv_penums_6_0= rulePEnum ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==26) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:190:1: (lv_penums_6_0= rulePEnum )
            	    {
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:190:1: (lv_penums_6_0= rulePEnum )
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:191:3: lv_penums_6_0= rulePEnum
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getPenumsPEnumParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePEnum_in_ruleModel260);
            	    lv_penums_6_0=rulePEnum();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"penums",
            	            		lv_penums_6_0, 
            	            		"PEnum");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleGrammarName"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:215:1: entryRuleGrammarName returns [EObject current=null] : iv_ruleGrammarName= ruleGrammarName EOF ;
    public final EObject entryRuleGrammarName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammarName = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:216:2: (iv_ruleGrammarName= ruleGrammarName EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:217:2: iv_ruleGrammarName= ruleGrammarName EOF
            {
             newCompositeNode(grammarAccess.getGrammarNameRule()); 
            pushFollow(FOLLOW_ruleGrammarName_in_entryRuleGrammarName297);
            iv_ruleGrammarName=ruleGrammarName();

            state._fsp--;

             current =iv_ruleGrammarName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammarName307); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGrammarName"


    // $ANTLR start "ruleGrammarName"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:224:1: ruleGrammarName returns [EObject current=null] : (otherlv_0= 'grammar name' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleGrammarName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:227:28: ( (otherlv_0= 'grammar name' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:228:1: (otherlv_0= 'grammar name' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:228:1: (otherlv_0= 'grammar name' ( (lv_name_1_0= RULE_ID ) ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:228:3: otherlv_0= 'grammar name' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleGrammarName344); 

                	newLeafNode(otherlv_0, grammarAccess.getGrammarNameAccess().getGrammarNameKeyword_0());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:232:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:233:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:233:1: (lv_name_1_0= RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:234:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarName361); 

            			newLeafNode(lv_name_1_0, grammarAccess.getGrammarNameAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGrammarNameRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGrammarName"


    // $ANTLR start "entryRulePackageDeclaration"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:258:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:259:2: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:260:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
            {
             newCompositeNode(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration402);
            iv_rulePackageDeclaration=rulePackageDeclaration();

            state._fsp--;

             current =iv_rulePackageDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDeclaration412); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:267:1: rulePackageDeclaration returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:270:28: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:271:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:271:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:271:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_rulePackageDeclaration449); 

                	newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:275:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:276:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:276:1: (lv_name_1_0= ruleQualifiedName )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:277:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_rulePackageDeclaration470);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleRootClass"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:301:1: entryRuleRootClass returns [EObject current=null] : iv_ruleRootClass= ruleRootClass EOF ;
    public final EObject entryRuleRootClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootClass = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:302:2: (iv_ruleRootClass= ruleRootClass EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:303:2: iv_ruleRootClass= ruleRootClass EOF
            {
             newCompositeNode(grammarAccess.getRootClassRule()); 
            pushFollow(FOLLOW_ruleRootClass_in_entryRuleRootClass506);
            iv_ruleRootClass=ruleRootClass();

            state._fsp--;

             current =iv_ruleRootClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRootClass516); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRootClass"


    // $ANTLR start "ruleRootClass"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:310:1: ruleRootClass returns [EObject current=null] : (otherlv_0= 'root' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRootClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:313:28: ( (otherlv_0= 'root' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:314:1: (otherlv_0= 'root' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:314:1: (otherlv_0= 'root' ( (lv_name_1_0= RULE_ID ) ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:314:3: otherlv_0= 'root' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleRootClass553); 

                	newLeafNode(otherlv_0, grammarAccess.getRootClassAccess().getRootKeyword_0());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:318:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:319:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:319:1: (lv_name_1_0= RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:320:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRootClass570); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRootClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRootClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRootClass"


    // $ANTLR start "entryRuleDateTimeFormat"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:344:1: entryRuleDateTimeFormat returns [EObject current=null] : iv_ruleDateTimeFormat= ruleDateTimeFormat EOF ;
    public final EObject entryRuleDateTimeFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateTimeFormat = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:345:2: (iv_ruleDateTimeFormat= ruleDateTimeFormat EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:346:2: iv_ruleDateTimeFormat= ruleDateTimeFormat EOF
            {
             newCompositeNode(grammarAccess.getDateTimeFormatRule()); 
            pushFollow(FOLLOW_ruleDateTimeFormat_in_entryRuleDateTimeFormat611);
            iv_ruleDateTimeFormat=ruleDateTimeFormat();

            state._fsp--;

             current =iv_ruleDateTimeFormat; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateTimeFormat621); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateTimeFormat"


    // $ANTLR start "ruleDateTimeFormat"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:353:1: ruleDateTimeFormat returns [EObject current=null] : (otherlv_0= 'date/time format:' ( (lv_dateTimeFormat_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleDateTimeFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_dateTimeFormat_1_0=null;

         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:356:28: ( (otherlv_0= 'date/time format:' ( (lv_dateTimeFormat_1_0= RULE_STRING ) ) ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:357:1: (otherlv_0= 'date/time format:' ( (lv_dateTimeFormat_1_0= RULE_STRING ) ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:357:1: (otherlv_0= 'date/time format:' ( (lv_dateTimeFormat_1_0= RULE_STRING ) ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:357:3: otherlv_0= 'date/time format:' ( (lv_dateTimeFormat_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleDateTimeFormat658); 

                	newLeafNode(otherlv_0, grammarAccess.getDateTimeFormatAccess().getDateTimeFormatKeyword_0());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:361:1: ( (lv_dateTimeFormat_1_0= RULE_STRING ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:362:1: (lv_dateTimeFormat_1_0= RULE_STRING )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:362:1: (lv_dateTimeFormat_1_0= RULE_STRING )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:363:3: lv_dateTimeFormat_1_0= RULE_STRING
            {
            lv_dateTimeFormat_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDateTimeFormat675); 

            			newLeafNode(lv_dateTimeFormat_1_0, grammarAccess.getDateTimeFormatAccess().getDateTimeFormatSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDateTimeFormatRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateTimeFormat",
                    		lv_dateTimeFormat_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateTimeFormat"


    // $ANTLR start "entryRuleMessage"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:387:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:388:2: (iv_ruleMessage= ruleMessage EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:389:2: iv_ruleMessage= ruleMessage EOF
            {
             newCompositeNode(grammarAccess.getMessageRule()); 
            pushFollow(FOLLOW_ruleMessage_in_entryRuleMessage716);
            iv_ruleMessage=ruleMessage();

            state._fsp--;

             current =iv_ruleMessage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessage726); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessage"


    // $ANTLR start "ruleMessage"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:396:1: ruleMessage returns [EObject current=null] : (otherlv_0= 'Message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAbstractAttribute ) )* ( (lv_enums_4_0= rulePEnumRef ) )* otherlv_5= '}' ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_enums_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:399:28: ( (otherlv_0= 'Message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAbstractAttribute ) )* ( (lv_enums_4_0= rulePEnumRef ) )* otherlv_5= '}' ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:400:1: (otherlv_0= 'Message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAbstractAttribute ) )* ( (lv_enums_4_0= rulePEnumRef ) )* otherlv_5= '}' )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:400:1: (otherlv_0= 'Message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAbstractAttribute ) )* ( (lv_enums_4_0= rulePEnumRef ) )* otherlv_5= '}' )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:400:3: otherlv_0= 'Message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAbstractAttribute ) )* ( (lv_enums_4_0= rulePEnumRef ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleMessage763); 

                	newLeafNode(otherlv_0, grammarAccess.getMessageAccess().getMessageKeyword_0());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:404:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:405:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:405:1: (lv_name_1_0= RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:406:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessage780); 

            			newLeafNode(lv_name_1_0, grammarAccess.getMessageAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleMessage797); 

                	newLeafNode(otherlv_2, grammarAccess.getMessageAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:426:1: ( (lv_attributes_3_0= ruleAbstractAttribute ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==18) ) {
                        int LA5_3 = input.LA(3);

                        if ( (LA5_3==RULE_ID||LA5_3==19||(LA5_3>=28 && LA5_3<=39)) ) {
                            alt5=1;
                        }


                    }


                }


                switch (alt5) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:427:1: (lv_attributes_3_0= ruleAbstractAttribute )
            	    {
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:427:1: (lv_attributes_3_0= ruleAbstractAttribute )
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:428:3: lv_attributes_3_0= ruleAbstractAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMessageAccess().getAttributesAbstractAttributeParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractAttribute_in_ruleMessage818);
            	    lv_attributes_3_0=ruleAbstractAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMessageRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_3_0, 
            	            		"AbstractAttribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:444:3: ( (lv_enums_4_0= rulePEnumRef ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:445:1: (lv_enums_4_0= rulePEnumRef )
            	    {
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:445:1: (lv_enums_4_0= rulePEnumRef )
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:446:3: lv_enums_4_0= rulePEnumRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMessageAccess().getEnumsPEnumRefParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePEnumRef_in_ruleMessage840);
            	    lv_enums_4_0=rulePEnumRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMessageRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"enums",
            	            		lv_enums_4_0, 
            	            		"PEnumRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleMessage853); 

                	newLeafNode(otherlv_5, grammarAccess.getMessageAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessage"


    // $ANTLR start "entryRuleAbstractAttribute"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:474:1: entryRuleAbstractAttribute returns [EObject current=null] : iv_ruleAbstractAttribute= ruleAbstractAttribute EOF ;
    public final EObject entryRuleAbstractAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractAttribute = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:475:2: (iv_ruleAbstractAttribute= ruleAbstractAttribute EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:476:2: iv_ruleAbstractAttribute= ruleAbstractAttribute EOF
            {
             newCompositeNode(grammarAccess.getAbstractAttributeRule()); 
            pushFollow(FOLLOW_ruleAbstractAttribute_in_entryRuleAbstractAttribute889);
            iv_ruleAbstractAttribute=ruleAbstractAttribute();

            state._fsp--;

             current =iv_ruleAbstractAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractAttribute899); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractAttribute"


    // $ANTLR start "ruleAbstractAttribute"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:483:1: ruleAbstractAttribute returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_SubTypeRef_1= ruleSubTypeRef ) ;
    public final EObject ruleAbstractAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_SubTypeRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:486:28: ( (this_Attribute_0= ruleAttribute | this_SubTypeRef_1= ruleSubTypeRef ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:487:1: (this_Attribute_0= ruleAttribute | this_SubTypeRef_1= ruleSubTypeRef )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:487:1: (this_Attribute_0= ruleAttribute | this_SubTypeRef_1= ruleSubTypeRef )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==18) ) {
                    switch ( input.LA(3) ) {
                    case 19:
                        {
                        int LA7_3 = input.LA(4);

                        if ( (LA7_3==20) ) {
                            int LA7_6 = input.LA(5);

                            if ( (LA7_6==RULE_ID) ) {
                                alt7=2;
                            }
                            else if ( ((LA7_6>=28 && LA7_6<=39)) ) {
                                alt7=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 7, 6, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 3, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                        {
                        alt7=1;
                        }
                        break;
                    case RULE_ID:
                        {
                        alt7=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:488:5: this_Attribute_0= ruleAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractAttributeAccess().getAttributeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAttribute_in_ruleAbstractAttribute946);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;

                     
                            current = this_Attribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:498:5: this_SubTypeRef_1= ruleSubTypeRef
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractAttributeAccess().getSubTypeRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSubTypeRef_in_ruleAbstractAttribute973);
                    this_SubTypeRef_1=ruleSubTypeRef();

                    state._fsp--;

                     
                            current = this_SubTypeRef_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractAttribute"


    // $ANTLR start "entryRuleAttribute"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:514:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:515:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:516:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1008);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1018); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:523:1: ruleAttribute returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' ( (lv_listOf_2_0= ruleListOf ) )? ( (lv_attributeType_3_0= ruleAttributeType ) ) ( (lv_optional_4_0= ruleOptional ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_listOf_2_0 = null;

        Enumerator lv_attributeType_3_0 = null;

        EObject lv_optional_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:526:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' ( (lv_listOf_2_0= ruleListOf ) )? ( (lv_attributeType_3_0= ruleAttributeType ) ) ( (lv_optional_4_0= ruleOptional ) )? ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:527:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' ( (lv_listOf_2_0= ruleListOf ) )? ( (lv_attributeType_3_0= ruleAttributeType ) ) ( (lv_optional_4_0= ruleOptional ) )? )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:527:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' ( (lv_listOf_2_0= ruleListOf ) )? ( (lv_attributeType_3_0= ruleAttributeType ) ) ( (lv_optional_4_0= ruleOptional ) )? )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:527:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' ( (lv_listOf_2_0= ruleListOf ) )? ( (lv_attributeType_3_0= ruleAttributeType ) ) ( (lv_optional_4_0= ruleOptional ) )?
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:527:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:528:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:528:1: (lv_name_0_0= RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:529:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute1060); 

            			newLeafNode(lv_name_0_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleAttribute1077); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getAsKeyword_1());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:549:1: ( (lv_listOf_2_0= ruleListOf ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:550:1: (lv_listOf_2_0= ruleListOf )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:550:1: (lv_listOf_2_0= ruleListOf )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:551:3: lv_listOf_2_0= ruleListOf
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getListOfListOfParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleListOf_in_ruleAttribute1098);
                    lv_listOf_2_0=ruleListOf();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"listOf",
                            		lv_listOf_2_0, 
                            		"ListOf");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:567:3: ( (lv_attributeType_3_0= ruleAttributeType ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:568:1: (lv_attributeType_3_0= ruleAttributeType )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:568:1: (lv_attributeType_3_0= ruleAttributeType )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:569:3: lv_attributeType_3_0= ruleAttributeType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeAccess().getAttributeTypeAttributeTypeEnumRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleAttributeType_in_ruleAttribute1120);
            lv_attributeType_3_0=ruleAttributeType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"attributeType",
                    		lv_attributeType_3_0, 
                    		"AttributeType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:585:2: ( (lv_optional_4_0= ruleOptional ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:586:1: (lv_optional_4_0= ruleOptional )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:586:1: (lv_optional_4_0= ruleOptional )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:587:3: lv_optional_4_0= ruleOptional
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getOptionalOptionalParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleOptional_in_ruleAttribute1141);
                    lv_optional_4_0=ruleOptional();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"optional",
                            		lv_optional_4_0, 
                            		"Optional");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleListOf"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:611:1: entryRuleListOf returns [EObject current=null] : iv_ruleListOf= ruleListOf EOF ;
    public final EObject entryRuleListOf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOf = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:612:2: (iv_ruleListOf= ruleListOf EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:613:2: iv_ruleListOf= ruleListOf EOF
            {
             newCompositeNode(grammarAccess.getListOfRule()); 
            pushFollow(FOLLOW_ruleListOf_in_entryRuleListOf1178);
            iv_ruleListOf=ruleListOf();

            state._fsp--;

             current =iv_ruleListOf; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOf1188); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListOf"


    // $ANTLR start "ruleListOf"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:620:1: ruleListOf returns [EObject current=null] : ( ( (lv_listOf_0_0= 'list' ) ) otherlv_1= 'of' ) ;
    public final EObject ruleListOf() throws RecognitionException {
        EObject current = null;

        Token lv_listOf_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:623:28: ( ( ( (lv_listOf_0_0= 'list' ) ) otherlv_1= 'of' ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:624:1: ( ( (lv_listOf_0_0= 'list' ) ) otherlv_1= 'of' )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:624:1: ( ( (lv_listOf_0_0= 'list' ) ) otherlv_1= 'of' )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:624:2: ( (lv_listOf_0_0= 'list' ) ) otherlv_1= 'of'
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:624:2: ( (lv_listOf_0_0= 'list' ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:625:1: (lv_listOf_0_0= 'list' )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:625:1: (lv_listOf_0_0= 'list' )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:626:3: lv_listOf_0_0= 'list'
            {
            lv_listOf_0_0=(Token)match(input,19,FOLLOW_19_in_ruleListOf1231); 

                    newLeafNode(lv_listOf_0_0, grammarAccess.getListOfAccess().getListOfListKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getListOfRule());
            	        }
                   		setWithLastConsumed(current, "listOf", lv_listOf_0_0, "list");
            	    

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleListOf1256); 

                	newLeafNode(otherlv_1, grammarAccess.getListOfAccess().getOfKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListOf"


    // $ANTLR start "entryRuleOptional"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:651:1: entryRuleOptional returns [EObject current=null] : iv_ruleOptional= ruleOptional EOF ;
    public final EObject entryRuleOptional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptional = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:652:2: (iv_ruleOptional= ruleOptional EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:653:2: iv_ruleOptional= ruleOptional EOF
            {
             newCompositeNode(grammarAccess.getOptionalRule()); 
            pushFollow(FOLLOW_ruleOptional_in_entryRuleOptional1292);
            iv_ruleOptional=ruleOptional();

            state._fsp--;

             current =iv_ruleOptional; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptional1302); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptional"


    // $ANTLR start "ruleOptional"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:660:1: ruleOptional returns [EObject current=null] : ( ( (lv_optional_0_0= '(' ) ) otherlv_1= 'optional' otherlv_2= ')' ) ;
    public final EObject ruleOptional() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:663:28: ( ( ( (lv_optional_0_0= '(' ) ) otherlv_1= 'optional' otherlv_2= ')' ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:664:1: ( ( (lv_optional_0_0= '(' ) ) otherlv_1= 'optional' otherlv_2= ')' )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:664:1: ( ( (lv_optional_0_0= '(' ) ) otherlv_1= 'optional' otherlv_2= ')' )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:664:2: ( (lv_optional_0_0= '(' ) ) otherlv_1= 'optional' otherlv_2= ')'
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:664:2: ( (lv_optional_0_0= '(' ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:665:1: (lv_optional_0_0= '(' )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:665:1: (lv_optional_0_0= '(' )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:666:3: lv_optional_0_0= '('
            {
            lv_optional_0_0=(Token)match(input,21,FOLLOW_21_in_ruleOptional1345); 

                    newLeafNode(lv_optional_0_0, grammarAccess.getOptionalAccess().getOptionalLeftParenthesisKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalRule());
            	        }
                   		setWithLastConsumed(current, "optional", lv_optional_0_0, "(");
            	    

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleOptional1370); 

                	newLeafNode(otherlv_1, grammarAccess.getOptionalAccess().getOptionalKeyword_1());
                
            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleOptional1382); 

                	newLeafNode(otherlv_2, grammarAccess.getOptionalAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptional"


    // $ANTLR start "entryRuleSubTypeRef"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:695:1: entryRuleSubTypeRef returns [EObject current=null] : iv_ruleSubTypeRef= ruleSubTypeRef EOF ;
    public final EObject entryRuleSubTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubTypeRef = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:696:2: (iv_ruleSubTypeRef= ruleSubTypeRef EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:697:2: iv_ruleSubTypeRef= ruleSubTypeRef EOF
            {
             newCompositeNode(grammarAccess.getSubTypeRefRule()); 
            pushFollow(FOLLOW_ruleSubTypeRef_in_entryRuleSubTypeRef1418);
            iv_ruleSubTypeRef=ruleSubTypeRef();

            state._fsp--;

             current =iv_ruleSubTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubTypeRef1428); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubTypeRef"


    // $ANTLR start "ruleSubTypeRef"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:704:1: ruleSubTypeRef returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' ( (lv_listOf_2_0= ruleListOf ) )? ( (otherlv_3= RULE_ID ) ) ( (lv_optional_4_0= ruleOptional ) )? ) ;
    public final EObject ruleSubTypeRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_listOf_2_0 = null;

        EObject lv_optional_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:707:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' ( (lv_listOf_2_0= ruleListOf ) )? ( (otherlv_3= RULE_ID ) ) ( (lv_optional_4_0= ruleOptional ) )? ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:708:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' ( (lv_listOf_2_0= ruleListOf ) )? ( (otherlv_3= RULE_ID ) ) ( (lv_optional_4_0= ruleOptional ) )? )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:708:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' ( (lv_listOf_2_0= ruleListOf ) )? ( (otherlv_3= RULE_ID ) ) ( (lv_optional_4_0= ruleOptional ) )? )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:708:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' ( (lv_listOf_2_0= ruleListOf ) )? ( (otherlv_3= RULE_ID ) ) ( (lv_optional_4_0= ruleOptional ) )?
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:708:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:709:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:709:1: (lv_name_0_0= RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:710:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubTypeRef1470); 

            			newLeafNode(lv_name_0_0, grammarAccess.getSubTypeRefAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubTypeRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleSubTypeRef1487); 

                	newLeafNode(otherlv_1, grammarAccess.getSubTypeRefAccess().getAsKeyword_1());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:730:1: ( (lv_listOf_2_0= ruleListOf ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:731:1: (lv_listOf_2_0= ruleListOf )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:731:1: (lv_listOf_2_0= ruleListOf )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:732:3: lv_listOf_2_0= ruleListOf
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubTypeRefAccess().getListOfListOfParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleListOf_in_ruleSubTypeRef1508);
                    lv_listOf_2_0=ruleListOf();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubTypeRefRule());
                    	        }
                           		set(
                           			current, 
                           			"listOf",
                            		lv_listOf_2_0, 
                            		"ListOf");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:748:3: ( (otherlv_3= RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:749:1: (otherlv_3= RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:749:1: (otherlv_3= RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:750:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubTypeRefRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubTypeRef1529); 

            		newLeafNode(otherlv_3, grammarAccess.getSubTypeRefAccess().getSubTypeSubTypeCrossReference_3_0()); 
            	

            }


            }

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:761:2: ( (lv_optional_4_0= ruleOptional ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:762:1: (lv_optional_4_0= ruleOptional )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:762:1: (lv_optional_4_0= ruleOptional )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:763:3: lv_optional_4_0= ruleOptional
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubTypeRefAccess().getOptionalOptionalParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleOptional_in_ruleSubTypeRef1550);
                    lv_optional_4_0=ruleOptional();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubTypeRefRule());
                    	        }
                           		set(
                           			current, 
                           			"optional",
                            		lv_optional_4_0, 
                            		"Optional");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubTypeRef"


    // $ANTLR start "entryRulePEnumRef"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:787:1: entryRulePEnumRef returns [EObject current=null] : iv_rulePEnumRef= rulePEnumRef EOF ;
    public final EObject entryRulePEnumRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePEnumRef = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:788:2: (iv_rulePEnumRef= rulePEnumRef EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:789:2: iv_rulePEnumRef= rulePEnumRef EOF
            {
             newCompositeNode(grammarAccess.getPEnumRefRule()); 
            pushFollow(FOLLOW_rulePEnumRef_in_entryRulePEnumRef1587);
            iv_rulePEnumRef=rulePEnumRef();

            state._fsp--;

             current =iv_rulePEnumRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePEnumRef1597); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePEnumRef"


    // $ANTLR start "rulePEnumRef"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:796:1: rulePEnumRef returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' otherlv_2= 'enum' ( (otherlv_3= RULE_ID ) ) ( (lv_optional_4_0= ruleOptional ) )? ) ;
    public final EObject rulePEnumRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_optional_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:799:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' otherlv_2= 'enum' ( (otherlv_3= RULE_ID ) ) ( (lv_optional_4_0= ruleOptional ) )? ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:800:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' otherlv_2= 'enum' ( (otherlv_3= RULE_ID ) ) ( (lv_optional_4_0= ruleOptional ) )? )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:800:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' otherlv_2= 'enum' ( (otherlv_3= RULE_ID ) ) ( (lv_optional_4_0= ruleOptional ) )? )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:800:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'as' otherlv_2= 'enum' ( (otherlv_3= RULE_ID ) ) ( (lv_optional_4_0= ruleOptional ) )?
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:800:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:801:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:801:1: (lv_name_0_0= RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:802:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePEnumRef1639); 

            			newLeafNode(lv_name_0_0, grammarAccess.getPEnumRefAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPEnumRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_rulePEnumRef1656); 

                	newLeafNode(otherlv_1, grammarAccess.getPEnumRefAccess().getAsKeyword_1());
                
            otherlv_2=(Token)match(input,24,FOLLOW_24_in_rulePEnumRef1668); 

                	newLeafNode(otherlv_2, grammarAccess.getPEnumRefAccess().getEnumKeyword_2());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:826:1: ( (otherlv_3= RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:827:1: (otherlv_3= RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:827:1: (otherlv_3= RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:828:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPEnumRefRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePEnumRef1688); 

            		newLeafNode(otherlv_3, grammarAccess.getPEnumRefAccess().getPenumPEnumCrossReference_3_0()); 
            	

            }


            }

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:839:2: ( (lv_optional_4_0= ruleOptional ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==21) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:840:1: (lv_optional_4_0= ruleOptional )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:840:1: (lv_optional_4_0= ruleOptional )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:841:3: lv_optional_4_0= ruleOptional
                    {
                     
                    	        newCompositeNode(grammarAccess.getPEnumRefAccess().getOptionalOptionalParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleOptional_in_rulePEnumRef1709);
                    lv_optional_4_0=ruleOptional();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPEnumRefRule());
                    	        }
                           		set(
                           			current, 
                           			"optional",
                            		lv_optional_4_0, 
                            		"Optional");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePEnumRef"


    // $ANTLR start "entryRuleSubType"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:865:1: entryRuleSubType returns [EObject current=null] : iv_ruleSubType= ruleSubType EOF ;
    public final EObject entryRuleSubType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubType = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:866:2: (iv_ruleSubType= ruleSubType EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:867:2: iv_ruleSubType= ruleSubType EOF
            {
             newCompositeNode(grammarAccess.getSubTypeRule()); 
            pushFollow(FOLLOW_ruleSubType_in_entryRuleSubType1746);
            iv_ruleSubType=ruleSubType();

            state._fsp--;

             current =iv_ruleSubType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubType1756); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubType"


    // $ANTLR start "ruleSubType"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:874:1: ruleSubType returns [EObject current=null] : (otherlv_0= 'SubType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAbstractAttribute ) )* ( (lv_enums_4_0= rulePEnumRef ) )* otherlv_5= '}' ) ;
    public final EObject ruleSubType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_enums_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:877:28: ( (otherlv_0= 'SubType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAbstractAttribute ) )* ( (lv_enums_4_0= rulePEnumRef ) )* otherlv_5= '}' ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:878:1: (otherlv_0= 'SubType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAbstractAttribute ) )* ( (lv_enums_4_0= rulePEnumRef ) )* otherlv_5= '}' )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:878:1: (otherlv_0= 'SubType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAbstractAttribute ) )* ( (lv_enums_4_0= rulePEnumRef ) )* otherlv_5= '}' )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:878:3: otherlv_0= 'SubType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAbstractAttribute ) )* ( (lv_enums_4_0= rulePEnumRef ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleSubType1793); 

                	newLeafNode(otherlv_0, grammarAccess.getSubTypeAccess().getSubTypeKeyword_0());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:882:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:883:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:883:1: (lv_name_1_0= RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:884:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubType1810); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSubTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleSubType1827); 

                	newLeafNode(otherlv_2, grammarAccess.getSubTypeAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:904:1: ( (lv_attributes_3_0= ruleAbstractAttribute ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1==18) ) {
                        int LA13_3 = input.LA(3);

                        if ( (LA13_3==RULE_ID||LA13_3==19||(LA13_3>=28 && LA13_3<=39)) ) {
                            alt13=1;
                        }


                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:905:1: (lv_attributes_3_0= ruleAbstractAttribute )
            	    {
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:905:1: (lv_attributes_3_0= ruleAbstractAttribute )
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:906:3: lv_attributes_3_0= ruleAbstractAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubTypeAccess().getAttributesAbstractAttributeParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractAttribute_in_ruleSubType1848);
            	    lv_attributes_3_0=ruleAbstractAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubTypeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_3_0, 
            	            		"AbstractAttribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:922:3: ( (lv_enums_4_0= rulePEnumRef ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:923:1: (lv_enums_4_0= rulePEnumRef )
            	    {
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:923:1: (lv_enums_4_0= rulePEnumRef )
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:924:3: lv_enums_4_0= rulePEnumRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubTypeAccess().getEnumsPEnumRefParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePEnumRef_in_ruleSubType1870);
            	    lv_enums_4_0=rulePEnumRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubTypeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"enums",
            	            		lv_enums_4_0, 
            	            		"PEnumRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleSubType1883); 

                	newLeafNode(otherlv_5, grammarAccess.getSubTypeAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubType"


    // $ANTLR start "entryRulePEnum"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:952:1: entryRulePEnum returns [EObject current=null] : iv_rulePEnum= rulePEnum EOF ;
    public final EObject entryRulePEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePEnum = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:953:2: (iv_rulePEnum= rulePEnum EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:954:2: iv_rulePEnum= rulePEnum EOF
            {
             newCompositeNode(grammarAccess.getPEnumRule()); 
            pushFollow(FOLLOW_rulePEnum_in_entryRulePEnum1919);
            iv_rulePEnum=rulePEnum();

            state._fsp--;

             current =iv_rulePEnum; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePEnum1929); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePEnum"


    // $ANTLR start "rulePEnum"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:961:1: rulePEnum returns [EObject current=null] : (otherlv_0= 'Enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= rulePEnumElement ) )* otherlv_4= '}' ) ;
    public final EObject rulePEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:964:28: ( (otherlv_0= 'Enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= rulePEnumElement ) )* otherlv_4= '}' ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:965:1: (otherlv_0= 'Enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= rulePEnumElement ) )* otherlv_4= '}' )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:965:1: (otherlv_0= 'Enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= rulePEnumElement ) )* otherlv_4= '}' )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:965:3: otherlv_0= 'Enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= rulePEnumElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_rulePEnum1966); 

                	newLeafNode(otherlv_0, grammarAccess.getPEnumAccess().getEnumKeyword_0());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:969:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:970:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:970:1: (lv_name_1_0= RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:971:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePEnum1983); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPEnumAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPEnumRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_rulePEnum2000); 

                	newLeafNode(otherlv_2, grammarAccess.getPEnumAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:991:1: ( (lv_elements_3_0= rulePEnumElement ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:992:1: (lv_elements_3_0= rulePEnumElement )
            	    {
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:992:1: (lv_elements_3_0= rulePEnumElement )
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:993:3: lv_elements_3_0= rulePEnumElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPEnumAccess().getElementsPEnumElementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePEnumElement_in_rulePEnum2021);
            	    lv_elements_3_0=rulePEnumElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPEnumRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_3_0, 
            	            		"PEnumElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_rulePEnum2034); 

                	newLeafNode(otherlv_4, grammarAccess.getPEnumAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePEnum"


    // $ANTLR start "entryRulePEnumElement"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1021:1: entryRulePEnumElement returns [EObject current=null] : iv_rulePEnumElement= rulePEnumElement EOF ;
    public final EObject entryRulePEnumElement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePEnumElement = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1022:2: (iv_rulePEnumElement= rulePEnumElement EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1023:2: iv_rulePEnumElement= rulePEnumElement EOF
            {
             newCompositeNode(grammarAccess.getPEnumElementRule()); 
            pushFollow(FOLLOW_rulePEnumElement_in_entryRulePEnumElement2070);
            iv_rulePEnumElement=rulePEnumElement();

            state._fsp--;

             current =iv_rulePEnumElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePEnumElement2080); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePEnumElement"


    // $ANTLR start "rulePEnumElement"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1030:1: rulePEnumElement returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject rulePEnumElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1033:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1034:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1034:1: ( (lv_name_0_0= RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1035:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1035:1: (lv_name_0_0= RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1036:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePEnumElement2121); 

            			newLeafNode(lv_name_0_0, grammarAccess.getPEnumElementAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPEnumElementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePEnumElement"


    // $ANTLR start "entryRuleQualifiedName"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1060:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1061:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1062:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2162);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2173); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1069:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1072:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1073:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1073:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1073:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2213); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1080:1: (kw= '.' this_ID_2= RULE_ID )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==27) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1081:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,27,FOLLOW_27_in_ruleQualifiedName2232); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2247); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "ruleAttributeType"
    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1101:1: ruleAttributeType returns [Enumerator current=null] : ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'byte' ) | (enumLiteral_2= 'char' ) | (enumLiteral_3= 'integer' ) | (enumLiteral_4= 'float' ) | (enumLiteral_5= 'double' ) | (enumLiteral_6= 'short' ) | (enumLiteral_7= 'long' ) | (enumLiteral_8= 'calendar' ) | (enumLiteral_9= 'boolean' ) | (enumLiteral_10= 'XREF' ) | (enumLiteral_11= 'ID' ) ) ;
    public final Enumerator ruleAttributeType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;

         enterRule(); 
        try {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1103:28: ( ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'byte' ) | (enumLiteral_2= 'char' ) | (enumLiteral_3= 'integer' ) | (enumLiteral_4= 'float' ) | (enumLiteral_5= 'double' ) | (enumLiteral_6= 'short' ) | (enumLiteral_7= 'long' ) | (enumLiteral_8= 'calendar' ) | (enumLiteral_9= 'boolean' ) | (enumLiteral_10= 'XREF' ) | (enumLiteral_11= 'ID' ) ) )
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1104:1: ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'byte' ) | (enumLiteral_2= 'char' ) | (enumLiteral_3= 'integer' ) | (enumLiteral_4= 'float' ) | (enumLiteral_5= 'double' ) | (enumLiteral_6= 'short' ) | (enumLiteral_7= 'long' ) | (enumLiteral_8= 'calendar' ) | (enumLiteral_9= 'boolean' ) | (enumLiteral_10= 'XREF' ) | (enumLiteral_11= 'ID' ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1104:1: ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'byte' ) | (enumLiteral_2= 'char' ) | (enumLiteral_3= 'integer' ) | (enumLiteral_4= 'float' ) | (enumLiteral_5= 'double' ) | (enumLiteral_6= 'short' ) | (enumLiteral_7= 'long' ) | (enumLiteral_8= 'calendar' ) | (enumLiteral_9= 'boolean' ) | (enumLiteral_10= 'XREF' ) | (enumLiteral_11= 'ID' ) )
            int alt17=12;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt17=1;
                }
                break;
            case 29:
                {
                alt17=2;
                }
                break;
            case 30:
                {
                alt17=3;
                }
                break;
            case 31:
                {
                alt17=4;
                }
                break;
            case 32:
                {
                alt17=5;
                }
                break;
            case 33:
                {
                alt17=6;
                }
                break;
            case 34:
                {
                alt17=7;
                }
                break;
            case 35:
                {
                alt17=8;
                }
                break;
            case 36:
                {
                alt17=9;
                }
                break;
            case 37:
                {
                alt17=10;
                }
                break;
            case 38:
                {
                alt17=11;
                }
                break;
            case 39:
                {
                alt17=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1104:2: (enumLiteral_0= 'string' )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1104:2: (enumLiteral_0= 'string' )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1104:4: enumLiteral_0= 'string'
                    {
                    enumLiteral_0=(Token)match(input,28,FOLLOW_28_in_ruleAttributeType2308); 

                            current = grammarAccess.getAttributeTypeAccess().getSTRINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getAttributeTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1110:6: (enumLiteral_1= 'byte' )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1110:6: (enumLiteral_1= 'byte' )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1110:8: enumLiteral_1= 'byte'
                    {
                    enumLiteral_1=(Token)match(input,29,FOLLOW_29_in_ruleAttributeType2325); 

                            current = grammarAccess.getAttributeTypeAccess().getBYTEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getAttributeTypeAccess().getBYTEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1116:6: (enumLiteral_2= 'char' )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1116:6: (enumLiteral_2= 'char' )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1116:8: enumLiteral_2= 'char'
                    {
                    enumLiteral_2=(Token)match(input,30,FOLLOW_30_in_ruleAttributeType2342); 

                            current = grammarAccess.getAttributeTypeAccess().getCHAREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getAttributeTypeAccess().getCHAREnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1122:6: (enumLiteral_3= 'integer' )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1122:6: (enumLiteral_3= 'integer' )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1122:8: enumLiteral_3= 'integer'
                    {
                    enumLiteral_3=(Token)match(input,31,FOLLOW_31_in_ruleAttributeType2359); 

                            current = grammarAccess.getAttributeTypeAccess().getINTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getAttributeTypeAccess().getINTEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1128:6: (enumLiteral_4= 'float' )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1128:6: (enumLiteral_4= 'float' )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1128:8: enumLiteral_4= 'float'
                    {
                    enumLiteral_4=(Token)match(input,32,FOLLOW_32_in_ruleAttributeType2376); 

                            current = grammarAccess.getAttributeTypeAccess().getFLOATEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getAttributeTypeAccess().getFLOATEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1134:6: (enumLiteral_5= 'double' )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1134:6: (enumLiteral_5= 'double' )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1134:8: enumLiteral_5= 'double'
                    {
                    enumLiteral_5=(Token)match(input,33,FOLLOW_33_in_ruleAttributeType2393); 

                            current = grammarAccess.getAttributeTypeAccess().getDOUBLEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getAttributeTypeAccess().getDOUBLEEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1140:6: (enumLiteral_6= 'short' )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1140:6: (enumLiteral_6= 'short' )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1140:8: enumLiteral_6= 'short'
                    {
                    enumLiteral_6=(Token)match(input,34,FOLLOW_34_in_ruleAttributeType2410); 

                            current = grammarAccess.getAttributeTypeAccess().getSHORTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getAttributeTypeAccess().getSHORTEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1146:6: (enumLiteral_7= 'long' )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1146:6: (enumLiteral_7= 'long' )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1146:8: enumLiteral_7= 'long'
                    {
                    enumLiteral_7=(Token)match(input,35,FOLLOW_35_in_ruleAttributeType2427); 

                            current = grammarAccess.getAttributeTypeAccess().getLONGEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getAttributeTypeAccess().getLONGEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1152:6: (enumLiteral_8= 'calendar' )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1152:6: (enumLiteral_8= 'calendar' )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1152:8: enumLiteral_8= 'calendar'
                    {
                    enumLiteral_8=(Token)match(input,36,FOLLOW_36_in_ruleAttributeType2444); 

                            current = grammarAccess.getAttributeTypeAccess().getCALENDAREnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getAttributeTypeAccess().getCALENDAREnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1158:6: (enumLiteral_9= 'boolean' )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1158:6: (enumLiteral_9= 'boolean' )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1158:8: enumLiteral_9= 'boolean'
                    {
                    enumLiteral_9=(Token)match(input,37,FOLLOW_37_in_ruleAttributeType2461); 

                            current = grammarAccess.getAttributeTypeAccess().getBOOLEANEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getAttributeTypeAccess().getBOOLEANEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1164:6: (enumLiteral_10= 'XREF' )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1164:6: (enumLiteral_10= 'XREF' )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1164:8: enumLiteral_10= 'XREF'
                    {
                    enumLiteral_10=(Token)match(input,38,FOLLOW_38_in_ruleAttributeType2478); 

                            current = grammarAccess.getAttributeTypeAccess().getXREFEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getAttributeTypeAccess().getXREFEnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1170:6: (enumLiteral_11= 'ID' )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1170:6: (enumLiteral_11= 'ID' )
                    // ../com.viacron.utils.bbb.ByteByByte/src-gen/com/viacron/utils/bbb/parser/antlr/internal/InternalByteByByte.g:1170:8: enumLiteral_11= 'ID'
                    {
                    enumLiteral_11=(Token)match(input,39,FOLLOW_39_in_ruleAttributeType2495); 

                            current = grammarAccess.getAttributeTypeAccess().getIDEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_11, grammarAccess.getAttributeTypeAccess().getIDEnumLiteralDeclaration_11()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeType"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGrammarName_in_ruleModel131 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rulePackageDeclaration_in_ruleModel152 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleRootClass_in_ruleModel173 = new BitSet(new long[]{0x000000000600C002L});
    public static final BitSet FOLLOW_ruleDateTimeFormat_in_ruleModel194 = new BitSet(new long[]{0x0000000006008002L});
    public static final BitSet FOLLOW_ruleMessage_in_ruleModel216 = new BitSet(new long[]{0x0000000006008002L});
    public static final BitSet FOLLOW_ruleSubType_in_ruleModel238 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_rulePEnum_in_ruleModel260 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleGrammarName_in_entryRuleGrammarName297 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammarName307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGrammarName344 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarName361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration402 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDeclaration412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePackageDeclaration449 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackageDeclaration470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRootClass_in_entryRuleRootClass506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRootClass516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleRootClass553 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRootClass570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeFormat_in_entryRuleDateTimeFormat611 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateTimeFormat621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleDateTimeFormat658 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDateTimeFormat675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessage_in_entryRuleMessage716 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessage726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleMessage763 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessage780 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleMessage797 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleAbstractAttribute_in_ruleMessage818 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_rulePEnumRef_in_ruleMessage840 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_ruleMessage853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAttribute_in_entryRuleAbstractAttribute889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractAttribute899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleAbstractAttribute946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubTypeRef_in_ruleAbstractAttribute973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1008 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1060 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAttribute1077 = new BitSet(new long[]{0x000000FFF0080000L});
    public static final BitSet FOLLOW_ruleListOf_in_ruleAttribute1098 = new BitSet(new long[]{0x000000FFF0080000L});
    public static final BitSet FOLLOW_ruleAttributeType_in_ruleAttribute1120 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOptional_in_ruleAttribute1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOf_in_entryRuleListOf1178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOf1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleListOf1231 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleListOf1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptional_in_entryRuleOptional1292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptional1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOptional1345 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleOptional1370 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleOptional1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubTypeRef_in_entryRuleSubTypeRef1418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubTypeRef1428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubTypeRef1470 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSubTypeRef1487 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ruleListOf_in_ruleSubTypeRef1508 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubTypeRef1529 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOptional_in_ruleSubTypeRef1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePEnumRef_in_entryRulePEnumRef1587 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePEnumRef1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePEnumRef1639 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePEnumRef1656 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePEnumRef1668 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePEnumRef1688 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOptional_in_rulePEnumRef1709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubType_in_entryRuleSubType1746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubType1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleSubType1793 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubType1810 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSubType1827 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleAbstractAttribute_in_ruleSubType1848 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_rulePEnumRef_in_ruleSubType1870 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_ruleSubType1883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePEnum_in_entryRulePEnum1919 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePEnum1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulePEnum1966 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePEnum1983 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulePEnum2000 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_rulePEnumElement_in_rulePEnum2021 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_rulePEnum2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePEnumElement_in_entryRulePEnumElement2070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePEnumElement2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePEnumElement2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2213 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleQualifiedName2232 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2247 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_28_in_ruleAttributeType2308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAttributeType2325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleAttributeType2342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAttributeType2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAttributeType2376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleAttributeType2393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleAttributeType2410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleAttributeType2427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAttributeType2444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleAttributeType2461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleAttributeType2478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleAttributeType2495 = new BitSet(new long[]{0x0000000000000002L});

}