package com.example.ejemplomemoriainterna;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Escribir en la memoria interna
        try{

            OutputStreamWriter miFichero = new OutputStreamWriter(openFileOutput("fichero.txt", Context.MODE_PRIVATE));
            miFichero.write("TEXTO PRUEBA") ;
            miFichero.close();
        }catch (Exception e){

            Log.e("Fichero","Error al escribir en la memoria interna");
        }

        //Recuperar informacion de la memoria uinterna
        try{

            BufferedReader miFichero = new BufferedReader(new InputStreamReader(openFileInput("fichero.txt")));
            String texto = miFichero.readLine();
            Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();

            miFichero.close();

        }catch(Exception e){

            Log.e("Fichero","Error al leer de la memeoria interna");
        }

    }
}