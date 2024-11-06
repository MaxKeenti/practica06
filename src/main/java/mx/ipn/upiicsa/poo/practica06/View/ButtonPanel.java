package mx.ipn.upiicsa.poo.practica06.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel {
    private JPanel buttonPanel;
    private DisplayPanel displayPanel;

    public ButtonPanel(DisplayPanel displayPanel) {
        this.displayPanel = displayPanel;
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        JButton[] buttons = createButtons();
        addButtonLayout(buttons, c);
        addListeners(buttons);
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    private JButton[] createButtons() {
        JButton[] buttons = {
            new JButton("0"), new JButton("1"), new JButton("2"), new JButton("3"),
            new JButton("4"), new JButton("5"), new JButton("6"), new JButton("7"),
            new JButton("8"), new JButton("9"), new JButton("+"), new JButton("-"),
            new JButton("*"), new JButton("/"), new JButton("="), new JButton("C"),
            new JButton("."), new JButton("%")
        };
        return buttons;
    }

    private void addButtonLayout(JButton[] buttons, GridBagConstraints c) {
        // Row 0 (Clear, Add, Subtract, Multiply)
        c.gridx = 0; c.gridy = 0; buttonPanel.add(buttons[15], c); // Clear button 'C'
        c.gridx = 1; c.gridy = 0; buttonPanel.add(buttons[10], c); // Add button '+'
        c.gridx = 2; c.gridy = 0; buttonPanel.add(buttons[11], c); // Subtract button '-'
        c.gridx = 3; c.gridy = 0; buttonPanel.add(buttons[12], c); // Multiply button '*'
    
        // Row 1 (7, 8, 9, Divide)
        c.gridx = 0; c.gridy = 1; buttonPanel.add(buttons[7], c);  // Button '7'
        c.gridx = 1; c.gridy = 1; buttonPanel.add(buttons[8], c);  // Button '8'
        c.gridx = 2; c.gridy = 1; buttonPanel.add(buttons[9], c);  // Button '9'
        c.gridx = 3; c.gridy = 1; buttonPanel.add(buttons[13], c); // Divide button '/'
    
        // Row 2 (4, 5, 6, Percentage)
        c.gridx = 0; c.gridy = 2; buttonPanel.add(buttons[4], c);  // Button '4'
        c.gridx = 1; c.gridy = 2; buttonPanel.add(buttons[5], c);  // Button '5'
        c.gridx = 2; c.gridy = 2; buttonPanel.add(buttons[6], c);  // Button '6'
        c.gridx = 3; c.gridy = 2; buttonPanel.add(buttons[17], c); // Percentage button '%'
    
        // Row 3 (1, 2, 3, Equals)
        c.gridx = 0; c.gridy = 3; buttonPanel.add(buttons[1], c);  // Button '1'
        c.gridx = 1; c.gridy = 3; buttonPanel.add(buttons[2], c);  // Button '2'
        c.gridx = 2; c.gridy = 3; buttonPanel.add(buttons[3], c);  // Button '3'
        c.gridx = 3; c.gridy = 3; c.gridheight = 2;
        buttonPanel.add(buttons[14], c);                           // Equals button '='
    
        // Row 4 (0, 0 (spanning 2 columns), Decimal)
        c.gridheight = 1; // Reset gridheight
        c.gridx = 0; c.gridy = 4; c.gridwidth = 2;
        buttonPanel.add(buttons[0], c);  // Button '0' spans two columns
        c.gridx = 2; c.gridy = 4; c.gridwidth = 1;
        buttonPanel.add(buttons[16], c); // Decimal button '.'
    }

    private void addListeners(JButton[] buttons) {
        for (int i = 0; i <= 9; i++) {
            int finalI = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayPanel.updateDisplay(String.valueOf(finalI));
                }
            });
        }
        buttons[15].addActionListener(new ActionListener() { // Clear button
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanel.clearDisplay();
            }
        });
        // Add other listeners as needed for operators like '+', '-', etc.
    }
}