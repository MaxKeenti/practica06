package mx.ipn.upiicsa.poo.practica06.View;

import javax.swing.*;

import mx.ipn.upiicsa.poo.practica06.Model.BasicCalculator;
import mx.ipn.upiicsa.poo.practica06.Model.CalculatorBase;
import mx.ipn.upiicsa.poo.practica06.Model.ScientificCalculator;

import java.awt.*;

public class ButtonPanel {
    private JPanel buttonPanel;
    private JButton[] buttons;
    protected DisplayPanel displayPanel;
    protected MainFrame frame;

    // Constructor
    public ButtonPanel(DisplayPanel displayPanel, MainFrame mainFrame) {
        this.displayPanel = displayPanel;
        this.frame = mainFrame; // Asigna el parámetro mainFrame al atributo frame
        initializeButtonPanel();
        addListeners();
    }

    // Método para inicializar el panel de botones
    private void initializeButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        // Crear botones para la calculadora básica
        String[] buttonLabels = {
                "C", "%", "÷", "",
                "7", "8", "9", "×",
                "4", "5", "6", "−",
                "1", "2", "3", "+",
                "M", "0", ".", "="
        };

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            if (!buttonLabels[i].isEmpty()) {
                buttonPanel.add(buttons[i]);
            } else {
                buttonPanel.add(new JLabel()); // Espacio vacío para alinear los botones
            }
        }
    }

    // Método para añadir listeners a los botones
    private void addListeners() {
        // Botón de limpiar "C"
        buttons[0].addActionListener(e -> displayPanel.setText(""));

        // Botón de porcentaje "%"
        buttons[1].addActionListener(e -> handleOperator("%"));

        // Botón de división "÷"
        buttons[2].addActionListener(e -> handleOperator("/"));

        // Botones numéricos y el punto decimal
        for (int i = 4; i <= 17; i++) {
            if (i != 7 && i != 11 && i != 15) { // Evitar los botones de operadores
                int index = i; // Necesario para la variable final en expresiones lambda
                buttons[i].addActionListener(e -> handleNumber(buttons[index].getText()));
            }
        }

        // Botones de operadores matemáticos
        buttons[7].addActionListener(e -> handleOperator("*")); // Multiplicación
        buttons[11].addActionListener(e -> handleOperator("-")); // Resta
        buttons[15].addActionListener(e -> handleOperator("+")); // Suma

        // Botón de igual "="
        buttons[19].addActionListener(e -> calculateResult());

        // Botón para alternar modo "M"
        buttons[16].addActionListener(e -> toggleCalculatorMode());
    }

    // Método para manejar números y el punto decimal
    private void handleNumber(String value) {
        String currentText = displayPanel.getText();
        if (currentText.equals("0")) {
            displayPanel.setText(value);
        } else {
            displayPanel.setText(currentText + value);
        }
    }

    // Método para manejar operadores
    private void handleOperator(String operator) {
        displayPanel.appendText(" " + operator + " ");
    }

    // Método para calcular el resultado de la expresión
    private void calculateResult() {
        String expression = displayPanel.getText();

        // Usa la calculadora básica o científica dependiendo del modo actual
        CalculatorBase calculator = frame.isScientificMode() ? new ScientificCalculator() : new BasicCalculator();

        try {
            double result = calculator.calculate(expression);
            displayPanel.setText(String.valueOf(result));
        } catch (ArithmeticException e) {
            displayPanel.setText("Error");
        }
    }

    // Alternar entre calculadora básica y científica
    private void toggleCalculatorMode() {
        frame.toggleCalculatorMode(); // Llamada al MainFrame para alternar
    }

    // Método para obtener el panel de botones
    public JPanel getButtonPanel() {
        return buttonPanel;
    }
}