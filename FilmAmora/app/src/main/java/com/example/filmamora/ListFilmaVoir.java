package com.example.filmamora;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.Objet.Film;
import com.example.filmamora.Objet.FilmComparator;
import com.example.filmamora.Objet.ProprieteFilm;
import com.example.filmamora.database.DBManager;

import java.util.ArrayList;

public class ListFilmaVoir extends AppCompatActivity {

    private ArrayList<Film> listFilm;
    private Button triAnnee;
    private Button triTitre;
    private ListView listView;
    private TextView linkFilm;
    private com.example.filmamora.Adapter.FilmAdapter filmAdapter;
    private DBManager c3po;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_filma_voir);

        //Create db manager
        c3po = new DBManager(this);


        this.linkFilm = findViewById(R.id.filmavoir);
        linkFilm.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        this.triAnnee = findViewById(R.id.btnTri2);
        this.triTitre = findViewById(R.id.btnTri1);

        //List des items
        this.listFilm = c3po.getFilmaVoir();

        listView = findViewById(R.id.ListFilm);
        filmAdapter = new FilmAdapter(this, listFilm);
        listView.setAdapter(filmAdapter);

        triAnnee.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                listFilm.sort(new FilmComparator(ProprieteFilm.ANNEE));
                filmAdapter.update(listFilm);
            }
        });

        triTitre.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                listFilm.sort(new FilmComparator(ProprieteFilm.TITRE));
                filmAdapter.update(listFilm);
            }
        });


        //Item clickable ======================================================================================
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                long idFilm = listView.getItemIdAtPosition(position);
                Log.d("mainActivity", ""+ idFilm);

                Intent detailFilms = new Intent(getApplicationContext(), detail_film.class);
                Bundle extras = new Bundle();
                extras.putString("idFilm", idFilm + "");
                detailFilms.putExtras(extras);
                startActivity(detailFilms);
                finish();

            }

        });
    }

    public void goToReal(View view) {
        Intent goToReal = new Intent(getApplicationContext(), ListRealisateur.class);
        startActivity(goToReal);
    }


    public void filmAvoir(View view) {
        Intent goToAvoir = new Intent(getApplicationContext(), ListFilmaVoir.class);
        startActivity(goToAvoir);
        finish();
    }

    public void listFilm(View view) {
        Intent gotoFilm = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(gotoFilm);
        finish();
    }

}
