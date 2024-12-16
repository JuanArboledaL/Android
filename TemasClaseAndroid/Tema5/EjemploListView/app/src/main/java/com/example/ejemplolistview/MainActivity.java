package com.example.ejemplolistview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

        //Instancia el listView del xml
        ListView list;
        list = findViewById(R.id.listado);

        //Declara la fuente de datos (array,ArrayList...)
        final String datos[] = {"opcion 1", "Opcion 2" , "Opcion 3", "Opcion 4", "Opción 5"};

        //crear adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datos);

        //asigno un adaptador
        list.setAdapter(adaptador);

        //Crear listenerr
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //Opcon 1: no hacerlo porque no es consistente, aunque funciones
                //Toast.makeText(MainActivity.this, datos[position], Toast.lLENGTH_SHORT).show();

                //opcion 2:
                Toast.makeText(MainActivity.this, adapterView.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}