package model;
// this class is for a marbles bag item, a collectible item

public class MarblesBag extends Item {
    public MarblesBag() {
        super("Marbles Bag", 1,0,false);
    }

    @Override
    public int damageChooser() {
        return damage;
    }
}
