package model;

import java.util.Random;
// This class is for a Kentucky Rifle with 4 bullets, a weapon

public class KentuckyRifle extends Item {
    public KentuckyRifle() {
        super("Kentucky Rifle with 4 bullets", 8, 12, true);
        typeWeapon = true;
    }

    @Override
    public int damageChooser() {
        Random d = new Random();
        int damageAmount = damage;
        int random = 0;
        for (int i = 0; i < 5; i++) {
            random = d.nextInt(10);
        }
        if (random > 5) {
            damageAmount = 12;
        }
        return damageAmount;
    }
}
