package com.example.act7;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
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
        datos.add(new Datos(R.drawable.buho, "Buho"));
        datos.add(new Datos(R.drawable.cachorros, "Carchorros"));
        datos.add(new Datos(R.drawable.cerdo, "Cerdo"));
        datos.add(new Datos(R.drawable.jirafas, "Jirafas"));
        datos.add(new Datos(R.drawable.lobo, "Lobo"));
        datos.add(new Datos(R.drawable.potro, "Potro"));
        datos.add(new Datos(R.drawable.tigre, "Tigre"));
        datos.add(new Datos(R.drawable.tortuga, "Tortuga"));
        datos.add(new Datos(R.drawable.tucan, "Tucán"));

        GridView imagenes = findViewById(R.id.imagenes);

        Adaptador miAdptador = new Adaptador(this,datos);
        imagenes.setAdapter(miAdptador);

        imagenes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                String seleccion = ((Datos)adapterView.getItemAtPosition(posicion)).getTexto();
                Toast.makeText(MainActivity.this, seleccion, Toast.LENGTH_SHORT).show();

            }
        });
    }

}