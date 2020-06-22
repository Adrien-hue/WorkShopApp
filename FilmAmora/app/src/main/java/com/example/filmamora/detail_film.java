package com.example.filmamora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.filmamora.database.DBManager;

public class detail_film extends AppCompatActivity {

    private DBManager c3po;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        c3po = new DBManager(this);


        Bundle extras = getIntent().getExtras();
        String idFi = extras.getString("idFilm");
        int idFilm = Integer.parseInt(idFi);

        Log.d("IDFilm : ", "" +idFilm);


    }
}