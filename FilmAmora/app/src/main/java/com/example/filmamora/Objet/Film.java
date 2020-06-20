package com.example.filmamora.Objet;


public class Film{

    private final String name;
    private String info;
    private final Long date;
    private int id;

    public Film(String name, int id, String info, Long date){
        this.name = name;
        this.info = info;
        this.date = date;
        this.id = id;
    }

    public String getName() { return name; }

    public Long getDate() { return date; }

    public int getId(){ return id; }

    public String getInfo(){ return info; }

}
