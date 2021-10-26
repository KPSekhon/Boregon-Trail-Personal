package model;



import java.util.Random;
// this class is a mysterious water bottle that can heal or reduce a player's HP by +/- 2

public class MysteryWater extends Item  {

    // EFFECTS: instantiates a mystery water item
    public MysteryWater() {
        super("Mysterious Water Bottle", 0, 0, false);
        heartValue = new HeartPoints(randomHealthTrait());
    }


    @Override
    // EFFECTS: returns zero default damage, as it is not a weapon
    public int damageChooser() {
        return damage;
    }

    //MODIFIES: this
    //EFFECTS: determines the heartValue of item, either +2 or -2
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
