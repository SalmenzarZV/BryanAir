package com.pmdm.almenzarjimenezsergio.bryanair;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class Alertadialogo extends DialogFragment {
    String etDeparture, etDestination, etName, etApellidos;

    public Alertadialogo(String etDeparture, String etDestination, String etName, String etApellidos) {
        this.etDeparture = etDeparture;
        this.etDestination = etDestination;
        this.etName = etName;
        this.etApellidos = etApellidos;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(R.string.alertDialogMessage).setTitle(R.string.alertDialogTitle)
                .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        return  builder.create();
    }


}
