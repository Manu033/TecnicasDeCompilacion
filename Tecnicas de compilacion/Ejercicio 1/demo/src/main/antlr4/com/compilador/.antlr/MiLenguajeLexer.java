// Generated from c:/Users/carri/OneDrive/Documentos/UBP FACULTAD DOCUMENTOS/Semestre 9/TC/Tecnicasdecompilacion/Tecnicas de compilacion/Ejercicio 1/demo/src/main/antlr4/com/compilador/MiLenguaje.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiLenguajeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, INTEGER=2, STRING=3, BOOLEAN=4, KEYWORD=5, OPERATOR=6, SEPARATOR=7, 
		WS=8, COMMENT=9, BLOCK_COMMENT=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "INTEGER", "STRING", "BOOLEAN", "KEYWORD", "OPERATOR", "SEPARATOR", 
			"WS", "COMMENT", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "INTEGER", "STRING", "BOOLEAN", "KEYWORD", "OPERATOR", "SEPARATOR", 
			"WS", "COMMENT", "BLOCK_COMMENT"
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
		"\u0004\u0000\n\u008d\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u0018\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0001\u0004\u0001"+
		"\u001e\b\u0001\u000b\u0001\f\u0001\u001f\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002&\b\u0002\n\u0002\f\u0002)\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00036\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004Y\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005j\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0004\u0007o\b\u0007\u000b\u0007\f\u0007p\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\by\b\b\n\b\f\b|\t\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0084\b\t\n\t"+
		"\f\t\u0087\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\u0085\u0000"+
		"\n\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0001\u0000\t\u0002\u0000AZaz\u0004\u0000"+
		"09AZ__az\u0001\u000009\u0004\u0000\n\n\r\r\"\"\\\\\u0005\u0000%%*+--/"+
		"/==\u0002\u0000<<>>\u0006\u0000(),,..;;{{}}\u0003\u0000\t\n\r\r  \u0002"+
		"\u0000\n\n\r\r\u00a2\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0001\u0015\u0001\u0000\u0000\u0000\u0003\u001d\u0001\u0000\u0000"+
		"\u0000\u0005!\u0001\u0000\u0000\u0000\u00075\u0001\u0000\u0000\u0000\t"+
		"X\u0001\u0000\u0000\u0000\u000bi\u0001\u0000\u0000\u0000\rk\u0001\u0000"+
		"\u0000\u0000\u000fn\u0001\u0000\u0000\u0000\u0011t\u0001\u0000\u0000\u0000"+
		"\u0013\u007f\u0001\u0000\u0000\u0000\u0015\u0019\u0007\u0000\u0000\u0000"+
		"\u0016\u0018\u0007\u0001\u0000\u0000\u0017\u0016\u0001\u0000\u0000\u0000"+
		"\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000"+
		"\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u0002\u0001\u0000\u0000\u0000"+
		"\u001b\u0019\u0001\u0000\u0000\u0000\u001c\u001e\u0007\u0002\u0000\u0000"+
		"\u001d\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000"+
		"\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u0004"+
		"\u0001\u0000\u0000\u0000!\'\u0005\"\u0000\u0000\"#\u0005\\\u0000\u0000"+
		"#&\t\u0000\u0000\u0000$&\b\u0003\u0000\u0000%\"\u0001\u0000\u0000\u0000"+
		"%$\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000"+
		"\u0000\'(\u0001\u0000\u0000\u0000(*\u0001\u0000\u0000\u0000)\'\u0001\u0000"+
		"\u0000\u0000*+\u0005\"\u0000\u0000+\u0006\u0001\u0000\u0000\u0000,-\u0005"+
		"t\u0000\u0000-.\u0005r\u0000\u0000./\u0005u\u0000\u0000/6\u0005e\u0000"+
		"\u000001\u0005f\u0000\u000012\u0005a\u0000\u000023\u0005l\u0000\u0000"+
		"34\u0005s\u0000\u000046\u0005e\u0000\u00005,\u0001\u0000\u0000\u00005"+
		"0\u0001\u0000\u0000\u00006\b\u0001\u0000\u0000\u000078\u0005v\u0000\u0000"+
		"89\u0005a\u0000\u00009Y\u0005r\u0000\u0000:;\u0005i\u0000\u0000;Y\u0005"+
		"f\u0000\u0000<=\u0005e\u0000\u0000=>\u0005l\u0000\u0000>?\u0005s\u0000"+
		"\u0000?Y\u0005e\u0000\u0000@A\u0005p\u0000\u0000AB\u0005r\u0000\u0000"+
		"BC\u0005i\u0000\u0000CD\u0005n\u0000\u0000DY\u0005t\u0000\u0000EF\u0005"+
		"w\u0000\u0000FG\u0005h\u0000\u0000GH\u0005i\u0000\u0000HI\u0005l\u0000"+
		"\u0000IY\u0005e\u0000\u0000JK\u0005f\u0000\u0000KL\u0005u\u0000\u0000"+
		"LM\u0005n\u0000\u0000MN\u0005c\u0000\u0000NO\u0005t\u0000\u0000OP\u0005"+
		"i\u0000\u0000PQ\u0005o\u0000\u0000QY\u0005n\u0000\u0000RS\u0005r\u0000"+
		"\u0000ST\u0005e\u0000\u0000TU\u0005t\u0000\u0000UV\u0005u\u0000\u0000"+
		"VW\u0005r\u0000\u0000WY\u0005n\u0000\u0000X7\u0001\u0000\u0000\u0000X"+
		":\u0001\u0000\u0000\u0000X<\u0001\u0000\u0000\u0000X@\u0001\u0000\u0000"+
		"\u0000XE\u0001\u0000\u0000\u0000XJ\u0001\u0000\u0000\u0000XR\u0001\u0000"+
		"\u0000\u0000Y\n\u0001\u0000\u0000\u0000Zj\u0007\u0004\u0000\u0000[\\\u0005"+
		"=\u0000\u0000\\j\u0005=\u0000\u0000]^\u0005!\u0000\u0000^j\u0005=\u0000"+
		"\u0000_j\u0007\u0005\u0000\u0000`a\u0005<\u0000\u0000aj\u0005=\u0000\u0000"+
		"bc\u0005>\u0000\u0000cj\u0005=\u0000\u0000de\u0005&\u0000\u0000ej\u0005"+
		"&\u0000\u0000fg\u0005|\u0000\u0000gj\u0005|\u0000\u0000hj\u0005!\u0000"+
		"\u0000iZ\u0001\u0000\u0000\u0000i[\u0001\u0000\u0000\u0000i]\u0001\u0000"+
		"\u0000\u0000i_\u0001\u0000\u0000\u0000i`\u0001\u0000\u0000\u0000ib\u0001"+
		"\u0000\u0000\u0000id\u0001\u0000\u0000\u0000if\u0001\u0000\u0000\u0000"+
		"ih\u0001\u0000\u0000\u0000j\f\u0001\u0000\u0000\u0000kl\u0007\u0006\u0000"+
		"\u0000l\u000e\u0001\u0000\u0000\u0000mo\u0007\u0007\u0000\u0000nm\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0006\u0007\u0000"+
		"\u0000s\u0010\u0001\u0000\u0000\u0000tu\u0005/\u0000\u0000uv\u0005/\u0000"+
		"\u0000vz\u0001\u0000\u0000\u0000wy\b\b\u0000\u0000xw\u0001\u0000\u0000"+
		"\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{}\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0006"+
		"\b\u0000\u0000~\u0012\u0001\u0000\u0000\u0000\u007f\u0080\u0005/\u0000"+
		"\u0000\u0080\u0081\u0005*\u0000\u0000\u0081\u0085\u0001\u0000\u0000\u0000"+
		"\u0082\u0084\t\u0000\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084"+
		"\u0087\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0088\u0089\u0005*\u0000\u0000\u0089\u008a"+
		"\u0005/\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0006"+
		"\t\u0000\u0000\u008c\u0014\u0001\u0000\u0000\u0000\u000b\u0000\u0019\u001f"+
		"%\'5Xipz\u0085\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}