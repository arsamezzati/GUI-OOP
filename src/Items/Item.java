package Items;


public class Item  {

    private String name;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    private int attackDamage;
    public int getAttackDamage(){
        return this.attackDamage;
    }
    public void setAttackDamage(int amount){
        this.attackDamage = amount;
    }
    private int health;
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int amount) { this.health = amount; }
    public Item(String name){
        this.name = name;

    }

}
