package model;
// This class is a general abstract class for items

import model.persistance.Writable;
import org.json.JSONObject;

public abstract class Item extends Writable {
    protected String name;
    protected int cost;
    protected int damage;
    protected boolean typeWeapon;
    protected HeartPoints heartValue;

    // EFFECTS: instantiates an item with general item behaviour depending on type
    public Item(String name, int cost, int damage, boolean typeWeapon) {
        heartValue = new HeartPoints(0);
        setDamage(damage);
        setHeartValue(heartValue);
        setName(name);
        setCost(cost);
        typeWeapon = this.typeWeapon;
    }

    Item(JSONObject json) {
        super(json);
    }

    // MODIFIES: this
    // EFFECTS: determines the value item can damage other objects
    public abstract int damageChooser();

    // EFFECTS: returns true if item is weapon,
    // false otherwise
    public boolean isTypeWeapon() {
        return typeWeapon;
    }

    // getters and setters
    public void setHeartValue(HeartPoints heartValue) {
        this.heartValue = heartValue;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return this.cost;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getHeartValue() {
        return heartValue.getHp();
    }

    public String getName() {
        return this.name;
    }

    @Override
    //EFFECTS: stores item as an JsonObject
    // Source: JSonSerializationDemo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("cost", this.cost);
        json.put("damage", this.damage);
        json.put("IsWeapon", typeWeapon);
        return json;
    }

    @Override
    public void fromJson(JSONObject json) {
        this.name = json.getString("name");
        this.cost = json.getInt("cost");
        this.damage = json.getInt("damage");
        this.typeWeapon = json.getBoolean("IsWeapon");
    }
}
