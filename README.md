# The Project

## Table of Contents
1.[What is the Project for?](#what-is-the-project-for?).
2.[What is the Project?](#what-is-the-project?).
3.[What we used?](#what=we-used?).
4.[Polymorphism](#polymorphism).
    4.1.[Parametric Polymorphism](#parametric-polymorphism).
    4.2.[Inclusion ( Overriding )](#inclusion-(overriding)).
    4.3.[Overloading](#overloading).
5.[Inheritance](#inheritance).
6.[Information Hiding](#information-hiding).

### What is the Project for?
This is a school project by Arsam Ezzati and Hila Kargar Masouleh for OOP course taught by Professor Distefano in University of Messina.
## What is the project?
In this Project we tried to implement all of OOP design principles through Java that we were taught by our Professor into the project and ship it as a whole.
Our Project is a Text based dungeon crawler that has some RPG aspects to it like level ups, different equipment and more.
### What we used?
we mostly used vanilla Java and Swing for the GUI which is pretty basic
## Polymorphism
Polymorphism is a core concept in OOP which refers to the ability of a class or interface to represent multiple forms or types which leads to a cleaner
and a more maintainable code.
in Java Polymorphism is achieved through inclusion( method overriding ), method overloading and Parametric polymorphism.
### Parametric Polymorphism
Parametric polymorphism is about using Generic types <T> in classes that can hold all types or only some specific types for example <T extends Numbers> can only hold
Number types like Integer or Float.
This will help the reusablity of the code. 
We used Parametric Polymorphism as the core of our Items/Inventory part of the game.
```java
public class Inventory <T extends Item<ItemTypes>> {
    private List<T> items;
    // Other class details
}
```
our inventory has a variable called List<T>, and T extends Item<ItemTypes> which means it'll only accept subclasses of Item in our case ( because Item<T> itself has no objects in our code ).
```java
public class Item<T extends ItemTypes>{

    private T attribute;
```
In this section we used <T extends ItemTypes> which means that attribute would only accepts types that implement the ItemType interface meaning they all have a getValue method.
this will clarify the type of the item ( weapon/armor ).
the value of attribute is damage if the item is a weapon and health if the item is an armor.
### Inclusion ( Overriding )
Polymorphism by inclusion is when a class can be treated as an object of another class or type, which is achieved when the class in a subclass of a parentclass or when it implements an interface.
this can achieve multiple purposes such as having the same method doing different things in different classes.
```java
public class Dungeon implements EventInterface {
@Override
    public void start(Player p){
        this.randomGen(this.player);


    }
}
public class Treasure implements EventInterface{
@Override
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
public class Fight extends JFrame implements ActionListener,EventInterface {
@Override
    public void start(Player p){

        this.setVisible(true);


    }
}
```
In this example, EventInterface is an interface and all events implement it, they all have the start method but they do different things.
this will make it possible for the variable event to hold all of them in TextAdventure class ( which is the main class ).
this variable sets the current event of the game.
```java
private EventInterface event;
```
### Overloading
This type of polymorphism make it possible to have multiple of the same method which takes different amount or type of parameters.
```java
public class InventoryBox implements ActionListener, ItemListener {
    private void handleEquippingItems() {
        ArrayList<Equippable> selectedItems = getSelectedItems();
        Player player = game.getPlayer(); // Assuming this is how you get the player instance

        if (selectedItems.size() == 1) {
            player.equipItem(selectedItems.get(0));
            removeItemFromInventory(selectedItems.get(0));
        } else if (selectedItems.size() == 2) {
            player.equipItem(selectedItems.get(0), selectedItems.get(1));
            removeItemFromInventory(selectedItems.get(0));
            removeItemFromInventory(selectedItems.get(1));
        }
    }
}
```
In this example, If the player chooses to equip only 1 item, the 1-parameter method is called and if they decided to equip 2 items ( which is the maximum ), it uses the 2-parameter version of the method.
```java
public void equipItem(Equippable item){
        item.handleEquip(this);
    }
    public void equipItem(Equippable firstItem, Equippable secondItem){
        firstItem.handleEquip(this);
        secondItem.handleEquip(this);
    }
```
## Inheritance
Inheritance is a basic functionality of OOP, making it possible for classes to have children known as Subclasses or Childclasses and Parentclasses or Superclasses.
It also enables subclasses to inherit methods and attributes, while having their own unique ones. This leads to better reusability and having a class hierarchy, enables subclasses to inherit
the common features of the parent class and have their own new ones.
This [Class Diagram](https://drive.google.com/file/d/1pREhIImt_T_pgyoBpxXL3ohMbrbgai41/view?usp=sharing) shows most of the classes and inheritances in our code.
Dotted lines mean the classes implement an interface and normal lines show inheritance.

## Abstract Data Type
an ADT is a type of Data that can only be accessed through a specified interface, helping understandability of the user.
2 key aspects of ADT is the use of Information hiding and Encapsulation.
### Encapsulation
Encapsulation is a fundamental concept in OOP. It refers to the bundling of data with the methods that operate on that data. Encapsulation restricts direct access to some of an object's attributes and methods, which is a way of preventing interference and misuse of the methods and data.
In our code we used Encapsulation in every class and one of the examples is shown below.
```java
public class Characters {
    private TextAdventure game;
    private int level;
    public int getLevel(){
        return this.level;
    }
    public void setLevel(int amount){
        this.level = amount;
    }
}
```
### Information Hiding
Information hiding is closely related to encapsulation, but it focuses more on hiding the internal state and functionalities of an object, so that the implementation details are not exposed to the outside. This concept is used in modular programming, as it allows changes to be made to the internal implementation of a class without affecting other parts of a program.
Here is some examples of Information Hiding in our code.
```java
public void handleEquip(Player p){
        p.setAttackDamage(p.getAttackDamage()+this.getAttribute().getValue());
        p.setEquippedWeapon(this);
    }
    public void handleUnequip(Player p,Inventory<Item<?>> inv){
        p.setAttackDamage(p.getAttackDamage() - p.getEquippedWeapon().getAttribute().getValue());
        p.getInventory().getInvGui().removeItemFromInventory(p.getEquippedWeapon());
    }

```
In this example, when the player clicks on the Equip button, it calls the handleEquip method which will set the equipped item of the player and changes the related attributes according to the Item.
```java
public class Weapon extends Item<DamageGenericClass> implements Equippable{
    public static Weapon handleTreasureEvent(Player p){
            return generateWeapon(p);
        }
    private static Weapon generateWeapon(Player p){
            Random random = new Random();
            int r = random.nextInt(weaponList.length);
            return new Weapon(weaponList[r],p.getLevel()+5);
    
        }
}
```
In this example, when a treasure is openned in the game, the handleTreasureEvent method is called which will then call the private generateWeapon method.
in this example the information hiding is completely internal, the private method wont be exposed to other classes and instead we use the handler to call it.





