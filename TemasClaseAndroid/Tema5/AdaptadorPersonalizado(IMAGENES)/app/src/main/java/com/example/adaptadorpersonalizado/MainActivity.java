package com.example.adaptadorpersonalizado;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Defino los datos
        ArrayList<Datos> datos = new ArrayList<>();
        datos.add(new Datos(R.drawable.consola,"Consola"));
        datos.add(new Datos(R.drawable.ordenador_fijo,"Ordenador Fijo"));
        datos.add(new Datos(R.drawable.ordenador_portatil,"Ordenador Portatil"));
        datos.add(new Datos(R.drawable.reloj,"Reloj"));
        datos.add(new Datos(R.drawable.smartphone,"Smartphone"));
        datos.add(new Datos(R.drawable.tablet,"Tablet"));
        datos.add(new Datos(R.drawable.tv,"Televisión"));

        //Recupero el id del listado
        final ListView listado = findViewById(R.id.listado);


        //Incorporo la cabecera

        //Creo el adaptador
        Adaptador miAdaptador = new Adaptador(datos,this);

        listado.setAdapter(miAdaptador);


        //Insertar listener
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                String seleccionado = ((Datos) adapterView.getItemAtPosition(posicion)).getTexto();
                Toast.makeText(MainActivity.this, seleccionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}