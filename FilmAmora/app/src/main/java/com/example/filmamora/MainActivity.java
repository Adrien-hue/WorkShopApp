package com.example.filmamora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.Objet.Film;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private TextView filmName;
    private TextView filmInfo;
    private TextView filmDate;
    private Button triAnnee;
    private FilmAdapter FilmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.filmDate = (TextView) findViewById(R.id.item_date);
        this.filmInfo = findViewById(R.id.item_info);
        this.filmName = findViewById(R.id.item_name);
        this.triAnnee = findViewById(R.id.btnTri2);

        //List des items
        final ArrayList <Film> listFilm = new ArrayList<Film>();
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" , (long) 2018));
        listFilm.add(new Film("Interstellar", 2,"Par Christopher Nolan" , (long) 2014));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", (long) 2017));
        listFilm.add(new Film("Matrix",4,"Par les Wachowski", (long) 1999));
        listFilm.add(new Film("Her",5,"Par Spike Jonze", (long) 2013));
        listFilm.add(new Film("TEST",6,"Par Spike Jonze", (long) 2019));

        final ListView listView = findViewById(R.id.ListFilm);
        FilmAdapter = new FilmAdapter(this, listFilm);
        listView.setAdapter(new FilmAdapter(this, listFilm));

        triAnnee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Collections.sort(listFilm);
                FilmAdapter.update(listFilm);
            }
        });
    }
}
