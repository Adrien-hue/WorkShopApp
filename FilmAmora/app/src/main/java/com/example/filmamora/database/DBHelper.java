package com.example.filmamora.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private String createQuery = "CREATE TABLE Film(id Int PRIMARY KEY AUTOINCREMENT  NOT NULL , titre Varchar (255) NOT NULL ,annee Date NOT NULL , synopsis Varchar (1000) NOT NULL)";


    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createQuery);
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
