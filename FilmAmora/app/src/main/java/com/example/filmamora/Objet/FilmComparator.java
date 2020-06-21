package com.example.filmamora.Objet;

import java.util.Comparator;

public class FilmComparator implements Comparator<Film> {

    private ProprieteFilm proprieteTri;

    public FilmComparator(ProprieteFilm prop){
        super();
        this.proprieteTri = prop;
    }

    @Override
    public int compare(Film film, Film t1) {
        int result = 0;
        if (proprieteTri == ProprieteFilm.TITRE){
            result = film.getTitre().compareTo(t1.getTitre());
        }
        else if (proprieteTri == ProprieteFilm.ANNEE){
            result = film.getAnnee().compareTo(t1.getAnnee());
        }
        return result;
    }
}
