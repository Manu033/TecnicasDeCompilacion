# Proyecto Final - Técnicas de Compilación

## Pasos para levantar el proyecto localmente

### 1. Clonar repositorio
```
git clone https://github.com/Manu033/TecnicasDeCompilacion.git
```

### 2. Entrar a la ruta del proyecto final

```
cd TecnicasDeCompilacion/ProyectoFinal
-> tu-carpeta/TecnicasDeCompilacion/ProyectoFinal
```

### 3. Compilar el proyecto
Con el siguiente comando compilas el proyecto JAVA
```
mvn clean package                                                                                  
```
### 4. Ejecutar el proyecto indicandole el archivo a analizar

```
java -jar target/demo-1.0-jar-with-dependencies.jar <ejemploAEjecutar.txt>     
```