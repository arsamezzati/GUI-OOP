package Game;

import CharacterInfo.Enemies.*;
import CharacterInfo.Enemy;
import CharacterInfo.Player;
import GUI.TextAdventure;

import java.util.Random;

public class EnemyGenerator {
    private static final String[] enemies = {"Assassin", "DeathClaw", "Demogorgon", "Goblin", "HuntingTroll", "Shadow"};
    public static Enemy generateEnemy(Player p, TextAdventure game){
        Random random = new Random();
        int num = random.nextInt(enemies.length);
        String enemy = enemies[num];
        return switch (enemy){
            case "Assassin" -> new Assassin(p.getLevel(),game);
            case "DeathClaw" -> new DeathClaw(p.getLevel(),game);
            case "Demogorgon" -> new Demogorgon(p.getLevel(),game);
            case "Goblin" -> new Goblin(p.getLevel(),game);
            case "HuntingTroll" -> new HuntingTroll(p.getLevel(),game);
            case "Shadow" -> new Shadow(p.getLevel(),game);
            default -> throw new IllegalStateException("Unexpected Value: " + enemy);
        };
    }
}
