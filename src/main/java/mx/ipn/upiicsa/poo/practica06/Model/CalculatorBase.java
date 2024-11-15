package mx.ipn.upiicsa.poo.practica06.Model;

public abstract class CalculatorBase {
    protected double operand;
    protected String operator;

    public void setOperand(double operand) {
        this.operand = operand;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void reset() {
        this.operand = 0;
        this.operator = "";
    }

    // Método abstracto que calculará la expresión
    public abstract double calculate(String expression);
}