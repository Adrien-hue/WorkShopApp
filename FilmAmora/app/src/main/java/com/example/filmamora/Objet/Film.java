package com.example.filmamora.Objet;


public class Film {

    private String name;
    private String info;
    private int date;
    private int id;

    public Film(String name, int id, String info, int date){
        this.name = name;
        this.info = info;
        this.date = date;
        this.id = id;
    }

    public String getName() { return name; }

    public int getDate() { return date; }

    public int getId(){ return id; }

    public String getInfo(){ return info; }
}
