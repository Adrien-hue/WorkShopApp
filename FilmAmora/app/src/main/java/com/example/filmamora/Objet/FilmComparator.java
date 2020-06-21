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
            result = film.getName().compareTo(t1.getName());
        }
        else if (proprieteTri == ProprieteFilm.ANNEE){
            result = film.getDate().compareTo(t1.getDate());
        }
        return result;
    }
}
