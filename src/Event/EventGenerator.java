package Event;

import GUI.TextAdventure;

import java.util.ArrayList;
import java.util.Random;
public class EventGenerator{
    private static String[] eventPool = {"enemy","dungeon","treasure"};

    public static String trigger(TextAdventure game) {
        Random r = new Random();
        int rNumber = r.nextInt(eventPool.length);
        String randomEvent = eventPool[rNumber];
        switch (randomEvent){
            case "enemy":
                Fight.trigger(game);
                return "Would you like to fight?";
            case "dungeon":return "you found a dungeon";
            case "treasure": return "you found big ol' treasure";
            default:
                return "you didnt find anything";

        }

    }
}
