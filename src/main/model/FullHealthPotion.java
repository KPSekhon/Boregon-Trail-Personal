package model;

// This class is for a potion that restores a player health by 10 HP


// EFFECTS: creates a Full Health Potion
public class FullHealthPotion extends Item  {
    private HeartPoints heartPoints = new HeartPoints(10);

    //EFFECTS: initializes the full health potion with the maximum health of a player
    public FullHealthPotion() {
        super("Full Health Potion", 5, 0, false);
        setHeartValue(heartPoints);
    }

    @Override
    //EFFECTS: returns zero damage as it is not a weapon
    public int damageChooser() {
        return damage;
    }


}
