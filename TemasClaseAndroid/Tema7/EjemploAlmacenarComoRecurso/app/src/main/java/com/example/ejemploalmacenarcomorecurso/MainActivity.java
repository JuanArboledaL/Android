package com.example.ejemploalmacenarcomorecurso;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            InputStream fraw = getResources().openRawResource(R.raw.fichero);
            BufferedReader in = new BufferedReader(new InputStreamReader(fraw));
            String linea = in.readLine();
            Toast.makeText(this,linea,Toast.LENGTH_SHORT).show();
            fraw.close();

        }catch(Exception e){

            Log.e("fichero","Error al leer desde recursos raw ");
        }
    }
}