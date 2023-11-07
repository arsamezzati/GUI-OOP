package Items.Armors;

import Items.Armor;

public class Plate extends Armor {
    public Plate(String name, int health, int level) {
        super(name, health + level);
    }
}
