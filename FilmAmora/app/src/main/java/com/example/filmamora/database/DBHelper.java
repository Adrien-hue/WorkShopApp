package com.example.filmamora.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private String film = "CREATE TABLE Film(id Int PRIMARY KEY AUTOINCREMENT  NOT NULL , titre Varchar (255) NOT NULL ,annee Date NOT NULL , synopsis Varchar (1000) NOT NULL)";
    private String personne = "CREATE TABLE personne( id Int PRIMARY KEY AUTOINCREMENT  NOT NULL , nom Varchar (50) NOT NULL , prenom Varchar (50) NOT NULL)";
    private String role = "CREATE TABLE role(id Int PRIMARY KEY AUTOINCREMENT  NOT NULL , libelle Varchar (255) NOT NULL)";
    private String avis =  "CREATE TABLE avis(id Int PRIMARY KEY AUTOINCREMENT NOT NULL , note Int NOT NULL , commentaire Varchar (1000) NOT NULL , id_Film Int REFERENCES Film(id) UNIQUE NOT NULL)";
    private String participe =  "CREATE TABLE participe(id Int REFERENCES personne(id) PRIMARY KEY NOT NULL, id_Film Int REFERENCES Film(id) PRIMARY KEY  NOT NULL , id_role Int REFERENCES role(id) PRIMARY KEY  NOT NULL)";



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
