package CharacterInfo.Enemies;

import CharacterInfo.*;
import GUI.TextAdventure;

public class Vecna extends Enemy {
    public Vecna(int level, TextAdventure game){
        super(game);
        this.setName("Vecna");
        this.setMaxHealth((100*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(30+level);
    }
}
