package CharacterInfo.Enemies;

import CharacterInfo.*;

public class BloodQueen extends Enemy {
    public BloodQueen(int level){
        super();
        this.setName("Blood Queen");
        this.setMaxHealth((int) (100*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(15+level);
    }
}
