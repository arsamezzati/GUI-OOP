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

        frame = new JFrame("Level Up");
        mainPanel = new JPanel(new GridLayout(0, 1));
        textArea = new JTextArea("Choose an attribute to level up:");
        textArea.setEditable(false);
        bottomPanel = new JPanel();


        optionButton1 = new JRadioButton("Increase Health");
        optionButton2 = new JRadioButton("Increase Attack");


        group = new ButtonGroup();
        group.add(optionButton1);
        group.add(optionButton2);


        mainPanel.add(textArea);
        mainPanel.add(optionButton1);
        mainPanel.add(optionButton2);


        okButton = new JButton("Apply Level Up");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyLevelUpChoice();
            }
        });


        bottomPanel.add(okButton);
    }

    private void setUpFrame() {

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void applyLevelUpChoice() {

        if (optionButton1.isSelected()) {
            applyChangesForOption1();
        } else if (optionButton2.isSelected()) {
            applyChangesForOption2();
        }

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
