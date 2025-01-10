package com.example.practicaevaluaciont5.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.practicaevaluaciont5.R;

public class AcercadeActiity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.acercade);
        setSupportActionBar(toolbar);

        TextView ubicacion = findViewById(R.id.ubicacion);
        registerForContextMenu(ubicacion);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo
            menuInfo){

        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:36.695804,-4.457127?z=18"));
        startActivity(intent);
        return super.onContextItemSelected(item);
    }
}
