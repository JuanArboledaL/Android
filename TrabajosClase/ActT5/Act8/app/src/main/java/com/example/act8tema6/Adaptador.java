package com.example.act8tema6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<Datos> {

    private ArrayList<Datos> datos;

    public Adaptador(Context context, ArrayList<Datos> datos){
        super(context,R.layout.elemento,datos);
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.elemento,parent,false);

        ImageView img = elemento.findViewById(R.id.imagen);
        img.setImageResource(datos.get(position).getImagen());

        TextView t1 = elemento.findViewById(R.id.miTexto1);
        t1.setText(datos.get(position).getTexto());

        CheckBox checkBox = elemento.findViewById(R.id.checkbox);
        checkBox.setChecked(datos.get(position).getCheckbox());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                datos.get(position).setCheckbox(isChecked);
            }
        });

        return elemento;
    }
}
