package Event;

import CharacterInfo.Player;
import GUI.TextAdventure;
import Items.Armor;
import Items.Item;
import Items.Weapon;

import java.util.Random;

public class Treasure implements EventInterface{
    public Treasure(TextAdventure game){
        this.game = game;
    }

    private final TextAdventure game;

    public static Treasure trigger(TextAdventure game){
        Treasure treasure = new Treasure(game);
        game.displayMessage("You found a treasure!");
        game.removePanel(game.getExplorePanel());
        game.addPanel(game.getEventPanel());
        game.repaint();
        return treasure;
    }
    public void start(Player p){
        Random random = new Random();
        int r = random.nextInt(2);
        Item<?> newItem;
        if (r == 0){
            newItem = Armor.handleTreasureEvent(p);
            System.out.println(newItem.getAttribute().getClass().getName());

        }else{
           newItem = Weapon.handleTreasureEvent(p);
           System.out.println(newItem.getAttribute().getClass().getName());


        }
        game.getPlayer().getInventory().getInvGui().handleNewItem(newItem);
        game.displayMessage("You found one "+newItem.getName());
        game.getPlayer().getInventory().addItem(newItem);

    }
}