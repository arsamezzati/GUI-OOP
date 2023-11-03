// File: CharacterLabel.java
package GUI;

import CharacterInfo.Player;
import javax.swing.JLabel;

public class CharacterLabel extends JLabel {
    private Player player;

    public CharacterLabel(Player player) {
        this.player = player;
        updateCharacterInfo();
    }

    public void setPlayer(Player player) {
        this.player = player;
        updateCharacterInfo();
    }

    public void updateCharacterInfo() {
        if (player != null) {
            String info = String.format("%s | Level: %d | Damage: %d | Health: %d / %d",
                    player.getName(),
                    player.getLevel(),
                    player.getAttackDamage(),
                    player.getCurHealth(),
                    player.getMaxHealth());
            setText(info);
        }
    }
}
