package Items.Weapones;

import Items.Weapon;

public class Dagger extends Weapon {
    public Dagger(String name, int attack, int level) {
        super(name,attack + level);
    }
}
