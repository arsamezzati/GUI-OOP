package Items;


public abstract class Item<T extends ItemTypes>{
    public Item(String name){
        this.name = name;

    }
    private String name;
    private T attribute;


    public final T getAttribute(){
        return this.attribute;
    }
    public final void setAttribute(T attribute){
        this.attribute = attribute;
    }

    public final String getName(){
        return this.name;
    }
    public final void setName(String name){
        this.name = name;
    }




}