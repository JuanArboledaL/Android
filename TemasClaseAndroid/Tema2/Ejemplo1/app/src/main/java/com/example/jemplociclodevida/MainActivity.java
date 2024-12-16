package com.example.jemplociclodevida;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Definimos el elemento del callBack de la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //usamos la clase Toast que muestre durante 2 segundos un mensaje pequeño al usuario
            Toast.makeText(this, "Se ejecuta el método onCreate", Toast.LENGTH_SHORT).show();

    }

    //Defino el método de llamada onPause de la actividad
    @Override
    protected void onPause() {
        super.onPause();

        //Aquí deberiamos de guaradar la información para la siguiente sesión
        Toast.makeText(this, "Se ejecuta el método onPause", Toast.LENGTH_SHORT).show();
    }


    //Definimos el método de llamada onStart de la actividad


    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "Se ejecuta el método onRestart", Toast.LENGTH_SHORT).show();

    }

    //Definimos el metodo callBack onResume de la aplicación
    @Override
    protected void onResume() {

        super.onResume();


        Toast.makeText(this, "Se ejecuta el método onResume", Toast.LENGTH_SHORT).show();

    }

    //Definimos el metodo onStart de la aplicacion
    protected void onStart() {
        super.onStart();

        //Aquí deberiamos leer los datos de la ultima sesion para continuat la actividad
        //donde la dejo el usuario
        Toast.makeText(this, "Se ejecuta el método onStart", Toast.LENGTH_SHORT).show();

    }

    //Definimos el metodo onDrestroid de la aplicacion
    @Override
    protected void onDestroy() {
        super.onDestroy();

        //Si no tenemos memoria suficiente, andorid destruye la actividad sin ejecutar el método
        Toast.makeText(this, "Se ejecuta el método onDestroid", Toast.LENGTH_SHORT).show();

    }

    //Definimos el metodo onStop de la aplicacion
    @Override
    protected void onStop() {
        super.onStop();

        //Si no tenemos memoria suficiente, andorid destruye la actividad sin ejecutar el método
        Toast.makeText(this, "Se ejecuta el método onStop", Toast.LENGTH_SHORT).show();

    }
}