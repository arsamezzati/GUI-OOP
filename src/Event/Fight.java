package Event;
import CharacterInfo.*;

import CharacterInfo.Enemies.Assassin;
import GUI.TextAdventure;
import javax.swing.*;
import java.awt.*;

public class Fight extends JFrame{
    private Player player1;
    private Enemy enemy;
    private JFrame fFrame;
    private JPanel fPanel;
    private JButton attButton,spellButton,runButton;
    private JTextArea combatText;

    public Fight(Player p, Enemy e) {
        this.player1 = p;
        this.enemy = e;

        // Set up the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLayout(new BorderLayout());

        // Set up the combat text area
        combatText = new JTextArea();
        add(new JScrollPane(combatText), BorderLayout.CENTER);

        // Set up the panel with buttons
        fPanel = new JPanel();
        attButton = new JButton("Attack");
        spellButton = new JButton("Use Spell");
        runButton = new JButton("RUN!");

        fPanel.add(attButton);
        fPanel.add(spellButton);
        fPanel.add(runButton);
        add(fPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null);

        // Make this frame visible
        setVisible(true);
    }


    public static String trigger(TextAdventure game) {
        game.removePanel(game.getExplorePanel());
        game.addPanel(game.getEventPanel());
        return "you found an enemy";
    }
    public static void start(Player p){
        Enemy e = new Assassin(1);
        new Fight(p,e);

    }
}
