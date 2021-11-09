package com.pmdm.almenzarjimenezsergio.bryanair;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class BuyActivity extends AppCompatActivity {
    TextView tvNameBuy, tvSurnameBuy, tvDestinationBuy, tvDepartureBuy;
    String departure, destination, name, surname;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_activity);

        initialize();

    }

    private void initialize() {
        bundle = getIntent().getExtras();

        departure = bundle.getString("departure");
        destination = bundle.getString("destination");
        name = bundle.getString("name");
        surname = bundle.getString("surname");

        tvNameBuy = findViewById(R.id.tvNameBuy);
        tvSurnameBuy = findViewById(R.id.tvSurnameBuy);
        tvDepartureBuy = findViewById(R.id.tvDepartureBuy);
        tvDestinationBuy = findViewById(R.id.tvDestinationBuy);

        tvNameBuy.append(name);
        tvSurnameBuy.append(surname);
        tvDepartureBuy.append(departure);
        tvDestinationBuy.append(destination);
    }


}
