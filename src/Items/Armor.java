package Items;

public class Armor<T> extends Item{
    public  Armor(String name,int health){
        super(name);
        this.setHealth(health);
        this.setAttackDamage(0);
    }
}
