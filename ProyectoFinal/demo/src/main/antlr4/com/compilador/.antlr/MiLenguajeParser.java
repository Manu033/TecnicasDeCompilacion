// Generated from c:/Documentos Manu/Facultad UBP/Semestre 9/TC/TCGit/ProyectoFinal/demo/src/main/antlr4/com/compilador/MiLenguaje.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiLenguajeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FOR=1, WHILE=2, IF=3, ELSE=4, INT=5, CHAR=6, DOUBLE=7, BOOL=8, VOID=9, 
		STRING=10, RETURN=11, BREAK=12, CONTINUE=13, PA=14, PC=15, CA=16, CC=17, 
		LA=18, LC=19, PYC=20, COMA=21, IGUAL=22, MAYOR=23, MAYOR_IGUAL=24, MENOR=25, 
		MENOR_IGUAL=26, EQL=27, DISTINTO=28, SUM=29, RES=30, MUL=31, DIV=32, MOD=33, 
		OR=34, AND=35, NOT=36, INTEGER=37, DECIMAL=38, CHARACTER=39, STRING_LITERAL=40, 
		ID=41, COMENTARIO_LINEA=42, COMENTARIO_BLOQUE=43, WS=44, OTRO=45;
	public static final int
		RULE_programa = 0, RULE_sentencia = 1, RULE_sentenciaInterior = 2, RULE_sentenciaBreak = 3, 
		RULE_sentenciaContinue = 4, RULE_sentenciaIf = 5, RULE_bloque = 6, RULE_declaracionFuncion = 7, 
		RULE_sentenciaWhile = 8, RULE_sentenciaFor = 9, RULE_parametros = 10, 
		RULE_parametro = 11, RULE_declaracionVariable = 12, RULE_asignacion = 13, 
		RULE_retorno = 14, RULE_tipo = 15, RULE_expresion = 16, RULE_argumentos = 17, 
		RULE_comparadorBinario = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "sentencia", "sentenciaInterior", "sentenciaBreak", "sentenciaContinue", 
			"sentenciaIf", "bloque", "declaracionFuncion", "sentenciaWhile", "sentenciaFor", 
			"parametros", "parametro", "declaracionVariable", "asignacion", "retorno", 
			"tipo", "expresion", "argumentos", "comparadorBinario"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'for'", "'while'", "'if'", "'else'", "'int'", "'char'", "'double'", 
			"'bool'", "'void'", "'String'", "'return'", "'break'", "'continue'", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "','", "'='", "'>'", 
			"'>='", "'<'", "'<='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'||'", "'&&'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FOR", "WHILE", "IF", "ELSE", "INT", "CHAR", "DOUBLE", "BOOL", 
			"VOID", "STRING", "RETURN", "BREAK", "CONTINUE", "PA", "PC", "CA", "CC", 
			"LA", "LC", "PYC", "COMA", "IGUAL", "MAYOR", "MAYOR_IGUAL", "MENOR", 
			"MENOR_IGUAL", "EQL", "DISTINTO", "SUM", "RES", "MUL", "DIV", "MOD", 
			"OR", "AND", "NOT", "INTEGER", "DECIMAL", "CHARACTER", "STRING_LITERAL", 
			"ID", "COMENTARIO_LINEA", "COMENTARIO_BLOQUE", "WS", "OTRO"
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
	public String getGrammarFileName() { return "MiLenguaje.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiLenguajeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiLenguajeParser.EOF, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023257568L) != 0)) {
				{
				{
				setState(38);
				sentencia();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
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
	public static class SentenciaContext extends ParserRuleContext {
		public DeclaracionFuncionContext declaracionFuncion() {
			return getRuleContext(DeclaracionFuncionContext.class,0);
		}
		public DeclaracionVariableContext declaracionVariable() {
			return getRuleContext(DeclaracionVariableContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentencia);
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				declaracionFuncion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				declaracionVariable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				asignacion();
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
	public static class SentenciaInteriorContext extends ParserRuleContext {
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public RetornoContext retorno() {
			return getRuleContext(RetornoContext.class,0);
		}
		public SentenciaBreakContext sentenciaBreak() {
			return getRuleContext(SentenciaBreakContext.class,0);
		}
		public SentenciaContinueContext sentenciaContinue() {
			return getRuleContext(SentenciaContinueContext.class,0);
		}
		public SentenciaIfContext sentenciaIf() {
			return getRuleContext(SentenciaIfContext.class,0);
		}
		public SentenciaWhileContext sentenciaWhile() {
			return getRuleContext(SentenciaWhileContext.class,0);
		}
		public SentenciaForContext sentenciaFor() {
			return getRuleContext(SentenciaForContext.class,0);
		}
		public SentenciaInteriorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaInterior; }
	}

	public final SentenciaInteriorContext sentenciaInterior() throws RecognitionException {
		SentenciaInteriorContext _localctx = new SentenciaInteriorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sentenciaInterior);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case CHAR:
			case DOUBLE:
			case BOOL:
			case VOID:
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				sentencia();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				retorno();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				sentenciaBreak();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				sentenciaContinue();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				sentenciaIf();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 6);
				{
				setState(56);
				sentenciaWhile();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 7);
				{
				setState(57);
				sentenciaFor();
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
	public static class SentenciaBreakContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(MiLenguajeParser.BREAK, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public SentenciaBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaBreak; }
	}

	public final SentenciaBreakContext sentenciaBreak() throws RecognitionException {
		SentenciaBreakContext _localctx = new SentenciaBreakContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sentenciaBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(BREAK);
			setState(61);
			match(PYC);
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
	public static class SentenciaContinueContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(MiLenguajeParser.CONTINUE, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public SentenciaContinueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaContinue; }
	}

	public final SentenciaContinueContext sentenciaContinue() throws RecognitionException {
		SentenciaContinueContext _localctx = new SentenciaContinueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sentenciaContinue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(CONTINUE);
			setState(64);
			match(PYC);
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
	public static class SentenciaIfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiLenguajeParser.IF, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiLenguajeParser.ELSE, 0); }
		public SentenciaIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaIf; }
	}

	public final SentenciaIfContext sentenciaIf() throws RecognitionException {
		SentenciaIfContext _localctx = new SentenciaIfContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sentenciaIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(IF);
			setState(67);
			match(PA);
			setState(68);
			expresion(0);
			setState(69);
			match(PC);
			setState(70);
			bloque();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(71);
				match(ELSE);
				setState(72);
				bloque();
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
	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LA() { return getToken(MiLenguajeParser.LA, 0); }
		public TerminalNode LC() { return getToken(MiLenguajeParser.LC, 0); }
		public List<SentenciaInteriorContext> sentenciaInterior() {
			return getRuleContexts(SentenciaInteriorContext.class);
		}
		public SentenciaInteriorContext sentenciaInterior(int i) {
			return getRuleContext(SentenciaInteriorContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(LA);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023271918L) != 0)) {
				{
				{
				setState(76);
				sentenciaInterior();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(LC);
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
	public static class DeclaracionFuncionContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public DeclaracionFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionFuncion; }
	}

	public final DeclaracionFuncionContext declaracionFuncion() throws RecognitionException {
		DeclaracionFuncionContext _localctx = new DeclaracionFuncionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaracionFuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			tipo();
			setState(85);
			match(ID);
			setState(86);
			match(PA);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2016L) != 0)) {
				{
				setState(87);
				parametros();
				}
			}

			setState(90);
			match(PC);
			setState(91);
			bloque();
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
	public static class SentenciaWhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiLenguajeParser.WHILE, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public SentenciaWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaWhile; }
	}

	public final SentenciaWhileContext sentenciaWhile() throws RecognitionException {
		SentenciaWhileContext _localctx = new SentenciaWhileContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sentenciaWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(WHILE);
			setState(94);
			match(PA);
			setState(95);
			expresion(0);
			setState(96);
			match(PC);
			setState(97);
			bloque();
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
	public static class SentenciaForContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiLenguajeParser.FOR, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public List<TerminalNode> PYC() { return getTokens(MiLenguajeParser.PYC); }
		public TerminalNode PYC(int i) {
			return getToken(MiLenguajeParser.PYC, i);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public DeclaracionVariableContext declaracionVariable() {
			return getRuleContext(DeclaracionVariableContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public SentenciaForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaFor; }
	}

	public final SentenciaForContext sentenciaFor() throws RecognitionException {
		SentenciaForContext _localctx = new SentenciaForContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sentenciaFor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(FOR);
			setState(100);
			match(PA);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2016L) != 0)) {
				{
				setState(101);
				declaracionVariable();
				}
			}

			setState(104);
			match(PYC);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4329327050752L) != 0)) {
				{
				setState(105);
				expresion(0);
				}
			}

			setState(108);
			match(PYC);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(109);
				asignacion();
				}
			}

			setState(112);
			match(PC);
			setState(113);
			bloque();
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
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MiLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MiLenguajeParser.COMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			parametro();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(116);
				match(COMA);
				setState(117);
				parametro();
				}
				}
				setState(122);
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
	public static class ParametroContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			tipo();
			setState(124);
			match(ID);
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
	public static class DeclaracionVariableContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public TerminalNode CA() { return getToken(MiLenguajeParser.CA, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode CC() { return getToken(MiLenguajeParser.CC, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public DeclaracionVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionVariable; }
	}

	public final DeclaracionVariableContext declaracionVariable() throws RecognitionException {
		DeclaracionVariableContext _localctx = new DeclaracionVariableContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declaracionVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			tipo();
			setState(127);
			match(ID);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CA) {
				{
				setState(128);
				match(CA);
				setState(129);
				expresion(0);
				setState(130);
				match(CC);
				}
			}

			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(134);
				match(IGUAL);
				setState(135);
				expresion(0);
				}
			}

			setState(138);
			match(PYC);
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
	public static class AsignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public List<TerminalNode> SUM() { return getTokens(MiLenguajeParser.SUM); }
		public TerminalNode SUM(int i) {
			return getToken(MiLenguajeParser.SUM, i);
		}
		public List<TerminalNode> RES() { return getTokens(MiLenguajeParser.RES); }
		public TerminalNode RES(int i) {
			return getToken(MiLenguajeParser.RES, i);
		}
		public TerminalNode CA() { return getToken(MiLenguajeParser.CA, 0); }
		public TerminalNode CC() { return getToken(MiLenguajeParser.CC, 0); }
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_asignacion);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(ID);
				setState(141);
				match(IGUAL);
				setState(142);
				expresion(0);
				setState(143);
				match(PYC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(ID);
				setState(146);
				match(SUM);
				setState(147);
				match(SUM);
				setState(148);
				match(PYC);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				match(ID);
				setState(150);
				match(RES);
				setState(151);
				match(RES);
				setState(152);
				match(PYC);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				match(ID);
				setState(154);
				match(CA);
				setState(155);
				expresion(0);
				setState(156);
				match(CC);
				setState(157);
				match(IGUAL);
				setState(158);
				expresion(0);
				setState(159);
				match(PYC);
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
	public static class RetornoContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiLenguajeParser.RETURN, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public RetornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retorno; }
	}

	public final RetornoContext retorno() throws RecognitionException {
		RetornoContext _localctx = new RetornoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_retorno);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(RETURN);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4329327050752L) != 0)) {
				{
				setState(164);
				expresion(0);
				}
			}

			setState(167);
			match(PYC);
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
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiLenguajeParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(MiLenguajeParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(MiLenguajeParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(MiLenguajeParser.VOID, 0); }
		public TerminalNode STRING() { return getToken(MiLenguajeParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(MiLenguajeParser.BOOL, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2016L) != 0)) ) {
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
	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpComparacionContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ComparadorBinarioContext comparadorBinario() {
			return getRuleContext(ComparadorBinarioContext.class,0);
		}
		public ExpComparacionContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpNegacionContext extends ExpresionContext {
		public TerminalNode NOT() { return getToken(MiLenguajeParser.NOT, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExpNegacionContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpDecimalContext extends ExpresionContext {
		public TerminalNode DECIMAL() { return getToken(MiLenguajeParser.DECIMAL, 0); }
		public ExpDecimalContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpBinariaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode SUM() { return getToken(MiLenguajeParser.SUM, 0); }
		public TerminalNode RES() { return getToken(MiLenguajeParser.RES, 0); }
		public TerminalNode MUL() { return getToken(MiLenguajeParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MiLenguajeParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MiLenguajeParser.MOD, 0); }
		public ExpBinariaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpOrContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode OR() { return getToken(MiLenguajeParser.OR, 0); }
		public ExpOrContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpAccesoArregloContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode CA() { return getToken(MiLenguajeParser.CA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode CC() { return getToken(MiLenguajeParser.CC, 0); }
		public ExpAccesoArregloContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpFuncionContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public ExpFuncionContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpVariableContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public ExpVariableContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpCadenaContext extends ExpresionContext {
		public TerminalNode STRING_LITERAL() { return getToken(MiLenguajeParser.STRING_LITERAL, 0); }
		public ExpCadenaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpAndContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode AND() { return getToken(MiLenguajeParser.AND, 0); }
		public ExpAndContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpParentizadaContext extends ExpresionContext {
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public ExpParentizadaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpCaracterContext extends ExpresionContext {
		public TerminalNode CHARACTER() { return getToken(MiLenguajeParser.CHARACTER, 0); }
		public ExpCaracterContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpEnteroContext extends ExpresionContext {
		public TerminalNode INTEGER() { return getToken(MiLenguajeParser.INTEGER, 0); }
		public ExpEnteroContext(ExpresionContext ctx) { copyFrom(ctx); }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new ExpNegacionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(172);
				match(NOT);
				setState(173);
				expresion(9);
				}
				break;
			case 2:
				{
				_localctx = new ExpParentizadaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				match(PA);
				setState(175);
				expresion(0);
				setState(176);
				match(PC);
				}
				break;
			case 3:
				{
				_localctx = new ExpFuncionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				match(ID);
				setState(179);
				match(PA);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4329327050752L) != 0)) {
					{
					setState(180);
					argumentos();
					}
				}

				setState(183);
				match(PC);
				}
				break;
			case 4:
				{
				_localctx = new ExpAccesoArregloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				match(ID);
				setState(185);
				match(CA);
				setState(186);
				expresion(0);
				setState(187);
				match(CC);
				}
				break;
			case 5:
				{
				_localctx = new ExpVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new ExpEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(INTEGER);
				}
				break;
			case 7:
				{
				_localctx = new ExpDecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(DECIMAL);
				}
				break;
			case 8:
				{
				_localctx = new ExpCaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(CHARACTER);
				}
				break;
			case 9:
				{
				_localctx = new ExpCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(STRING_LITERAL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(221);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExpOrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(196);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(197);
						match(OR);
						setState(198);
						expresion(18);
						}
						break;
					case 2:
						{
						_localctx = new ExpAndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(199);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(200);
						match(AND);
						setState(201);
						expresion(17);
						}
						break;
					case 3:
						{
						_localctx = new ExpComparacionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(202);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(203);
						comparadorBinario();
						setState(204);
						expresion(16);
						}
						break;
					case 4:
						{
						_localctx = new ExpBinariaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(206);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(207);
						match(SUM);
						setState(208);
						expresion(15);
						}
						break;
					case 5:
						{
						_localctx = new ExpBinariaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(209);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(210);
						match(RES);
						setState(211);
						expresion(14);
						}
						break;
					case 6:
						{
						_localctx = new ExpBinariaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(212);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(213);
						match(MUL);
						setState(214);
						expresion(13);
						}
						break;
					case 7:
						{
						_localctx = new ExpBinariaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(215);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(216);
						match(DIV);
						setState(217);
						expresion(12);
						}
						break;
					case 8:
						{
						_localctx = new ExpBinariaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(218);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(219);
						match(MOD);
						setState(220);
						expresion(11);
						}
						break;
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MiLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MiLenguajeParser.COMA, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			expresion(0);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(227);
				match(COMA);
				setState(228);
				expresion(0);
				}
				}
				setState(233);
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
	public static class ComparadorBinarioContext extends ParserRuleContext {
		public TerminalNode MAYOR() { return getToken(MiLenguajeParser.MAYOR, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(MiLenguajeParser.MAYOR_IGUAL, 0); }
		public TerminalNode MENOR() { return getToken(MiLenguajeParser.MENOR, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(MiLenguajeParser.MENOR_IGUAL, 0); }
		public TerminalNode EQL() { return getToken(MiLenguajeParser.EQL, 0); }
		public TerminalNode DISTINTO() { return getToken(MiLenguajeParser.DISTINTO, 0); }
		public ComparadorBinarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparadorBinario; }
	}

	public final ComparadorBinarioContext comparadorBinario() throws RecognitionException {
		ComparadorBinarioContext _localctx = new ComparadorBinarioContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_comparadorBinario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 528482304L) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u00ed\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0005\u0000(\b\u0000\n\u0000\f\u0000+\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00012\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002;\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005J\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0005\u0006N\b\u0006\n\u0006\f\u0006Q\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007Y\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\tg\b"+
		"\t\u0001\t\u0001\t\u0003\tk\b\t\u0001\t\u0001\t\u0003\to\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0005\nw\b\n\n\n\f\nz\t\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u0085\b\f\u0001\f\u0001\f\u0003\f\u0089\b\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u00a2\b\r\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00a6\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00b6\b\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00c3"+
		"\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u00de\b\u0010\n\u0010\f\u0010\u00e1\t\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00e6\b\u0011\n\u0011"+
		"\f\u0011\u00e9\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0000\u0001"+
		" \u0013\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$\u0000\u0002\u0001\u0000\u0005\n\u0001\u0000\u0017"+
		"\u001c\u0101\u0000)\u0001\u0000\u0000\u0000\u00021\u0001\u0000\u0000\u0000"+
		"\u0004:\u0001\u0000\u0000\u0000\u0006<\u0001\u0000\u0000\u0000\b?\u0001"+
		"\u0000\u0000\u0000\nB\u0001\u0000\u0000\u0000\fK\u0001\u0000\u0000\u0000"+
		"\u000eT\u0001\u0000\u0000\u0000\u0010]\u0001\u0000\u0000\u0000\u0012c"+
		"\u0001\u0000\u0000\u0000\u0014s\u0001\u0000\u0000\u0000\u0016{\u0001\u0000"+
		"\u0000\u0000\u0018~\u0001\u0000\u0000\u0000\u001a\u00a1\u0001\u0000\u0000"+
		"\u0000\u001c\u00a3\u0001\u0000\u0000\u0000\u001e\u00a9\u0001\u0000\u0000"+
		"\u0000 \u00c2\u0001\u0000\u0000\u0000\"\u00e2\u0001\u0000\u0000\u0000"+
		"$\u00ea\u0001\u0000\u0000\u0000&(\u0003\u0002\u0001\u0000\'&\u0001\u0000"+
		"\u0000\u0000(+\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000)*\u0001"+
		"\u0000\u0000\u0000*,\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000"+
		",-\u0005\u0000\u0000\u0001-\u0001\u0001\u0000\u0000\u0000.2\u0003\u000e"+
		"\u0007\u0000/2\u0003\u0018\f\u000002\u0003\u001a\r\u00001.\u0001\u0000"+
		"\u0000\u00001/\u0001\u0000\u0000\u000010\u0001\u0000\u0000\u00002\u0003"+
		"\u0001\u0000\u0000\u00003;\u0003\u0002\u0001\u00004;\u0003\u001c\u000e"+
		"\u00005;\u0003\u0006\u0003\u00006;\u0003\b\u0004\u00007;\u0003\n\u0005"+
		"\u00008;\u0003\u0010\b\u00009;\u0003\u0012\t\u0000:3\u0001\u0000\u0000"+
		"\u0000:4\u0001\u0000\u0000\u0000:5\u0001\u0000\u0000\u0000:6\u0001\u0000"+
		"\u0000\u0000:7\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:9\u0001"+
		"\u0000\u0000\u0000;\u0005\u0001\u0000\u0000\u0000<=\u0005\f\u0000\u0000"+
		"=>\u0005\u0014\u0000\u0000>\u0007\u0001\u0000\u0000\u0000?@\u0005\r\u0000"+
		"\u0000@A\u0005\u0014\u0000\u0000A\t\u0001\u0000\u0000\u0000BC\u0005\u0003"+
		"\u0000\u0000CD\u0005\u000e\u0000\u0000DE\u0003 \u0010\u0000EF\u0005\u000f"+
		"\u0000\u0000FI\u0003\f\u0006\u0000GH\u0005\u0004\u0000\u0000HJ\u0003\f"+
		"\u0006\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\u000b"+
		"\u0001\u0000\u0000\u0000KO\u0005\u0012\u0000\u0000LN\u0003\u0004\u0002"+
		"\u0000ML\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000"+
		"\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000QO\u0001"+
		"\u0000\u0000\u0000RS\u0005\u0013\u0000\u0000S\r\u0001\u0000\u0000\u0000"+
		"TU\u0003\u001e\u000f\u0000UV\u0005)\u0000\u0000VX\u0005\u000e\u0000\u0000"+
		"WY\u0003\u0014\n\u0000XW\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Z[\u0005\u000f\u0000\u0000[\\\u0003\f\u0006"+
		"\u0000\\\u000f\u0001\u0000\u0000\u0000]^\u0005\u0002\u0000\u0000^_\u0005"+
		"\u000e\u0000\u0000_`\u0003 \u0010\u0000`a\u0005\u000f\u0000\u0000ab\u0003"+
		"\f\u0006\u0000b\u0011\u0001\u0000\u0000\u0000cd\u0005\u0001\u0000\u0000"+
		"df\u0005\u000e\u0000\u0000eg\u0003\u0018\f\u0000fe\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hj\u0005\u0014\u0000"+
		"\u0000ik\u0003 \u0010\u0000ji\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000ln\u0005\u0014\u0000\u0000mo\u0003\u001a"+
		"\r\u0000nm\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000"+
		"\u0000\u0000pq\u0005\u000f\u0000\u0000qr\u0003\f\u0006\u0000r\u0013\u0001"+
		"\u0000\u0000\u0000sx\u0003\u0016\u000b\u0000tu\u0005\u0015\u0000\u0000"+
		"uw\u0003\u0016\u000b\u0000vt\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000"+
		"\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y\u0015\u0001"+
		"\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000{|\u0003\u001e\u000f\u0000"+
		"|}\u0005)\u0000\u0000}\u0017\u0001\u0000\u0000\u0000~\u007f\u0003\u001e"+
		"\u000f\u0000\u007f\u0084\u0005)\u0000\u0000\u0080\u0081\u0005\u0010\u0000"+
		"\u0000\u0081\u0082\u0003 \u0010\u0000\u0082\u0083\u0005\u0011\u0000\u0000"+
		"\u0083\u0085\u0001\u0000\u0000\u0000\u0084\u0080\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0005\u0016\u0000\u0000\u0087\u0089\u0003 \u0010\u0000\u0088"+
		"\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0014\u0000\u0000\u008b"+
		"\u0019\u0001\u0000\u0000\u0000\u008c\u008d\u0005)\u0000\u0000\u008d\u008e"+
		"\u0005\u0016\u0000\u0000\u008e\u008f\u0003 \u0010\u0000\u008f\u0090\u0005"+
		"\u0014\u0000\u0000\u0090\u00a2\u0001\u0000\u0000\u0000\u0091\u0092\u0005"+
		")\u0000\u0000\u0092\u0093\u0005\u001d\u0000\u0000\u0093\u0094\u0005\u001d"+
		"\u0000\u0000\u0094\u00a2\u0005\u0014\u0000\u0000\u0095\u0096\u0005)\u0000"+
		"\u0000\u0096\u0097\u0005\u001e\u0000\u0000\u0097\u0098\u0005\u001e\u0000"+
		"\u0000\u0098\u00a2\u0005\u0014\u0000\u0000\u0099\u009a\u0005)\u0000\u0000"+
		"\u009a\u009b\u0005\u0010\u0000\u0000\u009b\u009c\u0003 \u0010\u0000\u009c"+
		"\u009d\u0005\u0011\u0000\u0000\u009d\u009e\u0005\u0016\u0000\u0000\u009e"+
		"\u009f\u0003 \u0010\u0000\u009f\u00a0\u0005\u0014\u0000\u0000\u00a0\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a1\u008c\u0001\u0000\u0000\u0000\u00a1\u0091"+
		"\u0001\u0000\u0000\u0000\u00a1\u0095\u0001\u0000\u0000\u0000\u00a1\u0099"+
		"\u0001\u0000\u0000\u0000\u00a2\u001b\u0001\u0000\u0000\u0000\u00a3\u00a5"+
		"\u0005\u000b\u0000\u0000\u00a4\u00a6\u0003 \u0010\u0000\u00a5\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0005\u0014\u0000\u0000\u00a8\u001d\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0007\u0000\u0000\u0000\u00aa\u001f\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0006\u0010\uffff\uffff\u0000\u00ac\u00ad"+
		"\u0005$\u0000\u0000\u00ad\u00c3\u0003 \u0010\t\u00ae\u00af\u0005\u000e"+
		"\u0000\u0000\u00af\u00b0\u0003 \u0010\u0000\u00b0\u00b1\u0005\u000f\u0000"+
		"\u0000\u00b1\u00c3\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005)\u0000\u0000"+
		"\u00b3\u00b5\u0005\u000e\u0000\u0000\u00b4\u00b6\u0003\"\u0011\u0000\u00b5"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b7\u00c3\u0005\u000f\u0000\u0000\u00b8"+
		"\u00b9\u0005)\u0000\u0000\u00b9\u00ba\u0005\u0010\u0000\u0000\u00ba\u00bb"+
		"\u0003 \u0010\u0000\u00bb\u00bc\u0005\u0011\u0000\u0000\u00bc\u00c3\u0001"+
		"\u0000\u0000\u0000\u00bd\u00c3\u0005)\u0000\u0000\u00be\u00c3\u0005%\u0000"+
		"\u0000\u00bf\u00c3\u0005&\u0000\u0000\u00c0\u00c3\u0005\'\u0000\u0000"+
		"\u00c1\u00c3\u0005(\u0000\u0000\u00c2\u00ab\u0001\u0000\u0000\u0000\u00c2"+
		"\u00ae\u0001\u0000\u0000\u0000\u00c2\u00b2\u0001\u0000\u0000\u0000\u00c2"+
		"\u00b8\u0001\u0000\u0000\u0000\u00c2\u00bd\u0001\u0000\u0000\u0000\u00c2"+
		"\u00be\u0001\u0000\u0000\u0000\u00c2\u00bf\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3"+
		"\u00df\u0001\u0000\u0000\u0000\u00c4\u00c5\n\u0011\u0000\u0000\u00c5\u00c6"+
		"\u0005\"\u0000\u0000\u00c6\u00de\u0003 \u0010\u0012\u00c7\u00c8\n\u0010"+
		"\u0000\u0000\u00c8\u00c9\u0005#\u0000\u0000\u00c9\u00de\u0003 \u0010\u0011"+
		"\u00ca\u00cb\n\u000f\u0000\u0000\u00cb\u00cc\u0003$\u0012\u0000\u00cc"+
		"\u00cd\u0003 \u0010\u0010\u00cd\u00de\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\n\u000e\u0000\u0000\u00cf\u00d0\u0005\u001d\u0000\u0000\u00d0\u00de\u0003"+
		" \u0010\u000f\u00d1\u00d2\n\r\u0000\u0000\u00d2\u00d3\u0005\u001e\u0000"+
		"\u0000\u00d3\u00de\u0003 \u0010\u000e\u00d4\u00d5\n\f\u0000\u0000\u00d5"+
		"\u00d6\u0005\u001f\u0000\u0000\u00d6\u00de\u0003 \u0010\r\u00d7\u00d8"+
		"\n\u000b\u0000\u0000\u00d8\u00d9\u0005 \u0000\u0000\u00d9\u00de\u0003"+
		" \u0010\f\u00da\u00db\n\n\u0000\u0000\u00db\u00dc\u0005!\u0000\u0000\u00dc"+
		"\u00de\u0003 \u0010\u000b\u00dd\u00c4\u0001\u0000\u0000\u0000\u00dd\u00c7"+
		"\u0001\u0000\u0000\u0000\u00dd\u00ca\u0001\u0000\u0000\u0000\u00dd\u00ce"+
		"\u0001\u0000\u0000\u0000\u00dd\u00d1\u0001\u0000\u0000\u0000\u00dd\u00d4"+
		"\u0001\u0000\u0000\u0000\u00dd\u00d7\u0001\u0000\u0000\u0000\u00dd\u00da"+
		"\u0001\u0000\u0000\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0!\u0001"+
		"\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e7\u0003"+
		" \u0010\u0000\u00e3\u00e4\u0005\u0015\u0000\u0000\u00e4\u00e6\u0003 \u0010"+
		"\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00e9\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000"+
		"\u0000\u00e8#\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000"+
		"\u00ea\u00eb\u0007\u0001\u0000\u0000\u00eb%\u0001\u0000\u0000\u0000\u0013"+
		")1:IOXfjnx\u0084\u0088\u00a1\u00a5\u00b5\u00c2\u00dd\u00df\u00e7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}