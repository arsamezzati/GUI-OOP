package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CharacterInfo.Player;
import Event.*;

public class TextAdventure extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JFrame frame;
    private JPanel explorePanel,eventPanel;
    private JButton exploreButton, quitButton,yesButton,noButton;
    private Player player;
    public void setPlayer(Player p){
        this.player = p;
        characterInfoLabel.setPlayer(p);  // Update the character info label when the player is set
    }
    private CharacterLabel characterInfoLabel;

    public JPanel getExplorePanel(){
        return this.explorePanel;
    }
    public JPanel getEventPanel(){
        return this.eventPanel;
    }



    public TextAdventure() {
        // Setup GUI
        frame = new JFrame();
        textArea = new JTextArea();
        // buttons ( explore )
        exploreButton = new JButton("Explore");
        quitButton = new JButton("Show Stats");
        exploreButton.addActionListener(this);
        quitButton.addActionListener(this);
        // buttons ( event )
        yesButton = new JButton("Yes");
        noButton = new JButton("No");
        yesButton.addActionListener(this);
        noButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(textArea);  // Wrap textArea in a JScrollPane
        frame.add(scrollPane, BorderLayout.CENTER);  // Add scrollPane to frame instead of textArea

        explorePanel = new JPanel();
        explorePanel.add(exploreButton);
        explorePanel.add(quitButton);
        frame.add(explorePanel, BorderLayout.SOUTH);

        eventPanel = new JPanel();
        eventPanel.add(yesButton);
        eventPanel.add(noButton);


        characterInfoLabel = new CharacterLabel(null,null);
        frame.add(characterInfoLabel, BorderLayout.NORTH);

        frame.setLocationRelativeTo(null);


        textArea.append("You find yourself in a room with two doors. Which one do you choose?\n");
    }

    public void showFrame() {
        frame.setVisible(true);
    }

    public void displayMessage(String message){
        this.textArea.append("\n"+message);
        this.textArea.setCaretPosition(this.textArea.getDocument().getLength());
    }
    public void removePanel(JPanel p){
        frame.remove(p);
        frame.revalidate();
        frame.repaint();
    }
    public void addPanel(JPanel p){
        frame.add(p,BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exploreButton) {
            characterInfoLabel.updateCharacterInfo();
            String result = EventGenerator.trigger(this);
            textArea.append("\n"+result);
            this.textArea.setCaretPosition(this.textArea.getDocument().getLength());
        } else if (e.getSource() == quitButton) {
            characterInfoLabel.updateCharacterInfo();
            textArea.append("You chose option 2.\n");
        }else if (e.getSource()==yesButton){

            characterInfoLabel.updateCharacterInfo();
            Fight.start(player);
            removePanel(eventPanel);
            addPanel(explorePanel);
        }else if(e.getSource()==noButton){

            characterInfoLabel.updateCharacterInfo();
            removePanel(eventPanel);
            addPanel(explorePanel);
        }
    }

    public static void main(String[] args) {

        TextAdventure TA = new TextAdventure();
        new NameSelection(TA);




    }
}
