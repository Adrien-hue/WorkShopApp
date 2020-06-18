package com.example.filmamora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.Objet.Film;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List des items
        List <Film> listFilm = new ArrayList<Film>();
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,"Le 26 mars 2018"));
        listFilm.add(new Film("interstellar", 2,"Par Christopher Nolan" ,"Le 5 novembre 2014"));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", "Le 26 juillet 2017"));
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,"Le 26 mars 2018"));
        listFilm.add(new Film("interstellar", 2,"Par Christopher Nolan" ,"Le 5 novembre 2014"));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", "Le 26 juillet 2017"));
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,"Le 26 mars 2018"));
        listFilm.add(new Film("interstellar", 2,"Par Christopher Nolan" ,"Le 5 novembre 2014"));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", "Le 26 juillet 2017"));
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,"Le 26 mars 2018"));
        listFilm.add(new Film("interstellar", 2,"Par Christopher Nolan" ,"Le 5 novembre 2014"));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", "Le 26 juillet 2017"));
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,"Le 26 mars 2018"));
        listFilm.add(new Film("interstellar", 2,"Par Christopher Nolan" ,"Le 5 novembre 2014"));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", "Le 26 juillet 2017"));
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,"Le 26 mars 2018"));
        listFilm.add(new Film("interstellar", 2,"Par Christopher Nolan" ,"Le 5 novembre 2014"));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", "Le 26 juillet 2017"));


        ListView listView = findViewById(R.id.ListFilm);
        // permet de trier la liste des films
        //Collections.sort(listFilm, Collections.reverseOrder((Comparator<Object>) listFilm));

        listView.setAdapter(new FilmAdapter(this, listFilm));






    }
}