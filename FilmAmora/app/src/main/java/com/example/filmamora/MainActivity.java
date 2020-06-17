package com.example.filmamora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filmamora.Adapter.film_adapter;
import com.example.filmamora.Objet.Film;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List des items
        List<Film> listFilm = new ArrayList<Film>();
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
        listView.setAdapter(new film_adapter(this, listFilm));






    }
}