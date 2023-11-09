package Items;

public class Armor<T> extends Item<T>{
    public  Armor(String name,T attribute,int health){
        super(name,attribute);
        this.setHealth(health);
        this.setAttackDamage(0);
    }
}
