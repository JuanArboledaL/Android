package com.example.repasoexamen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class bbdd extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE peliculas(_id INTEGER PRIMARY KEY, nombre TEXT, foto INTEGER, Lista INTEGER)";

    public bbdd(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS peliculas");
        db.execSQL(sqlCreate);
    }
}
