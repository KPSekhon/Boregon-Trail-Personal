package model;
// This item is for a filler slot

public class EmptyItem extends Item {
    EmptyItem() {
        super("",0,0,false);
    }

    @Override
    public int damageChooser() {
        return damage;
    }
}
