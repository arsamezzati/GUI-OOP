package Game;

import CharacterInfo.Enemies.*;
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

            return switch (enemyName) {
                case "Assassin" -> new Assassin(p.getLevel(), game);
                case "DeathClaw" -> new DeathClaw(p.getLevel(), game);
                case "Demogorgon" -> new Demogorgon(p.getLevel(), game);
                case "Goblin" -> new Goblin(p.getLevel(), game);
                case "HuntingTroll" -> new HuntingTroll(p.getLevel(), game);
                case "Shadow" -> new Shadow(p.getLevel(), game);
                default -> throw new IllegalStateException("Unexpected Value: " + enemyName);
            };
        } catch (Exception e) {

            System.err.println("Error generating enemy: " + e.getMessage());
            return new Goblin(p.getLevel(), game); // this is the default enemy in case of any issues in our program
        }
    }
}
