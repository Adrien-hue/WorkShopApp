package com.example.filmamora.database;

import android.app.Person;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.filmamora.Objet.DetailFilm;
import com.example.filmamora.Objet.Film;
import com.example.filmamora.Objet.Personne;

import java.util.ArrayList;

public class DBManager {

    private static final String DB_NAME = "films.sqlite";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase db;
    private DBHelper r2d2;

    public DBManager(Context context){
        r2d2 = new DBHelper(context, DB_NAME, null, DB_VERSION);

    }

    public void addNewCritiqueToDB(int idFilm, int note, String critique){
        db = r2d2.getWritableDatabase();
        String sqlQuery = "INSERT INTO Avis (note, critique, id_Film) VALUES (" + note + ",'"+ critique+"', "+ idFilm +");";
        //Log.d(TAG, sqlQuery);
        db.execSQL(sqlQuery);
    }

    public void addListaVoir(int idFilm){
        db = r2d2.getWritableDatabase();
        String sqlQuery = "UPDATE Film SET aVoir = '1' WHERE id = "+ idFilm +";";;
        //Log.d(TAG, sqlQuery);
        db.execSQL(sqlQuery);
    }

    public void suppListaVoir(int idFilm){
        db = r2d2.getWritableDatabase();
        String sqlQuery = "UPDATE Film SET aVoir = '0' WHERE id = "+ idFilm +";";;
        //Log.d(TAG, sqlQuery);
        db.execSQL(sqlQuery);
    }

    public ArrayList<Film> getFilmaVoir(){
        ArrayList<Film> results = new ArrayList<>();
        String sqlQuery = "SELECT f.id, f.titre, f.annee, pe.prenom, pe.nom, f.aVoir FROM Film f LEFT JOIN Avis a ON f.id = a.id_Film LEFT JOIN Participe pa ON pa.id_Film = f.id JOIN Personne pe ON pe.id = pa.id WHERE pa.id_role=2 AND aVoir = 1;";

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
                results.add(new Film(c.getInt(0), c.getString(1), c.getLong(2), c.getString(3), c.getString(4), c.getInt(5)));
            }while(c.moveToNext());
        }

        c.close();
        return results;
    }


    public ArrayList<Film> getAllFilm(){
        ArrayList<Film> results = new ArrayList<>();
        String sqlQuery = "SELECT f.id, f.titre, f.annee, pe.prenom, pe.nom, f.aVoir FROM Film f LEFT JOIN Avis a ON f.id = a.id_Film LEFT JOIN Participe pa ON pa.id_Film = f.id JOIN Personne pe ON pe.id = pa.id WHERE pa.id_role=2;";

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
                results.add(new Film(c.getInt(0), c.getString(1), c.getLong(2), c.getString(3), c.getString(4), c.getInt(5)));
            }while(c.moveToNext());
        }

        c.close();
        return results;
    }


    public DetailFilm getDetailsFilm(int idFilm){
        DetailFilm results = null;
        String sqlQuery = "SELECT f.id, f.titre, f.annee,pe.prenom, pe.nom,f.synopsis, a.note, a.commentaire FROM Film f LEFT JOIN Avis a ON f.id = a.id_Film LEFT JOIN Participe pa ON pa.id_Film = f.id JOIN Personne pe ON pe.id = pa.id WHERE pa.id_Film=" + idFilm +" AND pa.id_role=2;";
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
                results = new DetailFilm(c.getInt(0), c.getString(1), c.getLong(2), c.getString(3), c.getString(4), c.getString(5), c.getInt(6), c.getString(7));
            }while(c.moveToNext());
        }

        c.close();
        return results;
    }

    public ArrayList<Personne> getActeur(int idFilm){
        ArrayList<Personne> results = new ArrayList<>();
        String sqlQuery = "SELECT per.id, per.prenom, per.nom FROM Personne per JOIN Participe par ON per.id = par.id WHERE par.id_Film = "+ idFilm +" AND par.id_Role = 1;";
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
                results.add(new Personne(c.getInt(0), c.getString(1), c.getString(2)));
            }while(c.moveToNext());
        }

        c.close();
        return results;
    }

    public ArrayList<Film> getAllAvis(){
        ArrayList<Film> results = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Avis a JOIN Film F ON a.id_Film = f.id";
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

    public ArrayList<Personne> getAllRealisateur() {
        ArrayList<Personne> results = new ArrayList<>();
        String sqlQuery = "SELECT DISTINCT per.id, per.prenom, per.nom FROM Personne per JOIN Participe p ON per.id = p.id WHERE p.id_Role == 2;";
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
                results.add(new Personne(c.getInt(0), c.getString(1), c.getString(2)));
            }while(c.moveToNext());
        }

        c.close();
        return results;
    }

    public ArrayList<Film> getFilmParReal(int Realisateur) {
        //TODO Fonctionne à ne pas toucher !
        ArrayList<Film> results = new ArrayList<>();
        String sqlQuery = "SELECT f.id, f.titre, f.annee, pers.prenom, pers.nom FROM Film f JOIN participe p ON p.id_Film = f.id JOIN personne pers ON pers.id = p.id WHERE pers.id = "+ Realisateur +";";

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
                results.add(new Film(c.getInt(0), c.getString(1), c.getLong(2), c.getString(3), c.getString(4)));
            }while(c.moveToNext());
        }

        c.close();
        return results;
    }
}

