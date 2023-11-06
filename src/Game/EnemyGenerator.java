package Game;

import CharacterInfo.Enemies.*;
import CharacterInfo.Enemy;
import CharacterInfo.Player;

import java.util.Random;

public class EnemyGenerator {
    private static final String[] enemies = {"Assassin", "DeathClaw", "Demogorgon", "Goblin", "HuntingTroll", "Shadow"};
    public static Enemy generateEnemy(Player p){
        Random random = new Random();
        int num = random.nextInt(enemies.length);
        String enemy = enemies[num];
        return switch (enemy){
            case "Assassin" -> new Assassin(p.getLevel());
            case "DeathClaw" -> new DeathClaw(p.getLevel());
            case "Demogorgon" -> new Demogorgon(p.getLevel());
            case "Goblin" -> new Goblin(p.getLevel());
            case "HuntingTroll" -> new HuntingTroll(p.getLevel());
            case "Shadow" -> new Shadow(p.getLevel());
            default -> throw new IllegalStateException("Unexpected Value: " + enemy);
        };
    }
}
