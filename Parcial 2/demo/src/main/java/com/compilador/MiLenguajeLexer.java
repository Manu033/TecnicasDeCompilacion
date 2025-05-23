// Generated from com\compilador\MiLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiLenguajeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PA=1, PC=2, CA=3, CC=4, LA=5, LC=6, PYC=7, COMA=8, IGUAL=9, MAYOR=10, 
		MAYOR_IGUAL=11, MENOR=12, MENOR_IGUAL=13, EQL=14, DISTINTO=15, SUM=16, 
		RES=17, MUL=18, DIV=19, MOD=20, OR=21, AND=22, NOT=23, FOR=24, WHILE=25, 
		IF=26, ELSE=27, INT=28, CHAR=29, DOUBLE=30, VOID=31, STRING=32, RETURN=33, 
		ID=34, INTEGER=35, DECIMAL=36, CHARACTER=37, STRING_LITERAL=38, BREAK=39, 
		CONTINUE=40, COMENTARIO_LINEA=41, COMENTARIO_BLOQUE=42, WS=43, OTRO=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PA", "PC", "CA", "CC", "LA", "LC", "PYC", "COMA", "IGUAL", "MAYOR", 
			"MAYOR_IGUAL", "MENOR", "MENOR_IGUAL", "EQL", "DISTINTO", "SUM", "RES", 
			"MUL", "DIV", "MOD", "OR", "AND", "NOT", "FOR", "WHILE", "IF", "ELSE", 
			"INT", "CHAR", "DOUBLE", "VOID", "STRING", "RETURN", "ID", "INTEGER", 
			"DECIMAL", "CHARACTER", "STRING_LITERAL", "BREAK", "CONTINUE", "COMENTARIO_LINEA", 
			"COMENTARIO_BLOQUE", "WS", "OTRO", "LETRA", "DIGITO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "','", "'='", 
			"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'||'", "'&&'", "'!'", "'for'", "'while'", "'if'", "'else'", "'int'", 
			"'char'", "'double'", "'void'", "'String'", "'return'", null, null, null, 
			null, null, "'break'", "'continue'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PA", "PC", "CA", "CC", "LA", "LC", "PYC", "COMA", "IGUAL", "MAYOR", 
			"MAYOR_IGUAL", "MENOR", "MENOR_IGUAL", "EQL", "DISTINTO", "SUM", "RES", 
			"MUL", "DIV", "MOD", "OR", "AND", "NOT", "FOR", "WHILE", "IF", "ELSE", 
			"INT", "CHAR", "DOUBLE", "VOID", "STRING", "RETURN", "ID", "INTEGER", 
			"DECIMAL", "CHARACTER", "STRING_LITERAL", "BREAK", "CONTINUE", "COMENTARIO_LINEA", 
			"COMENTARIO_BLOQUE", "WS", "OTRO"
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


	public MiLenguajeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiLenguaje.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0122\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3#\3#\5#\u00cb\n#\3#\3#\3#\7#\u00d0\n#\f#\16#\u00d3\13#\3$\6$\u00d6"+
		"\n$\r$\16$\u00d7\3%\3%\3%\3%\3&\3&\3&\3&\5&\u00e2\n&\3&\3&\3\'\3\'\3\'"+
		"\3\'\7\'\u00ea\n\'\f\'\16\'\u00ed\13\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\7*\u0104\n*\f*\16*\u0107\13*\3*\3*"+
		"\3+\3+\3+\3+\7+\u010f\n+\f+\16+\u0112\13+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3"+
		"-\3-\3.\3.\3/\3/\3\u0110\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[\2]\2\3"+
		"\2\b\5\2\f\f\17\17))\6\2\f\f\17\17$$^^\4\2\f\f\17\17\5\2\13\f\17\17\""+
		"\"\4\2C\\c|\3\2\62;\2\u0129\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3_\3\2\2\2"+
		"\5a\3\2\2\2\7c\3\2\2\2\te\3\2\2\2\13g\3\2\2\2\ri\3\2\2\2\17k\3\2\2\2\21"+
		"m\3\2\2\2\23o\3\2\2\2\25q\3\2\2\2\27s\3\2\2\2\31v\3\2\2\2\33x\3\2\2\2"+
		"\35{\3\2\2\2\37~\3\2\2\2!\u0081\3\2\2\2#\u0083\3\2\2\2%\u0085\3\2\2\2"+
		"\'\u0087\3\2\2\2)\u0089\3\2\2\2+\u008b\3\2\2\2-\u008e\3\2\2\2/\u0091\3"+
		"\2\2\2\61\u0093\3\2\2\2\63\u0097\3\2\2\2\65\u009d\3\2\2\2\67\u00a0\3\2"+
		"\2\29\u00a5\3\2\2\2;\u00a9\3\2\2\2=\u00ae\3\2\2\2?\u00b5\3\2\2\2A\u00ba"+
		"\3\2\2\2C\u00c1\3\2\2\2E\u00ca\3\2\2\2G\u00d5\3\2\2\2I\u00d9\3\2\2\2K"+
		"\u00dd\3\2\2\2M\u00e5\3\2\2\2O\u00f0\3\2\2\2Q\u00f6\3\2\2\2S\u00ff\3\2"+
		"\2\2U\u010a\3\2\2\2W\u0118\3\2\2\2Y\u011c\3\2\2\2[\u011e\3\2\2\2]\u0120"+
		"\3\2\2\2_`\7*\2\2`\4\3\2\2\2ab\7+\2\2b\6\3\2\2\2cd\7]\2\2d\b\3\2\2\2e"+
		"f\7_\2\2f\n\3\2\2\2gh\7}\2\2h\f\3\2\2\2ij\7\177\2\2j\16\3\2\2\2kl\7=\2"+
		"\2l\20\3\2\2\2mn\7.\2\2n\22\3\2\2\2op\7?\2\2p\24\3\2\2\2qr\7@\2\2r\26"+
		"\3\2\2\2st\7@\2\2tu\7?\2\2u\30\3\2\2\2vw\7>\2\2w\32\3\2\2\2xy\7>\2\2y"+
		"z\7?\2\2z\34\3\2\2\2{|\7?\2\2|}\7?\2\2}\36\3\2\2\2~\177\7#\2\2\177\u0080"+
		"\7?\2\2\u0080 \3\2\2\2\u0081\u0082\7-\2\2\u0082\"\3\2\2\2\u0083\u0084"+
		"\7/\2\2\u0084$\3\2\2\2\u0085\u0086\7,\2\2\u0086&\3\2\2\2\u0087\u0088\7"+
		"\61\2\2\u0088(\3\2\2\2\u0089\u008a\7\'\2\2\u008a*\3\2\2\2\u008b\u008c"+
		"\7~\2\2\u008c\u008d\7~\2\2\u008d,\3\2\2\2\u008e\u008f\7(\2\2\u008f\u0090"+
		"\7(\2\2\u0090.\3\2\2\2\u0091\u0092\7#\2\2\u0092\60\3\2\2\2\u0093\u0094"+
		"\7h\2\2\u0094\u0095\7q\2\2\u0095\u0096\7t\2\2\u0096\62\3\2\2\2\u0097\u0098"+
		"\7y\2\2\u0098\u0099\7j\2\2\u0099\u009a\7k\2\2\u009a\u009b\7n\2\2\u009b"+
		"\u009c\7g\2\2\u009c\64\3\2\2\2\u009d\u009e\7k\2\2\u009e\u009f\7h\2\2\u009f"+
		"\66\3\2\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7u\2\2\u00a3"+
		"\u00a4\7g\2\2\u00a48\3\2\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7p\2\2\u00a7"+
		"\u00a8\7v\2\2\u00a8:\3\2\2\2\u00a9\u00aa\7e\2\2\u00aa\u00ab\7j\2\2\u00ab"+
		"\u00ac\7c\2\2\u00ac\u00ad\7t\2\2\u00ad<\3\2\2\2\u00ae\u00af\7f\2\2\u00af"+
		"\u00b0\7q\2\2\u00b0\u00b1\7w\2\2\u00b1\u00b2\7d\2\2\u00b2\u00b3\7n\2\2"+
		"\u00b3\u00b4\7g\2\2\u00b4>\3\2\2\2\u00b5\u00b6\7x\2\2\u00b6\u00b7\7q\2"+
		"\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7f\2\2\u00b9@\3\2\2\2\u00ba\u00bb\7"+
		"U\2\2\u00bb\u00bc\7v\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7k\2\2\u00be\u00bf"+
		"\7p\2\2\u00bf\u00c0\7i\2\2\u00c0B\3\2\2\2\u00c1\u00c2\7t\2\2\u00c2\u00c3"+
		"\7g\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7w\2\2\u00c5\u00c6\7t\2\2\u00c6"+
		"\u00c7\7p\2\2\u00c7D\3\2\2\2\u00c8\u00cb\5[.\2\u00c9\u00cb\7a\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00d1\3\2\2\2\u00cc\u00d0\5["+
		".\2\u00cd\u00d0\5]/\2\u00ce\u00d0\7a\2\2\u00cf\u00cc\3\2\2\2\u00cf\u00cd"+
		"\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2F\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d6\5]/\2\u00d5"+
		"\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8H\3\2\2\2\u00d9\u00da\5G$\2\u00da\u00db\7\60\2\2\u00db\u00dc"+
		"\5G$\2\u00dcJ\3\2\2\2\u00dd\u00e1\7)\2\2\u00de\u00e2\n\2\2\2\u00df\u00e0"+
		"\7^\2\2\u00e0\u00e2\13\2\2\2\u00e1\u00de\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e4\7)\2\2\u00e4L\3\2\2\2\u00e5\u00eb\7$\2\2\u00e6"+
		"\u00ea\n\3\2\2\u00e7\u00e8\7^\2\2\u00e8\u00ea\13\2\2\2\u00e9\u00e6\3\2"+
		"\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7$"+
		"\2\2\u00efN\3\2\2\2\u00f0\u00f1\7d\2\2\u00f1\u00f2\7t\2\2\u00f2\u00f3"+
		"\7g\2\2\u00f3\u00f4\7c\2\2\u00f4\u00f5\7m\2\2\u00f5P\3\2\2\2\u00f6\u00f7"+
		"\7e\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa\7v\2\2\u00fa"+
		"\u00fb\7k\2\2\u00fb\u00fc\7p\2\2\u00fc\u00fd\7w\2\2\u00fd\u00fe\7g\2\2"+
		"\u00feR\3\2\2\2\u00ff\u0100\7\61\2\2\u0100\u0101\7\61\2\2\u0101\u0105"+
		"\3\2\2\2\u0102\u0104\n\4\2\2\u0103\u0102\3\2\2\2\u0104\u0107\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0108\u0109\b*\2\2\u0109T\3\2\2\2\u010a\u010b\7\61\2\2\u010b\u010c"+
		"\7,\2\2\u010c\u0110\3\2\2\2\u010d\u010f\13\2\2\2\u010e\u010d\3\2\2\2\u010f"+
		"\u0112\3\2\2\2\u0110\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0113\3\2"+
		"\2\2\u0112\u0110\3\2\2\2\u0113\u0114\7,\2\2\u0114\u0115\7\61\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u0117\b+\2\2\u0117V\3\2\2\2\u0118\u0119\t\5\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u011b\b,\2\2\u011bX\3\2\2\2\u011c\u011d\13\2\2\2"+
		"\u011dZ\3\2\2\2\u011e\u011f\t\6\2\2\u011f\\\3\2\2\2\u0120\u0121\t\7\2"+
		"\2\u0121^\3\2\2\2\f\2\u00ca\u00cf\u00d1\u00d7\u00e1\u00e9\u00eb\u0105"+
		"\u0110\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}