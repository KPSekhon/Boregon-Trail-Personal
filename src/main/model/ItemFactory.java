package model;

import model.exceptions.UnknownItemException;
import org.json.JSONObject;

public class ItemFactory {
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
