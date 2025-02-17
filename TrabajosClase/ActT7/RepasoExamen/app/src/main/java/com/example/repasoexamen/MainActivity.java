package com.example.repasoexamen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.repasoexamen.Adaptador.Adaptador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView tendencias = findViewById(R.id.listaTendencias);
        ListView miLista = findViewById(R.id.miLista);

        bbdd peliculasDB = new bbdd(this, "PeliculasDB", null, 1);
        SQLiteDatabase db = peliculasDB.getWritableDatabase();

        if (db != null) {
            cargarPeliculasDeBD(db);
            // Cargar tendencias
            cargarListaPeliculas(db, tendencias, 0);
            // Cargar MiLista
            cargarListaPeliculas(db, miLista, 1);
        }


    }

    private void cargarPeliculasDeBD(SQLiteDatabase db) {
        db.execSQL("delete from peliculas;");
        db.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('Alquimia de almas'," + R.drawable.alquimia + ",'0')");
        db.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('Breaquing Bad'," + R.drawable.breaking + ",'0')");
        db.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('Broadchurch'," + R.drawable.broadchurch + ",'0')");
        db.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('Erased'," + R.drawable.erased + ",'0')");
        db.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('The Haunting of Hill House'," + R.drawable.hill + ",'0')");
        db.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('Stranger Things'," + R.drawable.stranger + ",'0')");
        db.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('Supernatural'," + R.drawable.supernatural + ",'0')");
        db.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('Attack on Titan'," + R.drawable.titanes + ",'0')");
    }

    private void cargarListaPeliculas(SQLiteDatabase db, ListView miLista, int lista) {
        ArrayList<Datos> datos = new ArrayList<>();
        Adaptador adaptador = new Adaptador(MainActivity.this, datos);
        String sentenciaSelect = "SELECT _id,foto,nombre FROM peliculas WHERE lista=" + lista + ";";
        Cursor miCursor = db.rawQuery(sentenciaSelect, null);
        if (miCursor.moveToFirst()) {
            do {
                int id = miCursor.getInt(0);
                int foto = miCursor.getInt(1);
                String nombre = miCursor.getString(2);
                datos.add(new Datos(id, foto, nombre));
            } while (miCursor.moveToNext());
            miCursor.close();
        }
        miLista.setAdapter(adaptador);
    }
}