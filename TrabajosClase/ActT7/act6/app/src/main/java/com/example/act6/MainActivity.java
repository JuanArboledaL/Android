package com.example.act6;

import static android.content.Context.*;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button btnGuardar = findViewById(R.id.guaradar);
        final Button btnRecuperar = findViewById(R.id.recuperar);
        final EditText editext = findViewById(R.id.ediText);
        final TextView txt = findViewById(R.id.txt);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    OutputStreamWriter miFichero = new OutputStreamWriter(openFileOutput("fichero.txt", MODE_PRIVATE));
                    miFichero.write(editext.getText().toString());
                    miFichero.close();
                }catch(Exception e){

                    Log.e("Fichero","Error al escribir en la memoria interna");
                }
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    BufferedReader miFichero = new BufferedReader(new InputStreamReader(openFileInput("fichero.txt")));
                    txt.setText(miFichero.readLine());
                    miFichero.close();

                }catch(Exception e){

                    Log.e("Fichero","Error al leer de la memeoria interna");
                }
            }
        });
    }
}