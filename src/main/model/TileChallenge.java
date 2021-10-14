package model;

import java.util.Random;
// this class is for the tile challenge, an event in the main story

public class TileChallenge {
    private Player player;
    private int tileOne = 1;
    private int tileTwo = 2;
    private int tileThree = 3;
    private int tileFour = 4;
    private MarblesBag marblesBag;
    String hint = "";

    TileChallenge() {
    }

    // EFFECTS: chooses a random value between one and four
    public int chooseRandomValue() {
        int value = 0;
        Random b = new Random();
        for (int i = 0; i < 5; i++) {
            value = 1 + b.nextInt(4);
        }
        return value;
    }

    // MODIFIES: this
    //EFFECTS: changes values of randomly chosen tiles to zero,
    // to signify they are the correct tiles
    public void assignValue() {
        int tileChangeOne;
        int tileChangeTwo;
        tileChangeOne = chooseRandomValue();
        tileChangeTwo = chooseRandomValue();
        while (tileChangeTwo == tileChangeOne) {
            tileChangeTwo = chooseRandomValue();
        }
        if (tileFour == tileChangeOne || tileFour == tileChangeTwo) {
            tileFour = 0;
        }
        if (tileThree == tileChangeOne || tileThree == tileChangeTwo) {
            tileThree = 0;
        }
        if (tileTwo == tileChangeOne || tileTwo == tileChangeTwo) {
            tileTwo = 0;
        }
        if (tileOne == tileChangeOne || tileOne == tileChangeTwo) {
            tileOne = 0;
        }
    }

    public String rollMarbles(Player player) {
        if (player.hasItem(marblesBag)) {
            if (tileOne == 0) {
                hint += "\n juan is right ";
            }
            if (tileTwo == 0) {
                hint += "\n unos,... ";
            }
            if (tileThree == 0) {
                hint += "\n a triangle has ... sides ";
            }
            if (tileFour == 0) {
                hint += "\n don't be such a square ";
            }
        } else if (tileOne == 0) {
            hint = "\n juan is right ";
        } else if (tileTwo == 0) {
            hint = "\n unos,... ";
        } else if (tileThree == 0) {
            hint = "\n a triangle has ... sides ";
        } else if (tileFour == 0) {
            hint = "\n don't be such a square ";
        }
        return hint;
    }

    // getters


    public int getTileOne() {
        return tileOne;
    }

    public int getTileThree() {
        return tileThree;
    }

    public int getTileTwo() {
        return tileTwo;
    }

    public int getTileFour() {
        return tileFour;
    }

    public String getHint() {
        return hint;
    }
}
