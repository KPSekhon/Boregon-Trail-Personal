package model;

public class Monster {
    private HeartPoints heartPoints;
    private String name;
    private HeartPoints initialHealth;

    public Monster() {
        heartPoints = new HeartPoints(20);
        name = "Hytos";
        initialHealth = heartPoints;
    }


    // MODIFIES: this
    // EFFECTS: removes input hp to player's overall hp
    public void loseHP(int hp) {
        heartPoints.addHP(hp);
    }

    //MODIFIES: this
    //EFFECTS: resets the monster's health to original value
    public void resetHp() {
        heartPoints = initialHealth;
    }
}
