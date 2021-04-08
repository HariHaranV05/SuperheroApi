package com.example.herotoast;

public class HeroImage {
    private String id;
    private String name;
    private  String url;

    public HeroImage(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public HeroImage() {
    }

    @Override
    public String toString() {
        return "HeroImage : " +"\n"+
//                "id :" + id +"\n"+
                "name :" + name  +"\n"+
                "url :" + url ;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

