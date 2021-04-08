package com.example.herotoast;

public class HeroWork {
    private String id;
    private String name;
    private String occupation;
    private String base;

    public HeroWork(String id, String name, String occupation, String base) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
        this.base = base;
    }

    public HeroWork() {
    }

    @Override
    public String toString() {
        return "HeroWork :" +"\n"+
//                "id :" + id +"\n"+
                "name :" + name  +"\n"+
                "occupation :" + occupation+"\n"+
                "base :" + base ;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
