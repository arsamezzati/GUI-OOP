package CharacterInfo.Enemies;

import CharacterInfo.*;
import GUI.TextAdventure;

public class Demogorgon extends Enemy {
    public Demogorgon(int level, TextAdventure game){
        super(game);
        this.setName("Demogorgon");
        this.setMaxHealth((int) (50*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(7+level);
    }
}
