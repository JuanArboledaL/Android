package com.example.ejemplopreferenceactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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


        final Button preferencias = findViewById(R.id.btnPreferencias);
        final Button consultar = findViewById(R.id.btnConsultar);

        preferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, OpcionesActivity.class));
            }
        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                Log.i("Preferencias", "Opcion 1" + pref.getBoolean("opcion1",false));
                Log.i("Preferencias", "Opcion 2" + pref.getString("opcion2",""));
                Log.i("Preferencias", "Opcion 3" + pref.getString("opcion3",""));

            }
        });

    }
}