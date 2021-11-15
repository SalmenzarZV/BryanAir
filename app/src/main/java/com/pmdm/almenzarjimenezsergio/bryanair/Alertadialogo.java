package com.pmdm.almenzarjimenezsergio.bryanair;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class Alertadialogo extends DialogFragment {
    Bundle bundle;

    public Alertadialogo(Bundle bundle) {
        this.bundle = bundle;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(R.string.alertDialogMessage).setTitle(R.string.alertDialogTitle)
                .setPositiveButton(R.string.aceptar, (dialogInterface, i) -> {
                    Context context = getContext();
                    Intent intent = new Intent(context, BillActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                })
                .setNegativeButton(R.string.cancelar, (dialogInterface, i) -> dialogInterface.cancel());

        return  builder.create();
    }


}
