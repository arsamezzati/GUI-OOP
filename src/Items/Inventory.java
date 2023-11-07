package Items;
import java.util.ArrayList;
import java.util.List;
public class Inventory <T extends Item>{
    private List<T> items;
    private int capacity;
    public Inventory(int capacity){
        this.capacity = capacity;
        this.items = new ArrayList<>(capacity);
    }
    public boolean addItem(T item){
        if (items.size() < capacity){
            items.add(item);
            return true;
        }
        return false;
    }
    public boolean removeitem(T item){
        if (items.contains(item)){
            items.remove(item);
            return true;
        }
        return false;
    }

    public List<T> getItems() {
        return items;
    }
    public int getCapacity() {
        return capacity;
    }
}
