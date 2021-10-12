package model;

public class MarblesBag extends Item {
    public MarblesBag() {
        super("Marbles Bag", 1,0,false);
    }

    @Override
    public int damageChooser() {
        return damage;
    }
}
