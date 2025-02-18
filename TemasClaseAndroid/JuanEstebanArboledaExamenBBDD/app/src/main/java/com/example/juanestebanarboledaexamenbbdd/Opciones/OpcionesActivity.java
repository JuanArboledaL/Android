package com.example.juanestebanarboledaexamenbbdd.Opciones;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.juanestebanarboledaexamenbbdd.R;

public class OpcionesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones);
    }

}
