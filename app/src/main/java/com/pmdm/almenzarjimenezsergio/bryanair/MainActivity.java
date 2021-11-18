package com.pmdm.almenzarjimenezsergio.bryanair;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //instance params
    Button btBuy;
    ImageButton ibPremium;
    CheckBox cbTerms, cbWindow, cbPet, cbFirstClass;
    boolean window, pet, firstClass, insurance, premium;
    EditText etDestination, etDeparture, etName, etSurname, etDate;
    String destination, departure, name, date;
    RadioButton rbYes;
    int price;


    /**
     * Creation of visuals and logics foo activity_main.xml
     * @param savedInstanceState (Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    /**
     * activity_main components initialization.
     */
    private void initialize() {
        btBuy = findViewById(R.id.btBuy);
        ibPremium = findViewById(R.id.ibPremium);
        cbTerms = findViewById(R.id.cbTerms);
        cbWindow = findViewById(R.id.cbWindow);
        cbPet = findViewById(R.id.cbPet);
        cbFirstClass = findViewById(R.id.cbFirstClass);
        rbYes = findViewById(R.id.rbYes);
        etDestination = findViewById(R.id.etDestination);
        etDeparture = findViewById(R.id.etDeparture);
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etDate = findViewById(R.id.etDate);

        price =0;
        window = pet = insurance = firstClass = premium = false;

        btBuy.setOnClickListener(this);
        ibPremium.setOnClickListener(this);
        etDate.setOnClickListener(this);
    }

    /**
     * EditText harvesting
     */
    private void stringsInit() {
        destination  = etDestination.getText().toString();
        departure = etDeparture.getText().toString();
        name = etName.getText().toString() + " " + etSurname.getText().toString();
        date = etDate.getText().toString();
    }

    /**
     * Options Menu creation
     * @param menu Created
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String url;
        switch (item.getItemId()){
            case R.id.subItemPersonalData:

                break;

            case R.id.menuItemPrivacityPolicy:
                url = "https://www.ryanair.com/es/es/empresa/politica-de-privacidad";
                goWeb(url);

                break;

            case R.id.menuItemContact:
                url = "https://help.ryanair.com/hc/es-es/articles/360017684097?q=0";
                goWeb(url);
                break;

            case R.id.menuItemHelpCenter:
                url = "https://help.ryanair.com/hc/es-es?q=0";
                goWeb(url);
        }
        return super.onOptionsItemSelected(item);
    }

    private void goWeb(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        finish();
    }

    /**
     * onClick functions for activity_main views
     * @param view -> ibPremium, btBuy, etDate
     */
    @Override
    public void onClick(View view) {
        //MainActivity -> BuyActivity;
        if (view.equals(ibPremium) || view.equals(btBuy)){
            if(cbTerms.isChecked() && !emptyFields()){
                stringsInit();
                calcuPrice(view);
                Configuration config = getResources().getConfiguration();
                Intent intent;
                if (config.smallestScreenWidthDp >=600){
                    intent = new Intent(this, BillBuyActivity.class);
                } else {
                    intent = new Intent(this, BuyActivity.class);
                }

                intent.putExtras(putBundle());
                startActivity(intent);
            } else {
                Toast.makeText(this, "Tiene que aceptar los terminos y condiciones y rellenar los campos requeridos", Toast.LENGTH_LONG).show();
            }
        }

        //DatePicker init
        if (view.equals(etDate)){
            DatePickerFragment newFragment = new DatePickerFragment(etDate);
            newFragment.show(getSupportFragmentManager(), "datepicker");
        }

    }

    /**
     *  Travel Price generation.
     * @param view control between ibPremium & btBuy
     */
    private void calcuPrice(View view) {
        price = 0;

        for(int i = 0; i < destination.length(); i++){
            price += destination.toLowerCase().charAt(i);
        }

        for(int i = 0; i < departure.length(); i++){
            price += departure.toLowerCase().charAt(i);
        }
        String[] dateFields = date.split("/");

        for (String dateField : dateFields) {
            price += (Integer.parseInt(dateField) / 5);
        }

        price /= 5;

        if (view.equals(ibPremium)){
            price += 500;
            premium = true;
        }

        if (cbFirstClass.isChecked()){
            price += 500;
            firstClass = true;
        }

        if (cbWindow.isChecked()){
            price += 50;
            window = true;
        }

        if (rbYes.isChecked()){
            price += 500;
            insurance = true;
        }

        if (cbPet.isChecked()){
            pet = true;
        }
    }

    /**
     * Empty fields control
     * @return true/false (empty/!empty)
     */
    private boolean emptyFields() {
        return etDestination.getText().toString().length() == 0 ||
                etDeparture.getText().toString().length() == 0 ||
                etName.getText().toString().length() == 0 ||
                etSurname.getText().toString().length() == 0 ||
                etDate.getText().toString().length() == 0;
    }

    /**
     * Bundle instance and inflate
     * @return bundle
     */
    private Bundle putBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("departure", departure);
        bundle.putString("destination", destination);
        bundle.putString("date", date);
        bundle.putInt("price", price);
        bundle.putBoolean("premium", premium);
        bundle.putBoolean("pet", pet);
        bundle.putBoolean("insurance", insurance);
        bundle.putBoolean("firstClass", firstClass);
        bundle.putBoolean("window", window);

        return bundle;
    }

    //BUSCAR NOSEQUE DE LOS ARGUMENTS
    private Bundle putBundleArguments() {
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("departure", departure);
        bundle.putString("destination", destination);
        bundle.putString("date", date);
        bundle.putInt("price", price);
        bundle.putBoolean("premium", premium);
        bundle.putBoolean("pet", pet);
        bundle.putBoolean("insurance", insurance);
        bundle.putBoolean("firstClass", firstClass);
        bundle.putBoolean("window", window);

        return bundle;
    }
}