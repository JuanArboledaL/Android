package com.example.ejemplofragmentcompact;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         setContentView(R.layout.activity_settings);

        getSupportFragmentManager().beginTransaction().replace(R.id.main, new OpcionesPreferencias()).commit();
    }
}
