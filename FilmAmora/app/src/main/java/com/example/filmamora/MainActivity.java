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
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,2018));
        listFilm.add(new Film("Interstellar", 2,"Par Christopher Nolan" ,2014));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", 2017));
        listFilm.add(new Film("Matrix",4,"Par les Wachowski", 1999));
        listFilm.add(new Film("Her",5,"Par Spike Jonze", 2013));

        final ListView listView = findViewById(R.id.ListFilm);
        FilmAdapter = new FilmAdapter(this, listFilm);
        listView.setAdapter(new FilmAdapter(this, listFilm));

        triAnnee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                triAnnee(listFilm);
                FilmAdapter.update(listFilm);
            }
        });
    }
    public ArrayList triAnnee(ArrayList listFilm){
        int taille = listFilm.size();
        int i=0, j=0, min=0;
        for(i =1; i<taille; i++){
            Film f1 = (Film) listFilm.get(i);
            Film f2 = (Film) listFilm.get(i-1);
            //Film f3 = (Film) listFilm.get(j-1);
            if(f1.getDate() < f2.getDate()){
                j = i;
                min = f2.getId();
                Film f3 = (Film) listFilm.get(j-1);
                do{
                    //listFilm.get(j) = listFilm.get(j-1);
                    Collections.swap(listFilm, j, j-1);
                    j--;
                }while(j>0 && min < f3.getDate());
                //listFilm.get(j) = min;
                Collections.swap(listFilm, j, min);
            }
        }
        return listFilm;
    }


}
