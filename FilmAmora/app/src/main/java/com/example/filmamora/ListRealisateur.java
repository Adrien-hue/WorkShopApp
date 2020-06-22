package com.example.filmamora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filmamora.Adapter.RealAdapter;
import com.example.filmamora.Objet.Personne;
import com.example.filmamora.database.DBManager;

import java.util.ArrayList;

public class ListRealisateur extends AppCompatActivity {

    private TextView parReal;
    private RealAdapter RealAdapter;
    private ArrayList<Personne> listRealisateur;
    private DBManager c3po;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_realisateur);

        c3po = new DBManager(this);

        //Permet de souligner le text pour montrer où il se trouve

        this.parReal = findViewById(R.id.parreal);
        parReal.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        //list realisateur
        this.listRealisateur = c3po.getAllRealisateur();

        final ListView listView = findViewById(R.id.ListRealisateur);

        RealAdapter = new RealAdapter(this, listRealisateur);

        listView.setAdapter(new RealAdapter(this, listRealisateur));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                long realisateur = listView.getItemIdAtPosition(position);
                Log.d("mainActivity", "" + realisateur);

                        Intent ListFilm_par_Realisateur = new Intent(getApplicationContext(), list_film_par_Realisateur.class);
                        Bundle extras = new Bundle();
                        extras.putString("idRealisateur", realisateur + "");
                        ListFilm_par_Realisateur.putExtras(extras);
                        startActivity(ListFilm_par_Realisateur);
                        startActivity(ListFilm_par_Realisateur);
                        finish();

            }
        });
    }

    public void goBackFilm(View view){
        Intent goBackFilm = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goBackFilm);
    }

}