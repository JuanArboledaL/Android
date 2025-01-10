package com.example.ejercicio2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

        TextView texto = findViewById(R.id.texto);
        ListView list = findViewById(R.id.listado);


        final String datos[] = {"BlindsPot","Stranger Things","Cobra Kai","Los Brigerton", "Ninja Go","Sick y Luder","Breaking Bad","Batller Call Saul","Narcos","Aias JJ"};

        ArrayAdapter<String>adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datos);

        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                texto.setText(adapterView.getAdapter().getItem(posicion).toString());

            }
        });

    }
}