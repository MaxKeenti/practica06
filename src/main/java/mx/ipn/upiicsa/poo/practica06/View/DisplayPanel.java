package mx.ipn.upiicsa.poo.practica06.View;

import javax.swing.*;

public class DisplayPanel extends JPanel{
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

    // Método para obtener el texto actual en la pantalla
    public String getText() {
        return display.getText();
    }

    // Método para establecer el texto en la pantalla
    public void setText(String text) {
        display.setText(text);
    }
}