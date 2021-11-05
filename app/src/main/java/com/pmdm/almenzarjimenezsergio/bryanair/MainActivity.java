package com.pmdm.almenzarjimenezsergio.bryanair;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btBuy;
    ImageButton ibPremium;
    CheckBox cbTerms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btBuy = findViewById(R.id.btBuy);
        ibPremium = findViewById(R.id.ibPremium);
        cbTerms = findViewById(R.id.cbTerms);

        btBuy.setOnClickListener(this);
        ibPremium.setOnClickListener(this);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }


    @Override
    public void onClick(View view) {
        if(cbTerms.isChecked()){
            if (view.equals(ibPremium)){
                FragmentManager fragmentManager = getSupportFragmentManager();
                Alertadialogo alertadialogo = new Alertadialogo();
                alertadialogo.show(fragmentManager, "tag");
            }

            if (view.equals(btBuy)){
                Snackbar mySnack = Snackbar.make(view ,"Gracias por su compra", Snackbar.LENGTH_LONG);
                mySnack.show();
            }
        } else {
            Toast.makeText(this, "Tiene que aceptar los terminos y condiciones", Toast.LENGTH_LONG).show();
        }

        /*
        if (view.equals(swInvalid)){
            if (swInvalid.isChecked()){
                Toast.makeText(this, "Lo siento, eres minusválido", Toast.LENGTH_LONG);
            } else {
                Toast.makeText(this, "Felicidades, no eres minusválido", Toast.LENGTH_LONG);
            }
        }

         */
    }
}