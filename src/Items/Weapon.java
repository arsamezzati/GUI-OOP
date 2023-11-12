package Items;

public class Weapon extends Item{
    public Weapon(String name,int attack){
        super(name);
        this.setAttackDamage(attack);
        this.setHealth(0);
    }
}
