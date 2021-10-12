package model;

public abstract class Item {
    protected String name;
    protected int cost;
    protected int damage;
    protected boolean typeWeapon;
    protected HeartPoints heartValue;

    public Item(String name,int cost,int damage, boolean typeWeapon) {
        heartValue = new HeartPoints(0);
        setDamage(damage);
        setHeartValue(heartValue);
        setName(name);
        setCost(cost);
    }

    // MODIFIES: this
    // EFFECTS: determines the value item can damage other objects
    public abstract int damageChooser();

    // EFFECTS: returns true if item is weapon,
    // false otherwise
    public boolean isTypeWeapon() {
        return typeWeapon;
    }

    // getters and setters
    public void setHeartValue(HeartPoints heartValue) {
        this.heartValue = heartValue;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return this.cost;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getHeartValue() {
        return heartValue.getHp();
    }

    public String getName() {
        return this.name;
    }
}
