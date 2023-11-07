package Items;

import javax.swing.*;

public class Item <T>{
    private String name;
    private T attribute;
    public Item(String name, T attribute){
        this.name = name;
        this.attribute = attribute;
    }
    public String getName(){
        return this.name;
    }
}
