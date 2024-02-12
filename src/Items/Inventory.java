package Items;
import GUI.InventoryBox;
import GUI.TextAdventure;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import Items.Armor;
public class Inventory <T extends Item<?>>{
    public Inventory(int capacity, TextAdventure game){
        this.capacity = capacity;
        this.items = new ArrayList<>(capacity);
        invGui = new InventoryBox(game);

    }
    private List<T> items;
    public List<T> getItemsList(){
        return items;
    }
    private int capacity;

    private InventoryBox invGui;
    public InventoryBox getInvGui(){
        return this.invGui;
    }
    public boolean addItem(T item){
        if (items.size() < capacity){
            items.add(item);
            return true;
        }
        return false;
    }

    public List<T> getItems() {
        return items;
    }
}