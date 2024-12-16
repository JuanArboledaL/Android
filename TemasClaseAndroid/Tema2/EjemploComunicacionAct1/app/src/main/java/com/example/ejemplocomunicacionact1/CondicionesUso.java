package com.example.ejemplocomunicacionact1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CondicionesUso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condiciones_uso);

        final TextView lblMensaje = findViewById(R.id.lblMensaje);

        //Obtener la informacion del intent
        Bundle extras = getIntent().getExtras();
        String usuario = extras.getString("usuario");

        //Muestro el saludo en la etiqueta
        String mensaje= "Hola "+ usuario + " ¿Aceptas las condiciones de uso?";

        lblMensaje.setText(mensaje);

    }

    public void onClick(View view){
        Intent intent = new Intent();

        //Comprobamos la vista (el botón) que ha invocado al metodo
        int id = view.getId();
        if(id == R.id.btnAceptar){

            intent.putExtra("boton_pulsado","ACEPTAR");
            setResult(RESULT_OK, intent);
        }

        else if(id  == R.id.btnRechazar){

            intent.putExtra("boton_pulsado","RECHAZAR");
            setResult(RESULT_OK,intent);
        }
        else if(id == R.id.btnCancelar){

            setResult(RESULT_CANCELED, intent);
        }
        finish();
    }
}