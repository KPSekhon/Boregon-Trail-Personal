package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private HeartPoints heartPoints;
    private String name;
    private int wallet;
    private List<Item> inventory;
    private Item weapon;

    public Player(String name) {
        this.wallet = 10;
        heartPoints = new HeartPoints(10);
        setName(name);
        this.inventory = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds input hp to player's overall hp
    public void addHP(int hp) {
        heartPoints.addHP(hp);
    }

    // MODIFIES: this
    // EFFECTS: adds input m amount to wallet
    public void addMoney(int m) {
        this.wallet += m;
    }

    // MODIFIES: this
    // EFFECTS: removes input m amount from wallet
    public void spendMoney(int m) {
        this.wallet -= m;
    }

    // MODIFIES: this
    // EFFECTS: adds item to inventory
    public void addItem(Item item) {
        inventory.add(item);
    }

    // MODIFIES: this
    // EFFECTS: removes item from inventory
    public void loseItem(Item item) {
        inventory.remove(item);
    }

    // MODIFIES: monster
    // EFFECTS: applies weapon damage onto monster
    public void useWeapon(Monster monster) {
        int hurt = weapon.damageChooser();
        monster.loseHP(hurt);
    }

    //MODIFIES: this
    // EFFECTS: adds item healing value to player
    // and reduces item healing value to 0
    public void healPlayer(Item item) {
        int heal = item.heartValue.getHp();
        addHP(heal);
    }


    // getters and setters
    public void setName(String s) {
        this.name = s;
    }

}
