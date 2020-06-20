package com.example.filmamora.PageRealisateur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.Objet.Film;
import com.example.filmamora.R;

import java.util.ArrayList;

public class StevenSpielberg_list extends AppCompatActivity {

    private ArrayList<Film> listFilm;
    private TextView filmName;
    private TextView filmInfo;
    private TextView filmDate;
    private Button triAnnee;
    private Button triTitre;
    private FilmAdapter FilmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steven_spielberg_list);


        this.filmDate = (TextView) findViewById(R.id.item_date);
        this.filmInfo = findViewById(R.id.item_info);
        this.filmName = findViewById(R.id.item_name);


        //List des items
        this.listFilm = new ArrayList<Film>();
        listFilm.add(new Film("Ready Player One", 2, "Par Steven Spielberg" , (long) 2018));

        final ListView listView = findViewById(R.id.ListFilm);
        FilmAdapter = new FilmAdapter(this, listFilm);
        listView.setAdapter(new FilmAdapter(this, listFilm));
    }
}