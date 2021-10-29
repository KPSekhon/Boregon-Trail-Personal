package model;

import model.exceptions.UnknownItemException;
import org.json.JSONObject;

// This class is for searching through the JSON Arrays and retrieving
// the appropriate item/weapon according to the JsonObject's key value
public class ItemFactory {

    // EFFECTS: if there is no item with a value associated with the name key
    // an UnknownItemException is thrown
    // Otherwise, a new Item is constructed that fits the stored value of
    // the input name key of the JsonObject
    public static Item getItem(JSONObject json) throws UnknownItemException {
        switch (json.getString("name")) {
            case "":
                return new EmptyItem();
            case "Full Health Potion":
                return new FullHealthPotion();
            case "The tooth of Hytos the troll":
                return new HytosTooth();
            case "Temporary Immortal Potion":
                return new ImmortalPotion();
            case "Marbles Bag":
                return new MarblesBag();
        }
        if (!(json.isEmpty())) {
            return getWeapon(json);
        } else {
            throw new UnknownItemException();
        }
    }

    // EFFECTS: if there is no weapon with a value associated with the name key
    // an UnknownItemException is thrown
    // Otherwise, extends getItem, but in the pursuit of weapons
    public static Item getWeapon(JSONObject json) throws UnknownItemException {
        switch (json.getString("name")) {
            case "Elf Sword":
                return new ElfSword();
            case "broken weapon":
                return new EmptyWeapon();
            case "Kentucky Rifle with 4 bullets":
                return new KentuckyRifle();
            case "Knife":
                return new Knife();
            case "Sword":
                return new Sword();
            default:
                throw new UnknownItemException();
        }
    }
}
