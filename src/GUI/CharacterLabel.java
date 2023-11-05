// File: CharacterLabel.java
package GUI;

import CharacterInfo.*;

import javax.swing.JLabel;

public class CharacterLabel extends JLabel {
    private Player player;
    private Enemy enemy;  // Add an Enemy reference

    public CharacterLabel(Player player,Enemy enemy) {
        this.player = player;
        if(enemy!=null){
            this.enemy = enemy;
        }
        updateCharacterInfo();
    }

    public void setPlayer(Player player) {
        this.player = player;
        updateCharacterInfo();
    }

    public void setEnemy(Enemy enemy) {  // New method to set enemy
        this.enemy = enemy;
        updateCharacterInfo();
    }

    public void updateCharacterInfo() {
        StringBuilder info = new StringBuilder();
        if (player != null) {
            info.append(String.format("%s | Level: %d | Damage: %d | Health: %d / %d",
                    player.getName(),
                    player.getLevel(),
                    player.getAttackDamage(),
                    player.getCurHealth(),
                    player.getMaxHealth()));
        }
        if (enemy != null) {  // If there is an enemy, append its information
            info.append(String.format("     Enemy: %s | Level: %d | Damage: %d | Health: %d / %d",
                    enemy.getName(),
                    enemy.getLevel(),
                    enemy.getAttackDamage(),
                    enemy.getCurHealth(),
                    enemy.getMaxHealth()));
        }
        setText(info.toString());  // Update the text of the label
    }
}
