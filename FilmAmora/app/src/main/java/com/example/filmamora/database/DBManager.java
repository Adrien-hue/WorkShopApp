package com.example.filmamora.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.filmamora.Objet.Film;
import com.example.filmamora.Objet.Realisateur;

import java.util.ArrayList;

public class DBManager {

    private static final String DB_NAME = "films.sqlite";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase db;
    private DBHelper r2d2;

    public DBManager(Context context){
        r2d2 = new DBHelper(context, DB_NAME, null, DB_VERSION);

    }

    public void addNewCritiqueToDB(Film f){
        db = r2d2.getWritableDatabase();
        String sqlQuery = "";
        //Log.d(TAG, sqlQuery);
        db.execSQL(sqlQuery);
    }
    public ArrayList<Film> getAllFilm(){
        ArrayList<Film> results = new ArrayList<>();
<<<<<<< Updated upstream
        String sqlQuery = "";
=======
        String sqlQuery = "SELECT f.id, f.titre, f.annee, f.aVoir, pe.prenom, pe.nom FROM Film f LEFT JOIN Avis a ON f.id = a.id_Film LEFT JOIN Participe pa ON pa.id_Film = f.id LEFT JOIN Personne pe ON pe.id = pa.id WHERE pa.id_role=2;";

>>>>>>> Stashed changes
        //Log.d(TAG, sqlQuery);

        //Get database
        db = r2d2.getReadableDatabase();

        //Execute query and get response
        Cursor c = db.rawQuery(sqlQuery, null);

        //Init cursor to first row
        if(!c.moveToFirst()){
           // Log.v(TAG, "There are no products in the database");
        }else{
            do{
                //Add new film to list
                results.add(new Film(c.getInt(1), c.getString(2), c.getLong(3),c.getString(4), c.getInt(5), c.getInt(6), c.getString(7)));
            }while(c.moveToNext());
        }

        c.close();
        return results;
    }

<<<<<<< Updated upstream
    public ArrayList<Realisateur> getAllPeople(){
        ArrayList<Realisateur> results = new ArrayList<>();
        String sqlQuery = "";
=======
    public ArrayList<Realisateur> getAllRealisateur() {
        ArrayList<Realisateur> results = new ArrayList<>();
        String sqlQuery = "SELECT p.id, p.nom, p.prenom FROM Personne p JOIN Participe par ON p.id = par.id WHERE par.id_Role == 2;";
>>>>>>> Stashed changes
        //Log.d(TAG, sqlQuery);

        //Get database
        db = r2d2.getReadableDatabase();

        //Execute query and get response
        Cursor c = db.rawQuery(sqlQuery, null);

        //Init cursor to first row
        if(!c.moveToFirst()){
            // Log.v(TAG, "There are no products in the database");
        }else{
            do{
                results.add(new Realisateur(c.getInt(1), c.getString(2), c.getString(3)));
            }while(c.moveToNext());
        }

        c.close();
        return results;
    }

<<<<<<< Updated upstream
    public ArrayList<Film> getRole(){
        ArrayList<Film> results = new ArrayList<>();
        String sqlQuery = "";
        //Log.d(TAG, sqlQuery);

        //Get database
        db = r2d2.getReadableDatabase();

        //Execute query and get response
        Cursor c = db.rawQuery(sqlQuery, null);

        //Init cursor to first row
        if(!c.moveToFirst()){
            // Log.v(TAG, "There are no products in the database");
        }else{
            do{
                //Add new film to list
                        //results.add(new Film(c.getString(1), c.getInt(2), c.getString(3),c.getLong(4)));
            }while(c.moveToNext());
        }

        c.close();
        return results;
    }

    public ArrayList<Film> getAllAvis(){
        ArrayList<Film> results = new ArrayList<>();
        String sqlQuery = "";
=======
    public ArrayList<Realisateur> getAllActeur(int idFilm){
        ArrayList<Realisateur> results = new ArrayList<>();
        String sqlQuery = "SELECT p.id, p.nom, p.prenom FROM Personne per JOIN Participe par ON p.id = par.id WHERE par.id_Film == "+ idFilm +" AND par.id_Role == 1;";
>>>>>>> Stashed changes
        //Log.d(TAG, sqlQuery);

        //Get database
        db = r2d2.getReadableDatabase();

        //Execute query and get response
        Cursor c = db.rawQuery(sqlQuery, null);

        //Init cursor to first row
        if(!c.moveToFirst()){
            // Log.v(TAG, "There are no people in the database");
        }else{
            do{
                //Add new person to list
                results.add(new Realisateur(c.getInt(1), c.getString(2), c.getString(3)));
            }while(c.moveToNext());
        }

        c.close();
        return results;
    }

<<<<<<< Updated upstream
    public ArrayList<Realisateur> getAllRealisateur() {
        //TODO
        ArrayList<Realisateur> results = new ArrayList<>();
        String sqlQuery = "";
=======
    public ArrayList<Film> getAllAvis(){
        ArrayList<Film> results = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Avis a JOIN Film F ON a.id_Film = f.id";
>>>>>>> Stashed changes
        //Log.d(TAG, sqlQuery);

        //Get database
        db = r2d2.getReadableDatabase();

        //Execute query and get response
        Cursor c = db.rawQuery(sqlQuery, null);

        //Init cursor to first row
        if(!c.moveToFirst()){
            // Log.v(TAG, "There are no products in the database");
        }else{
            do{
                //Add new film to list
                        //results.add(new Film(c.getString(1), c.getInt(2), c.getString(3),c.getLong(4)));
            }while(c.moveToNext());
        }

        c.close();
        return results;
    }


    public ArrayList<Film> getFilmParReal(int Realisateur) {
        //TODO A VERIFIER !
        ArrayList<Film> results = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Film f INNER JOIN participe p ON p.id_Film = f.id INNER JOIN personne pers ON pers.id = p.id WHERE pers.id = " +Realisateur;
        //Log.d(TAG, sqlQuery);

        //Get database
        db = r2d2.getReadableDatabase();

        //Execute query and get response
        Cursor c = db.rawQuery(sqlQuery, null);

        //Init cursor to first row
        if(!c.moveToFirst()){
            // Log.v(TAG, "There are no products in the database");
        }else{
            do{
                //Add new film to list
                //results.add(new Film(c.getString(1), c.getInt(2), c.getString(3),c.getLong(4)));
            }while(c.moveToNext());
        }

        c.close();
        return results;
    }
}

