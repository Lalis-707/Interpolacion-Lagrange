package Ecuaciones_Lineales.InterpolacionLagrange;

public class InterpolacionNewton {
    /**
     * Calcula la tabla de diferencias divididas para los puntos dados.
     *
     * @param x Arreglo con los valores de x (nodos)
     * @param y Arreglo con los valores de y (f(x))
     * @return Matriz con la tabla de diferencias divididas
     */
    public static double[][] calcularDiferenciasDivididas(double[] x, double[] y) {
        int n = x.length;
        double[][] tabla = new double[n][n];

        // La primera columna contiene los valores de y (diferencias de orden 0)
        for (int i = 0; i < n; i++) {
            tabla[i][0] = y[i];
        }

        // Cálculo de las diferencias divididas de orden superior
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i + 1][j - 1] - tabla[i][j - 1]) / (x[i + j] - x[i]);
            }
        }
        return tabla;
    }

    /**
     * Evalúa el polinomio interpolador de Newton en un punto xEval dado.
     *
     * @param x     Arreglo con los nodos de x
     * @param tabla Matriz de diferencias divididas
     * @param xEval El punto x donde queremos interpolar
     * @return El valor interpolado y = P(xEval)
     */
    public static double evaluarPolinomio(double[] x, double[][] tabla, double xEval) {
        int n = x.length;
        double resultado = tabla[0][0];
        double productoTerminos = 1.0;

        // Sumamos a1*(x - x0) + a2*(x - x0)(x - x1) + ...
        for (int i = 1; i < n; i++) {
            productoTerminos *= (xEval - x[i - 1]);
            resultado += tabla[0][i] * productoTerminos;
        }

        return resultado;
    }

    /**
     * Imprime en consola la tabla de diferencias divididas con formato de tabla.
     */
    public static void imprimirTabla(double[] x, double[][] tabla) {
        int n = x.length;
        int ancho = 12; // ancho de cada columna

        String fmtTexto = "|%" + ancho + "s";
        String fmtNumero = "|%" + ancho + ".4f";
        String fmtX = "|%" + ancho + ".2f";

        // Separador horizontal: +------------+------------+ ...
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n + 1; k++) {
            sb.append("+").append("-".repeat(ancho));
        }
        sb.append("+");
        String separador = sb.toString();

        System.out.println("\n--- TABLA DE DIFERENCIAS DIVIDIDAS ---");

        // Encabezado
        System.out.println(separador);
        System.out.printf(fmtTexto, "x_i");
        System.out.printf(fmtTexto, "f[x_i]");
        for (int j = 1; j < n; j++) {
            System.out.printf(fmtTexto, "Orden " + j);
        }
        System.out.println("|");
        System.out.println(separador);

        // Filas
        for (int i = 0; i < n; i++) {
            System.out.printf(fmtX, x[i]);
            for (int j = 0; j < n; j++) {
                if (j < n - i) {
                    System.out.printf(fmtNumero, tabla[i][j]);
                } else {
                    System.out.printf(fmtTexto, ""); // celda vacía
                }
            }
            System.out.println("|");
        }
        System.out.println(separador);
    }
}