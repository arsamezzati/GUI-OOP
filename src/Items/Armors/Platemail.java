package Items.Armors;

import Items.Armor;

public class Platemail extends Armor {
    public Platemail(String name, int health, int level) {
        super(name,"Health" ,health + level);
    }
}
