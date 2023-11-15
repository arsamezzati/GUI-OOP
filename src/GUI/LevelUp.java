// File: LevelUp.java
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelUp {
    private final TextAdventure game;
    private JFrame frame;
    private JPanel mainPanel, bottomPanel;
    private JRadioButton optionButton1, optionButton2;
    private ButtonGroup group;
    private JButton okButton;
    private JTextArea textArea;

    public LevelUp(TextAdventure game) {
        this.game = game;
        initializeComponents();
        setUpFrame();
    }

    private void initializeComponents() {
        // Initialize your components here
        frame = new JFrame("Level Up");
        mainPanel = new JPanel(new GridLayout(0, 1)); // One column, multiple rows
        textArea = new JTextArea("Choose an attribute to level up:");
        textArea.setEditable(false);
        bottomPanel = new JPanel();

        // Create the radio buttons for the level up options
        optionButton1 = new JRadioButton("Increase Health");
        optionButton2 = new JRadioButton("Increase Attack");

        // Group the radio buttons to ensure only one can be selected at a time
        group = new ButtonGroup();
        group.add(optionButton1);
        group.add(optionButton2);

        // Adding components to mainPanel
        mainPanel.add(textArea);
        mainPanel.add(optionButton1);
        mainPanel.add(optionButton2);

        // Create the button for applying level up choices
        okButton = new JButton("Apply Level Up");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyLevelUpChoice();
            }
        });

        // Add the OK button to the bottom panel
        bottomPanel.add(okButton);
    }

    private void setUpFrame() {
        // Add panels to the frame
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Set default close operation and frame visibility
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack(); // Adjusts window to fit components
        frame.setLocationRelativeTo(null); // Center window
        frame.setVisible(true);
    }

    private void applyLevelUpChoice() {
        // Check which option is selected and apply the level up accordingly
        if (optionButton1.isSelected()) {
            applyChangesForOption1();
        } else if (optionButton2.isSelected()) {
            applyChangesForOption2();
        }
        // Dispose of the frame after applying changes
        frame.dispose();
    }

    private void applyChangesForOption1() {

        game.getPlayer().increaseHealth();
        game.displayMessage("Health increased!");
    }

    private void applyChangesForOption2() {

        game.getPlayer().increaseAttack();
        game.displayMessage("Attack increased!");
    }
}
