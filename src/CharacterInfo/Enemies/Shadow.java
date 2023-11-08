package CharacterInfo.Enemies;

import CharacterInfo.*;
import GUI.TextAdventure;
import org.w3c.dom.Text;

public class Shadow extends Enemy {
    public Shadow(int level, TextAdventure game){
        super(game);
        this.setName("Shadow");
        this.setMaxHealth((int) (50*(level)));
        this.setCurHealth((int) (50*(level)));
        this.setLevel(level);
        this.setAttackDamage(5+level);
    }
}
