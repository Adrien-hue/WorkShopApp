package com.example.filmamora;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.DetailsFilm.ReadyPlayerOne;
import com.example.filmamora.DetailsFilm.Valerian;
import com.example.filmamora.Objet.Film;
import com.example.filmamora.Objet.FilmComparator;
import com.example.filmamora.Objet.ProprieteFilm;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Film> listFilm;
    private TextView filmName;
    private TextView filmInfo;
    private TextView filmDate;
    private Button triAnnee;
    private Button triTitre;
    private TextView linkFilm;
    private FilmAdapter FilmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.linkFilm = findViewById(R.id.filmLink);
        linkFilm.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        this.filmDate = (TextView) findViewById(R.id.item_date);
        this.filmInfo = findViewById(R.id.item_info);
        this.filmName = findViewById(R.id.item_name);
        this.triAnnee = findViewById(R.id.btnTri2);
        this.triTitre = findViewById(R.id.btnTri1);

        //List des items
        this.listFilm = new ArrayList<Film>();
        listFilm.add(new Film("Interstellar", 1, "Par Christopher Nolan" , (long) 2014));
        listFilm.add(new Film("Ready Player One", 2,"Par Steven Spielberg" , (long) 2018));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", (long) 2017));
        listFilm.add(new Film("Matrix",4,"Par les Wachowski", (long) 1999));
        listFilm.add(new Film("Her",16,"Par Spike Jonze", (long) 2013));
        listFilm.add(new Film("TEST",14,"Par Spike Jonze", (long) 2019));

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
                    case 2:
                        Intent Steven = new Intent(getApplicationContext(), ReadyPlayerOne.class);
                        startActivity(Steven);
                        finish();
                        break;
                    case 3:
                        Intent valerian = new Intent(getApplicationContext(), Valerian.class);
                        startActivity(valerian);
                        finish();
                    default:
                        break;
            }
            }
        });
    }

    public void goToReal(View view) {
        Intent goToReal = new Intent(getApplicationContext(), ListRealisateur.class);
        startActivity(goToReal);
    }


}
