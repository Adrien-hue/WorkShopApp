package com.example.filmamora.Objet;

public class Personne {
    private int id;
    private String nom;
    private String prenom;


    public Personne(int id, String prenom, String nom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
