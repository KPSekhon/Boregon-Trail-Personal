package model;

public class HytosTooth extends Item {
    public HytosTooth() {
        super("The tooth of Hytos the troll", 400, 0, false);
    }

    @Override
    public int damageChooser() {
        return damage;
    }
}
