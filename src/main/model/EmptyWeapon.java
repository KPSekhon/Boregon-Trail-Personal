package model;

// This class is a weapon placeholder class until a weapon is set up for the player
public class EmptyWeapon extends Item {
    // MODIFIES: this
    //EFFECTS: instantiates an empty broken weapon
    public EmptyWeapon() {
        super("broken weapon", 0, 0, true);
        typeWeapon = true;
    }


    @Override
    // EFFECTS: returns zero default damage, as it is not a weapon
    public int damageChooser() {
        return damage;
    }
}
