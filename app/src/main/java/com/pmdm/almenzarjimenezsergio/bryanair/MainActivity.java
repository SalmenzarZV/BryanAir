package com.pmdm.almenzarjimenezsergio.bryanair;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etDeparture, etDestination, etName, etSurname;

    Button btBuy;
    ImageButton ibPremium;
    CheckBox cbTerms;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch swInvalid;



    public void initActivity(){
        Intent intentAdd = new Intent(this, BuyActivity.class);
        Bundle bundleAdd = new Bundle();

        intentAdd.putExtras(bundleAdd);
        startActivity(intentAdd);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btBuy = findViewById(R.id.btBuy);
        ibPremium = findViewById(R.id.ibPremium);
        cbTerms = findViewById(R.id.cbTerms);
        swInvalid =  findViewById(R.id.swInvalid);

        etDeparture = findViewById(R.id.etDeparture);
        etDestination = findViewById(R.id.etDestination);
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);

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
        if(cbTerms.isChecked() && !emptyFields()){

            String departure, destination, name, surnane;
            departure = etDeparture.getText().toString();
            destination = etDestination.getText().toString();
            name = etName.getText().toString();
            surnane = etSurname.getText().toString();

            if (view.equals(ibPremium) || view.equals(btBuy)){
                int price = generateSeed(departure.toLowerCase(), destination.toLowerCase());
                if (view.equals(ibPremium)) price+= 500;

                Intent intent = new Intent(this, BuyActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("departure", departure);
                bundle.putString("destination", destination);
                bundle.putString("name", name);
                bundle.putString("surname", surnane);
                bundle.putInt("price", price);
                intent.putExtras(bundle);
                startActivity(intent);
            }

        } else {
            Toast.makeText(this, "Tiene que aceptar los terminos y condiciones y rellenar los campos con *", Toast.LENGTH_LONG).show();
        }

    }

    private int generateSeed(String departure, String destination) {
        int price;
        String seedText = departure + destination;
        int seed=0;
        for (int i = 0; i<seedText.length(); i++){
            seed += seedText.getBytes(StandardCharsets.UTF_8)[i];
        }

        return price = seed;
    }

    private boolean emptyFields() {
        boolean empty = false;
        if(etName.getText().toString().length() == 0 || etSurname.getText().toString().length() == 0 ||
                etDestination.getText().toString().length() == 0 ||
                etDeparture.getText().toString().length() == 0){

            empty = true;

        }
        return empty;
    }

}