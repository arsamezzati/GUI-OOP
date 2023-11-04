package CharacterInfo.Enemies;

import CharacterInfo.*;

public class DeathClaw extends Enemy {
    public DeathClaw(int level){
        super();
        this.setName("DeathClaw");
        this.setMaxHealth((int) (50*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(3+level);
    }
}
