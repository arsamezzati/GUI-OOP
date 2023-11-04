package CharacterInfo.Enemies;

import CharacterInfo.*;

public class LordDarkar extends Enemy {
    public LordDarkar(int level){
        super();
        this.setName("Lord Drakar");
        this.setMaxHealth((100*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(20+level);
    }
}
