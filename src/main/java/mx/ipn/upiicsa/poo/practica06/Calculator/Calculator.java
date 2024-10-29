package mx.ipn.upiicsa.poo.practica06.Calculator;

public class Calculator {
    // Método para sumar dos números
    public double suma(double a, double b) {
        return a + b;
    }

    // Método para restar dos números
    public double resta(double a, double b) {
        return a - b;
    }

    // Método para multiplicar dos números
    public double multiplicacion(double a, double b) {
        return a * b;
    }

    // Método para dividir dos números; maneja la división por cero
    public double division(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Error: No se puede dividir entre cero.");
            return 0;
        }
    }

    // Método para calcular el porcentaje de un valor
    public double porcentaje(double a, double b) {
        return (a * b) / 100;
    }
}
