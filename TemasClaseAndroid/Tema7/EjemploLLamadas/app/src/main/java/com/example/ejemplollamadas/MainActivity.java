package com.example.ejemplollamadas;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    private static final int PERMISSION_REQUEST_CONTACTS = 0;
    private static final int PERMISSION_REQUEST_CALL_LOG=1;
    private Button btnLlamadas;
    private TextView lblResultados;
    private LinearLayout vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLlamadas = findViewById(R.id.btnLLamadas);
        lblResultados = findViewById(R.id.lblResultados);
        vista = findViewById(R.id.listaPrincipal);

        //Accedo al content provider público a partir de la API 22
        btnLlamadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarLLamadas();
            }
        });

    }

    private void realizarLLamadas(){

        //comprobar si los permisos necesarios han sido consedidos
        //Elijo el manifest de Android porque si no no va areconocer

        int permisoLecturaHistorial = ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.READ_CALL_LOG);

        if(permisoLecturaHistorial != PackageManager.PERMISSION_GRANTED){

            //Pido permisos
            peticionPermisos(android.Manifest.permission.READ_CALL_LOG,
                    new String[]{android.Manifest.permission.READ_CALL_LOG},
                    PERMISSION_REQUEST_CALL_LOG,
                    "a los contactos");
        }else{

            //Los permisos han sido concedidos, compruebo las llamadas
            String columnas[] = {CallLog.Calls.TYPE, CallLog.Calls.NUMBER};
            Uri llamadasUri =CallLog.Calls.CONTENT_URI;

            ContentResolver cr = getContentResolver();
            Cursor cur = cr.query(llamadasUri,columnas,null,null,null);
            if(cur!= null){

                if(cur.moveToFirst()){

                    int tipo;
                    String tipoLLamadas="";
                    String telefono;

                    int colTipo = cur.getColumnIndex(CallLog.Calls.TYPE);
                    int colTelefono = cur.getColumnIndex(CallLog.Calls.NUMBER);

                    lblResultados.setText("");

                    do{

                        tipo = cur.getInt(colTipo);
                        telefono = cur.getString(colTelefono);

                        if(tipo == CallLog.Calls.INCOMING_TYPE){

                            tipoLLamadas = "ENTRADA";
                        }else if(tipo == CallLog.Calls.OUTGOING_TYPE){

                            tipoLLamadas = "SALIDA";
                        }else if(tipo == CallLog.Calls.MISSED_TYPE){
                            tipoLLamadas = "PERDIDA";


                        }
                        lblResultados.append((tipoLLamadas +" - " + telefono + "\n"));
                    }while(cur.moveToNext());
                }

            }

        }
    }
    private void peticionPermisos(String permiso, String[] manifest, int id, String tipo){

        //El usuario denego el permiso al menos una vex pero NO seleccionó "no volver a preguntar"

        if(ActivityCompat.shouldShowRequestPermissionRationale(this,permiso)){

            Snackbar.make(vista, "Es necesario el acceso " + tipo + " para su gestión de la app",
                    Snackbar.LENGTH_INDEFINITE).setAction("ACEPTAR", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ActivityCompat.requestPermissions(MainActivity.this, manifest, id);
                }
            }).show();
        }else{

            //El permiso aun no ha sido solicitado o Marcó "NO VOLVER A PREGUNTAR"
            ActivityCompat.requestPermissions(MainActivity.this, manifest, id);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){

            case PERMISSION_REQUEST_CALL_LOG:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                    Snackbar.make(vista,"Permiso de lectura historial establecido",
                    Snackbar.LENGTH_LONG).show();
                }else {

                    Snackbar.make(vista,"Permisod de lectura de contaxtos denegado",
                            Snackbar.LENGTH_LONG).show();
                }
                break;
        }
    }
}