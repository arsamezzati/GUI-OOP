package Items;

import java.util.Random;

public class Armor extends Item{
    public  Armor(String name,int health){
        super(name);
        this.setHealth(health);
        this.setAttackDamage(0);
    }
    private static final String[] armorList = {"Bronze Armor","Silver Armor","Gold Armor"};

    public Armor handleTreasureEvent(){
        return generateArmor();
    }

    private Armor generateArmor(){
        Random random = new Random();
        int r = random.nextInt(armorList.length);
        return new Armor(armorList[r],150);

    }
}
