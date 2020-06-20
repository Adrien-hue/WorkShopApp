package com.example.filmamora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.Adapter.RealAdapter;
import com.example.filmamora.DetailsFilm.ReadyPlayerOne;
import com.example.filmamora.Objet.Realisateur;

import java.util.ArrayList;

public class ListRealisateur extends AppCompatActivity {

    private TextView parReal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_realisateur);

        //Permet de souligner le text pour montrer où il se trouve

        this.parReal = findViewById(R.id.parreal);
        parReal.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        final ArrayList<Realisateur> listReal = new ArrayList<Realisateur>();

        listReal.add(new Realisateur(1, "Steven Spielberg"));
        listReal.add(new Realisateur(2, "Christopher Nolan"));
        listReal.add(new Realisateur(4, "Luc Besson"));
        listReal.add(new Realisateur(5, "Spike Jonze"));

        final ListView listView = findViewById(R.id.ListRealisateur);

        listView.setAdapter(new RealAdapter(this, listReal));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                long realisateur = listView.getItemIdAtPosition(position);
                Log.d("mainActivity", "" + realisateur);

                switch ((int) realisateur){
                    case 1:
                        Intent Steven = new Intent(getApplicationContext(), ReadyPlayerOne.class);
                        startActivity(Steven);
                        finish();
                        break;
                    case 2:  Intent Christopher = new Intent(getApplicationContext(), ReadyPlayerOne.class);
                        startActivity(Christopher);
                        finish();;
                        break;
                    case 3:  Intent Luc = new Intent(getApplicationContext(), ReadyPlayerOne.class);
                        startActivity(Luc);
                        finish();;
                        break;
                    case 4:  Intent Spike = new Intent(getApplicationContext(), ReadyPlayerOne.class);
                        startActivity(Spike);
                        finish();;
                        break;
                    default:
                        break;
                }


            }
        });
    }

    public void backHome(View view) {
        Intent backHome = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(backHome);
        finish();
    }
}