package Items.Weapones;

import Items.Weapon;

public class Sword extends Weapon {
    public Sword(String name, int attack, int level) {
        super(name,attack + level);
    }
}
