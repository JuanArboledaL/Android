package com.example.ejercicio5;

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

        Datos datos[] = new Datos[]{

                new Datos("Juan Esteban", "12134332"),
                new Datos("Camilo Sesto", "546482132"),
                new Datos("La nea de medallo", "56484235"),
                new Datos("Milo dos tiempos", "2131546"),
                new Datos("Karla", "3446564"),
        };
        
        //Instancio el listado xml
        final ListView listado = findViewById(R.id.agenda);
        
        //Incorporo la cabecera
        View cabecera = getLayoutInflater().inflate(R.layout.cabecera,null);
        listado.addHeaderView(cabecera);
        
        //Creo mi adaptador personalizado
        Adaptador miAdaptador = new Adaptador(this,datos);
        listado.setAdapter(miAdaptador);
        
        //Creo un listener para el listado
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                
                String seleccionado  =((Datos)adapterView.getItemAtPosition(posicion)).getTexto1();
                Toast.makeText(MainActivity.this, "Nombre de contacto", Toast.LENGTH_SHORT).show();

                seleccionado = ((Datos)adapterView.getItemAtPosition(posicion)).getTexto2();
                Toast.makeText(MainActivity.this, "Numero de teléfono", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
}