package model;
// this class is for a marbles bag item, a collectible item


//EFFECTS: instantiates a marbles bag item
public class MarblesBag extends Item  {
    //EFFECTS: instantiates a marbles bag item
    public MarblesBag() {
        super("Marbles Bag", 1,0,false);
    }

    @Override
    // EFFECTS: returns zero default damage, as it is not a weapon
    public int damageChooser() {
        return damage;
    }

}
