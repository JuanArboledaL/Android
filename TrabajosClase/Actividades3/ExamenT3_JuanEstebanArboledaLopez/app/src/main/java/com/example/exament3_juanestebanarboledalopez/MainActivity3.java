package com.example.exament3_juanestebanarboledalopez;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinner = (Spinner) findViewById(R.id.objetivoDias);

        String[] valores = {"Dia 1","Dia 2","Dia 3","Dia 4","Dia 5", "Dia 6", "Dia 7"};

        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,valores));

    }
}