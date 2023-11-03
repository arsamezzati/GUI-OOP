package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CharacterInfo.*;
public class NameSelection implements ActionListener {
    private TextAdventure game;
    private JTextField nameSelection;
    private JFrame nameFrame;

    public NameSelection(TextAdventure game) {
        this.game = game;

        nameFrame = new JFrame();  // Fixed: Removed type declaration
        nameFrame.setSize(250, 100);
        nameSelection = new JTextField();  // Fixed: Removed type declaration
        nameSelection.setPreferredSize(new Dimension(100, 25));
        nameFrame.add(nameSelection, BorderLayout.NORTH);

        JPanel bp = new JPanel();
        nameFrame.add(bp, BorderLayout.SOUTH);
        JButton okb = new JButton("Set Name");
        bp.add(okb);  // Removed BorderLayout.CENTER
        okb.addActionListener(this);
        nameFrame.setLocationRelativeTo(null);
        nameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Set default close operation
        nameFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Player p = new Player(this.nameSelection.getText(),200,30);
        game.setPlayer(p);
        game.setVisible(true);
        game.showFrame();
        game.displayMessage(p.getName()+" shows up!");
        nameFrame.dispose();
    }
}
