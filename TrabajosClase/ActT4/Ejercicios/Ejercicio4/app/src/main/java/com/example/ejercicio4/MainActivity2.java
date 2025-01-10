package com.example.ejercicio4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onClick(View view){

        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);

        ImageButton img = findViewById(R.id.imgSpider);
        img.setImageResource(R.drawable.fantasma);

    }

    public void onClick2(View view){

        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);

        ImageButton img = findViewById(R.id.imgSpider);
        img.setImageResource(R.drawable.calabaza);

    }
}