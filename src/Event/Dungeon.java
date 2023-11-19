package Event;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import CharacterInfo.Enemy;
import CharacterInfo.Player;
import GUI.TextAdventure;
import Game.EnemyGenerator;

public class Dungeon implements EventInterface {
    public Dungeon(Player p,TextAdventure game){
        this.entryLevel = p.getLevel();
        this.game = game;
        this.player = p;

    }
    private int entryLevel;
    private Player player;
    private TextAdventure game;
    private boolean isRandom;
    public int getEntryLevel(){
        return this.entryLevel;
    }
    public void setEntryLevel(int amount){
        this.entryLevel = amount;
    }
    private String Boss;
    public String getBoss(){
        return this.Boss;
    }
    public void setBoss(String name){
        this.Boss = name;
    }
    private String sideEnemy;
    public String getSideEnemy(){
        return this.sideEnemy;
    }
    public void setSideEnemy(String name){
        this.sideEnemy = name;
    }
    private String loot;
    public String getLoot(){
        return this.loot;
    }
    public void setLoot(String item){
        this.loot = item;
    }
    private Queue<Enemy> enemyBossList = new LinkedList<>();
    private Queue<Enemy> sideEnemyList = new LinkedList<>();
    public Queue<Enemy> getSideEnemyList(){
        return this.sideEnemyList;
    }

    public void addEnemy(Enemy enemy){
        this.sideEnemyList.add(enemy);
    }
    public Enemy seeNextEnemyList(){
        return this.sideEnemyList.peek();
    }
    public Enemy getNextEnemyList(){
        return this.sideEnemyList.poll();
    }

    public void randomGen(Player p){
        Enemy e1 = EnemyGenerator.generateEnemy(p,this.game);

        Enemy e2 = EnemyGenerator.generateEnemy(p,this.game);

        Enemy e3 = EnemyGenerator.generateEnemy(p,this.game);

        this.sideEnemyList.offer(e1);
        this.sideEnemyList.offer(e2);
        this.sideEnemyList.offer(e3);
    }
    public static void trigger(TextAdventure game){
        game.setEvent(new Dungeon(game.getPlayer(),game));
        game.displayMessage("Do you want to step inside?");
        game.removePanel(game.getExplorePanel());
        game.addPanel(game.getEventPanel());
        game.repaint();

    }
    @Override
    public void start(Player p){
        this.randomGen(this.player);


    }

}
