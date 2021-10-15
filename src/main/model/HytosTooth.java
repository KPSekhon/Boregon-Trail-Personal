package model;

public class HytosTooth extends Item {
    public HytosTooth() {
        super("The tooth of Hytos the troll", 400, 0, false);
    }

    @Override
    // EFFECTS: returns zero default damage, as it is not a weapon
    public int damageChooser() {
        return damage;
    }
}
