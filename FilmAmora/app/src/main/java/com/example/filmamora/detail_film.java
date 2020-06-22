package com.example.filmamora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filmamora.Adapter.ActorAdapter;
import com.example.filmamora.Adapter.FilmAdapter;
import com.example.filmamora.Adapter.RealAdapter;
import com.example.filmamora.Objet.DetailFilm;
import com.example.filmamora.Objet.Film;
import com.example.filmamora.Objet.Personne;
import com.example.filmamora.database.DBManager;

import java.util.ArrayList;

public class detail_film extends AppCompatActivity {

    private ArrayList<Personne> listActeurs;
    private DBManager c3po;
    private ActorAdapter ActorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        c3po = new DBManager(this);

        Bundle extras = getIntent().getExtras();
        String idFi = extras.getString("idFilm");
        int idFilm = Integer.parseInt(idFi);

        Log.d("IDFilm : ", "" +idFilm);

        DetailFilm d = c3po.getDetailsFilm(idFilm);
        c3po.getActeur(idFilm);


        TextView Titre = findViewById(R.id.item_TitreFilm);
        Titre.setText(d.getTitre());

        TextView Date = findViewById(R.id.item_Date);
        Date.setText("Sorti en "+ d.getAnnee());

        TextView RealisateurP = findViewById(R.id.item_RealisateurPrenom);
        RealisateurP.setText(d.getReal_p());

        TextView RealisateurN = findViewById(R.id.item_RealisateurNom);
        RealisateurN.setText(d.getReal_nom());

        ImageView itemImageView = findViewById(R.id.item_imageId);
        String ressourceName = "item_" + d.getIdFilm();

        int resId = this.getResources().getIdentifier(ressourceName, "drawable", this.getPackageName());
        itemImageView.setImageResource(resId);

        TextView syno = findViewById(R.id.item_synopsis);
        syno.setText(d.getSynopsis());

        this.listActeurs = c3po.getActeur(idFilm);

        final ListView listView = findViewById(R.id.listActeurs);
        ActorAdapter = new ActorAdapter(this, listActeurs);
        listView.setAdapter(new ActorAdapter(this, listActeurs));

        TextView note = findViewById(R.id.item_note);

        if(d.getaNote() == 0){
            note.setText("Pas de note");
        }else {
            note.setText(d.getaNote() + "/10");
        }

        TextView critique = findViewById(R.id.item_critique);

        if(d.getaCommentaire() == null){
            critique.setText("Pas de critique");
        }else {
            critique.setText(d.getaCommentaire());
        }


    }

    public void backHome(View view){
        Intent goBackFilm = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goBackFilm);
    }
}