package Items;

import CharacterInfo.Player;
import Game.HealthGenericClass;

import java.util.Random;

public class Armor extends Item<HealthGenericClass> implements Equippable{
    public Armor(String name,int health){
        super(name);

        HealthGenericClass healthValue = new HealthGenericClass(health);

        this.setAttribute(healthValue);


    }
    private static final String[] armorList = {"Bronze Armor","Silver Armor","Gold Armor"};

    public static Armor handleTreasureEvent(Player p){
        return generateArmor(p);
    }

    private static Armor generateArmor(Player p){

        Random random = new Random();
        int r = random.nextInt(armorList.length);
        return new Armor(armorList[r],p.getLevel()+35);

    }
    public void handleEquip(Player p){
        p.setMaxHealth(p.getMaxHealth() + this.getAttribute().getValue());
        p.getInventory().getInvGui().removeItemFromInventory(this);
        p.setMaxHealth(p.getMaxHealth()+this.getAttribute().getValue());
        p.setEquippedArmor(this);

    }
    public void handleUnequip(Player p,Inventory<Item<?>> inv){
        p.setMaxHealth(p.getMaxHealth()-p.getEquippedArmor().getAttribute().getValue());

        if (p.getCurHealth() > p.getMaxHealth()){
            p.setCurHealth(p.getMaxHealth());
        }

    }
}