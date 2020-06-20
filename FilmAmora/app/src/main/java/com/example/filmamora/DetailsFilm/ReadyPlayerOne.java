package com.example.filmamora.DetailsFilm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.filmamora.MainActivity;
import com.example.filmamora.R;

public class ReadyPlayerOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_player_one);



    }

    public void backHome(View view) {
        Intent backHome = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(backHome);
        finish();
    }
}