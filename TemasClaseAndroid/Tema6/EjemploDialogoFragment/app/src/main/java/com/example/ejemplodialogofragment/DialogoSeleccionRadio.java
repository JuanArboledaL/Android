package com.example.ejemplodialogofragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoSeleccionRadio extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final String[]  items = {"Español","Ingles", "Frances", "Alemán"};
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());

        builder.setTitle("Selección Radio")
                .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Log.i("Dialogos", "Opción elejida" + items[i]);
                    }
                });

        return builder.create();
    }
}
