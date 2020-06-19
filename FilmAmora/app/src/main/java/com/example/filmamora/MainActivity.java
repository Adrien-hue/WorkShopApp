package com.example.filmamora;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.Objet.Film;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView filmName;
    private TextView filmInfo;
    private TextView filmDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.filmDate = (TextView) findViewById(R.id.item_date);
        this.filmInfo = findViewById(R.id.item_info);
        this.filmName = findViewById(R.id.item_name);

        //List des items
        ArrayList <Film> listFilm = new ArrayList<Film>();
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,2018));
        listFilm.add(new Film("Interstellar", 2,"Par Christopher Nolan" ,2014));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", 2017));
        listFilm.add(new Film("Matrix",4,"Par les Wachowski", 1999));
        listFilm.add(new Film("Her",5,"Par Spike Jonze", 2013));

        ListView listView = findViewById(R.id.ListFilm);

        // permet de trier la liste des films
        //Collections.sort(listFilm, Collections.reverseOrder((Comparator<Object>) listFilm));

        listView.setAdapter(new FilmAdapter(this, listFilm));

    }
    public ArrayList triAnnee(ArrayList listFilm){
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
                }while(j>0 && min<listFilm.get(j-1);
                listFilm(j) = min;
            }
        }
        return listFilm;
    }
}