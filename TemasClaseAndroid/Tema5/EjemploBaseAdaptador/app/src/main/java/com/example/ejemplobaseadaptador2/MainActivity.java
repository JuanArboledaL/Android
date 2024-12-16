package com.example.ejemplobaseadaptador2;

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
        datos.add(new Datos("Linea Superior 1", "Linea Inferior 1"));
        datos.add(new Datos("Linea Superior 2", "Linea Inferior 2"));
        datos.add(new Datos("Linea Superior 3", "Linea Inferior 3"));
        datos.add(new Datos("Linea Superior 4", "Linea Inferior 4"));
        datos.add(new Datos("Linea Superior 5", "Linea Inferior 5"));

        //Recupero el id del listado

        final ListView listado = findViewById(R.id.listado);

        //Incorporo la cabecera
        View cabecera = getLayoutInflater().inflate(R.layout.cabecera,null);
        listado.addHeaderView(cabecera);

        //Creo el adaptador
        Adaptador miAdaptador = new Adaptador(datos, this);
        listado.setAdapter(miAdaptador);

        //Insertar listener
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                String texto1 = ((Datos)adapterView.getItemAtPosition(posicion)).getTexto1();
                String texto2 = ((Datos)adapterView.getItemAtPosition(posicion)).getTexto2();

                Toast.makeText(MainActivity.this, "Título: " + texto1 + " Subtitulo: " + texto2, Toast.LENGTH_SHORT).show();
            }
        });


    }
}