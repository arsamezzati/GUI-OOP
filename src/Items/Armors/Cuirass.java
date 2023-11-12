package Items.Armors;

import Items.Armor;

public class Cuirass extends Armor {
    public Cuirass(String name, int health, int level) {
        super(name,health + level);
    }
}
