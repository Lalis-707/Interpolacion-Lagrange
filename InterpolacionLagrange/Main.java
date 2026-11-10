package Ecuaciones_Lineales.InterpolacionLagrange;

public class Main {

    public static void main(String[] args) {
        // Nodos propios (cámbialos si lo deseas)
        double[] x = {1.0, 2.0, 4.0, 5.0};
        double[] y = {2.0, 3.0, 10.0, 20.0};

        // Punto a interpolar
        double xEval = 3.0;

        // ===== METODO DE NEWTON =====
        System.out.println("========== NEWTON (DIFERENCIAS DIVIDIDAS) ==========");
        double[][] tabla = InterpolacionNewton.calcularDiferenciasDivididas(x, y);
        InterpolacionNewton.imprimirTabla(x, tabla);

        System.out.println("\n--- COEFICIENTES DEL POLINOMIO (a_k) ---");
        for (int k = 0; k < x.length; k++) {
            System.out.printf("a_%d = %.4f\n", k, tabla[0][k]);
        }

        double yNewton = InterpolacionNewton.evaluarPolinomio(x, tabla, xEval);
        System.out.printf("\nNewton:   P(%.2f) = %.6f\n", xEval, yNewton);

        // ===== METODO DE LAGRANGE =====
        System.out.println("\n========== LAGRANGE ==========");
        double yLagrange = InterpolacionLagrange.interpolacionLagrange(x, y, xEval);
        System.out.printf("Lagrange: P(%.2f) = %.6f\n", xEval, yLagrange);

        // ===== COMPARACIÓN =====
        System.out.println("\n========== COMPARACIÓN ==========");
        System.out.printf("Diferencia absoluta = %.3e\n", Math.abs(yNewton - yLagrange));
    }
}