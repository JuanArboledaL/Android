package com.example.juanestebanarboledaexamenbbdd;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.juanestebanarboledaexamenbbdd.AdaptadorPersonalizado.Adaptador;
import com.example.juanestebanarboledaexamenbbdd.AdaptadorPersonalizado.Datos;
import com.example.juanestebanarboledaexamenbbdd.BBDD.PeliculasBBDD;
import com.example.juanestebanarboledaexamenbbdd.Opciones.OpcionesActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private int peliculaS;
    private LinearLayout layoutAnyadir;
    private LinearLayout layoutQuitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final  Button aniadirTendencia = findViewById(R.id.aniadirTendencia);
        final  Button cancelarTendencia = findViewById(R.id.cancelarTendencia);
        final Button quitarMl = findViewById(R.id.quitar);
        final Button cancelarML = findViewById(R.id.cancelarMl);
        final ListView listaT = findViewById(R.id.peliculasBBDD);
        final ListView miLissta = findViewById(R.id.misPeliculas);

        layoutAnyadir = findViewById(R.id.lyTendencia);
        layoutQuitar = findViewById(R.id.lyMl);

        PeliculasBBDD bdUsuarios = new PeliculasBBDD(this,"Peliculas",null,1);
        SQLiteDatabase db = bdUsuarios.getWritableDatabase();
        db.execSQL("delete from Peliculas");

        anyadir(db);
        rellenarTendencias(db);
        rellenarMl(db);

        listaT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                layoutAnyadir.setVisibility(View.VISIBLE);
                layoutQuitar.setVisibility(View.GONE);

                peliculaS = ((Datos) parent.getItemAtPosition(position)).getClave();
            }
        });

        miLissta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                layoutQuitar.setVisibility(View.VISIBLE);
                layoutAnyadir.setVisibility(View.GONE);

                peliculaS = ((Datos) parent.getItemAtPosition(position)).getClave();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == R.id.op1){

            Intent intent = new Intent(MainActivity.this, OpcionesActivity.class);
            startActivity(intent);

        }
        return true;
    }

    private void cancelar() {
        layoutAnyadir.setVisibility(View.INVISIBLE);
        layoutQuitar.setVisibility(View.GONE);
    }


    private void rellenarTendencias(SQLiteDatabase db) {
        Cursor c = db.rawQuery("select * from Peliculas where lista = 0",null);
        ListView listado = (ListView) findViewById(R.id.peliculasBBDD);
        ArrayList<Datos> datos = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                int clave = c.getInt(0);
                String nombre = c.getString(1);
                int foto = c.getInt(2);
                int lista = c.getInt(3);
                Datos datos1 = new Datos(clave,nombre,foto,lista);
                datos.add(datos1);
            }while (c.moveToNext());
        }
        Adaptador miAdaptador = new Adaptador(this,datos);
        listado.setAdapter(miAdaptador);
    }

    private void rellenarMl(SQLiteDatabase db) {
        Cursor c = db.rawQuery("select * from Peliculas where lista = 1", null);
        ListView listado = (ListView) findViewById(R.id.misPeliculas);
        ArrayList<Datos> datos = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                int clave = c.getInt(0);
                String nombre = c.getString(1);
                int foto = c.getInt(2);
                int lista = c.getInt(3);
                Datos datos1 = new Datos(clave, nombre, foto, lista);
                datos.add(datos1);
            } while (c.moveToNext());
        }
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);

    }

    private void anyadir(SQLiteDatabase db) {
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("nombre","Stranger Things");
        nuevoRegistro.put("foto",R.drawable.stranger);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","Shingeki no Kyojin");
        nuevoRegistro.put("foto",R.drawable.titanes);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","Supernatural");
        nuevoRegistro.put("foto",R.drawable.supernatural);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","Breaking Bad");
        nuevoRegistro.put("foto",R.drawable.breaking);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","Hill");
        nuevoRegistro.put("foto",R.drawable.hill);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","Howl");
        nuevoRegistro.put("foto",R.drawable.howl);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","Alquimia");
        nuevoRegistro.put("foto",R.drawable.alquimia);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","Lucifer");
        nuevoRegistro.put("foto",R.drawable.lucifer);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","Broadchurch");
        nuevoRegistro.put("foto",R.drawable.broadchurch);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","Erased");
        nuevoRegistro.put("foto",R.drawable.erased);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);
    }

}