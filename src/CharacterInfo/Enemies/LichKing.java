package CharacterInfo.Enemies;

import CharacterInfo.*;

public class LichKing extends Enemy {
    public LichKing(int level){
        super();
        this.setName("Lich King");
        this.setMaxHealth((int) (100*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(25+level);
    }
}
