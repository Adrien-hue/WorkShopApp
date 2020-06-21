package com.example.filmamora;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.Objet.Film;
import com.example.filmamora.Objet.FilmComparator;
import com.example.filmamora.Objet.ProprieteFilm;
import com.example.filmamora.database.DBManager;

import java.util.ArrayList;

public class list_film_par_Realisateur extends AppCompatActivity {


    private ArrayList<Film> listFilm;
    private Button triAnnee;
    private Button triTitre;
    private com.example.filmamora.Adapter.FilmAdapter FilmAdapter;
    private DBManager c3po;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_film_par__realisateur);

        this.triAnnee = findViewById(R.id.btnTri2);
        this.triTitre = findViewById(R.id.btnTri1);

        triAnnee.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                listFilm.sort(new FilmComparator(ProprieteFilm.ANNEE));
                FilmAdapter.update(listFilm);
            }
        });

        triTitre.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                listFilm.sort(new FilmComparator(ProprieteFilm.TITRE));
                FilmAdapter.update(listFilm);
            }
        });

        Intent intent = getIntent();

        if (intent != null){

            if (intent.hasExtra("idRealisateur")){
                int idRealisateur = intent.getIntExtra("idRealisateur", 0);
                this.listFilm = c3po.getFilmParReal(idRealisateur);

                final ListView listView = findViewById(R.id.ListFilm);
                FilmAdapter = new FilmAdapter(this, listFilm);
                listView.setAdapter(new FilmAdapter(this, listFilm));

            }

        }





    }
}