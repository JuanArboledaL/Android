package com.example.ejemplopreferenciascompartidas;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

        final Button btnCargar = findViewById(R.id.btnCargar);
        final Button btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ontengo la refrencia de la conecxion de las preferencias
                //(Archivo xml)) donde tengo o voy a guardar las referencias
                SharedPreferences prefs = getSharedPreferences("Mis preferencias", Context.MODE_PRIVATE);

                //Guardar los valores
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("Nombre", "IesBelen");
                editor.putString("email", "·iesbele@gmail.com");

                //Guardo los cambios
                editor.commit();
            }
        });

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ontengo la refrencia de la conecxion de las preferencias
                //(Archivo xml)) donde tengo o voy a guardar las referencias
                SharedPreferences prefs = getSharedPreferences("Mis preferencias", Context.MODE_PRIVATE);

                String nombre = prefs.getString("nombre","");
                String correo = prefs.getString("email", "");

                Log.i("Preferencias", "Nombre" + nombre);
                Log.i("Preferencias", "Correo" + correo);


            }
        });
    }
}