package mx.ipn.upiicsa.poo.practica06.Model;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException;

public class ScientificCalculator extends CalculatorBase {

    @Override
    public double calculate(String expression) {
        try {
            // Crear y evaluar la expresión científica con Exp4j
            Expression exp = new ExpressionBuilder(expression).build();
            return exp.evaluate();
        } catch (ArithmeticException | UnknownFunctionOrVariableException e) {
            System.out.println("Error al evaluar la expresión científica: " + expression);
            e.printStackTrace();
            return 0;
        }
    }
}