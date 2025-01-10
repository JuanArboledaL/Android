package com.example.practicaevaluaciont5.activities;

import static com.example.practicaevaluaciont5.activities.CategoriasActivity.ID_CATEGORIA;
import static com.example.practicaevaluaciont5.activities.DestallesProductoActivity.ID_PRODUCTO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.practicaevaluaciont5.adaptadores.AdaptadorProductos;
import com.example.practicaevaluaciont5.R;
import com.example.practicaevaluaciont5.datos.FuenteDeDatos;
import com.example.practicaevaluaciont5.datos.Producto;

public class ProductosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.productos);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        Bundle extra = getIntent().getExtras();
        int categoria = extra != null ? extra.getInt(ID_CATEGORIA) : null;

        FuenteDeDatos datos= FuenteDeDatos.getInstance();
        final ListView listado = findViewById(R.id.listado);

        Producto[] producto= null;

        ImageView logo = findViewById(R.id.logo);

        switch (categoria){

            case 1: {

                logo.setImageResource(R.drawable.logogranizados);
                producto = datos.getGranizados();
                break;
            }
            case 2:{

                producto = datos.getMicheladas();
                logo.setImageResource(R.drawable.logomicheladas);
                break;
            }
            case 3:{

                producto = datos.getCocktails();
                logo.setImageResource(R.drawable.cocktailslogo);
                break;
            }
            case 4:{

                producto = datos.getCervezas();
                logo.setImageResource(R.drawable.cerveza);
                break;
            }

        }

        Intent intent = new Intent(this, DestallesProductoActivity.class);

        listado.setAdapter(new AdaptadorProductos(this, producto));

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                Producto producto = FuenteDeDatos.getProducto(
                        ((Producto)adapterView.getItemAtPosition(posicion)).getId(),
                        ((Producto)adapterView.getItemAtPosition(posicion)).getCategoria());

                intent.putExtra(ID_PRODUCTO,producto.getId());
                intent.putExtra(ID_CATEGORIA,producto.getCategoria());
                startActivity(intent);
            }
        });
    }
}