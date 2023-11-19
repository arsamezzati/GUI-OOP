package Game;

import Items.ItemTypes;

public class HealthGenericClass implements ItemTypes {
    private int value;
    public HealthGenericClass(int value){
        this.value = value;
    }
    @Override
    public int getValue(){
        return this.value;
    }
}
