package Event;

import CharacterInfo.Enemies.Assassin;
import CharacterInfo.Enemy;

import java.util.Random;

public interface EventInterface {
    static final String[] enemies = {"assassin","goblin"};
    public static Enemy enemyFactory(int level){
        Random r = new Random();
        int num = r.nextInt(enemies.length);
        String enemy = enemies[num];
        switch (enemy){
            case "assassin": return new Assassin(level);
            default:return null;
        }
    }

}
