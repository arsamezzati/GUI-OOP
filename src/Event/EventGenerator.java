package Event;

import GUI.TextAdventure;

import java.util.ArrayList;
import java.util.Random;
public class EventGenerator{
    private static String[] eventPool = {"enemy","dungeon","treasure","fountain"};

    public static String trigger(TextAdventure game) {
        Random r = new Random();
        int rNumber = r.nextInt(eventPool.length);
        String randomEvent = eventPool[rNumber];
        switch (randomEvent){
            case "enemy":
                Fight.trigger(game);
                return "Would you like to fight?";
            case "dungeon":
                Dungeon.trigger(game);
                return "you found a dungeon";
            case "treasure":
                game.setEvent(Treasure.trigger(game));
                return "Would you like to open it?";
            default:
                return "you didnt find anything";

        }

    }
}
