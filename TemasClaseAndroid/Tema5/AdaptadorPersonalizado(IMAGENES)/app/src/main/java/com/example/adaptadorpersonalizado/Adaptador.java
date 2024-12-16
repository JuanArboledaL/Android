package com.example.adaptadorpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private ArrayList<Datos> datos;
    private Context contexto;

    public Adaptador(ArrayList<Datos> datos, Context contexto) {
        super();
        this.datos = datos;
        this.contexto = contexto;
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

    @Override
    public View getView(int posicion, View view, ViewGroup parent) {

        View elemento = LayoutInflater.from(contexto).inflate(R.layout.elemento,parent,false);

        final TextView texto = elemento.findViewById(R.id.texto);
        texto.setText(datos.get(posicion).getTexto());

        final ImageView icono = elemento.findViewById(R.id.icono);
        icono.setImageResource(datos.get(posicion).getIcono());

        return elemento;
    }
}
