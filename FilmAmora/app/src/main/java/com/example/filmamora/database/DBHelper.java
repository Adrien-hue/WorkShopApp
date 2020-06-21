package com.example.filmamora.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private String film = "CREATE TABLE Film(id integer  PRIMARY KEY AUTOINCREMENT  NOT NULL , titre Varchar (255) NOT NULL , annee Int NOT NULL , synopsis Varchar (1000) NOT NULL);";
    private String personne = "CREATE TABLE personne( id integer PRIMARY KEY AUTOINCREMENT  NOT NULL , nom Varchar (50) NOT NULL , prenom Varchar (50) NOT NULL);";
    private String role = "CREATE TABLE role(id integer PRIMARY KEY AUTOINCREMENT  NOT NULL , libelle Varchar (255) NOT NULL);";
    private String avis =  "CREATE TABLE avis(id integer PRIMARY KEY AUTOINCREMENT NOT NULL , note Int NOT NULL , commentaire Varchar (1000) NOT NULL , id_Film Int REFERENCES Film(id) UNIQUE NOT NULL);";
    private String participe =  "CREATE TABLE participe(id integer REFERENCES personne(id) NOT NULL, id_Film integer REFERENCES Film(id) NOT NULL , id_role integer REFERENCES role(id) NOT NULL, PRIMARY KEY(id, id_Film, id_role));";



    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(film);
        sqLiteDatabase.execSQL(personne);
        sqLiteDatabase.execSQL(role);
        sqLiteDatabase.execSQL(avis);
        sqLiteDatabase.execSQL(participe);
    }

    /**
     * Called when update database to newer version
     * @param sqLiteDatabase
     * @param i old version number
     * @param i1 new version number
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
