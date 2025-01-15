package com.example.ejemplorecycleview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Opciones> datos;
    private RecyclerView recyclerView;
    private Button btnInsertar;
    private Button btnBorrar;
    private Button btnIncbtnMover;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperamos el RecycleView

        recyclerView = findViewById(R.id.recView);


        //Indicar que el recicleView no cambie de tamaño
        recyclerView.setHasFixedSize(true);

        //Creo los datos
        datos = new ArrayList<Opciones>();
        for (int i = 1 ; i<= 32; i++){

            if(i % 2 == 0){
                datos.add( new Opciones("Opción " + i, " Esta es la opción número " + i, R.drawable.star1));

            }else{

                datos.add( new Opciones("Opción " + i, " Esta es la opción número " + i, R.drawable.star2));
            }
        }

        //Crear Adaptador que se usa para mostrar las opciones del listado
        final AdaptadorOpciones adaptadorOpciones= new AdaptadorOpciones(datos);

        //Definimos el evento Onclick (se ha definido en el adaptador)
        adaptadorOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this," has hecho click en " + datos.get(recyclerView.getChildAdapterPosition(view)).getTitulo(),Toast.LENGTH_SHORT).show();
            }
        });

        //aSIGNO ADAPTADOR Y LAYOUTR
        recyclerView.setAdapter(adaptadorOpciones);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Defiimos los eventos onClick
        btnInsertar = findViewById(R.id.insertar);
        btnBorrar = findViewById(R.id.borrar);
        btnIncbtnMover = findViewById(R.id.mover);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datos.add(1, new Opciones("Nueva opción ", "Subytitulo nueva opción", R.drawable.star1));
                adaptadorOpciones.notifyItemInserted(1);
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(datos.size()<2) return;

                datos.remove(1);
                adaptadorOpciones.notifyItemRemoved(1);
            }
        });

        btnIncbtnMover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(datos.size() < 2) return;

                Opciones aux  = datos.get(1);
                datos.set(1,datos.get(2));
                datos.set(2,aux);

                adaptadorOpciones.notifyItemMoved(1,2);
            }
        });
    }
}