package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharacterInfo.Enemy;
import CharacterInfo.Player;
import Event.*;

public class TextAdventure extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JFrame frame;
    private JPanel explorePanel,eventPanel,dungeonPanel;
    private JButton exploreButton, quitButton,yesButton,noButton,lookButton,exitButton;
    private Player player;
    public Player getPlayer(){
        return this.player;
    }
    private EventInterface event;
    public void setEvent(EventInterface event){
        this.event = event;

    }
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
        quitButton = new JButton("Inventory");
        exploreButton.addActionListener(this);
        quitButton.addActionListener(this);
        // buttons ( event )
        yesButton = new JButton("Yes");
        noButton = new JButton("No");
        yesButton.addActionListener(this);
        noButton.addActionListener(this);
        // buttons ( dungeon )
        lookButton = new JButton("Look Around");
        exitButton = new JButton("Exit");
        lookButton.addActionListener(this);
        exitButton.addActionListener(this);


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

        dungeonPanel = new JPanel();
        dungeonPanel.add(lookButton);
        dungeonPanel.add(exitButton);





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
        Object source = e.getSource();

        if (source == exploreButton) {
            characterInfoLabel.updateCharacterInfo();
            String result = EventGenerator.trigger(this);
            textArea.append("\n" + result);
        } else if (source == quitButton) {
            characterInfoLabel.updateCharacterInfo();
            // Assuming the quitButton is meant to show player stats
            displayPlayerStats();
        } else if (source == yesButton) {
            handleYesButton();
        } else if (source == noButton) {
            characterInfoLabel.updateCharacterInfo();
            removePanel(eventPanel);
            addPanel(explorePanel);
        } else if (source == lookButton) {
            handleLookButton();
        } else if (source == exitButton) {
            handleExitButton();
        }
    }

    private void displayPlayerStats() {
        // Display player stats here
        textArea.append("Displaying player stats...\n");
        // Append player stats to text area
    }

    private void handleYesButton() {
        characterInfoLabel.updateCharacterInfo();
        event.start(player);
        if (event instanceof Dungeon) {
            Dungeon dungeon = (Dungeon) this.event;
            if (!dungeon.getSideEnemyList().isEmpty()) {
                displayMessage("You see a " + dungeon.seeNextEnemyList().getName() + ". Do you want to fight?");
                removePanel(eventPanel);
                addPanel(dungeonPanel); // Switch to dungeon panel with fight options
                characterInfoLabel.updateCharacterInfo();
                repaint();
            } else {
                displayMessage("The dungeon is empty. You can look around or exit.");
            }
        } else {
            removePanel(eventPanel);
            addPanel(explorePanel);
            repaint();
        }
    }

    private void handleLookButton() {
        Dungeon dungeon = (Dungeon) this.event;
        if (!dungeon.getSideEnemyList().isEmpty()) {
            Enemy nextEnemy = dungeon.seeNextEnemyList();
            characterInfoLabel.updateCharacterInfo();
            startFightWithEnemy(nextEnemy);
            repaint();
        } else {
            displayMessage("There are no more enemies to fight.");
        }
    }

    private void handleExitButton() {
        displayMessage("You have exited the dungeon.");
        removePanel(dungeonPanel);
        addPanel(explorePanel);
        repaint();
    }

    private void startFightWithEnemy(Enemy enemy) {
        displayMessage("You engage in battle with " + enemy.getName() + "!");
        enemy = ((Dungeon) (this.event)).getNextEnemyList();
        Fight f = new Fight(this.player,enemy);
        f.start(this.player);

        // Here you would call the logic to handle the fight.
        // This could be a method in this class or in another class that processes the fight.
    }

    // Assuming Dungeon class has this method
// If not, it should be added to return the next enemy without removing it from the queue
    private Enemy peekNextEnemy() {
        return ((Dungeon) this.event).getSideEnemyList().peek();
    }
    public void handleLevelUp(){
        new LevelUp(this);
    }


    public static void main(String[] args) {

        TextAdventure TA = new TextAdventure();
        new NameSelection(TA);




    }
}
