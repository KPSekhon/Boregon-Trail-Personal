package model;
// This class is for the collectible: Hytos the troll's tooth

public class HytosTooth extends Item {

    //EFFECTS: initializes the tooth with name and high value
    public HytosTooth() {
        super("The tooth of Hytos the troll", 400, 0, false);
    }

    @Override
    // EFFECTS: returns zero default damage, as it is not a weapon
    public int damageChooser() {
        return damage;
    }
}
