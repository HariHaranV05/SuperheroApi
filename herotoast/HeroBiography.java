package com.example.herotoast;

public class HeroBiography {
    private String id;
    private String name;
    private String full_name;
    private String alter_egos;
    private String place_of_birth;
    private String first_appearance;
    private  String publisher;
    private String alignment;

    public HeroBiography(String id, String name, String full_name, String alter_egos, String place_of_birth, String first_appearance, String publisher, String alignment) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.alter_egos = alter_egos;
        this.place_of_birth = place_of_birth;
        this.first_appearance = first_appearance;
        this.publisher = publisher;
        this.alignment = alignment;
    }

    public HeroBiography() {
    }

    @Override
    public String toString() {
        return "HeroBiography : " +"\n"+
//                "id :" + id +"\n"+
                "name :" + name  +"\n"+
                "full_name :" + full_name  +"\n"+
                "alter_egos :" + alter_egos +"\n"+
                "place_of_birth :" + place_of_birth  +"\n"+
                "first_appearance :" + first_appearance +"\n"+
                "publisher :" + publisher  +"\n"+
                "alignment :" + alignment  +"\n"
                ;
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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAlter_egos() {
        return alter_egos;
    }

    public void setAlter_egos(String alter_egos) {
        this.alter_egos = alter_egos;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getFirst_appearance() {
        return first_appearance;
    }

    public void setFirst_appearance(String first_appearance) {
        this.first_appearance = first_appearance;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }
}

