package Items.Weapones;

import Items.Weapon;

public class Spear extends Weapon {
    public Spear(String name, int attack, int level) {
        super(name, attack + level);
    }
}
