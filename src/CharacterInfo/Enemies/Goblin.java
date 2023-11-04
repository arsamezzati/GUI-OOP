package CharacterInfo.Enemies;

import CharacterInfo.*;

public class Goblin extends Enemy {
    public Goblin(int level) {
        super();
        this.setName("Goblin");
        this.setMaxHealth((int) (40*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(2+level);
    }
}
