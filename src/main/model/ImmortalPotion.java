package model;
// This class is for a temporary Immortal potion that restores a person's health by 27 HP

public class ImmortalPotion extends Item {
    private HeartPoints heartPoints = new HeartPoints(27);

    public ImmortalPotion() {
        super("Temporary Immortal Potion", 999,0,false);
        setHeartValue(heartPoints);
    }

    @Override
    public int damageChooser() {
        return damage;
    }
}
