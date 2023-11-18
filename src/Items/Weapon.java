package Items;

import CharacterInfo.Player;
import Game.DamageGenericClass;

import java.util.Random;

public class Weapon extends Item<DamageGenericClass> implements Equippable{
    public Weapon(String name,int attack){
        super(name);

        DamageGenericClass damageValue = new DamageGenericClass(attack);

        this.setAttribute(damageValue);


    }
    private static final String[] weaponList = {"Axe","Dagger","Mace","Polearm","Spear","Sword"};

    public static Weapon handleTreasureEvent(){
        return generateWeapon();
    }
    public void handleEquip(Player p){
        p.setMaxHealth(p.getAttackDamage()+this.getAttribute().getValue());


    }
    public void handleUnequip(Player p,Inventory<Item<?>> inv){
        p.setAttackDamage(p.getAttackDamage()-this.getAttribute().getValue());
    }
    private static Weapon generateWeapon(){
        Random random = new Random();
        int r = random.nextInt(weaponList.length);
        return new Weapon(weaponList[r],25);

    }
    public int dastan(){
        return 5;
    }
}
