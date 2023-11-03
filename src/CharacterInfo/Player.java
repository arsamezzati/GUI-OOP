package CharacterInfo;

public class Player extends Characters{
    public Player(String name,int health,int damage){
        this.setName(name);
        this.setAttackDamage(damage);
        this.setMaxHealth(health);
        this.setCurHealth(this.getMaxHealth());
        this.setStatus(true);
        this.setLevel(1);
        this.xp = 0;
        this.maxXp = 50;
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





}
