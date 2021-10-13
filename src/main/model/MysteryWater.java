package model;

import java.util.Random;
// this class is a mysterious water bottle that can heal or reduce a player's HP by +/- 2

public class MysteryWater extends Item {

    MysteryWater() {
        super("Mysterious Water Bottle", 0, 0, false);
        heartValue = new HeartPoints(randomHealthTrait());
    }


    @Override
    public int damageChooser() {
        return damage;
    }

    public int randomHealthTrait() {
        Random b = new Random();
        int val;
        int det = 0;
        for (int i = 0; i < 5; i++) {
            det = 1 + b.nextInt(2);
        }
        if (det == 1) {
            val = -2;
        } else {
            val = 2;
        }
        return val;
    }
}
