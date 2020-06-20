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

import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.DetailsFilm.ReadyPlayerOne;
import com.example.filmamora.ListRealisateur;
import com.example.filmamora.MainActivity;
import com.example.filmamora.Objet.Film;
import com.example.filmamora.Objet.FilmComparator;
import com.example.filmamora.Objet.ProprieteFilm;
import com.example.filmamora.R;

import java.util.ArrayList;

public class SpikeJonze extends AppCompatActivity {

    private ArrayList<Film> listFilm;
    private Button triAnnee;
    private Button triTitre;
    private com.example.filmamora.Adapter.FilmAdapter FilmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spike_jonze);

        this.triAnnee = findViewById(R.id.btnTri2);
        this.triTitre = findViewById(R.id.btnTri1);


        //List des items
        this.listFilm = new ArrayList<Film>();
        listFilm.add(new Film("Her",16,"Par Spike Jonze", (long) 2013));

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
                    case 16:
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
    public void goToReal(View view) {
        Intent goToReal = new Intent(getApplicationContext(), ListRealisateur.class);
        startActivity(goToReal);
    }

    public void goBackFilm(View view){
        Intent goBackFilm = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goBackFilm);
    }
}
