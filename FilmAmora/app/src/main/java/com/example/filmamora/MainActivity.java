package com.example.filmamora;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.Objet.Film;
import com.example.filmamora.Objet.FilmComparator;
import com.example.filmamora.Objet.ProprieteFilm;
import com.example.filmamora.database.DBManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Film> listFilm;
    private Button triAnnee;
    private Button triTitre;
    private TextView linkFilm;
    private FilmAdapter filmAdapter;
    private DBManager c3po;
    private ListView listView;

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

        listView = findViewById(R.id.ListFilm);

        filmAdapter = new FilmAdapter(this, listFilm);



        listView.setAdapter(filmAdapter);

        triAnnee.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Log.d("onClickAnnee", "clickAnnee");
                listFilm.sort(new FilmComparator(ProprieteFilm.ANNEE));
                filmAdapter.update(listFilm);
            }
        });

        triTitre.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Log.d("onClickTitre", "clickTitre");
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
   /* public ArrayList triAnnee(ArrayList listFilm){
        int taille = listFilm.size();
        int i, j, min;
        for(i =1; i<taille; i++){
            Film f1 = (Film) listFilm.get(i);
            Film f2 = (Film) listFilm.get(i-1);
            if(f1.getDate() < f2.getDate()){
                j = i;
                min = f2.getId();
                do{
                    listFilm.get(j) = listFilm.get(j-1);
                }while(j>0 && min<listFilm.get(j-1));
                listFilm(j) = min;
            }
        }
        return listFilm;
    }*/
}
