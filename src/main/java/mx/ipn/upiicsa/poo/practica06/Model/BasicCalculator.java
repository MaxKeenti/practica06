package mx.ipn.upiicsa.poo.practica06.Model;

public class BasicCalculator extends CalculatorBase {

    @Override
    public double calculate() {
        switch (operator) {
            case "+":
                return operand;
            case "-":
                return -operand;
            case "*":
                return operand;
            case "/":
                if (operand == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return operand;
            case "%":
                return operand / 100;
            default:
                return 0;
        }
    }
}