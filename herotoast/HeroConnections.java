package com.example.herotoast;

public class HeroConnections {
    private String id;
    private String name;
    private String group_affiliation;
    private String relatives;

    public HeroConnections(String id, String name, String group_affiliation, String relatives) {
        this.id = id;
        this.name = name;
        this.group_affiliation = group_affiliation;
        this.relatives = relatives;
    }

    public HeroConnections() {
    }

    @Override
    public String toString() {
        return "HeroConnections : " +"\n"+
//                "id :" + id +"\n"+
                "name :" + name  +"\n"+
                "group_affiliation :" + group_affiliation  +"\n"+
                "relatives :" + relatives;
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

    public String getGroup_affiliation() {
        return group_affiliation;
    }

    public void setGroup_affiliation(String group_affiliation) {
        this.group_affiliation = group_affiliation;
    }

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }
}
