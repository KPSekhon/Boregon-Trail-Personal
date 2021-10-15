package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
// this class is for the main PLayer

public class Player {
    private HeartPoints heartPoints;
    private String name;
    private int wallet;
    private List<Item> inventory;
    private Item weapon;

    // EFFECTS: instantiates a player object
    public Player(String name) {
        this.wallet = 10;
        heartPoints = new HeartPoints(10);
        setName(name);
        this.inventory = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds input hp to player's overall hp
    public void addHP(int hp) {
        this.heartPoints.addHP(hp);
    }

    // MODIFIES: this
    // EFFECTS: removes hp points from player's current hp
    // unless input is higher than current hp, then
    // hp is set to 0
    public int loseHP(int hp) {
        this.heartPoints.removeHP(hp);
        return heartPoints.getHp();
    }

    // MODIFIES: this
    // EFFECTS: adds input m amount to wallet
    public void addMoney(int m) {
        this.wallet += m;
    }

    // MODIFIES: this
    // EFFECTS: removes input m amount from wallet and produces,
    // if amount does not exceed wallet amount, otherwise produces false
    public boolean spendMoney(int m) {
        if (m > this.wallet) {
            return false;
        } else {
            this.wallet -= m;
            return true;
        }
    }

    // MODIFIES: this
    // EFFECTS: adds item to inventory,
    // if item is a weapon, that item is set to
    // current weapon
    public void addItem(Item item) {
        inventory.add(item);
        if (item.isTypeWeapon()) {
            weapon = item;
        }
    }

    // MODIFIES: this
    // EFFECTS: removes item from inventory, if item is inventory
    // and produces true, otherwise produces false
    public boolean loseItem(Item item) {
        if (hasItem(item)) {
            inventory.remove(item);
            return true;
        }
        return false;
    }


    //MODIFIES: this
    // EFFECTS: adds item healing value to player
    // and reduces item healing value to 0
    public void healPlayer(Item item) {
        int heal = item.heartValue.getHp();
        addHP(heal);
    }

    //EFFECTS: produces true if player has item in inventory
    // ,false otherwise
    public boolean hasItem(Item item) {
        boolean b = false;
        for (Item i : inventory) {
            if (Objects.equals(i.getName(), item.getName())) {
                b = true;
                break;
            }
        }
        return b;
    }

    // getters and setters
    public void setName(String s) {
        this.name = s;
    }

    public String getName() {
        return this.name;
    }

    public int getWallet() {
        return this.wallet;
    }

    public int getPlayerHP() {
        return this.heartPoints.getHp();
    }

    public int getInventorySize() {
        return this.inventory.size();
    }

    public String getWeaponName() {
        return weapon.getName();
    }

    public Item getWeapon() {
        return weapon;
    }

    // EFFECTS: return item with inputted index
    // or returns false, if there is no item in inputted index
    public Item getInventoryItem(int i) {
        if (i > (getInventorySize() - 1)) {
            return new EmptyItem();
        } else {
            return inventory.get(i);
        }
    }

}
