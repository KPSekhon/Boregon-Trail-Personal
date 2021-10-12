package model;

public class FullHealthPotion extends Item {
    public FullHealthPotion() {
        super("Full Health Potion", 5, 0, false);
    }

    @Override
    public int damageChooser() {
        return damage;
    }
}
