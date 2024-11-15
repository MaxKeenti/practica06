package mx.ipn.upiicsa.poo.practica06.View;

import javax.swing.*;

public class ScientificButtonPanel extends ButtonPanel {
    public ScientificButtonPanel(DisplayPanel displayPanel) {
        super(displayPanel); // Llama al constructor de la clase padre

        // Añadimos botones científicos
        String[] scientificButtons = {"x²", "x³", "xʸ", "eˣ", "10ˣ", 
                                      "1/x", "√x", "³√x", "ʸ√x", "ln", "log₁₀",
                                      "x!", "sin", "cos", "tan", "e", "π"};
        
        for (String label : scientificButtons) {
            JButton button = new JButton(label);
            button.addActionListener(e -> handleScientificFunction(label));
            getButtonPanel().add(button);
        }
    }

    // Métodos para las funciones científicas
    private void handleScientificFunction(String label) {
        double value = Double.parseDouble(displayPanel.getText());

        switch (label) {
            case "x²": value = Math.pow(value, 2); break;
            case "x³": value = Math.pow(value, 3); break;
            case "eˣ": value = Math.exp(value); break;
            case "10ˣ": value = Math.pow(10, value); break;
            case "1/x": value = 1 / value; break;
            case "√x": value = Math.sqrt(value); break;
            case "³√x": value = Math.cbrt(value); break;
            case "ln": value = Math.log(value); break;
            case "log₁₀": value = Math.log10(value); break;
            case "sin": value = Math.sin(Math.toRadians(value)); break;
            case "cos": value = Math.cos(Math.toRadians(value)); break;
            case "tan": value = Math.tan(Math.toRadians(value)); break;
            case "x!": value = factorial(value); break;
            case "e": value = Math.E; break;
            case "π": value = Math.PI; break;
        }
        displayPanel.setText(String.valueOf(value));
    }

    // Método para calcular el factorial
    private double factorial(double n) {
        if (n < 0) return Double.NaN; // No existe factorial para números negativos
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}