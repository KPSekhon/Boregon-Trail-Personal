package model;

// This class is for a potion that restores a player health by 10 HP

// EFFECTS: creates a Full Health Potion
public class FullHealthPotion extends Item {
    private HeartPoints heartPoints = new HeartPoints(10);

    public FullHealthPotion() {
        super("Full Health Potion", 5, 0, false);
        setHeartValue(heartPoints);
    }

    @Override
    public int damageChooser() {
        return damage;
    }
}
