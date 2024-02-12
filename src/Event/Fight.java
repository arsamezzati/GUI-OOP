package Event;
import CharacterInfo.*;

import GUI.CharacterLabel;
import GUI.TextAdventure;
import Game.EnemyGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fight extends JFrame implements ActionListener,EventInterface {
    private final Player player1;
    private final Enemy enemy;
    private JFrame fFrame;
    private JPanel fPanel;
    private JButton attButton,runButton;
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
        runButton = new JButton("Run Away!");
        attButton.addActionListener(this);
        //spellButton.addActionListener(this);
        runButton.addActionListener(this);


        fPanel.add(attButton);
        //fPanel.add(spellButton);
        fPanel.add(runButton);
        add(fPanel, BorderLayout.SOUTH);
        characterInfoLabel = new CharacterLabel(this.player1,this.enemy);
        this.add(characterInfoLabel, BorderLayout.NORTH);
        setLocationRelativeTo(null);



    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==attButton){
            this.player1.dealDamage(this.enemy,this.player1.getAttackDamage());
            this.enemy.dealDamage(this.player1,this.enemy.getAttackDamage());
            this.player1.checkStatus();
            this.enemy.checkStatus();
            if (!this.enemy.getStatus()){
                this.player1.gainXp(this.enemy);
            }
            characterInfoLabel.updateCharacterInfo();

            displayMessage("You dealt "+this.player1.getAttackDamage()+" Damage and received "+this.enemy.getAttackDamage()+" damage");
            if (!this.enemy.getStatus()){
                attButton.setEnabled(false);
                runButton.setEnabled(false);
                this.displayMessage("You defeated "+this.enemy.getName()+" you gained "+this.enemy.getLevel()*25+" xp");
                this.displayMessage("you can now close this window");
            }



        } else if (e.getSource()==runButton) {
            this.enemy.attack(player1);
            if (this.player1.getCurHealth()>this.player1.getMaxHealth()/2){
                this.dispose();

            } else {
                this.displayMessage("You failed to run away!");
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
        Enemy e = EnemyGenerator.generateEnemy(game.getPlayer(),game);
        game.setEvent(new Fight(game.getPlayer(),e));
    }
    @Override
    public void start(Player p){

        this.setVisible(true);


    }
}
