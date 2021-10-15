package model;

// This class runs all the heart points systems
public class HeartPoints {
    protected int hp;

    // EFFECTS: instantiates the heartpoints amount
    public HeartPoints(int hp) {
        setHp(hp);
    }

    // MODIFIES: this
    // EFFECTS: adds input hp points to current hp
    public void addHP(int hp) {
        this.hp += hp;
    }

    // MODIFIES: this
    // EFFECTS: removes hp points from current hp
    // unless input is higher than current hp, then
    // hp is set to 0
    public boolean removeHP(int hp) {
        if (hp >= this.hp) {
            this.hp = 0;
            return false;
        } else {
            this.hp -= hp;
            return true;
        }
    }

    //getters and setters
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    }
}
