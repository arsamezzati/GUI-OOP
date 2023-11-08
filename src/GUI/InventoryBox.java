package GUI;

import CharacterInfo.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryBox {
    private TextAdventure game;
    private JFrame inventoryFrame;
    private JPanel mainPanel,buttonPanel;
    private JButton closeButton;
    public InventoryBox(TextAdventure game){
        this.game = game;
        inventoryFrame = new JFrame();
        inventoryFrame.setSize(300,300);
        JPanel bp = new JPanel();
        inventoryFrame.add(bp, BorderLayout.SOUTH);
        inventoryFrame.setLocationRelativeTo(null);
        inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventoryFrame.setVisible(true);
        mainPanel = new JPanel();
        closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
