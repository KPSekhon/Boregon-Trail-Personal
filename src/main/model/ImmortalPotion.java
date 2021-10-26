package model;
// This class is for a temporary Immortal potion that restores a person's health by 27 HP


public class ImmortalPotion extends Item {
    private HeartPoints heartPoints = new HeartPoints(27);

    // EFFECTS: creates an immortal potion
    public ImmortalPotion() {
        super("Temporary Immortal Potion", 3,0,false);
        setHeartValue(heartPoints);
    }

    @Override
    // EFFECTS: returns zero default damage, as it is not a weapon
    public int damageChooser() {
        return damage;
    }



}
