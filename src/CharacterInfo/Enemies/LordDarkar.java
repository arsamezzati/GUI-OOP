package CharacterInfo.Enemies;

import CharacterInfo.*;
import GUI.TextAdventure;

public class LordDarkar extends Enemy {
    public LordDarkar(int level, TextAdventure game){
        super(game);
        this.setName("Lord Drakar");
        this.setMaxHealth((100*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(20+level);
    }
}
