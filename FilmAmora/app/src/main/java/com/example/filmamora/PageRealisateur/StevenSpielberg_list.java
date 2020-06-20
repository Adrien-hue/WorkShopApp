package com.example.filmamora.PageRealisateur;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.DetailsFilm.ReadyPlayerOne;
import com.example.filmamora.Objet.Film;
import com.example.filmamora.Objet.FilmComparator;
import com.example.filmamora.Objet.ProprieteFilm;
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
        this.triAnnee = findViewById(R.id.btnTri2);
        this.triTitre = findViewById(R.id.btnTri1);


        //List des items
        this.listFilm = new ArrayList<Film>();
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" , (long) 2018));

        final ListView listView = findViewById(R.id.ListFilm);
        FilmAdapter = new FilmAdapter(this, listFilm);
        listView.setAdapter(new FilmAdapter(this, listFilm));

        triAnnee.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                listFilm.sort(new FilmComparator(ProprieteFilm.DATE));
                FilmAdapter.update(listFilm);
            }
        });

        triTitre.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                listFilm.sort(new FilmComparator(ProprieteFilm.NAME));
                FilmAdapter.update(listFilm);
            }
        });


        //Item clickable ======================================================================================
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                long film = listView.getItemIdAtPosition(position);
                Log.d("mainActivity", ""+ film);

                switch ((int) film){
                    case 1:
                        Intent rdy = new Intent(getApplicationContext(), ReadyPlayerOne.class);
                        startActivity(rdy);
                        finish();
                        break;
                    default:
                        break;
                }
            }
        });
    }
    }
