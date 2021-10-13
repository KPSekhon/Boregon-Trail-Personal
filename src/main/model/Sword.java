package model;

import java.util.Random;
// this class if for a sword item, a weapon

public class Sword extends Item {
    public Sword() {
        super("Sword", 6, 6, true);
        typeWeapon = true;
    }

    @Override
    public int damageChooser() {
        Random d = new Random();
        int damageAmount = damage;
        for (int i = 0; i < 7; i++) {
            damageAmount = 6 + d.nextInt(5);
        }
        return damageAmount;
    }
}
