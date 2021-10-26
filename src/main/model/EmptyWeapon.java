package model;

public class EmptyWeapon extends Item {
    EmptyWeapon() {
        super("broken weapon", 0, 0, true);
    }


    @Override
    // EFFECTS: returns zero default damage, as it is not a weapon
    public int damageChooser() {
        return damage;
    }
}
