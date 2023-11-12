package CharacterInfo;

import GUI.TextAdventure;
import Items.Inventory;
import Items.Item;

public class Player extends Characters implements CombatInterface{
    public Player(String name, int health, int damage, TextAdventure game){
        this.setName(name);
        this.setAttackDamage(damage);
        this.setMaxHealth(health);
        this.setCurHealth(this.getMaxHealth());
        this.setStatus(true);
        this.setLevel(1);
        this.xp = 0;
        this.maxXp = 50;
        this.setGame(game);
        this.inventory = new Inventory<Item>(50,game);

    }
    private final Inventory<Item> inventory;
    public Inventory<Item> getInventory(){
        return this.inventory;
    }
    private int xp;
    private int maxXp;
    public int getMaxXp(){
        return this.maxXp;
    }
    public void setMaxXp(int amount){
        this.maxXp = amount;
    }
    public int getXp(){
        return this.xp;
    }
    public void setXp(int enemyLevel){
        this.xp = this.xp + (enemyLevel*25);
    }
    public void gainXp(Enemy e){
        if(!e.getStatus()){
            this.setXp(e.getLevel());
            if (this.maxXp <= this.xp) {
                this.xp = 0;
                this.setLevel(this.getLevel()+1);
                this.getGame().handleLevelUp();

            }

        }
    }
    public void increaseHealth(){
        this.setMaxHealth(this.getMaxHealth()+15);
        this.setCurHealth(this.getMaxHealth());
    }
    public void increaseAttack(){
        this.setAttackDamage(this.getAttackDamage()+5);
        this.setCurHealth(this.getMaxHealth());
    }
    @Override
    public void attack(Characters c) {
        if (this.getStatus()) {
            this.dealDamage(c,this.getAttackDamage());
        }
    }





}
