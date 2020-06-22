package com.example.filmamora.Objet;


import java.util.ArrayList;

public class Film{

    private int id;
    private final String titre;
    private final Long annee;
    private String synopsis;
    private int aVoir;
    private int note;
    private String p_nom;
    private String p_prenom;
    private String critique;
    private ArrayList<Acteur> Acteurs;




    public Film(int id, String titre, Long annee, String synopsis, int aVoir, int note, String critique, ArrayList<Acteur> acteurs) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.synopsis = synopsis;
        this.aVoir = aVoir;
        this.note = note;
        this.critique = critique;
        Acteurs = acteurs;
    }

    public Film(int id, String titre, Long annee, String p_prenom, String p_nom, int aVoir) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.p_prenom = p_prenom;
        this.p_nom = p_nom;
        this.aVoir = aVoir;
    }

    public Film(int id, String titre, Long annee, String synopsis, int aVoir, int note, String critique) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.synopsis = synopsis;
        this.aVoir = aVoir;
        this.note = note;
        this.critique = critique;
    }

    public String getP_nom() {
        return p_nom;
    }

    public String getP_prenom() {
        return p_prenom;
    }
    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public Long getAnnee() {
        return annee;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getaVoir() {
        return aVoir;
    }

    public int getNote() {
        return note;
    }

    public String getCritique() {
        return critique;
    }

    public ArrayList<Acteur> getActeurs() {
        return Acteurs;
    }
}
