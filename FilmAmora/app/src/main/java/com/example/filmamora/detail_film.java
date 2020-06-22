package com.example.filmamora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.filmamora.Adapter.DetailAdapter;
import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.Objet.DetailFilm;
import com.example.filmamora.Objet.Film;
import com.example.filmamora.database.DBManager;

import java.util.ArrayList;

public class detail_film extends AppCompatActivity {

    private ArrayList<DetailFilm> listDetail;
    private DBManager c3po;
    private DetailAdapter detailAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        c3po = new DBManager(this);

        Bundle extras = getIntent().getExtras();
        String idFi = extras.getString("idFilm");
        int idFilm = Integer.parseInt(idFi);

        Log.d("IDFilm : ", "" +idFilm);

        this.listDetail = c3po.getDetailsFilm(idFilm);

        final ListView listView = findViewById(R.id.detailList);

        detailAdapter = new DetailAdapter(this, listDetail);
        listView.setAdapter(new DetailAdapter(this, listDetail));






    }
}