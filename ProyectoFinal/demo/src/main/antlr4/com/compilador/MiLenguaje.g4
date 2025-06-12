grammar MiLenguaje;

// Reglas del Parser (Gramática Sintáctica)

programa
    : (sentencia)* EOF
    ;

sentencia
    : declaracionFuncion
    | declaracionVariable
    | asignacion
    ;

// Reglas para sentencias que pueden aparecer dentro de un bloque (funciones, bucles, etc.)
sentenciaInterior
    : sentencia
    | retorno
    | sentenciaBreak
    | sentenciaContinue
    | sentenciaIf
    | sentenciaWhile
    | sentenciaFor
    ;

sentenciaBreak
    : BREAK PYC
    ;

sentenciaContinue
    : CONTINUE PYC
    ;

sentenciaIf
    : IF PA expresion PC bloque (ELSE bloque)?
    ;

bloque
    : LA (sentenciaInterior)* LC
    ;

declaracionFuncion
    : tipo ID PA parametros? PC bloque
    ;

sentenciaWhile
    : WHILE PA expresion PC bloque
    ;

sentenciaFor
    : FOR PA declaracionVariable? PYC expresion? PYC asignacion? PC bloque
    ;

parametros
    : parametro (COMA parametro)*
    ;

parametro
    : tipo ID
    ;

// FIX CLAVE: Se permite una asignación opcional al momento de la declaración de la variable.
declaracionVariable
    : tipo ID (IGUAL expresion)? PYC
    ;

asignacion
    : ID IGUAL expresion PYC // Asignación simple
    | ID SUM SUM PYC      // Incremento (ej: x++)
    | ID RES RES PYC      // Decremento (ej: x--)
    ;

retorno
    : RETURN expresion? PYC
    ;

tipo
    : INT
    | CHAR
    | DOUBLE
    | VOID
    | STRING
    ;

// Reglas para expresiones con etiquetas para facilitar el procesamiento en el visitor/listener
expresion
    : ID PA argumentos? PC                     #expFuncion      // Llamada a función
    | expresion (operadorBinario | comparadorBinario) expresion    #expBinaria      // Operaciones binarias (matemáticas, lógicas, comparación)
    | NOT expresion                            #expNegacion     // Negación lógica
    | PA expresion PC                          #expParentizada  // Expresión entre paréntesis
    | ID                                       #expVariable     // Uso de una variable
    | INTEGER                                  #expEntero       // Número entero
    | DECIMAL                                  #expDecimal      // Número decimal
    | CHARACTER                                #expCaracter     // Carácter
    | STRING_LITERAL                           #expCadena       // Cadena de texto
    ;

operadorBinario
    : SUM | RES | MUL | DIV | MOD
    ;

comparadorBinario
    : MAYOR | MAYOR_IGUAL | MENOR | MENOR_IGUAL | EQL | DISTINTO
    | AND | OR
    ;

argumentos
    : expresion (COMA expresion)*
    ;


// Reglas del Lexer (Tokens)
// ¡IMPORTANTE! El orden de las reglas del lexer importa.
// Las palabras clave deben ir ANTES que ID para que ANTLR las reconozca correctamente.

// Palabras clave
FOR       : 'for' ;
WHILE     : 'while' ;
IF        : 'if' ;
ELSE      : 'else' ;
INT       : 'int' ;
CHAR      : 'char' ;
DOUBLE    : 'double' ;
VOID      : 'void' ;
STRING    : 'String' ; // Asegúrate de que tu lenguaje distingue entre String y char para literales
RETURN    : 'return' ;
BREAK     : 'break' ;
CONTINUE  : 'continue' ;

// Operadores y delimitadores
PA        : '(' ;
PC        : ')' ;
CA        : '[' ;
CC        : ']' ;
LA        : '{' ;
LC        : '}' ;
PYC       : ';' ;
COMA      : ',' ;
IGUAL     : '=' ;
MAYOR     : '>' ;
MAYOR_IGUAL: '>=' ;
MENOR     : '<' ;
MENOR_IGUAL: '<=' ;
EQL       : '==' ;
DISTINTO  : '!=' ;
SUM       : '+' ;
RES       : '-' ;
MUL       : '*' ;
DIV       : '/' ;
MOD       : '%' ;
OR        : '||' ;
AND       : '&&' ;
NOT       : '!'   ;

// Literales
INTEGER   : DIGITO+ ;
DECIMAL   : INTEGER '.' DIGITO+ ; // Asegúrate de que DECIMAL tenga al menos un dígito después del punto
CHARACTER : '\'' (~['\r\n] | '\\' .) '\'' ; // Un solo carácter, puede ser escape
STRING_LITERAL : '"' (~["\\\r\n] | '\\' .)* '"' ; // Cualquier carácter excepto comilla o salto de línea, o secuencia de escape

// Identificador (Debe ir DESPUÉS de todas las palabras clave)
ID : (LETRA | '_') (LETRA | DIGITO | '_')*;

// Tokens ocultos (whitespace, comentarios)
COMENTARIO_LINEA : '//' ~[\r\n]* -> skip ;
COMENTARIO_BLOQUE : '/*' .*? '*/' -> skip ; // Non-greedy match para evitar problemas con /* /* */ */

WS : [ \r\n\t] -> skip ; // Espacios, saltos de línea, tabulaciones

// Regla para atrapar cualquier carácter no reconocido
OTRO : . ; // ¡CUIDADO! Esta regla puede ocultar errores de tipografía.
           // Es útil para depuración inicial, pero en un compilador final,
           // se preferiría que ANTLR genere un error para caracteres no reconocidos.

// Fragmentos (no se convierten en tokens directamente, son para componer otras reglas)
fragment LETRA : [A-Za-z] ;
fragment DIGITO : [0-9] ;