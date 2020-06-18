package com.example.filmamora;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.Objet.Film;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView filmName;
    private TextView filmInfo;
    private TextView filmDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.filmDate = (TextView) findViewById(R.id.item_date);
        this.filmInfo = findViewById(R.id.item_info);
        this.filmName = findViewById(R.id.item_name);

        //List des items
        List <Film> listFilm = new ArrayList<Film>();
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,"Le 26 mars 2018"));
        listFilm.add(new Film("Interstellar", 2,"Par Christopher Nolan" ,"Le 5 novembre 2014"));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", "Le 26 juillet 2017"));
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,"Le 26 mars 2018"));
        listFilm.add(new Film("Interstellar", 2,"Par Christopher Nolan" ,"Le 5 novembre 2014"));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", "Le 26 juillet 2017"));
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,"Le 26 mars 2018"));
        listFilm.add(new Film("Interstellar", 2,"Par Christopher Nolan" ,"Le 5 novembre 2014"));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", "Le 26 juillet 2017"));
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,"Le 26 mars 2018"));
        listFilm.add(new Film("Interstellar", 2,"Par Christopher Nolan" ,"Le 5 novembre 2014"));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", "Le 26 juillet 2017"));
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,"Le 26 mars 2018"));
        listFilm.add(new Film("Interstellar", 2,"Par Christopher Nolan" ,"Le 5 novembre 2014"));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", "Le 26 juillet 2017"));
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,"Le 26 mars 2018"));
        listFilm.add(new Film("Interstellar", 2,"Par Christopher Nolan" ,"Le 5 novembre 2014"));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", "Le 26 juillet 2017"));



        ListView listView = findViewById(R.id.ListFilm);

        // permet de trier la liste des films
        //Collections.sort(listFilm, Collections.reverseOrder((Comparator<Object>) listFilm));

        listView.setAdapter(new FilmAdapter(this, listFilm));







    }
}