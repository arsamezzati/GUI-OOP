package CharacterInfo;

public class Characters {
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
}
