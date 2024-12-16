package com.example.ejemplogridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
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

        //Instanciar el listado
        final GridView listado;
        listado= findViewById(R.id.listado);

        //Creo la fuente de datos
        final String datos[] = {"opcion 1", "Opcion 2" , "Opcion 3", "Opcion 4", "Opción 5"};

        //Creo el adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datos);

        //Asigno adaptador
        listado.setAdapter(adaptador);

        //Añadir listener
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                //Opcion1
                Toast.makeText(MainActivity.this, "Has hecho click en " + adapterView.getItemAtPosition(posicion), Toast.LENGTH_SHORT).show();

                //Opcion 2
                Toast.makeText(MainActivity.this, "Has hecho click en " + adapterView.getAdapter().getItem(posicion), Toast.LENGTH_SHORT).show();
            }
        });

    }
}