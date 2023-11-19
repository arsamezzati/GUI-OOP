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

    public static Weapon handleTreasureEvent(Player p){
        return generateWeapon(p);
    }
    public void handleEquip(Player p){
        p.setAttackDamage(p.getAttackDamage()+this.getAttribute().getValue());
        p.setEquippedWeapon(this);
    }
    public void handleUnequip(Player p,Inventory<Item<?>> inv){
        p.setAttackDamage(p.getAttackDamage() - p.getEquippedWeapon().getAttribute().getValue());
        p.getInventory().getInvGui().removeItemFromInventory(p.getEquippedWeapon());
    }
    private static Weapon generateWeapon(Player p){
        Random random = new Random();
        int r = random.nextInt(weaponList.length);
        return new Weapon(weaponList[r],p.getLevel()+5);

    }
}
