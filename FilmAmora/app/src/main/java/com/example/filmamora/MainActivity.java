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
import com.example.filmamora.DetailsFilm.Interstellar;
import com.example.filmamora.DetailsFilm.ReadyPlayerOne;
import com.example.filmamora.DetailsFilm.Valerian;
import com.example.filmamora.Objet.Film;
import com.example.filmamora.Objet.FilmComparator;
import com.example.filmamora.Objet.ProprieteFilm;
import com.example.filmamora.database.DBManager;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Film> listFilm;
    private Button triAnnee;
    private Button triTitre;
    private TextView linkFilm;
    private FilmAdapter FilmAdapter;
    private DBManager c3po;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create db manager
        c3po = new DBManager(this);


        this.linkFilm = findViewById(R.id.filmLink);
        linkFilm.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        this.triAnnee = findViewById(R.id.btnTri2);
        this.triTitre = findViewById(R.id.btnTri1);

        //List des items
       this.listFilm = c3po.getAllFilm();

        final ListView listView = findViewById(R.id.ListFilm);
        FilmAdapter = new FilmAdapter(this, listFilm);
        listView.setAdapter(new FilmAdapter(this, listFilm));

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


        //Item clickable ======================================================================================
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                long film = listView.getItemIdAtPosition(position);
                Log.d("mainActivity", ""+ film);

                switch ((int) film){
                    case 1:
                        Intent interstellar = new Intent(getApplicationContext(), Interstellar.class);
                        startActivity(interstellar);
                        finish();
                        break;

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
