package Event;

import CharacterInfo.Player;
import GUI.TextAdventure;

public class Treasure implements EventInterface{
    public Treasure(TextAdventure game){
        this.game = game;
    }

    private TextAdventure game;

    public void trigger(){

    }
    public void start(Player p){

    }
}