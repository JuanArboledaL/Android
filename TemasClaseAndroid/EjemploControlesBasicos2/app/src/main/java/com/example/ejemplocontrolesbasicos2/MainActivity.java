package com.example.ejemplocontrolesbasicos2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ejemplo creando los datos desde java
        Spinner spinner = findViewById(R.id.miSpinner);

        String valores[]={"Dato 1" , "Dato 2", "Datos 3", "Datos 4"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, valores));

        TextView texto = findViewById(R.id.txt1);
        String valor = spinner.getSelectedItem().toString();
        texto.setText(valor);

        //El valor no cambia, solo sale el que tomo cuando se ejecuto la app, para tomar el nuevo valor tengo que
        //definir un manejador de eventos

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adaptador, View view, int posicion, long id) {
                //Primera forma para obtener el elemnto
//                String cadena = (String) adaptador.getItemAtPosition(posicion);
//                texto.setText(cadena);

                //Segunda forma de obtener el elemento
                String cadena = adaptador.getSelectedItem().toString();
                texto.setText(cadena);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Ejemplo 2 de Spinner creando los datos desde el XML
        Spinner spinner2 = findViewById(R.id.miSpinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.valores, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adaptador, View view, int posicion, long id) {

                String cadena = (String) adaptador.getItemAtPosition(posicion);
                texto.setText(cadena);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Recupero el checkBox y creo el listener
        TextView texto2 = findViewById(R.id.lbl1);
        CheckBox checkBox = findViewById(R.id.miCheck);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean pulsado) {

                if(pulsado){

                    texto2.setText("Seleccionado");
                }else{

                    texto2.setText("Deseleccionado");
                }
            }
        });

        RadioGroup grupo = findViewById(R.id.grupo);
        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {

                final RadioButton rb = findViewById(checkId);
                texto2.setText(rb.getText().toString());
            }
        });

        //Recupero el id del switch y creo el listener
        final Switch pulsador = findViewById(R.id.miSwitch);
        pulsador.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean pulsado) {

                if(pulsado){
                    texto2.setText("Switch marcado");
                }else{
                    texto2.setText("Switch no pulsado");
                }
            }
        });



        //Raiting
        final RatingBar puntuacion= findViewById(R.id.miRiting);
        puntuacion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float valor, boolean b) {
                texto2. setText("Nuevo valor: "+ valor);
            }
        });

        //Seebak
        final SeekBar control = findViewById(R.id.miSeekBar);
        control.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                final TextView texto = findViewById(R.id.text3);
                texto.setAlpha(i/60f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                texto2.setText("Inicio de cambio de texto SeekBar");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                texto2.setText("Fin cambio de texto en SeekBar");
            }
        });

    }
}