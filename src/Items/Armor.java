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

    public static Armor handleTreasureEvent(){
        return generateArmor();
    }

    private static Armor generateArmor(){
        Random random = new Random();
        int r = random.nextInt(armorList.length);
        return new Armor(armorList[r],150);

    }
    public void handleEquip(Player p){
        p.setMaxHealth(p.getMaxHealth()+this.getAttribute().getValue());


    }
    public void handleUnequip(Player p,Inventory<Item<?>> inv){
        p.setMaxHealth(p.getMaxHealth()-this.getAttribute().getValue());

        if (p.getCurHealth() > p.getMaxHealth()){
            p.setCurHealth(p.getMaxHealth());
        }

    }
}
