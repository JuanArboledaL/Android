package com.example.ejemplosqlite2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView lblConsulta = findViewById(R.id.lblConsulta);
        final EditText codigo= findViewById(R.id.etCodigo);
        final EditText nombre = findViewById(R.id.etNombre);
        final Button insertar = findViewById(R.id.btnInsertar);
        final Button borrar = findViewById(R.id.btnBorrar);
        final Button actualizar = findViewById(R.id.btnActualizar);
        final Button consultar = findViewById(R.id.btnConsultar);

        //Abrimos la base de datos en modo escritura
        UsuariosBBDD usarios = new UsuariosBBDD(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = usarios.getWritableDatabase();


        //Comprobamos que se haya abierto correctamente
        if(db!= null){

            //Inserto datos
            insertar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String cod = codigo.getText().toString();
                    String usuario = nombre.getText().toString();

                    ContentValues registro = new ContentValues();
                    registro.put("codigo", cod);
                    registro.put("nombre", usuario);
                    db.insert("Usuarios",null, registro);

                    //Borrar formulario
                    codigo.setText("");
                    nombre.setText("");
                }
            });

            //Borrar todos lod datos
            borrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.execSQL("DELETE FROM Usuarios");
                }
            });

            //Actuyalizo los datos
            actualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String cod= codigo.getText().toString();
                    String usuario = nombre.getText().toString();

                    String args[] = {usuario,cod};
                    db.execSQL("UPDATE Usuarios SET nombre=? WHERE codigo=?",args);

                }
            });

            //Consultar en la base de datos
            consultar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    lblConsulta.setText("");

                    Cursor miCursor = db.rawQuery("SELECT codigo, nombre FROM Usuarios", null);

                    if(miCursor.moveToFirst()){

                        do{

                            String cod = miCursor.getString(0);
                            String usuario = miCursor.getString(1);

                            lblConsulta.append(cod+ " "+ usuario+ "\n");
                        }while(miCursor.moveToNext());
                        miCursor.close();
                    }
                }
            });
        }
    }
}