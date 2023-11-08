package CharacterInfo.Enemies;

import CharacterInfo.*;
import GUI.TextAdventure;

public class DeathClaw extends Enemy {
    public DeathClaw(int level, TextAdventure game){
        super(game);
        this.setName("DeathClaw");
        this.setMaxHealth((int) (50*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(3+level);
    }
}
