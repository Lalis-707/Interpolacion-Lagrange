# Interpolación Polinomial: Lagrange vs. Diferencias Divididas de Newton
**Práctica:** Tarea 01, Unidad 05  ^v^

## Descripción general

Proyecto en Java que implementa y compara dos métodos de interpolación polinomial:

- **Interpolación de Lagrange** (`InterpolacionLagrange.java`): se completó la línea de la productoria del polinomio base `L_i(x)`:
  ```java
  termino *= (xEval - x[j]) / (x[i] - x[j]);
  ```
- **Diferencias Divididas de Newton** (`InterpolacionNewton.java`): calcula e imprime la tabla de diferencias divididas, los coeficientes del polinomio y lo evalúa en un punto.
- **Main** (`Main.java`): ejecuta ambos métodos con el mismo conjunto de nodos y calcula la diferencia absoluta entre los resultados.

## Requerimientos del entorno

| Requisito | Versión |
|---|---|
| Java (JDK) | 11 o superior |
| IDE | IntelliJ IDEA (también funciona en Eclipse o NetBeans) |
| Sistema operativo | Windows / Linux / macOS |

> Se requiere Java 11 o superior porque se usa `String.repeat()` en el formato de la tabla.

## Estructura del proyecto

```
Interpolacion-Lagrange/
├── README.md
├── .gitignore
└── src/
    └── interpolacion/
        ├── InterpolacionLagrange.java
        ├── InterpolacionNewton.java
        └── Main.java
```

## Guía de ejecución rápida

### Opción A: con IntelliJ IDEA

1. Clonar el repositorio:
   ```
   git clone https://github.com/Lalis-707/Interpolacion-Lagrange.git
   ```
2. En IntelliJ: **File > Open** y seleccionar la carpeta clonada.
3. Si es necesario, clic derecho en `src` > **Mark Directory as > Sources Root**.
4. Abrir `Main.java` y presionar **Run**.

### Opción B: desde la terminal

```
git clone https://github.com/Lalis-707/Interpolacion-Lagrange.git
cd Interpolacion-Lagrange
javac -d out src/interpolacion/*.java
java -cp out interpolacion.Main
```

## Datos de prueba

| Dato | Valor |
|---|---|
| Nodos x | `{1.0, 2.0, 4.0, 5.0}` |
| Valores y | `{2.0, 3.0, 10.0, 20.0}` |
| Punto de evaluación | `x = 3.0` |

## Salida esperada en consola

```
--- TABLA DE DIFERENCIAS DIVIDIDAS ---
+------------+------------+------------+------------+------------+
|         x_i|      f[x_i]|     Orden 1|     Orden 2|     Orden 3|
+------------+------------+------------+------------+------------+
|        1.00|      2.0000|      1.0000|      0.8333|      0.3333|
|        2.00|      3.0000|      3.5000|      2.1667|            |
|        4.00|     10.0000|     10.0000|            |            |
|        5.00|     20.0000|            |            |            |
+------------+------------+------------+------------+------------+

--- COEFICIENTES DEL POLINOMIO (a_k) ---
a_0 = 2.0000
a_1 = 1.0000
a_2 = 0.8333
a_3 = 0.3333

Newton:   P(3.00) = 5.000000

========== LAGRANGE ==========
Lagrange: P(3.00) = 5.000000

========== COMPARACIÓN ==========
Diferencia absoluta = 8.882e-16
```

Ambos métodos devuelven `P(3.0) = 5.000000`. La diferencia del orden de 10⁻¹⁶ corresponde al error de redondeo de la aritmética de punto flotante (`double`).

## Notas

- Los nodos `x` no deben repetirse; `InterpolacionLagrange` lanza una `IllegalArgumentException` en ese caso.
- El código de Diferencias Divididas de Newton se tomó del repositorio oficial de la asignatura, y se modificó únicamente el método `imprimirTabla` para mostrar la tabla con formato.

## Referencia del repositorio oficial de la asignatura

https://github.com/victorvasher/M-todos-N-mericos-ITSX/tree/main/Interpolaci%C3%B3n
