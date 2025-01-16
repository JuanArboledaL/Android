package com.example.ejemplodialogofragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager FM = getSupportFragmentManager();
        final Button btnConfirmacion = findViewById(R.id.btnConfirmacion);
        final Button btnSeleccion = findViewById(R.id.btnSeleccion);
        final Button btnRadio = findViewById(R.id.btnRadiio);
        final Button btnCheck = findViewById(R.id.btnCheck);
        final Button btnDialogoPersonalizado = findViewById(R.id.btnDialogPersonalizado);

        final Button btnAlerta = findViewById(R.id.btnAlerta);
        btnAlerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogoAlerta dialogo = new DialogoAlerta();
                dialogo.show(FM,"tagAlerta");
            }
        });

        btnConfirmacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogoConfirmación dialog = new DialogoConfirmación();
                dialog.show(FM,"tagConfirmación");
            }
        });

        btnSeleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogoSeleccion dialogo = new DialogoSeleccion();
                dialogo.show(FM,"tagSelección");
            }
        });

        btnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogoSeleccionRadio  dialogo = new DialogoSeleccionRadio();
                dialogo.show(FM , "tagRadio");
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogoSeleccionCheck dialogo = new DialogoSeleccionCheck();
                dialogo.show(FM, "tagCheck");
            }
        });

        btnDialogoPersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogoPersonalizado dialogo  = new DialogoPersonalizado();
                dialogo.show(FM, "tagPersonalizado");
            }
        });
    }
}