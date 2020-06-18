package com.example.filmamora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



    }

    public void returnLobby(View view) {
        Intent returnLobby = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(returnLobby);
        finish();
    }
}