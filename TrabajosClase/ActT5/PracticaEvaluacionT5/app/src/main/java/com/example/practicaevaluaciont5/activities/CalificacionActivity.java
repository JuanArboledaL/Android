package com.example.practicaevaluaciont5.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.practicaevaluaciont5.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalificacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.calificacion);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        Button enviar = findViewById(R.id.enviar);
        RatingBar calificacion = findViewById(R.id.calificacion);
        TextInputEditText opinion = findViewById(R.id.comentario);
        TextInputLayout texto = findViewById(R.id.textInput);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(String.valueOf(opinion.getText()).isEmpty()){

                    texto.setHelperText("Ingrese una opinión por favor.");

                }else{

                    texto.setHelperText("");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");

                    String mensaje = getHora(simpleDateFormat.format(new Date())) + " envio mis opiniones sobre la experiencia en la aplicación: \n"
                            .concat(String.valueOf(opinion.getText()).concat("\n")
                                    .concat("Calificación: ").concat(String.valueOf(calificacion.getNumStars())).concat(" estrellas."));
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT,"Sugerencias");
                    intent.putExtra(Intent.EXTRA_TEXT, mensaje);
                    intent.putExtra(Intent.EXTRA_EMAIL, new
                            String[]{"juanarboledalopez@gmail.com"});
                    startActivity(intent);
                }

            }
        });
    }

    private String getHora(String hora){
        int numeroHora = Integer.parseInt(hora);
        String saludo;

        if( numeroHora < 12){

            saludo= "Buenos dias";

        }else if(numeroHora >= 12 && numeroHora < 18 ){

            saludo = "Buenas tardes";

        }else{

            saludo = "Buenas noches";
        }

        return saludo;
    }
}