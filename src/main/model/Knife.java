package model;

import java.util.Random;
// This class is for a knife item, a weapon


public class Knife extends Item {
    // EFFECTS: instantiates a knife item
    public Knife() {
        super("Knife", 3, 3, true);
        typeWeapon = true;
    }

    @Override
    // MODIFIES: this
    // EFFECTS: chooses a damage amount for knife between 1 - 3
    public int damageChooser() {
        Random d = new Random();
        int damageAmount = damage;
        for (int i = 0; i < 7; i++) {
            damageAmount = 1 + d.nextInt(3);
        }
        return damageAmount;
    }
}
