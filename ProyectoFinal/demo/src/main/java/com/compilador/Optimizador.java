 package com.compilador;

// import java.util.*;
// import java.util.regex.*;

// /**
//  * Optimizador de código de tres direcciones
//  */
// public class Optimizador {
//     private List<String> codigo;

//     public Optimizador(List<String> codigo) {
//         this.codigo = new ArrayList<>(codigo);
//     }

//     /**
//      * Realiza todas las optimizaciones disponibles
//      */
//     public List<String> optimizar() {
//         eliminarCodigoMuerto();
//         propagarConstantes();
//         simplificarExpresiones();
//         eliminarSentenciasRedundantes();
//         eliminarAsignacionesInutiles();

//         return codigo;
//     }

//     /**
//      * Elimina código muerto (código inalcanzable)
//      */
//     public void eliminarCodigoMuerto() {
//         Set<Integer> lineasAlcanzables = new HashSet<>();
//         Map<String, Integer> etiquetas = new HashMap<>();
//         // Identificar etiquetas
//         for (int i = 0; i < codigo.size(); i++) {
//             String linea = codigo.get(i);
//             if (linea.endsWith(":")) {
//                 String etiqueta = linea.substring(0, linea.length() - 1);
//                 etiquetas.put(etiqueta, i);
//             }
//         }
//         // Marcar desde inicio y desde func_main
//         marcarLineasAlcanzables(0, lineasAlcanzables, etiquetas);
//         if (etiquetas.containsKey("func_main")) {
//             marcarLineasAlcanzables(etiquetas.get("func_main"), lineasAlcanzables, etiquetas);
//         }
//         // Filtrar
//         List<String> codigoOpt = new ArrayList<>();
//         for (int i = 0; i < codigo.size(); i++) {
//             if (lineasAlcanzables.contains(i)) {
//                 codigoOpt.add(codigo.get(i));
//             }
//         }
//         codigo = codigoOpt;
//     }

//     private void marcarLineasAlcanzables(int linea, Set<Integer> visitadas, Map<String, Integer> etiquetas) {
//         if (linea >= codigo.size() || visitadas.contains(linea)) return;
//         visitadas.add(linea);
//         String instr = codigo.get(linea).trim();
//         if (instr.startsWith("goto ")) {
//             String et = instr.substring(5).trim();
//             if (etiquetas.containsKey(et)) {
//                 marcarLineasAlcanzables(etiquetas.get(et), visitadas, etiquetas);
//             }
//             return;
//         }
//         if (instr.startsWith("if ") && instr.contains(" goto ")) {
//             String[] partes = instr.split(" goto ");
//             String et = partes[1].trim();
//             if (etiquetas.containsKey(et)) {
//                 marcarLineasAlcanzables(etiquetas.get(et), visitadas, etiquetas);
//             }
//         }
//         if (instr.equals("return") || instr.startsWith("return ")) {
//             return;
//         }
//         marcarLineasAlcanzables(linea + 1, visitadas, etiquetas);
//     }

//     /**
//      * Propaga constantes cuando es posible
//      */
//     public void propagarConstantes() {
//         Map<String, String> constantValues = new HashMap<>();
//         List<String> codigoOpt = new ArrayList<>();
//         for (String linea : codigo) {
//             if (linea.contains(" = ") && !linea.matches(".*call.*")) {
//                 String[] partes = linea.split("=", 2);
//                 String dest = partes[0].trim();
//                 String val = partes[1].replace(";", "").trim();
//                 if (val.matches("-?\\d+")) {
//                     constantValues.put(dest, val);
//                     codigoOpt.add(dest + " = " + val);
//                     continue;
//                 }
//                 if (constantValues.containsKey(val)) {
//                     constantValues.put(dest, constantValues.get(val));
//                     codigoOpt.add(dest + " = " + constantValues.get(val));
//                     continue;
//                 }
//             }
//             String tmp = linea;
//             for (Map.Entry<String, String> e : constantValues.entrySet()) {
//                 tmp = tmp.replaceAll("\\b" + e.getKey() + "\\b", e.getValue());
//             }
//             codigoOpt.add(tmp);
//         }
//         codigo = codigoOpt;
//     }

//     /**
//      * Simplifica expresiones constantes y neutras
//      */
//     public void simplificarExpresiones() {
//         List<String> codigoOpt = new ArrayList<>();
//         for (String linea : codigo) {
//             String newline = linea;
//             if (newline.contains(" = ")) {
//                 String[] partes = newline.split("=", 2);
//                 String dest = partes[0].trim();
//                 String expr = partes[1].replace(";", "").trim();
//                 // Constantes aritméticas
//                 if (expr.matches("-?\\d+ [+\\-*/%] -?\\d+")) {
//                     String[] op = expr.split(" ");
//                     int a = Integer.parseInt(op[0]);
//                     String oper = op[1];
//                     int b = Integer.parseInt(op[2]);
//                     int res = 0;
//                     boolean ok = true;
//                     switch (oper) {
//                         case "+": res = a + b; break;
//                         case "-": res = a - b; break;
//                         case "*": res = a * b; break;
//                         case "/": if (b != 0) res = a / b; else ok = false; break;
//                         case "%": if (b != 0) res = a % b; else ok = false; break;
//                     }
//                     if (ok) {
//                         newline = dest + " = " + res;
//                         codigoOpt.add(newline);
//                         continue;
//                     }
//                 }
//                 // Operaciones neutras
//                 newline = newline.replaceAll("\\b(\\w+) \\+ 0\\b", "$1");
//                 newline = newline.replaceAll("\\b0 \\+ (\\w+)\\b", "$1");
//                 newline = newline.replaceAll("\\b(\\w+) \\* 1\\b", "$1");
//                 newline = newline.replaceAll("\\b1 \\* (\\w+)\\b", "$1");
//             }
//             codigoOpt.add(newline);
//         }
//         codigo = codigoOpt;
//     }

//     /**
//      * Elimina sentencias redundantes (a = a)
//      */
//     public void eliminarSentenciasRedundantes() {
//         List<String> codigoOpt = new ArrayList<>();
//         for (String linea : codigo) {
//             if (linea.contains(" = ")) {
//                 String[] partes = linea.split("=", 2);
//                 String dest = partes[0].trim();
//                 String val  = partes[1].replace(";", "").trim();
//                 if (dest.equals(val)) continue;
//             }
//             codigoOpt.add(linea);
//         }
//         codigo = codigoOpt;
//     }

//     /**
//      * Elimina asignaciones a variables nunca usadas (dead-store)
//      */
//     public void eliminarAsignacionesInutiles() {
//         List<String> result = new ArrayList<>();
//         Set<String> vivas = new HashSet<>();
//         vivas.add("resultado");  // considera resultado como entrada/salida
//         Pattern varPat = Pattern.compile("\\b[a-zA-Z_]\\w*\\b");
//         for (int i = codigo.size() - 1; i >= 0; i--) {
//             String linea = codigo.get(i);
//             if (linea.contains(" = ")) {
//                 String[] partes = linea.split("=", 2);
//                 String dest = partes[0].trim();
//                 String expr = partes[1].replaceAll("//.*", "").replace(";", "").trim();
//                 if (!vivas.contains(dest)) continue;
//                 result.add(0, linea);
//                 Matcher m = varPat.matcher(expr);
//                 while (m.find()) {
//                     String var = m.group();
//                     if (!var.matches("\\d+")) vivas.add(var);
//                 }
//                 vivas.add(dest);
//             } else {
//                 result.add(0, linea);
//                 Matcher m = varPat.matcher(linea);
//                 while (m.find()) {
//                     String var = m.group();
//                     if (!var.matches("\\d+")) vivas.add(var);
//                 }
//             }
//         }
//         codigo = result;
//     }


//     /**
//      * Obtiene el código optimizado
//      */
//     public List<String> getCodigoOptimizado() {
//         return codigo;
//     }

//     /**
//      * Imprime el código optimizado
//      */
//     public void imprimirCodigoOptimizado() {
//         System.out.println("\n=== CÓDIGO OPTIMIZADO ===");
//         for (int i = 0; i < codigo.size(); i++) {
//             System.out.println(i + ": " + codigo.get(i));
//         }
//     }
// }

// package com.compilador;

// import java.util.*;

// /**
//  * Optimizador de código de tres direcciones
//  */
// public class Optimizador {
    
//     private List<String> codigo;
    
//     public Optimizador(List<String> codigo) {
//         this.codigo = new ArrayList<>(codigo);
//     }
    
//     /**
//      * Realiza todas las optimizaciones disponibles
//      */
//     public List<String> optimizar() {

//         propagarConstantes();
//         simplificarExpresiones();
//         eliminarCodigoMuerto();
//         eliminarSentenciasRedundantes();
//         return codigo;
//     }

//      /**
//      * Propaga constantes cuando es posible
//      */
//     public void propagarConstantes() {
//     Map<String,String> consts = new HashMap<>();
//     List<String> out = new ArrayList<>();

//     for (String linea : codigo) {
//         String trimmed = linea.trim();
//         if (trimmed.contains(" = ") && !trimmed.contains(" call ")) {
//             // Divide en LHS y RHS
//             String[] partes = trimmed.split("\\s*=\\s*", 2);
//             String dest = partes[0].trim();
//             String rhs  = partes[1].trim();

//             // Sustituye constantes **solo** en RHS
// for (Map.Entry<String,String> e : consts.entrySet()) {
//     rhs = rhs.replaceAll("\\b" + e.getKey() + "\\b", e.getValue());
// }


//             // Si RHS ha quedado en literal puro, lo guardo
//             if (rhs.matches("-?\\d+(\\.\\d+)?") || rhs.matches("'.'")) {
//                 consts.put(dest, rhs);
//             } else {
//                 // Ya no constante → lo elimino del mapa
//                 consts.remove(dest);
//             }

//             out.add(dest + " = " + rhs);
//         } else {
//             // No es asignación simple → propago en toda la línea
//             String tmp = linea;
// for (Map.Entry<String,String> e : consts.entrySet()) {
//                 tmp = tmp.replaceAll("\\b"+e.getKey()+"\\b", e.getValue());
//             }
//             out.add(tmp);
//         }
//     }
//     codigo = out;
// }

    
//     /**
//      * Simplifica expresiones constantes (ej: 2 + 3 -> 5)
//      */
// public void simplificarExpresiones() {
//     List<String> out = new ArrayList<>();

//     for (String linea : codigo) {
//         if (linea.contains(" = ")) {
//             // 1) Separa LHS y RHS
//             String[] p = linea.split("\\s*=\\s*", 2);
//             String dest = p[0].trim();
//             String rhs  = p[1].trim();

//             // 2) Expresión aritmética constante: “num OP num”
//             if (rhs.matches("-?\\d+\\s*[+\\-*/%]\\s*-?\\d+")) {
//                 String[] opParts = rhs.split("\\s*[+\\-*/%]\\s*");
//                 int a = Integer.parseInt(opParts[0]);
//                 int b = Integer.parseInt(opParts[1]);
//                 char oper = rhs.replaceAll(".*?([+\\-*/%]).*", "$1").charAt(0);
//                 int res;
//                 switch (oper) {
//                     case '+': res = a + b; break;
//                     case '-': res = a - b; break;
//                     case '*': res = a * b; break;
//                     case '/': res = (b != 0 ? a / b : a); break;
//                     case '%': res = (b != 0 ? a % b : a); break;
//                     default:  res = 0;
//                 }
//                 out.add(dest + " = " + res);
//                 continue;
//             }

//             // 3) Expresión lógica constante: “num COMPAR num”
//             if (rhs.matches("-?\\d+\\s*(>=|<=|>|<|==|!=)\\s*-?\\d+")) {
//                 String[] cmp = rhs.split("\\s*(>=|<=|==|!=|>|<)\\s*");
//                 int a = Integer.parseInt(cmp[0]);
//                 int b = Integer.parseInt(cmp[1]);
//                 String oper = rhs.replaceAll(".*?(>=|<=|==|!=|>|<).*", "$1");
//                 boolean r;
//                 switch (oper) {
//                     case ">":  r = a > b;  break;
//                     case ">=": r = a >= b; break;
//                     case "<":  r = a < b;  break;
//                     case "<=": r = a <= b; break;
//                     case "==": r = a == b; break;
//                     default:   r = a != b;
//                 }
//                 out.add(dest + " = " + (r ? 1 : 0));
//                 continue;
//             }

//             // 4) No es constante pura → dejo la asignación recortada
//             out.add(dest + " = " + rhs);
//         } else {
//             // No es asignación → mantenla tal cual
//             out.add(linea);
//         }
//     }
//     codigo = out;
// }


    
//     /**
//      * Elimina código muerto (código inalcanzable)
//      */
//     public void eliminarCodigoMuerto() {
//         Set<Integer> lineasAlcanzables = new HashSet<>();
//         Map<String, Integer> etiquetas = new HashMap<>();
        
//         // Primero, identificar todas las etiquetas y sus líneas
//         for (int i = 0; i < codigo.size(); i++) {
//             String linea = codigo.get(i);
//             if (linea.endsWith(":")) {
//                 String etiqueta = linea.substring(0, linea.length() - 1);
//                 etiquetas.put(etiqueta, i);
//             }
//         }
        
//         // Marcar líneas alcanzables con un recorrido desde el inicio
//         marcarLineasAlcanzables(0, lineasAlcanzables, etiquetas);
        
//         // También asegurarnos de que main sea considerado como punto de entrada
//         if (etiquetas.containsKey("func_main")) {
//             marcarLineasAlcanzables(etiquetas.get("func_main"), lineasAlcanzables, etiquetas);
//         }
        
//         // Eliminar líneas no alcanzables
//         List<String> codigoOptimizado = new ArrayList<>();
//         for (int i = 0; i < codigo.size(); i++) {
//             if (lineasAlcanzables.contains(i)) {
//                 codigoOptimizado.add(codigo.get(i));
//             }
//         }
        
//         codigo = codigoOptimizado;
//     }
    
//     /**
//      * Recursivamente marca líneas alcanzables
//      */
//     private void marcarLineasAlcanzables(int linea, Set<Integer> lineasAlcanzables, Map<String, Integer> etiquetas) {
//         // Si ya visitamos esta línea, retornar
//         if (linea >= codigo.size() || lineasAlcanzables.contains(linea)) {
//             return;
//         }
        
//         lineasAlcanzables.add(linea);
//         String instruccion = codigo.get(linea);
        
//         // Si es un goto incondicional
//         if (instruccion.startsWith("goto ")) {
//             String etiqueta = instruccion.substring(5);
//             if (etiquetas.containsKey(etiqueta)) {
//                 marcarLineasAlcanzables(etiquetas.get(etiqueta), lineasAlcanzables, etiquetas);
//             }
//             return; // No continúa con la siguiente instrucción
//         }
        
//         // Si es un goto condicional
//         if (instruccion.startsWith("if ")) {
//             String[] partes = instruccion.split(" goto ");
//             if (partes.length == 2) {
//                 String etiqueta = partes[1];
//                 if (etiquetas.containsKey(etiqueta)) {
//                     marcarLineasAlcanzables(etiquetas.get(etiqueta), lineasAlcanzables, etiquetas);
//                 }
//             }
//         }
        
//         // Si es return, no continúa con la siguiente instrucción
//         if (instruccion.equals("return") || instruccion.startsWith("return ")) {
//             return;
//         }
        
//         // Continuar con la siguiente instrucción
//         marcarLineasAlcanzables(linea + 1, lineasAlcanzables, etiquetas);
//     }
    
   
    
//     /**
//      * Elimina sentencias redundantes (asignación a sí mismo, etc)
//      */
//     public void eliminarSentenciasRedundantes() {
//         List<String> codigoOptimizado = new ArrayList<>();
        
//         for (String linea : codigo) {
//             // Eliminar asignaciones a sí mismo (a = a)
//             if (linea.contains(" = ")) {
//                 String[] partes = linea.split(" = ");
//                 if (partes.length == 2) {
//                     String destino = partes[0].trim();
//                     String valor = partes[1].trim();
                    
//                     if (destino.equals(valor)) {
//                         continue; // Saltar esta línea
//                     }
//                 }
//             }
            
//             codigoOptimizado.add(linea);
//         }
        
//         codigo = codigoOptimizado;
//     }
    
//     /**
//      * Obtiene el código optimizado
//      */
//     public List<String> getCodigoOptimizado() {
//         return codigo;
//     }
    
//     /**
//      * Imprime el código optimizado
//      */
//     public void imprimirCodigoOptimizado() {
//         System.out.println("\n=== CÓDIGO OPTIMIZADO ===");
//         for (int i = 0; i < codigo.size(); i++) {
//             System.out.println(i + ": " + codigo.get(i));
//         }
//     }
// }


import java.io.*;
import java.util.*;

/**
 * Optimizador de código de tres direcciones (texto plano)
 */
public class Optimizador {
    private List<String> codigo;

    public Optimizador(List<String> codigo) {
        // Copia defensiva
        this.codigo = new ArrayList<>(codigo);
    }

    /**
     * Ejecuta todas las fases de optimización:
     * 1) propagación de constantes
     * 2) plegado de expresiones constantes
     * 3) eliminación de código muerto
     * 4) eliminación de asignaciones redundantes
     */
    public List<String> optimizar() {
        propagarConstantes();
        simplificarExpresiones();
        eliminarCodigoMuerto();
        eliminarSentenciasRedundantes();
        return codigo;
    }

    /**
     * Fase 1: Propagar constantes solo en el RHS de asignaciones simples.
     */
    private void propagarConstantes() {
        Map<String,String> consts = new HashMap<>();
        List<String> out = new ArrayList<>();
        for (String linea : codigo) {
            String trimmed = linea.trim();
            if (trimmed.contains(" = ") && !trimmed.contains(" call ")) {
                String[] partes = trimmed.split("\\s*=\\s*", 2);
                String dest = partes[0].trim();
                String rhs  = partes[1].trim();
                // sustituir solo en RHS
                for (Map.Entry<String,String> e : consts.entrySet()) {
                    rhs = rhs.replaceAll("\\b" + e.getKey() + "\\b", e.getValue());
                }
                // actualizar mapa si RHS es literal
                if (rhs.matches("-?\\d+(\\.\\d+)?") || rhs.matches("'.'")) {
                    consts.put(dest, rhs);
                } else {
                    consts.remove(dest);
                }
                out.add(dest + " = " + rhs);
            } else {
                // propagar en toda la línea
                String tmp = linea;
                for (Map.Entry<String,String> e : consts.entrySet()) {
                    tmp = tmp.replaceAll("\\b" + e.getKey() + "\\b", e.getValue());
                }
                out.add(tmp);
            }
        }
        codigo = out;
    }

    /**
     * Fase 2: Plegar expresiones aritméticas y lógicas constantes.
     */
    private void simplificarExpresiones() {
        List<String> out = new ArrayList<>();
        for (String linea : codigo) {
            if (linea.contains(" = ")) {
                String[] p = linea.split("\\s*=\\s*", 2);
                String dest = p[0].trim();
                String rhs  = p[1].trim();
                // aritmética constante
                if (rhs.matches("-?\\d+\\s*[+\\-*/%]\\s*-?\\d+")) {
                    String[] opn = rhs.split("\\s*[+\\-*/%]\\s*");
                    int a = Integer.parseInt(opn[0]);
                    int b = Integer.parseInt(opn[1]);
                    char op = rhs.replaceAll(".*?([+\\-*/%]).*", "$1").charAt(0);
                    int res;
                    switch (op) {
                        case '+': res = a + b; break;
                        case '-': res = a - b; break;
                        case '*': res = a * b; break;
                        case '/': res = (b!=0? a/b : a); break;
                        default : res = (b!=0? a%b : a);
                    }
                    out.add(dest + " = " + res);
                    continue;
                }
                // lógica constante
                if (rhs.matches("-?\\d+\\s*(>=|<=|>|<|==|!=)\\s*-?\\d+")) {
                    String[] cmp = rhs.split("\\s*(>=|<=|==|!=|>|<)\\s*");
                    int a = Integer.parseInt(cmp[0]);
                    int b = Integer.parseInt(cmp[1]);
                    String op = rhs.replaceAll(".*?(>=|<=|==|!=|>|<).*", "$1");
                    boolean r;
                    switch (op) {
                        case ">":  r = a>b;  break;
                        case ">=": r = a>=b; break;
                        case "<":  r = a<b;  break;
                        case "<=": r = a<=b; break;
                        case "==": r = a==b; break;
                        default:    r = a!=b; break;
                    }
                    out.add(dest + " = " + (r?1:0));
                    continue;
                }
                // no es constante pura
                out.add(dest + " = " + rhs);
            } else {
                out.add(linea);
            }
        }
        codigo = out;
    }

    /**
     * Fase 3: Eliminación de código muerto (basado en alcance y uso de variables).
     */
    private void eliminarCodigoMuerto() {
        // Mapear etiquetas a índices de línea
        Map<String, Integer> etiquetas = new HashMap<>();
        for (int i = 0; i < codigo.size(); i++) {
            String linea = codigo.get(i).trim();
            if (linea.endsWith(":")) {
                String etiqueta = linea.substring(0, linea.length() - 1);
                etiquetas.put(etiqueta, i);
            }
        }
        
        // Conjunto de líneas alcanzables
        Set<Integer> alcanzables = new HashSet<>();
        // Marcar desde el comienzo y desde func_main si existe
        marcarAlcanzables(0, alcanzables, etiquetas);
        if (etiquetas.containsKey("func_main")) {
            marcarAlcanzables(etiquetas.get("func_main"), alcanzables, etiquetas);
        }
        
        // Reconstruir sólo con líneas alcanzables
        List<String> out = new ArrayList<>();
        for (int i = 0; i < codigo.size(); i++) {
            if (alcanzables.contains(i)) {
                out.add(codigo.get(i));
            }
        }
        codigo = out;
    }

    // Recursión para marcar alcance via saltos y flujo secuencial
    private void marcarAlcanzables(int idx, Set<Integer> alc, Map<String,Integer> etiquetas) {
        if (idx < 0 || idx >= codigo.size() || alc.contains(idx)) {
            return;
        }
        alc.add(idx);
        String linea = codigo.get(idx).trim();
        // Goto incondicional: "goto etiqueta"
        if (linea.startsWith("goto ")) {
            String et = linea.substring(5).trim();
            if (etiquetas.containsKey(et)) {
                marcarAlcanzables(etiquetas.get(et), alc, etiquetas);
            }
            return; // no seguir secuencialmente
        }
        // If condicional: "if <cond> goto etiqueta"
        if (linea.startsWith("if ") && linea.contains(" goto ")) {
            String[] partes = linea.split(" goto ");
            String et = partes[1].trim();
            if (etiquetas.containsKey(et)) {
                marcarAlcanzables(etiquetas.get(et), alc, etiquetas);
            }
        }
        // Return detiene flujo
        if (linea.startsWith("return")) {
            return;
        }
        // Flujo secuencial
        marcarAlcanzables(idx + 1, alc, etiquetas);
    }

    /**
     * Fase 4: Eliminar asignaciones redundantes x = x.
     */
    private void eliminarSentenciasRedundantes() {
        List<String> out = new ArrayList<>();
        for (String linea : codigo) {
            if (linea.contains(" = ")) {
                String[] p = linea.split("\\s*=\\s*", 2);
                if (p[0].trim().equals(p[1].trim())) {
                    continue;
                }
            }
            out.add(linea);
        }
        codigo = out;
    }

    /**
     * Para depuración: imprime el código optimizado.
     */
    public void imprimirCodigoOptimizado() {
        System.out.println("=== CÓDIGO OPTIMIZADO ===");
        for (int i = 0; i < codigo.size(); i++) {
            System.out.println(i + ": " + codigo.get(i));
        }
    }
}
