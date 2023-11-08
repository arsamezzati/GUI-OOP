package CharacterInfo;

import GUI.TextAdventure;

public class Enemy extends Characters implements CombatInterface{
    public Enemy(TextAdventure game){
        this.setStatus(true);
        this.setGame(game);
    }

    @Override
    public void attack(Characters c) {
        if (this.getStatus()){
            this.dealDamage(c,this.getAttackDamage());
        }


    }
}

