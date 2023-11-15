package Items;

import java.util.Random;

public class Weapon extends Item{
    public Weapon(String name,int attack){
        super(name);
        this.setAttackDamage(attack);
        this.setHealth(0);
    }
    private static final String[] weaponList = {"Axe","Dagger","Mace","Polearm","Spear","Sword"};

    public static Weapon handleTreasureEvent(){
        return generateWeapon();
    }

    private static Weapon generateWeapon(){
        Random random = new Random();
        int r = random.nextInt(weaponList.length);
        return new Weapon(weaponList[r],150);

    }
}
