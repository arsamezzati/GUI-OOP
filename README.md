# The Project

## Table of Contents
1.[What is the Project for?](#what-is-the-project-for?).  
2.[What is the Project?](#what-is-the-project?).  
3.[What we used?](#what=we-used?).  
4.[Polymorphism](#polymorphism).  
    4.1.[Parametric Polymorphism](#parametric-polymorphism).  
    4.2.[Inclusion ( Overriding )](#inclusion-(subtyping)).  
    4.3.[Overloading](#overloading).  
5.[Inheritance](#inheritance).  
6.[Abstract Data Type](#abstract-data-type).  
    6.1.[Encapsulation](#encapsulation).  
    6.2.[Information Hiding](#information-hiding).  
7.[Aggregation](#aggregation).  
8.[Composition](#composition).  
9.[Exception Handling](#exception-handling).  
10.[Open Closed Principle](#open-closed-principle).  


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
### Inclusion ( Subtyping )
Polymorphism by inclusion is when a class can be treated as an object of another class or type, which is achieved when the class in a subclass of a parentclass or when it implements an interface.
this can achieve multiple purposes such as having the same method doing different things in different classes or having a Super type as the type of an attribute and using any of the subtypes ( and their specified methods ) instead.
This type of polmorphism is mainly implemented by subclassing, where the subclasses override the methods that are already present in the parentclass or the interface which grants them more specified behavior.

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
public class TextAdventure extends JFrame implements ActionListener {
    private EventInterface event;
    public void setEvent(EventInterface event){
        this.event = event;

    }
}
public class Dungeon implements EventInterface {
    public static void trigger(TextAdventure game){
        game.setEvent(new Dungeon(game.getPlayer(),game));
        ....
    }
}
```
In this example the use of EventInterface as the supertype of all events is showing the main functionality of polymorphism by inclusion, the attribute `event` has the supertype `EventInterface` which is an interface implemented by all the events,
which eventually makes it possible for the attribute to hold different events.
here is another example: 
```java
public class Player extends Characters implements CombatInterface{
    public void equipItem(Equippable item){
            item.handleEquip(this);
    }
}
```
In this example, player class has the method equipItem which takes in an `Equippable` type of object which is an interface implemented by all the equippable gear. This makes it possible for the method to be multi-functional and work for both armor and weapon.
```java
public class Fight extends JFrame implements ActionListener,EventInterface {
    private final Enemy enemy;
}
```
in this example, in the Fight class, there's an Enemy type variable which will take one enemy, all of them are subclasses of Enemy, for example Assassin and Goblin.
## More on Subtyping
Subtyping is when a class can be treated as an instance of a parent class or interface, this will allow reusability and some unique functionalities. its a form of implementing Inclusion polymorphism and one of its uses with the help of inheritance.
we used Subtyping in the examples above, and also in subclasses of Enemy, Items etc where one variable is set to hold a super type which will eventually take a subclass type and work perfectly fine.

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
This [Class Diagram](https://drive.google.com/file/d/1Zws1gt2rwfyQ4njG2bGJbZFmkZZ8_3jw/view?usp=sharing) shows most of the classes and inheritances in our code.
Dotted lines mean the classes implement an interface and normal lines show inheritance.
### A brief overlook on the classes
``CharacterInfo``: this is the Package that holds Characters.
`Characters`: This is the superclass to `Enemy` and `Player` which contains a variety of shared methods and attributes between them.  
`Player`: This class is the user's character, which contains xp,inventory ( as Composition ) and many more attributes and methods in addition to its superclass `Characters` and sibling class `Enemy`.  
`Enemy`: This is a subclass of characters. its constructor takes text adventure game, string name and  int level as parameters. so it creates different enemies based on the name parameter using of different methods that are defined in the same class. 
``Event``: This is the Package that holds the events of the game.
`Dungeon`: This class is a class that starts the dungeon event, it implements the `EventInterface` interface and has the ability to create 3 random enemies according to the player level.
`Fight`: This is the class that starts the fight mechanic which is an event used in a random enemy encouner and dungeon. It has a unique GUI that allows the player to attack and get attacked. at the end of the fight, if the player comes out as the winner, he/she gains an amount of xp according to enemy level.  
`Treasure`: This is the event that generates a random armor or weapon ( using a Random function ). and adds the item to the player's inventory.
`EventInterface`: this Interface is implemented by all the events, which allows the game to hold is as the current event since the data type of the attribute is the same as the name of this interface, it also has the "start(Player p)" method which is overriden by all the classes that implement this interface.  
``Game``: This package holds a number of classes that directly manage the game system.  
`DamageGenerics/HealthGenerics`: These classes set the type of an item through parametric polymorphism and decide what kind of value the item gives ( damage / health ).  
`EnemyGenrator`: This is the class that handles the system for generating random enemies, which is used in Dungeon and Random enemy encounter.  
``GUI``: This package holds the main GUI classes and the main executable class of the project.  
`CharacterLabel`: This class shows the stats of the player and when there's an enemy availabel it also shows their stats. It's used both in the main window and the fight window.  
`InventoryBox`: This class is the GUI to the Inventory class.  
`LevelUp`: This class appears whenever the player levels up, giving an increase health and an increase damage option to the player.  
`NameSelection`: This is the first window that appears when the program is ran, which asks the user to enter the name they want to use for their character.  
`TextAdventure`: This is the main executable class, which is also the main window.  
``Items``: This package holds everything about Inventory and items.  
`Equippable`: This interface is implemented by Armor and Weapon class which allows subtyping.  
`Armor`: This is the class with the armor generator, handle equip item and names of the armors.  
`Weapon`: This is the same as the armor class but for weapons.  
`Inventory`: This is the class that is used as Composition in Player class, giving the player an inventory that can only be accessed THROUGH the playr.
`Item`: This is the superclass of Armor and Weapon containing the common methods and attributes.  

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
## Aggregation
Aggregation is a form of relation in OOP. It represents a relationship between two classes where they have a "has-a" relationship, but the parts can exist independently of the aggregate. Aggregation is often used to indicate that one class is a collection or a container of other classes, but those contained classes do not strictly depend on the lifecycle of the container.
In our code we used aggregation a lot when a class has an instance of another one. here is an example.
```java
public class Fight extends JFrame implements ActionListener,EventInterface {
    private Player player1;
    private Enemy enemy;
}
```
in this example, the Fight class has a Player and an Enemy object inside of it as an attribute, but the lifecycle of those objects are not bound to te lifecycle of Fight Object.
When the fight is ended, the Fight object is destroyed but the player object is still in the game and can continue playing it.
here is another example.
```java
public Player(String name, int health, int damage, TextAdventure game){
        
        this.setGame(game);

    }

```
We also used Aggregation in Player class by including "game" attribute in Player class.

## Composition
Composition can be defined as a more restrictive form of Aggregation with stricter bounds betweent he lifecycles, whereas the lifecycle of the contained class is strictly bound to the lifecycle of the container class,
In composition, one class simply cease to exist or can not function properly when the container is destroyed. It can only be accessed properly through the interfaces that are defined in the container class.
In our code we used Composition in the Player class and Inventory.
```java
public class Player extends Characters implements CombatInterface{
    public Player(String name, int health, int damage, TextAdventure game){
        this.inventory = new Inventory<Item<?>>(50,game);
    }
    public Inventory<Item<?>> getInventory(){
        return this.inventory;
    }
}
```
In this example, the only way you can get access to the Inventor class is through the public method "getInventory". and the Inventory object is created in the Player constrctor, which means the Inventory simply cant  
function or be accessed without the existance of the Player class.

## Exception Handling
Exception handling in programming refers to the process of managing and responding to exceptions and unexpected events or errors that may disrupt the normal flow of a program's execution or cause a crash. In Java we use Try and Catch to handle exceptions.
`Try` block is where we write the code that the exception may ( or may not ) occur, this gives the program the preparation to handle the issues that may occur.  
`Catch` block is where the program jumps to if the exception happesn, which throws an error and usually should print it in the logs and then do a default behviour to continue the flow of the program.

this is where we used this in our code: 
```java
public static Enemy generateEnemy(Player p, TextAdventure game) {
        try {
            Random random = new Random();
            int num = random.nextInt(enemies.length);
            String enemyName = enemies[num];

            switch (enemyName){
                case "Assassin" :
                    return new Enemy("Assassin",40*(p.getLevel()),4+p.getLevel(),game,p.getLevel());
                case "DeathClaw" :
                    return new Enemy("DeathClaw",50*(p.getLevel()),3+p.getLevel(),game,p.getLevel());
                case "Demogorgon" :
                    return new Enemy("Demogorgon",50*(p.getLevel()),7+p.getLevel(),game,p.getLevel());
                case "Goblin" :
                     return new Enemy("Goblin",40*(p.getLevel()),2+p.getLevel(),game,p.getLevel());
                case "HuntingTroll" :
                    return new Enemy("HuntingTroll",40*(p.getLevel()),6+p.getLevel(),game,p.getLevel());
                case "Shadow" :
                    return new Enemy("Shadow",50*(p.getLevel()),5+ p.getLevel(),game, p.getLevel());
                default:
                    return new Enemy("Goblin", 40 * p.getLevel(), 2 + p.getLevel(), game, p.getLevel());
            }
        } catch (Exception e) {

            System.err.println("Error generating enemy: " + e.getMessage());
            return new Enemy("Goblin", 40 * p.getLevel(), 2 + p.getLevel(), game, p.getLevel()); // this is the default enemy in case of any issues in our program
        }
    }
```
The code catches the exception if it occurs, and jumps to the catch block, which prints the error message for debugging purposes and returns an enemy, we chose Goblin as our default enemy in case of any errors.
## Open Closed Principle
Open closed principle is one of the main OOP design principles which suggests that the entities ( classes, interfaces, objects, etc ) should be closed to modification but open to extension. which means that the behavior of a module could be extended without changing the soruce code but with added new classes/modules or behaviors. It allows better management of the code.
In our code we tried to achieve this design by including some subclasses like Enemy subclasses and Interfaces like `Equippable`, `ItemType` and `Armor` and `Weapon` so that if we ever decide to add new types of items, we could add them by implementing those Interfaces or adding new classes for example, to add new itemtype called "Potions" we could just add the class, implement the ItemType and not Equippable since potions are not equippable items.
```java
public interface Equippable {
        void handleEquip(Player p);
        void handleUnequip(Player p,Inventory<Item<?>> inv);


}
public class Weapon extends Item<DamageGenericClass> implements Equippable{
}
public class Armor extends Item<HealthGenericClass> implements Equippable{}
```
Here you can see that we have 2 types of Equippable items rightnow, Armor and Weapon. both implement the equippable interface and if we wanted to add a 3rd one, for example helmet, we just need to create the class and implement the interface and there is no need to edited already written code.







