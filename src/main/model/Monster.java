package model;
// this class if for a Monster object

import java.util.Random;

public class Monster {
    private HeartPoints heartPoints;
    private String name;
    private HeartPoints initialHealth;
    private int attack;

    public Monster() {
        heartPoints = new HeartPoints(20);
        name = "Hytos";
        initialHealth = new HeartPoints(20);
    }

    //MODIFIES: this
    //EFFECTS: chooses amount of damage to do
    public int attackChooser(Player player) {
        Random d = new Random();
        int attackAmount = attack;
        for (int i = 0; i < 7; i++) {
            attackAmount = 1 + d.nextInt(3);
        }
        return attackAmount;
    }



    // MODIFIES: this
    // EFFECTS: removes input hp to monster's overall hp
    // returns true if it can, returns false if entered HP exceeds
    // monster current HP and set HP to 0
    public boolean loseHP(int hp) {
        return heartPoints.removeHP(hp);
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
