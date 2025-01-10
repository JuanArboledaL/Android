package com.example.actividad12;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final GridLayout aficiones = findViewById(R.id.aficiones);
        final RadioGroup deporte = findViewById(R.id.deporte);
        final RadioGroup literario = findViewById(R.id.literario);

        final Button recetear = findViewById(R.id.recetear);
        final Button aceptar = findViewById(R.id.aceptar);

        recetear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < aficiones.getChildCount(); i++){

                    View v = aficiones.getChildAt(i);
                    if(v instanceof CheckBox){

                        ((CheckBox) v).setChecked(false);
                    }
                }

                for (int i = 0; i < literario.getChildCount(); i++){

                    View v = literario.getChildAt(i);
                    if(v instanceof RadioButton){

                        ((RadioButton) v).setChecked(false);
                    }
                }

                for (int i = 0; i < deporte.getChildCount(); i++){

                    View v = deporte.getChildAt(i);
                    if(v instanceof RadioButton){

                        ((RadioButton) v).setChecked(false);
                    }
                }

                final TextView cadena= findViewById(R.id.text);
                String cad = "";
                cadena.setText(cad);
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final TextView texto = findViewById(R.id.text);
                String cadena = "Tus aficiones son:\n";

                for (int i = 0; i < aficiones.getChildCount(); i++) {

                    View v = aficiones.getChildAt(i);
                    if(v instanceof CheckBox){

                        if(((CheckBox) v).isChecked()){
                            cadena += ((CheckBox) v).getText() + "\n";
                        }
                    }
                }

                cadena += "Tus Generos literario son:\n";
                for (int i = 0; i < literario.getChildCount(); i++) {

                    View v = literario.getChildAt(i);
                    if (v instanceof RadioButton) {

                        if (((RadioButton) v).isChecked()) {
                            cadena += ((RadioButton) v).getText() + "\n";
                        }
                    }
                }

                cadena += "Tus Deportes son:\n";
                for (int i = 0; i < deporte.getChildCount(); i++) {

                    View v = deporte.getChildAt(i);
                    if (v instanceof RadioButton) {

                        if (((RadioButton) v).isChecked()) {
                            cadena += ((RadioButton) v).getText() + "\n";
                        }
                    }
                }

                texto.setText(cadena);
            }
        });

    }
}