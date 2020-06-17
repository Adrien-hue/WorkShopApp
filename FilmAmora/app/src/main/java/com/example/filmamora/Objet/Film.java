package com.example.filmamora.Objet;

public class Film {

    public String name;
    public String info;
    public String date;
    public int id;

    public Film(String name, int id, String info, String date){
        this.name = name;
        this.info = info;
        this.date = date;
        this.id = id;
    }

    public String getName() { return name; }

    public String getDate() { return date; }

    public int getId(){ return id; }

    public String getInfo(){ return info; }
}
