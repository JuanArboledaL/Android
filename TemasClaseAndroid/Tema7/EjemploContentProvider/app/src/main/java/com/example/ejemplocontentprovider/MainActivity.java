package com.example.ejemplocontentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Elementos Layout
    private Button btnInsertar;
    private Button btnConsultar;
    private Button btnEliminar;
    private TextView txtResultados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias a los controles
        txtResultados = findViewById(R.id.txtResultados);
        btnInsertar = findViewById(R.id.btnInsertar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnConsultar = findViewById(R.id.btnConsultar);

        //creo la consulta con el comntent resolver

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Columnas que vamos a recuperar
                String[] columnas = {

                        ClientesProvider.Clientes._ID,
                        ClientesProvider.Clientes.COL_NOMBRE,
                        ClientesProvider.Clientes.COL_TELEFONO,
                        ClientesProvider.Clientes.COL_EMAIL

                };

                Uri uri = ClientesProvider.CONTENT_URI;
                ContentResolver cr = getContentResolver();

                //Hacemos las consultas
                Cursor cur = cr.query(

                        uri,
                        columnas,  //Columnas a devolver
                        null,       //Condicion de la consulta
                        null,       //Argumentos de la consulta
                        null        //Orden de los resultados
                );

                if(cur != null){

                    if(cur.moveToFirst()){

                        String nombre;
                        String telefono;
                        String email;

                        int colNombre = cur.getColumnIndex(ClientesProvider.Clientes.COL_NOMBRE);
                        int colTelefono = cur.getColumnIndex(ClientesProvider.Clientes.COL_TELEFONO);
                        int colEmail = cur.getColumnIndex(ClientesProvider.Clientes.COL_EMAIL);

                        txtResultados.setText("");

                        do{

                            nombre = cur.getString(colNombre);
                            telefono = cur.getString(colTelefono);
                            email = cur.getString(colEmail);

                            txtResultados.append(nombre + " - " + telefono +" - " + email + " - "+"\n");

                        }while(cur.moveToNext());
                    }
                }

            }
        });

        //INSERTO DATOS con el content resolver en el content provider
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues registro = new ContentValues();
                registro.put(ClientesProvider.Clientes.COL_NOMBRE,"Cliente nuevo");
                registro.put(ClientesProvider.Clientes.COL_TELEFONO,"9911222");
                registro.put(ClientesProvider.Clientes.COL_EMAIL,"nuevo@gmail.com");

                ContentResolver cr =  getContentResolver();

                cr.insert(ClientesProvider.CONTENT_URI,registro);
            }
        });

        //Eliminar datos con el content resolver
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentResolver cr = getContentResolver();
                cr.delete(ClientesProvider.CONTENT_URI, ClientesProvider.Clientes.COL_NOMBRE +"='Cliente Nuevo'", null);

            }
        });

    }
}