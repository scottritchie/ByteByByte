package com.viacron.utils.bbb.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import com.viacron.utils.bbb.services.ByteByByteGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalByteByByteParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'string'", "'byte'", "'char'", "'integer'", "'float'", "'double'", "'short'", "'long'", "'calendar'", "'boolean'", "'XREF'", "'ID'", "'grammar name'", "'package'", "'root'", "'date/time format:'", "'Message'", "'{'", "'}'", "'as'", "'of'", "'optional'", "')'", "'enum'", "'SubType'", "'Enum'", "'.'", "'list'", "'('"
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
    public String getGrammarFileName() { return "../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g"; }


     
     	private ByteByByteGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ByteByByteGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleModel"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:61:1: ( ruleModel EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:76:1: ( rule__Model__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:76:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleGrammarName"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:88:1: entryRuleGrammarName : ruleGrammarName EOF ;
    public final void entryRuleGrammarName() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:89:1: ( ruleGrammarName EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:90:1: ruleGrammarName EOF
            {
             before(grammarAccess.getGrammarNameRule()); 
            pushFollow(FOLLOW_ruleGrammarName_in_entryRuleGrammarName121);
            ruleGrammarName();

            state._fsp--;

             after(grammarAccess.getGrammarNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammarName128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGrammarName"


    // $ANTLR start "ruleGrammarName"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:97:1: ruleGrammarName : ( ( rule__GrammarName__Group__0 ) ) ;
    public final void ruleGrammarName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:101:2: ( ( ( rule__GrammarName__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:102:1: ( ( rule__GrammarName__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:102:1: ( ( rule__GrammarName__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:103:1: ( rule__GrammarName__Group__0 )
            {
             before(grammarAccess.getGrammarNameAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:104:1: ( rule__GrammarName__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:104:2: rule__GrammarName__Group__0
            {
            pushFollow(FOLLOW_rule__GrammarName__Group__0_in_ruleGrammarName154);
            rule__GrammarName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGrammarNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGrammarName"


    // $ANTLR start "entryRulePackageDeclaration"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:116:1: entryRulePackageDeclaration : rulePackageDeclaration EOF ;
    public final void entryRulePackageDeclaration() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:117:1: ( rulePackageDeclaration EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:118:1: rulePackageDeclaration EOF
            {
             before(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration181);
            rulePackageDeclaration();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDeclaration188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:125:1: rulePackageDeclaration : ( ( rule__PackageDeclaration__Group__0 ) ) ;
    public final void rulePackageDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:129:2: ( ( ( rule__PackageDeclaration__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:130:1: ( ( rule__PackageDeclaration__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:130:1: ( ( rule__PackageDeclaration__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:131:1: ( rule__PackageDeclaration__Group__0 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:132:1: ( rule__PackageDeclaration__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:132:2: rule__PackageDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__0_in_rulePackageDeclaration214);
            rule__PackageDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleRootClass"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:144:1: entryRuleRootClass : ruleRootClass EOF ;
    public final void entryRuleRootClass() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:145:1: ( ruleRootClass EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:146:1: ruleRootClass EOF
            {
             before(grammarAccess.getRootClassRule()); 
            pushFollow(FOLLOW_ruleRootClass_in_entryRuleRootClass241);
            ruleRootClass();

            state._fsp--;

             after(grammarAccess.getRootClassRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRootClass248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRootClass"


    // $ANTLR start "ruleRootClass"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:153:1: ruleRootClass : ( ( rule__RootClass__Group__0 ) ) ;
    public final void ruleRootClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:157:2: ( ( ( rule__RootClass__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:158:1: ( ( rule__RootClass__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:158:1: ( ( rule__RootClass__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:159:1: ( rule__RootClass__Group__0 )
            {
             before(grammarAccess.getRootClassAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:160:1: ( rule__RootClass__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:160:2: rule__RootClass__Group__0
            {
            pushFollow(FOLLOW_rule__RootClass__Group__0_in_ruleRootClass274);
            rule__RootClass__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRootClassAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRootClass"


    // $ANTLR start "entryRuleDateTimeFormat"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:172:1: entryRuleDateTimeFormat : ruleDateTimeFormat EOF ;
    public final void entryRuleDateTimeFormat() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:173:1: ( ruleDateTimeFormat EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:174:1: ruleDateTimeFormat EOF
            {
             before(grammarAccess.getDateTimeFormatRule()); 
            pushFollow(FOLLOW_ruleDateTimeFormat_in_entryRuleDateTimeFormat301);
            ruleDateTimeFormat();

            state._fsp--;

             after(grammarAccess.getDateTimeFormatRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateTimeFormat308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDateTimeFormat"


    // $ANTLR start "ruleDateTimeFormat"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:181:1: ruleDateTimeFormat : ( ( rule__DateTimeFormat__Group__0 ) ) ;
    public final void ruleDateTimeFormat() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:185:2: ( ( ( rule__DateTimeFormat__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:186:1: ( ( rule__DateTimeFormat__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:186:1: ( ( rule__DateTimeFormat__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:187:1: ( rule__DateTimeFormat__Group__0 )
            {
             before(grammarAccess.getDateTimeFormatAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:188:1: ( rule__DateTimeFormat__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:188:2: rule__DateTimeFormat__Group__0
            {
            pushFollow(FOLLOW_rule__DateTimeFormat__Group__0_in_ruleDateTimeFormat334);
            rule__DateTimeFormat__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDateTimeFormatAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDateTimeFormat"


    // $ANTLR start "entryRuleMessage"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:200:1: entryRuleMessage : ruleMessage EOF ;
    public final void entryRuleMessage() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:201:1: ( ruleMessage EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:202:1: ruleMessage EOF
            {
             before(grammarAccess.getMessageRule()); 
            pushFollow(FOLLOW_ruleMessage_in_entryRuleMessage361);
            ruleMessage();

            state._fsp--;

             after(grammarAccess.getMessageRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessage368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMessage"


    // $ANTLR start "ruleMessage"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:209:1: ruleMessage : ( ( rule__Message__Group__0 ) ) ;
    public final void ruleMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:213:2: ( ( ( rule__Message__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:214:1: ( ( rule__Message__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:214:1: ( ( rule__Message__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:215:1: ( rule__Message__Group__0 )
            {
             before(grammarAccess.getMessageAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:216:1: ( rule__Message__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:216:2: rule__Message__Group__0
            {
            pushFollow(FOLLOW_rule__Message__Group__0_in_ruleMessage394);
            rule__Message__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMessageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMessage"


    // $ANTLR start "entryRuleAbstractAttribute"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:228:1: entryRuleAbstractAttribute : ruleAbstractAttribute EOF ;
    public final void entryRuleAbstractAttribute() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:229:1: ( ruleAbstractAttribute EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:230:1: ruleAbstractAttribute EOF
            {
             before(grammarAccess.getAbstractAttributeRule()); 
            pushFollow(FOLLOW_ruleAbstractAttribute_in_entryRuleAbstractAttribute421);
            ruleAbstractAttribute();

            state._fsp--;

             after(grammarAccess.getAbstractAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractAttribute428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractAttribute"


    // $ANTLR start "ruleAbstractAttribute"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:237:1: ruleAbstractAttribute : ( ( rule__AbstractAttribute__Alternatives ) ) ;
    public final void ruleAbstractAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:241:2: ( ( ( rule__AbstractAttribute__Alternatives ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:242:1: ( ( rule__AbstractAttribute__Alternatives ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:242:1: ( ( rule__AbstractAttribute__Alternatives ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:243:1: ( rule__AbstractAttribute__Alternatives )
            {
             before(grammarAccess.getAbstractAttributeAccess().getAlternatives()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:244:1: ( rule__AbstractAttribute__Alternatives )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:244:2: rule__AbstractAttribute__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractAttribute__Alternatives_in_ruleAbstractAttribute454);
            rule__AbstractAttribute__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractAttributeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractAttribute"


    // $ANTLR start "entryRuleAttribute"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:256:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:257:1: ( ruleAttribute EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:258:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute481);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute488); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:265:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:269:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:270:1: ( ( rule__Attribute__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:270:1: ( ( rule__Attribute__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:271:1: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:272:1: ( rule__Attribute__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:272:2: rule__Attribute__Group__0
            {
            pushFollow(FOLLOW_rule__Attribute__Group__0_in_ruleAttribute514);
            rule__Attribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleListOf"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:284:1: entryRuleListOf : ruleListOf EOF ;
    public final void entryRuleListOf() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:285:1: ( ruleListOf EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:286:1: ruleListOf EOF
            {
             before(grammarAccess.getListOfRule()); 
            pushFollow(FOLLOW_ruleListOf_in_entryRuleListOf541);
            ruleListOf();

            state._fsp--;

             after(grammarAccess.getListOfRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOf548); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleListOf"


    // $ANTLR start "ruleListOf"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:293:1: ruleListOf : ( ( rule__ListOf__Group__0 ) ) ;
    public final void ruleListOf() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:297:2: ( ( ( rule__ListOf__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:298:1: ( ( rule__ListOf__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:298:1: ( ( rule__ListOf__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:299:1: ( rule__ListOf__Group__0 )
            {
             before(grammarAccess.getListOfAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:300:1: ( rule__ListOf__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:300:2: rule__ListOf__Group__0
            {
            pushFollow(FOLLOW_rule__ListOf__Group__0_in_ruleListOf574);
            rule__ListOf__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getListOfAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleListOf"


    // $ANTLR start "entryRuleOptional"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:312:1: entryRuleOptional : ruleOptional EOF ;
    public final void entryRuleOptional() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:313:1: ( ruleOptional EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:314:1: ruleOptional EOF
            {
             before(grammarAccess.getOptionalRule()); 
            pushFollow(FOLLOW_ruleOptional_in_entryRuleOptional601);
            ruleOptional();

            state._fsp--;

             after(grammarAccess.getOptionalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptional608); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOptional"


    // $ANTLR start "ruleOptional"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:321:1: ruleOptional : ( ( rule__Optional__Group__0 ) ) ;
    public final void ruleOptional() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:325:2: ( ( ( rule__Optional__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:326:1: ( ( rule__Optional__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:326:1: ( ( rule__Optional__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:327:1: ( rule__Optional__Group__0 )
            {
             before(grammarAccess.getOptionalAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:328:1: ( rule__Optional__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:328:2: rule__Optional__Group__0
            {
            pushFollow(FOLLOW_rule__Optional__Group__0_in_ruleOptional634);
            rule__Optional__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOptionalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOptional"


    // $ANTLR start "entryRuleSubTypeRef"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:340:1: entryRuleSubTypeRef : ruleSubTypeRef EOF ;
    public final void entryRuleSubTypeRef() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:341:1: ( ruleSubTypeRef EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:342:1: ruleSubTypeRef EOF
            {
             before(grammarAccess.getSubTypeRefRule()); 
            pushFollow(FOLLOW_ruleSubTypeRef_in_entryRuleSubTypeRef661);
            ruleSubTypeRef();

            state._fsp--;

             after(grammarAccess.getSubTypeRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubTypeRef668); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSubTypeRef"


    // $ANTLR start "ruleSubTypeRef"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:349:1: ruleSubTypeRef : ( ( rule__SubTypeRef__Group__0 ) ) ;
    public final void ruleSubTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:353:2: ( ( ( rule__SubTypeRef__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:354:1: ( ( rule__SubTypeRef__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:354:1: ( ( rule__SubTypeRef__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:355:1: ( rule__SubTypeRef__Group__0 )
            {
             before(grammarAccess.getSubTypeRefAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:356:1: ( rule__SubTypeRef__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:356:2: rule__SubTypeRef__Group__0
            {
            pushFollow(FOLLOW_rule__SubTypeRef__Group__0_in_ruleSubTypeRef694);
            rule__SubTypeRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSubTypeRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSubTypeRef"


    // $ANTLR start "entryRulePEnumRef"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:368:1: entryRulePEnumRef : rulePEnumRef EOF ;
    public final void entryRulePEnumRef() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:369:1: ( rulePEnumRef EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:370:1: rulePEnumRef EOF
            {
             before(grammarAccess.getPEnumRefRule()); 
            pushFollow(FOLLOW_rulePEnumRef_in_entryRulePEnumRef721);
            rulePEnumRef();

            state._fsp--;

             after(grammarAccess.getPEnumRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePEnumRef728); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePEnumRef"


    // $ANTLR start "rulePEnumRef"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:377:1: rulePEnumRef : ( ( rule__PEnumRef__Group__0 ) ) ;
    public final void rulePEnumRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:381:2: ( ( ( rule__PEnumRef__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:382:1: ( ( rule__PEnumRef__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:382:1: ( ( rule__PEnumRef__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:383:1: ( rule__PEnumRef__Group__0 )
            {
             before(grammarAccess.getPEnumRefAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:384:1: ( rule__PEnumRef__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:384:2: rule__PEnumRef__Group__0
            {
            pushFollow(FOLLOW_rule__PEnumRef__Group__0_in_rulePEnumRef754);
            rule__PEnumRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPEnumRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePEnumRef"


    // $ANTLR start "entryRuleSubType"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:396:1: entryRuleSubType : ruleSubType EOF ;
    public final void entryRuleSubType() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:397:1: ( ruleSubType EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:398:1: ruleSubType EOF
            {
             before(grammarAccess.getSubTypeRule()); 
            pushFollow(FOLLOW_ruleSubType_in_entryRuleSubType781);
            ruleSubType();

            state._fsp--;

             after(grammarAccess.getSubTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubType788); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSubType"


    // $ANTLR start "ruleSubType"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:405:1: ruleSubType : ( ( rule__SubType__Group__0 ) ) ;
    public final void ruleSubType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:409:2: ( ( ( rule__SubType__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:410:1: ( ( rule__SubType__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:410:1: ( ( rule__SubType__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:411:1: ( rule__SubType__Group__0 )
            {
             before(grammarAccess.getSubTypeAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:412:1: ( rule__SubType__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:412:2: rule__SubType__Group__0
            {
            pushFollow(FOLLOW_rule__SubType__Group__0_in_ruleSubType814);
            rule__SubType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSubTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSubType"


    // $ANTLR start "entryRulePEnum"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:424:1: entryRulePEnum : rulePEnum EOF ;
    public final void entryRulePEnum() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:425:1: ( rulePEnum EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:426:1: rulePEnum EOF
            {
             before(grammarAccess.getPEnumRule()); 
            pushFollow(FOLLOW_rulePEnum_in_entryRulePEnum841);
            rulePEnum();

            state._fsp--;

             after(grammarAccess.getPEnumRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePEnum848); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePEnum"


    // $ANTLR start "rulePEnum"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:433:1: rulePEnum : ( ( rule__PEnum__Group__0 ) ) ;
    public final void rulePEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:437:2: ( ( ( rule__PEnum__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:438:1: ( ( rule__PEnum__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:438:1: ( ( rule__PEnum__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:439:1: ( rule__PEnum__Group__0 )
            {
             before(grammarAccess.getPEnumAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:440:1: ( rule__PEnum__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:440:2: rule__PEnum__Group__0
            {
            pushFollow(FOLLOW_rule__PEnum__Group__0_in_rulePEnum874);
            rule__PEnum__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPEnumAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePEnum"


    // $ANTLR start "entryRulePEnumElement"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:452:1: entryRulePEnumElement : rulePEnumElement EOF ;
    public final void entryRulePEnumElement() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:453:1: ( rulePEnumElement EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:454:1: rulePEnumElement EOF
            {
             before(grammarAccess.getPEnumElementRule()); 
            pushFollow(FOLLOW_rulePEnumElement_in_entryRulePEnumElement901);
            rulePEnumElement();

            state._fsp--;

             after(grammarAccess.getPEnumElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePEnumElement908); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePEnumElement"


    // $ANTLR start "rulePEnumElement"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:461:1: rulePEnumElement : ( ( rule__PEnumElement__NameAssignment ) ) ;
    public final void rulePEnumElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:465:2: ( ( ( rule__PEnumElement__NameAssignment ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:466:1: ( ( rule__PEnumElement__NameAssignment ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:466:1: ( ( rule__PEnumElement__NameAssignment ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:467:1: ( rule__PEnumElement__NameAssignment )
            {
             before(grammarAccess.getPEnumElementAccess().getNameAssignment()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:468:1: ( rule__PEnumElement__NameAssignment )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:468:2: rule__PEnumElement__NameAssignment
            {
            pushFollow(FOLLOW_rule__PEnumElement__NameAssignment_in_rulePEnumElement934);
            rule__PEnumElement__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPEnumElementAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePEnumElement"


    // $ANTLR start "entryRuleQualifiedName"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:480:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:481:1: ( ruleQualifiedName EOF )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:482:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName961);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName968); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:489:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:493:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:494:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:494:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:495:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:496:1: ( rule__QualifiedName__Group__0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:496:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName994);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "ruleAttributeType"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:509:1: ruleAttributeType : ( ( rule__AttributeType__Alternatives ) ) ;
    public final void ruleAttributeType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:513:1: ( ( ( rule__AttributeType__Alternatives ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:514:1: ( ( rule__AttributeType__Alternatives ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:514:1: ( ( rule__AttributeType__Alternatives ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:515:1: ( rule__AttributeType__Alternatives )
            {
             before(grammarAccess.getAttributeTypeAccess().getAlternatives()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:516:1: ( rule__AttributeType__Alternatives )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:516:2: rule__AttributeType__Alternatives
            {
            pushFollow(FOLLOW_rule__AttributeType__Alternatives_in_ruleAttributeType1031);
            rule__AttributeType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAttributeTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeType"


    // $ANTLR start "rule__AbstractAttribute__Alternatives"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:527:1: rule__AbstractAttribute__Alternatives : ( ( ruleAttribute ) | ( ruleSubTypeRef ) );
    public final void rule__AbstractAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:531:1: ( ( ruleAttribute ) | ( ruleSubTypeRef ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==30) ) {
                    switch ( input.LA(3) ) {
                    case 38:
                        {
                        int LA1_3 = input.LA(4);

                        if ( (LA1_3==31) ) {
                            int LA1_6 = input.LA(5);

                            if ( ((LA1_6>=11 && LA1_6<=22)) ) {
                                alt1=1;
                            }
                            else if ( (LA1_6==RULE_ID) ) {
                                alt1=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 1, 6, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 3, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        {
                        alt1=1;
                        }
                        break;
                    case RULE_ID:
                        {
                        alt1=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 2, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:532:1: ( ruleAttribute )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:532:1: ( ruleAttribute )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:533:1: ruleAttribute
                    {
                     before(grammarAccess.getAbstractAttributeAccess().getAttributeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleAttribute_in_rule__AbstractAttribute__Alternatives1066);
                    ruleAttribute();

                    state._fsp--;

                     after(grammarAccess.getAbstractAttributeAccess().getAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:538:6: ( ruleSubTypeRef )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:538:6: ( ruleSubTypeRef )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:539:1: ruleSubTypeRef
                    {
                     before(grammarAccess.getAbstractAttributeAccess().getSubTypeRefParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleSubTypeRef_in_rule__AbstractAttribute__Alternatives1083);
                    ruleSubTypeRef();

                    state._fsp--;

                     after(grammarAccess.getAbstractAttributeAccess().getSubTypeRefParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractAttribute__Alternatives"


    // $ANTLR start "rule__AttributeType__Alternatives"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:549:1: rule__AttributeType__Alternatives : ( ( ( 'string' ) ) | ( ( 'byte' ) ) | ( ( 'char' ) ) | ( ( 'integer' ) ) | ( ( 'float' ) ) | ( ( 'double' ) ) | ( ( 'short' ) ) | ( ( 'long' ) ) | ( ( 'calendar' ) ) | ( ( 'boolean' ) ) | ( ( 'XREF' ) ) | ( ( 'ID' ) ) );
    public final void rule__AttributeType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:553:1: ( ( ( 'string' ) ) | ( ( 'byte' ) ) | ( ( 'char' ) ) | ( ( 'integer' ) ) | ( ( 'float' ) ) | ( ( 'double' ) ) | ( ( 'short' ) ) | ( ( 'long' ) ) | ( ( 'calendar' ) ) | ( ( 'boolean' ) ) | ( ( 'XREF' ) ) | ( ( 'ID' ) ) )
            int alt2=12;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            case 15:
                {
                alt2=5;
                }
                break;
            case 16:
                {
                alt2=6;
                }
                break;
            case 17:
                {
                alt2=7;
                }
                break;
            case 18:
                {
                alt2=8;
                }
                break;
            case 19:
                {
                alt2=9;
                }
                break;
            case 20:
                {
                alt2=10;
                }
                break;
            case 21:
                {
                alt2=11;
                }
                break;
            case 22:
                {
                alt2=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:554:1: ( ( 'string' ) )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:554:1: ( ( 'string' ) )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:555:1: ( 'string' )
                    {
                     before(grammarAccess.getAttributeTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:556:1: ( 'string' )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:556:3: 'string'
                    {
                    match(input,11,FOLLOW_11_in_rule__AttributeType__Alternatives1116); 

                    }

                     after(grammarAccess.getAttributeTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:561:6: ( ( 'byte' ) )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:561:6: ( ( 'byte' ) )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:562:1: ( 'byte' )
                    {
                     before(grammarAccess.getAttributeTypeAccess().getBYTEEnumLiteralDeclaration_1()); 
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:563:1: ( 'byte' )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:563:3: 'byte'
                    {
                    match(input,12,FOLLOW_12_in_rule__AttributeType__Alternatives1137); 

                    }

                     after(grammarAccess.getAttributeTypeAccess().getBYTEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:568:6: ( ( 'char' ) )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:568:6: ( ( 'char' ) )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:569:1: ( 'char' )
                    {
                     before(grammarAccess.getAttributeTypeAccess().getCHAREnumLiteralDeclaration_2()); 
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:570:1: ( 'char' )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:570:3: 'char'
                    {
                    match(input,13,FOLLOW_13_in_rule__AttributeType__Alternatives1158); 

                    }

                     after(grammarAccess.getAttributeTypeAccess().getCHAREnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:575:6: ( ( 'integer' ) )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:575:6: ( ( 'integer' ) )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:576:1: ( 'integer' )
                    {
                     before(grammarAccess.getAttributeTypeAccess().getINTEnumLiteralDeclaration_3()); 
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:577:1: ( 'integer' )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:577:3: 'integer'
                    {
                    match(input,14,FOLLOW_14_in_rule__AttributeType__Alternatives1179); 

                    }

                     after(grammarAccess.getAttributeTypeAccess().getINTEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:582:6: ( ( 'float' ) )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:582:6: ( ( 'float' ) )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:583:1: ( 'float' )
                    {
                     before(grammarAccess.getAttributeTypeAccess().getFLOATEnumLiteralDeclaration_4()); 
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:584:1: ( 'float' )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:584:3: 'float'
                    {
                    match(input,15,FOLLOW_15_in_rule__AttributeType__Alternatives1200); 

                    }

                     after(grammarAccess.getAttributeTypeAccess().getFLOATEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:589:6: ( ( 'double' ) )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:589:6: ( ( 'double' ) )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:590:1: ( 'double' )
                    {
                     before(grammarAccess.getAttributeTypeAccess().getDOUBLEEnumLiteralDeclaration_5()); 
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:591:1: ( 'double' )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:591:3: 'double'
                    {
                    match(input,16,FOLLOW_16_in_rule__AttributeType__Alternatives1221); 

                    }

                     after(grammarAccess.getAttributeTypeAccess().getDOUBLEEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:596:6: ( ( 'short' ) )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:596:6: ( ( 'short' ) )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:597:1: ( 'short' )
                    {
                     before(grammarAccess.getAttributeTypeAccess().getSHORTEnumLiteralDeclaration_6()); 
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:598:1: ( 'short' )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:598:3: 'short'
                    {
                    match(input,17,FOLLOW_17_in_rule__AttributeType__Alternatives1242); 

                    }

                     after(grammarAccess.getAttributeTypeAccess().getSHORTEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:603:6: ( ( 'long' ) )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:603:6: ( ( 'long' ) )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:604:1: ( 'long' )
                    {
                     before(grammarAccess.getAttributeTypeAccess().getLONGEnumLiteralDeclaration_7()); 
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:605:1: ( 'long' )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:605:3: 'long'
                    {
                    match(input,18,FOLLOW_18_in_rule__AttributeType__Alternatives1263); 

                    }

                     after(grammarAccess.getAttributeTypeAccess().getLONGEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:610:6: ( ( 'calendar' ) )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:610:6: ( ( 'calendar' ) )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:611:1: ( 'calendar' )
                    {
                     before(grammarAccess.getAttributeTypeAccess().getCALENDAREnumLiteralDeclaration_8()); 
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:612:1: ( 'calendar' )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:612:3: 'calendar'
                    {
                    match(input,19,FOLLOW_19_in_rule__AttributeType__Alternatives1284); 

                    }

                     after(grammarAccess.getAttributeTypeAccess().getCALENDAREnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:617:6: ( ( 'boolean' ) )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:617:6: ( ( 'boolean' ) )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:618:1: ( 'boolean' )
                    {
                     before(grammarAccess.getAttributeTypeAccess().getBOOLEANEnumLiteralDeclaration_9()); 
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:619:1: ( 'boolean' )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:619:3: 'boolean'
                    {
                    match(input,20,FOLLOW_20_in_rule__AttributeType__Alternatives1305); 

                    }

                     after(grammarAccess.getAttributeTypeAccess().getBOOLEANEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:624:6: ( ( 'XREF' ) )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:624:6: ( ( 'XREF' ) )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:625:1: ( 'XREF' )
                    {
                     before(grammarAccess.getAttributeTypeAccess().getXREFEnumLiteralDeclaration_10()); 
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:626:1: ( 'XREF' )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:626:3: 'XREF'
                    {
                    match(input,21,FOLLOW_21_in_rule__AttributeType__Alternatives1326); 

                    }

                     after(grammarAccess.getAttributeTypeAccess().getXREFEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:631:6: ( ( 'ID' ) )
                    {
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:631:6: ( ( 'ID' ) )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:632:1: ( 'ID' )
                    {
                     before(grammarAccess.getAttributeTypeAccess().getIDEnumLiteralDeclaration_11()); 
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:633:1: ( 'ID' )
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:633:3: 'ID'
                    {
                    match(input,22,FOLLOW_22_in_rule__AttributeType__Alternatives1347); 

                    }

                     after(grammarAccess.getAttributeTypeAccess().getIDEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeType__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:645:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:649:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:650:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__01380);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01383);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:657:1: rule__Model__Group__0__Impl : ( ( rule__Model__GrammarNameAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:661:1: ( ( ( rule__Model__GrammarNameAssignment_0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:662:1: ( ( rule__Model__GrammarNameAssignment_0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:662:1: ( ( rule__Model__GrammarNameAssignment_0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:663:1: ( rule__Model__GrammarNameAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getGrammarNameAssignment_0()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:664:1: ( rule__Model__GrammarNameAssignment_0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:664:2: rule__Model__GrammarNameAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__GrammarNameAssignment_0_in_rule__Model__Group__0__Impl1410);
            rule__Model__GrammarNameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGrammarNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:674:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:678:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:679:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11440);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__11443);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:686:1: rule__Model__Group__1__Impl : ( ( rule__Model__PackageAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:690:1: ( ( ( rule__Model__PackageAssignment_1 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:691:1: ( ( rule__Model__PackageAssignment_1 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:691:1: ( ( rule__Model__PackageAssignment_1 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:692:1: ( rule__Model__PackageAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getPackageAssignment_1()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:693:1: ( rule__Model__PackageAssignment_1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:693:2: rule__Model__PackageAssignment_1
            {
            pushFollow(FOLLOW_rule__Model__PackageAssignment_1_in_rule__Model__Group__1__Impl1470);
            rule__Model__PackageAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getPackageAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:703:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:707:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:708:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__21500);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__3_in_rule__Model__Group__21503);
            rule__Model__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:715:1: rule__Model__Group__2__Impl : ( ( rule__Model__RootClassAssignment_2 ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:719:1: ( ( ( rule__Model__RootClassAssignment_2 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:720:1: ( ( rule__Model__RootClassAssignment_2 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:720:1: ( ( rule__Model__RootClassAssignment_2 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:721:1: ( rule__Model__RootClassAssignment_2 )
            {
             before(grammarAccess.getModelAccess().getRootClassAssignment_2()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:722:1: ( rule__Model__RootClassAssignment_2 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:722:2: rule__Model__RootClassAssignment_2
            {
            pushFollow(FOLLOW_rule__Model__RootClassAssignment_2_in_rule__Model__Group__2__Impl1530);
            rule__Model__RootClassAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getRootClassAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:732:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:736:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:737:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__31560);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__4_in_rule__Model__Group__31563);
            rule__Model__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:744:1: rule__Model__Group__3__Impl : ( ( rule__Model__DateTimeFormatAssignment_3 )? ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:748:1: ( ( ( rule__Model__DateTimeFormatAssignment_3 )? ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:749:1: ( ( rule__Model__DateTimeFormatAssignment_3 )? )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:749:1: ( ( rule__Model__DateTimeFormatAssignment_3 )? )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:750:1: ( rule__Model__DateTimeFormatAssignment_3 )?
            {
             before(grammarAccess.getModelAccess().getDateTimeFormatAssignment_3()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:751:1: ( rule__Model__DateTimeFormatAssignment_3 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==26) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:751:2: rule__Model__DateTimeFormatAssignment_3
                    {
                    pushFollow(FOLLOW_rule__Model__DateTimeFormatAssignment_3_in_rule__Model__Group__3__Impl1590);
                    rule__Model__DateTimeFormatAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getDateTimeFormatAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group__4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:761:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:765:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:766:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__41621);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__5_in_rule__Model__Group__41624);
            rule__Model__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4"


    // $ANTLR start "rule__Model__Group__4__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:773:1: rule__Model__Group__4__Impl : ( ( rule__Model__MessagesAssignment_4 )* ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:777:1: ( ( ( rule__Model__MessagesAssignment_4 )* ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:778:1: ( ( rule__Model__MessagesAssignment_4 )* )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:778:1: ( ( rule__Model__MessagesAssignment_4 )* )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:779:1: ( rule__Model__MessagesAssignment_4 )*
            {
             before(grammarAccess.getModelAccess().getMessagesAssignment_4()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:780:1: ( rule__Model__MessagesAssignment_4 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==27) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:780:2: rule__Model__MessagesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Model__MessagesAssignment_4_in_rule__Model__Group__4__Impl1651);
            	    rule__Model__MessagesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getMessagesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4__Impl"


    // $ANTLR start "rule__Model__Group__5"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:790:1: rule__Model__Group__5 : rule__Model__Group__5__Impl rule__Model__Group__6 ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:794:1: ( rule__Model__Group__5__Impl rule__Model__Group__6 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:795:2: rule__Model__Group__5__Impl rule__Model__Group__6
            {
            pushFollow(FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__51682);
            rule__Model__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__6_in_rule__Model__Group__51685);
            rule__Model__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5"


    // $ANTLR start "rule__Model__Group__5__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:802:1: rule__Model__Group__5__Impl : ( ( rule__Model__SubTypesAssignment_5 )* ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:806:1: ( ( ( rule__Model__SubTypesAssignment_5 )* ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:807:1: ( ( rule__Model__SubTypesAssignment_5 )* )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:807:1: ( ( rule__Model__SubTypesAssignment_5 )* )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:808:1: ( rule__Model__SubTypesAssignment_5 )*
            {
             before(grammarAccess.getModelAccess().getSubTypesAssignment_5()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:809:1: ( rule__Model__SubTypesAssignment_5 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==35) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:809:2: rule__Model__SubTypesAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__Model__SubTypesAssignment_5_in_rule__Model__Group__5__Impl1712);
            	    rule__Model__SubTypesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getSubTypesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5__Impl"


    // $ANTLR start "rule__Model__Group__6"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:819:1: rule__Model__Group__6 : rule__Model__Group__6__Impl ;
    public final void rule__Model__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:823:1: ( rule__Model__Group__6__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:824:2: rule__Model__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__6__Impl_in_rule__Model__Group__61743);
            rule__Model__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__6"


    // $ANTLR start "rule__Model__Group__6__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:830:1: rule__Model__Group__6__Impl : ( ( rule__Model__PenumsAssignment_6 )* ) ;
    public final void rule__Model__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:834:1: ( ( ( rule__Model__PenumsAssignment_6 )* ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:835:1: ( ( rule__Model__PenumsAssignment_6 )* )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:835:1: ( ( rule__Model__PenumsAssignment_6 )* )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:836:1: ( rule__Model__PenumsAssignment_6 )*
            {
             before(grammarAccess.getModelAccess().getPenumsAssignment_6()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:837:1: ( rule__Model__PenumsAssignment_6 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==36) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:837:2: rule__Model__PenumsAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__Model__PenumsAssignment_6_in_rule__Model__Group__6__Impl1770);
            	    rule__Model__PenumsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getPenumsAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__6__Impl"


    // $ANTLR start "rule__GrammarName__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:861:1: rule__GrammarName__Group__0 : rule__GrammarName__Group__0__Impl rule__GrammarName__Group__1 ;
    public final void rule__GrammarName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:865:1: ( rule__GrammarName__Group__0__Impl rule__GrammarName__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:866:2: rule__GrammarName__Group__0__Impl rule__GrammarName__Group__1
            {
            pushFollow(FOLLOW_rule__GrammarName__Group__0__Impl_in_rule__GrammarName__Group__01815);
            rule__GrammarName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GrammarName__Group__1_in_rule__GrammarName__Group__01818);
            rule__GrammarName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarName__Group__0"


    // $ANTLR start "rule__GrammarName__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:873:1: rule__GrammarName__Group__0__Impl : ( 'grammar name' ) ;
    public final void rule__GrammarName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:877:1: ( ( 'grammar name' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:878:1: ( 'grammar name' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:878:1: ( 'grammar name' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:879:1: 'grammar name'
            {
             before(grammarAccess.getGrammarNameAccess().getGrammarNameKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__GrammarName__Group__0__Impl1846); 
             after(grammarAccess.getGrammarNameAccess().getGrammarNameKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarName__Group__0__Impl"


    // $ANTLR start "rule__GrammarName__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:892:1: rule__GrammarName__Group__1 : rule__GrammarName__Group__1__Impl ;
    public final void rule__GrammarName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:896:1: ( rule__GrammarName__Group__1__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:897:2: rule__GrammarName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__GrammarName__Group__1__Impl_in_rule__GrammarName__Group__11877);
            rule__GrammarName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarName__Group__1"


    // $ANTLR start "rule__GrammarName__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:903:1: rule__GrammarName__Group__1__Impl : ( ( rule__GrammarName__NameAssignment_1 ) ) ;
    public final void rule__GrammarName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:907:1: ( ( ( rule__GrammarName__NameAssignment_1 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:908:1: ( ( rule__GrammarName__NameAssignment_1 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:908:1: ( ( rule__GrammarName__NameAssignment_1 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:909:1: ( rule__GrammarName__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarNameAccess().getNameAssignment_1()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:910:1: ( rule__GrammarName__NameAssignment_1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:910:2: rule__GrammarName__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__GrammarName__NameAssignment_1_in_rule__GrammarName__Group__1__Impl1904);
            rule__GrammarName__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGrammarNameAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarName__Group__1__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:924:1: rule__PackageDeclaration__Group__0 : rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 ;
    public final void rule__PackageDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:928:1: ( rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:929:2: rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__0__Impl_in_rule__PackageDeclaration__Group__01938);
            rule__PackageDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__01941);
            rule__PackageDeclaration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__0"


    // $ANTLR start "rule__PackageDeclaration__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:936:1: rule__PackageDeclaration__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:940:1: ( ( 'package' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:941:1: ( 'package' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:941:1: ( 'package' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:942:1: 'package'
            {
             before(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__PackageDeclaration__Group__0__Impl1969); 
             after(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__0__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:955:1: rule__PackageDeclaration__Group__1 : rule__PackageDeclaration__Group__1__Impl ;
    public final void rule__PackageDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:959:1: ( rule__PackageDeclaration__Group__1__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:960:2: rule__PackageDeclaration__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__1__Impl_in_rule__PackageDeclaration__Group__12000);
            rule__PackageDeclaration__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__1"


    // $ANTLR start "rule__PackageDeclaration__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:966:1: rule__PackageDeclaration__Group__1__Impl : ( ( rule__PackageDeclaration__NameAssignment_1 ) ) ;
    public final void rule__PackageDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:970:1: ( ( ( rule__PackageDeclaration__NameAssignment_1 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:971:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:971:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:972:1: ( rule__PackageDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:973:1: ( rule__PackageDeclaration__NameAssignment_1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:973:2: rule__PackageDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__1__Impl2027);
            rule__PackageDeclaration__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__1__Impl"


    // $ANTLR start "rule__RootClass__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:987:1: rule__RootClass__Group__0 : rule__RootClass__Group__0__Impl rule__RootClass__Group__1 ;
    public final void rule__RootClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:991:1: ( rule__RootClass__Group__0__Impl rule__RootClass__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:992:2: rule__RootClass__Group__0__Impl rule__RootClass__Group__1
            {
            pushFollow(FOLLOW_rule__RootClass__Group__0__Impl_in_rule__RootClass__Group__02061);
            rule__RootClass__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RootClass__Group__1_in_rule__RootClass__Group__02064);
            rule__RootClass__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootClass__Group__0"


    // $ANTLR start "rule__RootClass__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:999:1: rule__RootClass__Group__0__Impl : ( 'root' ) ;
    public final void rule__RootClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1003:1: ( ( 'root' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1004:1: ( 'root' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1004:1: ( 'root' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1005:1: 'root'
            {
             before(grammarAccess.getRootClassAccess().getRootKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__RootClass__Group__0__Impl2092); 
             after(grammarAccess.getRootClassAccess().getRootKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootClass__Group__0__Impl"


    // $ANTLR start "rule__RootClass__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1018:1: rule__RootClass__Group__1 : rule__RootClass__Group__1__Impl ;
    public final void rule__RootClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1022:1: ( rule__RootClass__Group__1__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1023:2: rule__RootClass__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RootClass__Group__1__Impl_in_rule__RootClass__Group__12123);
            rule__RootClass__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootClass__Group__1"


    // $ANTLR start "rule__RootClass__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1029:1: rule__RootClass__Group__1__Impl : ( ( rule__RootClass__NameAssignment_1 ) ) ;
    public final void rule__RootClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1033:1: ( ( ( rule__RootClass__NameAssignment_1 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1034:1: ( ( rule__RootClass__NameAssignment_1 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1034:1: ( ( rule__RootClass__NameAssignment_1 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1035:1: ( rule__RootClass__NameAssignment_1 )
            {
             before(grammarAccess.getRootClassAccess().getNameAssignment_1()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1036:1: ( rule__RootClass__NameAssignment_1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1036:2: rule__RootClass__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__RootClass__NameAssignment_1_in_rule__RootClass__Group__1__Impl2150);
            rule__RootClass__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRootClassAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootClass__Group__1__Impl"


    // $ANTLR start "rule__DateTimeFormat__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1050:1: rule__DateTimeFormat__Group__0 : rule__DateTimeFormat__Group__0__Impl rule__DateTimeFormat__Group__1 ;
    public final void rule__DateTimeFormat__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1054:1: ( rule__DateTimeFormat__Group__0__Impl rule__DateTimeFormat__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1055:2: rule__DateTimeFormat__Group__0__Impl rule__DateTimeFormat__Group__1
            {
            pushFollow(FOLLOW_rule__DateTimeFormat__Group__0__Impl_in_rule__DateTimeFormat__Group__02184);
            rule__DateTimeFormat__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateTimeFormat__Group__1_in_rule__DateTimeFormat__Group__02187);
            rule__DateTimeFormat__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateTimeFormat__Group__0"


    // $ANTLR start "rule__DateTimeFormat__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1062:1: rule__DateTimeFormat__Group__0__Impl : ( 'date/time format:' ) ;
    public final void rule__DateTimeFormat__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1066:1: ( ( 'date/time format:' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1067:1: ( 'date/time format:' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1067:1: ( 'date/time format:' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1068:1: 'date/time format:'
            {
             before(grammarAccess.getDateTimeFormatAccess().getDateTimeFormatKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__DateTimeFormat__Group__0__Impl2215); 
             after(grammarAccess.getDateTimeFormatAccess().getDateTimeFormatKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateTimeFormat__Group__0__Impl"


    // $ANTLR start "rule__DateTimeFormat__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1081:1: rule__DateTimeFormat__Group__1 : rule__DateTimeFormat__Group__1__Impl ;
    public final void rule__DateTimeFormat__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1085:1: ( rule__DateTimeFormat__Group__1__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1086:2: rule__DateTimeFormat__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DateTimeFormat__Group__1__Impl_in_rule__DateTimeFormat__Group__12246);
            rule__DateTimeFormat__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateTimeFormat__Group__1"


    // $ANTLR start "rule__DateTimeFormat__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1092:1: rule__DateTimeFormat__Group__1__Impl : ( ( rule__DateTimeFormat__DateTimeFormatAssignment_1 ) ) ;
    public final void rule__DateTimeFormat__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1096:1: ( ( ( rule__DateTimeFormat__DateTimeFormatAssignment_1 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1097:1: ( ( rule__DateTimeFormat__DateTimeFormatAssignment_1 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1097:1: ( ( rule__DateTimeFormat__DateTimeFormatAssignment_1 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1098:1: ( rule__DateTimeFormat__DateTimeFormatAssignment_1 )
            {
             before(grammarAccess.getDateTimeFormatAccess().getDateTimeFormatAssignment_1()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1099:1: ( rule__DateTimeFormat__DateTimeFormatAssignment_1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1099:2: rule__DateTimeFormat__DateTimeFormatAssignment_1
            {
            pushFollow(FOLLOW_rule__DateTimeFormat__DateTimeFormatAssignment_1_in_rule__DateTimeFormat__Group__1__Impl2273);
            rule__DateTimeFormat__DateTimeFormatAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDateTimeFormatAccess().getDateTimeFormatAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateTimeFormat__Group__1__Impl"


    // $ANTLR start "rule__Message__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1113:1: rule__Message__Group__0 : rule__Message__Group__0__Impl rule__Message__Group__1 ;
    public final void rule__Message__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1117:1: ( rule__Message__Group__0__Impl rule__Message__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1118:2: rule__Message__Group__0__Impl rule__Message__Group__1
            {
            pushFollow(FOLLOW_rule__Message__Group__0__Impl_in_rule__Message__Group__02307);
            rule__Message__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Message__Group__1_in_rule__Message__Group__02310);
            rule__Message__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Group__0"


    // $ANTLR start "rule__Message__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1125:1: rule__Message__Group__0__Impl : ( 'Message' ) ;
    public final void rule__Message__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1129:1: ( ( 'Message' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1130:1: ( 'Message' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1130:1: ( 'Message' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1131:1: 'Message'
            {
             before(grammarAccess.getMessageAccess().getMessageKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__Message__Group__0__Impl2338); 
             after(grammarAccess.getMessageAccess().getMessageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Group__0__Impl"


    // $ANTLR start "rule__Message__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1144:1: rule__Message__Group__1 : rule__Message__Group__1__Impl rule__Message__Group__2 ;
    public final void rule__Message__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1148:1: ( rule__Message__Group__1__Impl rule__Message__Group__2 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1149:2: rule__Message__Group__1__Impl rule__Message__Group__2
            {
            pushFollow(FOLLOW_rule__Message__Group__1__Impl_in_rule__Message__Group__12369);
            rule__Message__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Message__Group__2_in_rule__Message__Group__12372);
            rule__Message__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Group__1"


    // $ANTLR start "rule__Message__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1156:1: rule__Message__Group__1__Impl : ( ( rule__Message__NameAssignment_1 ) ) ;
    public final void rule__Message__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1160:1: ( ( ( rule__Message__NameAssignment_1 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1161:1: ( ( rule__Message__NameAssignment_1 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1161:1: ( ( rule__Message__NameAssignment_1 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1162:1: ( rule__Message__NameAssignment_1 )
            {
             before(grammarAccess.getMessageAccess().getNameAssignment_1()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1163:1: ( rule__Message__NameAssignment_1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1163:2: rule__Message__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Message__NameAssignment_1_in_rule__Message__Group__1__Impl2399);
            rule__Message__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMessageAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Group__1__Impl"


    // $ANTLR start "rule__Message__Group__2"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1173:1: rule__Message__Group__2 : rule__Message__Group__2__Impl rule__Message__Group__3 ;
    public final void rule__Message__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1177:1: ( rule__Message__Group__2__Impl rule__Message__Group__3 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1178:2: rule__Message__Group__2__Impl rule__Message__Group__3
            {
            pushFollow(FOLLOW_rule__Message__Group__2__Impl_in_rule__Message__Group__22429);
            rule__Message__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Message__Group__3_in_rule__Message__Group__22432);
            rule__Message__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Group__2"


    // $ANTLR start "rule__Message__Group__2__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1185:1: rule__Message__Group__2__Impl : ( '{' ) ;
    public final void rule__Message__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1189:1: ( ( '{' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1190:1: ( '{' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1190:1: ( '{' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1191:1: '{'
            {
             before(grammarAccess.getMessageAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,28,FOLLOW_28_in_rule__Message__Group__2__Impl2460); 
             after(grammarAccess.getMessageAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Group__2__Impl"


    // $ANTLR start "rule__Message__Group__3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1204:1: rule__Message__Group__3 : rule__Message__Group__3__Impl rule__Message__Group__4 ;
    public final void rule__Message__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1208:1: ( rule__Message__Group__3__Impl rule__Message__Group__4 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1209:2: rule__Message__Group__3__Impl rule__Message__Group__4
            {
            pushFollow(FOLLOW_rule__Message__Group__3__Impl_in_rule__Message__Group__32491);
            rule__Message__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Message__Group__4_in_rule__Message__Group__32494);
            rule__Message__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Group__3"


    // $ANTLR start "rule__Message__Group__3__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1216:1: rule__Message__Group__3__Impl : ( ( rule__Message__AttributesAssignment_3 )* ) ;
    public final void rule__Message__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1220:1: ( ( ( rule__Message__AttributesAssignment_3 )* ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1221:1: ( ( rule__Message__AttributesAssignment_3 )* )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1221:1: ( ( rule__Message__AttributesAssignment_3 )* )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1222:1: ( rule__Message__AttributesAssignment_3 )*
            {
             before(grammarAccess.getMessageAccess().getAttributesAssignment_3()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1223:1: ( rule__Message__AttributesAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1==30) ) {
                        int LA7_3 = input.LA(3);

                        if ( (LA7_3==RULE_ID||(LA7_3>=11 && LA7_3<=22)||LA7_3==38) ) {
                            alt7=1;
                        }


                    }


                }


                switch (alt7) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1223:2: rule__Message__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Message__AttributesAssignment_3_in_rule__Message__Group__3__Impl2521);
            	    rule__Message__AttributesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getMessageAccess().getAttributesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Group__3__Impl"


    // $ANTLR start "rule__Message__Group__4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1233:1: rule__Message__Group__4 : rule__Message__Group__4__Impl rule__Message__Group__5 ;
    public final void rule__Message__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1237:1: ( rule__Message__Group__4__Impl rule__Message__Group__5 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1238:2: rule__Message__Group__4__Impl rule__Message__Group__5
            {
            pushFollow(FOLLOW_rule__Message__Group__4__Impl_in_rule__Message__Group__42552);
            rule__Message__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Message__Group__5_in_rule__Message__Group__42555);
            rule__Message__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Group__4"


    // $ANTLR start "rule__Message__Group__4__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1245:1: rule__Message__Group__4__Impl : ( ( rule__Message__EnumsAssignment_4 )* ) ;
    public final void rule__Message__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1249:1: ( ( ( rule__Message__EnumsAssignment_4 )* ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1250:1: ( ( rule__Message__EnumsAssignment_4 )* )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1250:1: ( ( rule__Message__EnumsAssignment_4 )* )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1251:1: ( rule__Message__EnumsAssignment_4 )*
            {
             before(grammarAccess.getMessageAccess().getEnumsAssignment_4()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1252:1: ( rule__Message__EnumsAssignment_4 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1252:2: rule__Message__EnumsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Message__EnumsAssignment_4_in_rule__Message__Group__4__Impl2582);
            	    rule__Message__EnumsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getMessageAccess().getEnumsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Group__4__Impl"


    // $ANTLR start "rule__Message__Group__5"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1262:1: rule__Message__Group__5 : rule__Message__Group__5__Impl ;
    public final void rule__Message__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1266:1: ( rule__Message__Group__5__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1267:2: rule__Message__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Message__Group__5__Impl_in_rule__Message__Group__52613);
            rule__Message__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Group__5"


    // $ANTLR start "rule__Message__Group__5__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1273:1: rule__Message__Group__5__Impl : ( '}' ) ;
    public final void rule__Message__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1277:1: ( ( '}' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1278:1: ( '}' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1278:1: ( '}' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1279:1: '}'
            {
             before(grammarAccess.getMessageAccess().getRightCurlyBracketKeyword_5()); 
            match(input,29,FOLLOW_29_in_rule__Message__Group__5__Impl2641); 
             after(grammarAccess.getMessageAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Group__5__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1304:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1308:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1309:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FOLLOW_rule__Attribute__Group__0__Impl_in_rule__Attribute__Group__02684);
            rule__Attribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__02687);
            rule__Attribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1316:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__NameAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1320:1: ( ( ( rule__Attribute__NameAssignment_0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1321:1: ( ( rule__Attribute__NameAssignment_0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1321:1: ( ( rule__Attribute__NameAssignment_0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1322:1: ( rule__Attribute__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_0()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1323:1: ( rule__Attribute__NameAssignment_0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1323:2: rule__Attribute__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Attribute__NameAssignment_0_in_rule__Attribute__Group__0__Impl2714);
            rule__Attribute__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1333:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1337:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1338:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FOLLOW_rule__Attribute__Group__1__Impl_in_rule__Attribute__Group__12744);
            rule__Attribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__12747);
            rule__Attribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1345:1: rule__Attribute__Group__1__Impl : ( 'as' ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1349:1: ( ( 'as' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1350:1: ( 'as' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1350:1: ( 'as' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1351:1: 'as'
            {
             before(grammarAccess.getAttributeAccess().getAsKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__Attribute__Group__1__Impl2775); 
             after(grammarAccess.getAttributeAccess().getAsKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1364:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1368:1: ( rule__Attribute__Group__2__Impl rule__Attribute__Group__3 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1369:2: rule__Attribute__Group__2__Impl rule__Attribute__Group__3
            {
            pushFollow(FOLLOW_rule__Attribute__Group__2__Impl_in_rule__Attribute__Group__22806);
            rule__Attribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Attribute__Group__3_in_rule__Attribute__Group__22809);
            rule__Attribute__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2"


    // $ANTLR start "rule__Attribute__Group__2__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1376:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__ListOfAssignment_2 )? ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1380:1: ( ( ( rule__Attribute__ListOfAssignment_2 )? ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1381:1: ( ( rule__Attribute__ListOfAssignment_2 )? )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1381:1: ( ( rule__Attribute__ListOfAssignment_2 )? )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1382:1: ( rule__Attribute__ListOfAssignment_2 )?
            {
             before(grammarAccess.getAttributeAccess().getListOfAssignment_2()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1383:1: ( rule__Attribute__ListOfAssignment_2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==38) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1383:2: rule__Attribute__ListOfAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Attribute__ListOfAssignment_2_in_rule__Attribute__Group__2__Impl2836);
                    rule__Attribute__ListOfAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getListOfAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__Attribute__Group__3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1393:1: rule__Attribute__Group__3 : rule__Attribute__Group__3__Impl rule__Attribute__Group__4 ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1397:1: ( rule__Attribute__Group__3__Impl rule__Attribute__Group__4 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1398:2: rule__Attribute__Group__3__Impl rule__Attribute__Group__4
            {
            pushFollow(FOLLOW_rule__Attribute__Group__3__Impl_in_rule__Attribute__Group__32867);
            rule__Attribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Attribute__Group__4_in_rule__Attribute__Group__32870);
            rule__Attribute__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__3"


    // $ANTLR start "rule__Attribute__Group__3__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1405:1: rule__Attribute__Group__3__Impl : ( ( rule__Attribute__AttributeTypeAssignment_3 ) ) ;
    public final void rule__Attribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1409:1: ( ( ( rule__Attribute__AttributeTypeAssignment_3 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1410:1: ( ( rule__Attribute__AttributeTypeAssignment_3 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1410:1: ( ( rule__Attribute__AttributeTypeAssignment_3 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1411:1: ( rule__Attribute__AttributeTypeAssignment_3 )
            {
             before(grammarAccess.getAttributeAccess().getAttributeTypeAssignment_3()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1412:1: ( rule__Attribute__AttributeTypeAssignment_3 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1412:2: rule__Attribute__AttributeTypeAssignment_3
            {
            pushFollow(FOLLOW_rule__Attribute__AttributeTypeAssignment_3_in_rule__Attribute__Group__3__Impl2897);
            rule__Attribute__AttributeTypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getAttributeTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__3__Impl"


    // $ANTLR start "rule__Attribute__Group__4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1422:1: rule__Attribute__Group__4 : rule__Attribute__Group__4__Impl ;
    public final void rule__Attribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1426:1: ( rule__Attribute__Group__4__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1427:2: rule__Attribute__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Attribute__Group__4__Impl_in_rule__Attribute__Group__42927);
            rule__Attribute__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__4"


    // $ANTLR start "rule__Attribute__Group__4__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1433:1: rule__Attribute__Group__4__Impl : ( ( rule__Attribute__OptionalAssignment_4 )? ) ;
    public final void rule__Attribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1437:1: ( ( ( rule__Attribute__OptionalAssignment_4 )? ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1438:1: ( ( rule__Attribute__OptionalAssignment_4 )? )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1438:1: ( ( rule__Attribute__OptionalAssignment_4 )? )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1439:1: ( rule__Attribute__OptionalAssignment_4 )?
            {
             before(grammarAccess.getAttributeAccess().getOptionalAssignment_4()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1440:1: ( rule__Attribute__OptionalAssignment_4 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==39) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1440:2: rule__Attribute__OptionalAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Attribute__OptionalAssignment_4_in_rule__Attribute__Group__4__Impl2954);
                    rule__Attribute__OptionalAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getOptionalAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__4__Impl"


    // $ANTLR start "rule__ListOf__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1460:1: rule__ListOf__Group__0 : rule__ListOf__Group__0__Impl rule__ListOf__Group__1 ;
    public final void rule__ListOf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1464:1: ( rule__ListOf__Group__0__Impl rule__ListOf__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1465:2: rule__ListOf__Group__0__Impl rule__ListOf__Group__1
            {
            pushFollow(FOLLOW_rule__ListOf__Group__0__Impl_in_rule__ListOf__Group__02995);
            rule__ListOf__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ListOf__Group__1_in_rule__ListOf__Group__02998);
            rule__ListOf__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOf__Group__0"


    // $ANTLR start "rule__ListOf__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1472:1: rule__ListOf__Group__0__Impl : ( ( rule__ListOf__ListOfAssignment_0 ) ) ;
    public final void rule__ListOf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1476:1: ( ( ( rule__ListOf__ListOfAssignment_0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1477:1: ( ( rule__ListOf__ListOfAssignment_0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1477:1: ( ( rule__ListOf__ListOfAssignment_0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1478:1: ( rule__ListOf__ListOfAssignment_0 )
            {
             before(grammarAccess.getListOfAccess().getListOfAssignment_0()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1479:1: ( rule__ListOf__ListOfAssignment_0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1479:2: rule__ListOf__ListOfAssignment_0
            {
            pushFollow(FOLLOW_rule__ListOf__ListOfAssignment_0_in_rule__ListOf__Group__0__Impl3025);
            rule__ListOf__ListOfAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getListOfAccess().getListOfAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOf__Group__0__Impl"


    // $ANTLR start "rule__ListOf__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1489:1: rule__ListOf__Group__1 : rule__ListOf__Group__1__Impl ;
    public final void rule__ListOf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1493:1: ( rule__ListOf__Group__1__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1494:2: rule__ListOf__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOf__Group__1__Impl_in_rule__ListOf__Group__13055);
            rule__ListOf__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOf__Group__1"


    // $ANTLR start "rule__ListOf__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1500:1: rule__ListOf__Group__1__Impl : ( 'of' ) ;
    public final void rule__ListOf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1504:1: ( ( 'of' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1505:1: ( 'of' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1505:1: ( 'of' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1506:1: 'of'
            {
             before(grammarAccess.getListOfAccess().getOfKeyword_1()); 
            match(input,31,FOLLOW_31_in_rule__ListOf__Group__1__Impl3083); 
             after(grammarAccess.getListOfAccess().getOfKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOf__Group__1__Impl"


    // $ANTLR start "rule__Optional__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1523:1: rule__Optional__Group__0 : rule__Optional__Group__0__Impl rule__Optional__Group__1 ;
    public final void rule__Optional__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1527:1: ( rule__Optional__Group__0__Impl rule__Optional__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1528:2: rule__Optional__Group__0__Impl rule__Optional__Group__1
            {
            pushFollow(FOLLOW_rule__Optional__Group__0__Impl_in_rule__Optional__Group__03118);
            rule__Optional__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Optional__Group__1_in_rule__Optional__Group__03121);
            rule__Optional__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Optional__Group__0"


    // $ANTLR start "rule__Optional__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1535:1: rule__Optional__Group__0__Impl : ( ( rule__Optional__OptionalAssignment_0 ) ) ;
    public final void rule__Optional__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1539:1: ( ( ( rule__Optional__OptionalAssignment_0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1540:1: ( ( rule__Optional__OptionalAssignment_0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1540:1: ( ( rule__Optional__OptionalAssignment_0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1541:1: ( rule__Optional__OptionalAssignment_0 )
            {
             before(grammarAccess.getOptionalAccess().getOptionalAssignment_0()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1542:1: ( rule__Optional__OptionalAssignment_0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1542:2: rule__Optional__OptionalAssignment_0
            {
            pushFollow(FOLLOW_rule__Optional__OptionalAssignment_0_in_rule__Optional__Group__0__Impl3148);
            rule__Optional__OptionalAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOptionalAccess().getOptionalAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Optional__Group__0__Impl"


    // $ANTLR start "rule__Optional__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1552:1: rule__Optional__Group__1 : rule__Optional__Group__1__Impl rule__Optional__Group__2 ;
    public final void rule__Optional__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1556:1: ( rule__Optional__Group__1__Impl rule__Optional__Group__2 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1557:2: rule__Optional__Group__1__Impl rule__Optional__Group__2
            {
            pushFollow(FOLLOW_rule__Optional__Group__1__Impl_in_rule__Optional__Group__13178);
            rule__Optional__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Optional__Group__2_in_rule__Optional__Group__13181);
            rule__Optional__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Optional__Group__1"


    // $ANTLR start "rule__Optional__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1564:1: rule__Optional__Group__1__Impl : ( 'optional' ) ;
    public final void rule__Optional__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1568:1: ( ( 'optional' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1569:1: ( 'optional' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1569:1: ( 'optional' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1570:1: 'optional'
            {
             before(grammarAccess.getOptionalAccess().getOptionalKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__Optional__Group__1__Impl3209); 
             after(grammarAccess.getOptionalAccess().getOptionalKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Optional__Group__1__Impl"


    // $ANTLR start "rule__Optional__Group__2"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1583:1: rule__Optional__Group__2 : rule__Optional__Group__2__Impl ;
    public final void rule__Optional__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1587:1: ( rule__Optional__Group__2__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1588:2: rule__Optional__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Optional__Group__2__Impl_in_rule__Optional__Group__23240);
            rule__Optional__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Optional__Group__2"


    // $ANTLR start "rule__Optional__Group__2__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1594:1: rule__Optional__Group__2__Impl : ( ')' ) ;
    public final void rule__Optional__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1598:1: ( ( ')' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1599:1: ( ')' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1599:1: ( ')' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1600:1: ')'
            {
             before(grammarAccess.getOptionalAccess().getRightParenthesisKeyword_2()); 
            match(input,33,FOLLOW_33_in_rule__Optional__Group__2__Impl3268); 
             after(grammarAccess.getOptionalAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Optional__Group__2__Impl"


    // $ANTLR start "rule__SubTypeRef__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1619:1: rule__SubTypeRef__Group__0 : rule__SubTypeRef__Group__0__Impl rule__SubTypeRef__Group__1 ;
    public final void rule__SubTypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1623:1: ( rule__SubTypeRef__Group__0__Impl rule__SubTypeRef__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1624:2: rule__SubTypeRef__Group__0__Impl rule__SubTypeRef__Group__1
            {
            pushFollow(FOLLOW_rule__SubTypeRef__Group__0__Impl_in_rule__SubTypeRef__Group__03305);
            rule__SubTypeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubTypeRef__Group__1_in_rule__SubTypeRef__Group__03308);
            rule__SubTypeRef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__Group__0"


    // $ANTLR start "rule__SubTypeRef__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1631:1: rule__SubTypeRef__Group__0__Impl : ( ( rule__SubTypeRef__NameAssignment_0 ) ) ;
    public final void rule__SubTypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1635:1: ( ( ( rule__SubTypeRef__NameAssignment_0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1636:1: ( ( rule__SubTypeRef__NameAssignment_0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1636:1: ( ( rule__SubTypeRef__NameAssignment_0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1637:1: ( rule__SubTypeRef__NameAssignment_0 )
            {
             before(grammarAccess.getSubTypeRefAccess().getNameAssignment_0()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1638:1: ( rule__SubTypeRef__NameAssignment_0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1638:2: rule__SubTypeRef__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__SubTypeRef__NameAssignment_0_in_rule__SubTypeRef__Group__0__Impl3335);
            rule__SubTypeRef__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSubTypeRefAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__Group__0__Impl"


    // $ANTLR start "rule__SubTypeRef__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1648:1: rule__SubTypeRef__Group__1 : rule__SubTypeRef__Group__1__Impl rule__SubTypeRef__Group__2 ;
    public final void rule__SubTypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1652:1: ( rule__SubTypeRef__Group__1__Impl rule__SubTypeRef__Group__2 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1653:2: rule__SubTypeRef__Group__1__Impl rule__SubTypeRef__Group__2
            {
            pushFollow(FOLLOW_rule__SubTypeRef__Group__1__Impl_in_rule__SubTypeRef__Group__13365);
            rule__SubTypeRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubTypeRef__Group__2_in_rule__SubTypeRef__Group__13368);
            rule__SubTypeRef__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__Group__1"


    // $ANTLR start "rule__SubTypeRef__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1660:1: rule__SubTypeRef__Group__1__Impl : ( 'as' ) ;
    public final void rule__SubTypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1664:1: ( ( 'as' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1665:1: ( 'as' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1665:1: ( 'as' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1666:1: 'as'
            {
             before(grammarAccess.getSubTypeRefAccess().getAsKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__SubTypeRef__Group__1__Impl3396); 
             after(grammarAccess.getSubTypeRefAccess().getAsKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__Group__1__Impl"


    // $ANTLR start "rule__SubTypeRef__Group__2"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1679:1: rule__SubTypeRef__Group__2 : rule__SubTypeRef__Group__2__Impl rule__SubTypeRef__Group__3 ;
    public final void rule__SubTypeRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1683:1: ( rule__SubTypeRef__Group__2__Impl rule__SubTypeRef__Group__3 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1684:2: rule__SubTypeRef__Group__2__Impl rule__SubTypeRef__Group__3
            {
            pushFollow(FOLLOW_rule__SubTypeRef__Group__2__Impl_in_rule__SubTypeRef__Group__23427);
            rule__SubTypeRef__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubTypeRef__Group__3_in_rule__SubTypeRef__Group__23430);
            rule__SubTypeRef__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__Group__2"


    // $ANTLR start "rule__SubTypeRef__Group__2__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1691:1: rule__SubTypeRef__Group__2__Impl : ( ( rule__SubTypeRef__ListOfAssignment_2 )? ) ;
    public final void rule__SubTypeRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1695:1: ( ( ( rule__SubTypeRef__ListOfAssignment_2 )? ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1696:1: ( ( rule__SubTypeRef__ListOfAssignment_2 )? )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1696:1: ( ( rule__SubTypeRef__ListOfAssignment_2 )? )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1697:1: ( rule__SubTypeRef__ListOfAssignment_2 )?
            {
             before(grammarAccess.getSubTypeRefAccess().getListOfAssignment_2()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1698:1: ( rule__SubTypeRef__ListOfAssignment_2 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==38) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1698:2: rule__SubTypeRef__ListOfAssignment_2
                    {
                    pushFollow(FOLLOW_rule__SubTypeRef__ListOfAssignment_2_in_rule__SubTypeRef__Group__2__Impl3457);
                    rule__SubTypeRef__ListOfAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubTypeRefAccess().getListOfAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__Group__2__Impl"


    // $ANTLR start "rule__SubTypeRef__Group__3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1708:1: rule__SubTypeRef__Group__3 : rule__SubTypeRef__Group__3__Impl rule__SubTypeRef__Group__4 ;
    public final void rule__SubTypeRef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1712:1: ( rule__SubTypeRef__Group__3__Impl rule__SubTypeRef__Group__4 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1713:2: rule__SubTypeRef__Group__3__Impl rule__SubTypeRef__Group__4
            {
            pushFollow(FOLLOW_rule__SubTypeRef__Group__3__Impl_in_rule__SubTypeRef__Group__33488);
            rule__SubTypeRef__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubTypeRef__Group__4_in_rule__SubTypeRef__Group__33491);
            rule__SubTypeRef__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__Group__3"


    // $ANTLR start "rule__SubTypeRef__Group__3__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1720:1: rule__SubTypeRef__Group__3__Impl : ( ( rule__SubTypeRef__SubTypeAssignment_3 ) ) ;
    public final void rule__SubTypeRef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1724:1: ( ( ( rule__SubTypeRef__SubTypeAssignment_3 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1725:1: ( ( rule__SubTypeRef__SubTypeAssignment_3 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1725:1: ( ( rule__SubTypeRef__SubTypeAssignment_3 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1726:1: ( rule__SubTypeRef__SubTypeAssignment_3 )
            {
             before(grammarAccess.getSubTypeRefAccess().getSubTypeAssignment_3()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1727:1: ( rule__SubTypeRef__SubTypeAssignment_3 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1727:2: rule__SubTypeRef__SubTypeAssignment_3
            {
            pushFollow(FOLLOW_rule__SubTypeRef__SubTypeAssignment_3_in_rule__SubTypeRef__Group__3__Impl3518);
            rule__SubTypeRef__SubTypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSubTypeRefAccess().getSubTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__Group__3__Impl"


    // $ANTLR start "rule__SubTypeRef__Group__4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1737:1: rule__SubTypeRef__Group__4 : rule__SubTypeRef__Group__4__Impl ;
    public final void rule__SubTypeRef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1741:1: ( rule__SubTypeRef__Group__4__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1742:2: rule__SubTypeRef__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SubTypeRef__Group__4__Impl_in_rule__SubTypeRef__Group__43548);
            rule__SubTypeRef__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__Group__4"


    // $ANTLR start "rule__SubTypeRef__Group__4__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1748:1: rule__SubTypeRef__Group__4__Impl : ( ( rule__SubTypeRef__OptionalAssignment_4 )? ) ;
    public final void rule__SubTypeRef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1752:1: ( ( ( rule__SubTypeRef__OptionalAssignment_4 )? ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1753:1: ( ( rule__SubTypeRef__OptionalAssignment_4 )? )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1753:1: ( ( rule__SubTypeRef__OptionalAssignment_4 )? )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1754:1: ( rule__SubTypeRef__OptionalAssignment_4 )?
            {
             before(grammarAccess.getSubTypeRefAccess().getOptionalAssignment_4()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1755:1: ( rule__SubTypeRef__OptionalAssignment_4 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==39) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1755:2: rule__SubTypeRef__OptionalAssignment_4
                    {
                    pushFollow(FOLLOW_rule__SubTypeRef__OptionalAssignment_4_in_rule__SubTypeRef__Group__4__Impl3575);
                    rule__SubTypeRef__OptionalAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubTypeRefAccess().getOptionalAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__Group__4__Impl"


    // $ANTLR start "rule__PEnumRef__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1775:1: rule__PEnumRef__Group__0 : rule__PEnumRef__Group__0__Impl rule__PEnumRef__Group__1 ;
    public final void rule__PEnumRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1779:1: ( rule__PEnumRef__Group__0__Impl rule__PEnumRef__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1780:2: rule__PEnumRef__Group__0__Impl rule__PEnumRef__Group__1
            {
            pushFollow(FOLLOW_rule__PEnumRef__Group__0__Impl_in_rule__PEnumRef__Group__03616);
            rule__PEnumRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PEnumRef__Group__1_in_rule__PEnumRef__Group__03619);
            rule__PEnumRef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__Group__0"


    // $ANTLR start "rule__PEnumRef__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1787:1: rule__PEnumRef__Group__0__Impl : ( ( rule__PEnumRef__NameAssignment_0 ) ) ;
    public final void rule__PEnumRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1791:1: ( ( ( rule__PEnumRef__NameAssignment_0 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1792:1: ( ( rule__PEnumRef__NameAssignment_0 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1792:1: ( ( rule__PEnumRef__NameAssignment_0 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1793:1: ( rule__PEnumRef__NameAssignment_0 )
            {
             before(grammarAccess.getPEnumRefAccess().getNameAssignment_0()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1794:1: ( rule__PEnumRef__NameAssignment_0 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1794:2: rule__PEnumRef__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__PEnumRef__NameAssignment_0_in_rule__PEnumRef__Group__0__Impl3646);
            rule__PEnumRef__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPEnumRefAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__Group__0__Impl"


    // $ANTLR start "rule__PEnumRef__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1804:1: rule__PEnumRef__Group__1 : rule__PEnumRef__Group__1__Impl rule__PEnumRef__Group__2 ;
    public final void rule__PEnumRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1808:1: ( rule__PEnumRef__Group__1__Impl rule__PEnumRef__Group__2 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1809:2: rule__PEnumRef__Group__1__Impl rule__PEnumRef__Group__2
            {
            pushFollow(FOLLOW_rule__PEnumRef__Group__1__Impl_in_rule__PEnumRef__Group__13676);
            rule__PEnumRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PEnumRef__Group__2_in_rule__PEnumRef__Group__13679);
            rule__PEnumRef__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__Group__1"


    // $ANTLR start "rule__PEnumRef__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1816:1: rule__PEnumRef__Group__1__Impl : ( 'as' ) ;
    public final void rule__PEnumRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1820:1: ( ( 'as' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1821:1: ( 'as' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1821:1: ( 'as' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1822:1: 'as'
            {
             before(grammarAccess.getPEnumRefAccess().getAsKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__PEnumRef__Group__1__Impl3707); 
             after(grammarAccess.getPEnumRefAccess().getAsKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__Group__1__Impl"


    // $ANTLR start "rule__PEnumRef__Group__2"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1835:1: rule__PEnumRef__Group__2 : rule__PEnumRef__Group__2__Impl rule__PEnumRef__Group__3 ;
    public final void rule__PEnumRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1839:1: ( rule__PEnumRef__Group__2__Impl rule__PEnumRef__Group__3 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1840:2: rule__PEnumRef__Group__2__Impl rule__PEnumRef__Group__3
            {
            pushFollow(FOLLOW_rule__PEnumRef__Group__2__Impl_in_rule__PEnumRef__Group__23738);
            rule__PEnumRef__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PEnumRef__Group__3_in_rule__PEnumRef__Group__23741);
            rule__PEnumRef__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__Group__2"


    // $ANTLR start "rule__PEnumRef__Group__2__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1847:1: rule__PEnumRef__Group__2__Impl : ( 'enum' ) ;
    public final void rule__PEnumRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1851:1: ( ( 'enum' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1852:1: ( 'enum' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1852:1: ( 'enum' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1853:1: 'enum'
            {
             before(grammarAccess.getPEnumRefAccess().getEnumKeyword_2()); 
            match(input,34,FOLLOW_34_in_rule__PEnumRef__Group__2__Impl3769); 
             after(grammarAccess.getPEnumRefAccess().getEnumKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__Group__2__Impl"


    // $ANTLR start "rule__PEnumRef__Group__3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1866:1: rule__PEnumRef__Group__3 : rule__PEnumRef__Group__3__Impl rule__PEnumRef__Group__4 ;
    public final void rule__PEnumRef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1870:1: ( rule__PEnumRef__Group__3__Impl rule__PEnumRef__Group__4 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1871:2: rule__PEnumRef__Group__3__Impl rule__PEnumRef__Group__4
            {
            pushFollow(FOLLOW_rule__PEnumRef__Group__3__Impl_in_rule__PEnumRef__Group__33800);
            rule__PEnumRef__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PEnumRef__Group__4_in_rule__PEnumRef__Group__33803);
            rule__PEnumRef__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__Group__3"


    // $ANTLR start "rule__PEnumRef__Group__3__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1878:1: rule__PEnumRef__Group__3__Impl : ( ( rule__PEnumRef__PenumAssignment_3 ) ) ;
    public final void rule__PEnumRef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1882:1: ( ( ( rule__PEnumRef__PenumAssignment_3 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1883:1: ( ( rule__PEnumRef__PenumAssignment_3 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1883:1: ( ( rule__PEnumRef__PenumAssignment_3 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1884:1: ( rule__PEnumRef__PenumAssignment_3 )
            {
             before(grammarAccess.getPEnumRefAccess().getPenumAssignment_3()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1885:1: ( rule__PEnumRef__PenumAssignment_3 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1885:2: rule__PEnumRef__PenumAssignment_3
            {
            pushFollow(FOLLOW_rule__PEnumRef__PenumAssignment_3_in_rule__PEnumRef__Group__3__Impl3830);
            rule__PEnumRef__PenumAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getPEnumRefAccess().getPenumAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__Group__3__Impl"


    // $ANTLR start "rule__PEnumRef__Group__4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1895:1: rule__PEnumRef__Group__4 : rule__PEnumRef__Group__4__Impl ;
    public final void rule__PEnumRef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1899:1: ( rule__PEnumRef__Group__4__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1900:2: rule__PEnumRef__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PEnumRef__Group__4__Impl_in_rule__PEnumRef__Group__43860);
            rule__PEnumRef__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__Group__4"


    // $ANTLR start "rule__PEnumRef__Group__4__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1906:1: rule__PEnumRef__Group__4__Impl : ( ( rule__PEnumRef__OptionalAssignment_4 )? ) ;
    public final void rule__PEnumRef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1910:1: ( ( ( rule__PEnumRef__OptionalAssignment_4 )? ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1911:1: ( ( rule__PEnumRef__OptionalAssignment_4 )? )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1911:1: ( ( rule__PEnumRef__OptionalAssignment_4 )? )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1912:1: ( rule__PEnumRef__OptionalAssignment_4 )?
            {
             before(grammarAccess.getPEnumRefAccess().getOptionalAssignment_4()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1913:1: ( rule__PEnumRef__OptionalAssignment_4 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==39) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1913:2: rule__PEnumRef__OptionalAssignment_4
                    {
                    pushFollow(FOLLOW_rule__PEnumRef__OptionalAssignment_4_in_rule__PEnumRef__Group__4__Impl3887);
                    rule__PEnumRef__OptionalAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPEnumRefAccess().getOptionalAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__Group__4__Impl"


    // $ANTLR start "rule__SubType__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1933:1: rule__SubType__Group__0 : rule__SubType__Group__0__Impl rule__SubType__Group__1 ;
    public final void rule__SubType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1937:1: ( rule__SubType__Group__0__Impl rule__SubType__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1938:2: rule__SubType__Group__0__Impl rule__SubType__Group__1
            {
            pushFollow(FOLLOW_rule__SubType__Group__0__Impl_in_rule__SubType__Group__03928);
            rule__SubType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubType__Group__1_in_rule__SubType__Group__03931);
            rule__SubType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__Group__0"


    // $ANTLR start "rule__SubType__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1945:1: rule__SubType__Group__0__Impl : ( 'SubType' ) ;
    public final void rule__SubType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1949:1: ( ( 'SubType' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1950:1: ( 'SubType' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1950:1: ( 'SubType' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1951:1: 'SubType'
            {
             before(grammarAccess.getSubTypeAccess().getSubTypeKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__SubType__Group__0__Impl3959); 
             after(grammarAccess.getSubTypeAccess().getSubTypeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__Group__0__Impl"


    // $ANTLR start "rule__SubType__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1964:1: rule__SubType__Group__1 : rule__SubType__Group__1__Impl rule__SubType__Group__2 ;
    public final void rule__SubType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1968:1: ( rule__SubType__Group__1__Impl rule__SubType__Group__2 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1969:2: rule__SubType__Group__1__Impl rule__SubType__Group__2
            {
            pushFollow(FOLLOW_rule__SubType__Group__1__Impl_in_rule__SubType__Group__13990);
            rule__SubType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubType__Group__2_in_rule__SubType__Group__13993);
            rule__SubType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__Group__1"


    // $ANTLR start "rule__SubType__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1976:1: rule__SubType__Group__1__Impl : ( ( rule__SubType__NameAssignment_1 ) ) ;
    public final void rule__SubType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1980:1: ( ( ( rule__SubType__NameAssignment_1 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1981:1: ( ( rule__SubType__NameAssignment_1 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1981:1: ( ( rule__SubType__NameAssignment_1 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1982:1: ( rule__SubType__NameAssignment_1 )
            {
             before(grammarAccess.getSubTypeAccess().getNameAssignment_1()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1983:1: ( rule__SubType__NameAssignment_1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1983:2: rule__SubType__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SubType__NameAssignment_1_in_rule__SubType__Group__1__Impl4020);
            rule__SubType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSubTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__Group__1__Impl"


    // $ANTLR start "rule__SubType__Group__2"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1993:1: rule__SubType__Group__2 : rule__SubType__Group__2__Impl rule__SubType__Group__3 ;
    public final void rule__SubType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1997:1: ( rule__SubType__Group__2__Impl rule__SubType__Group__3 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:1998:2: rule__SubType__Group__2__Impl rule__SubType__Group__3
            {
            pushFollow(FOLLOW_rule__SubType__Group__2__Impl_in_rule__SubType__Group__24050);
            rule__SubType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubType__Group__3_in_rule__SubType__Group__24053);
            rule__SubType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__Group__2"


    // $ANTLR start "rule__SubType__Group__2__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2005:1: rule__SubType__Group__2__Impl : ( '{' ) ;
    public final void rule__SubType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2009:1: ( ( '{' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2010:1: ( '{' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2010:1: ( '{' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2011:1: '{'
            {
             before(grammarAccess.getSubTypeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,28,FOLLOW_28_in_rule__SubType__Group__2__Impl4081); 
             after(grammarAccess.getSubTypeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__Group__2__Impl"


    // $ANTLR start "rule__SubType__Group__3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2024:1: rule__SubType__Group__3 : rule__SubType__Group__3__Impl rule__SubType__Group__4 ;
    public final void rule__SubType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2028:1: ( rule__SubType__Group__3__Impl rule__SubType__Group__4 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2029:2: rule__SubType__Group__3__Impl rule__SubType__Group__4
            {
            pushFollow(FOLLOW_rule__SubType__Group__3__Impl_in_rule__SubType__Group__34112);
            rule__SubType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubType__Group__4_in_rule__SubType__Group__34115);
            rule__SubType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__Group__3"


    // $ANTLR start "rule__SubType__Group__3__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2036:1: rule__SubType__Group__3__Impl : ( ( rule__SubType__AttributesAssignment_3 )* ) ;
    public final void rule__SubType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2040:1: ( ( ( rule__SubType__AttributesAssignment_3 )* ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2041:1: ( ( rule__SubType__AttributesAssignment_3 )* )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2041:1: ( ( rule__SubType__AttributesAssignment_3 )* )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2042:1: ( rule__SubType__AttributesAssignment_3 )*
            {
             before(grammarAccess.getSubTypeAccess().getAttributesAssignment_3()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2043:1: ( rule__SubType__AttributesAssignment_3 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1==30) ) {
                        int LA14_3 = input.LA(3);

                        if ( (LA14_3==RULE_ID||(LA14_3>=11 && LA14_3<=22)||LA14_3==38) ) {
                            alt14=1;
                        }


                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2043:2: rule__SubType__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__SubType__AttributesAssignment_3_in_rule__SubType__Group__3__Impl4142);
            	    rule__SubType__AttributesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getSubTypeAccess().getAttributesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__Group__3__Impl"


    // $ANTLR start "rule__SubType__Group__4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2053:1: rule__SubType__Group__4 : rule__SubType__Group__4__Impl rule__SubType__Group__5 ;
    public final void rule__SubType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2057:1: ( rule__SubType__Group__4__Impl rule__SubType__Group__5 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2058:2: rule__SubType__Group__4__Impl rule__SubType__Group__5
            {
            pushFollow(FOLLOW_rule__SubType__Group__4__Impl_in_rule__SubType__Group__44173);
            rule__SubType__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubType__Group__5_in_rule__SubType__Group__44176);
            rule__SubType__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__Group__4"


    // $ANTLR start "rule__SubType__Group__4__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2065:1: rule__SubType__Group__4__Impl : ( ( rule__SubType__EnumsAssignment_4 )* ) ;
    public final void rule__SubType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2069:1: ( ( ( rule__SubType__EnumsAssignment_4 )* ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2070:1: ( ( rule__SubType__EnumsAssignment_4 )* )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2070:1: ( ( rule__SubType__EnumsAssignment_4 )* )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2071:1: ( rule__SubType__EnumsAssignment_4 )*
            {
             before(grammarAccess.getSubTypeAccess().getEnumsAssignment_4()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2072:1: ( rule__SubType__EnumsAssignment_4 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2072:2: rule__SubType__EnumsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__SubType__EnumsAssignment_4_in_rule__SubType__Group__4__Impl4203);
            	    rule__SubType__EnumsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getSubTypeAccess().getEnumsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__Group__4__Impl"


    // $ANTLR start "rule__SubType__Group__5"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2082:1: rule__SubType__Group__5 : rule__SubType__Group__5__Impl ;
    public final void rule__SubType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2086:1: ( rule__SubType__Group__5__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2087:2: rule__SubType__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__SubType__Group__5__Impl_in_rule__SubType__Group__54234);
            rule__SubType__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__Group__5"


    // $ANTLR start "rule__SubType__Group__5__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2093:1: rule__SubType__Group__5__Impl : ( '}' ) ;
    public final void rule__SubType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2097:1: ( ( '}' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2098:1: ( '}' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2098:1: ( '}' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2099:1: '}'
            {
             before(grammarAccess.getSubTypeAccess().getRightCurlyBracketKeyword_5()); 
            match(input,29,FOLLOW_29_in_rule__SubType__Group__5__Impl4262); 
             after(grammarAccess.getSubTypeAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__Group__5__Impl"


    // $ANTLR start "rule__PEnum__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2124:1: rule__PEnum__Group__0 : rule__PEnum__Group__0__Impl rule__PEnum__Group__1 ;
    public final void rule__PEnum__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2128:1: ( rule__PEnum__Group__0__Impl rule__PEnum__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2129:2: rule__PEnum__Group__0__Impl rule__PEnum__Group__1
            {
            pushFollow(FOLLOW_rule__PEnum__Group__0__Impl_in_rule__PEnum__Group__04305);
            rule__PEnum__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PEnum__Group__1_in_rule__PEnum__Group__04308);
            rule__PEnum__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnum__Group__0"


    // $ANTLR start "rule__PEnum__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2136:1: rule__PEnum__Group__0__Impl : ( 'Enum' ) ;
    public final void rule__PEnum__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2140:1: ( ( 'Enum' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2141:1: ( 'Enum' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2141:1: ( 'Enum' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2142:1: 'Enum'
            {
             before(grammarAccess.getPEnumAccess().getEnumKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__PEnum__Group__0__Impl4336); 
             after(grammarAccess.getPEnumAccess().getEnumKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnum__Group__0__Impl"


    // $ANTLR start "rule__PEnum__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2155:1: rule__PEnum__Group__1 : rule__PEnum__Group__1__Impl rule__PEnum__Group__2 ;
    public final void rule__PEnum__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2159:1: ( rule__PEnum__Group__1__Impl rule__PEnum__Group__2 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2160:2: rule__PEnum__Group__1__Impl rule__PEnum__Group__2
            {
            pushFollow(FOLLOW_rule__PEnum__Group__1__Impl_in_rule__PEnum__Group__14367);
            rule__PEnum__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PEnum__Group__2_in_rule__PEnum__Group__14370);
            rule__PEnum__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnum__Group__1"


    // $ANTLR start "rule__PEnum__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2167:1: rule__PEnum__Group__1__Impl : ( ( rule__PEnum__NameAssignment_1 ) ) ;
    public final void rule__PEnum__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2171:1: ( ( ( rule__PEnum__NameAssignment_1 ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2172:1: ( ( rule__PEnum__NameAssignment_1 ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2172:1: ( ( rule__PEnum__NameAssignment_1 ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2173:1: ( rule__PEnum__NameAssignment_1 )
            {
             before(grammarAccess.getPEnumAccess().getNameAssignment_1()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2174:1: ( rule__PEnum__NameAssignment_1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2174:2: rule__PEnum__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PEnum__NameAssignment_1_in_rule__PEnum__Group__1__Impl4397);
            rule__PEnum__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPEnumAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnum__Group__1__Impl"


    // $ANTLR start "rule__PEnum__Group__2"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2184:1: rule__PEnum__Group__2 : rule__PEnum__Group__2__Impl rule__PEnum__Group__3 ;
    public final void rule__PEnum__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2188:1: ( rule__PEnum__Group__2__Impl rule__PEnum__Group__3 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2189:2: rule__PEnum__Group__2__Impl rule__PEnum__Group__3
            {
            pushFollow(FOLLOW_rule__PEnum__Group__2__Impl_in_rule__PEnum__Group__24427);
            rule__PEnum__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PEnum__Group__3_in_rule__PEnum__Group__24430);
            rule__PEnum__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnum__Group__2"


    // $ANTLR start "rule__PEnum__Group__2__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2196:1: rule__PEnum__Group__2__Impl : ( '{' ) ;
    public final void rule__PEnum__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2200:1: ( ( '{' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2201:1: ( '{' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2201:1: ( '{' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2202:1: '{'
            {
             before(grammarAccess.getPEnumAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,28,FOLLOW_28_in_rule__PEnum__Group__2__Impl4458); 
             after(grammarAccess.getPEnumAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnum__Group__2__Impl"


    // $ANTLR start "rule__PEnum__Group__3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2215:1: rule__PEnum__Group__3 : rule__PEnum__Group__3__Impl rule__PEnum__Group__4 ;
    public final void rule__PEnum__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2219:1: ( rule__PEnum__Group__3__Impl rule__PEnum__Group__4 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2220:2: rule__PEnum__Group__3__Impl rule__PEnum__Group__4
            {
            pushFollow(FOLLOW_rule__PEnum__Group__3__Impl_in_rule__PEnum__Group__34489);
            rule__PEnum__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PEnum__Group__4_in_rule__PEnum__Group__34492);
            rule__PEnum__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnum__Group__3"


    // $ANTLR start "rule__PEnum__Group__3__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2227:1: rule__PEnum__Group__3__Impl : ( ( rule__PEnum__ElementsAssignment_3 )* ) ;
    public final void rule__PEnum__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2231:1: ( ( ( rule__PEnum__ElementsAssignment_3 )* ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2232:1: ( ( rule__PEnum__ElementsAssignment_3 )* )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2232:1: ( ( rule__PEnum__ElementsAssignment_3 )* )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2233:1: ( rule__PEnum__ElementsAssignment_3 )*
            {
             before(grammarAccess.getPEnumAccess().getElementsAssignment_3()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2234:1: ( rule__PEnum__ElementsAssignment_3 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2234:2: rule__PEnum__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PEnum__ElementsAssignment_3_in_rule__PEnum__Group__3__Impl4519);
            	    rule__PEnum__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getPEnumAccess().getElementsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnum__Group__3__Impl"


    // $ANTLR start "rule__PEnum__Group__4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2244:1: rule__PEnum__Group__4 : rule__PEnum__Group__4__Impl ;
    public final void rule__PEnum__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2248:1: ( rule__PEnum__Group__4__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2249:2: rule__PEnum__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PEnum__Group__4__Impl_in_rule__PEnum__Group__44550);
            rule__PEnum__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnum__Group__4"


    // $ANTLR start "rule__PEnum__Group__4__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2255:1: rule__PEnum__Group__4__Impl : ( '}' ) ;
    public final void rule__PEnum__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2259:1: ( ( '}' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2260:1: ( '}' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2260:1: ( '}' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2261:1: '}'
            {
             before(grammarAccess.getPEnumAccess().getRightCurlyBracketKeyword_4()); 
            match(input,29,FOLLOW_29_in_rule__PEnum__Group__4__Impl4578); 
             after(grammarAccess.getPEnumAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnum__Group__4__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2284:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2288:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2289:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__04619);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__04622);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2296:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2300:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2301:1: ( RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2301:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2302:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl4649); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2313:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2317:1: ( rule__QualifiedName__Group__1__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2318:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__14678);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2324:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2328:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2329:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2329:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2330:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2331:1: ( rule__QualifiedName__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==37) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2331:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl4705);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2345:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2349:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2350:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__04740);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__04743);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2357:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2361:1: ( ( '.' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2362:1: ( '.' )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2362:1: ( '.' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2363:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,37,FOLLOW_37_in_rule__QualifiedName__Group_1__0__Impl4771); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2376:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2380:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2381:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__14802);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2387:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2391:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2392:1: ( RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2392:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2393:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl4829); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Model__GrammarNameAssignment_0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2409:1: rule__Model__GrammarNameAssignment_0 : ( ruleGrammarName ) ;
    public final void rule__Model__GrammarNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2413:1: ( ( ruleGrammarName ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2414:1: ( ruleGrammarName )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2414:1: ( ruleGrammarName )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2415:1: ruleGrammarName
            {
             before(grammarAccess.getModelAccess().getGrammarNameGrammarNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleGrammarName_in_rule__Model__GrammarNameAssignment_04867);
            ruleGrammarName();

            state._fsp--;

             after(grammarAccess.getModelAccess().getGrammarNameGrammarNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__GrammarNameAssignment_0"


    // $ANTLR start "rule__Model__PackageAssignment_1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2424:1: rule__Model__PackageAssignment_1 : ( rulePackageDeclaration ) ;
    public final void rule__Model__PackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2428:1: ( ( rulePackageDeclaration ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2429:1: ( rulePackageDeclaration )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2429:1: ( rulePackageDeclaration )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2430:1: rulePackageDeclaration
            {
             before(grammarAccess.getModelAccess().getPackagePackageDeclarationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_rulePackageDeclaration_in_rule__Model__PackageAssignment_14898);
            rulePackageDeclaration();

            state._fsp--;

             after(grammarAccess.getModelAccess().getPackagePackageDeclarationParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__PackageAssignment_1"


    // $ANTLR start "rule__Model__RootClassAssignment_2"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2439:1: rule__Model__RootClassAssignment_2 : ( ruleRootClass ) ;
    public final void rule__Model__RootClassAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2443:1: ( ( ruleRootClass ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2444:1: ( ruleRootClass )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2444:1: ( ruleRootClass )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2445:1: ruleRootClass
            {
             before(grammarAccess.getModelAccess().getRootClassRootClassParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleRootClass_in_rule__Model__RootClassAssignment_24929);
            ruleRootClass();

            state._fsp--;

             after(grammarAccess.getModelAccess().getRootClassRootClassParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__RootClassAssignment_2"


    // $ANTLR start "rule__Model__DateTimeFormatAssignment_3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2454:1: rule__Model__DateTimeFormatAssignment_3 : ( ruleDateTimeFormat ) ;
    public final void rule__Model__DateTimeFormatAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2458:1: ( ( ruleDateTimeFormat ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2459:1: ( ruleDateTimeFormat )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2459:1: ( ruleDateTimeFormat )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2460:1: ruleDateTimeFormat
            {
             before(grammarAccess.getModelAccess().getDateTimeFormatDateTimeFormatParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDateTimeFormat_in_rule__Model__DateTimeFormatAssignment_34960);
            ruleDateTimeFormat();

            state._fsp--;

             after(grammarAccess.getModelAccess().getDateTimeFormatDateTimeFormatParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DateTimeFormatAssignment_3"


    // $ANTLR start "rule__Model__MessagesAssignment_4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2469:1: rule__Model__MessagesAssignment_4 : ( ruleMessage ) ;
    public final void rule__Model__MessagesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2473:1: ( ( ruleMessage ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2474:1: ( ruleMessage )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2474:1: ( ruleMessage )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2475:1: ruleMessage
            {
             before(grammarAccess.getModelAccess().getMessagesMessageParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleMessage_in_rule__Model__MessagesAssignment_44991);
            ruleMessage();

            state._fsp--;

             after(grammarAccess.getModelAccess().getMessagesMessageParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__MessagesAssignment_4"


    // $ANTLR start "rule__Model__SubTypesAssignment_5"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2484:1: rule__Model__SubTypesAssignment_5 : ( ruleSubType ) ;
    public final void rule__Model__SubTypesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2488:1: ( ( ruleSubType ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2489:1: ( ruleSubType )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2489:1: ( ruleSubType )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2490:1: ruleSubType
            {
             before(grammarAccess.getModelAccess().getSubTypesSubTypeParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSubType_in_rule__Model__SubTypesAssignment_55022);
            ruleSubType();

            state._fsp--;

             after(grammarAccess.getModelAccess().getSubTypesSubTypeParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__SubTypesAssignment_5"


    // $ANTLR start "rule__Model__PenumsAssignment_6"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2499:1: rule__Model__PenumsAssignment_6 : ( rulePEnum ) ;
    public final void rule__Model__PenumsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2503:1: ( ( rulePEnum ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2504:1: ( rulePEnum )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2504:1: ( rulePEnum )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2505:1: rulePEnum
            {
             before(grammarAccess.getModelAccess().getPenumsPEnumParserRuleCall_6_0()); 
            pushFollow(FOLLOW_rulePEnum_in_rule__Model__PenumsAssignment_65053);
            rulePEnum();

            state._fsp--;

             after(grammarAccess.getModelAccess().getPenumsPEnumParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__PenumsAssignment_6"


    // $ANTLR start "rule__GrammarName__NameAssignment_1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2514:1: rule__GrammarName__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__GrammarName__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2518:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2519:1: ( RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2519:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2520:1: RULE_ID
            {
             before(grammarAccess.getGrammarNameAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GrammarName__NameAssignment_15084); 
             after(grammarAccess.getGrammarNameAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarName__NameAssignment_1"


    // $ANTLR start "rule__PackageDeclaration__NameAssignment_1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2529:1: rule__PackageDeclaration__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2533:1: ( ( ruleQualifiedName ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2534:1: ( ruleQualifiedName )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2534:1: ( ruleQualifiedName )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2535:1: ruleQualifiedName
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_15115);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__NameAssignment_1"


    // $ANTLR start "rule__RootClass__NameAssignment_1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2544:1: rule__RootClass__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RootClass__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2548:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2549:1: ( RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2549:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2550:1: RULE_ID
            {
             before(grammarAccess.getRootClassAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RootClass__NameAssignment_15146); 
             after(grammarAccess.getRootClassAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootClass__NameAssignment_1"


    // $ANTLR start "rule__DateTimeFormat__DateTimeFormatAssignment_1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2559:1: rule__DateTimeFormat__DateTimeFormatAssignment_1 : ( RULE_STRING ) ;
    public final void rule__DateTimeFormat__DateTimeFormatAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2563:1: ( ( RULE_STRING ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2564:1: ( RULE_STRING )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2564:1: ( RULE_STRING )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2565:1: RULE_STRING
            {
             before(grammarAccess.getDateTimeFormatAccess().getDateTimeFormatSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DateTimeFormat__DateTimeFormatAssignment_15177); 
             after(grammarAccess.getDateTimeFormatAccess().getDateTimeFormatSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateTimeFormat__DateTimeFormatAssignment_1"


    // $ANTLR start "rule__Message__NameAssignment_1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2574:1: rule__Message__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Message__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2578:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2579:1: ( RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2579:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2580:1: RULE_ID
            {
             before(grammarAccess.getMessageAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Message__NameAssignment_15208); 
             after(grammarAccess.getMessageAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__NameAssignment_1"


    // $ANTLR start "rule__Message__AttributesAssignment_3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2589:1: rule__Message__AttributesAssignment_3 : ( ruleAbstractAttribute ) ;
    public final void rule__Message__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2593:1: ( ( ruleAbstractAttribute ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2594:1: ( ruleAbstractAttribute )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2594:1: ( ruleAbstractAttribute )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2595:1: ruleAbstractAttribute
            {
             before(grammarAccess.getMessageAccess().getAttributesAbstractAttributeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleAbstractAttribute_in_rule__Message__AttributesAssignment_35239);
            ruleAbstractAttribute();

            state._fsp--;

             after(grammarAccess.getMessageAccess().getAttributesAbstractAttributeParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__AttributesAssignment_3"


    // $ANTLR start "rule__Message__EnumsAssignment_4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2604:1: rule__Message__EnumsAssignment_4 : ( rulePEnumRef ) ;
    public final void rule__Message__EnumsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2608:1: ( ( rulePEnumRef ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2609:1: ( rulePEnumRef )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2609:1: ( rulePEnumRef )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2610:1: rulePEnumRef
            {
             before(grammarAccess.getMessageAccess().getEnumsPEnumRefParserRuleCall_4_0()); 
            pushFollow(FOLLOW_rulePEnumRef_in_rule__Message__EnumsAssignment_45270);
            rulePEnumRef();

            state._fsp--;

             after(grammarAccess.getMessageAccess().getEnumsPEnumRefParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__EnumsAssignment_4"


    // $ANTLR start "rule__Attribute__NameAssignment_0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2619:1: rule__Attribute__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2623:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2624:1: ( RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2624:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2625:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_05301); 
             after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__NameAssignment_0"


    // $ANTLR start "rule__Attribute__ListOfAssignment_2"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2634:1: rule__Attribute__ListOfAssignment_2 : ( ruleListOf ) ;
    public final void rule__Attribute__ListOfAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2638:1: ( ( ruleListOf ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2639:1: ( ruleListOf )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2639:1: ( ruleListOf )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2640:1: ruleListOf
            {
             before(grammarAccess.getAttributeAccess().getListOfListOfParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleListOf_in_rule__Attribute__ListOfAssignment_25332);
            ruleListOf();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getListOfListOfParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__ListOfAssignment_2"


    // $ANTLR start "rule__Attribute__AttributeTypeAssignment_3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2649:1: rule__Attribute__AttributeTypeAssignment_3 : ( ruleAttributeType ) ;
    public final void rule__Attribute__AttributeTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2653:1: ( ( ruleAttributeType ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2654:1: ( ruleAttributeType )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2654:1: ( ruleAttributeType )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2655:1: ruleAttributeType
            {
             before(grammarAccess.getAttributeAccess().getAttributeTypeAttributeTypeEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleAttributeType_in_rule__Attribute__AttributeTypeAssignment_35363);
            ruleAttributeType();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getAttributeTypeAttributeTypeEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__AttributeTypeAssignment_3"


    // $ANTLR start "rule__Attribute__OptionalAssignment_4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2664:1: rule__Attribute__OptionalAssignment_4 : ( ruleOptional ) ;
    public final void rule__Attribute__OptionalAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2668:1: ( ( ruleOptional ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2669:1: ( ruleOptional )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2669:1: ( ruleOptional )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2670:1: ruleOptional
            {
             before(grammarAccess.getAttributeAccess().getOptionalOptionalParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleOptional_in_rule__Attribute__OptionalAssignment_45394);
            ruleOptional();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getOptionalOptionalParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__OptionalAssignment_4"


    // $ANTLR start "rule__ListOf__ListOfAssignment_0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2679:1: rule__ListOf__ListOfAssignment_0 : ( ( 'list' ) ) ;
    public final void rule__ListOf__ListOfAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2683:1: ( ( ( 'list' ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2684:1: ( ( 'list' ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2684:1: ( ( 'list' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2685:1: ( 'list' )
            {
             before(grammarAccess.getListOfAccess().getListOfListKeyword_0_0()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2686:1: ( 'list' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2687:1: 'list'
            {
             before(grammarAccess.getListOfAccess().getListOfListKeyword_0_0()); 
            match(input,38,FOLLOW_38_in_rule__ListOf__ListOfAssignment_05430); 
             after(grammarAccess.getListOfAccess().getListOfListKeyword_0_0()); 

            }

             after(grammarAccess.getListOfAccess().getListOfListKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOf__ListOfAssignment_0"


    // $ANTLR start "rule__Optional__OptionalAssignment_0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2702:1: rule__Optional__OptionalAssignment_0 : ( ( '(' ) ) ;
    public final void rule__Optional__OptionalAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2706:1: ( ( ( '(' ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2707:1: ( ( '(' ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2707:1: ( ( '(' ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2708:1: ( '(' )
            {
             before(grammarAccess.getOptionalAccess().getOptionalLeftParenthesisKeyword_0_0()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2709:1: ( '(' )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2710:1: '('
            {
             before(grammarAccess.getOptionalAccess().getOptionalLeftParenthesisKeyword_0_0()); 
            match(input,39,FOLLOW_39_in_rule__Optional__OptionalAssignment_05474); 
             after(grammarAccess.getOptionalAccess().getOptionalLeftParenthesisKeyword_0_0()); 

            }

             after(grammarAccess.getOptionalAccess().getOptionalLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Optional__OptionalAssignment_0"


    // $ANTLR start "rule__SubTypeRef__NameAssignment_0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2725:1: rule__SubTypeRef__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__SubTypeRef__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2729:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2730:1: ( RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2730:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2731:1: RULE_ID
            {
             before(grammarAccess.getSubTypeRefAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubTypeRef__NameAssignment_05513); 
             after(grammarAccess.getSubTypeRefAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__NameAssignment_0"


    // $ANTLR start "rule__SubTypeRef__ListOfAssignment_2"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2740:1: rule__SubTypeRef__ListOfAssignment_2 : ( ruleListOf ) ;
    public final void rule__SubTypeRef__ListOfAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2744:1: ( ( ruleListOf ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2745:1: ( ruleListOf )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2745:1: ( ruleListOf )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2746:1: ruleListOf
            {
             before(grammarAccess.getSubTypeRefAccess().getListOfListOfParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleListOf_in_rule__SubTypeRef__ListOfAssignment_25544);
            ruleListOf();

            state._fsp--;

             after(grammarAccess.getSubTypeRefAccess().getListOfListOfParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__ListOfAssignment_2"


    // $ANTLR start "rule__SubTypeRef__SubTypeAssignment_3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2755:1: rule__SubTypeRef__SubTypeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__SubTypeRef__SubTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2759:1: ( ( ( RULE_ID ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2760:1: ( ( RULE_ID ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2760:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2761:1: ( RULE_ID )
            {
             before(grammarAccess.getSubTypeRefAccess().getSubTypeSubTypeCrossReference_3_0()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2762:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2763:1: RULE_ID
            {
             before(grammarAccess.getSubTypeRefAccess().getSubTypeSubTypeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubTypeRef__SubTypeAssignment_35579); 
             after(grammarAccess.getSubTypeRefAccess().getSubTypeSubTypeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getSubTypeRefAccess().getSubTypeSubTypeCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__SubTypeAssignment_3"


    // $ANTLR start "rule__SubTypeRef__OptionalAssignment_4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2774:1: rule__SubTypeRef__OptionalAssignment_4 : ( ruleOptional ) ;
    public final void rule__SubTypeRef__OptionalAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2778:1: ( ( ruleOptional ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2779:1: ( ruleOptional )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2779:1: ( ruleOptional )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2780:1: ruleOptional
            {
             before(grammarAccess.getSubTypeRefAccess().getOptionalOptionalParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleOptional_in_rule__SubTypeRef__OptionalAssignment_45614);
            ruleOptional();

            state._fsp--;

             after(grammarAccess.getSubTypeRefAccess().getOptionalOptionalParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeRef__OptionalAssignment_4"


    // $ANTLR start "rule__PEnumRef__NameAssignment_0"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2789:1: rule__PEnumRef__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__PEnumRef__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2793:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2794:1: ( RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2794:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2795:1: RULE_ID
            {
             before(grammarAccess.getPEnumRefAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PEnumRef__NameAssignment_05645); 
             after(grammarAccess.getPEnumRefAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__NameAssignment_0"


    // $ANTLR start "rule__PEnumRef__PenumAssignment_3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2804:1: rule__PEnumRef__PenumAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__PEnumRef__PenumAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2808:1: ( ( ( RULE_ID ) ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2809:1: ( ( RULE_ID ) )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2809:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2810:1: ( RULE_ID )
            {
             before(grammarAccess.getPEnumRefAccess().getPenumPEnumCrossReference_3_0()); 
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2811:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2812:1: RULE_ID
            {
             before(grammarAccess.getPEnumRefAccess().getPenumPEnumIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PEnumRef__PenumAssignment_35680); 
             after(grammarAccess.getPEnumRefAccess().getPenumPEnumIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getPEnumRefAccess().getPenumPEnumCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__PenumAssignment_3"


    // $ANTLR start "rule__PEnumRef__OptionalAssignment_4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2823:1: rule__PEnumRef__OptionalAssignment_4 : ( ruleOptional ) ;
    public final void rule__PEnumRef__OptionalAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2827:1: ( ( ruleOptional ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2828:1: ( ruleOptional )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2828:1: ( ruleOptional )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2829:1: ruleOptional
            {
             before(grammarAccess.getPEnumRefAccess().getOptionalOptionalParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleOptional_in_rule__PEnumRef__OptionalAssignment_45715);
            ruleOptional();

            state._fsp--;

             after(grammarAccess.getPEnumRefAccess().getOptionalOptionalParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumRef__OptionalAssignment_4"


    // $ANTLR start "rule__SubType__NameAssignment_1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2838:1: rule__SubType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SubType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2842:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2843:1: ( RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2843:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2844:1: RULE_ID
            {
             before(grammarAccess.getSubTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubType__NameAssignment_15746); 
             after(grammarAccess.getSubTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__NameAssignment_1"


    // $ANTLR start "rule__SubType__AttributesAssignment_3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2853:1: rule__SubType__AttributesAssignment_3 : ( ruleAbstractAttribute ) ;
    public final void rule__SubType__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2857:1: ( ( ruleAbstractAttribute ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2858:1: ( ruleAbstractAttribute )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2858:1: ( ruleAbstractAttribute )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2859:1: ruleAbstractAttribute
            {
             before(grammarAccess.getSubTypeAccess().getAttributesAbstractAttributeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleAbstractAttribute_in_rule__SubType__AttributesAssignment_35777);
            ruleAbstractAttribute();

            state._fsp--;

             after(grammarAccess.getSubTypeAccess().getAttributesAbstractAttributeParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__AttributesAssignment_3"


    // $ANTLR start "rule__SubType__EnumsAssignment_4"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2868:1: rule__SubType__EnumsAssignment_4 : ( rulePEnumRef ) ;
    public final void rule__SubType__EnumsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2872:1: ( ( rulePEnumRef ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2873:1: ( rulePEnumRef )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2873:1: ( rulePEnumRef )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2874:1: rulePEnumRef
            {
             before(grammarAccess.getSubTypeAccess().getEnumsPEnumRefParserRuleCall_4_0()); 
            pushFollow(FOLLOW_rulePEnumRef_in_rule__SubType__EnumsAssignment_45808);
            rulePEnumRef();

            state._fsp--;

             after(grammarAccess.getSubTypeAccess().getEnumsPEnumRefParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubType__EnumsAssignment_4"


    // $ANTLR start "rule__PEnum__NameAssignment_1"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2883:1: rule__PEnum__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PEnum__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2887:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2888:1: ( RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2888:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2889:1: RULE_ID
            {
             before(grammarAccess.getPEnumAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PEnum__NameAssignment_15839); 
             after(grammarAccess.getPEnumAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnum__NameAssignment_1"


    // $ANTLR start "rule__PEnum__ElementsAssignment_3"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2898:1: rule__PEnum__ElementsAssignment_3 : ( rulePEnumElement ) ;
    public final void rule__PEnum__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2902:1: ( ( rulePEnumElement ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2903:1: ( rulePEnumElement )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2903:1: ( rulePEnumElement )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2904:1: rulePEnumElement
            {
             before(grammarAccess.getPEnumAccess().getElementsPEnumElementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_rulePEnumElement_in_rule__PEnum__ElementsAssignment_35870);
            rulePEnumElement();

            state._fsp--;

             after(grammarAccess.getPEnumAccess().getElementsPEnumElementParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnum__ElementsAssignment_3"


    // $ANTLR start "rule__PEnumElement__NameAssignment"
    // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2913:1: rule__PEnumElement__NameAssignment : ( RULE_ID ) ;
    public final void rule__PEnumElement__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2917:1: ( ( RULE_ID ) )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2918:1: ( RULE_ID )
            {
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2918:1: ( RULE_ID )
            // ../com.viacron.utils.bbb.ByteByByte.ui/src-gen/com/viacron/utils/bbb/ui/contentassist/antlr/internal/InternalByteByByte.g:2919:1: RULE_ID
            {
             before(grammarAccess.getPEnumElementAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PEnumElement__NameAssignment5901); 
             after(grammarAccess.getPEnumElementAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEnumElement__NameAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGrammarName_in_entryRuleGrammarName121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammarName128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GrammarName__Group__0_in_ruleGrammarName154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDeclaration188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__0_in_rulePackageDeclaration214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRootClass_in_entryRuleRootClass241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRootClass248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RootClass__Group__0_in_ruleRootClass274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeFormat_in_entryRuleDateTimeFormat301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateTimeFormat308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateTimeFormat__Group__0_in_ruleDateTimeFormat334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessage_in_entryRuleMessage361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessage368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Message__Group__0_in_ruleMessage394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAttribute_in_entryRuleAbstractAttribute421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractAttribute428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractAttribute__Alternatives_in_ruleAbstractAttribute454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__Group__0_in_ruleAttribute514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOf_in_entryRuleListOf541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOf548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOf__Group__0_in_ruleListOf574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptional_in_entryRuleOptional601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptional608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Optional__Group__0_in_ruleOptional634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubTypeRef_in_entryRuleSubTypeRef661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubTypeRef668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubTypeRef__Group__0_in_ruleSubTypeRef694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePEnumRef_in_entryRulePEnumRef721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePEnumRef728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnumRef__Group__0_in_rulePEnumRef754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubType_in_entryRuleSubType781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubType788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubType__Group__0_in_ruleSubType814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePEnum_in_entryRulePEnum841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePEnum848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnum__Group__0_in_rulePEnum874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePEnumElement_in_entryRulePEnumElement901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePEnumElement908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnumElement__NameAssignment_in_rulePEnumElement934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeType__Alternatives_in_ruleAttributeType1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_rule__AbstractAttribute__Alternatives1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubTypeRef_in_rule__AbstractAttribute__Alternatives1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__AttributeType__Alternatives1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__AttributeType__Alternatives1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__AttributeType__Alternatives1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__AttributeType__Alternatives1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__AttributeType__Alternatives1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__AttributeType__Alternatives1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__AttributeType__Alternatives1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__AttributeType__Alternatives1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AttributeType__Alternatives1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__AttributeType__Alternatives1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__AttributeType__Alternatives1326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__AttributeType__Alternatives1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__01380 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__GrammarNameAssignment_0_in_rule__Model__Group__0__Impl1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11440 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__11443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__PackageAssignment_1_in_rule__Model__Group__1__Impl1470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__21500 = new BitSet(new long[]{0x000000180C000000L});
    public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__21503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__RootClassAssignment_2_in_rule__Model__Group__2__Impl1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__31560 = new BitSet(new long[]{0x000000180C000000L});
    public static final BitSet FOLLOW_rule__Model__Group__4_in_rule__Model__Group__31563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DateTimeFormatAssignment_3_in_rule__Model__Group__3__Impl1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__41621 = new BitSet(new long[]{0x000000180C000000L});
    public static final BitSet FOLLOW_rule__Model__Group__5_in_rule__Model__Group__41624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__MessagesAssignment_4_in_rule__Model__Group__4__Impl1651 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__51682 = new BitSet(new long[]{0x000000180C000000L});
    public static final BitSet FOLLOW_rule__Model__Group__6_in_rule__Model__Group__51685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__SubTypesAssignment_5_in_rule__Model__Group__5__Impl1712 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__Model__Group__6__Impl_in_rule__Model__Group__61743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__PenumsAssignment_6_in_rule__Model__Group__6__Impl1770 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__GrammarName__Group__0__Impl_in_rule__GrammarName__Group__01815 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__GrammarName__Group__1_in_rule__GrammarName__Group__01818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__GrammarName__Group__0__Impl1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GrammarName__Group__1__Impl_in_rule__GrammarName__Group__11877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GrammarName__NameAssignment_1_in_rule__GrammarName__Group__1__Impl1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__0__Impl_in_rule__PackageDeclaration__Group__01938 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__01941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__PackageDeclaration__Group__0__Impl1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1__Impl_in_rule__PackageDeclaration__Group__12000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__1__Impl2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RootClass__Group__0__Impl_in_rule__RootClass__Group__02061 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RootClass__Group__1_in_rule__RootClass__Group__02064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__RootClass__Group__0__Impl2092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RootClass__Group__1__Impl_in_rule__RootClass__Group__12123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RootClass__NameAssignment_1_in_rule__RootClass__Group__1__Impl2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateTimeFormat__Group__0__Impl_in_rule__DateTimeFormat__Group__02184 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DateTimeFormat__Group__1_in_rule__DateTimeFormat__Group__02187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__DateTimeFormat__Group__0__Impl2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateTimeFormat__Group__1__Impl_in_rule__DateTimeFormat__Group__12246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateTimeFormat__DateTimeFormatAssignment_1_in_rule__DateTimeFormat__Group__1__Impl2273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Message__Group__0__Impl_in_rule__Message__Group__02307 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Message__Group__1_in_rule__Message__Group__02310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Message__Group__0__Impl2338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Message__Group__1__Impl_in_rule__Message__Group__12369 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Message__Group__2_in_rule__Message__Group__12372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Message__NameAssignment_1_in_rule__Message__Group__1__Impl2399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Message__Group__2__Impl_in_rule__Message__Group__22429 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rule__Message__Group__3_in_rule__Message__Group__22432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Message__Group__2__Impl2460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Message__Group__3__Impl_in_rule__Message__Group__32491 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rule__Message__Group__4_in_rule__Message__Group__32494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Message__AttributesAssignment_3_in_rule__Message__Group__3__Impl2521 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Message__Group__4__Impl_in_rule__Message__Group__42552 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rule__Message__Group__5_in_rule__Message__Group__42555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Message__EnumsAssignment_4_in_rule__Message__Group__4__Impl2582 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Message__Group__5__Impl_in_rule__Message__Group__52613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Message__Group__5__Impl2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__Group__0__Impl_in_rule__Attribute__Group__02684 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__02687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__NameAssignment_0_in_rule__Attribute__Group__0__Impl2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__Group__1__Impl_in_rule__Attribute__Group__12744 = new BitSet(new long[]{0x00000040007FF800L});
    public static final BitSet FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__12747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Attribute__Group__1__Impl2775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__Group__2__Impl_in_rule__Attribute__Group__22806 = new BitSet(new long[]{0x00000040007FF800L});
    public static final BitSet FOLLOW_rule__Attribute__Group__3_in_rule__Attribute__Group__22809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__ListOfAssignment_2_in_rule__Attribute__Group__2__Impl2836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__Group__3__Impl_in_rule__Attribute__Group__32867 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Attribute__Group__4_in_rule__Attribute__Group__32870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__AttributeTypeAssignment_3_in_rule__Attribute__Group__3__Impl2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__Group__4__Impl_in_rule__Attribute__Group__42927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__OptionalAssignment_4_in_rule__Attribute__Group__4__Impl2954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOf__Group__0__Impl_in_rule__ListOf__Group__02995 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ListOf__Group__1_in_rule__ListOf__Group__02998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOf__ListOfAssignment_0_in_rule__ListOf__Group__0__Impl3025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOf__Group__1__Impl_in_rule__ListOf__Group__13055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ListOf__Group__1__Impl3083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Optional__Group__0__Impl_in_rule__Optional__Group__03118 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Optional__Group__1_in_rule__Optional__Group__03121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Optional__OptionalAssignment_0_in_rule__Optional__Group__0__Impl3148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Optional__Group__1__Impl_in_rule__Optional__Group__13178 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Optional__Group__2_in_rule__Optional__Group__13181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Optional__Group__1__Impl3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Optional__Group__2__Impl_in_rule__Optional__Group__23240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Optional__Group__2__Impl3268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubTypeRef__Group__0__Impl_in_rule__SubTypeRef__Group__03305 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__SubTypeRef__Group__1_in_rule__SubTypeRef__Group__03308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubTypeRef__NameAssignment_0_in_rule__SubTypeRef__Group__0__Impl3335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubTypeRef__Group__1__Impl_in_rule__SubTypeRef__Group__13365 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_rule__SubTypeRef__Group__2_in_rule__SubTypeRef__Group__13368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__SubTypeRef__Group__1__Impl3396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubTypeRef__Group__2__Impl_in_rule__SubTypeRef__Group__23427 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_rule__SubTypeRef__Group__3_in_rule__SubTypeRef__Group__23430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubTypeRef__ListOfAssignment_2_in_rule__SubTypeRef__Group__2__Impl3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubTypeRef__Group__3__Impl_in_rule__SubTypeRef__Group__33488 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__SubTypeRef__Group__4_in_rule__SubTypeRef__Group__33491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubTypeRef__SubTypeAssignment_3_in_rule__SubTypeRef__Group__3__Impl3518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubTypeRef__Group__4__Impl_in_rule__SubTypeRef__Group__43548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubTypeRef__OptionalAssignment_4_in_rule__SubTypeRef__Group__4__Impl3575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnumRef__Group__0__Impl_in_rule__PEnumRef__Group__03616 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__PEnumRef__Group__1_in_rule__PEnumRef__Group__03619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnumRef__NameAssignment_0_in_rule__PEnumRef__Group__0__Impl3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnumRef__Group__1__Impl_in_rule__PEnumRef__Group__13676 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__PEnumRef__Group__2_in_rule__PEnumRef__Group__13679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__PEnumRef__Group__1__Impl3707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnumRef__Group__2__Impl_in_rule__PEnumRef__Group__23738 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PEnumRef__Group__3_in_rule__PEnumRef__Group__23741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__PEnumRef__Group__2__Impl3769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnumRef__Group__3__Impl_in_rule__PEnumRef__Group__33800 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__PEnumRef__Group__4_in_rule__PEnumRef__Group__33803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnumRef__PenumAssignment_3_in_rule__PEnumRef__Group__3__Impl3830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnumRef__Group__4__Impl_in_rule__PEnumRef__Group__43860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnumRef__OptionalAssignment_4_in_rule__PEnumRef__Group__4__Impl3887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubType__Group__0__Impl_in_rule__SubType__Group__03928 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SubType__Group__1_in_rule__SubType__Group__03931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__SubType__Group__0__Impl3959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubType__Group__1__Impl_in_rule__SubType__Group__13990 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__SubType__Group__2_in_rule__SubType__Group__13993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubType__NameAssignment_1_in_rule__SubType__Group__1__Impl4020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubType__Group__2__Impl_in_rule__SubType__Group__24050 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rule__SubType__Group__3_in_rule__SubType__Group__24053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SubType__Group__2__Impl4081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubType__Group__3__Impl_in_rule__SubType__Group__34112 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rule__SubType__Group__4_in_rule__SubType__Group__34115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubType__AttributesAssignment_3_in_rule__SubType__Group__3__Impl4142 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SubType__Group__4__Impl_in_rule__SubType__Group__44173 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rule__SubType__Group__5_in_rule__SubType__Group__44176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubType__EnumsAssignment_4_in_rule__SubType__Group__4__Impl4203 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SubType__Group__5__Impl_in_rule__SubType__Group__54234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__SubType__Group__5__Impl4262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnum__Group__0__Impl_in_rule__PEnum__Group__04305 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PEnum__Group__1_in_rule__PEnum__Group__04308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PEnum__Group__0__Impl4336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnum__Group__1__Impl_in_rule__PEnum__Group__14367 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PEnum__Group__2_in_rule__PEnum__Group__14370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnum__NameAssignment_1_in_rule__PEnum__Group__1__Impl4397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnum__Group__2__Impl_in_rule__PEnum__Group__24427 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rule__PEnum__Group__3_in_rule__PEnum__Group__24430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PEnum__Group__2__Impl4458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnum__Group__3__Impl_in_rule__PEnum__Group__34489 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rule__PEnum__Group__4_in_rule__PEnum__Group__34492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PEnum__ElementsAssignment_3_in_rule__PEnum__Group__3__Impl4519 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__PEnum__Group__4__Impl_in_rule__PEnum__Group__44550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__PEnum__Group__4__Impl4578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__04619 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__04622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl4649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__14678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl4705 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__04740 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__04743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__QualifiedName__Group_1__0__Impl4771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__14802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl4829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGrammarName_in_rule__Model__GrammarNameAssignment_04867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDeclaration_in_rule__Model__PackageAssignment_14898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRootClass_in_rule__Model__RootClassAssignment_24929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeFormat_in_rule__Model__DateTimeFormatAssignment_34960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessage_in_rule__Model__MessagesAssignment_44991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubType_in_rule__Model__SubTypesAssignment_55022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePEnum_in_rule__Model__PenumsAssignment_65053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarName__NameAssignment_15084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_15115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RootClass__NameAssignment_15146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DateTimeFormat__DateTimeFormatAssignment_15177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Message__NameAssignment_15208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAttribute_in_rule__Message__AttributesAssignment_35239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePEnumRef_in_rule__Message__EnumsAssignment_45270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_05301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOf_in_rule__Attribute__ListOfAssignment_25332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeType_in_rule__Attribute__AttributeTypeAssignment_35363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptional_in_rule__Attribute__OptionalAssignment_45394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ListOf__ListOfAssignment_05430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Optional__OptionalAssignment_05474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubTypeRef__NameAssignment_05513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOf_in_rule__SubTypeRef__ListOfAssignment_25544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubTypeRef__SubTypeAssignment_35579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptional_in_rule__SubTypeRef__OptionalAssignment_45614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PEnumRef__NameAssignment_05645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PEnumRef__PenumAssignment_35680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptional_in_rule__PEnumRef__OptionalAssignment_45715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubType__NameAssignment_15746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAttribute_in_rule__SubType__AttributesAssignment_35777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePEnumRef_in_rule__SubType__EnumsAssignment_45808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PEnum__NameAssignment_15839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePEnumElement_in_rule__PEnum__ElementsAssignment_35870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PEnumElement__NameAssignment5901 = new BitSet(new long[]{0x0000000000000002L});

}