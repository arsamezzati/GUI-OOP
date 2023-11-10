package Items.Weapones;

import Items.Weapon;

public class Polearm extends Weapon {
    public Polearm(String name, int attack, int level) {
        super(name, "Damage",attack + level);
    }
}
