package CharacterInfo.Enemies;

import CharacterInfo.*;

public class Vecna extends Enemy {
    public Vecna(int level){
        super();
        this.setName("Vecna");
        this.setMaxHealth((100*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(30+level);
    }
}
