package Items;

public class Armor extends ItemStats{
    public  Armor(String name,int health){
        this.setName(name);
        this.setHealth(health);
        this.setAttackDamge(0);
    }
}
