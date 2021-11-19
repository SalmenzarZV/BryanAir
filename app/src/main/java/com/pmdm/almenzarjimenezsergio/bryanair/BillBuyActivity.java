package com.pmdm.almenzarjimenezsergio.bryanair;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BillBuyActivity extends AppCompatActivity {

    TextView tvNameBill, tvDestinationBill, tvDepartureBill, tvPremiumBill, tvWindowBill, tvPetBill,
            tvFirstClassBill, tvInsuranceBill, tvPriceBill, tvDateBill, tvNameBuy, tvDestinationBuy,
            tvDepartureBuy, tvPriceBuy, tvDateBuy, tvCheck;
    String departure, destination, name, price, date;
    Bundle bundle;
    Button btBack, btBuyBuy, btCancelBuy;
    boolean window, pet, firstClass, insurance, premium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_buy);
        initialize();
    }

    private void initialize() {
        bundle = getIntent().getExtras();
        stringsInit();
        booleanInit();
        putTvs();
        putBts();
    }

    private void stringsInit() {
        departure = bundle.getString("departure");
        destination = bundle.getString("destination");
        name = bundle.getString("name");
        price = Integer.toString(bundle.getInt("price"));
        date = bundle.getString("date");
    }

    private void putBts() {
        btBuyBuy = findViewById(R.id.btBuyBuy);
        btCancelBuy = findViewById(R.id.btCancelBuy);
        btBack = findViewById(R.id.btBack);

        btBuyBuy.setVisibility(View.GONE);
        btCancelBuy.setVisibility(View.GONE);
        btBack.setOnClickListener(view -> finish());

    }

    private void booleanInit() {
        window = bundle.getBoolean("window");
        pet = bundle.getBoolean("pet");
        firstClass = bundle.getBoolean("firstClass");
        insurance = bundle.getBoolean("insurance");
        premium = bundle.getBoolean("premium");
    }

    private void putTvs() {
        //BillActivity
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
        //BuyActivity
        tvNameBuy = findViewById(R.id.tvNameBuy);
        tvDepartureBuy = findViewById(R.id.tvDepartureBuy);
        tvDestinationBuy = findViewById(R.id.tvDestinationBuy);
        tvPriceBuy = findViewById(R.id.tvPriceBuy);
        tvDateBuy = findViewById(R.id.tvDateBuy);
        tvCheck = findViewById(R.id.tvCheck);

        tvCheck.setText(R.string.ticket);

        appendTvs();

    }

    private void appendTvs() {
        tvNameBuy.append(name);
        tvDepartureBuy.append(departure);
        tvDestinationBuy.append(destination);
        tvPriceBuy.append(price + "€");
        tvDateBuy.append(date);
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