package Items;

public class ItemStats {
    private String name;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    private int attackDamge;
    public int getAttackDamge(){
        return this.attackDamge;
    }
    public void setAttackDamge(int amount){
        this.attackDamge = amount;
    }
    private int health;
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int amount) { this.health = amount; }
}
