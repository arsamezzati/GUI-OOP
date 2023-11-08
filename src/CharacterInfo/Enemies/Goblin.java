package CharacterInfo.Enemies;

import CharacterInfo.*;
import GUI.TextAdventure;

public class Goblin extends Enemy {
    public Goblin(int level, TextAdventure game) {
        super(game);
        this.setName("Goblin");
        this.setMaxHealth((int) (40*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(2+level);
    }
}
