package com.example.ejemplolecturasd;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ESTE PROGRAMA FUNCIONA HASTA LA API 28
        //PARA QUE FUNCIONE EN TODAS LAS APIS, EJECUTAR CON LAS LÍNEAS COMENTADAS

        boolean sdDisponible = false;
        boolean sdAccesoEscrtura = false;

        //Comprobar el estado de la memoria sd
        String estado = Environment.getExternalStorageState();

        if ( estado.equals(Environment.MEDIA_MOUNTED)){
            sdDisponible = true;
            sdAccesoEscrtura = true;
        }
        else if(estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            sdDisponible = true;
        }

        if(sdDisponible && sdAccesoEscrtura){
            //Escribo en la tarjet SD
            try{

                //obtener la ruta del directorio raiz
                //File ruta_sd = Environment.getExternalStorageDirectory();

                File ruta_sd = getExternalFilesDir(null);

                File f = new File(ruta_sd.getAbsolutePath(),"prueba_sd.txt");

                OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
                fout.write("Texto de prueba");
                fout.close();
            }catch(Exception e){

                Log.e("Ficheros", "Error al escribir en la tarjeta SD");
            }

            //Leo los datos que acabo de escribir
            try{

                //File ruta_sd = Environment.getExternalStorageDirectory();
                File ruta_sd = getExternalFilesDir(null);

                File f = new File(ruta_sd.getAbsolutePath(),"prueba_sd.txt");
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

                String linea = in.readLine();
                Toast.makeText(this,linea,Toast.LENGTH_SHORT).show();
                in.close();

            }catch(Exception e){

                Log.e("Ficheros","Error al leer desde la tarjeta SD");
            }
        }

    }
}