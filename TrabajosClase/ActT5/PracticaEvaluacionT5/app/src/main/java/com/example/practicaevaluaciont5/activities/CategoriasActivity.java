package com.example.practicaevaluaciont5.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.practicaevaluaciont5.R;
import com.example.practicaevaluaciont5.adaptadores.AdaptadorCategorias;
import com.example.practicaevaluaciont5.datos.Categoria;
import com.example.practicaevaluaciont5.datos.FuenteDeDatos;

public class CategoriasActivity extends AppCompatActivity {

    static final String ID_CATEGORIA = "idCategoria";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.categorias);


        setSupportActionBar(toolbar);

        FuenteDeDatos datos= FuenteDeDatos.getInstance();

        final GridView listado = findViewById(R.id.listado);

        AdaptadorCategorias adaptadorCategorias = new AdaptadorCategorias(this, datos.getCategorias());
        listado.setAdapter(adaptadorCategorias);

        Intent intenCategorias = new Intent(this, ProductosActivity.class);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                Categoria categoria = FuenteDeDatos.getCategorias()[posicion];

                intenCategorias.putExtra(ID_CATEGORIA, categoria.getCategoria());
                startActivity(intenCategorias );

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opcionesmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int opcion = item.getItemId();

        if(opcion == R.id.llamada){

            Intent intent = new
                    Intent(Intent.ACTION_DIAL, Uri.parse("tel:624308929"));
            startActivity(intent);
            return true;

        }else if(opcion == R.id.op2){

            Intent intent = new Intent(this,CalificacionActivity.class);
            startActivity(intent);
            return true;
        }else if(opcion == R.id.op3){

            Intent intent = new Intent(this, AcercadeActiity.class);
            startActivity(intent);
            return true;
        }else{

            return super.onOptionsItemSelected(item);
        }
    }

}