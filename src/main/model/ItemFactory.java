package model;

import model.exceptions.UnknownItemException;
import org.json.JSONObject;

public class ItemFactory {
    public static Item getItem(JSONObject json) throws UnknownItemException {
        switch (json.getString("name")) {
            case "":
                return new EmptyItem();
            case "Elf Sword":
                return new ElfSword();
            case "broken weapon":
                return new EmptyWeapon();
            case "Full Health Potion":
                return new FullHealthPotion();
            case "The tooth of Hytos the troll":
                return new HytosTooth();
            case "Temporary Immortal Potion":
                return new ImmortalPotion();
            case "Kentucky Rifle with 4 bullets":
                new KentuckyRifle();
            case "Knife":
                new Knife();
            case "Marbles Bag":
                return new MarblesBag();
            case "Sword":
                return new Sword();
            default: throw new UnknownItemException();
        }
    }

    public static Item getWeapon(JSONObject json) throws UnknownItemException {
        switch (json.getString("weapon")) {
            case "Elf Sword":
                return new ElfSword();
            default:
                throw new UnknownItemException();
        }
    }
}
