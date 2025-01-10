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
import com.example.practicaevaluaciont5.datos.Categoria;

public class AdaptadorCategorias extends ArrayAdapter<Categoria> {

    private Categoria categorias[];

    public AdaptadorCategorias(@NonNull Context context, Categoria[] categorias) {
        super(context, R.layout.elemento_categoria, categorias);
        this.categorias = categorias;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.elemento_categoria,parent,false);

        final TextView nombre = elemento.findViewById(R.id.txtCategoria);
        nombre.setText(categorias[position].getNombre());

        final ImageView img = elemento.findViewById(R.id.imgCategoria);
        img.setImageResource(categorias[position].getImagen());

        return elemento;
    }
}
