package com.example.exament3_juanestebanarboledalopez;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView titulo1 = findViewById(R.id.tittle4);
        final Button peso= findViewById(R.id.btnPerderPeso);
        final Button fuerte = findViewById(R.id.btnFuerte);
        final Button forma = findViewById(R.id.btnForma);
        final Button siguiente = findViewById(R.id.btnSiguiente);



        fuerte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fuerte.setBackgroundColor(Color.rgb(243,230,248));
                peso.setBackgroundColor(Color.rgb(247,193,234));
                forma.setBackgroundColor(Color.rgb(247,193,234));
            }
        });
        peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                peso.setBackgroundColor(Color.rgb(243,230,248));
                fuerte.setBackgroundColor(Color.rgb(247,193,234));
                forma.setBackgroundColor(Color.rgb(247,193,234));
            }
        });
        forma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                forma.setBackgroundColor(Color.rgb(243,230,248));
                fuerte.setBackgroundColor(Color.rgb(247,193,234));
                peso.setBackgroundColor(Color.rgb(247,193,234));
            }
        });

    }

    public void onClick(View view){

        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);

    }
}