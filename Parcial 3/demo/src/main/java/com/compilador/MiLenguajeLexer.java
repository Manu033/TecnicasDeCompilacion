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
		FOR=1, WHILE=2, IF=3, ELSE=4, INT=5, CHAR=6, DOUBLE=7, VOID=8, STRING=9, 
		RETURN=10, BREAK=11, CONTINUE=12, PA=13, PC=14, CA=15, CC=16, LA=17, LC=18, 
		PYC=19, COMA=20, IGUAL=21, MAYOR=22, MAYOR_IGUAL=23, MENOR=24, MENOR_IGUAL=25, 
		EQL=26, DISTINTO=27, SUM=28, RES=29, MUL=30, DIV=31, MOD=32, OR=33, AND=34, 
		NOT=35, INTEGER=36, DECIMAL=37, CHARACTER=38, STRING_LITERAL=39, ID=40, 
		COMENTARIO_LINEA=41, COMENTARIO_BLOQUE=42, WS=43, OTRO=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FOR", "WHILE", "IF", "ELSE", "INT", "CHAR", "DOUBLE", "VOID", "STRING", 
			"RETURN", "BREAK", "CONTINUE", "PA", "PC", "CA", "CC", "LA", "LC", "PYC", 
			"COMA", "IGUAL", "MAYOR", "MAYOR_IGUAL", "MENOR", "MENOR_IGUAL", "EQL", 
			"DISTINTO", "SUM", "RES", "MUL", "DIV", "MOD", "OR", "AND", "NOT", "INTEGER", 
			"DECIMAL", "CHARACTER", "STRING_LITERAL", "ID", "COMENTARIO_LINEA", "COMENTARIO_BLOQUE", 
			"WS", "OTRO", "LETRA", "DIGITO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'for'", "'while'", "'if'", "'else'", "'int'", "'char'", "'double'", 
			"'void'", "'String'", "'return'", "'break'", "'continue'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "';'", "','", "'='", "'>'", "'>='", "'<'", 
			"'<='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'||'", "'&&'", 
			"'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FOR", "WHILE", "IF", "ELSE", "INT", "CHAR", "DOUBLE", "VOID", 
			"STRING", "RETURN", "BREAK", "CONTINUE", "PA", "PC", "CA", "CC", "LA", 
			"LC", "PYC", "COMA", "IGUAL", "MAYOR", "MAYOR_IGUAL", "MENOR", "MENOR_IGUAL", 
			"EQL", "DISTINTO", "SUM", "RES", "MUL", "DIV", "MOD", "OR", "AND", "NOT", 
			"INTEGER", "DECIMAL", "CHARACTER", "STRING_LITERAL", "ID", "COMENTARIO_LINEA", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u012c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3%\6%\u00d9\n%\r%\16"+
		"%\u00da\3&\6&\u00de\n&\r&\16&\u00df\3&\3&\6&\u00e4\n&\r&\16&\u00e5\3\'"+
		"\3\'\3\'\3\'\5\'\u00ec\n\'\3\'\3\'\3(\3(\3(\3(\7(\u00f4\n(\f(\16(\u00f7"+
		"\13(\3(\3(\3)\3)\5)\u00fd\n)\3)\3)\3)\7)\u0102\n)\f)\16)\u0105\13)\3*"+
		"\3*\3*\3*\7*\u010b\n*\f*\16*\u010e\13*\3*\3*\3+\3+\3+\3+\7+\u0116\n+\f"+
		"+\16+\u0119\13+\3+\3+\3+\3+\3+\3,\6,\u0121\n,\r,\16,\u0122\3,\3,\3-\3"+
		"-\3.\3.\3/\3/\3\u0117\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[\2]\2\3\2\b"+
		"\5\2\f\f\17\17))\6\2\f\f\17\17$$^^\4\2\f\f\17\17\5\2\13\f\17\17\"\"\4"+
		"\2C\\c|\3\2\62;\2\u0136\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3_\3\2\2\2\5c\3"+
		"\2\2\2\7i\3\2\2\2\tl\3\2\2\2\13q\3\2\2\2\ru\3\2\2\2\17z\3\2\2\2\21\u0081"+
		"\3\2\2\2\23\u0086\3\2\2\2\25\u008d\3\2\2\2\27\u0094\3\2\2\2\31\u009a\3"+
		"\2\2\2\33\u00a3\3\2\2\2\35\u00a5\3\2\2\2\37\u00a7\3\2\2\2!\u00a9\3\2\2"+
		"\2#\u00ab\3\2\2\2%\u00ad\3\2\2\2\'\u00af\3\2\2\2)\u00b1\3\2\2\2+\u00b3"+
		"\3\2\2\2-\u00b5\3\2\2\2/\u00b7\3\2\2\2\61\u00ba\3\2\2\2\63\u00bc\3\2\2"+
		"\2\65\u00bf\3\2\2\2\67\u00c2\3\2\2\29\u00c5\3\2\2\2;\u00c7\3\2\2\2=\u00c9"+
		"\3\2\2\2?\u00cb\3\2\2\2A\u00cd\3\2\2\2C\u00cf\3\2\2\2E\u00d2\3\2\2\2G"+
		"\u00d5\3\2\2\2I\u00d8\3\2\2\2K\u00dd\3\2\2\2M\u00e7\3\2\2\2O\u00ef\3\2"+
		"\2\2Q\u00fc\3\2\2\2S\u0106\3\2\2\2U\u0111\3\2\2\2W\u0120\3\2\2\2Y\u0126"+
		"\3\2\2\2[\u0128\3\2\2\2]\u012a\3\2\2\2_`\7h\2\2`a\7q\2\2ab\7t\2\2b\4\3"+
		"\2\2\2cd\7y\2\2de\7j\2\2ef\7k\2\2fg\7n\2\2gh\7g\2\2h\6\3\2\2\2ij\7k\2"+
		"\2jk\7h\2\2k\b\3\2\2\2lm\7g\2\2mn\7n\2\2no\7u\2\2op\7g\2\2p\n\3\2\2\2"+
		"qr\7k\2\2rs\7p\2\2st\7v\2\2t\f\3\2\2\2uv\7e\2\2vw\7j\2\2wx\7c\2\2xy\7"+
		"t\2\2y\16\3\2\2\2z{\7f\2\2{|\7q\2\2|}\7w\2\2}~\7d\2\2~\177\7n\2\2\177"+
		"\u0080\7g\2\2\u0080\20\3\2\2\2\u0081\u0082\7x\2\2\u0082\u0083\7q\2\2\u0083"+
		"\u0084\7k\2\2\u0084\u0085\7f\2\2\u0085\22\3\2\2\2\u0086\u0087\7U\2\2\u0087"+
		"\u0088\7v\2\2\u0088\u0089\7t\2\2\u0089\u008a\7k\2\2\u008a\u008b\7p\2\2"+
		"\u008b\u008c\7i\2\2\u008c\24\3\2\2\2\u008d\u008e\7t\2\2\u008e\u008f\7"+
		"g\2\2\u008f\u0090\7v\2\2\u0090\u0091\7w\2\2\u0091\u0092\7t\2\2\u0092\u0093"+
		"\7p\2\2\u0093\26\3\2\2\2\u0094\u0095\7d\2\2\u0095\u0096\7t\2\2\u0096\u0097"+
		"\7g\2\2\u0097\u0098\7c\2\2\u0098\u0099\7m\2\2\u0099\30\3\2\2\2\u009a\u009b"+
		"\7e\2\2\u009b\u009c\7q\2\2\u009c\u009d\7p\2\2\u009d\u009e\7v\2\2\u009e"+
		"\u009f\7k\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7w\2\2\u00a1\u00a2\7g\2\2"+
		"\u00a2\32\3\2\2\2\u00a3\u00a4\7*\2\2\u00a4\34\3\2\2\2\u00a5\u00a6\7+\2"+
		"\2\u00a6\36\3\2\2\2\u00a7\u00a8\7]\2\2\u00a8 \3\2\2\2\u00a9\u00aa\7_\2"+
		"\2\u00aa\"\3\2\2\2\u00ab\u00ac\7}\2\2\u00ac$\3\2\2\2\u00ad\u00ae\7\177"+
		"\2\2\u00ae&\3\2\2\2\u00af\u00b0\7=\2\2\u00b0(\3\2\2\2\u00b1\u00b2\7.\2"+
		"\2\u00b2*\3\2\2\2\u00b3\u00b4\7?\2\2\u00b4,\3\2\2\2\u00b5\u00b6\7@\2\2"+
		"\u00b6.\3\2\2\2\u00b7\u00b8\7@\2\2\u00b8\u00b9\7?\2\2\u00b9\60\3\2\2\2"+
		"\u00ba\u00bb\7>\2\2\u00bb\62\3\2\2\2\u00bc\u00bd\7>\2\2\u00bd\u00be\7"+
		"?\2\2\u00be\64\3\2\2\2\u00bf\u00c0\7?\2\2\u00c0\u00c1\7?\2\2\u00c1\66"+
		"\3\2\2\2\u00c2\u00c3\7#\2\2\u00c3\u00c4\7?\2\2\u00c48\3\2\2\2\u00c5\u00c6"+
		"\7-\2\2\u00c6:\3\2\2\2\u00c7\u00c8\7/\2\2\u00c8<\3\2\2\2\u00c9\u00ca\7"+
		",\2\2\u00ca>\3\2\2\2\u00cb\u00cc\7\61\2\2\u00cc@\3\2\2\2\u00cd\u00ce\7"+
		"\'\2\2\u00ceB\3\2\2\2\u00cf\u00d0\7~\2\2\u00d0\u00d1\7~\2\2\u00d1D\3\2"+
		"\2\2\u00d2\u00d3\7(\2\2\u00d3\u00d4\7(\2\2\u00d4F\3\2\2\2\u00d5\u00d6"+
		"\7#\2\2\u00d6H\3\2\2\2\u00d7\u00d9\5]/\2\u00d8\u00d7\3\2\2\2\u00d9\u00da"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00dbJ\3\2\2\2\u00dc"+
		"\u00de\5]/\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00dd\3\2\2"+
		"\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\7\60\2\2\u00e2"+
		"\u00e4\5]/\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2"+
		"\2\u00e5\u00e6\3\2\2\2\u00e6L\3\2\2\2\u00e7\u00eb\7)\2\2\u00e8\u00ec\n"+
		"\2\2\2\u00e9\u00ea\7^\2\2\u00ea\u00ec\13\2\2\2\u00eb\u00e8\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\7)\2\2\u00eeN\3\2\2\2\u00ef"+
		"\u00f5\7$\2\2\u00f0\u00f4\n\3\2\2\u00f1\u00f2\7^\2\2\u00f2\u00f4\13\2"+
		"\2\2\u00f3\u00f0\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2"+
		"\2\2\u00f8\u00f9\7$\2\2\u00f9P\3\2\2\2\u00fa\u00fd\5[.\2\u00fb\u00fd\7"+
		"a\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\u0103\3\2\2\2\u00fe"+
		"\u0102\5[.\2\u00ff\u0102\5]/\2\u0100\u0102\7a\2\2\u0101\u00fe\3\2\2\2"+
		"\u0101\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101"+
		"\3\2\2\2\u0103\u0104\3\2\2\2\u0104R\3\2\2\2\u0105\u0103\3\2\2\2\u0106"+
		"\u0107\7\61\2\2\u0107\u0108\7\61\2\2\u0108\u010c\3\2\2\2\u0109\u010b\n"+
		"\4\2\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0110\b*"+
		"\2\2\u0110T\3\2\2\2\u0111\u0112\7\61\2\2\u0112\u0113\7,\2\2\u0113\u0117"+
		"\3\2\2\2\u0114\u0116\13\2\2\2\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2"+
		"\u0117\u0118\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011a\3\2\2\2\u0119\u0117"+
		"\3\2\2\2\u011a\u011b\7,\2\2\u011b\u011c\7\61\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u011e\b+\2\2\u011eV\3\2\2\2\u011f\u0121\t\5\2\2\u0120\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0125\b,\2\2\u0125X\3\2\2\2\u0126\u0127\13\2\2\2\u0127Z\3\2"+
		"\2\2\u0128\u0129\t\6\2\2\u0129\\\3\2\2\2\u012a\u012b\t\7\2\2\u012b^\3"+
		"\2\2\2\17\2\u00da\u00df\u00e5\u00eb\u00f3\u00f5\u00fc\u0101\u0103\u010c"+
		"\u0117\u0122\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}