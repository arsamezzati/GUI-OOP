package Items;


public abstract class Item<T extends ItemTypes>{

    private String name;
    private T attribute;


    public T getAttribute(){
        return this.attribute;
    }
    public void setAttribute(T attribute){
        this.attribute = attribute;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }


    public Item(String name){
        this.name = name;

    }

}