package model;

import java.util.Random;

public class KentuckyRifle extends Item {
    public KentuckyRifle() {
        super("Kentucky Rifle with 4 bullets", 8, 12, true);
    }

    @Override
    public int damageChooser() {
        Random d = new Random();
        int damageAmount = damage;
        for (int i = 0; i < 7; i++) {
            damageAmount = d.nextInt(2);
        }
        if (damageAmount == 1) {
            damageAmount = 12;
        }
        return damageAmount;
    }
}
