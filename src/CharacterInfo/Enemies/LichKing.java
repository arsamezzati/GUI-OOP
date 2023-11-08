package CharacterInfo.Enemies;

import CharacterInfo.*;
import GUI.TextAdventure;

public class LichKing extends Enemy {
    public LichKing(int level, TextAdventure game){
        super(game);
        this.setName("Lich King");
        this.setMaxHealth((int) (100*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(25+level);
    }
}
