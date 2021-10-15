package model;

import java.util.Random;
// this class is for a sword item, a weapon

//EFFECTS: instantiates a sword item with specific characteristics
public class Sword extends Item {
    public Sword() {
        super("Sword", 6, 6, true);
        typeWeapon = true;
    }

    @Override
    // MODIFIES: this
    // EFFECTS: chooses a damage amount for sword between 6 - 10
    public int damageChooser() {
        Random d = new Random();
        int damageAmount = damage;
        for (int i = 0; i < 7; i++) {
            damageAmount = 6 + d.nextInt(5);
        }
        return damageAmount;
    }
}
