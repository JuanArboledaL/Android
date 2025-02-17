package com.example.act7;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button btnGuardar = findViewById(R.id.guardar);
        final Button btnResuperar = findViewById(R.id.recuperar);
        final EditText editext = findViewById(R.id.edi);
        final TextView txt = findViewById(R.id.txt);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean sdDisponible = false;
                boolean sdAccesoEscrtura = false;
                String estado = Environment.getExternalStorageState();

                if(estado.equals(Environment.MEDIA_MOUNTED)){

                    sdDisponible = true;
                    sdAccesoEscrtura =true;

                }else if(estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){

                    sdDisponible = true;
                }

                if(sdDisponible && sdAccesoEscrtura){

                    try{

                        File ruta_sd = getExternalFilesDir(null);

                        File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");

                        OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));

                        fout.write(editext.getText().toString());
                        fout.close();
                    }catch (Exception e){

                        Log.e("Ficheros", "Error al escribir en la tarjeta SD");
                    }
                }
            }
        });

        btnResuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    File ruta_sd = getExternalFilesDir(null);

                    File f = new File(ruta_sd.getAbsolutePath(),"prueba_sd.txt");
                    BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

                    String linea = in.readLine();
                    txt.setText(linea);
                    in.close();

                }catch(Exception e){

                    Log.e("Ficheros","Error al leer desde la tarjeta SD");
                }
            }
        });
    }
}