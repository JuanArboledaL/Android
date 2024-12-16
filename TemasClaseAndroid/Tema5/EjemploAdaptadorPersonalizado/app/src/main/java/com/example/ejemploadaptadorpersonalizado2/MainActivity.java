package com.example.ejemploadaptadorpersonalizado2;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creo los datos que voy a mostrar en pantalla

        Datos datos[] = new Datos[]{

                new Datos("Linea superior 1", "Linea Inferior 1"),
                new Datos("Linea superior 2", "Linea Inferior 2"),
                new Datos("Linea superior 32", "Linea Inferior 3"),
                new Datos("Linea superior 4", "Linea Inferior 4"),
                new Datos("Linea superior 5", "Linea Inferior 5"),
        };

        //Instancio el listado XML
        final ListView listado = findViewById(R.id.listado);

        //Incorporo la cabecera
        View cabecera = getLayoutInflater().inflate(R.layout.cabecera,null);
        listado.addHeaderView(cabecera);

        //Creo mi adaptador personalizado
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);

        //Creo un listener para el listado
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                String seleccionado = ((Datos)adapterView.getItemAtPosition(posicion)).getTexto1();
                Toast.makeText(MainActivity.this, "Título: ", Toast.LENGTH_SHORT).show();

                seleccionado = ((Datos)adapterView.getItemAtPosition(posicion)).getTexto2();
                Toast.makeText(MainActivity.this, "Subtitulo: ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}