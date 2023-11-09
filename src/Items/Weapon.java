package Items;

public class Weapon<T> extends Item<T>{
    public Weapon(String name,T attribute,int attack){
        super(name,attribute);
        this.setAttackDamage(attack);
        this.setHealth(0);
    }
}
