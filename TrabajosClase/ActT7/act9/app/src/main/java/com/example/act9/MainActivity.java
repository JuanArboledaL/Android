package com.example.act9;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button actualizar = findViewById(R.id.btnActualizar);
        final Button borrar = findViewById(R.id.btnBorrar);
        final Button insertar = findViewById(R.id.insertar);
        final Button act = findViewById(R.id.act);
        final Button cons = findViewById(R.id.cons);

        final LinearLayout ly = findViewById(R.id.layout);

        final EditText nombre = findViewById(R.id.nombre);
        final EditText apellido = findViewById(R.id.apellido);
        final EditText codigo = findViewById(R.id.codigo);

        final TextView resultado = findViewById(R.id.resultados);


        BBDDActivity registro = new BBDDActivity(this, "DBRegistro",null,1);
        SQLiteDatabase db = registro.getWritableDatabase();

        if(db != null){

            insertar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    contador++;
                    String  nom = nombre.getText().toString();
                    String ap = apellido.getText().toString();

                    ContentValues content = new ContentValues();
                    content.put("codigo", contador);
                    content.put("nombre",nom);
                    content.put("apellidos",ap);
                    db.insert("Registro",null,content);

                    nombre.setText("");
                    apellido.setText("");
                }
            });

            act.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ly.setVisibility(View.VISIBLE);
                }
            });

            cons.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    resultado.setText("");

                    Cursor c = db.rawQuery("SELECT codigo, nombre, apellidos FROM Registro", null);

                    if(c.moveToFirst()){

                        do{

                            String cod =  c.getString(0);
                            String usuario = c.getString(1);
                            String apellido = c.getString(2);

                            resultado.append(cod + " " + usuario +" "+ apellido + " \n");
                        }while (c.moveToNext());
                    }
                }
            });

            actualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ContentValues c = new ContentValues();
                    c.put("nombre",nombre.getText().toString());
                    c.put("apellidos",apellido.getText().toString());
                    db.update("Registro",c,"codigo="+codigo.getText().toString(),null);
                }
            });

            borrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    db.delete("Registro","codigo=" + codigo.getText().toString(),null);
                    Toast.makeText(MainActivity.this, "Se elimino el usuario" + nombre.getText().toString(), Toast.LENGTH_SHORT).show();
                    codigo.setText("");
                }
            });
        }


    }
}