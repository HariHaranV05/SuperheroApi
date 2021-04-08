package com.example.herotoast;

public class HeroAppearance {
    private String id;
    private String name;
    private String gender;
    private String race;
    private String eye_color;
    private String hair_color;

    public HeroAppearance(String id, String name, String gender, String race, String eye_color, String hair_color) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.race = race;
        this.eye_color = eye_color;
        this.hair_color = hair_color;
    }

    public HeroAppearance() {
    }

    @Override
    public String toString() {
        return "HeroAppearance : " +"\n"+
//                "id :" + id  +"\n"+
                "name :" + name  +"\n"+
                "gender :" + gender  +"\n"+
                "race :" + race  +"\n"+
                "eye_color :" + eye_color  +"\n"+
                "hair_color :" + hair_color ;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }
}
