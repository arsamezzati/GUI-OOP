package CharacterInfo.Enemies;
import CharacterInfo.*;
public class Assassin extends Enemy {
    public Assassin(int level) {
        super();

        this.setName("Assassin");
        this.setMaxHealth((40 * (level * 1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(4 + level);
    }
}
