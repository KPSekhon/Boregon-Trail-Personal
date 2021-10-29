package model;

import model.exceptions.UnknownItemException;
import model.persistance.Writable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
// this class is for the main PLayer

public class Player extends Writable {
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

    public Player(JSONObject json) {
        super(json);
    }

    // MODIFIES: this
    // EFFECTS: adds input hp to player's overall hp
    public void addHP(int hp) {
        this.heartPoints.addHP(hp);
    }

    @Override
    //EFFECTS: stores Player as an JsonObject
    // Source: JSonSerializationDemo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("heartpoints", this.heartPoints.getHp());
        json.put("wallet", this.wallet);
        json.put("inventory", inventoryToJson());
        json.put("weapon", getInventoryItem(0));
        return json;
    }

    @Override
    // MODIFIES: this
    // EFFECTS: if there is no item in inventory, re-instantiates with nothing in inventory
    // if there is no weapon already instantiated, places broken weapon as place-holder weapon
    // re-instantiates Player from JsonObject
    protected void fromJson(JSONObject json) {
        this.name = json.getString("name");
        this.heartPoints = new HeartPoints(json.getInt("heartpoints"));
        this.wallet = json.getInt("wallet");
        this.inventory = new ArrayList<Item>();
        JSONArray rawInventory = json.getJSONArray("inventory");
        for (int i = 0; i < rawInventory.length(); i++) {
            try {
                Item item = ItemFactory.getItem(rawInventory.getJSONObject(i));
                addItem(item);
            } catch (UnknownItemException e) {
                continue;
            }
        }
        try {
            this.weapon = inventory.get(0);
        } catch (IndexOutOfBoundsException e) {
            addItem(new EmptyWeapon());
        } catch (JSONException e) {
            addItem(new EmptyWeapon());
        }
    }


    // EFFECTS: returns items in inventory as a JSON array
    // Source: JSonSerializationDemo
    private JSONArray inventoryToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Item i : inventory) {
            jsonArray.put(i.toJson());
        }
        return jsonArray;
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
        if (item.isTypeWeapon()) {
            setWeapon(item);
        } else {
            inventory.add(item);
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

    public void setHeartPoints(HeartPoints heartPoints) {
        this.heartPoints = heartPoints;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void setWeapon(Item weapon) {
        if ((!(this.weapon == null)) && this.weapon.isTypeWeapon()) {
            this.inventory.remove(0);
            this.inventory.add(0, weapon);
            this.weapon = weapon;
        } else {
            this.weapon = weapon;
            this.inventory.add(weapon);
        }
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
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
