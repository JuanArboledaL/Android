package com.example.act8tema6;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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

        ArrayList<Datos> datos = new ArrayList<Datos>();
        datos.add(new Datos(R.drawable.consola,"Consola"));
        datos.add(new Datos(R.drawable.ordenador_fijo,"Ordenador fijo"));
        datos.add(new Datos(R.drawable.ordenador_portatil,"Ordenador portátil"));
        datos.add(new Datos(R.drawable.reloj,"Reloj"));
        datos.add(new Datos(R.drawable.smartphone,"Smartphone"));
        datos.add(new Datos(R.drawable.tablet,"Tablet"));
        datos.add(new Datos(R.drawable.tv,"Televisión"));


        // Incorporo el objeto ListView en la aplicación
        ListView listado = (ListView) findViewById(R.id.miLista);


        Adaptador miAdaptador = new Adaptador(this,datos);
        listado.setAdapter(miAdaptador);

        Button button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String frase= "Para navegar por internet utilizas: ";
                boolean check= false;

                for (int i = 0; i < datos.size(); i++) {
                    Datos datos1 = (Datos) listado.getItemAtPosition(i);
                    if (datos1.getCheckbox()) {
                        frase+=datos1.getTexto()+", ";
                        check=true;
                    }
                }
                if (!check) {
                    frase = "No se ha seleccionado ningun dispositivo";
                }

                Toast.makeText(MainActivity.this, frase.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        


    }
}