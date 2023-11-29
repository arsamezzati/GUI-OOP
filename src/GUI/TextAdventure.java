package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        characterInfoLabel.setPlayer(p);
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
        lookButton = new JButton("Fight the enemy");
        exitButton = new JButton("Exit");
        lookButton.addActionListener(this);
        exitButton.addActionListener(this);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

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

            this.player.getInventory().getInvGui().turnOnVisibility();

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

        textArea.append("Displaying player stats...\n");

    }

    private void handleYesButton() {
        characterInfoLabel.updateCharacterInfo();
        event.start(player);
        if (event instanceof Dungeon) {
            Dungeon dungeon = (Dungeon) this.event;
            if (!dungeon.getSideEnemyList().isEmpty()) {
                displayMessage("You see a " + dungeon.seeNextEnemyList().getName() + ". Do you want to fight?");
                removePanel(eventPanel);
                addPanel(dungeonPanel);
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


    }


    private Enemy peekNextEnemy() {
        return ((Dungeon) this.event).getSideEnemyList().peek();
    }
    public void handleLevelUp(){
        new LevelUp(this);
    }


    public static void main(String[] args) {

        TextAdventure TA = new TextAdventure();
        new NameSelection(TA);
        Player p = new Player("Mamad",200,30,TA);





    }
}
