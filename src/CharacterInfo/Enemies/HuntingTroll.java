package CharacterInfo.Enemies;

import CharacterInfo.*;

public class HuntingTroll extends Enemy {
    public HuntingTroll(int level){
        super();
        this.setName("Hunting Troll");
        this.setMaxHealth((40*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(6+level);
    }
}
