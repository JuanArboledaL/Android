package com.example.ejemplodestruiractividades;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle estadoAlmacenado) {
        super.onCreate(estadoAlmacenado);
        setContentView(R.layout.activity_main);

        if(estadoAlmacenado != null){

            //Recuperamos una variable que se almacene con el estado
            Toast.makeText(this, "Evento onCreate(). Se recupera la variable almacenada" +
                    estadoAlmacenado.getString("VARIABLE_ALMACENADA"), Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    protected void onSaveInstanceState(@Nullable Bundle estado) {
        super.onSaveInstanceState(estado);

        //Añadimos una variable que se alamacena con el estado
        estado.putString("VARIABLE_ALCACENADA","texto guardado");
        Toast.makeText(this,"El estado de la actividad se ha guarado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "El sistema ha terminado la actividad", Toast.LENGTH_SHORT).show();
    }
}