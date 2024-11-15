package mx.ipn.upiicsa.poo.practica06.View;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame frame;
    private DisplayPanel displayPanel;
    private ButtonPanel basicButtonPanel;
    private ScientificButtonPanel scientificButtonPanel;
    private boolean isScientificMode = false;

    public MainFrame() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(300, 500));

        displayPanel = new DisplayPanel();
        basicButtonPanel = new ButtonPanel(displayPanel, this);
        scientificButtonPanel = new ScientificButtonPanel(displayPanel, this);

        frame.getContentPane().add(displayPanel.getDisplay(), BorderLayout.PAGE_START);
        frame.getContentPane().add(basicButtonPanel.getButtonPanel(), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // Método para alternar entre calculadora básica y científica
    public void toggleCalculatorMode() {
        frame.getContentPane().removeAll();

        if (isScientificMode) {
            // Volver al modo básico
            frame.getContentPane().add(displayPanel.getDisplay(), BorderLayout.PAGE_START);
            frame.getContentPane().add(basicButtonPanel.getButtonPanel(), BorderLayout.CENTER);
        } else {
            // Cambiar al modo científico
            frame.getContentPane().add(displayPanel.getDisplay(), BorderLayout.PAGE_START);
            frame.getContentPane().add(scientificButtonPanel.getButtonPanel(), BorderLayout.CENTER);
        }

        isScientificMode = !isScientificMode;
        frame.revalidate();
        frame.repaint();
    }

    public JFrame getFrame() {
        return frame;
    }

    // Getter para isScientificMode
    public boolean isScientificMode() {
        return isScientificMode;
    }
}