package com.example.ejemplomenucontextualenlistas;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recupero el listado
        listado = findViewById(R.id.listado);

        ArrayList<String> datos = new ArrayList<>();
        datos.add("Elemento 1");
        datos.add("Elemento 2");
        datos.add("Elemento 3");

        //Creo Adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adaptador);
        registerForContextMenu(listado);


    }

}