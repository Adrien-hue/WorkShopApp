package com.example.filmamora;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.filmamora.Objet.Film;
import java.util.ArrayList;

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
        final ArrayList <Film> listFilm = new ArrayList<Film>();
        listFilm.add(new Film("Ready Player One", 1, "Par Steven Spielberg" ,2018));
        listFilm.add(new Film("Interstellar", 2,"Par Christopher Nolan" ,2014));
        listFilm.add(new Film("Valérian et la cité des mille planètes",3,"Par Luc Besson", 2017));
        listFilm.add(new Film("Matrix",4,"Par les Wachowski", 1999));
        listFilm.add(new Film("Her",5,"Par Spike Jonze", 2013));


        final ListView listView = findViewById(R.id.ListFilm);

        listView.setAdapter(new FilmAdapter(this, listFilm));



        //Item clickable ======================================================================================
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                long film = listView.getItemIdAtPosition(position);
                Log.d("mainActivity", ""+ film);

                if(film == 1){
                    Intent rdy = new Intent(getApplicationContext(), ReadyPlayerOne.class);
                    startActivity(rdy);

                }else if(film == 2){


                }else if(film == 2){

                }else if(film == 3){

                }else if(film == 4){

                }else if(film == 5){

                }
            }
        });

    }

    public void goToReal(View view) {
        Intent goToReal = new Intent(getApplicationContext(), ListRealisateur.class);
        startActivity(goToReal);
    }
}
