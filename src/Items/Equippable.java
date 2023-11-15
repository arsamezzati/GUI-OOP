package Items;
import CharacterInfo.Player;
import Items.Item;
public interface Equippable {
        void handleEquip(Player p);
        void handleUnequip(Player p,Inventory<Item<?>> inv);


}
