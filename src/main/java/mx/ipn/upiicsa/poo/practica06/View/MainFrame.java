package mx.ipn.upiicsa.poo.practica06.View;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame frame;
    private DisplayPanel displayPanel;
    private ButtonPanel buttonPanel;

    public MainFrame() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(200, 400));
        
        displayPanel = new DisplayPanel();
        buttonPanel = new ButtonPanel(displayPanel);

        frame.getContentPane().add(displayPanel.getDisplay(), BorderLayout.PAGE_START);
        frame.getContentPane().add(buttonPanel.getButtonPanel(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}