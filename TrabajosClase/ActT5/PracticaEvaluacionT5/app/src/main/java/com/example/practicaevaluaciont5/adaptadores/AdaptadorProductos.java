package com.example.practicaevaluaciont5.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.practicaevaluaciont5.R;
import com.example.practicaevaluaciont5.datos.Producto;

public class AdaptadorProductos extends ArrayAdapter<Producto> {


    private Producto datos[];

    public AdaptadorProductos(@NonNull Context context, Producto[] datos) {
        super(context, R.layout.elemento_productos, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.elemento_productos,parent,false);

        final TextView nombre = elemento.findViewById(R.id.nombreProducto);
        nombre.setText(datos[position].getNombre());

        final TextView precio = elemento.findViewById(R.id.precio);
        precio.setText(String.valueOf(datos[position].getPrecio()).concat(" €"));

        final ImageView img = elemento.findViewById(R.id.imgProduct);
        img.setImageResource(datos[position].getSrc());

        return elemento;
    }
}
