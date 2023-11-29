package CharacterInfo;

import GUI.TextAdventure;

public abstract class Characters {
    private TextAdventure game;
    private int level;
    public int getLevel(){
        return this.level;
    }
    public void setLevel(int amount){
        this.level = amount;
    }
    private int maxHealth;
    // status of the character ( dead = False, alive = True )
    private boolean status;
    public boolean getStatus(){
        return this.status;
    }
    public void setStatus(boolean isAlive){
        this.status = isAlive;
    }
    public void checkStatus(){
        if (this.curHealth <= 0){
            this.status = false;
            this.setCurHealth(0);
        }
    }
    public int getMaxHealth(){
        return this.maxHealth;
    }
    public void setMaxHealth(int amount){
        this.maxHealth = amount;

    }
    private int curHealth;
    public int getCurHealth(){
        return this.curHealth;
    }
    public void setCurHealth(int amount){
        this.curHealth = amount;
        if (this.curHealth == 0){
            this.setStatus(false);
        }
    }
    private int AttackDamage;
    public int getAttackDamage(){
        return this.AttackDamage;
    }
    public void setAttackDamage(int amount){
        this.AttackDamage = amount;
    }
    private String name;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void getInfo(){

        System.out.print("Health: "+this.getCurHealth()+"/"+this.getMaxHealth());
        System.out.print("Damage: " + this.getAttackDamage()+"\n");
    }
    public void setGame(TextAdventure game){
        this.game = game;
    }
    public TextAdventure getGame(){
        return this.game;
    }
    private void receiveDamage(int damage){
        this.curHealth -= damage;
        if (this.curHealth <= 0){
            this.die();
        }
    }
    private void die(){
        if (this.getClass()== Player.class){
            this.setStatus(false);
            System.exit(0);
        } else if (this.getClass() == Enemy.class) {
            this.setStatus(false);
            this.game.displayMessage("you defeated "+this.getName());
            
        }
    }
    public void handleReceiveDamage(int damage){
        this.receiveDamage(damage);
    }
    public void dealDamage(Characters target,int damage){
        target.handleReceiveDamage(damage);
    }
}
