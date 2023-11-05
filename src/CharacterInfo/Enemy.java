package CharacterInfo;

public class Enemy extends Characters implements CombatInterface{
    public Enemy(){
        this.setStatus(true);
    }

    @Override
    public void attack(Characters c) {
        if (this.getStatus()){
            c.setCurHealth(c.getCurHealth()-this.getAttackDamage());
        }


    }
}

