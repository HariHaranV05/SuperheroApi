package com.example.herotoast;

public class HeroPowerstats {
    private String id;
    private String name;
    private String intelligence;
    private String strength;
    private String speed;
    private String durability;
    private String power;
    private String combat;

    public HeroPowerstats(String id, String name, String intelligence, String strength, String speed, String durability, String power, String combat) {
        this.id = id;
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
    }

    @Override
    public String toString() {
        return "HeroPowerstats : " +"\n"+
//                "id :" + id  +"\n"+
                "name :" + name  +"\n"+
                "intelligence :" + intelligence  +"\n"+
                "strength :" + strength  +"\n"+
                "speed :" + speed  +"\n"+
                "durability :" + durability +"\n"+
                "power :" + power  +"\n"+
                "combat :" + combat +"\n";
    }

    public HeroPowerstats() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCombat() {
        return combat;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }
}

