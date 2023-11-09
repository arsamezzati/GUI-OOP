package Items.Armors;

import Items.Armor;

public class Helmet extends Armor {
    public Helmet(String name, int health, int level) {
        super(name,"Health" ,health + level);
    }
}
