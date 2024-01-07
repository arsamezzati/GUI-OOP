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

            Enemy enemy = new Enemy(game,enemyName, p.getLevel());
            return enemy;
        } catch (Exception e) {

            System.err.println("Error generating enemy: " + e.getMessage());
            return new Enemy(game,"Goblin", p.getLevel()); // this is the default enemy in case of any issues in our program
        }
    }
}
