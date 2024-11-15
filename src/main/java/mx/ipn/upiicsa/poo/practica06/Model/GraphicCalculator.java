package mx.ipn.upiicsa.poo.practica06.Model;

public class GraphicCalculator {
    private double firstOperand;
    private double secondOperand;
    private String operator;
    private boolean readyForSecondOperand;

    public GraphicCalculator() {
        reset();
    }

    public void reset() {
        firstOperand = 0;
        secondOperand = 0;
        operator = "";
        readyForSecondOperand = false;
    }

    public void setOperand(double operand) {
        if (!readyForSecondOperand) {
            firstOperand = operand;
            readyForSecondOperand = true;
        } else {
            secondOperand = operand;
        }
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculate() {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    throw new ArithmeticException("No se puede dividir entre cero");
                }
            case "%":
                return (firstOperand * secondOperand) / 100.0;
            default:
                return secondOperand;
        }
    }
}