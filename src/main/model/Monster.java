package model;
// this class if for a Monster object

import model.persistance.Writable;
import org.json.JSONObject;

import java.util.Random;

public class Monster extends Writable {
    private HeartPoints heartPoints;
    private String name;
    private HeartPoints initialHealth;
    private int attack;




    //EFFECTS: instantiates a new monster with specific value traits
    public Monster() {
        heartPoints = new HeartPoints(20);
        name = "Hytos the troll";
        initialHealth = new HeartPoints(20);
        attack = attackChooser();
    }

    public Monster(JSONObject json) {
        super(json);
    }

    //MODIFIES: this
    //EFFECTS: chooses amount of damage to be applied
    public int attackChooser() {
        Random d = new Random();
        int attackAmount = attack;
        for (int i = 0; i < 7; i++) {
            attackAmount = 1 + d.nextInt(3);
        }
        return attackAmount;
    }

    @Override
    //EFFECTS: stores Monster as an JsonObject
    // Source: JSonSerializationDemo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("heartPoints", this.heartPoints.getHp());
        json.put("initialHealth", this.initialHealth.getHp());
        json.put("attack",this.attack);
        return json;
    }

    @Override
    protected void fromJson(JSONObject json) {
        this.name = json.getString("name");
        this.heartPoints = new HeartPoints(json.getInt("heartPoints"));
        this.initialHealth = new HeartPoints(json.getInt("initialHealth"));
        this.attack = json.getInt("attack");
    }


    // MODIFIES: this
    // EFFECTS: removes input hp to monster's overall hp
    // returns true if it can, returns false if entered HP exceeds
    // monster current HP and set HP to 0
    public boolean loseHP(int hp) {
        return  heartPoints.removeHP(hp);
    }

    //MODIFIES: this
    //EFFECTS: resets the monster's health to original value
    public void resetHp() {
        heartPoints = initialHealth;
    }

    // getters

    public String getName() {
        return this.name;
    }

    public int getHP() {
        return heartPoints.getHp();
    }

    public int getInitialHP() {
        return initialHealth.getHp();
    }
}
