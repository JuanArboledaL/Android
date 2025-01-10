package com.example.actevaluativatema1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_vista);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //actEvaluativa main
        final EditText nombre = findViewById(R.id.campoNombre);
        final EditText fechaNa = findViewById(R.id.fechaNacimiento);

        final CheckBox crearRecordatorio = findViewById(R.id.checkRecordatorio);

        final Button aceptar = findViewById(R.id.btnAceptar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena="";
                final TextView txt  = findViewById(R.id.textRecodatorio);

                if(nombre.getText().toString().isEmpty()){

                    cadena = getString(R.string.nombreErr);
                }
                else if(fechaNa.getText().toString().isEmpty()){

                    cadena= getString(R.string.fechaErr);

                }else{

                    cadena = getString(R.string.textoFinalizado).replace("{NOMBRE}", nombre.getText()).replace("{FECHA}", fechaNa.getText());

                    if(crearRecordatorio.isChecked()){

                        cadena += getString(R.string.recordatorio);

                    }
                }
                txt.setText(cadena);
            }

        });

    }
    public void onClick(View view) {

        Intent intent = new Intent(Activity2.this,MainActivity3.class);

        startActivity(intent);
    }
}