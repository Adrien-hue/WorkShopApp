package com.example.filmamora.Objet;


public class Film{

    private int id;
    private final String titre;
    private final Long annee;
    private int aVoir;
    private String p_nom;
    private String p_prenom;


    public Film(int id, String titre, Long annee, String p_prenom, String p_nom, int aVoir) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.p_prenom = p_prenom;
        this.p_nom = p_nom;
        this.aVoir = aVoir;
    }

    public Film(int id, String titre, Long annee, String p_prenom, String p_nom) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.p_prenom = p_prenom;
        this.p_nom = p_nom;
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

    public int getaVoir() {
        return aVoir;
    }

}
