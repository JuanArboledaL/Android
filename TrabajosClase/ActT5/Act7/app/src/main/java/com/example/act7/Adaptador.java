package com.example.act7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private ArrayList<Datos> datos;
    private Context contexto;

    public Adaptador(Context contexto, ArrayList<Datos> datos) {
        super();
        this.datos = datos;
        this.contexto = contexto;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.elemento, parent, false);

        TextView texto1 = (TextView) elemento.findViewById(R.id.texto);
        texto1.setText(datos.get(i).getTexto());

        ImageView icono = elemento.findViewById(R.id.img);
        icono.setImageResource(datos.get(i).getImagen());

        return elemento;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int i) {
        return datos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}

