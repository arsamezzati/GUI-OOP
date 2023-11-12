package Items.Weapones;

import Items.Weapon;

public class Axe extends Weapon {
    public Axe(String name, int attack, int level) {
        super(name ,attack + level);
    }
}
