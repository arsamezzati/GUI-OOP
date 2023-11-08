package CharacterInfo.Enemies;
import CharacterInfo.*;
import GUI.TextAdventure;
import org.w3c.dom.Text;

public class Assassin extends Enemy {
    public Assassin(int level, TextAdventure game) {
        super(game);

        this.setName("Assassin");
        this.setMaxHealth((40 * (level * 1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(4 + level);
    }
}
