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
        // Layout configuration based on grid coordinates
        // (similarly as the original layout code but simplified here for brevity)
        // Example for adding some buttons:
        c.gridx = 0; c.gridy = 0; buttonPanel.add(buttons[15], c); // Clear button 'C'
        c.gridx = 1; c.gridy = 0; buttonPanel.add(buttons[10], c); // Add button '+'
        // ... continue this pattern for other buttons
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