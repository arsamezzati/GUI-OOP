package CharacterInfo;

import GUI.TextAdventure;

public class Enemy extends Characters implements CombatInterface{
    public Enemy(String name,int health, int damage, TextAdventure game, int level){
        super(name,health,damage,game,level);
    }
    private void createEnemyType(String name,int level){

    }
    private void createAssassin (int level){
        this.setName("Assassin");
        this.setMaxHealth((40 * (level * 1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(4 + level);
    }
    private void createBloodQueen(int level){
        this.setName("BloodQueen");
        this.setMaxHealth((int) (100*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(15+level);
    }
    private void createDeathClaw(int level){
        this.setName("DeathClaw");
        this.setMaxHealth((int) (50*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(3+level);
    }
    private void createDemogorgon(int level){
        this.setName("Demogorgon");
        this.setMaxHealth((int) (50*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(7+level);
    }
    private void createGoblin(int level){
        this.setName("Goblin");
        this.setMaxHealth((int) (40*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(2+level);
    }
    private void createHuntingTroll(int level){
        this.setName("HuntingTroll");
        this.setMaxHealth((40*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(6+level);
    }
    private void createLichKing(int level){
        this.setName("LichKing");
        this.setMaxHealth((int) (100*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(25+level);
    }
    private void createLordDarkar(int level){
        this.setName("LordDrakar");
        this.setMaxHealth((100*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(20+level);
    }
    private void createShadow(int level){
        this.setName("Shadow");
        this.setMaxHealth((int) (50*(level)));
        this.setCurHealth((int) (50*(level)));
        this.setLevel(level);
        this.setAttackDamage(5+level);
    }
    private void createVecna(int level){
        this.setName("Vecna");
        this.setMaxHealth((100*(level*1)));
        this.setCurHealth(this.getMaxHealth());
        this.setLevel(level);
        this.setAttackDamage(30+level);
    }

    @Override
    public void attack(Characters c) {
        if (this.getStatus()){
            this.dealDamage(c,this.getAttackDamage());
        }


    }
}

