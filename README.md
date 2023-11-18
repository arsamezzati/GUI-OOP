#The Project
###What is the Project for?
This is a school project by Arsam Ezzati and Hila Kargar Masouleh for OOP course taught by Professor Distefano in University of Messina.
##What is the project?
In this Project we tried to implement all of OOP design principles through Java that we were taught by our Professor into the project and ship it as a whole.
Our Project is a Text based dungeon crawler that has some RPG aspects to it like level ups, different equipment and more.
###What we used?
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


