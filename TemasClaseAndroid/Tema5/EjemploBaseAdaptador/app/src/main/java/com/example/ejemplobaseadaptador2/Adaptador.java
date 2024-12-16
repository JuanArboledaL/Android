package com.example.ejemplobaseadaptador2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private ArrayList<Datos> datos;
    private Context contex;

    public Adaptador(ArrayList<Datos> datos, Context contex) {
        super();
        this.datos = datos;
        this.contex = contex;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup parent) {

        View elemento = LayoutInflater.from(contex).inflate(R.layout.elemento,parent,false);

        final TextView texto1= elemento.findViewById(R.id.texto1);
        texto1.setText(datos.get(posicion).getTexto1());

        final TextView texto2= elemento.findViewById(R.id.texto2);
        texto2.setText(datos.get(posicion).getTexto2());

        return elemento;

    }

    @Override
    public int getCount() {

        return datos.size();
    }

    @Override
    public Object getItem(int posicion) {
        return datos.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }
}
