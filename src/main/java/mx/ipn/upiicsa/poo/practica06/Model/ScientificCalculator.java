package mx.ipn.upiicsa.poo.practica06.Model;

public class ScientificCalculator extends CalculatorBase {

    @Override
    public double calculate() {
        switch (operator) {
            case "sin":
                return Math.sin(Math.toRadians(operand));
            case "cos":
                return Math.cos(Math.toRadians(operand));
            case "tan":
                return Math.tan(Math.toRadians(operand));
            case "log":
                return Math.log10(operand);
            case "sqrt":
                return Math.sqrt(operand);
            default:
                return 0;
        }
    }
}