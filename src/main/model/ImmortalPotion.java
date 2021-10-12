package model;

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
