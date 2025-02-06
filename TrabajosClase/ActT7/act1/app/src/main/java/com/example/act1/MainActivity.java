package com.example.act1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button guardar = findViewById(R.id.guardar);
        Button recuperar = findViewById(R.id.recuperar);

        EditText txt1 = findViewById(R.id.ed1);
        EditText txt2 = findViewById(R.id.ed2);

        TextView texto1 = findViewById(R.id.txt1);
        TextView texto2 = findViewById(R.id.txt2);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor =pref.edit();
                editor.putString("dato1", txt1.getText().toString());
                editor.putString("dato2", txt2.getText().toString());

                editor.commit();
            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref=getSharedPreferences("preferencias", Context.MODE_PRIVATE);

                String mensaje1, mensaje2;
                mensaje1 = pref.getString("dato1", "");
                mensaje2= pref.getString("dato2","");
                texto1.setText(mensaje1);
                texto2.setText(mensaje2);

            }
        });
    }
}