package CharacterInfo;

import GUI.TextAdventure;

public class Enemy extends Characters implements CombatInterface{
    public Enemy(String name,int health, int damage, TextAdventure game, int level){
        super(name,health,damage,game,level);
    }
    @Override
    public void attack(Characters c) {
        if (this.getStatus()){
            this.dealDamage(c,this.getAttackDamage());
        }


    }
}

