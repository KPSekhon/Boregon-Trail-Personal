package model;

import java.util.Random;
// This class is for a knife item, a weapon

public class Knife extends Item {
    public Knife() {
        super("Knife", 3, 3, true);
        typeWeapon = true;
    }

    @Override
    public int damageChooser() {
        Random d = new Random();
        int damageAmount = damage;
        for (int i = 0; i < 7; i++) {
            damageAmount = 1 + d.nextInt(3);
        }
        return damageAmount;
    }
}
