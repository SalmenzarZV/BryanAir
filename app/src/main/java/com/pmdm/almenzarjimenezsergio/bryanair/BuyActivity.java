package com.pmdm.almenzarjimenezsergio.bryanair;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


public class BuyActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvNameBuy, tvDestinationBuy, tvDepartureBuy, tvPrice;
    String departure, destination, name, surname, price;
    Bundle bundle;
    Button btBuyBuy, btCancelBuy;
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
        price = bundle.getInt("price") + "€";

        tvNameBuy = findViewById(R.id.tvNameBuy);
        tvDepartureBuy = findViewById(R.id.tvDepartureBuy);
        tvDestinationBuy = findViewById(R.id.tvDestinationBuy);
        tvPrice = findViewById(R.id.tvPrice);

        btBuyBuy = findViewById(R.id.btBuyBuy);
        btCancelBuy = findViewById(R.id.btCancelBuy);

        tvNameBuy.append(name + " "+surname);
        tvDepartureBuy.append(departure);
        tvDestinationBuy.append(destination);
        tvPrice.append(price);

        btBuyBuy.setOnClickListener(this);
        btCancelBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btCancelBuy)){
            finish();
        }

        if (view.equals(btBuyBuy)){
            Alertadialogo alertadialogo = new Alertadialogo(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            alertadialogo.show(fragmentManager, "Consfirmar compra");
        }
    }
}
