package com.pmdm.almenzarjimenezsergio.bryanair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class BillActivity extends AppCompatActivity {
    //instance params
    TextView tvNameBill, tvDestinationBill, tvDepartureBill, tvPremiumBill, tvWindowBill, tvPetBill,
            tvFirstClassBill, tvInsuranceBill, tvPriceBill, tvDateBill;
    String departure, destination, name, price, date;
    Bundle bundle;
    Button btBack;
    boolean window, pet, firstClass, insurance, premium;

    /**
     * Creation of visuals and logics foo activity_bill.xml
     * @param savedInstanceState (Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        initialize();
    }

    /**
     * activity_bill components initialization.
     */
    private void initialize() {
        bundle = getIntent().getExtras();

        tvNameBill = findViewById(R.id.tvNameBill);
        tvDestinationBill = findViewById(R.id.tvDestinationBill);
        tvDepartureBill = findViewById(R.id.tvDepartureBill);
        tvPremiumBill = findViewById(R.id.tvPremiumBill);
        tvWindowBill = findViewById(R.id.tvWindowBill);
        tvPetBill = findViewById(R.id.tvPetBill);
        tvFirstClassBill = findViewById(R.id.tvFirstClassBill);
        tvInsuranceBill = findViewById(R.id.tvInsuranceBill);
        tvPriceBill = findViewById(R.id.tvPriceBill);
        tvDateBill = findViewById(R.id.tvDateBill);

        departure = bundle.getString("departure");
        destination = bundle.getString("destination");
        name = bundle.getString("name");
        price = bundle.getString("price");
        date = bundle.getString("date");
        window = bundle.getBoolean("window");
        pet = bundle.getBoolean("pet");
        firstClass = bundle.getBoolean("firstClass");
        insurance = bundle.getBoolean("insurance");
        premium = bundle.getBoolean("premium");

        putTvs();

        btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(view -> {
            finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }

    /**
     * activity_bill TextViews setter.
     */
    private void putTvs() {
        tvNameBill.append(name);
        tvDepartureBill.append(departure);
        tvDestinationBill.append(destination);
        tvPriceBill.append(price);
        tvDateBill.append(date);

        if (window){
            tvWindowBill.append("Si (+50€)");
        } else {
            tvWindowBill.append("No");
        }

        if (pet){
            tvPetBill.append("Si (+0€)");
        } else {
            tvPetBill.append("No");
        }

        if (firstClass){
            tvFirstClassBill.append("Si (+500€)");
        } else {
            tvFirstClassBill.append("No");
        }

        if (insurance){
            tvInsuranceBill.append("Si (+500€)");
        } else {
            tvInsuranceBill.append("No");
        }

        if (premium){
            tvPremiumBill.append("Si (+500€)");
        } else {
            tvPremiumBill.append("No");
        }

    }
}