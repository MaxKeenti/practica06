package mx.ipn.upiicsa.poo.practica06.View;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel {
    private JTextField display;

    public DisplayPanel() {
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
    }

    // Método para obtener el campo de texto del display
    public JTextField getDisplay() {
        return display;
    }

    // Método para establecer el texto completo en el display
    public void setText(String text) {
        display.setText(text);
    }

    // Método para obtener el texto actual del display
    public String getText() {
        return display.getText();
    }

    // Método para agregar texto al contenido actual del display
    public void appendText(String text) {
        display.setText(display.getText() + text);
    }

    // Método para limpiar el display
    public void clear() {
        display.setText("");
    }
}