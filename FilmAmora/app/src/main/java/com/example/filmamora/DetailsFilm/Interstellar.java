package com.example.filmamora.DetailsFilm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.filmamora.MainActivity;
import com.example.filmamora.R;

public class Interstellar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstellar);



    }

    public void backHome(View view) {
        Intent backHome = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(backHome);
        finish();
    }
}
