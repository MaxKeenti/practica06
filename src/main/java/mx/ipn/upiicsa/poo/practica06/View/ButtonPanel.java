package mx.ipn.upiicsa.poo.practica06.View;

import javax.swing.*;
import mx.ipn.upiicsa.poo.practica06.Model.*;
import java.awt.*;

public class ButtonPanel {
    private JPanel buttonPanel;
    protected DisplayPanel displayPanel;
    private CalculatorBase currentCalculator;
    private BasicCalculator basicCalculator;
    private ScientificCalculator scientificCalculator;
    private boolean isScientificMode = false;

    public ButtonPanel(DisplayPanel displayPanel) {
        this.displayPanel = displayPanel;
        this.basicCalculator = new BasicCalculator();
        this.scientificCalculator = new ScientificCalculator();
        this.currentCalculator = basicCalculator; // Inicializamos con la calculadora básica

        buttonPanel = new JPanel(new GridBagLayout());
        configureButtonPanel();
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    /**
     * Configura el panel de botones según el modo actual (básico o científico).
     */
    private void configureButtonPanel() {
        buttonPanel.removeAll();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;

        JButton[] buttons = isScientificMode ? createScientificButtons() : createBasicButtons();
        addButtonLayout(buttons, c);
        addListeners(buttons);

        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    /**
     * Crea los botones para la calculadora básica.
     */
    private JButton[] createBasicButtons() {
        return new JButton[] {
                new JButton("C"), new JButton("%"), new JButton("÷"),
                new JButton("7"), new JButton("8"), new JButton("9"), new JButton("×"),
                new JButton("4"), new JButton("5"), new JButton("6"), new JButton("−"),
                new JButton("1"), new JButton("2"), new JButton("3"), new JButton("+"),
                new JButton("M"), new JButton("0"), new JButton("."), new JButton("=")
        };
    }

    /**
     * Crea los botones para la calculadora científica.
     */
    private JButton[] createScientificButtons() {
        return new JButton[] {
                new JButton("C"), new JButton("sin"), new JButton("cos"), new JButton("tan"),
                new JButton("log"), new JButton("sqrt"), new JButton("M"), new JButton("=")
        };
    }

    /**
     * Añade los botones al panel con su disposición.
     */
    private void addButtonLayout(JButton[] buttons, GridBagConstraints c) {
        int row = 0, col = 0;
        for (JButton button : buttons) {
            c.gridx = col;
            c.gridy = row;
            buttonPanel.add(button, c);
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }
    }

    /**
     * Añade los listeners a los botones según el modo actual.
     */
    private void addListeners(JButton[] buttons) {
        // Botón "M" para cambiar entre los modos
        buttons[isScientificMode ? 6 : 15].addActionListener(e -> toggleCalculatorMode());

        // Asigna listeners para los botones según el modo
        if (isScientificMode) {
            addScientificListeners(buttons);
        } else {
            addBasicListeners(buttons);
        }
    }

    /**
     * Alterna entre la calculadora básica y la científica.
     */
    private void toggleCalculatorMode() {
        isScientificMode = !isScientificMode;
        currentCalculator = isScientificMode ? scientificCalculator : basicCalculator;
        configureButtonPanel();
    }

    /**
     * Añade los listeners para los botones de la calculadora básica.
     */
    private void addBasicListeners(JButton[] buttons) {
        // Limpia la pantalla
        buttons[0].addActionListener(e -> displayPanel.clearDisplay());

        // Operadores
        buttons[1].addActionListener(e -> handleOperator("%"));
        buttons[2].addActionListener(e -> handleOperator("/"));
        buttons[7].addActionListener(e -> handleOperator("*"));
        buttons[11].addActionListener(e -> handleOperator("-"));
        buttons[15].addActionListener(e -> handleOperator("+"));

        // Botón "=" para calcular el resultado
        buttons[18].addActionListener(e -> handleEquals());

        // Números y punto decimal
        for (int i = 3; i <= 17; i++) {
            if (i != 7 && i != 11 && i != 15) { // Evitar los botones de operadores
                final int index = i; // Capturamos el valor de i en una variable final
                buttons[index].addActionListener(e -> handleNumber(buttons[index].getText()));
            }
        }
    }

    /**
     * Añade los listeners para los botones de la calculadora científica.
     */
    private void addScientificListeners(JButton[] buttons) {
        buttons[1].addActionListener(e -> handleOperator("sin"));
        buttons[2].addActionListener(e -> handleOperator("cos"));
        buttons[3].addActionListener(e -> handleOperator("tan"));
        buttons[4].addActionListener(e -> handleOperator("log"));
        buttons[5].addActionListener(e -> handleOperator("sqrt"));
        buttons[7].addActionListener(e -> handleEquals());
    }

    /**
     * Maneja la entrada de números.
     */
    private void handleNumber(String number) {
        displayPanel.updateDisplay(displayPanel.getText() + number);
    }

    /**
     * Maneja la entrada de operadores.
     */
    private void handleOperator(String operator) {
        String displayText = displayPanel.getText();
        if (!displayText.isEmpty()) {
            currentCalculator.setOperand(Double.parseDouble(displayText));
            currentCalculator.setOperator(operator);
            displayPanel.clearDisplay();
        }
    }

    /**
     * Calcula el resultado al presionar "=".
     */
    private void handleEquals() {
        String displayText = displayPanel.getText();
        if (!displayText.isEmpty()) {
            try {
                currentCalculator.setOperand(Double.parseDouble(displayText));
                double result = currentCalculator.calculate();
                displayPanel.clearDisplay();
                displayPanel.updateDisplay(String.valueOf(result));
                currentCalculator.reset();
            } catch (ArithmeticException ex) {
                displayPanel.updateDisplay("Error");
            }
        }
    }
}