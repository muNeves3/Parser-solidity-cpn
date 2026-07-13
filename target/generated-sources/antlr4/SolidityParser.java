// Generated from SolidityParser.g4 by ANTLR 4.13.1

package sol_rdp.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SolidityParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ReservedKeywords=1, Abstract=2, Address=3, Anonymous=4, As=5, Assembly=6, 
		Bool=7, Break=8, Bytes=9, Calldata=10, Catch=11, Constant=12, Constructor=13, 
		Continue=14, Contract=15, Delete=16, Do=17, Else=18, Emit=19, Enum=20, 
		Error=21, Event=22, External=23, Fallback=24, FalseLiteral=25, Fixed=26, 
		FixedBytes=27, For=28, From=29, Function=30, Global=31, Hex=32, If=33, 
		Immutable=34, Import=35, Indexed=36, Interface=37, Internal=38, Is=39, 
		Library=40, Mapping=41, Memory=42, Modifier=43, New=44, SubDenomination=45, 
		Override=46, Payable=47, Pragma=48, Private=49, Public=50, Pure=51, Receive=52, 
		Return=53, Returns=54, Revert=55, SignedIntegerType=56, Storage=57, String=58, 
		Struct=59, Transient=60, TrueLiteral=61, Try=62, Type=63, Ufixed=64, Unchecked=65, 
		Unicode=66, UnsignedIntegerType=67, Using=68, View=69, Virtual=70, While=71, 
		LParen=72, RParen=73, LBrack=74, RBrack=75, LBrace=76, RBrace=77, Colon=78, 
		Semicolon=79, Period=80, Conditional=81, DoubleArrow=82, RightArrow=83, 
		Assign=84, AssignBitOr=85, AssignBitXor=86, AssignBitAnd=87, AssignShl=88, 
		AssignSar=89, AssignShr=90, AssignAdd=91, AssignSub=92, AssignMul=93, 
		AssignDiv=94, AssignMod=95, Comma=96, Or=97, And=98, BitOr=99, BitXor=100, 
		BitAnd=101, Shl=102, Sar=103, Shr=104, Add=105, Sub=106, Mul=107, Div=108, 
		Mod=109, Exp=110, Equal=111, NotEqual=112, LessThan=113, GreaterThan=114, 
		LessThanOrEqual=115, GreaterThanOrEqual=116, Not=117, BitNot=118, Inc=119, 
		Dec=120, DoubleQuote=121, SingleQuote=122, NonEmptyStringLiteral=123, 
		EmptyStringLiteral=124, UnicodeStringLiteral=125, HexString=126, HexNumber=127, 
		OctalNumber=128, DecimalNumber=129, DecimalNumberFollowedByIdentifier=130, 
		Identifier=131, WS=132, COMMENT=133, LINE_COMMENT=134, AssemblyDialect=135, 
		AssemblyLBrace=136, AssemblyFlagString=137, AssemblyBlockLParen=138, AssemblyBlockRParen=139, 
		AssemblyBlockComma=140, AssemblyBlockWS=141, AssemblyBlockCOMMENT=142, 
		AssemblyBlockLINE_COMMENT=143, YulBreak=144, YulCase=145, YulContinue=146, 
		YulDefault=147, YulFalse=148, YulFor=149, YulFunction=150, YulIf=151, 
		YulLeave=152, YulLet=153, YulSwitch=154, YulTrue=155, YulHex=156, YulEVMBuiltin=157, 
		YulLBrace=158, YulRBrace=159, YulLParen=160, YulRParen=161, YulAssign=162, 
		YulPeriod=163, YulComma=164, YulArrow=165, YulIdentifier=166, YulHexNumber=167, 
		YulDecimalNumber=168, YulStringLiteral=169, YulHexStringLiteral=170, YulWS=171, 
		YulCOMMENT=172, YulLINE_COMMENT=173, PragmaToken=174, PragmaSemicolon=175, 
		PragmaWS=176, PragmaCOMMENT=177, PragmaLINE_COMMENT=178;
	public static final int
		RULE_sourceUnit = 0, RULE_pragmaDirective = 1, RULE_importDirective = 2, 
		RULE_importAliases = 3, RULE_path = 4, RULE_symbolAliases = 5, RULE_contractDefinition = 6, 
		RULE_interfaceDefinition = 7, RULE_libraryDefinition = 8, RULE_inheritanceSpecifierList = 9, 
		RULE_inheritanceSpecifier = 10, RULE_contractBodyElement = 11, RULE_namedArgument = 12, 
		RULE_callArgumentList = 13, RULE_identifierPath = 14, RULE_modifierInvocation = 15, 
		RULE_visibility = 16, RULE_parameterList = 17, RULE_parameterDeclaration = 18, 
		RULE_constructorDefinition = 19, RULE_stateMutability = 20, RULE_overrideSpecifier = 21, 
		RULE_functionDefinition = 22, RULE_modifierDefinition = 23, RULE_fallbackFunctionDefinition = 24, 
		RULE_receiveFunctionDefinition = 25, RULE_structDefinition = 26, RULE_structMember = 27, 
		RULE_enumDefinition = 28, RULE_userDefinedValueTypeDefinition = 29, RULE_stateVariableDeclaration = 30, 
		RULE_constantVariableDeclaration = 31, RULE_eventParameter = 32, RULE_eventDefinition = 33, 
		RULE_errorParameter = 34, RULE_errorDefinition = 35, RULE_userDefinableOperator = 36, 
		RULE_usingDirective = 37, RULE_usingAliases = 38, RULE_typeName = 39, 
		RULE_elementaryTypeName = 40, RULE_addressPayable = 41, RULE_functionTypeName = 42, 
		RULE_variableDeclaration = 43, RULE_dataLocation = 44, RULE_expression = 45, 
		RULE_assignOp = 46, RULE_tupleExpression = 47, RULE_inlineArrayExpression = 48, 
		RULE_identifier = 49, RULE_literal = 50, RULE_literalWithSubDenomination = 51, 
		RULE_boolLiteral = 52, RULE_stringLiteral = 53, RULE_hexStringLiteral = 54, 
		RULE_unicodeStringLiteral = 55, RULE_numberLiteral = 56, RULE_block = 57, 
		RULE_uncheckedBlock = 58, RULE_statement = 59, RULE_simpleStatement = 60, 
		RULE_ifStatement = 61, RULE_forStatement = 62, RULE_whileStatement = 63, 
		RULE_doWhileStatement = 64, RULE_continueStatement = 65, RULE_breakStatement = 66, 
		RULE_tryStatement = 67, RULE_catchClause = 68, RULE_returnStatement = 69, 
		RULE_emitStatement = 70, RULE_revertStatement = 71, RULE_assemblyStatement = 72, 
		RULE_assemblyFlags = 73, RULE_variableDeclarationList = 74, RULE_variableDeclarationTuple = 75, 
		RULE_variableDeclarationStatement = 76, RULE_expressionStatement = 77, 
		RULE_mappingType = 78, RULE_mappingKeyType = 79, RULE_yulStatement = 80, 
		RULE_yulBlock = 81, RULE_yulVariableDeclaration = 82, RULE_yulAssignment = 83, 
		RULE_yulIfStatement = 84, RULE_yulForStatement = 85, RULE_yulSwitchCase = 86, 
		RULE_yulSwitchStatement = 87, RULE_yulFunctionDefinition = 88, RULE_yulPath = 89, 
		RULE_yulFunctionCall = 90, RULE_yulbool = 91, RULE_yulLiteral = 92, RULE_yulExpression = 93;
	private static String[] makeRuleNames() {
		return new String[] {
			"sourceUnit", "pragmaDirective", "importDirective", "importAliases", 
			"path", "symbolAliases", "contractDefinition", "interfaceDefinition", 
			"libraryDefinition", "inheritanceSpecifierList", "inheritanceSpecifier", 
			"contractBodyElement", "namedArgument", "callArgumentList", "identifierPath", 
			"modifierInvocation", "visibility", "parameterList", "parameterDeclaration", 
			"constructorDefinition", "stateMutability", "overrideSpecifier", "functionDefinition", 
			"modifierDefinition", "fallbackFunctionDefinition", "receiveFunctionDefinition", 
			"structDefinition", "structMember", "enumDefinition", "userDefinedValueTypeDefinition", 
			"stateVariableDeclaration", "constantVariableDeclaration", "eventParameter", 
			"eventDefinition", "errorParameter", "errorDefinition", "userDefinableOperator", 
			"usingDirective", "usingAliases", "typeName", "elementaryTypeName", "addressPayable", 
			"functionTypeName", "variableDeclaration", "dataLocation", "expression", 
			"assignOp", "tupleExpression", "inlineArrayExpression", "identifier", 
			"literal", "literalWithSubDenomination", "boolLiteral", "stringLiteral", 
			"hexStringLiteral", "unicodeStringLiteral", "numberLiteral", "block", 
			"uncheckedBlock", "statement", "simpleStatement", "ifStatement", "forStatement", 
			"whileStatement", "doWhileStatement", "continueStatement", "breakStatement", 
			"tryStatement", "catchClause", "returnStatement", "emitStatement", "revertStatement", 
			"assemblyStatement", "assemblyFlags", "variableDeclarationList", "variableDeclarationTuple", 
			"variableDeclarationStatement", "expressionStatement", "mappingType", 
			"mappingKeyType", "yulStatement", "yulBlock", "yulVariableDeclaration", 
			"yulAssignment", "yulIfStatement", "yulForStatement", "yulSwitchCase", 
			"yulSwitchStatement", "yulFunctionDefinition", "yulPath", "yulFunctionCall", 
			"yulbool", "yulLiteral", "yulExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'abstract'", "'address'", "'anonymous'", "'as'", "'assembly'", 
			"'bool'", null, "'bytes'", "'calldata'", "'catch'", "'constant'", "'constructor'", 
			null, "'contract'", "'delete'", "'do'", "'else'", "'emit'", "'enum'", 
			"'error'", "'event'", "'external'", "'fallback'", null, null, null, null, 
			"'from'", null, "'global'", null, null, "'immutable'", "'import'", "'indexed'", 
			"'interface'", "'internal'", "'is'", "'library'", "'mapping'", "'memory'", 
			"'modifier'", "'new'", null, "'override'", "'payable'", "'pragma'", "'private'", 
			"'public'", "'pure'", "'receive'", "'return'", "'returns'", "'revert'", 
			null, "'storage'", "'string'", "'struct'", "'transient'", null, "'try'", 
			"'type'", null, "'unchecked'", "'unicode'", null, "'using'", "'view'", 
			"'virtual'", "'while'", null, null, "'['", "']'", null, null, "':'", 
			null, null, "'?'", "'=>'", null, "'='", "'|='", "'^='", "'&='", "'<<='", 
			"'>>='", "'>>>='", "'+='", "'-='", "'*='", "'/='", "'%='", null, "'||'", 
			"'&&'", "'|'", "'^'", "'&'", "'<<'", "'>>'", "'>>>'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'**'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'!'", 
			"'~'", "'++'", "'--'", "'\"'", "'''", null, null, null, null, null, null, 
			null, null, null, null, null, null, "'\"evmasm\"'", null, null, null, 
			null, null, null, null, null, null, "'case'", null, "'default'", null, 
			null, null, null, "'leave'", "'let'", "'switch'", null, null, null, null, 
			null, null, null, "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ReservedKeywords", "Abstract", "Address", "Anonymous", "As", "Assembly", 
			"Bool", "Break", "Bytes", "Calldata", "Catch", "Constant", "Constructor", 
			"Continue", "Contract", "Delete", "Do", "Else", "Emit", "Enum", "Error", 
			"Event", "External", "Fallback", "FalseLiteral", "Fixed", "FixedBytes", 
			"For", "From", "Function", "Global", "Hex", "If", "Immutable", "Import", 
			"Indexed", "Interface", "Internal", "Is", "Library", "Mapping", "Memory", 
			"Modifier", "New", "SubDenomination", "Override", "Payable", "Pragma", 
			"Private", "Public", "Pure", "Receive", "Return", "Returns", "Revert", 
			"SignedIntegerType", "Storage", "String", "Struct", "Transient", "TrueLiteral", 
			"Try", "Type", "Ufixed", "Unchecked", "Unicode", "UnsignedIntegerType", 
			"Using", "View", "Virtual", "While", "LParen", "RParen", "LBrack", "RBrack", 
			"LBrace", "RBrace", "Colon", "Semicolon", "Period", "Conditional", "DoubleArrow", 
			"RightArrow", "Assign", "AssignBitOr", "AssignBitXor", "AssignBitAnd", 
			"AssignShl", "AssignSar", "AssignShr", "AssignAdd", "AssignSub", "AssignMul", 
			"AssignDiv", "AssignMod", "Comma", "Or", "And", "BitOr", "BitXor", "BitAnd", 
			"Shl", "Sar", "Shr", "Add", "Sub", "Mul", "Div", "Mod", "Exp", "Equal", 
			"NotEqual", "LessThan", "GreaterThan", "LessThanOrEqual", "GreaterThanOrEqual", 
			"Not", "BitNot", "Inc", "Dec", "DoubleQuote", "SingleQuote", "NonEmptyStringLiteral", 
			"EmptyStringLiteral", "UnicodeStringLiteral", "HexString", "HexNumber", 
			"OctalNumber", "DecimalNumber", "DecimalNumberFollowedByIdentifier", 
			"Identifier", "WS", "COMMENT", "LINE_COMMENT", "AssemblyDialect", "AssemblyLBrace", 
			"AssemblyFlagString", "AssemblyBlockLParen", "AssemblyBlockRParen", "AssemblyBlockComma", 
			"AssemblyBlockWS", "AssemblyBlockCOMMENT", "AssemblyBlockLINE_COMMENT", 
			"YulBreak", "YulCase", "YulContinue", "YulDefault", "YulFalse", "YulFor", 
			"YulFunction", "YulIf", "YulLeave", "YulLet", "YulSwitch", "YulTrue", 
			"YulHex", "YulEVMBuiltin", "YulLBrace", "YulRBrace", "YulLParen", "YulRParen", 
			"YulAssign", "YulPeriod", "YulComma", "YulArrow", "YulIdentifier", "YulHexNumber", 
			"YulDecimalNumber", "YulStringLiteral", "YulHexStringLiteral", "YulWS", 
			"YulCOMMENT", "YulLINE_COMMENT", "PragmaToken", "PragmaSemicolon", "PragmaWS", 
			"PragmaCOMMENT", "PragmaLINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SolidityParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SolidityParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SourceUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SolidityParser.EOF, 0); }
		public List<PragmaDirectiveContext> pragmaDirective() {
			return getRuleContexts(PragmaDirectiveContext.class);
		}
		public PragmaDirectiveContext pragmaDirective(int i) {
			return getRuleContext(PragmaDirectiveContext.class,i);
		}
		public List<ImportDirectiveContext> importDirective() {
			return getRuleContexts(ImportDirectiveContext.class);
		}
		public ImportDirectiveContext importDirective(int i) {
			return getRuleContext(ImportDirectiveContext.class,i);
		}
		public List<UsingDirectiveContext> usingDirective() {
			return getRuleContexts(UsingDirectiveContext.class);
		}
		public UsingDirectiveContext usingDirective(int i) {
			return getRuleContext(UsingDirectiveContext.class,i);
		}
		public List<ContractDefinitionContext> contractDefinition() {
			return getRuleContexts(ContractDefinitionContext.class);
		}
		public ContractDefinitionContext contractDefinition(int i) {
			return getRuleContext(ContractDefinitionContext.class,i);
		}
		public List<InterfaceDefinitionContext> interfaceDefinition() {
			return getRuleContexts(InterfaceDefinitionContext.class);
		}
		public InterfaceDefinitionContext interfaceDefinition(int i) {
			return getRuleContext(InterfaceDefinitionContext.class,i);
		}
		public List<LibraryDefinitionContext> libraryDefinition() {
			return getRuleContexts(LibraryDefinitionContext.class);
		}
		public LibraryDefinitionContext libraryDefinition(int i) {
			return getRuleContext(LibraryDefinitionContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<ConstantVariableDeclarationContext> constantVariableDeclaration() {
			return getRuleContexts(ConstantVariableDeclarationContext.class);
		}
		public ConstantVariableDeclarationContext constantVariableDeclaration(int i) {
			return getRuleContext(ConstantVariableDeclarationContext.class,i);
		}
		public List<StructDefinitionContext> structDefinition() {
			return getRuleContexts(StructDefinitionContext.class);
		}
		public StructDefinitionContext structDefinition(int i) {
			return getRuleContext(StructDefinitionContext.class,i);
		}
		public List<EnumDefinitionContext> enumDefinition() {
			return getRuleContexts(EnumDefinitionContext.class);
		}
		public EnumDefinitionContext enumDefinition(int i) {
			return getRuleContext(EnumDefinitionContext.class,i);
		}
		public List<UserDefinedValueTypeDefinitionContext> userDefinedValueTypeDefinition() {
			return getRuleContexts(UserDefinedValueTypeDefinitionContext.class);
		}
		public UserDefinedValueTypeDefinitionContext userDefinedValueTypeDefinition(int i) {
			return getRuleContext(UserDefinedValueTypeDefinitionContext.class,i);
		}
		public List<ErrorDefinitionContext> errorDefinition() {
			return getRuleContexts(ErrorDefinitionContext.class);
		}
		public ErrorDefinitionContext errorDefinition(int i) {
			return getRuleContext(ErrorDefinitionContext.class,i);
		}
		public List<EventDefinitionContext> eventDefinition() {
			return getRuleContexts(EventDefinitionContext.class);
		}
		public EventDefinitionContext eventDefinition(int i) {
			return getRuleContext(EventDefinitionContext.class,i);
		}
		public SourceUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceUnit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitSourceUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceUnitContext sourceUnit() throws RecognitionException {
		SourceUnitContext _localctx = new SourceUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sourceUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7097388063458819444L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 25L) != 0) || _la==Identifier) {
				{
				setState(201);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(188);
					pragmaDirective();
					}
					break;
				case 2:
					{
					setState(189);
					importDirective();
					}
					break;
				case 3:
					{
					setState(190);
					usingDirective();
					}
					break;
				case 4:
					{
					setState(191);
					contractDefinition();
					}
					break;
				case 5:
					{
					setState(192);
					interfaceDefinition();
					}
					break;
				case 6:
					{
					setState(193);
					libraryDefinition();
					}
					break;
				case 7:
					{
					setState(194);
					functionDefinition();
					}
					break;
				case 8:
					{
					setState(195);
					constantVariableDeclaration();
					}
					break;
				case 9:
					{
					setState(196);
					structDefinition();
					}
					break;
				case 10:
					{
					setState(197);
					enumDefinition();
					}
					break;
				case 11:
					{
					setState(198);
					userDefinedValueTypeDefinition();
					}
					break;
				case 12:
					{
					setState(199);
					errorDefinition();
					}
					break;
				case 13:
					{
					setState(200);
					eventDefinition();
					}
					break;
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PragmaDirectiveContext extends ParserRuleContext {
		public TerminalNode Pragma() { return getToken(SolidityParser.Pragma, 0); }
		public TerminalNode PragmaSemicolon() { return getToken(SolidityParser.PragmaSemicolon, 0); }
		public List<TerminalNode> PragmaToken() { return getTokens(SolidityParser.PragmaToken); }
		public TerminalNode PragmaToken(int i) {
			return getToken(SolidityParser.PragmaToken, i);
		}
		public PragmaDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragmaDirective; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitPragmaDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PragmaDirectiveContext pragmaDirective() throws RecognitionException {
		PragmaDirectiveContext _localctx = new PragmaDirectiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pragmaDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(Pragma);
			setState(210); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(209);
				match(PragmaToken);
				}
				}
				setState(212); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PragmaToken );
			setState(214);
			match(PragmaSemicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportDirectiveContext extends ParserRuleContext {
		public IdentifierContext unitAlias;
		public TerminalNode Import() { return getToken(SolidityParser.Import, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public SymbolAliasesContext symbolAliases() {
			return getRuleContext(SymbolAliasesContext.class,0);
		}
		public TerminalNode From() { return getToken(SolidityParser.From, 0); }
		public TerminalNode Mul() { return getToken(SolidityParser.Mul, 0); }
		public TerminalNode As() { return getToken(SolidityParser.As, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ImportDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDirective; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitImportDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDirectiveContext importDirective() throws RecognitionException {
		ImportDirectiveContext _localctx = new ImportDirectiveContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(Import);
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NonEmptyStringLiteral:
				{
				{
				setState(217);
				path();
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==As) {
					{
					setState(218);
					match(As);
					setState(219);
					((ImportDirectiveContext)_localctx).unitAlias = identifier();
					}
				}

				}
				}
				break;
			case LBrace:
				{
				{
				setState(222);
				symbolAliases();
				setState(223);
				match(From);
				setState(224);
				path();
				}
				}
				break;
			case Mul:
				{
				{
				setState(226);
				match(Mul);
				setState(227);
				match(As);
				setState(228);
				((ImportDirectiveContext)_localctx).unitAlias = identifier();
				setState(229);
				match(From);
				setState(230);
				path();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(234);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportAliasesContext extends ParserRuleContext {
		public IdentifierContext symbol;
		public IdentifierContext alias;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode As() { return getToken(SolidityParser.As, 0); }
		public ImportAliasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importAliases; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitImportAliases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportAliasesContext importAliases() throws RecognitionException {
		ImportAliasesContext _localctx = new ImportAliasesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importAliases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			((ImportAliasesContext)_localctx).symbol = identifier();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==As) {
				{
				setState(237);
				match(As);
				setState(238);
				((ImportAliasesContext)_localctx).alias = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PathContext extends ParserRuleContext {
		public TerminalNode NonEmptyStringLiteral() { return getToken(SolidityParser.NonEmptyStringLiteral, 0); }
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(NonEmptyStringLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolAliasesContext extends ParserRuleContext {
		public ImportAliasesContext importAliases;
		public List<ImportAliasesContext> aliases = new ArrayList<ImportAliasesContext>();
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<ImportAliasesContext> importAliases() {
			return getRuleContexts(ImportAliasesContext.class);
		}
		public ImportAliasesContext importAliases(int i) {
			return getRuleContext(ImportAliasesContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public SymbolAliasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolAliases; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitSymbolAliases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolAliasesContext symbolAliases() throws RecognitionException {
		SymbolAliasesContext _localctx = new SymbolAliasesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_symbolAliases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(LBrace);
			setState(244);
			((SymbolAliasesContext)_localctx).importAliases = importAliases();
			((SymbolAliasesContext)_localctx).aliases.add(((SymbolAliasesContext)_localctx).importAliases);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(245);
				match(Comma);
				setState(246);
				((SymbolAliasesContext)_localctx).importAliases = importAliases();
				((SymbolAliasesContext)_localctx).aliases.add(((SymbolAliasesContext)_localctx).importAliases);
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContractDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode Contract() { return getToken(SolidityParser.Contract, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Abstract() { return getToken(SolidityParser.Abstract, 0); }
		public InheritanceSpecifierListContext inheritanceSpecifierList() {
			return getRuleContext(InheritanceSpecifierListContext.class,0);
		}
		public List<ContractBodyElementContext> contractBodyElement() {
			return getRuleContexts(ContractBodyElementContext.class);
		}
		public ContractBodyElementContext contractBodyElement(int i) {
			return getRuleContext(ContractBodyElementContext.class,i);
		}
		public ContractDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contractDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitContractDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContractDefinitionContext contractDefinition() throws RecognitionException {
		ContractDefinitionContext _localctx = new ContractDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_contractDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Abstract) {
				{
				setState(254);
				match(Abstract);
				}
			}

			setState(257);
			match(Contract);
			setState(258);
			((ContractDefinitionContext)_localctx).name = identifier();
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Is) {
				{
				setState(259);
				inheritanceSpecifierList();
				}
			}

			setState(262);
			match(LBrace);
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7093158414008704376L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 25L) != 0) || _la==Identifier) {
				{
				{
				setState(263);
				contractBodyElement();
				}
				}
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(269);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode Interface() { return getToken(SolidityParser.Interface, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public InheritanceSpecifierListContext inheritanceSpecifierList() {
			return getRuleContext(InheritanceSpecifierListContext.class,0);
		}
		public List<ContractBodyElementContext> contractBodyElement() {
			return getRuleContexts(ContractBodyElementContext.class);
		}
		public ContractBodyElementContext contractBodyElement(int i) {
			return getRuleContext(ContractBodyElementContext.class,i);
		}
		public InterfaceDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitInterfaceDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceDefinitionContext interfaceDefinition() throws RecognitionException {
		InterfaceDefinitionContext _localctx = new InterfaceDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_interfaceDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(Interface);
			setState(272);
			((InterfaceDefinitionContext)_localctx).name = identifier();
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Is) {
				{
				setState(273);
				inheritanceSpecifierList();
				}
			}

			setState(276);
			match(LBrace);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7093158414008704376L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 25L) != 0) || _la==Identifier) {
				{
				{
				setState(277);
				contractBodyElement();
				}
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(283);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LibraryDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode Library() { return getToken(SolidityParser.Library, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ContractBodyElementContext> contractBodyElement() {
			return getRuleContexts(ContractBodyElementContext.class);
		}
		public ContractBodyElementContext contractBodyElement(int i) {
			return getRuleContext(ContractBodyElementContext.class,i);
		}
		public LibraryDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_libraryDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitLibraryDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LibraryDefinitionContext libraryDefinition() throws RecognitionException {
		LibraryDefinitionContext _localctx = new LibraryDefinitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_libraryDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(Library);
			setState(286);
			((LibraryDefinitionContext)_localctx).name = identifier();
			setState(287);
			match(LBrace);
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7093158414008704376L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 25L) != 0) || _la==Identifier) {
				{
				{
				setState(288);
				contractBodyElement();
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(294);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InheritanceSpecifierListContext extends ParserRuleContext {
		public InheritanceSpecifierContext inheritanceSpecifier;
		public List<InheritanceSpecifierContext> inheritanceSpecifiers = new ArrayList<InheritanceSpecifierContext>();
		public TerminalNode Is() { return getToken(SolidityParser.Is, 0); }
		public List<InheritanceSpecifierContext> inheritanceSpecifier() {
			return getRuleContexts(InheritanceSpecifierContext.class);
		}
		public InheritanceSpecifierContext inheritanceSpecifier(int i) {
			return getRuleContext(InheritanceSpecifierContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public InheritanceSpecifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritanceSpecifierList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitInheritanceSpecifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InheritanceSpecifierListContext inheritanceSpecifierList() throws RecognitionException {
		InheritanceSpecifierListContext _localctx = new InheritanceSpecifierListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inheritanceSpecifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(Is);
			setState(297);
			((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier = inheritanceSpecifier();
			((InheritanceSpecifierListContext)_localctx).inheritanceSpecifiers.add(((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier);
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(298);
					match(Comma);
					setState(299);
					((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier = inheritanceSpecifier();
					((InheritanceSpecifierListContext)_localctx).inheritanceSpecifiers.add(((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier);
					}
					} 
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InheritanceSpecifierContext extends ParserRuleContext {
		public IdentifierPathContext name;
		public CallArgumentListContext arguments;
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public InheritanceSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritanceSpecifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitInheritanceSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InheritanceSpecifierContext inheritanceSpecifier() throws RecognitionException {
		InheritanceSpecifierContext _localctx = new InheritanceSpecifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inheritanceSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			((InheritanceSpecifierContext)_localctx).name = identifierPath();
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(306);
				((InheritanceSpecifierContext)_localctx).arguments = callArgumentList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContractBodyElementContext extends ParserRuleContext {
		public ConstructorDefinitionContext constructorDefinition() {
			return getRuleContext(ConstructorDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public ModifierDefinitionContext modifierDefinition() {
			return getRuleContext(ModifierDefinitionContext.class,0);
		}
		public FallbackFunctionDefinitionContext fallbackFunctionDefinition() {
			return getRuleContext(FallbackFunctionDefinitionContext.class,0);
		}
		public ReceiveFunctionDefinitionContext receiveFunctionDefinition() {
			return getRuleContext(ReceiveFunctionDefinitionContext.class,0);
		}
		public StructDefinitionContext structDefinition() {
			return getRuleContext(StructDefinitionContext.class,0);
		}
		public EnumDefinitionContext enumDefinition() {
			return getRuleContext(EnumDefinitionContext.class,0);
		}
		public UserDefinedValueTypeDefinitionContext userDefinedValueTypeDefinition() {
			return getRuleContext(UserDefinedValueTypeDefinitionContext.class,0);
		}
		public StateVariableDeclarationContext stateVariableDeclaration() {
			return getRuleContext(StateVariableDeclarationContext.class,0);
		}
		public EventDefinitionContext eventDefinition() {
			return getRuleContext(EventDefinitionContext.class,0);
		}
		public ErrorDefinitionContext errorDefinition() {
			return getRuleContext(ErrorDefinitionContext.class,0);
		}
		public UsingDirectiveContext usingDirective() {
			return getRuleContext(UsingDirectiveContext.class,0);
		}
		public ContractBodyElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contractBodyElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitContractBodyElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContractBodyElementContext contractBodyElement() throws RecognitionException {
		ContractBodyElementContext _localctx = new ContractBodyElementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_contractBodyElement);
		try {
			setState(321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				constructorDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(311);
				modifierDefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(312);
				fallbackFunctionDefinition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(313);
				receiveFunctionDefinition();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(314);
				structDefinition();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(315);
				enumDefinition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(316);
				userDefinedValueTypeDefinition();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(317);
				stateVariableDeclaration();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(318);
				eventDefinition();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(319);
				errorDefinition();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(320);
				usingDirective();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NamedArgumentContext extends ParserRuleContext {
		public IdentifierContext name;
		public ExpressionContext value;
		public TerminalNode Colon() { return getToken(SolidityParser.Colon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NamedArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedArgument; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitNamedArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedArgumentContext namedArgument() throws RecognitionException {
		NamedArgumentContext _localctx = new NamedArgumentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_namedArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			((NamedArgumentContext)_localctx).name = identifier();
			setState(324);
			match(Colon);
			setState(325);
			((NamedArgumentContext)_localctx).value = expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallArgumentListContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<NamedArgumentContext> namedArgument() {
			return getRuleContexts(NamedArgumentContext.class);
		}
		public NamedArgumentContext namedArgument(int i) {
			return getRuleContext(NamedArgumentContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public CallArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callArgumentList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitCallArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallArgumentListContext callArgumentList() throws RecognitionException {
		CallArgumentListContext _localctx = new CallArgumentListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_callArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(LParen);
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Address:
			case Bool:
			case Bytes:
			case Delete:
			case Error:
			case FalseLiteral:
			case Fixed:
			case FixedBytes:
			case From:
			case Global:
			case New:
			case Payable:
			case Revert:
			case SignedIntegerType:
			case String:
			case Transient:
			case TrueLiteral:
			case Type:
			case Ufixed:
			case UnsignedIntegerType:
			case LParen:
			case RParen:
			case LBrack:
			case Sub:
			case Not:
			case BitNot:
			case Inc:
			case Dec:
			case NonEmptyStringLiteral:
			case EmptyStringLiteral:
			case UnicodeStringLiteral:
			case HexString:
			case HexNumber:
			case DecimalNumber:
			case Identifier:
				{
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -5368132423229832568L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -441348365435796215L) != 0) || _la==DecimalNumber || _la==Identifier) {
					{
					setState(328);
					expression(0);
					setState(333);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(329);
						match(Comma);
						setState(330);
						expression(0);
						}
						}
						setState(335);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			case LBrace:
				{
				setState(338);
				match(LBrace);
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1188950304312262656L) != 0) || _la==Identifier) {
					{
					setState(339);
					namedArgument();
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(340);
						match(Comma);
						setState(341);
						namedArgument();
						}
						}
						setState(346);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(349);
				match(RBrace);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(352);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierPathContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> Period() { return getTokens(SolidityParser.Period); }
		public TerminalNode Period(int i) {
			return getToken(SolidityParser.Period, i);
		}
		public IdentifierPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierPath; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitIdentifierPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierPathContext identifierPath() throws RecognitionException {
		IdentifierPathContext _localctx = new IdentifierPathContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_identifierPath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			identifier();
			setState(359);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(355);
					match(Period);
					setState(356);
					identifier();
					}
					} 
				}
				setState(361);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierInvocationContext extends ParserRuleContext {
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public ModifierInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierInvocation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitModifierInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierInvocationContext modifierInvocation() throws RecognitionException {
		ModifierInvocationContext _localctx = new ModifierInvocationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_modifierInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			identifierPath();
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(363);
				callArgumentList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VisibilityContext extends ParserRuleContext {
		public TerminalNode Internal() { return getToken(SolidityParser.Internal, 0); }
		public TerminalNode External() { return getToken(SolidityParser.External, 0); }
		public TerminalNode Private() { return getToken(SolidityParser.Private, 0); }
		public TerminalNode Public() { return getToken(SolidityParser.Public, 0); }
		public VisibilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibility; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitVisibility(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VisibilityContext visibility() throws RecognitionException {
		VisibilityContext _localctx = new VisibilityContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_visibility);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1689124746559488L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public ParameterDeclarationContext parameterDeclaration;
		public List<ParameterDeclarationContext> parameters = new ArrayList<ParameterDeclarationContext>();
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			((ParameterListContext)_localctx).parameterDeclaration = parameterDeclaration();
			((ParameterListContext)_localctx).parameters.add(((ParameterListContext)_localctx).parameterDeclaration);
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(369);
				match(Comma);
				setState(370);
				((ParameterListContext)_localctx).parameterDeclaration = parameterDeclaration();
				((ParameterListContext)_localctx).parameters.add(((ParameterListContext)_localctx).parameterDeclaration);
				}
				}
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclarationContext extends ParserRuleContext {
		public TypeNameContext type;
		public DataLocationContext location;
		public IdentifierContext name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public DataLocationContext dataLocation() {
			return getRuleContext(DataLocationContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			((ParameterDeclarationContext)_localctx).type = typeName(0);
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 144119586122368000L) != 0)) {
				{
				setState(377);
				((ParameterDeclarationContext)_localctx).location = dataLocation();
				}
			}

			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1188950304312262656L) != 0) || _la==Identifier) {
				{
				setState(380);
				((ParameterDeclarationContext)_localctx).name = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDefinitionContext extends ParserRuleContext {
		public ParameterListContext arguments;
		public BlockContext body;
		public TerminalNode Constructor() { return getToken(SolidityParser.Constructor, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<TerminalNode> Payable() { return getTokens(SolidityParser.Payable); }
		public TerminalNode Payable(int i) {
			return getToken(SolidityParser.Payable, i);
		}
		public List<TerminalNode> Internal() { return getTokens(SolidityParser.Internal); }
		public TerminalNode Internal(int i) {
			return getToken(SolidityParser.Internal, i);
		}
		public List<TerminalNode> Public() { return getTokens(SolidityParser.Public); }
		public TerminalNode Public(int i) {
			return getToken(SolidityParser.Public, i);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ConstructorDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitConstructorDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDefinitionContext constructorDefinition() throws RecognitionException {
		ConstructorDefinitionContext _localctx = new ConstructorDefinitionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constructorDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(Constructor);
			setState(384);
			match(LParen);
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1549240474800226952L) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
				{
				setState(385);
				((ConstructorDefinitionContext)_localctx).arguments = parameterList();
				}
			}

			setState(388);
			match(RParen);
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1190217216585367552L) != 0) || _la==Identifier) {
				{
				setState(393);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Error:
				case From:
				case Global:
				case Revert:
				case Transient:
				case Identifier:
					{
					setState(389);
					modifierInvocation();
					}
					break;
				case Payable:
					{
					setState(390);
					match(Payable);
					}
					break;
				case Internal:
					{
					setState(391);
					match(Internal);
					}
					break;
				case Public:
					{
					setState(392);
					match(Public);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(398);
			((ConstructorDefinitionContext)_localctx).body = block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateMutabilityContext extends ParserRuleContext {
		public TerminalNode Pure() { return getToken(SolidityParser.Pure, 0); }
		public TerminalNode View() { return getToken(SolidityParser.View, 0); }
		public TerminalNode Payable() { return getToken(SolidityParser.Payable, 0); }
		public StateMutabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateMutability; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitStateMutability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateMutabilityContext stateMutability() throws RecognitionException {
		StateMutabilityContext _localctx = new StateMutabilityContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stateMutability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			_la = _input.LA(1);
			if ( !(((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 4194321L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OverrideSpecifierContext extends ParserRuleContext {
		public IdentifierPathContext identifierPath;
		public List<IdentifierPathContext> overrides = new ArrayList<IdentifierPathContext>();
		public TerminalNode Override() { return getToken(SolidityParser.Override, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<IdentifierPathContext> identifierPath() {
			return getRuleContexts(IdentifierPathContext.class);
		}
		public IdentifierPathContext identifierPath(int i) {
			return getRuleContext(IdentifierPathContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public OverrideSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overrideSpecifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitOverrideSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OverrideSpecifierContext overrideSpecifier() throws RecognitionException {
		OverrideSpecifierContext _localctx = new OverrideSpecifierContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_overrideSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(Override);
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(403);
				match(LParen);
				setState(404);
				((OverrideSpecifierContext)_localctx).identifierPath = identifierPath();
				((OverrideSpecifierContext)_localctx).overrides.add(((OverrideSpecifierContext)_localctx).identifierPath);
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(405);
					match(Comma);
					setState(406);
					((OverrideSpecifierContext)_localctx).identifierPath = identifierPath();
					((OverrideSpecifierContext)_localctx).overrides.add(((OverrideSpecifierContext)_localctx).identifierPath);
					}
					}
					setState(411);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(412);
				match(RParen);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public ParameterListContext arguments;
		public ParameterListContext returnParameters;
		public BlockContext body;
		public TerminalNode Function() { return getToken(SolidityParser.Function, 0); }
		public List<TerminalNode> LParen() { return getTokens(SolidityParser.LParen); }
		public TerminalNode LParen(int i) {
			return getToken(SolidityParser.LParen, i);
		}
		public List<TerminalNode> RParen() { return getTokens(SolidityParser.RParen); }
		public TerminalNode RParen(int i) {
			return getToken(SolidityParser.RParen, i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Fallback() { return getToken(SolidityParser.Fallback, 0); }
		public TerminalNode Receive() { return getToken(SolidityParser.Receive, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public List<VisibilityContext> visibility() {
			return getRuleContexts(VisibilityContext.class);
		}
		public VisibilityContext visibility(int i) {
			return getRuleContext(VisibilityContext.class,i);
		}
		public List<StateMutabilityContext> stateMutability() {
			return getRuleContexts(StateMutabilityContext.class);
		}
		public StateMutabilityContext stateMutability(int i) {
			return getRuleContext(StateMutabilityContext.class,i);
		}
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<TerminalNode> Virtual() { return getTokens(SolidityParser.Virtual); }
		public TerminalNode Virtual(int i) {
			return getToken(SolidityParser.Virtual, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public TerminalNode Returns() { return getToken(SolidityParser.Returns, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ParameterListContext> parameterList() {
			return getRuleContexts(ParameterListContext.class);
		}
		public ParameterListContext parameterList(int i) {
			return getRuleContext(ParameterListContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(Function);
			setState(420);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Error:
			case From:
			case Global:
			case Revert:
			case Transient:
			case Identifier:
				{
				setState(417);
				identifier();
				}
				break;
			case Fallback:
				{
				setState(418);
				match(Fallback);
				}
				break;
			case Receive:
				{
				setState(419);
				match(Receive);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(422);
			match(LParen);
			setState(424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1549240474800226952L) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
				{
				setState(423);
				((FunctionDefinitionContext)_localctx).arguments = parameterList();
				}
			}

			setState(426);
			match(RParen);
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1193102335105040384L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 4611686018427387907L) != 0)) {
				{
				setState(432);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case External:
				case Internal:
				case Private:
				case Public:
					{
					setState(427);
					visibility();
					}
					break;
				case Payable:
				case Pure:
				case View:
					{
					setState(428);
					stateMutability();
					}
					break;
				case Error:
				case From:
				case Global:
				case Revert:
				case Transient:
				case Identifier:
					{
					setState(429);
					modifierInvocation();
					}
					break;
				case Virtual:
					{
					setState(430);
					match(Virtual);
					}
					break;
				case Override:
					{
					setState(431);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Returns) {
				{
				setState(437);
				match(Returns);
				setState(438);
				match(LParen);
				setState(439);
				((FunctionDefinitionContext)_localctx).returnParameters = parameterList();
				setState(440);
				match(RParen);
				}
			}

			setState(446);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(444);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(445);
				((FunctionDefinitionContext)_localctx).body = block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public ParameterListContext arguments;
		public BlockContext body;
		public TerminalNode Modifier() { return getToken(SolidityParser.Modifier, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<TerminalNode> Virtual() { return getTokens(SolidityParser.Virtual); }
		public TerminalNode Virtual(int i) {
			return getToken(SolidityParser.Virtual, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ModifierDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitModifierDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierDefinitionContext modifierDefinition() throws RecognitionException {
		ModifierDefinitionContext _localctx = new ModifierDefinitionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_modifierDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			match(Modifier);
			setState(449);
			((ModifierDefinitionContext)_localctx).name = identifier();
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(450);
				match(LParen);
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1549240474800226952L) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
					{
					setState(451);
					((ModifierDefinitionContext)_localctx).arguments = parameterList();
					}
				}

				setState(454);
				match(RParen);
				}
			}

			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Override || _la==Virtual) {
				{
				setState(459);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Virtual:
					{
					setState(457);
					match(Virtual);
					}
					break;
				case Override:
					{
					setState(458);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(466);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(464);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(465);
				((ModifierDefinitionContext)_localctx).body = block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FallbackFunctionDefinitionContext extends ParserRuleContext {
		public Token kind;
		public ParameterListContext returnParameters;
		public BlockContext body;
		public List<TerminalNode> LParen() { return getTokens(SolidityParser.LParen); }
		public TerminalNode LParen(int i) {
			return getToken(SolidityParser.LParen, i);
		}
		public List<TerminalNode> RParen() { return getTokens(SolidityParser.RParen); }
		public TerminalNode RParen(int i) {
			return getToken(SolidityParser.RParen, i);
		}
		public TerminalNode Fallback() { return getToken(SolidityParser.Fallback, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public List<ParameterListContext> parameterList() {
			return getRuleContexts(ParameterListContext.class);
		}
		public ParameterListContext parameterList(int i) {
			return getRuleContext(ParameterListContext.class,i);
		}
		public List<TerminalNode> External() { return getTokens(SolidityParser.External); }
		public TerminalNode External(int i) {
			return getToken(SolidityParser.External, i);
		}
		public List<StateMutabilityContext> stateMutability() {
			return getRuleContexts(StateMutabilityContext.class);
		}
		public StateMutabilityContext stateMutability(int i) {
			return getRuleContext(StateMutabilityContext.class,i);
		}
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<TerminalNode> Virtual() { return getTokens(SolidityParser.Virtual); }
		public TerminalNode Virtual(int i) {
			return getToken(SolidityParser.Virtual, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public TerminalNode Returns() { return getToken(SolidityParser.Returns, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FallbackFunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fallbackFunctionDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitFallbackFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FallbackFunctionDefinitionContext fallbackFunctionDefinition() throws RecognitionException {
		FallbackFunctionDefinitionContext _localctx = new FallbackFunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_fallbackFunctionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			((FallbackFunctionDefinitionContext)_localctx).kind = match(Fallback);
			setState(469);
			match(LParen);
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1549240474800226952L) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
				{
				setState(470);
				parameterList();
				}
			}

			setState(473);
			match(RParen);
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1191413210366869504L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 4611686018427387907L) != 0)) {
				{
				setState(479);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case External:
					{
					setState(474);
					match(External);
					}
					break;
				case Payable:
				case Pure:
				case View:
					{
					setState(475);
					stateMutability();
					}
					break;
				case Error:
				case From:
				case Global:
				case Revert:
				case Transient:
				case Identifier:
					{
					setState(476);
					modifierInvocation();
					}
					break;
				case Virtual:
					{
					setState(477);
					match(Virtual);
					}
					break;
				case Override:
					{
					setState(478);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Returns) {
				{
				setState(484);
				match(Returns);
				setState(485);
				match(LParen);
				setState(486);
				((FallbackFunctionDefinitionContext)_localctx).returnParameters = parameterList();
				setState(487);
				match(RParen);
				}
			}

			setState(493);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(491);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(492);
				((FallbackFunctionDefinitionContext)_localctx).body = block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReceiveFunctionDefinitionContext extends ParserRuleContext {
		public Token kind;
		public BlockContext body;
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode Receive() { return getToken(SolidityParser.Receive, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public List<TerminalNode> External() { return getTokens(SolidityParser.External); }
		public TerminalNode External(int i) {
			return getToken(SolidityParser.External, i);
		}
		public List<TerminalNode> Payable() { return getTokens(SolidityParser.Payable); }
		public TerminalNode Payable(int i) {
			return getToken(SolidityParser.Payable, i);
		}
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<TerminalNode> Virtual() { return getTokens(SolidityParser.Virtual); }
		public TerminalNode Virtual(int i) {
			return getToken(SolidityParser.Virtual, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ReceiveFunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiveFunctionDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitReceiveFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReceiveFunctionDefinitionContext receiveFunctionDefinition() throws RecognitionException {
		ReceiveFunctionDefinitionContext _localctx = new ReceiveFunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_receiveFunctionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			((ReceiveFunctionDefinitionContext)_localctx).kind = match(Receive);
			setState(496);
			match(LParen);
			setState(497);
			match(RParen);
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1189161410553184256L) != 0) || _la==Virtual || _la==Identifier) {
				{
				setState(503);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case External:
					{
					setState(498);
					match(External);
					}
					break;
				case Payable:
					{
					setState(499);
					match(Payable);
					}
					break;
				case Error:
				case From:
				case Global:
				case Revert:
				case Transient:
				case Identifier:
					{
					setState(500);
					modifierInvocation();
					}
					break;
				case Virtual:
					{
					setState(501);
					match(Virtual);
					}
					break;
				case Override:
					{
					setState(502);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(510);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(508);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(509);
				((ReceiveFunctionDefinitionContext)_localctx).body = block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public StructMemberContext members;
		public TerminalNode Struct() { return getToken(SolidityParser.Struct, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<StructMemberContext> structMember() {
			return getRuleContexts(StructMemberContext.class);
		}
		public StructMemberContext structMember(int i) {
			return getRuleContext(StructMemberContext.class,i);
		}
		public StructDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitStructDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDefinitionContext structDefinition() throws RecognitionException {
		StructDefinitionContext _localctx = new StructDefinitionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_structDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			match(Struct);
			setState(513);
			((StructDefinitionContext)_localctx).name = identifier();
			setState(514);
			match(LBrace);
			setState(516); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(515);
				((StructDefinitionContext)_localctx).members = structMember();
				}
				}
				setState(518); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1549240474800226952L) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier );
			setState(520);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructMemberContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StructMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structMember; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitStructMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_structMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			((StructMemberContext)_localctx).type = typeName(0);
			setState(523);
			((StructMemberContext)_localctx).name = identifier();
			setState(524);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext identifier;
		public List<IdentifierContext> enumValues = new ArrayList<IdentifierContext>();
		public TerminalNode Enum() { return getToken(SolidityParser.Enum, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public EnumDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitEnumDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDefinitionContext enumDefinition() throws RecognitionException {
		EnumDefinitionContext _localctx = new EnumDefinitionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_enumDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(Enum);
			setState(527);
			((EnumDefinitionContext)_localctx).name = identifier();
			setState(528);
			match(LBrace);
			setState(529);
			((EnumDefinitionContext)_localctx).identifier = identifier();
			((EnumDefinitionContext)_localctx).enumValues.add(((EnumDefinitionContext)_localctx).identifier);
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(530);
				match(Comma);
				setState(531);
				((EnumDefinitionContext)_localctx).identifier = identifier();
				((EnumDefinitionContext)_localctx).enumValues.add(((EnumDefinitionContext)_localctx).identifier);
				}
				}
				setState(536);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(537);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UserDefinedValueTypeDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode Type() { return getToken(SolidityParser.Type, 0); }
		public TerminalNode Is() { return getToken(SolidityParser.Is, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public AddressPayableContext addressPayable() {
			return getRuleContext(AddressPayableContext.class,0);
		}
		public UserDefinedValueTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedValueTypeDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUserDefinedValueTypeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserDefinedValueTypeDefinitionContext userDefinedValueTypeDefinition() throws RecognitionException {
		UserDefinedValueTypeDefinitionContext _localctx = new UserDefinedValueTypeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_userDefinedValueTypeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			match(Type);
			setState(540);
			((UserDefinedValueTypeDefinitionContext)_localctx).name = identifier();
			setState(541);
			match(Is);
			setState(544);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(542);
				elementaryTypeName();
				}
				break;
			case 2:
				{
				setState(543);
				addressPayable();
				}
				break;
			}
			setState(546);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateVariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public ExpressionContext initialValue;
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> Public() { return getTokens(SolidityParser.Public); }
		public TerminalNode Public(int i) {
			return getToken(SolidityParser.Public, i);
		}
		public List<TerminalNode> Private() { return getTokens(SolidityParser.Private); }
		public TerminalNode Private(int i) {
			return getToken(SolidityParser.Private, i);
		}
		public List<TerminalNode> Internal() { return getTokens(SolidityParser.Internal); }
		public TerminalNode Internal(int i) {
			return getToken(SolidityParser.Internal, i);
		}
		public List<TerminalNode> Constant() { return getTokens(SolidityParser.Constant); }
		public TerminalNode Constant(int i) {
			return getToken(SolidityParser.Constant, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public List<TerminalNode> Immutable() { return getTokens(SolidityParser.Immutable); }
		public TerminalNode Immutable(int i) {
			return getToken(SolidityParser.Immutable, i);
		}
		public List<TerminalNode> Transient() { return getTokens(SolidityParser.Transient); }
		public TerminalNode Transient(int i) {
			return getToken(SolidityParser.Transient, i);
		}
		public TerminalNode Assign() { return getToken(SolidityParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StateVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateVariableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitStateVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateVariableDeclarationContext stateVariableDeclaration() throws RecognitionException {
		StateVariableDeclarationContext _localctx = new StateVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_stateVariableDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			((StateVariableDeclarationContext)_localctx).type = typeName(0);
			setState(558);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(556);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case Public:
						{
						setState(549);
						match(Public);
						}
						break;
					case Private:
						{
						setState(550);
						match(Private);
						}
						break;
					case Internal:
						{
						setState(551);
						match(Internal);
						}
						break;
					case Constant:
						{
						setState(552);
						match(Constant);
						}
						break;
					case Override:
						{
						setState(553);
						overrideSpecifier();
						}
						break;
					case Immutable:
						{
						setState(554);
						match(Immutable);
						}
						break;
					case Transient:
						{
						setState(555);
						match(Transient);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(560);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			setState(561);
			((StateVariableDeclarationContext)_localctx).name = identifier();
			setState(564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(562);
				match(Assign);
				setState(563);
				((StateVariableDeclarationContext)_localctx).initialValue = expression(0);
				}
			}

			setState(566);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantVariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public ExpressionContext initialValue;
		public TerminalNode Constant() { return getToken(SolidityParser.Constant, 0); }
		public TerminalNode Assign() { return getToken(SolidityParser.Assign, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstantVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantVariableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitConstantVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantVariableDeclarationContext constantVariableDeclaration() throws RecognitionException {
		ConstantVariableDeclarationContext _localctx = new ConstantVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_constantVariableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			((ConstantVariableDeclarationContext)_localctx).type = typeName(0);
			setState(569);
			match(Constant);
			setState(570);
			((ConstantVariableDeclarationContext)_localctx).name = identifier();
			setState(571);
			match(Assign);
			setState(572);
			((ConstantVariableDeclarationContext)_localctx).initialValue = expression(0);
			setState(573);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EventParameterContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Indexed() { return getToken(SolidityParser.Indexed, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EventParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitEventParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventParameterContext eventParameter() throws RecognitionException {
		EventParameterContext _localctx = new EventParameterContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_eventParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			((EventParameterContext)_localctx).type = typeName(0);
			setState(577);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Indexed) {
				{
				setState(576);
				match(Indexed);
				}
			}

			setState(580);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1188950304312262656L) != 0) || _la==Identifier) {
				{
				setState(579);
				((EventParameterContext)_localctx).name = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EventDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public EventParameterContext eventParameter;
		public List<EventParameterContext> parameters = new ArrayList<EventParameterContext>();
		public TerminalNode Event() { return getToken(SolidityParser.Event, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Anonymous() { return getToken(SolidityParser.Anonymous, 0); }
		public List<EventParameterContext> eventParameter() {
			return getRuleContexts(EventParameterContext.class);
		}
		public EventParameterContext eventParameter(int i) {
			return getRuleContext(EventParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public EventDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitEventDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventDefinitionContext eventDefinition() throws RecognitionException {
		EventDefinitionContext _localctx = new EventDefinitionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_eventDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			match(Event);
			setState(583);
			((EventDefinitionContext)_localctx).name = identifier();
			setState(584);
			match(LParen);
			setState(593);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1549240474800226952L) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
				{
				setState(585);
				((EventDefinitionContext)_localctx).eventParameter = eventParameter();
				((EventDefinitionContext)_localctx).parameters.add(((EventDefinitionContext)_localctx).eventParameter);
				setState(590);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(586);
					match(Comma);
					setState(587);
					((EventDefinitionContext)_localctx).eventParameter = eventParameter();
					((EventDefinitionContext)_localctx).parameters.add(((EventDefinitionContext)_localctx).eventParameter);
					}
					}
					setState(592);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(595);
			match(RParen);
			setState(597);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Anonymous) {
				{
				setState(596);
				match(Anonymous);
				}
			}

			setState(599);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ErrorParameterContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ErrorParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_errorParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitErrorParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrorParameterContext errorParameter() throws RecognitionException {
		ErrorParameterContext _localctx = new ErrorParameterContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_errorParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			((ErrorParameterContext)_localctx).type = typeName(0);
			setState(603);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1188950304312262656L) != 0) || _la==Identifier) {
				{
				setState(602);
				((ErrorParameterContext)_localctx).name = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ErrorDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public ErrorParameterContext errorParameter;
		public List<ErrorParameterContext> parameters = new ArrayList<ErrorParameterContext>();
		public TerminalNode Error() { return getToken(SolidityParser.Error, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ErrorParameterContext> errorParameter() {
			return getRuleContexts(ErrorParameterContext.class);
		}
		public ErrorParameterContext errorParameter(int i) {
			return getRuleContext(ErrorParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public ErrorDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_errorDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitErrorDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrorDefinitionContext errorDefinition() throws RecognitionException {
		ErrorDefinitionContext _localctx = new ErrorDefinitionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_errorDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			match(Error);
			setState(606);
			((ErrorDefinitionContext)_localctx).name = identifier();
			setState(607);
			match(LParen);
			setState(616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1549240474800226952L) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
				{
				setState(608);
				((ErrorDefinitionContext)_localctx).errorParameter = errorParameter();
				((ErrorDefinitionContext)_localctx).parameters.add(((ErrorDefinitionContext)_localctx).errorParameter);
				setState(613);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(609);
					match(Comma);
					setState(610);
					((ErrorDefinitionContext)_localctx).errorParameter = errorParameter();
					((ErrorDefinitionContext)_localctx).parameters.add(((ErrorDefinitionContext)_localctx).errorParameter);
					}
					}
					setState(615);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(618);
			match(RParen);
			setState(619);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UserDefinableOperatorContext extends ParserRuleContext {
		public TerminalNode BitAnd() { return getToken(SolidityParser.BitAnd, 0); }
		public TerminalNode BitNot() { return getToken(SolidityParser.BitNot, 0); }
		public TerminalNode BitOr() { return getToken(SolidityParser.BitOr, 0); }
		public TerminalNode BitXor() { return getToken(SolidityParser.BitXor, 0); }
		public TerminalNode Add() { return getToken(SolidityParser.Add, 0); }
		public TerminalNode Div() { return getToken(SolidityParser.Div, 0); }
		public TerminalNode Mod() { return getToken(SolidityParser.Mod, 0); }
		public TerminalNode Mul() { return getToken(SolidityParser.Mul, 0); }
		public TerminalNode Sub() { return getToken(SolidityParser.Sub, 0); }
		public TerminalNode Equal() { return getToken(SolidityParser.Equal, 0); }
		public TerminalNode GreaterThan() { return getToken(SolidityParser.GreaterThan, 0); }
		public TerminalNode GreaterThanOrEqual() { return getToken(SolidityParser.GreaterThanOrEqual, 0); }
		public TerminalNode LessThan() { return getToken(SolidityParser.LessThan, 0); }
		public TerminalNode LessThanOrEqual() { return getToken(SolidityParser.LessThanOrEqual, 0); }
		public TerminalNode NotEqual() { return getToken(SolidityParser.NotEqual, 0); }
		public UserDefinableOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinableOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUserDefinableOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserDefinableOperatorContext userDefinableOperator() throws RecognitionException {
		UserDefinableOperatorContext _localctx = new UserDefinableOperatorContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_userDefinableOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			_la = _input.LA(1);
			if ( !(((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & 784327L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UsingDirectiveContext extends ParserRuleContext {
		public TerminalNode Using() { return getToken(SolidityParser.Using, 0); }
		public TerminalNode For() { return getToken(SolidityParser.For, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public TerminalNode Mul() { return getToken(SolidityParser.Mul, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Global() { return getToken(SolidityParser.Global, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public List<UsingAliasesContext> usingAliases() {
			return getRuleContexts(UsingAliasesContext.class);
		}
		public UsingAliasesContext usingAliases(int i) {
			return getRuleContext(UsingAliasesContext.class,i);
		}
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public UsingDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingDirective; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUsingDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsingDirectiveContext usingDirective() throws RecognitionException {
		UsingDirectiveContext _localctx = new UsingDirectiveContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_usingDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			match(Using);
			setState(636);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Error:
			case From:
			case Global:
			case Revert:
			case Transient:
			case Identifier:
				{
				setState(624);
				identifierPath();
				}
				break;
			case LBrace:
				{
				{
				setState(625);
				match(LBrace);
				setState(626);
				usingAliases();
				setState(631);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(627);
					match(Comma);
					setState(628);
					usingAliases();
					}
					}
					setState(633);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(634);
				match(RBrace);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(638);
			match(For);
			setState(641);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Mul:
				{
				setState(639);
				match(Mul);
				}
				break;
			case Address:
			case Bool:
			case Bytes:
			case Error:
			case Fixed:
			case FixedBytes:
			case From:
			case Function:
			case Global:
			case Mapping:
			case Revert:
			case SignedIntegerType:
			case String:
			case Transient:
			case Ufixed:
			case UnsignedIntegerType:
			case Identifier:
				{
				setState(640);
				typeName(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(644);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Global) {
				{
				setState(643);
				match(Global);
				}
			}

			setState(646);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UsingAliasesContext extends ParserRuleContext {
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public TerminalNode As() { return getToken(SolidityParser.As, 0); }
		public UserDefinableOperatorContext userDefinableOperator() {
			return getRuleContext(UserDefinableOperatorContext.class,0);
		}
		public UsingAliasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingAliases; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUsingAliases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsingAliasesContext usingAliases() throws RecognitionException {
		UsingAliasesContext _localctx = new UsingAliasesContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_usingAliases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(648);
			identifierPath();
			setState(651);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==As) {
				{
				setState(649);
				match(As);
				setState(650);
				userDefinableOperator();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeNameContext extends ParserRuleContext {
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public AddressPayableContext addressPayable() {
			return getRuleContext(AddressPayableContext.class,0);
		}
		public FunctionTypeNameContext functionTypeName() {
			return getRuleContext(FunctionTypeNameContext.class,0);
		}
		public MappingTypeContext mappingType() {
			return getRuleContext(MappingTypeContext.class,0);
		}
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LBrack() { return getToken(SolidityParser.LBrack, 0); }
		public TerminalNode RBrack() { return getToken(SolidityParser.RBrack, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		return typeName(0);
	}

	private TypeNameContext typeName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeNameContext _localctx = new TypeNameContext(_ctx, _parentState);
		TypeNameContext _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_typeName, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(654);
				elementaryTypeName();
				}
				break;
			case 2:
				{
				setState(655);
				addressPayable();
				}
				break;
			case 3:
				{
				setState(656);
				functionTypeName();
				}
				break;
			case 4:
				{
				setState(657);
				mappingType();
				}
				break;
			case 5:
				{
				setState(658);
				identifierPath();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(669);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeName);
					setState(661);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(662);
					match(LBrack);
					setState(664);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -5368132423229832568L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -441348365435796215L) != 0) || _la==DecimalNumber || _la==Identifier) {
						{
						setState(663);
						expression(0);
						}
					}

					setState(666);
					match(RBrack);
					}
					} 
				}
				setState(671);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementaryTypeNameContext extends ParserRuleContext {
		public TerminalNode Address() { return getToken(SolidityParser.Address, 0); }
		public TerminalNode Bool() { return getToken(SolidityParser.Bool, 0); }
		public TerminalNode String() { return getToken(SolidityParser.String, 0); }
		public TerminalNode Bytes() { return getToken(SolidityParser.Bytes, 0); }
		public TerminalNode SignedIntegerType() { return getToken(SolidityParser.SignedIntegerType, 0); }
		public TerminalNode UnsignedIntegerType() { return getToken(SolidityParser.UnsignedIntegerType, 0); }
		public TerminalNode FixedBytes() { return getToken(SolidityParser.FixedBytes, 0); }
		public TerminalNode Fixed() { return getToken(SolidityParser.Fixed, 0); }
		public TerminalNode Ufixed() { return getToken(SolidityParser.Ufixed, 0); }
		public ElementaryTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementaryTypeName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitElementaryTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementaryTypeNameContext elementaryTypeName() throws RecognitionException {
		ElementaryTypeNameContext _localctx = new ElementaryTypeNameContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_elementaryTypeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 360287970390966920L) != 0) || _la==Ufixed || _la==UnsignedIntegerType) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddressPayableContext extends ParserRuleContext {
		public TerminalNode Address() { return getToken(SolidityParser.Address, 0); }
		public TerminalNode Payable() { return getToken(SolidityParser.Payable, 0); }
		public AddressPayableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addressPayable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitAddressPayable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddressPayableContext addressPayable() throws RecognitionException {
		AddressPayableContext _localctx = new AddressPayableContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_addressPayable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
			match(Address);
			setState(675);
			match(Payable);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionTypeNameContext extends ParserRuleContext {
		public ParameterListContext arguments;
		public ParameterListContext returnParameters;
		public TerminalNode Function() { return getToken(SolidityParser.Function, 0); }
		public List<TerminalNode> LParen() { return getTokens(SolidityParser.LParen); }
		public TerminalNode LParen(int i) {
			return getToken(SolidityParser.LParen, i);
		}
		public List<TerminalNode> RParen() { return getTokens(SolidityParser.RParen); }
		public TerminalNode RParen(int i) {
			return getToken(SolidityParser.RParen, i);
		}
		public List<VisibilityContext> visibility() {
			return getRuleContexts(VisibilityContext.class);
		}
		public VisibilityContext visibility(int i) {
			return getRuleContext(VisibilityContext.class,i);
		}
		public List<StateMutabilityContext> stateMutability() {
			return getRuleContexts(StateMutabilityContext.class);
		}
		public StateMutabilityContext stateMutability(int i) {
			return getRuleContext(StateMutabilityContext.class,i);
		}
		public TerminalNode Returns() { return getToken(SolidityParser.Returns, 0); }
		public List<ParameterListContext> parameterList() {
			return getRuleContexts(ParameterListContext.class);
		}
		public ParameterListContext parameterList(int i) {
			return getRuleContext(ParameterListContext.class,i);
		}
		public FunctionTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionTypeName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitFunctionTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTypeNameContext functionTypeName() throws RecognitionException {
		FunctionTypeNameContext _localctx = new FunctionTypeNameContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_functionTypeName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			match(Function);
			setState(678);
			match(LParen);
			setState(680);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1549240474800226952L) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
				{
				setState(679);
				((FunctionTypeNameContext)_localctx).arguments = parameterList();
				}
			}

			setState(682);
			match(RParen);
			setState(687);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(685);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case External:
					case Internal:
					case Private:
					case Public:
						{
						setState(683);
						visibility();
						}
						break;
					case Payable:
					case Pure:
					case View:
						{
						setState(684);
						stateMutability();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(689);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			}
			setState(695);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(690);
				match(Returns);
				setState(691);
				match(LParen);
				setState(692);
				((FunctionTypeNameContext)_localctx).returnParameters = parameterList();
				setState(693);
				match(RParen);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext type;
		public DataLocationContext location;
		public IdentifierContext name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DataLocationContext dataLocation() {
			return getRuleContext(DataLocationContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			((VariableDeclarationContext)_localctx).type = typeName(0);
			setState(699);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 144119586122368000L) != 0)) {
				{
				setState(698);
				((VariableDeclarationContext)_localctx).location = dataLocation();
				}
			}

			setState(701);
			((VariableDeclarationContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataLocationContext extends ParserRuleContext {
		public TerminalNode Memory() { return getToken(SolidityParser.Memory, 0); }
		public TerminalNode Storage() { return getToken(SolidityParser.Storage, 0); }
		public TerminalNode Calldata() { return getToken(SolidityParser.Calldata, 0); }
		public DataLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataLocation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitDataLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataLocationContext dataLocation() throws RecognitionException {
		DataLocationContext _localctx = new DataLocationContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_dataLocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(703);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 144119586122368000L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryPrefixOperationContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Inc() { return getToken(SolidityParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(SolidityParser.Dec, 0); }
		public TerminalNode Not() { return getToken(SolidityParser.Not, 0); }
		public TerminalNode BitNot() { return getToken(SolidityParser.BitNot, 0); }
		public TerminalNode Delete() { return getToken(SolidityParser.Delete, 0); }
		public TerminalNode Sub() { return getToken(SolidityParser.Sub, 0); }
		public UnaryPrefixOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUnaryPrefixOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralWithSubDenominationContext literalWithSubDenomination() {
			return getRuleContext(LiteralWithSubDenominationContext.class,0);
		}
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public PrimaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrderComparisonContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LessThan() { return getToken(SolidityParser.LessThan, 0); }
		public TerminalNode GreaterThan() { return getToken(SolidityParser.GreaterThan, 0); }
		public TerminalNode LessThanOrEqual() { return getToken(SolidityParser.LessThanOrEqual, 0); }
		public TerminalNode GreaterThanOrEqual() { return getToken(SolidityParser.GreaterThanOrEqual, 0); }
		public OrderComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitOrderComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Conditional() { return getToken(SolidityParser.Conditional, 0); }
		public TerminalNode Colon() { return getToken(SolidityParser.Colon, 0); }
		public ConditionalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PayableConversionContext extends ExpressionContext {
		public TerminalNode Payable() { return getToken(SolidityParser.Payable, 0); }
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public PayableConversionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitPayableConversion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignOpContext assignOp() {
			return getRuleContext(AssignOpContext.class,0);
		}
		public AssignmentContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnarySuffixOperationContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Inc() { return getToken(SolidityParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(SolidityParser.Dec, 0); }
		public UnarySuffixOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUnarySuffixOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ShiftOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Shl() { return getToken(SolidityParser.Shl, 0); }
		public TerminalNode Sar() { return getToken(SolidityParser.Sar, 0); }
		public TerminalNode Shr() { return getToken(SolidityParser.Shr, 0); }
		public ShiftOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitShiftOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitAndOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BitAnd() { return getToken(SolidityParser.BitAnd, 0); }
		public BitAndOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitBitAndOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public FunctionCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexRangeAccessContext extends ExpressionContext {
		public ExpressionContext startIndex;
		public ExpressionContext endIndex;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBrack() { return getToken(SolidityParser.LBrack, 0); }
		public TerminalNode Colon() { return getToken(SolidityParser.Colon, 0); }
		public TerminalNode RBrack() { return getToken(SolidityParser.RBrack, 0); }
		public IndexRangeAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitIndexRangeAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexAccessContext extends ExpressionContext {
		public ExpressionContext index;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBrack() { return getToken(SolidityParser.LBrack, 0); }
		public TerminalNode RBrack() { return getToken(SolidityParser.RBrack, 0); }
		public IndexAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitIndexAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Add() { return getToken(SolidityParser.Add, 0); }
		public TerminalNode Sub() { return getToken(SolidityParser.Sub, 0); }
		public AddSubOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitAddSubOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitOrOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BitOr() { return getToken(SolidityParser.BitOr, 0); }
		public BitOrOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitBitOrOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Exp() { return getToken(SolidityParser.Exp, 0); }
		public ExpOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitExpOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode And() { return getToken(SolidityParser.And, 0); }
		public AndOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitAndOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InlineArrayContext extends ExpressionContext {
		public InlineArrayExpressionContext inlineArrayExpression() {
			return getRuleContext(InlineArrayExpressionContext.class,0);
		}
		public InlineArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitInlineArray(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Or() { return getToken(SolidityParser.Or, 0); }
		public OrOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitOrOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Period() { return getToken(SolidityParser.Period, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Address() { return getToken(SolidityParser.Address, 0); }
		public MemberAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitMemberAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivModOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Mul() { return getToken(SolidityParser.Mul, 0); }
		public TerminalNode Div() { return getToken(SolidityParser.Div, 0); }
		public TerminalNode Mod() { return getToken(SolidityParser.Mod, 0); }
		public MulDivModOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitMulDivModOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallOptionsContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<NamedArgumentContext> namedArgument() {
			return getRuleContexts(NamedArgumentContext.class);
		}
		public NamedArgumentContext namedArgument(int i) {
			return getRuleContext(NamedArgumentContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public FunctionCallOptionsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitFunctionCallOptions(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewExprContext extends ExpressionContext {
		public TerminalNode New() { return getToken(SolidityParser.New, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public NewExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitXorOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BitXor() { return getToken(SolidityParser.BitXor, 0); }
		public BitXorOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitBitXorOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TupleContext extends ExpressionContext {
		public TupleExpressionContext tupleExpression() {
			return getRuleContext(TupleExpressionContext.class,0);
		}
		public TupleContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityComparisonContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Equal() { return getToken(SolidityParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(SolidityParser.NotEqual, 0); }
		public EqualityComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitEqualityComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MetaTypeContext extends ExpressionContext {
		public TerminalNode Type() { return getToken(SolidityParser.Type, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public MetaTypeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitMetaType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 90;
		enterRecursionRule(_localctx, 90, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Payable:
				{
				_localctx = new PayableConversionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(706);
				match(Payable);
				setState(707);
				callArgumentList();
				}
				break;
			case Type:
				{
				_localctx = new MetaTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(708);
				match(Type);
				setState(709);
				match(LParen);
				setState(710);
				typeName(0);
				setState(711);
				match(RParen);
				}
				break;
			case Delete:
			case Sub:
			case Not:
			case BitNot:
			case Inc:
			case Dec:
				{
				_localctx = new UnaryPrefixOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(713);
				_la = _input.LA(1);
				if ( !(_la==Delete || ((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & 30721L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(714);
				expression(19);
				}
				break;
			case New:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(715);
				match(New);
				setState(716);
				typeName(0);
				}
				break;
			case LParen:
				{
				_localctx = new TupleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(717);
				tupleExpression();
				}
				break;
			case LBrack:
				{
				_localctx = new InlineArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(718);
				inlineArrayExpression();
				}
				break;
			case Address:
			case Bool:
			case Bytes:
			case Error:
			case FalseLiteral:
			case Fixed:
			case FixedBytes:
			case From:
			case Global:
			case Revert:
			case SignedIntegerType:
			case String:
			case Transient:
			case TrueLiteral:
			case Ufixed:
			case UnsignedIntegerType:
			case NonEmptyStringLiteral:
			case EmptyStringLiteral:
			case UnicodeStringLiteral:
			case HexString:
			case HexNumber:
			case DecimalNumber:
			case Identifier:
				{
				_localctx = new PrimaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(723);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(719);
					identifier();
					}
					break;
				case 2:
					{
					setState(720);
					literal();
					}
					break;
				case 3:
					{
					setState(721);
					literalWithSubDenomination();
					}
					break;
				case 4:
					{
					setState(722);
					elementaryTypeName();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(811);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(809);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
					case 1:
						{
						_localctx = new ExpOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(727);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(728);
						match(Exp);
						setState(729);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(730);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(731);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & 7L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(732);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new AddSubOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(733);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(734);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(735);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new ShiftOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(736);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(737);
						_la = _input.LA(1);
						if ( !(((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 7L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(738);
						expression(15);
						}
						break;
					case 5:
						{
						_localctx = new BitAndOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(739);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(740);
						match(BitAnd);
						setState(741);
						expression(14);
						}
						break;
					case 6:
						{
						_localctx = new BitXorOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(742);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(743);
						match(BitXor);
						setState(744);
						expression(13);
						}
						break;
					case 7:
						{
						_localctx = new BitOrOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(745);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(746);
						match(BitOr);
						setState(747);
						expression(12);
						}
						break;
					case 8:
						{
						_localctx = new OrderComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(748);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(749);
						_la = _input.LA(1);
						if ( !(((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & 15L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(750);
						expression(11);
						}
						break;
					case 9:
						{
						_localctx = new EqualityComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(751);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(752);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(753);
						expression(10);
						}
						break;
					case 10:
						{
						_localctx = new AndOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(754);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(755);
						match(And);
						setState(756);
						expression(9);
						}
						break;
					case 11:
						{
						_localctx = new OrOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(757);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(758);
						match(Or);
						setState(759);
						expression(8);
						}
						break;
					case 12:
						{
						_localctx = new ConditionalContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(760);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(761);
						match(Conditional);
						setState(762);
						expression(0);
						setState(763);
						match(Colon);
						setState(764);
						expression(6);
						}
						break;
					case 13:
						{
						_localctx = new AssignmentContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(766);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(767);
						assignOp();
						setState(768);
						expression(5);
						}
						break;
					case 14:
						{
						_localctx = new IndexAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(770);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(771);
						match(LBrack);
						setState(773);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -5368132423229832568L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -441348365435796215L) != 0) || _la==DecimalNumber || _la==Identifier) {
							{
							setState(772);
							((IndexAccessContext)_localctx).index = expression(0);
							}
						}

						setState(775);
						match(RBrack);
						}
						break;
					case 15:
						{
						_localctx = new IndexRangeAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(776);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(777);
						match(LBrack);
						setState(779);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -5368132423229832568L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -441348365435796215L) != 0) || _la==DecimalNumber || _la==Identifier) {
							{
							setState(778);
							((IndexRangeAccessContext)_localctx).startIndex = expression(0);
							}
						}

						setState(781);
						match(Colon);
						setState(783);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -5368132423229832568L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -441348365435796215L) != 0) || _la==DecimalNumber || _la==Identifier) {
							{
							setState(782);
							((IndexRangeAccessContext)_localctx).endIndex = expression(0);
							}
						}

						setState(785);
						match(RBrack);
						}
						break;
					case 16:
						{
						_localctx = new MemberAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(786);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(787);
						match(Period);
						setState(790);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Error:
						case From:
						case Global:
						case Revert:
						case Transient:
						case Identifier:
							{
							setState(788);
							identifier();
							}
							break;
						case Address:
							{
							setState(789);
							match(Address);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 17:
						{
						_localctx = new FunctionCallOptionsContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(792);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(793);
						match(LBrace);
						setState(802);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1188950304312262656L) != 0) || _la==Identifier) {
							{
							setState(794);
							namedArgument();
							setState(799);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==Comma) {
								{
								{
								setState(795);
								match(Comma);
								setState(796);
								namedArgument();
								}
								}
								setState(801);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(804);
						match(RBrace);
						}
						break;
					case 18:
						{
						_localctx = new FunctionCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(805);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(806);
						callArgumentList();
						}
						break;
					case 19:
						{
						_localctx = new UnarySuffixOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(807);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(808);
						_la = _input.LA(1);
						if ( !(_la==Inc || _la==Dec) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(813);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignOpContext extends ParserRuleContext {
		public TerminalNode Assign() { return getToken(SolidityParser.Assign, 0); }
		public TerminalNode AssignBitOr() { return getToken(SolidityParser.AssignBitOr, 0); }
		public TerminalNode AssignBitXor() { return getToken(SolidityParser.AssignBitXor, 0); }
		public TerminalNode AssignBitAnd() { return getToken(SolidityParser.AssignBitAnd, 0); }
		public TerminalNode AssignShl() { return getToken(SolidityParser.AssignShl, 0); }
		public TerminalNode AssignSar() { return getToken(SolidityParser.AssignSar, 0); }
		public TerminalNode AssignShr() { return getToken(SolidityParser.AssignShr, 0); }
		public TerminalNode AssignAdd() { return getToken(SolidityParser.AssignAdd, 0); }
		public TerminalNode AssignSub() { return getToken(SolidityParser.AssignSub, 0); }
		public TerminalNode AssignMul() { return getToken(SolidityParser.AssignMul, 0); }
		public TerminalNode AssignDiv() { return getToken(SolidityParser.AssignDiv, 0); }
		public TerminalNode AssignMod() { return getToken(SolidityParser.AssignMod, 0); }
		public AssignOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitAssignOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignOpContext assignOp() throws RecognitionException {
		AssignOpContext _localctx = new AssignOpContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_assignOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(814);
			_la = _input.LA(1);
			if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & 4095L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleExpressionContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public TupleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitTupleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleExpressionContext tupleExpression() throws RecognitionException {
		TupleExpressionContext _localctx = new TupleExpressionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_tupleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(816);
			match(LParen);
			{
			setState(818);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -5368132423229832568L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -441348365435796215L) != 0) || _la==DecimalNumber || _la==Identifier) {
				{
				setState(817);
				expression(0);
				}
			}

			setState(826);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(820);
				match(Comma);
				setState(822);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -5368132423229832568L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -441348365435796215L) != 0) || _la==DecimalNumber || _la==Identifier) {
					{
					setState(821);
					expression(0);
					}
				}

				}
				}
				setState(828);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(829);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InlineArrayExpressionContext extends ParserRuleContext {
		public TerminalNode LBrack() { return getToken(SolidityParser.LBrack, 0); }
		public TerminalNode RBrack() { return getToken(SolidityParser.RBrack, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public InlineArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineArrayExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitInlineArrayExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineArrayExpressionContext inlineArrayExpression() throws RecognitionException {
		InlineArrayExpressionContext _localctx = new InlineArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_inlineArrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831);
			match(LBrack);
			{
			setState(832);
			expression(0);
			setState(837);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(833);
				match(Comma);
				setState(834);
				expression(0);
				}
				}
				setState(839);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(840);
			match(RBrack);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SolidityParser.Identifier, 0); }
		public TerminalNode From() { return getToken(SolidityParser.From, 0); }
		public TerminalNode Error() { return getToken(SolidityParser.Error, 0); }
		public TerminalNode Revert() { return getToken(SolidityParser.Revert, 0); }
		public TerminalNode Global() { return getToken(SolidityParser.Global, 0); }
		public TerminalNode Transient() { return getToken(SolidityParser.Transient, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1188950304312262656L) != 0) || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public HexStringLiteralContext hexStringLiteral() {
			return getRuleContext(HexStringLiteralContext.class,0);
		}
		public UnicodeStringLiteralContext unicodeStringLiteral() {
			return getRuleContext(UnicodeStringLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_literal);
		try {
			setState(849);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NonEmptyStringLiteral:
			case EmptyStringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(844);
				stringLiteral();
				}
				break;
			case HexNumber:
			case DecimalNumber:
				enterOuterAlt(_localctx, 2);
				{
				setState(845);
				numberLiteral();
				}
				break;
			case FalseLiteral:
			case TrueLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(846);
				boolLiteral();
				}
				break;
			case HexString:
				enterOuterAlt(_localctx, 4);
				{
				setState(847);
				hexStringLiteral();
				}
				break;
			case UnicodeStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(848);
				unicodeStringLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralWithSubDenominationContext extends ParserRuleContext {
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public TerminalNode SubDenomination() { return getToken(SolidityParser.SubDenomination, 0); }
		public LiteralWithSubDenominationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalWithSubDenomination; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitLiteralWithSubDenomination(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralWithSubDenominationContext literalWithSubDenomination() throws RecognitionException {
		LiteralWithSubDenominationContext _localctx = new LiteralWithSubDenominationContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_literalWithSubDenomination);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(851);
			numberLiteral();
			setState(852);
			match(SubDenomination);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolLiteralContext extends ParserRuleContext {
		public TerminalNode TrueLiteral() { return getToken(SolidityParser.TrueLiteral, 0); }
		public TerminalNode FalseLiteral() { return getToken(SolidityParser.FalseLiteral, 0); }
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_boolLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854);
			_la = _input.LA(1);
			if ( !(_la==FalseLiteral || _la==TrueLiteral) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> NonEmptyStringLiteral() { return getTokens(SolidityParser.NonEmptyStringLiteral); }
		public TerminalNode NonEmptyStringLiteral(int i) {
			return getToken(SolidityParser.NonEmptyStringLiteral, i);
		}
		public List<TerminalNode> EmptyStringLiteral() { return getTokens(SolidityParser.EmptyStringLiteral); }
		public TerminalNode EmptyStringLiteral(int i) {
			return getToken(SolidityParser.EmptyStringLiteral, i);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_stringLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(857); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(856);
					_la = _input.LA(1);
					if ( !(_la==NonEmptyStringLiteral || _la==EmptyStringLiteral) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(859); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HexStringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> HexString() { return getTokens(SolidityParser.HexString); }
		public TerminalNode HexString(int i) {
			return getToken(SolidityParser.HexString, i);
		}
		public HexStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hexStringLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitHexStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HexStringLiteralContext hexStringLiteral() throws RecognitionException {
		HexStringLiteralContext _localctx = new HexStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_hexStringLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(862); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(861);
					match(HexString);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(864); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnicodeStringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> UnicodeStringLiteral() { return getTokens(SolidityParser.UnicodeStringLiteral); }
		public TerminalNode UnicodeStringLiteral(int i) {
			return getToken(SolidityParser.UnicodeStringLiteral, i);
		}
		public UnicodeStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unicodeStringLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUnicodeStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnicodeStringLiteralContext unicodeStringLiteral() throws RecognitionException {
		UnicodeStringLiteralContext _localctx = new UnicodeStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_unicodeStringLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(867); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(866);
					match(UnicodeStringLiteral);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(869); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberLiteralContext extends ParserRuleContext {
		public TerminalNode DecimalNumber() { return getToken(SolidityParser.DecimalNumber, 0); }
		public TerminalNode HexNumber() { return getToken(SolidityParser.HexNumber, 0); }
		public NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberLiteralContext numberLiteral() throws RecognitionException {
		NumberLiteralContext _localctx = new NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_numberLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(871);
			_la = _input.LA(1);
			if ( !(_la==HexNumber || _la==DecimalNumber) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<UncheckedBlockContext> uncheckedBlock() {
			return getRuleContexts(UncheckedBlockContext.class);
		}
		public UncheckedBlockContext uncheckedBlock(int i) {
			return getRuleContext(UncheckedBlockContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(873);
			match(LBrace);
			setState(878);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -747436996591664184L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -441348365435791989L) != 0) || _la==DecimalNumber || _la==Identifier) {
				{
				setState(876);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Address:
				case Assembly:
				case Bool:
				case Break:
				case Bytes:
				case Continue:
				case Delete:
				case Do:
				case Emit:
				case Error:
				case FalseLiteral:
				case Fixed:
				case FixedBytes:
				case For:
				case From:
				case Function:
				case Global:
				case If:
				case Mapping:
				case New:
				case Payable:
				case Return:
				case Revert:
				case SignedIntegerType:
				case String:
				case Transient:
				case TrueLiteral:
				case Try:
				case Type:
				case Ufixed:
				case UnsignedIntegerType:
				case While:
				case LParen:
				case LBrack:
				case LBrace:
				case Sub:
				case Not:
				case BitNot:
				case Inc:
				case Dec:
				case NonEmptyStringLiteral:
				case EmptyStringLiteral:
				case UnicodeStringLiteral:
				case HexString:
				case HexNumber:
				case DecimalNumber:
				case Identifier:
					{
					setState(874);
					statement();
					}
					break;
				case Unchecked:
					{
					setState(875);
					uncheckedBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(880);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(881);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UncheckedBlockContext extends ParserRuleContext {
		public TerminalNode Unchecked() { return getToken(SolidityParser.Unchecked, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public UncheckedBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uncheckedBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUncheckedBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UncheckedBlockContext uncheckedBlock() throws RecognitionException {
		UncheckedBlockContext _localctx = new UncheckedBlockContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_uncheckedBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(883);
			match(Unchecked);
			setState(884);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public EmitStatementContext emitStatement() {
			return getRuleContext(EmitStatementContext.class,0);
		}
		public RevertStatementContext revertStatement() {
			return getRuleContext(RevertStatementContext.class,0);
		}
		public AssemblyStatementContext assemblyStatement() {
			return getRuleContext(AssemblyStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_statement);
		try {
			setState(899);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(886);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(887);
				simpleStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(888);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(889);
				forStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(890);
				whileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(891);
				doWhileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(892);
				continueStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(893);
				breakStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(894);
				tryStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(895);
				returnStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(896);
				emitStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(897);
				revertStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(898);
				assemblyStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleStatementContext extends ParserRuleContext {
		public VariableDeclarationStatementContext variableDeclarationStatement() {
			return getRuleContext(VariableDeclarationStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SimpleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitSimpleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleStatementContext simpleStatement() throws RecognitionException {
		SimpleStatementContext _localctx = new SimpleStatementContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_simpleStatement);
		try {
			setState(903);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(901);
				variableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(902);
				expressionStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(SolidityParser.If, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(SolidityParser.Else, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			match(If);
			setState(906);
			match(LParen);
			setState(907);
			expression(0);
			setState(908);
			match(RParen);
			setState(909);
			statement();
			setState(912);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(910);
				match(Else);
				setState(911);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(SolidityParser.For, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public List<TerminalNode> Semicolon() { return getTokens(SolidityParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(SolidityParser.Semicolon, i);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			match(For);
			setState(915);
			match(LParen);
			setState(918);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Address:
			case Bool:
			case Bytes:
			case Delete:
			case Error:
			case FalseLiteral:
			case Fixed:
			case FixedBytes:
			case From:
			case Function:
			case Global:
			case Mapping:
			case New:
			case Payable:
			case Revert:
			case SignedIntegerType:
			case String:
			case Transient:
			case TrueLiteral:
			case Type:
			case Ufixed:
			case UnsignedIntegerType:
			case LParen:
			case LBrack:
			case Sub:
			case Not:
			case BitNot:
			case Inc:
			case Dec:
			case NonEmptyStringLiteral:
			case EmptyStringLiteral:
			case UnicodeStringLiteral:
			case HexString:
			case HexNumber:
			case DecimalNumber:
			case Identifier:
				{
				setState(916);
				simpleStatement();
				}
				break;
			case Semicolon:
				{
				setState(917);
				match(Semicolon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(922);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Address:
			case Bool:
			case Bytes:
			case Delete:
			case Error:
			case FalseLiteral:
			case Fixed:
			case FixedBytes:
			case From:
			case Global:
			case New:
			case Payable:
			case Revert:
			case SignedIntegerType:
			case String:
			case Transient:
			case TrueLiteral:
			case Type:
			case Ufixed:
			case UnsignedIntegerType:
			case LParen:
			case LBrack:
			case Sub:
			case Not:
			case BitNot:
			case Inc:
			case Dec:
			case NonEmptyStringLiteral:
			case EmptyStringLiteral:
			case UnicodeStringLiteral:
			case HexString:
			case HexNumber:
			case DecimalNumber:
			case Identifier:
				{
				setState(920);
				expressionStatement();
				}
				break;
			case Semicolon:
				{
				setState(921);
				match(Semicolon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(925);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -5368132423229832568L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -441348365435796215L) != 0) || _la==DecimalNumber || _la==Identifier) {
				{
				setState(924);
				expression(0);
				}
			}

			setState(927);
			match(RParen);
			setState(928);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(SolidityParser.While, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(930);
			match(While);
			setState(931);
			match(LParen);
			setState(932);
			expression(0);
			setState(933);
			match(RParen);
			setState(934);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileStatementContext extends ParserRuleContext {
		public TerminalNode Do() { return getToken(SolidityParser.Do, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode While() { return getToken(SolidityParser.While, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			match(Do);
			setState(937);
			statement();
			setState(938);
			match(While);
			setState(939);
			match(LParen);
			setState(940);
			expression(0);
			setState(941);
			match(RParen);
			setState(942);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(SolidityParser.Continue, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(944);
			match(Continue);
			setState(945);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(SolidityParser.Break, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(947);
			match(Break);
			setState(948);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TryStatementContext extends ParserRuleContext {
		public ParameterListContext returnParameters;
		public TerminalNode Try() { return getToken(SolidityParser.Try, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Returns() { return getToken(SolidityParser.Returns, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitTryStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_tryStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(950);
			match(Try);
			setState(951);
			expression(0);
			setState(957);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Returns) {
				{
				setState(952);
				match(Returns);
				setState(953);
				match(LParen);
				setState(954);
				((TryStatementContext)_localctx).returnParameters = parameterList();
				setState(955);
				match(RParen);
				}
			}

			setState(959);
			block();
			setState(961); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(960);
				catchClause();
				}
				}
				setState(963); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Catch );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CatchClauseContext extends ParserRuleContext {
		public ParameterListContext arguments;
		public TerminalNode Catch() { return getToken(SolidityParser.Catch, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitCatchClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(965);
			match(Catch);
			setState(973);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1188950304312262656L) != 0) || _la==LParen || _la==Identifier) {
				{
				setState(967);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1188950304312262656L) != 0) || _la==Identifier) {
					{
					setState(966);
					identifier();
					}
				}

				setState(969);
				match(LParen);
				{
				setState(970);
				((CatchClauseContext)_localctx).arguments = parameterList();
				}
				setState(971);
				match(RParen);
				}
			}

			setState(975);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(SolidityParser.Return, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(977);
			match(Return);
			setState(979);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -5368132423229832568L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -441348365435796215L) != 0) || _la==DecimalNumber || _la==Identifier) {
				{
				setState(978);
				expression(0);
				}
			}

			setState(981);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EmitStatementContext extends ParserRuleContext {
		public TerminalNode Emit() { return getToken(SolidityParser.Emit, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public EmitStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emitStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitEmitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmitStatementContext emitStatement() throws RecognitionException {
		EmitStatementContext _localctx = new EmitStatementContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_emitStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(983);
			match(Emit);
			setState(984);
			expression(0);
			setState(985);
			callArgumentList();
			setState(986);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RevertStatementContext extends ParserRuleContext {
		public TerminalNode Revert() { return getToken(SolidityParser.Revert, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public RevertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_revertStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitRevertStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RevertStatementContext revertStatement() throws RecognitionException {
		RevertStatementContext _localctx = new RevertStatementContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_revertStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(988);
			match(Revert);
			setState(989);
			expression(0);
			setState(990);
			callArgumentList();
			setState(991);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssemblyStatementContext extends ParserRuleContext {
		public TerminalNode Assembly() { return getToken(SolidityParser.Assembly, 0); }
		public TerminalNode AssemblyLBrace() { return getToken(SolidityParser.AssemblyLBrace, 0); }
		public TerminalNode YulRBrace() { return getToken(SolidityParser.YulRBrace, 0); }
		public TerminalNode AssemblyDialect() { return getToken(SolidityParser.AssemblyDialect, 0); }
		public AssemblyFlagsContext assemblyFlags() {
			return getRuleContext(AssemblyFlagsContext.class,0);
		}
		public List<YulStatementContext> yulStatement() {
			return getRuleContexts(YulStatementContext.class);
		}
		public YulStatementContext yulStatement(int i) {
			return getRuleContext(YulStatementContext.class,i);
		}
		public AssemblyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitAssemblyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyStatementContext assemblyStatement() throws RecognitionException {
		AssemblyStatementContext _localctx = new AssemblyStatementContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_assemblyStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(993);
			match(Assembly);
			setState(995);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AssemblyDialect) {
				{
				setState(994);
				match(AssemblyDialect);
				}
			}

			setState(998);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AssemblyBlockLParen) {
				{
				setState(997);
				assemblyFlags();
				}
			}

			setState(1000);
			match(AssemblyLBrace);
			setState(1004);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & 4220901L) != 0)) {
				{
				{
				setState(1001);
				yulStatement();
				}
				}
				setState(1006);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1007);
			match(YulRBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssemblyFlagsContext extends ParserRuleContext {
		public TerminalNode AssemblyBlockLParen() { return getToken(SolidityParser.AssemblyBlockLParen, 0); }
		public List<TerminalNode> AssemblyFlagString() { return getTokens(SolidityParser.AssemblyFlagString); }
		public TerminalNode AssemblyFlagString(int i) {
			return getToken(SolidityParser.AssemblyFlagString, i);
		}
		public TerminalNode AssemblyBlockRParen() { return getToken(SolidityParser.AssemblyBlockRParen, 0); }
		public List<TerminalNode> AssemblyBlockComma() { return getTokens(SolidityParser.AssemblyBlockComma); }
		public TerminalNode AssemblyBlockComma(int i) {
			return getToken(SolidityParser.AssemblyBlockComma, i);
		}
		public AssemblyFlagsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyFlags; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitAssemblyFlags(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyFlagsContext assemblyFlags() throws RecognitionException {
		AssemblyFlagsContext _localctx = new AssemblyFlagsContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_assemblyFlags);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1009);
			match(AssemblyBlockLParen);
			setState(1010);
			match(AssemblyFlagString);
			setState(1015);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AssemblyBlockComma) {
				{
				{
				setState(1011);
				match(AssemblyBlockComma);
				setState(1012);
				match(AssemblyFlagString);
				}
				}
				setState(1017);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1018);
			match(AssemblyBlockRParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationListContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration;
		public List<VariableDeclarationContext> variableDeclarations = new ArrayList<VariableDeclarationContext>();
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public VariableDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitVariableDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationListContext variableDeclarationList() throws RecognitionException {
		VariableDeclarationListContext _localctx = new VariableDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_variableDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1020);
			((VariableDeclarationListContext)_localctx).variableDeclaration = variableDeclaration();
			((VariableDeclarationListContext)_localctx).variableDeclarations.add(((VariableDeclarationListContext)_localctx).variableDeclaration);
			setState(1025);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1021);
				match(Comma);
				setState(1022);
				((VariableDeclarationListContext)_localctx).variableDeclaration = variableDeclaration();
				((VariableDeclarationListContext)_localctx).variableDeclarations.add(((VariableDeclarationListContext)_localctx).variableDeclaration);
				}
				}
				setState(1027);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationTupleContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration;
		public List<VariableDeclarationContext> variableDeclarations = new ArrayList<VariableDeclarationContext>();
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public VariableDeclarationTupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationTuple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitVariableDeclarationTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationTupleContext variableDeclarationTuple() throws RecognitionException {
		VariableDeclarationTupleContext _localctx = new VariableDeclarationTupleContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_variableDeclarationTuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1028);
			match(LParen);
			{
			setState(1032);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1029);
				match(Comma);
				}
				}
				setState(1034);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1035);
			((VariableDeclarationTupleContext)_localctx).variableDeclaration = variableDeclaration();
			((VariableDeclarationTupleContext)_localctx).variableDeclarations.add(((VariableDeclarationTupleContext)_localctx).variableDeclaration);
			}
			setState(1043);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1037);
				match(Comma);
				setState(1039);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1549240474800226952L) != 0) || _la==Ufixed || _la==UnsignedIntegerType || _la==Identifier) {
					{
					setState(1038);
					((VariableDeclarationTupleContext)_localctx).variableDeclaration = variableDeclaration();
					((VariableDeclarationTupleContext)_localctx).variableDeclarations.add(((VariableDeclarationTupleContext)_localctx).variableDeclaration);
					}
				}

				}
				}
				setState(1045);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1046);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationStatementContext extends ParserRuleContext {
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableDeclarationTupleContext variableDeclarationTuple() {
			return getRuleContext(VariableDeclarationTupleContext.class,0);
		}
		public TerminalNode Assign() { return getToken(SolidityParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationStatementContext variableDeclarationStatement() throws RecognitionException {
		VariableDeclarationStatementContext _localctx = new VariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_variableDeclarationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1057);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Address:
			case Bool:
			case Bytes:
			case Error:
			case Fixed:
			case FixedBytes:
			case From:
			case Function:
			case Global:
			case Mapping:
			case Revert:
			case SignedIntegerType:
			case String:
			case Transient:
			case Ufixed:
			case UnsignedIntegerType:
			case Identifier:
				{
				{
				setState(1048);
				variableDeclaration();
				setState(1051);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(1049);
					match(Assign);
					setState(1050);
					expression(0);
					}
				}

				}
				}
				break;
			case LParen:
				{
				{
				setState(1053);
				variableDeclarationTuple();
				setState(1054);
				match(Assign);
				setState(1055);
				expression(0);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1059);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1061);
			expression(0);
			setState(1062);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MappingTypeContext extends ParserRuleContext {
		public MappingKeyTypeContext key;
		public IdentifierContext name;
		public TypeNameContext value;
		public TerminalNode Mapping() { return getToken(SolidityParser.Mapping, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode DoubleArrow() { return getToken(SolidityParser.DoubleArrow, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public MappingKeyTypeContext mappingKeyType() {
			return getRuleContext(MappingKeyTypeContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public MappingTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mappingType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitMappingType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MappingTypeContext mappingType() throws RecognitionException {
		MappingTypeContext _localctx = new MappingTypeContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_mappingType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1064);
			match(Mapping);
			setState(1065);
			match(LParen);
			setState(1066);
			((MappingTypeContext)_localctx).key = mappingKeyType();
			setState(1068);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1188950304312262656L) != 0) || _la==Identifier) {
				{
				setState(1067);
				((MappingTypeContext)_localctx).name = identifier();
				}
			}

			setState(1070);
			match(DoubleArrow);
			setState(1071);
			((MappingTypeContext)_localctx).value = typeName(0);
			setState(1073);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1188950304312262656L) != 0) || _la==Identifier) {
				{
				setState(1072);
				((MappingTypeContext)_localctx).name = identifier();
				}
			}

			setState(1075);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MappingKeyTypeContext extends ParserRuleContext {
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public MappingKeyTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mappingKeyType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitMappingKeyType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MappingKeyTypeContext mappingKeyType() throws RecognitionException {
		MappingKeyTypeContext _localctx = new MappingKeyTypeContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_mappingKeyType);
		try {
			setState(1079);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Address:
			case Bool:
			case Bytes:
			case Fixed:
			case FixedBytes:
			case SignedIntegerType:
			case String:
			case Ufixed:
			case UnsignedIntegerType:
				enterOuterAlt(_localctx, 1);
				{
				setState(1077);
				elementaryTypeName();
				}
				break;
			case Error:
			case From:
			case Global:
			case Revert:
			case Transient:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1078);
				identifierPath();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulStatementContext extends ParserRuleContext {
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public YulVariableDeclarationContext yulVariableDeclaration() {
			return getRuleContext(YulVariableDeclarationContext.class,0);
		}
		public YulAssignmentContext yulAssignment() {
			return getRuleContext(YulAssignmentContext.class,0);
		}
		public YulFunctionCallContext yulFunctionCall() {
			return getRuleContext(YulFunctionCallContext.class,0);
		}
		public YulIfStatementContext yulIfStatement() {
			return getRuleContext(YulIfStatementContext.class,0);
		}
		public YulForStatementContext yulForStatement() {
			return getRuleContext(YulForStatementContext.class,0);
		}
		public YulSwitchStatementContext yulSwitchStatement() {
			return getRuleContext(YulSwitchStatementContext.class,0);
		}
		public TerminalNode YulLeave() { return getToken(SolidityParser.YulLeave, 0); }
		public TerminalNode YulBreak() { return getToken(SolidityParser.YulBreak, 0); }
		public TerminalNode YulContinue() { return getToken(SolidityParser.YulContinue, 0); }
		public YulFunctionDefinitionContext yulFunctionDefinition() {
			return getRuleContext(YulFunctionDefinitionContext.class,0);
		}
		public YulStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulStatementContext yulStatement() throws RecognitionException {
		YulStatementContext _localctx = new YulStatementContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_yulStatement);
		try {
			setState(1092);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1081);
				yulBlock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1082);
				yulVariableDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1083);
				yulAssignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1084);
				yulFunctionCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1085);
				yulIfStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1086);
				yulForStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1087);
				yulSwitchStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1088);
				match(YulLeave);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1089);
				match(YulBreak);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1090);
				match(YulContinue);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1091);
				yulFunctionDefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulBlockContext extends ParserRuleContext {
		public TerminalNode YulLBrace() { return getToken(SolidityParser.YulLBrace, 0); }
		public TerminalNode YulRBrace() { return getToken(SolidityParser.YulRBrace, 0); }
		public List<YulStatementContext> yulStatement() {
			return getRuleContexts(YulStatementContext.class);
		}
		public YulStatementContext yulStatement(int i) {
			return getRuleContext(YulStatementContext.class,i);
		}
		public YulBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulBlockContext yulBlock() throws RecognitionException {
		YulBlockContext _localctx = new YulBlockContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_yulBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1094);
			match(YulLBrace);
			setState(1098);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & 4220901L) != 0)) {
				{
				{
				setState(1095);
				yulStatement();
				}
				}
				setState(1100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1101);
			match(YulRBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulVariableDeclarationContext extends ParserRuleContext {
		public Token YulIdentifier;
		public List<Token> variables = new ArrayList<Token>();
		public TerminalNode YulLet() { return getToken(SolidityParser.YulLet, 0); }
		public List<TerminalNode> YulIdentifier() { return getTokens(SolidityParser.YulIdentifier); }
		public TerminalNode YulIdentifier(int i) {
			return getToken(SolidityParser.YulIdentifier, i);
		}
		public TerminalNode YulAssign() { return getToken(SolidityParser.YulAssign, 0); }
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public List<TerminalNode> YulComma() { return getTokens(SolidityParser.YulComma); }
		public TerminalNode YulComma(int i) {
			return getToken(SolidityParser.YulComma, i);
		}
		public YulFunctionCallContext yulFunctionCall() {
			return getRuleContext(YulFunctionCallContext.class,0);
		}
		public YulVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulVariableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulVariableDeclarationContext yulVariableDeclaration() throws RecognitionException {
		YulVariableDeclarationContext _localctx = new YulVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_yulVariableDeclaration);
		int _la;
		try {
			setState(1122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1103);
				match(YulLet);
				setState(1104);
				((YulVariableDeclarationContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulVariableDeclarationContext)_localctx).variables.add(((YulVariableDeclarationContext)_localctx).YulIdentifier);
				setState(1107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==YulAssign) {
					{
					setState(1105);
					match(YulAssign);
					setState(1106);
					yulExpression();
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1109);
				match(YulLet);
				setState(1110);
				((YulVariableDeclarationContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulVariableDeclarationContext)_localctx).variables.add(((YulVariableDeclarationContext)_localctx).YulIdentifier);
				setState(1115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1111);
					match(YulComma);
					setState(1112);
					((YulVariableDeclarationContext)_localctx).YulIdentifier = match(YulIdentifier);
					((YulVariableDeclarationContext)_localctx).variables.add(((YulVariableDeclarationContext)_localctx).YulIdentifier);
					}
					}
					setState(1117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==YulAssign) {
					{
					setState(1118);
					match(YulAssign);
					setState(1119);
					yulFunctionCall();
					}
				}

				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulAssignmentContext extends ParserRuleContext {
		public List<YulPathContext> yulPath() {
			return getRuleContexts(YulPathContext.class);
		}
		public YulPathContext yulPath(int i) {
			return getRuleContext(YulPathContext.class,i);
		}
		public TerminalNode YulAssign() { return getToken(SolidityParser.YulAssign, 0); }
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public YulFunctionCallContext yulFunctionCall() {
			return getRuleContext(YulFunctionCallContext.class,0);
		}
		public List<TerminalNode> YulComma() { return getTokens(SolidityParser.YulComma); }
		public TerminalNode YulComma(int i) {
			return getToken(SolidityParser.YulComma, i);
		}
		public YulAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulAssignmentContext yulAssignment() throws RecognitionException {
		YulAssignmentContext _localctx = new YulAssignmentContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_yulAssignment);
		int _la;
		try {
			setState(1138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1124);
				yulPath();
				setState(1125);
				match(YulAssign);
				setState(1126);
				yulExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1128);
				yulPath();
				setState(1131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1129);
					match(YulComma);
					setState(1130);
					yulPath();
					}
					}
					setState(1133); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==YulComma );
				}
				setState(1135);
				match(YulAssign);
				setState(1136);
				yulFunctionCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulIfStatementContext extends ParserRuleContext {
		public YulExpressionContext cond;
		public YulBlockContext body;
		public TerminalNode YulIf() { return getToken(SolidityParser.YulIf, 0); }
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public YulIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulIfStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulIfStatementContext yulIfStatement() throws RecognitionException {
		YulIfStatementContext _localctx = new YulIfStatementContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_yulIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1140);
			match(YulIf);
			setState(1141);
			((YulIfStatementContext)_localctx).cond = yulExpression();
			setState(1142);
			((YulIfStatementContext)_localctx).body = yulBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulForStatementContext extends ParserRuleContext {
		public YulBlockContext init;
		public YulExpressionContext cond;
		public YulBlockContext post;
		public YulBlockContext body;
		public TerminalNode YulFor() { return getToken(SolidityParser.YulFor, 0); }
		public List<YulBlockContext> yulBlock() {
			return getRuleContexts(YulBlockContext.class);
		}
		public YulBlockContext yulBlock(int i) {
			return getRuleContext(YulBlockContext.class,i);
		}
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public YulForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulForStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulForStatementContext yulForStatement() throws RecognitionException {
		YulForStatementContext _localctx = new YulForStatementContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_yulForStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1144);
			match(YulFor);
			setState(1145);
			((YulForStatementContext)_localctx).init = yulBlock();
			setState(1146);
			((YulForStatementContext)_localctx).cond = yulExpression();
			setState(1147);
			((YulForStatementContext)_localctx).post = yulBlock();
			setState(1148);
			((YulForStatementContext)_localctx).body = yulBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulSwitchCaseContext extends ParserRuleContext {
		public TerminalNode YulCase() { return getToken(SolidityParser.YulCase, 0); }
		public YulLiteralContext yulLiteral() {
			return getRuleContext(YulLiteralContext.class,0);
		}
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public YulSwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulSwitchCase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulSwitchCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulSwitchCaseContext yulSwitchCase() throws RecognitionException {
		YulSwitchCaseContext _localctx = new YulSwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_yulSwitchCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1150);
			match(YulCase);
			setState(1151);
			yulLiteral();
			setState(1152);
			yulBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulSwitchStatementContext extends ParserRuleContext {
		public TerminalNode YulSwitch() { return getToken(SolidityParser.YulSwitch, 0); }
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public TerminalNode YulDefault() { return getToken(SolidityParser.YulDefault, 0); }
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public List<YulSwitchCaseContext> yulSwitchCase() {
			return getRuleContexts(YulSwitchCaseContext.class);
		}
		public YulSwitchCaseContext yulSwitchCase(int i) {
			return getRuleContext(YulSwitchCaseContext.class,i);
		}
		public YulSwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulSwitchStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulSwitchStatementContext yulSwitchStatement() throws RecognitionException {
		YulSwitchStatementContext _localctx = new YulSwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_yulSwitchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1154);
			match(YulSwitch);
			setState(1155);
			yulExpression();
			setState(1167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YulCase:
				{
				{
				setState(1157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1156);
					yulSwitchCase();
					}
					}
					setState(1159); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==YulCase );
				setState(1163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==YulDefault) {
					{
					setState(1161);
					match(YulDefault);
					setState(1162);
					yulBlock();
					}
				}

				}
				}
				break;
			case YulDefault:
				{
				{
				setState(1165);
				match(YulDefault);
				setState(1166);
				yulBlock();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulFunctionDefinitionContext extends ParserRuleContext {
		public Token YulIdentifier;
		public List<Token> arguments = new ArrayList<Token>();
		public List<Token> returnParameters = new ArrayList<Token>();
		public YulBlockContext body;
		public TerminalNode YulFunction() { return getToken(SolidityParser.YulFunction, 0); }
		public List<TerminalNode> YulIdentifier() { return getTokens(SolidityParser.YulIdentifier); }
		public TerminalNode YulIdentifier(int i) {
			return getToken(SolidityParser.YulIdentifier, i);
		}
		public TerminalNode YulLParen() { return getToken(SolidityParser.YulLParen, 0); }
		public TerminalNode YulRParen() { return getToken(SolidityParser.YulRParen, 0); }
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public TerminalNode YulArrow() { return getToken(SolidityParser.YulArrow, 0); }
		public List<TerminalNode> YulComma() { return getTokens(SolidityParser.YulComma); }
		public TerminalNode YulComma(int i) {
			return getToken(SolidityParser.YulComma, i);
		}
		public YulFunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulFunctionDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulFunctionDefinitionContext yulFunctionDefinition() throws RecognitionException {
		YulFunctionDefinitionContext _localctx = new YulFunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_yulFunctionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1169);
			match(YulFunction);
			setState(1170);
			match(YulIdentifier);
			setState(1171);
			match(YulLParen);
			setState(1180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==YulIdentifier) {
				{
				setState(1172);
				((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulFunctionDefinitionContext)_localctx).arguments.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
				setState(1177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1173);
					match(YulComma);
					setState(1174);
					((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
					((YulFunctionDefinitionContext)_localctx).arguments.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
					}
					}
					setState(1179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1182);
			match(YulRParen);
			setState(1192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==YulArrow) {
				{
				setState(1183);
				match(YulArrow);
				setState(1184);
				((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulFunctionDefinitionContext)_localctx).returnParameters.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
				setState(1189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1185);
					match(YulComma);
					setState(1186);
					((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
					((YulFunctionDefinitionContext)_localctx).returnParameters.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
					}
					}
					setState(1191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1194);
			((YulFunctionDefinitionContext)_localctx).body = yulBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulPathContext extends ParserRuleContext {
		public List<TerminalNode> YulIdentifier() { return getTokens(SolidityParser.YulIdentifier); }
		public TerminalNode YulIdentifier(int i) {
			return getToken(SolidityParser.YulIdentifier, i);
		}
		public List<TerminalNode> YulPeriod() { return getTokens(SolidityParser.YulPeriod); }
		public TerminalNode YulPeriod(int i) {
			return getToken(SolidityParser.YulPeriod, i);
		}
		public List<TerminalNode> YulEVMBuiltin() { return getTokens(SolidityParser.YulEVMBuiltin); }
		public TerminalNode YulEVMBuiltin(int i) {
			return getToken(SolidityParser.YulEVMBuiltin, i);
		}
		public YulPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulPath; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulPathContext yulPath() throws RecognitionException {
		YulPathContext _localctx = new YulPathContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_yulPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1196);
			match(YulIdentifier);
			setState(1201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==YulPeriod) {
				{
				{
				setState(1197);
				match(YulPeriod);
				setState(1198);
				_la = _input.LA(1);
				if ( !(_la==YulEVMBuiltin || _la==YulIdentifier) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(1203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulFunctionCallContext extends ParserRuleContext {
		public TerminalNode YulLParen() { return getToken(SolidityParser.YulLParen, 0); }
		public TerminalNode YulRParen() { return getToken(SolidityParser.YulRParen, 0); }
		public TerminalNode YulIdentifier() { return getToken(SolidityParser.YulIdentifier, 0); }
		public TerminalNode YulEVMBuiltin() { return getToken(SolidityParser.YulEVMBuiltin, 0); }
		public List<YulExpressionContext> yulExpression() {
			return getRuleContexts(YulExpressionContext.class);
		}
		public YulExpressionContext yulExpression(int i) {
			return getRuleContext(YulExpressionContext.class,i);
		}
		public List<TerminalNode> YulComma() { return getTokens(SolidityParser.YulComma); }
		public TerminalNode YulComma(int i) {
			return getToken(SolidityParser.YulComma, i);
		}
		public YulFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulFunctionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulFunctionCallContext yulFunctionCall() throws RecognitionException {
		YulFunctionCallContext _localctx = new YulFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_yulFunctionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1204);
			_la = _input.LA(1);
			if ( !(_la==YulEVMBuiltin || _la==YulIdentifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1205);
			match(YulLParen);
			setState(1214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 148)) & ~0x3f) == 0 && ((1L << (_la - 148)) & 8127105L) != 0)) {
				{
				setState(1206);
				yulExpression();
				setState(1211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1207);
					match(YulComma);
					setState(1208);
					yulExpression();
					}
					}
					setState(1213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1216);
			match(YulRParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulboolContext extends ParserRuleContext {
		public TerminalNode YulTrue() { return getToken(SolidityParser.YulTrue, 0); }
		public TerminalNode YulFalse() { return getToken(SolidityParser.YulFalse, 0); }
		public YulboolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulbool; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulbool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulboolContext yulbool() throws RecognitionException {
		YulboolContext _localctx = new YulboolContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_yulbool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1218);
			_la = _input.LA(1);
			if ( !(_la==YulFalse || _la==YulTrue) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulLiteralContext extends ParserRuleContext {
		public TerminalNode YulDecimalNumber() { return getToken(SolidityParser.YulDecimalNumber, 0); }
		public TerminalNode YulStringLiteral() { return getToken(SolidityParser.YulStringLiteral, 0); }
		public TerminalNode YulHexNumber() { return getToken(SolidityParser.YulHexNumber, 0); }
		public YulboolContext yulbool() {
			return getRuleContext(YulboolContext.class,0);
		}
		public TerminalNode YulHexStringLiteral() { return getToken(SolidityParser.YulHexStringLiteral, 0); }
		public YulLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulLiteralContext yulLiteral() throws RecognitionException {
		YulLiteralContext _localctx = new YulLiteralContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_yulLiteral);
		try {
			setState(1225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YulDecimalNumber:
				enterOuterAlt(_localctx, 1);
				{
				setState(1220);
				match(YulDecimalNumber);
				}
				break;
			case YulStringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(1221);
				match(YulStringLiteral);
				}
				break;
			case YulHexNumber:
				enterOuterAlt(_localctx, 3);
				{
				setState(1222);
				match(YulHexNumber);
				}
				break;
			case YulFalse:
			case YulTrue:
				enterOuterAlt(_localctx, 4);
				{
				setState(1223);
				yulbool();
				}
				break;
			case YulHexStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(1224);
				match(YulHexStringLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulExpressionContext extends ParserRuleContext {
		public YulPathContext yulPath() {
			return getRuleContext(YulPathContext.class,0);
		}
		public YulFunctionCallContext yulFunctionCall() {
			return getRuleContext(YulFunctionCallContext.class,0);
		}
		public YulLiteralContext yulLiteral() {
			return getRuleContext(YulLiteralContext.class,0);
		}
		public YulExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulExpressionContext yulExpression() throws RecognitionException {
		YulExpressionContext _localctx = new YulExpressionContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_yulExpression);
		try {
			setState(1230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1227);
				yulPath();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1228);
				yulFunctionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1229);
				yulLiteral();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 39:
			return typeName_sempred((TypeNameContext)_localctx, predIndex);
		case 45:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeName_sempred(TypeNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		case 8:
			return precpred(_ctx, 10);
		case 9:
			return precpred(_ctx, 9);
		case 10:
			return precpred(_ctx, 8);
		case 11:
			return precpred(_ctx, 7);
		case 12:
			return precpred(_ctx, 6);
		case 13:
			return precpred(_ctx, 5);
		case 14:
			return precpred(_ctx, 26);
		case 15:
			return precpred(_ctx, 25);
		case 16:
			return precpred(_ctx, 24);
		case 17:
			return precpred(_ctx, 23);
		case 18:
			return precpred(_ctx, 22);
		case 19:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u00b2\u04d1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000\u00ca\b\u0000\n\u0000\f\u0000\u00cd\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0004\u0001\u00d3\b\u0001\u000b\u0001\f"+
		"\u0001\u00d4\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002\u00dd\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002\u00e9\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u00f0\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00f8\b\u0005"+
		"\n\u0005\f\u0005\u00fb\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0003"+
		"\u0006\u0100\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0105"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0109\b\u0006\n\u0006\f\u0006"+
		"\u010c\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u0113\b\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0117\b"+
		"\u0007\n\u0007\f\u0007\u011a\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\b\u0122\b\b\n\b\f\b\u0125\t\b\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u012d\b\t\n\t\f\t\u0130\t\t\u0001"+
		"\n\u0001\n\u0003\n\u0134\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0142\b\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u014c\b\r\n"+
		"\r\f\r\u014f\t\r\u0003\r\u0151\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u0157\b\r\n\r\f\r\u015a\t\r\u0003\r\u015c\b\r\u0001\r\u0003\r\u015f"+
		"\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0166"+
		"\b\u000e\n\u000e\f\u000e\u0169\t\u000e\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u016d\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u0174\b\u0011\n\u0011\f\u0011\u0177\t\u0011\u0001\u0012\u0001"+
		"\u0012\u0003\u0012\u017b\b\u0012\u0001\u0012\u0003\u0012\u017e\b\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0183\b\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u018a\b\u0013"+
		"\n\u0013\f\u0013\u018d\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005"+
		"\u0015\u0198\b\u0015\n\u0015\f\u0015\u019b\t\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u019f\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u01a5\b\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u01a9\b"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u01b1\b\u0016\n\u0016\f\u0016\u01b4\t\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u01bb\b\u0016"+
		"\u0001\u0016\u0001\u0016\u0003\u0016\u01bf\b\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u01c5\b\u0017\u0001\u0017\u0003\u0017"+
		"\u01c8\b\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u01cc\b\u0017\n\u0017"+
		"\f\u0017\u01cf\t\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u01d3\b\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u01d8\b\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018"+
		"\u01e0\b\u0018\n\u0018\f\u0018\u01e3\t\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u01ea\b\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u01ee\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u01f8"+
		"\b\u0019\n\u0019\f\u0019\u01fb\t\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u01ff\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0004\u001a"+
		"\u0205\b\u001a\u000b\u001a\f\u001a\u0206\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0215\b\u001c\n"+
		"\u001c\f\u001c\u0218\t\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0221\b\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u022d\b\u001e\n"+
		"\u001e\f\u001e\u0230\t\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003"+
		"\u001e\u0235\b\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0003"+
		" \u0242\b \u0001 \u0003 \u0245\b \u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0005!\u024d\b!\n!\f!\u0250\t!\u0003!\u0252\b!\u0001!\u0001!\u0003!"+
		"\u0256\b!\u0001!\u0001!\u0001\"\u0001\"\u0003\"\u025c\b\"\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0005#\u0264\b#\n#\f#\u0267\t#\u0003#\u0269"+
		"\b#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0005%\u0276\b%\n%\f%\u0279\t%\u0001%\u0001%\u0003%\u027d\b%"+
		"\u0001%\u0001%\u0001%\u0003%\u0282\b%\u0001%\u0003%\u0285\b%\u0001%\u0001"+
		"%\u0001&\u0001&\u0001&\u0003&\u028c\b&\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0003\'\u0294\b\'\u0001\'\u0001\'\u0001\'\u0003\'\u0299"+
		"\b\'\u0001\'\u0005\'\u029c\b\'\n\'\f\'\u029f\t\'\u0001(\u0001(\u0001)"+
		"\u0001)\u0001)\u0001*\u0001*\u0001*\u0003*\u02a9\b*\u0001*\u0001*\u0001"+
		"*\u0005*\u02ae\b*\n*\f*\u02b1\t*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003"+
		"*\u02b8\b*\u0001+\u0001+\u0003+\u02bc\b+\u0001+\u0001+\u0001,\u0001,\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0003-\u02d4\b-\u0003"+
		"-\u02d6\b-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0003-\u0306\b-\u0001"+
		"-\u0001-\u0001-\u0001-\u0003-\u030c\b-\u0001-\u0001-\u0003-\u0310\b-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0003-\u0317\b-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0005-\u031e\b-\n-\f-\u0321\t-\u0003-\u0323\b-\u0001-\u0001-"+
		"\u0001-\u0001-\u0001-\u0005-\u032a\b-\n-\f-\u032d\t-\u0001.\u0001.\u0001"+
		"/\u0001/\u0003/\u0333\b/\u0001/\u0001/\u0003/\u0337\b/\u0005/\u0339\b"+
		"/\n/\f/\u033c\t/\u0001/\u0001/\u00010\u00010\u00010\u00010\u00050\u0344"+
		"\b0\n0\f0\u0347\t0\u00010\u00010\u00011\u00011\u00012\u00012\u00012\u0001"+
		"2\u00012\u00032\u0352\b2\u00013\u00013\u00013\u00014\u00014\u00015\u0004"+
		"5\u035a\b5\u000b5\f5\u035b\u00016\u00046\u035f\b6\u000b6\f6\u0360\u0001"+
		"7\u00047\u0364\b7\u000b7\f7\u0365\u00018\u00018\u00019\u00019\u00019\u0005"+
		"9\u036d\b9\n9\f9\u0370\t9\u00019\u00019\u0001:\u0001:\u0001:\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0003;\u0384\b;\u0001<\u0001<\u0003<\u0388\b<\u0001=\u0001=\u0001"+
		"=\u0001=\u0001=\u0001=\u0001=\u0003=\u0391\b=\u0001>\u0001>\u0001>\u0001"+
		">\u0003>\u0397\b>\u0001>\u0001>\u0003>\u039b\b>\u0001>\u0003>\u039e\b"+
		">\u0001>\u0001>\u0001>\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001"+
		"@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001A\u0001A\u0001"+
		"A\u0001B\u0001B\u0001B\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001"+
		"C\u0003C\u03be\bC\u0001C\u0001C\u0004C\u03c2\bC\u000bC\fC\u03c3\u0001"+
		"D\u0001D\u0003D\u03c8\bD\u0001D\u0001D\u0001D\u0001D\u0003D\u03ce\bD\u0001"+
		"D\u0001D\u0001E\u0001E\u0003E\u03d4\bE\u0001E\u0001E\u0001F\u0001F\u0001"+
		"F\u0001F\u0001F\u0001G\u0001G\u0001G\u0001G\u0001G\u0001H\u0001H\u0003"+
		"H\u03e4\bH\u0001H\u0003H\u03e7\bH\u0001H\u0001H\u0005H\u03eb\bH\nH\fH"+
		"\u03ee\tH\u0001H\u0001H\u0001I\u0001I\u0001I\u0001I\u0005I\u03f6\bI\n"+
		"I\fI\u03f9\tI\u0001I\u0001I\u0001J\u0001J\u0001J\u0005J\u0400\bJ\nJ\f"+
		"J\u0403\tJ\u0001K\u0001K\u0005K\u0407\bK\nK\fK\u040a\tK\u0001K\u0001K"+
		"\u0001K\u0001K\u0003K\u0410\bK\u0005K\u0412\bK\nK\fK\u0415\tK\u0001K\u0001"+
		"K\u0001L\u0001L\u0001L\u0003L\u041c\bL\u0001L\u0001L\u0001L\u0001L\u0003"+
		"L\u0422\bL\u0001L\u0001L\u0001M\u0001M\u0001M\u0001N\u0001N\u0001N\u0001"+
		"N\u0003N\u042d\bN\u0001N\u0001N\u0001N\u0003N\u0432\bN\u0001N\u0001N\u0001"+
		"O\u0001O\u0003O\u0438\bO\u0001P\u0001P\u0001P\u0001P\u0001P\u0001P\u0001"+
		"P\u0001P\u0001P\u0001P\u0001P\u0003P\u0445\bP\u0001Q\u0001Q\u0005Q\u0449"+
		"\bQ\nQ\fQ\u044c\tQ\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0001R\u0003R\u0454"+
		"\bR\u0001R\u0001R\u0001R\u0001R\u0005R\u045a\bR\nR\fR\u045d\tR\u0001R"+
		"\u0001R\u0003R\u0461\bR\u0003R\u0463\bR\u0001S\u0001S\u0001S\u0001S\u0001"+
		"S\u0001S\u0001S\u0004S\u046c\bS\u000bS\fS\u046d\u0001S\u0001S\u0001S\u0003"+
		"S\u0473\bS\u0001T\u0001T\u0001T\u0001T\u0001U\u0001U\u0001U\u0001U\u0001"+
		"U\u0001U\u0001V\u0001V\u0001V\u0001V\u0001W\u0001W\u0001W\u0004W\u0486"+
		"\bW\u000bW\fW\u0487\u0001W\u0001W\u0003W\u048c\bW\u0001W\u0001W\u0003"+
		"W\u0490\bW\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0005X\u0498\bX\n"+
		"X\fX\u049b\tX\u0003X\u049d\bX\u0001X\u0001X\u0001X\u0001X\u0001X\u0005"+
		"X\u04a4\bX\nX\fX\u04a7\tX\u0003X\u04a9\bX\u0001X\u0001X\u0001Y\u0001Y"+
		"\u0001Y\u0005Y\u04b0\bY\nY\fY\u04b3\tY\u0001Z\u0001Z\u0001Z\u0001Z\u0001"+
		"Z\u0005Z\u04ba\bZ\nZ\fZ\u04bd\tZ\u0003Z\u04bf\bZ\u0001Z\u0001Z\u0001["+
		"\u0001[\u0001\\\u0001\\\u0001\\\u0001\\\u0001\\\u0003\\\u04ca\b\\\u0001"+
		"]\u0001]\u0001]\u0003]\u04cf\b]\u0001]\u0001\u012e\u0002NZ^\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\u00ba\u0000\u0013\u0003\u0000\u0017\u0017&&12\u0003\u0000//33E"+
		"E\u0004\u0000ceimotvv\b\u0000\u0003\u0003\u0007\u0007\t\t\u001a\u001b"+
		"88::@@CC\u0003\u0000\n\n**99\u0003\u0000\u0010\u0010jjux\u0001\u0000k"+
		"m\u0001\u0000ij\u0001\u0000fh\u0001\u0000qt\u0001\u0000op\u0001\u0000"+
		"wx\u0001\u0000T_\u0006\u0000\u0015\u0015\u001d\u001d\u001f\u001f77<<\u0083"+
		"\u0083\u0002\u0000\u0019\u0019==\u0001\u0000{|\u0002\u0000\u007f\u007f"+
		"\u0081\u0081\u0002\u0000\u009d\u009d\u00a6\u00a6\u0002\u0000\u0094\u0094"+
		"\u009b\u009b\u055c\u0000\u00cb\u0001\u0000\u0000\u0000\u0002\u00d0\u0001"+
		"\u0000\u0000\u0000\u0004\u00d8\u0001\u0000\u0000\u0000\u0006\u00ec\u0001"+
		"\u0000\u0000\u0000\b\u00f1\u0001\u0000\u0000\u0000\n\u00f3\u0001\u0000"+
		"\u0000\u0000\f\u00ff\u0001\u0000\u0000\u0000\u000e\u010f\u0001\u0000\u0000"+
		"\u0000\u0010\u011d\u0001\u0000\u0000\u0000\u0012\u0128\u0001\u0000\u0000"+
		"\u0000\u0014\u0131\u0001\u0000\u0000\u0000\u0016\u0141\u0001\u0000\u0000"+
		"\u0000\u0018\u0143\u0001\u0000\u0000\u0000\u001a\u0147\u0001\u0000\u0000"+
		"\u0000\u001c\u0162\u0001\u0000\u0000\u0000\u001e\u016a\u0001\u0000\u0000"+
		"\u0000 \u016e\u0001\u0000\u0000\u0000\"\u0170\u0001\u0000\u0000\u0000"+
		"$\u0178\u0001\u0000\u0000\u0000&\u017f\u0001\u0000\u0000\u0000(\u0190"+
		"\u0001\u0000\u0000\u0000*\u0192\u0001\u0000\u0000\u0000,\u01a0\u0001\u0000"+
		"\u0000\u0000.\u01c0\u0001\u0000\u0000\u00000\u01d4\u0001\u0000\u0000\u0000"+
		"2\u01ef\u0001\u0000\u0000\u00004\u0200\u0001\u0000\u0000\u00006\u020a"+
		"\u0001\u0000\u0000\u00008\u020e\u0001\u0000\u0000\u0000:\u021b\u0001\u0000"+
		"\u0000\u0000<\u0224\u0001\u0000\u0000\u0000>\u0238\u0001\u0000\u0000\u0000"+
		"@\u023f\u0001\u0000\u0000\u0000B\u0246\u0001\u0000\u0000\u0000D\u0259"+
		"\u0001\u0000\u0000\u0000F\u025d\u0001\u0000\u0000\u0000H\u026d\u0001\u0000"+
		"\u0000\u0000J\u026f\u0001\u0000\u0000\u0000L\u0288\u0001\u0000\u0000\u0000"+
		"N\u0293\u0001\u0000\u0000\u0000P\u02a0\u0001\u0000\u0000\u0000R\u02a2"+
		"\u0001\u0000\u0000\u0000T\u02a5\u0001\u0000\u0000\u0000V\u02b9\u0001\u0000"+
		"\u0000\u0000X\u02bf\u0001\u0000\u0000\u0000Z\u02d5\u0001\u0000\u0000\u0000"+
		"\\\u032e\u0001\u0000\u0000\u0000^\u0330\u0001\u0000\u0000\u0000`\u033f"+
		"\u0001\u0000\u0000\u0000b\u034a\u0001\u0000\u0000\u0000d\u0351\u0001\u0000"+
		"\u0000\u0000f\u0353\u0001\u0000\u0000\u0000h\u0356\u0001\u0000\u0000\u0000"+
		"j\u0359\u0001\u0000\u0000\u0000l\u035e\u0001\u0000\u0000\u0000n\u0363"+
		"\u0001\u0000\u0000\u0000p\u0367\u0001\u0000\u0000\u0000r\u0369\u0001\u0000"+
		"\u0000\u0000t\u0373\u0001\u0000\u0000\u0000v\u0383\u0001\u0000\u0000\u0000"+
		"x\u0387\u0001\u0000\u0000\u0000z\u0389\u0001\u0000\u0000\u0000|\u0392"+
		"\u0001\u0000\u0000\u0000~\u03a2\u0001\u0000\u0000\u0000\u0080\u03a8\u0001"+
		"\u0000\u0000\u0000\u0082\u03b0\u0001\u0000\u0000\u0000\u0084\u03b3\u0001"+
		"\u0000\u0000\u0000\u0086\u03b6\u0001\u0000\u0000\u0000\u0088\u03c5\u0001"+
		"\u0000\u0000\u0000\u008a\u03d1\u0001\u0000\u0000\u0000\u008c\u03d7\u0001"+
		"\u0000\u0000\u0000\u008e\u03dc\u0001\u0000\u0000\u0000\u0090\u03e1\u0001"+
		"\u0000\u0000\u0000\u0092\u03f1\u0001\u0000\u0000\u0000\u0094\u03fc\u0001"+
		"\u0000\u0000\u0000\u0096\u0404\u0001\u0000\u0000\u0000\u0098\u0421\u0001"+
		"\u0000\u0000\u0000\u009a\u0425\u0001\u0000\u0000\u0000\u009c\u0428\u0001"+
		"\u0000\u0000\u0000\u009e\u0437\u0001\u0000\u0000\u0000\u00a0\u0444\u0001"+
		"\u0000\u0000\u0000\u00a2\u0446\u0001\u0000\u0000\u0000\u00a4\u0462\u0001"+
		"\u0000\u0000\u0000\u00a6\u0472\u0001\u0000\u0000\u0000\u00a8\u0474\u0001"+
		"\u0000\u0000\u0000\u00aa\u0478\u0001\u0000\u0000\u0000\u00ac\u047e\u0001"+
		"\u0000\u0000\u0000\u00ae\u0482\u0001\u0000\u0000\u0000\u00b0\u0491\u0001"+
		"\u0000\u0000\u0000\u00b2\u04ac\u0001\u0000\u0000\u0000\u00b4\u04b4\u0001"+
		"\u0000\u0000\u0000\u00b6\u04c2\u0001\u0000\u0000\u0000\u00b8\u04c9\u0001"+
		"\u0000\u0000\u0000\u00ba\u04ce\u0001\u0000\u0000\u0000\u00bc\u00ca\u0003"+
		"\u0002\u0001\u0000\u00bd\u00ca\u0003\u0004\u0002\u0000\u00be\u00ca\u0003"+
		"J%\u0000\u00bf\u00ca\u0003\f\u0006\u0000\u00c0\u00ca\u0003\u000e\u0007"+
		"\u0000\u00c1\u00ca\u0003\u0010\b\u0000\u00c2\u00ca\u0003,\u0016\u0000"+
		"\u00c3\u00ca\u0003>\u001f\u0000\u00c4\u00ca\u00034\u001a\u0000\u00c5\u00ca"+
		"\u00038\u001c\u0000\u00c6\u00ca\u0003:\u001d\u0000\u00c7\u00ca\u0003F"+
		"#\u0000\u00c8\u00ca\u0003B!\u0000\u00c9\u00bc\u0001\u0000\u0000\u0000"+
		"\u00c9\u00bd\u0001\u0000\u0000\u0000\u00c9\u00be\u0001\u0000\u0000\u0000"+
		"\u00c9\u00bf\u0001\u0000\u0000\u0000\u00c9\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c9\u00c1\u0001\u0000\u0000\u0000\u00c9\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c9\u00c3\u0001\u0000\u0000\u0000\u00c9\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c9\u00c5\u0001\u0000\u0000\u0000\u00c9\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0001\u0000\u0000\u0000"+
		"\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\u0000\u0000\u0001"+
		"\u00cf\u0001\u0001\u0000\u0000\u0000\u00d0\u00d2\u00050\u0000\u0000\u00d1"+
		"\u00d3\u0005\u00ae\u0000\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d7\u0005\u00af\u0000\u0000\u00d7\u0003\u0001\u0000\u0000\u0000\u00d8"+
		"\u00e8\u0005#\u0000\u0000\u00d9\u00dc\u0003\b\u0004\u0000\u00da\u00db"+
		"\u0005\u0005\u0000\u0000\u00db\u00dd\u0003b1\u0000\u00dc\u00da\u0001\u0000"+
		"\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00e9\u0001\u0000"+
		"\u0000\u0000\u00de\u00df\u0003\n\u0005\u0000\u00df\u00e0\u0005\u001d\u0000"+
		"\u0000\u00e0\u00e1\u0003\b\u0004\u0000\u00e1\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e3\u0005k\u0000\u0000\u00e3\u00e4\u0005\u0005\u0000\u0000\u00e4"+
		"\u00e5\u0003b1\u0000\u00e5\u00e6\u0005\u001d\u0000\u0000\u00e6\u00e7\u0003"+
		"\b\u0004\u0000\u00e7\u00e9\u0001\u0000\u0000\u0000\u00e8\u00d9\u0001\u0000"+
		"\u0000\u0000\u00e8\u00de\u0001\u0000\u0000\u0000\u00e8\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005O\u0000"+
		"\u0000\u00eb\u0005\u0001\u0000\u0000\u0000\u00ec\u00ef\u0003b1\u0000\u00ed"+
		"\u00ee\u0005\u0005\u0000\u0000\u00ee\u00f0\u0003b1\u0000\u00ef\u00ed\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u0007\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f2\u0005{\u0000\u0000\u00f2\t\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f4\u0005L\u0000\u0000\u00f4\u00f9\u0003\u0006\u0003"+
		"\u0000\u00f5\u00f6\u0005`\u0000\u0000\u00f6\u00f8\u0003\u0006\u0003\u0000"+
		"\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000"+
		"\u00f9\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fc\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0005M\u0000\u0000\u00fd\u000b\u0001\u0000\u0000\u0000\u00fe"+
		"\u0100\u0005\u0002\u0000\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u00ff"+
		"\u0100\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0005\u000f\u0000\u0000\u0102\u0104\u0003b1\u0000\u0103\u0105\u0003"+
		"\u0012\t\u0000\u0104\u0103\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000"+
		"\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u010a\u0005L\u0000"+
		"\u0000\u0107\u0109\u0003\u0016\u000b\u0000\u0108\u0107\u0001\u0000\u0000"+
		"\u0000\u0109\u010c\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000"+
		"\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u010d\u0001\u0000\u0000"+
		"\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010d\u010e\u0005M\u0000\u0000"+
		"\u010e\r\u0001\u0000\u0000\u0000\u010f\u0110\u0005%\u0000\u0000\u0110"+
		"\u0112\u0003b1\u0000\u0111\u0113\u0003\u0012\t\u0000\u0112\u0111\u0001"+
		"\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0114\u0001"+
		"\u0000\u0000\u0000\u0114\u0118\u0005L\u0000\u0000\u0115\u0117\u0003\u0016"+
		"\u000b\u0000\u0116\u0115\u0001\u0000\u0000\u0000\u0117\u011a\u0001\u0000"+
		"\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000"+
		"\u0000\u0000\u0119\u011b\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000"+
		"\u0000\u0000\u011b\u011c\u0005M\u0000\u0000\u011c\u000f\u0001\u0000\u0000"+
		"\u0000\u011d\u011e\u0005(\u0000\u0000\u011e\u011f\u0003b1\u0000\u011f"+
		"\u0123\u0005L\u0000\u0000\u0120\u0122\u0003\u0016\u000b\u0000\u0121\u0120"+
		"\u0001\u0000\u0000\u0000\u0122\u0125\u0001\u0000\u0000\u0000\u0123\u0121"+
		"\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u0126"+
		"\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0126\u0127"+
		"\u0005M\u0000\u0000\u0127\u0011\u0001\u0000\u0000\u0000\u0128\u0129\u0005"+
		"\'\u0000\u0000\u0129\u012e\u0003\u0014\n\u0000\u012a\u012b\u0005`\u0000"+
		"\u0000\u012b\u012d\u0003\u0014\n\u0000\u012c\u012a\u0001\u0000\u0000\u0000"+
		"\u012d\u0130\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000"+
		"\u012e\u012c\u0001\u0000\u0000\u0000\u012f\u0013\u0001\u0000\u0000\u0000"+
		"\u0130\u012e\u0001\u0000\u0000\u0000\u0131\u0133\u0003\u001c\u000e\u0000"+
		"\u0132\u0134\u0003\u001a\r\u0000\u0133\u0132\u0001\u0000\u0000\u0000\u0133"+
		"\u0134\u0001\u0000\u0000\u0000\u0134\u0015\u0001\u0000\u0000\u0000\u0135"+
		"\u0142\u0003&\u0013\u0000\u0136\u0142\u0003,\u0016\u0000\u0137\u0142\u0003"+
		".\u0017\u0000\u0138\u0142\u00030\u0018\u0000\u0139\u0142\u00032\u0019"+
		"\u0000\u013a\u0142\u00034\u001a\u0000\u013b\u0142\u00038\u001c\u0000\u013c"+
		"\u0142\u0003:\u001d\u0000\u013d\u0142\u0003<\u001e\u0000\u013e\u0142\u0003"+
		"B!\u0000\u013f\u0142\u0003F#\u0000\u0140\u0142\u0003J%\u0000\u0141\u0135"+
		"\u0001\u0000\u0000\u0000\u0141\u0136\u0001\u0000\u0000\u0000\u0141\u0137"+
		"\u0001\u0000\u0000\u0000\u0141\u0138\u0001\u0000\u0000\u0000\u0141\u0139"+
		"\u0001\u0000\u0000\u0000\u0141\u013a\u0001\u0000\u0000\u0000\u0141\u013b"+
		"\u0001\u0000\u0000\u0000\u0141\u013c\u0001\u0000\u0000\u0000\u0141\u013d"+
		"\u0001\u0000\u0000\u0000\u0141\u013e\u0001\u0000\u0000\u0000\u0141\u013f"+
		"\u0001\u0000\u0000\u0000\u0141\u0140\u0001\u0000\u0000\u0000\u0142\u0017"+
		"\u0001\u0000\u0000\u0000\u0143\u0144\u0003b1\u0000\u0144\u0145\u0005N"+
		"\u0000\u0000\u0145\u0146\u0003Z-\u0000\u0146\u0019\u0001\u0000\u0000\u0000"+
		"\u0147\u015e\u0005H\u0000\u0000\u0148\u014d\u0003Z-\u0000\u0149\u014a"+
		"\u0005`\u0000\u0000\u014a\u014c\u0003Z-\u0000\u014b\u0149\u0001\u0000"+
		"\u0000\u0000\u014c\u014f\u0001\u0000\u0000\u0000\u014d\u014b\u0001\u0000"+
		"\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e\u0151\u0001\u0000"+
		"\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u0150\u0148\u0001\u0000"+
		"\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u015f\u0001\u0000"+
		"\u0000\u0000\u0152\u015b\u0005L\u0000\u0000\u0153\u0158\u0003\u0018\f"+
		"\u0000\u0154\u0155\u0005`\u0000\u0000\u0155\u0157\u0003\u0018\f\u0000"+
		"\u0156\u0154\u0001\u0000\u0000\u0000\u0157\u015a\u0001\u0000\u0000\u0000"+
		"\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000"+
		"\u0159\u015c\u0001\u0000\u0000\u0000\u015a\u0158\u0001\u0000\u0000\u0000"+
		"\u015b\u0153\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000"+
		"\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015f\u0005M\u0000\u0000\u015e"+
		"\u0150\u0001\u0000\u0000\u0000\u015e\u0152\u0001\u0000\u0000\u0000\u015f"+
		"\u0160\u0001\u0000\u0000\u0000\u0160\u0161\u0005I\u0000\u0000\u0161\u001b"+
		"\u0001\u0000\u0000\u0000\u0162\u0167\u0003b1\u0000\u0163\u0164\u0005P"+
		"\u0000\u0000\u0164\u0166\u0003b1\u0000\u0165\u0163\u0001\u0000\u0000\u0000"+
		"\u0166\u0169\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000\u0000"+
		"\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u001d\u0001\u0000\u0000\u0000"+
		"\u0169\u0167\u0001\u0000\u0000\u0000\u016a\u016c\u0003\u001c\u000e\u0000"+
		"\u016b\u016d\u0003\u001a\r\u0000\u016c\u016b\u0001\u0000\u0000\u0000\u016c"+
		"\u016d\u0001\u0000\u0000\u0000\u016d\u001f\u0001\u0000\u0000\u0000\u016e"+
		"\u016f\u0007\u0000\u0000\u0000\u016f!\u0001\u0000\u0000\u0000\u0170\u0175"+
		"\u0003$\u0012\u0000\u0171\u0172\u0005`\u0000\u0000\u0172\u0174\u0003$"+
		"\u0012\u0000\u0173\u0171\u0001\u0000\u0000\u0000\u0174\u0177\u0001\u0000"+
		"\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000"+
		"\u0000\u0000\u0176#\u0001\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000"+
		"\u0000\u0178\u017a\u0003N\'\u0000\u0179\u017b\u0003X,\u0000\u017a\u0179"+
		"\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000\u0000\u0000\u017b\u017d"+
		"\u0001\u0000\u0000\u0000\u017c\u017e\u0003b1\u0000\u017d\u017c\u0001\u0000"+
		"\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e%\u0001\u0000\u0000"+
		"\u0000\u017f\u0180\u0005\r\u0000\u0000\u0180\u0182\u0005H\u0000\u0000"+
		"\u0181\u0183\u0003\"\u0011\u0000\u0182\u0181\u0001\u0000\u0000\u0000\u0182"+
		"\u0183\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184"+
		"\u018b\u0005I\u0000\u0000\u0185\u018a\u0003\u001e\u000f\u0000\u0186\u018a"+
		"\u0005/\u0000\u0000\u0187\u018a\u0005&\u0000\u0000\u0188\u018a\u00052"+
		"\u0000\u0000\u0189\u0185\u0001\u0000\u0000\u0000\u0189\u0186\u0001\u0000"+
		"\u0000\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u0188\u0001\u0000"+
		"\u0000\u0000\u018a\u018d\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000"+
		"\u0000\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u018e\u0001\u0000"+
		"\u0000\u0000\u018d\u018b\u0001\u0000\u0000\u0000\u018e\u018f\u0003r9\u0000"+
		"\u018f\'\u0001\u0000\u0000\u0000\u0190\u0191\u0007\u0001\u0000\u0000\u0191"+
		")\u0001\u0000\u0000\u0000\u0192\u019e\u0005.\u0000\u0000\u0193\u0194\u0005"+
		"H\u0000\u0000\u0194\u0199\u0003\u001c\u000e\u0000\u0195\u0196\u0005`\u0000"+
		"\u0000\u0196\u0198\u0003\u001c\u000e\u0000\u0197\u0195\u0001\u0000\u0000"+
		"\u0000\u0198\u019b\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000\u0000"+
		"\u0000\u0199\u019a\u0001\u0000\u0000\u0000\u019a\u019c\u0001\u0000\u0000"+
		"\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019c\u019d\u0005I\u0000\u0000"+
		"\u019d\u019f\u0001\u0000\u0000\u0000\u019e\u0193\u0001\u0000\u0000\u0000"+
		"\u019e\u019f\u0001\u0000\u0000\u0000\u019f+\u0001\u0000\u0000\u0000\u01a0"+
		"\u01a4\u0005\u001e\u0000\u0000\u01a1\u01a5\u0003b1\u0000\u01a2\u01a5\u0005"+
		"\u0018\u0000\u0000\u01a3\u01a5\u00054\u0000\u0000\u01a4\u01a1\u0001\u0000"+
		"\u0000\u0000\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a4\u01a3\u0001\u0000"+
		"\u0000\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000\u01a6\u01a8\u0005H\u0000"+
		"\u0000\u01a7\u01a9\u0003\"\u0011\u0000\u01a8\u01a7\u0001\u0000\u0000\u0000"+
		"\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000\u0000\u0000"+
		"\u01aa\u01b2\u0005I\u0000\u0000\u01ab\u01b1\u0003 \u0010\u0000\u01ac\u01b1"+
		"\u0003(\u0014\u0000\u01ad\u01b1\u0003\u001e\u000f\u0000\u01ae\u01b1\u0005"+
		"F\u0000\u0000\u01af\u01b1\u0003*\u0015\u0000\u01b0\u01ab\u0001\u0000\u0000"+
		"\u0000\u01b0\u01ac\u0001\u0000\u0000\u0000\u01b0\u01ad\u0001\u0000\u0000"+
		"\u0000\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b0\u01af\u0001\u0000\u0000"+
		"\u0000\u01b1\u01b4\u0001\u0000\u0000\u0000\u01b2\u01b0\u0001\u0000\u0000"+
		"\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3\u01ba\u0001\u0000\u0000"+
		"\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b5\u01b6\u00056\u0000\u0000"+
		"\u01b6\u01b7\u0005H\u0000\u0000\u01b7\u01b8\u0003\"\u0011\u0000\u01b8"+
		"\u01b9\u0005I\u0000\u0000\u01b9\u01bb\u0001\u0000\u0000\u0000\u01ba\u01b5"+
		"\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb\u01be"+
		"\u0001\u0000\u0000\u0000\u01bc\u01bf\u0005O\u0000\u0000\u01bd\u01bf\u0003"+
		"r9\u0000\u01be\u01bc\u0001\u0000\u0000\u0000\u01be\u01bd\u0001\u0000\u0000"+
		"\u0000\u01bf-\u0001\u0000\u0000\u0000\u01c0\u01c1\u0005+\u0000\u0000\u01c1"+
		"\u01c7\u0003b1\u0000\u01c2\u01c4\u0005H\u0000\u0000\u01c3\u01c5\u0003"+
		"\"\u0011\u0000\u01c4\u01c3\u0001\u0000\u0000\u0000\u01c4\u01c5\u0001\u0000"+
		"\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6\u01c8\u0005I\u0000"+
		"\u0000\u01c7\u01c2\u0001\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000"+
		"\u0000\u01c8\u01cd\u0001\u0000\u0000\u0000\u01c9\u01cc\u0005F\u0000\u0000"+
		"\u01ca\u01cc\u0003*\u0015\u0000\u01cb\u01c9\u0001\u0000\u0000\u0000\u01cb"+
		"\u01ca\u0001\u0000\u0000\u0000\u01cc\u01cf\u0001\u0000\u0000\u0000\u01cd"+
		"\u01cb\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ce"+
		"\u01d2\u0001\u0000\u0000\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000\u01d0"+
		"\u01d3\u0005O\u0000\u0000\u01d1\u01d3\u0003r9\u0000\u01d2\u01d0\u0001"+
		"\u0000\u0000\u0000\u01d2\u01d1\u0001\u0000\u0000\u0000\u01d3/\u0001\u0000"+
		"\u0000\u0000\u01d4\u01d5\u0005\u0018\u0000\u0000\u01d5\u01d7\u0005H\u0000"+
		"\u0000\u01d6\u01d8\u0003\"\u0011\u0000\u01d7\u01d6\u0001\u0000\u0000\u0000"+
		"\u01d7\u01d8\u0001\u0000\u0000\u0000\u01d8\u01d9\u0001\u0000\u0000\u0000"+
		"\u01d9\u01e1\u0005I\u0000\u0000\u01da\u01e0\u0005\u0017\u0000\u0000\u01db"+
		"\u01e0\u0003(\u0014\u0000\u01dc\u01e0\u0003\u001e\u000f\u0000\u01dd\u01e0"+
		"\u0005F\u0000\u0000\u01de\u01e0\u0003*\u0015\u0000\u01df\u01da\u0001\u0000"+
		"\u0000\u0000\u01df\u01db\u0001\u0000\u0000\u0000\u01df\u01dc\u0001\u0000"+
		"\u0000\u0000\u01df\u01dd\u0001\u0000\u0000\u0000\u01df\u01de\u0001\u0000"+
		"\u0000\u0000\u01e0\u01e3\u0001\u0000\u0000\u0000\u01e1\u01df\u0001\u0000"+
		"\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2\u01e9\u0001\u0000"+
		"\u0000\u0000\u01e3\u01e1\u0001\u0000\u0000\u0000\u01e4\u01e5\u00056\u0000"+
		"\u0000\u01e5\u01e6\u0005H\u0000\u0000\u01e6\u01e7\u0003\"\u0011\u0000"+
		"\u01e7\u01e8\u0005I\u0000\u0000\u01e8\u01ea\u0001\u0000\u0000\u0000\u01e9"+
		"\u01e4\u0001\u0000\u0000\u0000\u01e9\u01ea\u0001\u0000\u0000\u0000\u01ea"+
		"\u01ed\u0001\u0000\u0000\u0000\u01eb\u01ee\u0005O\u0000\u0000\u01ec\u01ee"+
		"\u0003r9\u0000\u01ed\u01eb\u0001\u0000\u0000\u0000\u01ed\u01ec\u0001\u0000"+
		"\u0000\u0000\u01ee1\u0001\u0000\u0000\u0000\u01ef\u01f0\u00054\u0000\u0000"+
		"\u01f0\u01f1\u0005H\u0000\u0000\u01f1\u01f9\u0005I\u0000\u0000\u01f2\u01f8"+
		"\u0005\u0017\u0000\u0000\u01f3\u01f8\u0005/\u0000\u0000\u01f4\u01f8\u0003"+
		"\u001e\u000f\u0000\u01f5\u01f8\u0005F\u0000\u0000\u01f6\u01f8\u0003*\u0015"+
		"\u0000\u01f7\u01f2\u0001\u0000\u0000\u0000\u01f7\u01f3\u0001\u0000\u0000"+
		"\u0000\u01f7\u01f4\u0001\u0000\u0000\u0000\u01f7\u01f5\u0001\u0000\u0000"+
		"\u0000\u01f7\u01f6\u0001\u0000\u0000\u0000\u01f8\u01fb\u0001\u0000\u0000"+
		"\u0000\u01f9\u01f7\u0001\u0000\u0000\u0000\u01f9\u01fa\u0001\u0000\u0000"+
		"\u0000\u01fa\u01fe\u0001\u0000\u0000\u0000\u01fb\u01f9\u0001\u0000\u0000"+
		"\u0000\u01fc\u01ff\u0005O\u0000\u0000\u01fd\u01ff\u0003r9\u0000\u01fe"+
		"\u01fc\u0001\u0000\u0000\u0000\u01fe\u01fd\u0001\u0000\u0000\u0000\u01ff"+
		"3\u0001\u0000\u0000\u0000\u0200\u0201\u0005;\u0000\u0000\u0201\u0202\u0003"+
		"b1\u0000\u0202\u0204\u0005L\u0000\u0000\u0203\u0205\u00036\u001b\u0000"+
		"\u0204\u0203\u0001\u0000\u0000\u0000\u0205\u0206\u0001\u0000\u0000\u0000"+
		"\u0206\u0204\u0001\u0000\u0000\u0000\u0206\u0207\u0001\u0000\u0000\u0000"+
		"\u0207\u0208\u0001\u0000\u0000\u0000\u0208\u0209\u0005M\u0000\u0000\u0209"+
		"5\u0001\u0000\u0000\u0000\u020a\u020b\u0003N\'\u0000\u020b\u020c\u0003"+
		"b1\u0000\u020c\u020d\u0005O\u0000\u0000\u020d7\u0001\u0000\u0000\u0000"+
		"\u020e\u020f\u0005\u0014\u0000\u0000\u020f\u0210\u0003b1\u0000\u0210\u0211"+
		"\u0005L\u0000\u0000\u0211\u0216\u0003b1\u0000\u0212\u0213\u0005`\u0000"+
		"\u0000\u0213\u0215\u0003b1\u0000\u0214\u0212\u0001\u0000\u0000\u0000\u0215"+
		"\u0218\u0001\u0000\u0000\u0000\u0216\u0214\u0001\u0000\u0000\u0000\u0216"+
		"\u0217\u0001\u0000\u0000\u0000\u0217\u0219\u0001\u0000\u0000\u0000\u0218"+
		"\u0216\u0001\u0000\u0000\u0000\u0219\u021a\u0005M\u0000\u0000\u021a9\u0001"+
		"\u0000\u0000\u0000\u021b\u021c\u0005?\u0000\u0000\u021c\u021d\u0003b1"+
		"\u0000\u021d\u0220\u0005\'\u0000\u0000\u021e\u0221\u0003P(\u0000\u021f"+
		"\u0221\u0003R)\u0000\u0220\u021e\u0001\u0000\u0000\u0000\u0220\u021f\u0001"+
		"\u0000\u0000\u0000\u0221\u0222\u0001\u0000\u0000\u0000\u0222\u0223\u0005"+
		"O\u0000\u0000\u0223;\u0001\u0000\u0000\u0000\u0224\u022e\u0003N\'\u0000"+
		"\u0225\u022d\u00052\u0000\u0000\u0226\u022d\u00051\u0000\u0000\u0227\u022d"+
		"\u0005&\u0000\u0000\u0228\u022d\u0005\f\u0000\u0000\u0229\u022d\u0003"+
		"*\u0015\u0000\u022a\u022d\u0005\"\u0000\u0000\u022b\u022d\u0005<\u0000"+
		"\u0000\u022c\u0225\u0001\u0000\u0000\u0000\u022c\u0226\u0001\u0000\u0000"+
		"\u0000\u022c\u0227\u0001\u0000\u0000\u0000\u022c\u0228\u0001\u0000\u0000"+
		"\u0000\u022c\u0229\u0001\u0000\u0000\u0000\u022c\u022a\u0001\u0000\u0000"+
		"\u0000\u022c\u022b\u0001\u0000\u0000\u0000\u022d\u0230\u0001\u0000\u0000"+
		"\u0000\u022e\u022c\u0001\u0000\u0000\u0000\u022e\u022f\u0001\u0000\u0000"+
		"\u0000\u022f\u0231\u0001\u0000\u0000\u0000\u0230\u022e\u0001\u0000\u0000"+
		"\u0000\u0231\u0234\u0003b1\u0000\u0232\u0233\u0005T\u0000\u0000\u0233"+
		"\u0235\u0003Z-\u0000\u0234\u0232\u0001\u0000\u0000\u0000\u0234\u0235\u0001"+
		"\u0000\u0000\u0000\u0235\u0236\u0001\u0000\u0000\u0000\u0236\u0237\u0005"+
		"O\u0000\u0000\u0237=\u0001\u0000\u0000\u0000\u0238\u0239\u0003N\'\u0000"+
		"\u0239\u023a\u0005\f\u0000\u0000\u023a\u023b\u0003b1\u0000\u023b\u023c"+
		"\u0005T\u0000\u0000\u023c\u023d\u0003Z-\u0000\u023d\u023e\u0005O\u0000"+
		"\u0000\u023e?\u0001\u0000\u0000\u0000\u023f\u0241\u0003N\'\u0000\u0240"+
		"\u0242\u0005$\u0000\u0000\u0241\u0240\u0001\u0000\u0000\u0000\u0241\u0242"+
		"\u0001\u0000\u0000\u0000\u0242\u0244\u0001\u0000\u0000\u0000\u0243\u0245"+
		"\u0003b1\u0000\u0244\u0243\u0001\u0000\u0000\u0000\u0244\u0245\u0001\u0000"+
		"\u0000\u0000\u0245A\u0001\u0000\u0000\u0000\u0246\u0247\u0005\u0016\u0000"+
		"\u0000\u0247\u0248\u0003b1\u0000\u0248\u0251\u0005H\u0000\u0000\u0249"+
		"\u024e\u0003@ \u0000\u024a\u024b\u0005`\u0000\u0000\u024b\u024d\u0003"+
		"@ \u0000\u024c\u024a\u0001\u0000\u0000\u0000\u024d\u0250\u0001\u0000\u0000"+
		"\u0000\u024e\u024c\u0001\u0000\u0000\u0000\u024e\u024f\u0001\u0000\u0000"+
		"\u0000\u024f\u0252\u0001\u0000\u0000\u0000\u0250\u024e\u0001\u0000\u0000"+
		"\u0000\u0251\u0249\u0001\u0000\u0000\u0000\u0251\u0252\u0001\u0000\u0000"+
		"\u0000\u0252\u0253\u0001\u0000\u0000\u0000\u0253\u0255\u0005I\u0000\u0000"+
		"\u0254\u0256\u0005\u0004\u0000\u0000\u0255\u0254\u0001\u0000\u0000\u0000"+
		"\u0255\u0256\u0001\u0000\u0000\u0000\u0256\u0257\u0001\u0000\u0000\u0000"+
		"\u0257\u0258\u0005O\u0000\u0000\u0258C\u0001\u0000\u0000\u0000\u0259\u025b"+
		"\u0003N\'\u0000\u025a\u025c\u0003b1\u0000\u025b\u025a\u0001\u0000\u0000"+
		"\u0000\u025b\u025c\u0001\u0000\u0000\u0000\u025cE\u0001\u0000\u0000\u0000"+
		"\u025d\u025e\u0005\u0015\u0000\u0000\u025e\u025f\u0003b1\u0000\u025f\u0268"+
		"\u0005H\u0000\u0000\u0260\u0265\u0003D\"\u0000\u0261\u0262\u0005`\u0000"+
		"\u0000\u0262\u0264\u0003D\"\u0000\u0263\u0261\u0001\u0000\u0000\u0000"+
		"\u0264\u0267\u0001\u0000\u0000\u0000\u0265\u0263\u0001\u0000\u0000\u0000"+
		"\u0265\u0266\u0001\u0000\u0000\u0000\u0266\u0269\u0001\u0000\u0000\u0000"+
		"\u0267\u0265\u0001\u0000\u0000\u0000\u0268\u0260\u0001\u0000\u0000\u0000"+
		"\u0268\u0269\u0001\u0000\u0000\u0000\u0269\u026a\u0001\u0000\u0000\u0000"+
		"\u026a\u026b\u0005I\u0000\u0000\u026b\u026c\u0005O\u0000\u0000\u026cG"+
		"\u0001\u0000\u0000\u0000\u026d\u026e\u0007\u0002\u0000\u0000\u026eI\u0001"+
		"\u0000\u0000\u0000\u026f\u027c\u0005D\u0000\u0000\u0270\u027d\u0003\u001c"+
		"\u000e\u0000\u0271\u0272\u0005L\u0000\u0000\u0272\u0277\u0003L&\u0000"+
		"\u0273\u0274\u0005`\u0000\u0000\u0274\u0276\u0003L&\u0000\u0275\u0273"+
		"\u0001\u0000\u0000\u0000\u0276\u0279\u0001\u0000\u0000\u0000\u0277\u0275"+
		"\u0001\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278\u027a"+
		"\u0001\u0000\u0000\u0000\u0279\u0277\u0001\u0000\u0000\u0000\u027a\u027b"+
		"\u0005M\u0000\u0000\u027b\u027d\u0001\u0000\u0000\u0000\u027c\u0270\u0001"+
		"\u0000\u0000\u0000\u027c\u0271\u0001\u0000\u0000\u0000\u027d\u027e\u0001"+
		"\u0000\u0000\u0000\u027e\u0281\u0005\u001c\u0000\u0000\u027f\u0282\u0005"+
		"k\u0000\u0000\u0280\u0282\u0003N\'\u0000\u0281\u027f\u0001\u0000\u0000"+
		"\u0000\u0281\u0280\u0001\u0000\u0000\u0000\u0282\u0284\u0001\u0000\u0000"+
		"\u0000\u0283\u0285\u0005\u001f\u0000\u0000\u0284\u0283\u0001\u0000\u0000"+
		"\u0000\u0284\u0285\u0001\u0000\u0000\u0000\u0285\u0286\u0001\u0000\u0000"+
		"\u0000\u0286\u0287\u0005O\u0000\u0000\u0287K\u0001\u0000\u0000\u0000\u0288"+
		"\u028b\u0003\u001c\u000e\u0000\u0289\u028a\u0005\u0005\u0000\u0000\u028a"+
		"\u028c\u0003H$\u0000\u028b\u0289\u0001\u0000\u0000\u0000\u028b\u028c\u0001"+
		"\u0000\u0000\u0000\u028cM\u0001\u0000\u0000\u0000\u028d\u028e\u0006\'"+
		"\uffff\uffff\u0000\u028e\u0294\u0003P(\u0000\u028f\u0294\u0003R)\u0000"+
		"\u0290\u0294\u0003T*\u0000\u0291\u0294\u0003\u009cN\u0000\u0292\u0294"+
		"\u0003\u001c\u000e\u0000\u0293\u028d\u0001\u0000\u0000\u0000\u0293\u028f"+
		"\u0001\u0000\u0000\u0000\u0293\u0290\u0001\u0000\u0000\u0000\u0293\u0291"+
		"\u0001\u0000\u0000\u0000\u0293\u0292\u0001\u0000\u0000\u0000\u0294\u029d"+
		"\u0001\u0000\u0000\u0000\u0295\u0296\n\u0001\u0000\u0000\u0296\u0298\u0005"+
		"J\u0000\u0000\u0297\u0299\u0003Z-\u0000\u0298\u0297\u0001\u0000\u0000"+
		"\u0000\u0298\u0299\u0001\u0000\u0000\u0000\u0299\u029a\u0001\u0000\u0000"+
		"\u0000\u029a\u029c\u0005K\u0000\u0000\u029b\u0295\u0001\u0000\u0000\u0000"+
		"\u029c\u029f\u0001\u0000\u0000\u0000\u029d\u029b\u0001\u0000\u0000\u0000"+
		"\u029d\u029e\u0001\u0000\u0000\u0000\u029eO\u0001\u0000\u0000\u0000\u029f"+
		"\u029d\u0001\u0000\u0000\u0000\u02a0\u02a1\u0007\u0003\u0000\u0000\u02a1"+
		"Q\u0001\u0000\u0000\u0000\u02a2\u02a3\u0005\u0003\u0000\u0000\u02a3\u02a4"+
		"\u0005/\u0000\u0000\u02a4S\u0001\u0000\u0000\u0000\u02a5\u02a6\u0005\u001e"+
		"\u0000\u0000\u02a6\u02a8\u0005H\u0000\u0000\u02a7\u02a9\u0003\"\u0011"+
		"\u0000\u02a8\u02a7\u0001\u0000\u0000\u0000\u02a8\u02a9\u0001\u0000\u0000"+
		"\u0000\u02a9\u02aa\u0001\u0000\u0000\u0000\u02aa\u02af\u0005I\u0000\u0000"+
		"\u02ab\u02ae\u0003 \u0010\u0000\u02ac\u02ae\u0003(\u0014\u0000\u02ad\u02ab"+
		"\u0001\u0000\u0000\u0000\u02ad\u02ac\u0001\u0000\u0000\u0000\u02ae\u02b1"+
		"\u0001\u0000\u0000\u0000\u02af\u02ad\u0001\u0000\u0000\u0000\u02af\u02b0"+
		"\u0001\u0000\u0000\u0000\u02b0\u02b7\u0001\u0000\u0000\u0000\u02b1\u02af"+
		"\u0001\u0000\u0000\u0000\u02b2\u02b3\u00056\u0000\u0000\u02b3\u02b4\u0005"+
		"H\u0000\u0000\u02b4\u02b5\u0003\"\u0011\u0000\u02b5\u02b6\u0005I\u0000"+
		"\u0000\u02b6\u02b8\u0001\u0000\u0000\u0000\u02b7\u02b2\u0001\u0000\u0000"+
		"\u0000\u02b7\u02b8\u0001\u0000\u0000\u0000\u02b8U\u0001\u0000\u0000\u0000"+
		"\u02b9\u02bb\u0003N\'\u0000\u02ba\u02bc\u0003X,\u0000\u02bb\u02ba\u0001"+
		"\u0000\u0000\u0000\u02bb\u02bc\u0001\u0000\u0000\u0000\u02bc\u02bd\u0001"+
		"\u0000\u0000\u0000\u02bd\u02be\u0003b1\u0000\u02beW\u0001\u0000\u0000"+
		"\u0000\u02bf\u02c0\u0007\u0004\u0000\u0000\u02c0Y\u0001\u0000\u0000\u0000"+
		"\u02c1\u02c2\u0006-\uffff\uffff\u0000\u02c2\u02c3\u0005/\u0000\u0000\u02c3"+
		"\u02d6\u0003\u001a\r\u0000\u02c4\u02c5\u0005?\u0000\u0000\u02c5\u02c6"+
		"\u0005H\u0000\u0000\u02c6\u02c7\u0003N\'\u0000\u02c7\u02c8\u0005I\u0000"+
		"\u0000\u02c8\u02d6\u0001\u0000\u0000\u0000\u02c9\u02ca\u0007\u0005\u0000"+
		"\u0000\u02ca\u02d6\u0003Z-\u0013\u02cb\u02cc\u0005,\u0000\u0000\u02cc"+
		"\u02d6\u0003N\'\u0000\u02cd\u02d6\u0003^/\u0000\u02ce\u02d6\u0003`0\u0000"+
		"\u02cf\u02d4\u0003b1\u0000\u02d0\u02d4\u0003d2\u0000\u02d1\u02d4\u0003"+
		"f3\u0000\u02d2\u02d4\u0003P(\u0000\u02d3\u02cf\u0001\u0000\u0000\u0000"+
		"\u02d3\u02d0\u0001\u0000\u0000\u0000\u02d3\u02d1\u0001\u0000\u0000\u0000"+
		"\u02d3\u02d2\u0001\u0000\u0000\u0000\u02d4\u02d6\u0001\u0000\u0000\u0000"+
		"\u02d5\u02c1\u0001\u0000\u0000\u0000\u02d5\u02c4\u0001\u0000\u0000\u0000"+
		"\u02d5\u02c9\u0001\u0000\u0000\u0000\u02d5\u02cb\u0001\u0000\u0000\u0000"+
		"\u02d5\u02cd\u0001\u0000\u0000\u0000\u02d5\u02ce\u0001\u0000\u0000\u0000"+
		"\u02d5\u02d3\u0001\u0000\u0000\u0000\u02d6\u032b\u0001\u0000\u0000\u0000"+
		"\u02d7\u02d8\n\u0011\u0000\u0000\u02d8\u02d9\u0005n\u0000\u0000\u02d9"+
		"\u032a\u0003Z-\u0011\u02da\u02db\n\u0010\u0000\u0000\u02db\u02dc\u0007"+
		"\u0006\u0000\u0000\u02dc\u032a\u0003Z-\u0011\u02dd\u02de\n\u000f\u0000"+
		"\u0000\u02de\u02df\u0007\u0007\u0000\u0000\u02df\u032a\u0003Z-\u0010\u02e0"+
		"\u02e1\n\u000e\u0000\u0000\u02e1\u02e2\u0007\b\u0000\u0000\u02e2\u032a"+
		"\u0003Z-\u000f\u02e3\u02e4\n\r\u0000\u0000\u02e4\u02e5\u0005e\u0000\u0000"+
		"\u02e5\u032a\u0003Z-\u000e\u02e6\u02e7\n\f\u0000\u0000\u02e7\u02e8\u0005"+
		"d\u0000\u0000\u02e8\u032a\u0003Z-\r\u02e9\u02ea\n\u000b\u0000\u0000\u02ea"+
		"\u02eb\u0005c\u0000\u0000\u02eb\u032a\u0003Z-\f\u02ec\u02ed\n\n\u0000"+
		"\u0000\u02ed\u02ee\u0007\t\u0000\u0000\u02ee\u032a\u0003Z-\u000b\u02ef"+
		"\u02f0\n\t\u0000\u0000\u02f0\u02f1\u0007\n\u0000\u0000\u02f1\u032a\u0003"+
		"Z-\n\u02f2\u02f3\n\b\u0000\u0000\u02f3\u02f4\u0005b\u0000\u0000\u02f4"+
		"\u032a\u0003Z-\t\u02f5\u02f6\n\u0007\u0000\u0000\u02f6\u02f7\u0005a\u0000"+
		"\u0000\u02f7\u032a\u0003Z-\b\u02f8\u02f9\n\u0006\u0000\u0000\u02f9\u02fa"+
		"\u0005Q\u0000\u0000\u02fa\u02fb\u0003Z-\u0000\u02fb\u02fc\u0005N\u0000"+
		"\u0000\u02fc\u02fd\u0003Z-\u0006\u02fd\u032a\u0001\u0000\u0000\u0000\u02fe"+
		"\u02ff\n\u0005\u0000\u0000\u02ff\u0300\u0003\\.\u0000\u0300\u0301\u0003"+
		"Z-\u0005\u0301\u032a\u0001\u0000\u0000\u0000\u0302\u0303\n\u001a\u0000"+
		"\u0000\u0303\u0305\u0005J\u0000\u0000\u0304\u0306\u0003Z-\u0000\u0305"+
		"\u0304\u0001\u0000\u0000\u0000\u0305\u0306\u0001\u0000\u0000\u0000\u0306"+
		"\u0307\u0001\u0000\u0000\u0000\u0307\u032a\u0005K\u0000\u0000\u0308\u0309"+
		"\n\u0019\u0000\u0000\u0309\u030b\u0005J\u0000\u0000\u030a\u030c\u0003"+
		"Z-\u0000\u030b\u030a\u0001\u0000\u0000\u0000\u030b\u030c\u0001\u0000\u0000"+
		"\u0000\u030c\u030d\u0001\u0000\u0000\u0000\u030d\u030f\u0005N\u0000\u0000"+
		"\u030e\u0310\u0003Z-\u0000\u030f\u030e\u0001\u0000\u0000\u0000\u030f\u0310"+
		"\u0001\u0000\u0000\u0000\u0310\u0311\u0001\u0000\u0000\u0000\u0311\u032a"+
		"\u0005K\u0000\u0000\u0312\u0313\n\u0018\u0000\u0000\u0313\u0316\u0005"+
		"P\u0000\u0000\u0314\u0317\u0003b1\u0000\u0315\u0317\u0005\u0003\u0000"+
		"\u0000\u0316\u0314\u0001\u0000\u0000\u0000\u0316\u0315\u0001\u0000\u0000"+
		"\u0000\u0317\u032a\u0001\u0000\u0000\u0000\u0318\u0319\n\u0017\u0000\u0000"+
		"\u0319\u0322\u0005L\u0000\u0000\u031a\u031f\u0003\u0018\f\u0000\u031b"+
		"\u031c\u0005`\u0000\u0000\u031c\u031e\u0003\u0018\f\u0000\u031d\u031b"+
		"\u0001\u0000\u0000\u0000\u031e\u0321\u0001\u0000\u0000\u0000\u031f\u031d"+
		"\u0001\u0000\u0000\u0000\u031f\u0320\u0001\u0000\u0000\u0000\u0320\u0323"+
		"\u0001\u0000\u0000\u0000\u0321\u031f\u0001\u0000\u0000\u0000\u0322\u031a"+
		"\u0001\u0000\u0000\u0000\u0322\u0323\u0001\u0000\u0000\u0000\u0323\u0324"+
		"\u0001\u0000\u0000\u0000\u0324\u032a\u0005M\u0000\u0000\u0325\u0326\n"+
		"\u0016\u0000\u0000\u0326\u032a\u0003\u001a\r\u0000\u0327\u0328\n\u0012"+
		"\u0000\u0000\u0328\u032a\u0007\u000b\u0000\u0000\u0329\u02d7\u0001\u0000"+
		"\u0000\u0000\u0329\u02da\u0001\u0000\u0000\u0000\u0329\u02dd\u0001\u0000"+
		"\u0000\u0000\u0329\u02e0\u0001\u0000\u0000\u0000\u0329\u02e3\u0001\u0000"+
		"\u0000\u0000\u0329\u02e6\u0001\u0000\u0000\u0000\u0329\u02e9\u0001\u0000"+
		"\u0000\u0000\u0329\u02ec\u0001\u0000\u0000\u0000\u0329\u02ef\u0001\u0000"+
		"\u0000\u0000\u0329\u02f2\u0001\u0000\u0000\u0000\u0329\u02f5\u0001\u0000"+
		"\u0000\u0000\u0329\u02f8\u0001\u0000\u0000\u0000\u0329\u02fe\u0001\u0000"+
		"\u0000\u0000\u0329\u0302\u0001\u0000\u0000\u0000\u0329\u0308\u0001\u0000"+
		"\u0000\u0000\u0329\u0312\u0001\u0000\u0000\u0000\u0329\u0318\u0001\u0000"+
		"\u0000\u0000\u0329\u0325\u0001\u0000\u0000\u0000\u0329\u0327\u0001\u0000"+
		"\u0000\u0000\u032a\u032d\u0001\u0000\u0000\u0000\u032b\u0329\u0001\u0000"+
		"\u0000\u0000\u032b\u032c\u0001\u0000\u0000\u0000\u032c[\u0001\u0000\u0000"+
		"\u0000\u032d\u032b\u0001\u0000\u0000\u0000\u032e\u032f\u0007\f\u0000\u0000"+
		"\u032f]\u0001\u0000\u0000\u0000\u0330\u0332\u0005H\u0000\u0000\u0331\u0333"+
		"\u0003Z-\u0000\u0332\u0331\u0001\u0000\u0000\u0000\u0332\u0333\u0001\u0000"+
		"\u0000\u0000\u0333\u033a\u0001\u0000\u0000\u0000\u0334\u0336\u0005`\u0000"+
		"\u0000\u0335\u0337\u0003Z-\u0000\u0336\u0335\u0001\u0000\u0000\u0000\u0336"+
		"\u0337\u0001\u0000\u0000\u0000\u0337\u0339\u0001\u0000\u0000\u0000\u0338"+
		"\u0334\u0001\u0000\u0000\u0000\u0339\u033c\u0001\u0000\u0000\u0000\u033a"+
		"\u0338\u0001\u0000\u0000\u0000\u033a\u033b\u0001\u0000\u0000\u0000\u033b"+
		"\u033d\u0001\u0000\u0000\u0000\u033c\u033a\u0001\u0000\u0000\u0000\u033d"+
		"\u033e\u0005I\u0000\u0000\u033e_\u0001\u0000\u0000\u0000\u033f\u0340\u0005"+
		"J\u0000\u0000\u0340\u0345\u0003Z-\u0000\u0341\u0342\u0005`\u0000\u0000"+
		"\u0342\u0344\u0003Z-\u0000\u0343\u0341\u0001\u0000\u0000\u0000\u0344\u0347"+
		"\u0001\u0000\u0000\u0000\u0345\u0343\u0001\u0000\u0000\u0000\u0345\u0346"+
		"\u0001\u0000\u0000\u0000\u0346\u0348\u0001\u0000\u0000\u0000\u0347\u0345"+
		"\u0001\u0000\u0000\u0000\u0348\u0349\u0005K\u0000\u0000\u0349a\u0001\u0000"+
		"\u0000\u0000\u034a\u034b\u0007\r\u0000\u0000\u034bc\u0001\u0000\u0000"+
		"\u0000\u034c\u0352\u0003j5\u0000\u034d\u0352\u0003p8\u0000\u034e\u0352"+
		"\u0003h4\u0000\u034f\u0352\u0003l6\u0000\u0350\u0352\u0003n7\u0000\u0351"+
		"\u034c\u0001\u0000\u0000\u0000\u0351\u034d\u0001\u0000\u0000\u0000\u0351"+
		"\u034e\u0001\u0000\u0000\u0000\u0351\u034f\u0001\u0000\u0000\u0000\u0351"+
		"\u0350\u0001\u0000\u0000\u0000\u0352e\u0001\u0000\u0000\u0000\u0353\u0354"+
		"\u0003p8\u0000\u0354\u0355\u0005-\u0000\u0000\u0355g\u0001\u0000\u0000"+
		"\u0000\u0356\u0357\u0007\u000e\u0000\u0000\u0357i\u0001\u0000\u0000\u0000"+
		"\u0358\u035a\u0007\u000f\u0000\u0000\u0359\u0358\u0001\u0000\u0000\u0000"+
		"\u035a\u035b\u0001\u0000\u0000\u0000\u035b\u0359\u0001\u0000\u0000\u0000"+
		"\u035b\u035c\u0001\u0000\u0000\u0000\u035ck\u0001\u0000\u0000\u0000\u035d"+
		"\u035f\u0005~\u0000\u0000\u035e\u035d\u0001\u0000\u0000\u0000\u035f\u0360"+
		"\u0001\u0000\u0000\u0000\u0360\u035e\u0001\u0000\u0000\u0000\u0360\u0361"+
		"\u0001\u0000\u0000\u0000\u0361m\u0001\u0000\u0000\u0000\u0362\u0364\u0005"+
		"}\u0000\u0000\u0363\u0362\u0001\u0000\u0000\u0000\u0364\u0365\u0001\u0000"+
		"\u0000\u0000\u0365\u0363\u0001\u0000\u0000\u0000\u0365\u0366\u0001\u0000"+
		"\u0000\u0000\u0366o\u0001\u0000\u0000\u0000\u0367\u0368\u0007\u0010\u0000"+
		"\u0000\u0368q\u0001\u0000\u0000\u0000\u0369\u036e\u0005L\u0000\u0000\u036a"+
		"\u036d\u0003v;\u0000\u036b\u036d\u0003t:\u0000\u036c\u036a\u0001\u0000"+
		"\u0000\u0000\u036c\u036b\u0001\u0000\u0000\u0000\u036d\u0370\u0001\u0000"+
		"\u0000\u0000\u036e\u036c\u0001\u0000\u0000\u0000\u036e\u036f\u0001\u0000"+
		"\u0000\u0000\u036f\u0371\u0001\u0000\u0000\u0000\u0370\u036e\u0001\u0000"+
		"\u0000\u0000\u0371\u0372\u0005M\u0000\u0000\u0372s\u0001\u0000\u0000\u0000"+
		"\u0373\u0374\u0005A\u0000\u0000\u0374\u0375\u0003r9\u0000\u0375u\u0001"+
		"\u0000\u0000\u0000\u0376\u0384\u0003r9\u0000\u0377\u0384\u0003x<\u0000"+
		"\u0378\u0384\u0003z=\u0000\u0379\u0384\u0003|>\u0000\u037a\u0384\u0003"+
		"~?\u0000\u037b\u0384\u0003\u0080@\u0000\u037c\u0384\u0003\u0082A\u0000"+
		"\u037d\u0384\u0003\u0084B\u0000\u037e\u0384\u0003\u0086C\u0000\u037f\u0384"+
		"\u0003\u008aE\u0000\u0380\u0384\u0003\u008cF\u0000\u0381\u0384\u0003\u008e"+
		"G\u0000\u0382\u0384\u0003\u0090H\u0000\u0383\u0376\u0001\u0000\u0000\u0000"+
		"\u0383\u0377\u0001\u0000\u0000\u0000\u0383\u0378\u0001\u0000\u0000\u0000"+
		"\u0383\u0379\u0001\u0000\u0000\u0000\u0383\u037a\u0001\u0000\u0000\u0000"+
		"\u0383\u037b\u0001\u0000\u0000\u0000\u0383\u037c\u0001\u0000\u0000\u0000"+
		"\u0383\u037d\u0001\u0000\u0000\u0000\u0383\u037e\u0001\u0000\u0000\u0000"+
		"\u0383\u037f\u0001\u0000\u0000\u0000\u0383\u0380\u0001\u0000\u0000\u0000"+
		"\u0383\u0381\u0001\u0000\u0000\u0000\u0383\u0382\u0001\u0000\u0000\u0000"+
		"\u0384w\u0001\u0000\u0000\u0000\u0385\u0388\u0003\u0098L\u0000\u0386\u0388"+
		"\u0003\u009aM\u0000\u0387\u0385\u0001\u0000\u0000\u0000\u0387\u0386\u0001"+
		"\u0000\u0000\u0000\u0388y\u0001\u0000\u0000\u0000\u0389\u038a\u0005!\u0000"+
		"\u0000\u038a\u038b\u0005H\u0000\u0000\u038b\u038c\u0003Z-\u0000\u038c"+
		"\u038d\u0005I\u0000\u0000\u038d\u0390\u0003v;\u0000\u038e\u038f\u0005"+
		"\u0012\u0000\u0000\u038f\u0391\u0003v;\u0000\u0390\u038e\u0001\u0000\u0000"+
		"\u0000\u0390\u0391\u0001\u0000\u0000\u0000\u0391{\u0001\u0000\u0000\u0000"+
		"\u0392\u0393\u0005\u001c\u0000\u0000\u0393\u0396\u0005H\u0000\u0000\u0394"+
		"\u0397\u0003x<\u0000\u0395\u0397\u0005O\u0000\u0000\u0396\u0394\u0001"+
		"\u0000\u0000\u0000\u0396\u0395\u0001\u0000\u0000\u0000\u0397\u039a\u0001"+
		"\u0000\u0000\u0000\u0398\u039b\u0003\u009aM\u0000\u0399\u039b\u0005O\u0000"+
		"\u0000\u039a\u0398\u0001\u0000\u0000\u0000\u039a\u0399\u0001\u0000\u0000"+
		"\u0000\u039b\u039d\u0001\u0000\u0000\u0000\u039c\u039e\u0003Z-\u0000\u039d"+
		"\u039c\u0001\u0000\u0000\u0000\u039d\u039e\u0001\u0000\u0000\u0000\u039e"+
		"\u039f\u0001\u0000\u0000\u0000\u039f\u03a0\u0005I\u0000\u0000\u03a0\u03a1"+
		"\u0003v;\u0000\u03a1}\u0001\u0000\u0000\u0000\u03a2\u03a3\u0005G\u0000"+
		"\u0000\u03a3\u03a4\u0005H\u0000\u0000\u03a4\u03a5\u0003Z-\u0000\u03a5"+
		"\u03a6\u0005I\u0000\u0000\u03a6\u03a7\u0003v;\u0000\u03a7\u007f\u0001"+
		"\u0000\u0000\u0000\u03a8\u03a9\u0005\u0011\u0000\u0000\u03a9\u03aa\u0003"+
		"v;\u0000\u03aa\u03ab\u0005G\u0000\u0000\u03ab\u03ac\u0005H\u0000\u0000"+
		"\u03ac\u03ad\u0003Z-\u0000\u03ad\u03ae\u0005I\u0000\u0000\u03ae\u03af"+
		"\u0005O\u0000\u0000\u03af\u0081\u0001\u0000\u0000\u0000\u03b0\u03b1\u0005"+
		"\u000e\u0000\u0000\u03b1\u03b2\u0005O\u0000\u0000\u03b2\u0083\u0001\u0000"+
		"\u0000\u0000\u03b3\u03b4\u0005\b\u0000\u0000\u03b4\u03b5\u0005O\u0000"+
		"\u0000\u03b5\u0085\u0001\u0000\u0000\u0000\u03b6\u03b7\u0005>\u0000\u0000"+
		"\u03b7\u03bd\u0003Z-\u0000\u03b8\u03b9\u00056\u0000\u0000\u03b9\u03ba"+
		"\u0005H\u0000\u0000\u03ba\u03bb\u0003\"\u0011\u0000\u03bb\u03bc\u0005"+
		"I\u0000\u0000\u03bc\u03be\u0001\u0000\u0000\u0000\u03bd\u03b8\u0001\u0000"+
		"\u0000\u0000\u03bd\u03be\u0001\u0000\u0000\u0000\u03be\u03bf\u0001\u0000"+
		"\u0000\u0000\u03bf\u03c1\u0003r9\u0000\u03c0\u03c2\u0003\u0088D\u0000"+
		"\u03c1\u03c0\u0001\u0000\u0000\u0000\u03c2\u03c3\u0001\u0000\u0000\u0000"+
		"\u03c3\u03c1\u0001\u0000\u0000\u0000\u03c3\u03c4\u0001\u0000\u0000\u0000"+
		"\u03c4\u0087\u0001\u0000\u0000\u0000\u03c5\u03cd\u0005\u000b\u0000\u0000"+
		"\u03c6\u03c8\u0003b1\u0000\u03c7\u03c6\u0001\u0000\u0000\u0000\u03c7\u03c8"+
		"\u0001\u0000\u0000\u0000\u03c8\u03c9\u0001\u0000\u0000\u0000\u03c9\u03ca"+
		"\u0005H\u0000\u0000\u03ca\u03cb\u0003\"\u0011\u0000\u03cb\u03cc\u0005"+
		"I\u0000\u0000\u03cc\u03ce\u0001\u0000\u0000\u0000\u03cd\u03c7\u0001\u0000"+
		"\u0000\u0000\u03cd\u03ce\u0001\u0000\u0000\u0000\u03ce\u03cf\u0001\u0000"+
		"\u0000\u0000\u03cf\u03d0\u0003r9\u0000\u03d0\u0089\u0001\u0000\u0000\u0000"+
		"\u03d1\u03d3\u00055\u0000\u0000\u03d2\u03d4\u0003Z-\u0000\u03d3\u03d2"+
		"\u0001\u0000\u0000\u0000\u03d3\u03d4\u0001\u0000\u0000\u0000\u03d4\u03d5"+
		"\u0001\u0000\u0000\u0000\u03d5\u03d6\u0005O\u0000\u0000\u03d6\u008b\u0001"+
		"\u0000\u0000\u0000\u03d7\u03d8\u0005\u0013\u0000\u0000\u03d8\u03d9\u0003"+
		"Z-\u0000\u03d9\u03da\u0003\u001a\r\u0000\u03da\u03db\u0005O\u0000\u0000"+
		"\u03db\u008d\u0001\u0000\u0000\u0000\u03dc\u03dd\u00057\u0000\u0000\u03dd"+
		"\u03de\u0003Z-\u0000\u03de\u03df\u0003\u001a\r\u0000\u03df\u03e0\u0005"+
		"O\u0000\u0000\u03e0\u008f\u0001\u0000\u0000\u0000\u03e1\u03e3\u0005\u0006"+
		"\u0000\u0000\u03e2\u03e4\u0005\u0087\u0000\u0000\u03e3\u03e2\u0001\u0000"+
		"\u0000\u0000\u03e3\u03e4\u0001\u0000\u0000\u0000\u03e4\u03e6\u0001\u0000"+
		"\u0000\u0000\u03e5\u03e7\u0003\u0092I\u0000\u03e6\u03e5\u0001\u0000\u0000"+
		"\u0000\u03e6\u03e7\u0001\u0000\u0000\u0000\u03e7\u03e8\u0001\u0000\u0000"+
		"\u0000\u03e8\u03ec\u0005\u0088\u0000\u0000\u03e9\u03eb\u0003\u00a0P\u0000"+
		"\u03ea\u03e9\u0001\u0000\u0000\u0000\u03eb\u03ee\u0001\u0000\u0000\u0000"+
		"\u03ec\u03ea\u0001\u0000\u0000\u0000\u03ec\u03ed\u0001\u0000\u0000\u0000"+
		"\u03ed\u03ef\u0001\u0000\u0000\u0000\u03ee\u03ec\u0001\u0000\u0000\u0000"+
		"\u03ef\u03f0\u0005\u009f\u0000\u0000\u03f0\u0091\u0001\u0000\u0000\u0000"+
		"\u03f1\u03f2\u0005\u008a\u0000\u0000\u03f2\u03f7\u0005\u0089\u0000\u0000"+
		"\u03f3\u03f4\u0005\u008c\u0000\u0000\u03f4\u03f6\u0005\u0089\u0000\u0000"+
		"\u03f5\u03f3\u0001\u0000\u0000\u0000\u03f6\u03f9\u0001\u0000\u0000\u0000"+
		"\u03f7\u03f5\u0001\u0000\u0000\u0000\u03f7\u03f8\u0001\u0000\u0000\u0000"+
		"\u03f8\u03fa\u0001\u0000\u0000\u0000\u03f9\u03f7\u0001\u0000\u0000\u0000"+
		"\u03fa\u03fb\u0005\u008b\u0000\u0000\u03fb\u0093\u0001\u0000\u0000\u0000"+
		"\u03fc\u0401\u0003V+\u0000\u03fd\u03fe\u0005`\u0000\u0000\u03fe\u0400"+
		"\u0003V+\u0000\u03ff\u03fd\u0001\u0000\u0000\u0000\u0400\u0403\u0001\u0000"+
		"\u0000\u0000\u0401\u03ff\u0001\u0000\u0000\u0000\u0401\u0402\u0001\u0000"+
		"\u0000\u0000\u0402\u0095\u0001\u0000\u0000\u0000\u0403\u0401\u0001\u0000"+
		"\u0000\u0000\u0404\u0408\u0005H\u0000\u0000\u0405\u0407\u0005`\u0000\u0000"+
		"\u0406\u0405\u0001\u0000\u0000\u0000\u0407\u040a\u0001\u0000\u0000\u0000"+
		"\u0408\u0406\u0001\u0000\u0000\u0000\u0408\u0409\u0001\u0000\u0000\u0000"+
		"\u0409\u040b\u0001\u0000\u0000\u0000\u040a\u0408\u0001\u0000\u0000\u0000"+
		"\u040b\u040c\u0003V+\u0000\u040c\u0413\u0001\u0000\u0000\u0000\u040d\u040f"+
		"\u0005`\u0000\u0000\u040e\u0410\u0003V+\u0000\u040f\u040e\u0001\u0000"+
		"\u0000\u0000\u040f\u0410\u0001\u0000\u0000\u0000\u0410\u0412\u0001\u0000"+
		"\u0000\u0000\u0411\u040d\u0001\u0000\u0000\u0000\u0412\u0415\u0001\u0000"+
		"\u0000\u0000\u0413\u0411\u0001\u0000\u0000\u0000\u0413\u0414\u0001\u0000"+
		"\u0000\u0000\u0414\u0416\u0001\u0000\u0000\u0000\u0415\u0413\u0001\u0000"+
		"\u0000\u0000\u0416\u0417\u0005I\u0000\u0000\u0417\u0097\u0001\u0000\u0000"+
		"\u0000\u0418\u041b\u0003V+\u0000\u0419\u041a\u0005T\u0000\u0000\u041a"+
		"\u041c\u0003Z-\u0000\u041b\u0419\u0001\u0000\u0000\u0000\u041b\u041c\u0001"+
		"\u0000\u0000\u0000\u041c\u0422\u0001\u0000\u0000\u0000\u041d\u041e\u0003"+
		"\u0096K\u0000\u041e\u041f\u0005T\u0000\u0000\u041f\u0420\u0003Z-\u0000"+
		"\u0420\u0422\u0001\u0000\u0000\u0000\u0421\u0418\u0001\u0000\u0000\u0000"+
		"\u0421\u041d\u0001\u0000\u0000\u0000\u0422\u0423\u0001\u0000\u0000\u0000"+
		"\u0423\u0424\u0005O\u0000\u0000\u0424\u0099\u0001\u0000\u0000\u0000\u0425"+
		"\u0426\u0003Z-\u0000\u0426\u0427\u0005O\u0000\u0000\u0427\u009b\u0001"+
		"\u0000\u0000\u0000\u0428\u0429\u0005)\u0000\u0000\u0429\u042a\u0005H\u0000"+
		"\u0000\u042a\u042c\u0003\u009eO\u0000\u042b\u042d\u0003b1\u0000\u042c"+
		"\u042b\u0001\u0000\u0000\u0000\u042c\u042d\u0001\u0000\u0000\u0000\u042d"+
		"\u042e\u0001\u0000\u0000\u0000\u042e\u042f\u0005R\u0000\u0000\u042f\u0431"+
		"\u0003N\'\u0000\u0430\u0432\u0003b1\u0000\u0431\u0430\u0001\u0000\u0000"+
		"\u0000\u0431\u0432\u0001\u0000\u0000\u0000\u0432\u0433\u0001\u0000\u0000"+
		"\u0000\u0433\u0434\u0005I\u0000\u0000\u0434\u009d\u0001\u0000\u0000\u0000"+
		"\u0435\u0438\u0003P(\u0000\u0436\u0438\u0003\u001c\u000e\u0000\u0437\u0435"+
		"\u0001\u0000\u0000\u0000\u0437\u0436\u0001\u0000\u0000\u0000\u0438\u009f"+
		"\u0001\u0000\u0000\u0000\u0439\u0445\u0003\u00a2Q\u0000\u043a\u0445\u0003"+
		"\u00a4R\u0000\u043b\u0445\u0003\u00a6S\u0000\u043c\u0445\u0003\u00b4Z"+
		"\u0000\u043d\u0445\u0003\u00a8T\u0000\u043e\u0445\u0003\u00aaU\u0000\u043f"+
		"\u0445\u0003\u00aeW\u0000\u0440\u0445\u0005\u0098\u0000\u0000\u0441\u0445"+
		"\u0005\u0090\u0000\u0000\u0442\u0445\u0005\u0092\u0000\u0000\u0443\u0445"+
		"\u0003\u00b0X\u0000\u0444\u0439\u0001\u0000\u0000\u0000\u0444\u043a\u0001"+
		"\u0000\u0000\u0000\u0444\u043b\u0001\u0000\u0000\u0000\u0444\u043c\u0001"+
		"\u0000\u0000\u0000\u0444\u043d\u0001\u0000\u0000\u0000\u0444\u043e\u0001"+
		"\u0000\u0000\u0000\u0444\u043f\u0001\u0000\u0000\u0000\u0444\u0440\u0001"+
		"\u0000\u0000\u0000\u0444\u0441\u0001\u0000\u0000\u0000\u0444\u0442\u0001"+
		"\u0000\u0000\u0000\u0444\u0443\u0001\u0000\u0000\u0000\u0445\u00a1\u0001"+
		"\u0000\u0000\u0000\u0446\u044a\u0005\u009e\u0000\u0000\u0447\u0449\u0003"+
		"\u00a0P\u0000\u0448\u0447\u0001\u0000\u0000\u0000\u0449\u044c\u0001\u0000"+
		"\u0000\u0000\u044a\u0448\u0001\u0000\u0000\u0000\u044a\u044b\u0001\u0000"+
		"\u0000\u0000\u044b\u044d\u0001\u0000\u0000\u0000\u044c\u044a\u0001\u0000"+
		"\u0000\u0000\u044d\u044e\u0005\u009f\u0000\u0000\u044e\u00a3\u0001\u0000"+
		"\u0000\u0000\u044f\u0450\u0005\u0099\u0000\u0000\u0450\u0453\u0005\u00a6"+
		"\u0000\u0000\u0451\u0452\u0005\u00a2\u0000\u0000\u0452\u0454\u0003\u00ba"+
		"]\u0000\u0453\u0451\u0001\u0000\u0000\u0000\u0453\u0454\u0001\u0000\u0000"+
		"\u0000\u0454\u0463\u0001\u0000\u0000\u0000\u0455\u0456\u0005\u0099\u0000"+
		"\u0000\u0456\u045b\u0005\u00a6\u0000\u0000\u0457\u0458\u0005\u00a4\u0000"+
		"\u0000\u0458\u045a\u0005\u00a6\u0000\u0000\u0459\u0457\u0001\u0000\u0000"+
		"\u0000\u045a\u045d\u0001\u0000\u0000\u0000\u045b\u0459\u0001\u0000\u0000"+
		"\u0000\u045b\u045c\u0001\u0000\u0000\u0000\u045c\u0460\u0001\u0000\u0000"+
		"\u0000\u045d\u045b\u0001\u0000\u0000\u0000\u045e\u045f\u0005\u00a2\u0000"+
		"\u0000\u045f\u0461\u0003\u00b4Z\u0000\u0460\u045e\u0001\u0000\u0000\u0000"+
		"\u0460\u0461\u0001\u0000\u0000\u0000\u0461\u0463\u0001\u0000\u0000\u0000"+
		"\u0462\u044f\u0001\u0000\u0000\u0000\u0462\u0455\u0001\u0000\u0000\u0000"+
		"\u0463\u00a5\u0001\u0000\u0000\u0000\u0464\u0465\u0003\u00b2Y\u0000\u0465"+
		"\u0466\u0005\u00a2\u0000\u0000\u0466\u0467\u0003\u00ba]\u0000\u0467\u0473"+
		"\u0001\u0000\u0000\u0000\u0468\u046b\u0003\u00b2Y\u0000\u0469\u046a\u0005"+
		"\u00a4\u0000\u0000\u046a\u046c\u0003\u00b2Y\u0000\u046b\u0469\u0001\u0000"+
		"\u0000\u0000\u046c\u046d\u0001\u0000\u0000\u0000\u046d\u046b\u0001\u0000"+
		"\u0000\u0000\u046d\u046e\u0001\u0000\u0000\u0000\u046e\u046f\u0001\u0000"+
		"\u0000\u0000\u046f\u0470\u0005\u00a2\u0000\u0000\u0470\u0471\u0003\u00b4"+
		"Z\u0000\u0471\u0473\u0001\u0000\u0000\u0000\u0472\u0464\u0001\u0000\u0000"+
		"\u0000\u0472\u0468\u0001\u0000\u0000\u0000\u0473\u00a7\u0001\u0000\u0000"+
		"\u0000\u0474\u0475\u0005\u0097\u0000\u0000\u0475\u0476\u0003\u00ba]\u0000"+
		"\u0476\u0477\u0003\u00a2Q\u0000\u0477\u00a9\u0001\u0000\u0000\u0000\u0478"+
		"\u0479\u0005\u0095\u0000\u0000\u0479\u047a\u0003\u00a2Q\u0000\u047a\u047b"+
		"\u0003\u00ba]\u0000\u047b\u047c\u0003\u00a2Q\u0000\u047c\u047d\u0003\u00a2"+
		"Q\u0000\u047d\u00ab\u0001\u0000\u0000\u0000\u047e\u047f\u0005\u0091\u0000"+
		"\u0000\u047f\u0480\u0003\u00b8\\\u0000\u0480\u0481\u0003\u00a2Q\u0000"+
		"\u0481\u00ad\u0001\u0000\u0000\u0000\u0482\u0483\u0005\u009a\u0000\u0000"+
		"\u0483\u048f\u0003\u00ba]\u0000\u0484\u0486\u0003\u00acV\u0000\u0485\u0484"+
		"\u0001\u0000\u0000\u0000\u0486\u0487\u0001\u0000\u0000\u0000\u0487\u0485"+
		"\u0001\u0000\u0000\u0000\u0487\u0488\u0001\u0000\u0000\u0000\u0488\u048b"+
		"\u0001\u0000\u0000\u0000\u0489\u048a\u0005\u0093\u0000\u0000\u048a\u048c"+
		"\u0003\u00a2Q\u0000\u048b\u0489\u0001\u0000\u0000\u0000\u048b\u048c\u0001"+
		"\u0000\u0000\u0000\u048c\u0490\u0001\u0000\u0000\u0000\u048d\u048e\u0005"+
		"\u0093\u0000\u0000\u048e\u0490\u0003\u00a2Q\u0000\u048f\u0485\u0001\u0000"+
		"\u0000\u0000\u048f\u048d\u0001\u0000\u0000\u0000\u0490\u00af\u0001\u0000"+
		"\u0000\u0000\u0491\u0492\u0005\u0096\u0000\u0000\u0492\u0493\u0005\u00a6"+
		"\u0000\u0000\u0493\u049c\u0005\u00a0\u0000\u0000\u0494\u0499\u0005\u00a6"+
		"\u0000\u0000\u0495\u0496\u0005\u00a4\u0000\u0000\u0496\u0498\u0005\u00a6"+
		"\u0000\u0000\u0497\u0495\u0001\u0000\u0000\u0000\u0498\u049b\u0001\u0000"+
		"\u0000\u0000\u0499\u0497\u0001\u0000\u0000\u0000\u0499\u049a\u0001\u0000"+
		"\u0000\u0000\u049a\u049d\u0001\u0000\u0000\u0000\u049b\u0499\u0001\u0000"+
		"\u0000\u0000\u049c\u0494\u0001\u0000\u0000\u0000\u049c\u049d\u0001\u0000"+
		"\u0000\u0000\u049d\u049e\u0001\u0000\u0000\u0000\u049e\u04a8\u0005\u00a1"+
		"\u0000\u0000\u049f\u04a0\u0005\u00a5\u0000\u0000\u04a0\u04a5\u0005\u00a6"+
		"\u0000\u0000\u04a1\u04a2\u0005\u00a4\u0000\u0000\u04a2\u04a4\u0005\u00a6"+
		"\u0000\u0000\u04a3\u04a1\u0001\u0000\u0000\u0000\u04a4\u04a7\u0001\u0000"+
		"\u0000\u0000\u04a5\u04a3\u0001\u0000\u0000\u0000\u04a5\u04a6\u0001\u0000"+
		"\u0000\u0000\u04a6\u04a9\u0001\u0000\u0000\u0000\u04a7\u04a5\u0001\u0000"+
		"\u0000\u0000\u04a8\u049f\u0001\u0000\u0000\u0000\u04a8\u04a9\u0001\u0000"+
		"\u0000\u0000\u04a9\u04aa\u0001\u0000\u0000\u0000\u04aa\u04ab\u0003\u00a2"+
		"Q\u0000\u04ab\u00b1\u0001\u0000\u0000\u0000\u04ac\u04b1\u0005\u00a6\u0000"+
		"\u0000\u04ad\u04ae\u0005\u00a3\u0000\u0000\u04ae\u04b0\u0007\u0011\u0000"+
		"\u0000\u04af\u04ad\u0001\u0000\u0000\u0000\u04b0\u04b3\u0001\u0000\u0000"+
		"\u0000\u04b1\u04af\u0001\u0000\u0000\u0000\u04b1\u04b2\u0001\u0000\u0000"+
		"\u0000\u04b2\u00b3\u0001\u0000\u0000\u0000\u04b3\u04b1\u0001\u0000\u0000"+
		"\u0000\u04b4\u04b5\u0007\u0011\u0000\u0000\u04b5\u04be\u0005\u00a0\u0000"+
		"\u0000\u04b6\u04bb\u0003\u00ba]\u0000\u04b7\u04b8\u0005\u00a4\u0000\u0000"+
		"\u04b8\u04ba\u0003\u00ba]\u0000\u04b9\u04b7\u0001\u0000\u0000\u0000\u04ba"+
		"\u04bd\u0001\u0000\u0000\u0000\u04bb\u04b9\u0001\u0000\u0000\u0000\u04bb"+
		"\u04bc\u0001\u0000\u0000\u0000\u04bc\u04bf\u0001\u0000\u0000\u0000\u04bd"+
		"\u04bb\u0001\u0000\u0000\u0000\u04be\u04b6\u0001\u0000\u0000\u0000\u04be"+
		"\u04bf\u0001\u0000\u0000\u0000\u04bf\u04c0\u0001\u0000\u0000\u0000\u04c0"+
		"\u04c1\u0005\u00a1\u0000\u0000\u04c1\u00b5\u0001\u0000\u0000\u0000\u04c2"+
		"\u04c3\u0007\u0012\u0000\u0000\u04c3\u00b7\u0001\u0000\u0000\u0000\u04c4"+
		"\u04ca\u0005\u00a8\u0000\u0000\u04c5\u04ca\u0005\u00a9\u0000\u0000\u04c6"+
		"\u04ca\u0005\u00a7\u0000\u0000\u04c7\u04ca\u0003\u00b6[\u0000\u04c8\u04ca"+
		"\u0005\u00aa\u0000\u0000\u04c9\u04c4\u0001\u0000\u0000\u0000\u04c9\u04c5"+
		"\u0001\u0000\u0000\u0000\u04c9\u04c6\u0001\u0000\u0000\u0000\u04c9\u04c7"+
		"\u0001\u0000\u0000\u0000\u04c9\u04c8\u0001\u0000\u0000\u0000\u04ca\u00b9"+
		"\u0001\u0000\u0000\u0000\u04cb\u04cf\u0003\u00b2Y\u0000\u04cc\u04cf\u0003"+
		"\u00b4Z\u0000\u04cd\u04cf\u0003\u00b8\\\u0000\u04ce\u04cb\u0001\u0000"+
		"\u0000\u0000\u04ce\u04cc\u0001\u0000\u0000\u0000\u04ce\u04cd\u0001\u0000"+
		"\u0000\u0000\u04cf\u00bb\u0001\u0000\u0000\u0000\u008d\u00c9\u00cb\u00d4"+
		"\u00dc\u00e8\u00ef\u00f9\u00ff\u0104\u010a\u0112\u0118\u0123\u012e\u0133"+
		"\u0141\u014d\u0150\u0158\u015b\u015e\u0167\u016c\u0175\u017a\u017d\u0182"+
		"\u0189\u018b\u0199\u019e\u01a4\u01a8\u01b0\u01b2\u01ba\u01be\u01c4\u01c7"+
		"\u01cb\u01cd\u01d2\u01d7\u01df\u01e1\u01e9\u01ed\u01f7\u01f9\u01fe\u0206"+
		"\u0216\u0220\u022c\u022e\u0234\u0241\u0244\u024e\u0251\u0255\u025b\u0265"+
		"\u0268\u0277\u027c\u0281\u0284\u028b\u0293\u0298\u029d\u02a8\u02ad\u02af"+
		"\u02b7\u02bb\u02d3\u02d5\u0305\u030b\u030f\u0316\u031f\u0322\u0329\u032b"+
		"\u0332\u0336\u033a\u0345\u0351\u035b\u0360\u0365\u036c\u036e\u0383\u0387"+
		"\u0390\u0396\u039a\u039d\u03bd\u03c3\u03c7\u03cd\u03d3\u03e3\u03e6\u03ec"+
		"\u03f7\u0401\u0408\u040f\u0413\u041b\u0421\u042c\u0431\u0437\u0444\u044a"+
		"\u0453\u045b\u0460\u0462\u046d\u0472\u0487\u048b\u048f\u0499\u049c\u04a5"+
		"\u04a8\u04b1\u04bb\u04be\u04c9\u04ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}