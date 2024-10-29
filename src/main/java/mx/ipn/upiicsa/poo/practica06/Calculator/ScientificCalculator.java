package mx.ipn.upiicsa.poo.practica06.Calculator;

public class ScientificCalculator extends Calculator{
    // Redondea hacia abajo el valor
    public double piso(double a) {
        return Math.floor(a);
    }

    // Redondea hacia arriba el valor
    public double techo(double a) {
        return Math.ceil(a);
    }

    // Redondea al entero más cercano
    public double redondeo(double a) {
        return Math.round(a);
    }

    // Calcula el cuadrado del número
    public double potenciaCuadrado(double a) {
        return Math.pow(a, 2);
    }

    // Calcula el cubo del número
    public double potenciaCubo(double a) {
        return Math.pow(a, 3);
    }

    // Calcula la potencia n de un número
    public double potenciaN(double a, double n) {
        return Math.pow(a, n);
    }

    // Calcula la raíz cuadrada de un número
    public double raizCuadrada(double a) {
        return Math.sqrt(a);
    }

    // Calcula la raíz cúbica de un número
    public double raizCubica(double a) {
        return Math.cbrt(a);
    }

    // Calcula la raíz n de un número
    public double raizN(double a, double n) {
        return Math.pow(a, 1.0 / n);
    }

    // Calcula el seno de un ángulo en grados
    public double seno(double a) {
        return Math.sin(Math.toRadians(a));
    }

    // Calcula el coseno de un ángulo en grados
    public double coseno(double a) {
        return Math.cos(Math.toRadians(a));
    }

    // Calcula la tangente de un ángulo en grados
    public double tangente(double a) {
        return Math.tan(Math.toRadians(a));
    }

    // Calcula el factorial de un número entero
    public double factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo");
        }
        double resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
