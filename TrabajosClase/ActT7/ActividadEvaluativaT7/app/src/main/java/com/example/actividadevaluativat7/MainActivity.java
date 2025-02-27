package com.example.actividadevaluativat7;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.actividadevaluativat7.AdaptadorLista.Adaptador;
import com.example.actividadevaluativat7.AdaptadorLista.Datos;
import com.example.actividadevaluativat7.AdaptadorSpinner.AdaptadorSpinner;
import com.example.actividadevaluativat7.AdaptadorSpinner.DatosSpinner;
import com.example.actividadevaluativat7.bbdd.ProveedorContactos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int avatarSeleccionado = 0;
    private int contactoSeleccionado = 0;

    LinearLayout principal;
    private Adaptador adaptador;
    private Spinner spinner;
    private Button btnAdd;
    private Button btnCancel;
    private Button btnUpd;
    private ListView lista;
    private EditText name;
    private EditText number;
    private ImageButton addContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addContact = findViewById(R.id.imgAdd);
        principal = findViewById(R.id.principal);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);
        btnUpd = findViewById(R.id.btnUpd);

        name = findViewById(R.id.name);
        number = findViewById(R.id.number);

        lista = findViewById(R.id.listaContactos);
        registerForContextMenu(lista);

        spinner = findViewById(R.id.spinnerImagenes);
        DatosSpinner[] datosSpinners = new DatosSpinner[] {
                new DatosSpinner(R.drawable.batman),
                new DatosSpinner(R.drawable.capi),
                new DatosSpinner(R.drawable.hulk),
                new DatosSpinner(R.drawable.deadpool),
                new DatosSpinner(R.drawable.furia),
                new DatosSpinner(R.drawable.ironman),
                new DatosSpinner(R.drawable.lobezno),
                new DatosSpinner(R.drawable.spiderman),
                new DatosSpinner(R.drawable.thor),
                new DatosSpinner(R.drawable.wonderwoman),
        };

        iniciarLista();

        AdaptadorSpinner miAdaptador = new AdaptadorSpinner(this,datosSpinners);
        spinner.setAdapter(miAdaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                avatarSeleccionado = ((DatosSpinner) parent.getItemAtPosition(position)).getImagen();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
                principal.setVisibility(View.VISIBLE);
                btnAdd.setVisibility(View.VISIBLE);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(ProveedorContactos.Contactos.COL_NAME, name.getText().toString());
                values.put(ProveedorContactos.Contactos.COL_NUMBER, number.getText().toString());
                values.put(ProveedorContactos.Contactos.COL_AVATAR, avatarSeleccionado);

                ContentResolver contentResolver = getContentResolver();
                contentResolver.insert(ProveedorContactos.CONTENT_URI, values);
                limpiar();
                iniciarLista();
                principalVisible();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                principalVisible();
            }
        });

        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(ProveedorContactos.Contactos.COL_NAME, name.getText().toString());
                values.put(ProveedorContactos.Contactos.COL_NUMBER, number.getText().toString());
                values.put(ProveedorContactos.Contactos.COL_AVATAR, avatarSeleccionado);

                ContentResolver contentResolver = getContentResolver();
                contentResolver.update(ProveedorContactos.CONTENT_URI,values, ProveedorContactos.Contactos._ID + "=" + contactoSeleccionado, null);
                limpiar();
                iniciarLista();
                principalVisible();
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contactoSeleccionado = ((Datos) adaptador.getItem(position)).getIndice();
            }
        });
    }

    private void iniciarLista() {
        String[] columnas = new String[]{
                ProveedorContactos.Contactos._ID,
                ProveedorContactos.Contactos.COL_NAME,
                ProveedorContactos.Contactos.COL_NUMBER,
                ProveedorContactos.Contactos.COL_AVATAR,
        };
        Uri versionesUri = ProveedorContactos.CONTENT_URI;
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(versionesUri, columnas, null,null,null);
        Datos objetoDato;

        ArrayList<Datos> datos = new ArrayList<Datos>();
        adaptador = new Adaptador(this,datos);
        if (cur != null) {
            if (cur.moveToFirst()) {
                int colId = cur.getColumnIndex(ProveedorContactos.Contactos._ID);
                int colNom = cur.getColumnIndex(ProveedorContactos.Contactos.COL_NAME);
                int colTel = cur.getColumnIndex(ProveedorContactos.Contactos.COL_NUMBER);
                int colPer =cur.getColumnIndex(ProveedorContactos.Contactos.COL_AVATAR);

                do {
                    int id = cur.getInt(colId);
                    String nombre = cur.getString(colNom);
                    String telefono=cur.getString(colTel);
                    int avatar = cur.getInt(colPer);
                    objetoDato = new Datos(id, nombre,telefono,avatar);
                    datos.add(objetoDato);
                } while (cur.moveToNext());
            }
        }
        lista.setAdapter(adaptador);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int position = info.position;
        Datos contacto = adaptador.getItem(position);
        contactoSeleccionado = contacto.getIndice();

        if(item.getItemId() == R.id.borrarItem) {
            ContentResolver cr = getContentResolver();
            cr.delete(ProveedorContactos.CONTENT_URI, ProveedorContactos.Contactos._ID + "=" + contactoSeleccionado, null);
            iniciarLista();
            return true;
        }else if (item.getItemId() == R.id.actualizarItem) {
            name.setText(contacto.getNombre());
            int posicionAvatar = posicionAvatar(contacto.getPersonaje());
            spinner.setSelection(posicionAvatar);
            number.setText(contacto.getTelefono());

            principal.setVisibility(View.VISIBLE);
            btnAdd.setVisibility(View.GONE);
            btnUpd.setVisibility(View.VISIBLE);
            iniciarLista();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    private int posicionAvatar(int avatar) {
        AdaptadorSpinner adapter = (AdaptadorSpinner) spinner.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++) {
            if (adapter.getItem(i).getImagen() == avatar) {
                return i;
            }
        }
        return 0;
    }

    private void principalVisible() {
        principal.setVisibility(View.GONE);
        btnAdd.setVisibility(View.GONE);
        btnUpd.setVisibility(View.GONE);
    }

    private void limpiar() {
        name.setText("");
        number.setText("");
    }

}