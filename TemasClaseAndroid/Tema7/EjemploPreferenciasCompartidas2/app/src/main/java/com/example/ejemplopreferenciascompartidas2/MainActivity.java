package com.example.ejemplopreferenciascompartidas2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        final Button guardar = findViewById(R.id.btnGuardar);
        final Button cargar = findViewById(R.id.btnCargar);
        final Button borrar = findViewById(R.id.btnBorrar);

        final EditText etNombre = findViewById(R.id.etNombre);
        final EditText etCorreo = findViewById(R.id.etCorreo);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("Nombre", etNombre.getText().toString());
                editor.putString("email", etCorreo.getText().toString());

                editor.commit();
            }
        });

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getSharedPreferences("Mispreferencias", Context.MODE_PRIVATE);

                String nombre = pref.getString("Nombre", "");
                String correo = pref.getString("email", "");

                etNombre.setText(nombre);
                etCorreo.setText(correo);

            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etNombre.setText("");
                etCorreo.setText("");
            }
        });
    }
}