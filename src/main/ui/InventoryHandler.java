package ui;

import model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class handles the visual sorting of the player's inventory
public class InventoryHandler implements ActionListener {
    UI ui;
    String chosen;
    Player player;
    ImmortalPotion immortalPotion = new ImmortalPotion();
    FullHealthPotion fullHealthPotion = new FullHealthPotion();

    //MODIFIES: this
    //EFFECTS: instantiates the player and ui
    public InventoryHandler(UI ui) {
        this.ui = ui;
        this.player = ui.player;
    }


    //MODIFIES: player, ui
    //EFFECTS: if slot item has healing attributes,
    // then those attributes are applied and the item is discarded from the inventory
    // the associated item message is also displayed
    public void useItem(int slot) {
        Item item = player.getInventoryItem(slot);
        int hpVal = item.getHeartValue();
        if (!(hpVal == 0)) {
            player.healPlayer(item);
            ui.hpNumberLabel.setText("" + player.getPlayerHP());
            player.loseItem(item);
            itemMessage(item);
        } else {
            ui.mainTextArea.setText(" A nice collectible, " + item.getName() + ", is");
        }
        inventoryChecker();
    }

    // MODIFIES: ui
    // EFFECTS: returns a message of the chosen healing item
    private void itemMessage(Item item) {
        if (item.getName().equals(immortalPotion.getName())) {
            useImmortalPotion();
        } else if (item.getName().equals(fullHealthPotion.getName())) {
            useFullHealthPotion();
        }
    }

    //MODIFIES: ui
    //EFFECTS: returns message of Immortal Potion
    private void useImmortalPotion() {
        ui.mainTextArea.setText(player.getName() + " decides to drink the potion"
                + "\n" + player.getName() + " begins to glow and feels light as a feather"
                + "\n" + player.getName() + " has " + player.getPlayerHP() + " HP remaining");
    }

    //MODIFIES: ui
    //EFFECTS: returns message of Full Health Potion
    private void useFullHealthPotion() {
        ui.mainTextArea.setText(player.getName() + " decides to drink the potion"
                + "\n" + player.getName() + " begins to feel whole once again"
                + "\n" + player.getName() + " has " + player.getPlayerHP() + " HP remaining");
    }

    //MODIFIES: ui, this
    //EFFECTS: allows user to look at current inventory, for items that they have picked up
    // shows empty item slots, for slots that still have items to be added to
    private void inventoryChecker() {
        this.player = ui.player;
        if (player.getInventoryItem(1) == null) {
            ui.itemButton1.setText("");
        } else {
            ui.itemButton1.setText(player.getInventoryItem(1).getName());
        }
        if (player.getInventoryItem(2) == null) {
            ui.itemButton2.setText("");
        } else {
            ui.itemButton2.setText(player.getInventoryItem(2).getName());
        }
        if (player.getInventoryItem(3) == null) {
            ui.itemButton3.setText("");
        } else {
            ui.itemButton3.setText(player.getInventoryItem(3).getName());
        }
        inventoryCheckerContinued();
    }

    //MODIFIES: ui,this
    //EFFECTS: allows user to look at current inventory, for items that they have picked up
    // shows empty item slots, for slots that still have items to be added to
    // continuation of inventoryChecker
    private void inventoryCheckerContinued() {
        if (player.getInventoryItem(4) == null) {
            ui.itemButton4.setText("");
        } else {
            ui.itemButton4.setText(player.getInventoryItem(4).getName());
        }
        if (player.getInventoryItem(5) == null) {
            ui.itemButton5.setText("");
        } else {
            ui.itemButton5.setText(player.getInventoryItem(5).getName());
        }
    }

    @Override
    //MODIFIES: ui, this
    //EFFECTS: completes action associated with the button pressed
    // This method references code from linked video:
    // link - https://www.youtube.com/watch?v=vW2EV9En6vA&ab_channel=RyiSnow
    public void actionPerformed(ActionEvent e) {
        this.chosen = e.getActionCommand();

        switch (chosen) {
            case "inventoryButton":
                if (ui.inventoryStatus.equals("close")) {
                    ui.option1.setVisible(false);
                    ui.option2.setVisible(false);
                    ui.option3.setVisible(false);
                    ui.option4.setVisible(false);
                    ui.inventoryPanel.setVisible(true);
                    inventoryChecker();
                    ui.inventoryStatus = "open";
                } else if (ui.inventoryStatus.equals("open")) {
                    ui.option1.setVisible(true);
                    ui.option2.setVisible(true);
                    ui.option3.setVisible(true);
                    ui.option4.setVisible(true);
                    ui.inventoryPanel.setVisible(false);
                    ui.inventoryStatus = "close";
                }
                break;
        }
        itemUsage();
    }

    //MODIFIES: ui, this
    //EFFECTS: completes action associated with the button pressed
    // ,continuation of actionPerformed
    // This method references code from linked video:
    // link - https://www.youtube.com/watch?v=vW2EV9En6vA&ab_channel=RyiSnow
    public void itemUsage() {
        switch (chosen) {
            case "item1":
                useItem(1);
                break;
            case "item2":
                useItem(2);
                break;
            case "item3":
                useItem(3);
                break;
            case "item4":
                useItem(4);
                break;
            case "item5":
                useItem(5);
                break;
        }
    }


}
