package com.example.juanestebanarboledaexamenbbdd.BBDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PeliculasBBDD extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Peliculas(codigo INTEGER PRIMARY KEY autoincrement, nombre TEXT, foto INTEGER, lista INTEGER)";

    public PeliculasBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Peliculas");

        db.execSQL(sqlCreate);

    }
}
