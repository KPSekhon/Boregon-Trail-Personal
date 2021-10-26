package model;

import model.exceptions.UnknownItemException;
import org.json.JSONObject;

public class ItemFactory {
    public static Item getItem(JSONObject json) throws UnknownItemException {
        System.out.println(json.getString("name"));
        switch (json.getString("name")) {
            case "Elf Sword":
                return new ElfSword();
            default:
                throw new UnknownItemException();
        }

    }
}
