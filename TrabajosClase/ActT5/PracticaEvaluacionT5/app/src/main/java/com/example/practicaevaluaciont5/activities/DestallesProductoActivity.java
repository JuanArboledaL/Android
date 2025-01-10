package com.example.practicaevaluaciont5.activities;

import static com.example.practicaevaluaciont5.activities.CategoriasActivity.ID_CATEGORIA;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.practicaevaluaciont5.R;
import com.example.practicaevaluaciont5.datos.FuenteDeDatos;
import com.example.practicaevaluaciont5.datos.Producto;


public class DestallesProductoActivity extends AppCompatActivity {

    static final String ID_PRODUCTO = "id_producto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalleproducto);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.producto);

        TextView nombre = findViewById(R.id.nombreProducto);
        ImageView imagen = findViewById(R.id.imagenProducto);
        TextView descripcion = findViewById(R.id.descripcionProducto);
        TextView precio = findViewById(R.id.precio);
        Button volver = findViewById(R.id.volver);

        Bundle extra = getIntent().getExtras();
        int idProducto = extra != null ? extra.getInt(ID_PRODUCTO) : null;
        int idCategoria = extra != null ? extra.getInt(ID_CATEGORIA) : null;

        Producto producto = FuenteDeDatos.getProducto(idProducto, idCategoria);

        nombre.setText(producto.getNombre());
        imagen.setImageResource(producto.getSrc());
        descripcion.setText(producto.getDescripcion());
        precio.setText(String.valueOf(producto.getPrecio()).concat(" €"));

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}
