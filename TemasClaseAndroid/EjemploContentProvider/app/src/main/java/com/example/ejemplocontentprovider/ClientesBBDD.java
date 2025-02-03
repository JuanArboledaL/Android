package com.example.ejemplocontentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClientesBBDD extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla
    String sqlCreate = "CREATE TABLE Clientes(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, telefono TEXT, email TEXT)";

    public ClientesBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //cREAMOS LA TABLA
        db.execSQL(sqlCreate);

        //Pro simplicidad del ejemplo insertamos directamente los clientes

        for (int i = 1; i<10;i++){

            //Generamos los datos
            String nombre = "Cliente" + i;
            String telefono = "900-123-00" + i;
            String email = "email" + i +"@mail.com";

            //Insertamos los datos en la bbdd
            ContentValues registro = new ContentValues();
            registro.put("nombre",nombre);
            registro.put("telefono",telefono);
            registro.put("email",email);
            db.insert("Clientes",null,registro);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Clientes");
        db.execSQL(sqlCreate);
    }
}
