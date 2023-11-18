package GUI;

import CharacterInfo.Player;
import Items.Equippable;
import Items.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InventoryBox implements ActionListener, ItemListener {
    private TextAdventure game;
    private Map<JCheckBox, Equippable> checkboxToItemMap = new HashMap<>();
    private JFrame inventoryFrame;
    private JPanel mainPanel, buttonPanel, armorPanel, weaponPanel;
    private JButton closeButton, applyButton;
    private ArrayList<JCheckBox> armorCheckboxes;
    private ArrayList<JCheckBox> weaponCheckboxes;

    public InventoryBox(TextAdventure game) {
        this.game = game;
        inventoryFrame = new JFrame("Inventory");
        inventoryFrame.setSize(300, 300);


        mainPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel = new JPanel();
        armorPanel = new JPanel(); // Panel for armors
        weaponPanel = new JPanel(); // Panel for weapons

        armorCheckboxes = new ArrayList<>();
        weaponCheckboxes = new ArrayList<>();

        applyButton = new JButton("Apply");
        applyButton.addActionListener(this);
        buttonPanel.add(applyButton);


        mainPanel.add(armorPanel);
        mainPanel.add(weaponPanel);
        inventoryFrame.add(mainPanel, BorderLayout.CENTER);

        closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);
        inventoryFrame.add(buttonPanel, BorderLayout.SOUTH);

        inventoryFrame.setLocationRelativeTo(null);
        inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addCheckbox(Item<?> item, JPanel panel, ArrayList<JCheckBox> checkboxList) {
        JCheckBox checkBox = new JCheckBox(item.getName());
        checkBox.addItemListener(this);
        checkboxList.add(checkBox);
        panel.add(checkBox);

        // Assuming 'item' is of type Equippable or can be cast to it
        checkboxToItemMap.put(checkBox, (Equippable) item);
    }
    public void handleNewItem(Item<?> item){
        if (item.getAttribute().getClass().getName().equals("Game.HealthGenericClass")){
            addCheckbox(item,this.armorPanel,this.armorCheckboxes);
        }else {
            addCheckbox(item,this.weaponPanel,this.weaponCheckboxes);
        }
        inventoryFrame.repaint();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeButton) {
            inventoryFrame.setVisible(false);
        } else if (e.getSource() == applyButton) {
            handleEquippingItems();
        }
    }
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

    private ArrayList<Equippable> getSelectedItems() {
        ArrayList<Equippable> selectedItems = new ArrayList<>();
        for (JCheckBox checkBox : armorCheckboxes) {
            if (checkBox.isSelected()) {
                selectedItems.add(getItemFromCheckbox(checkBox, true)); // Implement this method
            }
        }
        for (JCheckBox checkBox : weaponCheckboxes) {
            if (checkBox.isSelected()) {
                selectedItems.add(getItemFromCheckbox(checkBox, false)); // Implement this method
            }
        }
        return selectedItems;
    }
    private Equippable getItemFromCheckbox(JCheckBox checkBox, boolean isArmor) {
        // Return the item associated with the checkbox
        return checkboxToItemMap.get(checkBox);
    }
    public void removeItemFromInventory(Equippable item) {
        for (Map.Entry<JCheckBox, Equippable> entry : checkboxToItemMap.entrySet()) {
            if (entry.getValue().equals(item)) {
                JCheckBox checkBox = entry.getKey();
                if (armorCheckboxes.contains(checkBox)) {
                    armorPanel.remove(checkBox);
                    armorCheckboxes.remove(checkBox);
                } else if (weaponCheckboxes.contains(checkBox)) {
                    weaponPanel.remove(checkBox);
                    weaponCheckboxes.remove(checkBox);
                }
                checkboxToItemMap.remove(checkBox);
                break;
            }
        }
        inventoryFrame.repaint();
        inventoryFrame.revalidate();
    }



    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox source = (JCheckBox) e.getItemSelectable();
        if (armorCheckboxes.contains(source)) {
            updateCheckboxes(armorCheckboxes, source);
        } else if (weaponCheckboxes.contains(source)) {
            updateCheckboxes(weaponCheckboxes, source);
        }
    }

    private void updateCheckboxes(ArrayList<JCheckBox> checkboxes, JCheckBox source) {
        if (source.isSelected()) {
            for (JCheckBox checkBox : checkboxes) {
                if (checkBox != source) {
                    checkBox.setEnabled(false);
                }
            }
        } else {
            for (JCheckBox checkBox : checkboxes) {
                checkBox.setEnabled(true);
            }
        }
    }

    public void turnOnVisibility() {
        inventoryFrame.repaint();
        inventoryFrame.setVisible(true);
    }
}
