package Items.Weapones;

import Items.Weapon;

public class Mace extends Weapon {
    public Mace(String name, int attack, int level) {
        super(name,attack + level);
    }
}
