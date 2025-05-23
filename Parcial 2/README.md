# 🚀 Compilador TC25 - Proyecto de Técnicas de Compilación

## ⚙️ Configuración Inicial del Proyecto

### 🏗️ Creación del Proyecto Maven
Para desarrollar nuestro compilador, comenzamos creando la estructura básica del proyecto con Maven, que facilitará la gestión de dependencias y el ciclo de vida de construcción.

```bash
mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:generate \
    -DarchetypeArtifactId="maven-archetype-quickstart" \
    -DarchetypeGroupId="org.apache.maven.archetypes" \
    -DarchetypeVersion="1.4" \
    -DgroupId="com.compilador" \
    -DartifactId="demo"
```

### 🔧 Configuraciones durante la ejecución:

- 📦 `groupId`: `com.compilador`  
- 📂 `artifactId`: `demo`  
- 🔢 `version`: `1.0`  
- 📁 `package`: `com.compilador`  

Esto genera la siguiente estructura de directorios:

```
📁 demo/
├── 📜 pom.xml
├── 📂 src/
│   ├── 📂 main/
│   │   └── 📂 java/
│   │       └── 📂 com/
│   │           └── 📂 compilador/
│   │               └── 📄 App.java
│   └── 📂 test/
│       └── 📂 java/
│           └── 📂 com/
│               └── 📂 compilador/
│                   └── 📄 AppTest.java
```

---

## 🛠️ Configuración de ANTLR para el Análisis Léxico

### 1️⃣ Modificación del `pom.xml`

Añadimos las siguientes dependencias y plugins:

```xml
<properties>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
  <antlr.version>4.9.3</antlr.version>
</properties>

<dependencies>
  <dependency>
    <groupId>org.antlr</groupId>
    <artifactId>antlr4-runtime</artifactId>
    <version>${antlr.version}</version>
  </dependency>
</dependencies>

<build>
  <plugins>
    <plugin>
      <groupId>org.antlr</groupId>
      <artifactId>antlr4-maven-plugin</artifactId>
      <version>${antlr.version}</version>
      <executions>
        <execution>
          <goals>
            <goal>antlr4</goal>
          </goals>
        </execution>
      </executions>
      <configuration>
        <sourceDirectory>${basedir}/src/main/antlr4</sourceDirectory>
        <outputDirectory>${basedir}/src/main/java</outputDirectory>
        <visitor>true</visitor>
        <listener>true</listener>
      </configuration>
    </plugin>
    
    <plugin>
      <artifactId>maven-assembly-plugin</artifactId>
      <configuration>
        <archive>
          <manifest>
            <mainClass>com.compilador.App</mainClass>
          </manifest>
        </archive>
        <descriptorRefs>
          <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
      </configuration>
      <executions>
        <execution>
          <id>make-assembly</id>
          <phase>package</phase>
          <goals>
            <goal>single</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

---

### 2️⃣ Crear estructura para archivos ANTLR

```bash
mkdir -p src/main/antlr4/com/compilador
```

---

### 3️⃣ Crear archivo de gramática `MiniLenguaje.g4`

```antlr
grammar MiniLenguaje;

program : token* EOF ;
token   : ID | INTEGER | STRING | KEYWORD | OPERATOR | SEPARATOR ;

ID          : [a-zA-Z][a-zA-Z0-9_]* ;
INTEGER     : [0-9]+ ;
STRING      : '"' (~["\r\n] | '\"')* '"' ;
BOOLEAN     : 'true' | 'false' ;

KEYWORD     : 'var' | 'if' | 'else' | 'print' | 'while' | 'function' | 'return' ;

OPERATOR    : '+' | '-' | '*' | '/' | '%' | '=' | '==' | '!=' | '<' | '>' | '<=' | '>=' | '&&' | '||' | '!' ;

SEPARATOR   : ';' | '(' | ')' | '{' | '}' | ',' | '.' ;

WS          : [ \t\r\n]+ -> skip ;
COMMENT     : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;
```

---

## 💡 Características añadidas

- 🔡 Soporte para literales de tipo decimal
- 📝 Soporte para caracteres con comillas simples
- 🔄 Operadores de comparación extendidos
- 🧮 Operadores lógicos (`&&`, `||`)
- 📌 Nuevas palabras clave: `VOID`, `INT`, `CHAR`, `DOUBLE`, `RETURN`
- 💬 Manejo completo de comentarios

---
💡 Características añadidas
🔡 Soporte para literales de tipo decimal

📝 Soporte para caracteres con comillas simples

🔄 Operadores de comparación extendidos

🧮 Operadores lógicos (&&, ||)

📌 Nuevas palabras clave: VOID, INT, CHAR, DOUBLE, RETURN

💬 Manejo completo de comentarios
## 📝 Ejemplo Actualizado

### 📌 Código de entrada

```java
// Variables con diferentes tipos de datos
int suma(int a, int b) {
    return a + b;
}

void main() {
    int resultado;
    resultado = suma(5, 3);
}
```

### 📊 Salida del Análisis Léxico

```
Analizando archivo: ejemplo.txt

=== ANÁLISIS LÉXICO ===
TIPO                 LEXEMA                         LÍNEA      COLUMNA   
-------------------------------------------------------------------
INT                  int                            1          0
ID                   suma                           1          4
PA                   (                              1          8
INT                  int                            1          9
ID                   a                              1          13        
COMA                 ,                              1          14
INT                  int                            1          16
ID                   b                              1          20
PC                   )                              1          21
LA                   {                              1          23
RETURN               return                         2          4
ID                   a                              2          11
SUM                  +                              2          13        
ID                   b                              2          15
PYC                  ;                              2          16
LC                   }                              3          0
VOID                 void                           5          0
ID                   main                           5          5
PA                   (                              5          9
PC                   )                              5          10
LA                   {                              5          12
INT                  int                            6          4
ID                   resultado                      6          8
PYC                  ;                              6          17
ID                   resultado                      7          4         
IGUAL                =                              7          14
ID                   suma                           7          16
PA                   (                              7          20
INTEGER              5                              7          21
COMA                 ,                              7          22
INTEGER              3                              7          24
PC                   )                              7          25
PYC                  ;                              7          26
LC                   }                              8          0

? Análisis léxico completado sin errores.

=== ANÁLISIS SINTÁCTICO ===
? Análisis sintáctico completado sin errores.
Representación textual del árbol sintáctico:
(programa (sentencia (declaracionFuncion (tipo int) suma ( (parametros (parametro (tipo int) a) , (parametro (tipo int) b)) ) (bloque { (sentencia (retorno return (expresion (expresion a) (operadorBinario +) (expresion b)) ;)) }))) (sentencia (declaracionFuncion (tipo void) main ( ) (bloque { (sentencia (declaracionVariable (tipo int) resultado ;)) (sentencia (asignacion resultado = (expresion suma ( (argumentos (expresion 5) , (expresion 3)) )) ;)) }))) <EOF>)

=== TABLA DE SÍMBOLOS ===
NOMBRE          TIPO       CATEGORÍA       LÍNEA      COLUMNA    ÁMBITO          PARÁMETROS
--------------------------------------------------------------------------------------------
a               int        parametro       1          13         suma
b               int        parametro       1          20         suma
suma            int        funcion         1          4          global          [int, int]
main            void       funcion         5          5          global

? Análisis semántico completado sin errores.
```

---
# 📊 Tabla de Símbolos

## 🔍 ¿Qué es la Tabla de Símbolos?

La **Tabla de Símbolos** es una estructura de datos fundamental en nuestro compilador que almacena información sobre todos los identificadores (variables, funciones, parámetros) que aparecen en el programa fuente. Funciona como un diccionario que registra información esencial sobre cada símbolo para facilitar las fases de **análisis semántico** y **generación de código**.

---

## 🏗️ Estructura de la Tabla de Símbolos

Nuestra implementación consta de los siguientes componentes:

### 📌 Clase `Simbolo`

Cada entrada en la tabla contiene:

- **nombre**: Identificador del símbolo  
- **tipo**: Tipo de dato (`int`, `char`, `double`, `void`)  
- **categoría**: Clasificación del símbolo (`variable`, `funcion`, `parametro`)  
- **línea y columna**: Posición en el código fuente donde se declaró  
- **ámbito**: Contexto de visibilidad (`global` o nombre de la función)  
- **parámetros**: Lista de tipos de parámetros (solo para funciones)  

---

## 🔄 Gestión de Ámbitos

La tabla maneja dos niveles de ámbito:

- **Ámbito global**: Accesible desde cualquier parte del programa  
- **Ámbito local**: Específico de cada función, solo visible dentro de ella  

---

## 🛠️ Funcionalidades Principales

La Tabla de Símbolos ofrece las siguientes operaciones:

- **Agregar símbolos (`agregar`)**:  
  Inserta nuevas entradas verificando duplicidad en el mismo ámbito

- **Búsqueda de símbolos (`buscar`)**:
  - Búsqueda en el ámbito actual
  - Búsqueda en ámbito específico
  - Búsqueda considerando la jerarquía de ámbitos (local → global)

- **Gestión de ámbitos (`setAmbito`, `getAmbito`)**:  
  Establecer y consultar el ámbito actual

- **Visualización (`imprimir`)**:  
  Mostrar el contenido completo de la tabla

---

## 📝 Ejemplo de Salida

=== TABLA DE SÍMBOLOS === NOMBRE TIPO CATEGORÍA LÍNEA COLUMNA ÁMBITO PARÁMETROS
a int parametro 1 13 suma b int parametro 1 20 suma suma int funcion 1 4 global [int, int] main void funcion 5 5 global resultado int variable 6 8 main

yaml
Copiar
Editar

---

## 🧩 Importancia en el Proceso de Compilación

La Tabla de Símbolos es crucial para:

- **Verificación de tipos**: Comprobar que las operaciones sean compatibles con los tipos de datos  
- **Control de ámbitos**: Gestionar la visibilidad y acceso a variables  
- **Detección de errores semánticos**:
  - Uso de variables no declaradas
  - Redeclaración de identificadores
  - Inconsistencias en el número o tipo de parámetros en llamadas a funciones

- **Generación de código**:  
  Proporciona información necesaria para la generación de código intermedio o código objeto

---

## 📈 Implementación Eficiente

Nuestra implementación utiliza estructuras de datos optimizadas:

- `ArrayList` para almacenar los símbolos  
- Métodos de búsqueda considerando jerarquía de ámbitos  
- Formato de visualización claro para depuración  

# 🧠 Construcción de la Tabla mediante `SimbolosListener`

La **Tabla de Símbolos** se construye durante el recorrido del árbol sintáctico a través de un **listener especializado**.

---

## 🔄 Clase `SimbolosListener`

Esta clase extiende `MiLenguajeBaseListener` generado por ANTLR4 e implementa los siguientes métodos clave:

### 📌 Gestión de funciones:

- `enterDeclaracionFuncion`:  
  Registra la función y sus parámetros, cambiando al ámbito de la función

- `exitDeclaracionFuncion`:  
  Restaura el ámbito global al salir de la función

### 📌 Verificación de variables:

- `enterExpVariable`:  
  Comprueba que las variables utilizadas hayan sido declaradas previamente

### 📌 Manejo de errores:

- `visitErrorNode`:  
  Captura errores sintácticos detectados durante el análisis

> Se mantiene una **lista de errores semánticos** para informar al usuario.

---

## 📋 Proceso de Construcción

Durante el recorrido del árbol, el listener:

- Captura declaraciones de funciones y sus parámetros  
- Registra variables locales y globales  
- Verifica referencias a identificadores  
- Detecta errores como:
  - Redeclaración de funciones o variables
  - Uso de variables no declaradas
  - Parámetros duplicados

---

## 📊 Ejemplo de Código para Análisis Semántico

```java
// Crear el listener para tabla de símbolos
SimbolosListener simbolosListener = new SimbolosListener();

// Recorrer el árbol con el listener
ParseTreeWalker walker = new ParseTreeWalker();
walker.walk(simbolosListener, tree);

// Obtener la tabla de símbolos construida
TablaSimbolos tabla = simbolosListener.getTablaSimbolos();

// Verificar si hay errores semánticos
List<String> errores = simbolosListener.getErrores();
if (!errores.isEmpty()) {
    for (String error : errores) {
        System.err.println(error);
    }
} else {
    // Mostrar la tabla de símbolos
    tabla.imprimir();
}


## 🚀 ¡Hora de Compilar y Ejecutar!

### 📦 Compilar el proyecto

```bash
mvn clean package
```

### ▶️ Ejecutar el compilador

```bash
mvn package assembly:single
java -jar target/demo-1.0-jar-with-dependencies.jar ejemplo.txt   
java -jar target/demo-1.0-jar-with-dependencies.jar ejemplo_error.txt
```


