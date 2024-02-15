package Game;

import CharacterInfo.Enemy;
import CharacterInfo.Player;
import GUI.TextAdventure;
import java.util.Random;

public class EnemyGenerator {
    private static final String[] enemies = {"Assassin", "DeathClaw", "Demogorgon", "Goblin", "HuntingTroll", "Shadow"};

    public static Enemy generateEnemy(Player p, TextAdventure game) {
        try {
            Random random = new Random();
            int num = random.nextInt(enemies.length);
            String enemyName = enemies[num];

            switch (enemyName){
                case "Assassin" :
                    return new Enemy("Assassin",40*(p.getLevel()),4+p.getLevel(),game,p.getLevel());
                case "DeathClaw" :
                    return new Enemy("DeathClaw",50*(p.getLevel()),3+p.getLevel(),game,p.getLevel());
                case "Demogorgon" :
                    return new Enemy("Demogorgon",50*(p.getLevel()),7+p.getLevel(),game,p.getLevel());
                case "Goblin" :
                     return new Enemy("Goblin",40*(p.getLevel()),2+p.getLevel(),game,p.getLevel());
                case "HuntingTroll" :
                    return new Enemy("HuntingTroll",40*(p.getLevel()),6+p.getLevel(),game,p.getLevel());
                case "Shadow" :
                    return new Enemy("Shadow",50*(p.getLevel()),5+ p.getLevel(),game, p.getLevel());
                default:
                    return new Enemy("Goblin", 40 * p.getLevel(), 2 + p.getLevel(), game, p.getLevel());
            }
        } catch (Exception e) {

            System.err.println("Error generating enemy: " + e.getMessage());
            return new Enemy("Goblin",40*(p.getLevel()),2+ p.getLevel(),game,p.getLevel()); // this is the default enemy in case of any issues in our program
        }

    }
}
