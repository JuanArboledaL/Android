package com.example.act6;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

        Datos datos[]= new Datos[]{

                new Datos(R.drawable.ima1, "DONUTS", "El 15 de septiembre de 2009, fue lanzado el SDK de Android 1.6 Donut, basado en el núcleo Linux 2.6.29. En la actualización se incluyen numerosas características nuevas."),
                new Datos(R.drawable.ima2, "FROYO", "El 20 de mayo de 2010, El SDK de Android 2.2 Froyo (Yogur helado) fue lanzado, basado en el núcleo Linux 2.6.32."),
                new Datos(R.drawable.ima3, "GINGERBREAD", "El 20 de mayo de 2010, El SDK de Android 2.2 Froyo (Yogur helado) fue lanzado, basado en el núcleo Linux 2.6.32."),
                new Datos(R.drawable.ima4, "HONEYCOMB", "El 22 de febrero de 2011, sale el SDK de Android 3.0 Honeycomb (Panal de Miel). Fue la primera actualización exclusiva para TV y tableta, lo que quiere decir que sólo es apta para TV y tabletas y no para teléfonos Android."),
                new Datos(R.drawable.ima5, "ICE CREAM", "El SDK para Android 4.0.0 Ice Cream Sandwich (Sándwich de Helado), basado en el núcleo de Linux 3.0.1, fue lanzado públicamente el 12 de octubre de 2011."),
                new Datos(R.drawable.ima6, "JELLY BEAN", "Google anunció Android 4.1 Jelly Bean (Gomita Confitada o Gominola) en la conferencia del 30 de junio de 2012. Basado en el núcleo de linux 3.0.31, Bean fue una actualización incremental con el enfoque primario de mejorar la funcionalidad y el rendimiento de la interfaz de usuario."),
                new Datos(R.drawable.ima7, "KITKAT", "Su nombre se debe a la chocolatina KitKat, de la empresa internacional Nestlé. Posibilidad de impresión mediante WIFI. WebViews basadas en el motor de Chromium."),
                new Datos(R.drawable.ima8, "LOLLIPOP", "Incluye Material Design, un diseño intrépido, colorido, y sensible interfaz de usuario para las experiencias coherentes e intuitivos en todos los dispositivos. Movimiento de respuesta natural, iluminación y sombras realistas y familiares elementos visuales hacen que sea más fácil de navegar su dispositivo.")
        };


        //Instacio el listado XML
        final ListView listado = findViewById(R.id.listado);

        //Creo mi adaptador
        Adaptador miAdaptador = new Adaptador(this,datos);
        listado.setAdapter(miAdaptador);

        //Creo un listener para el listado
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                TextView texto = findViewById(R.id.texto);

                String seleccion = ((Datos)adapterView.getItemAtPosition(posicion)).getTexto2();
                texto.setText(seleccion);

            }
        });
    }
}