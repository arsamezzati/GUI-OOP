package Game;

import CharacterInfo.Enemies.BloodQueen;
import CharacterInfo.Enemies.LichKing;
import CharacterInfo.Enemies.LordDarkar;
import CharacterInfo.Enemies.Vecna;
import CharacterInfo.Enemy;
import CharacterInfo.Player;

import java.util.Random;

public class BossGenerator {
    private static final String[] bosses = {"BloodQueen", "LichKing", "LordDarkar", "Vecna"};
    public static Enemy generateBoss(Player p){
        Random random = new Random();
        int num = random.nextInt(bosses.length);
        String boss = bosses[num];
        return switch (boss){
          case "BloodQueen" -> new BloodQueen(p.getLevel());
          case "LichKing" -> new LichKing(p.getLevel());
          case "LordDarkar" -> new LordDarkar(p.getLevel());
          case "Vecna" -> new Vecna(p.getLevel());
          default -> throw new IllegalStateException("Unexpected Value: " + boss);
        };
    }
}
