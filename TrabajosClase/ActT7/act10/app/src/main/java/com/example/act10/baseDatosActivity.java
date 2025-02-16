package com.example.act10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class baseDatosActivity extends SQLiteOpenHelper {

    String sqlCreate= "CREATE TABLE Registro(codigo INTEGER PRIMARY KEY, nombre TEXT, apellidos TEXT)";

    public baseDatosActivity(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Registro");
        db.execSQL(sqlCreate);
    }
}
