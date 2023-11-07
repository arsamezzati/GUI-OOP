package Items.Armors;

import Items.Armor;

public class Sheild extends Armor {
    public Sheild(String name, int health, int level) {
        super(name, health + level);
    }
}
