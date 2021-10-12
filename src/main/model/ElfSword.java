package model;

public class ElfSword extends Item {
    public ElfSword() {
        super("Elf Sword", 0, 50, true);
    }

    @Override
    // MODIFIES: this
    // EFFECTS: makes sure that damage amount is always fifty.
    public int damageChooser() {
        return 50;
    }
}
