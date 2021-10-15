package model;
// This item is for a filler slot, place-holder item


// EFFECTS: creates a place-holder item
public class EmptyItem extends Item {
    EmptyItem() {
        super("",0,0,false);
    }

    @Override
    // EFFECTS: returns zero default damage, as it is not a weapon
    public int damageChooser() {
        return damage;
    }
}
