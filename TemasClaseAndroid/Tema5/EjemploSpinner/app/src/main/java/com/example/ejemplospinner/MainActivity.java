package com.example.ejemplospinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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


        //Recupero spinner
        final Spinner listado;
        listado = findViewById(R.id.listado);


        //Declaro la fuente de datos
        final String datos[] = {"opcion 1", "Opcion 2" , "Opcion 3", "Opcion 4", "Opción 5"};

        //Crear adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datos);

        //Asigno adaptador;
        listado.setAdapter(adaptador);

        listado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long l) {

                Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(posicion).toString(), Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, adapterView.getAdapter().getItem(posicion).toString(), Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}