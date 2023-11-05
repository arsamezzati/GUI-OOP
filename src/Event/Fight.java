package Event;
import CharacterInfo.*;

import CharacterInfo.Enemies.Assassin;
import GUI.CharacterLabel;
import GUI.TextAdventure;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fight extends JFrame implements ActionListener {
    private Player player1;
    private Enemy enemy;
    private JFrame fFrame;
    private JPanel fPanel;
    private JButton attButton,spellButton,runButton;
    private JTextArea combatText;
    private CharacterLabel characterInfoLabel;

    public Fight(Player p, Enemy e) {
        this.player1 = p;
        this.enemy = e;


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650,500);
        setLayout(new BorderLayout());


        combatText = new JTextArea();
        add(new JScrollPane(combatText), BorderLayout.CENTER);



        fPanel = new JPanel();
        attButton = new JButton("Attack");
        spellButton = new JButton("Use Spell");
        runButton = new JButton("RUN!");
        attButton.addActionListener(this);
        spellButton.addActionListener(this);
        runButton.addActionListener(this);


        fPanel.add(attButton);
        fPanel.add(spellButton);
        fPanel.add(runButton);
        add(fPanel, BorderLayout.SOUTH);
        characterInfoLabel = new CharacterLabel(this.player1,this.enemy);
        this.add(characterInfoLabel, BorderLayout.NORTH);
        setLocationRelativeTo(null);


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==attButton){
            this.player1.attack(this.enemy);
            this.enemy.attack(this.player1);
            this.player1.checkStatus();
            this.enemy.checkStatus();
            characterInfoLabel.updateCharacterInfo();
            displayMessage("You dealt "+this.player1.getAttackDamage()+" Damage and received "+this.enemy.getAttackDamage()+" damage");
            if (!this.enemy.getStatus()){
                attButton.setEnabled(false);
            }



        }

    }
    public void displayMessage(String message){
        this.combatText.append("\n"+message);
        this.combatText.setCaretPosition(this.combatText.getDocument().getLength());
    }


    public static void trigger(TextAdventure game) {
        game.removePanel(game.getExplorePanel());
        game.addPanel(game.getEventPanel());
        game.displayMessage("you found an enemy!");
    }
    public static void start(Player p){
        Enemy e = new Assassin(1);
        new Fight(p,e);

    }
}
