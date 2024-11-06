package mx.ipn.upiicsa.poo.practica06.View;

import javax.swing.*;

public class DisplayPanel {
    private JTextField display;

    public DisplayPanel() {
        display = new JTextField("");
        display.setEditable(false);
    }

    public JTextField getDisplay() {
        return display;
    }

    public void updateDisplay(String text) {
        display.setText(display.getText() + text);
    }

    public void clearDisplay() {
        display.setText("");
    }
}