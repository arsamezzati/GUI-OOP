package GUI;

import CharacterInfo.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryBox implements ActionListener{
    private TextAdventure game;
    private JFrame inventoryFrame;
    private JPanel mainPanel,buttonPanel;
    private JButton closeButton;
    public InventoryBox(TextAdventure game){
        this.game = game;
        inventoryFrame = new JFrame("Inventory");
        inventoryFrame.setSize(300,300);
        JPanel bp = new JPanel();
        inventoryFrame.add(bp, BorderLayout.SOUTH);
        inventoryFrame.setLocationRelativeTo(null);
        inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonPanel = new JPanel();
        inventoryFrame.add(buttonPanel,BorderLayout.SOUTH);

        mainPanel = new JPanel();
        closeButton = new JButton("Close");
        buttonPanel.add(closeButton);


        closeButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==closeButton){
            inventoryFrame.setVisible(false);
        }

    }
    public void turnOnVisibility(){
        inventoryFrame.setVisible(true);
    }
}
