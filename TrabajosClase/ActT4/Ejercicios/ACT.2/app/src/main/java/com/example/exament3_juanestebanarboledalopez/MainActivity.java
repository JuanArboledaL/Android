package com.example.exament3_juanestebanarboledalopez;

import static com.example.exament3_juanestebanarboledalopez.R.id.btnFuerte;
import static com.example.exament3_juanestebanarboledalopez.R.id.btnPerderPeso;
import static com.example.exament3_juanestebanarboledalopez.R.id.editextUsuario;
import static com.example.exament3_juanestebanarboledalopez.R.id.tittle4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setContentView(R.layout.activity_main);

        final EditText nombre = findViewById(R.id.editextUsuario);
        final EditText contra = findViewById(R.id.editextContrasenia);

        final Button aceptar = findViewById(R.id.btnAceptar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena = "";
                final TextView txt = findViewById(R.id.textBienvenida);

                if (nombre.getText().toString().isEmpty() || contra.toString().isEmpty()) {

                    cadena = getString(R.string.introduce_usuario_y_clave);
                } else {

                    cadena = "Hola" + nombre + "Accediendo a la app";

                }
                txt.setText(cadena);

            }
        });

    }

    public void onClick(View view) {

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }

}