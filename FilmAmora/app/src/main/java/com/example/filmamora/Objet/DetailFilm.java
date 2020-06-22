package com.example.filmamora.Objet;

import java.util.ArrayList;

public class DetailFilm {

    private int idFilm;
    private String titre;
    private Long annee;
    private String real_p;
    private String real_nom;
    private String synopsis;
    private int aNote;
    private String aCommentaire;


    public DetailFilm(int idFilm, String titre, Long annee, String real_p, String real_nom, String synopsis, int aNote, String aCommentaire) {
        this.idFilm = idFilm;
        this.titre = titre;
        this.annee = annee;
        this.real_p = real_p;
        this.real_nom = real_nom;
        this.synopsis = synopsis;
        this.aNote = aNote;
        this.aCommentaire = aCommentaire;
    }


    public int getIdFilm() {
        return idFilm;
    }

    public String getTitre() {
        return titre;
    }

    public Long getAnnee() {
        return annee;
    }

    public String getReal_p() {
        return real_p;
    }

    public String getReal_nom() {
        return real_nom;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getaNote() {
        return aNote;
    }

    public String getaCommentaire() {
        return aCommentaire;
    }
}
