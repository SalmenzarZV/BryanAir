package com.pmdm.almenzarjimenezsergio.bryanair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BillBuyActivity extends AppCompatActivity /*implements View.OnClickListener*/ {
    //instance params
    TextView tvNameBuy, tvDestinationBuy, tvDepartureBuy, tvPriceBuy, tvDateBuy,
            tvNameBill, tvDestinationBill, tvDepartureBill, tvPremiumBill, tvWindowBill, tvPetBill,
                tvFirstClassBill, tvInsuranceBill, tvPriceBill, tvDateBill;
    String departure, destination, name, price, date;
    Bundle bundle;
    Button btBuyBuy, btCancelBuy;
    boolean window, pet, firstClass, insurance, premium;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_buy);
        //initialize();

    }
    /*
    private void initialize() {
        bundle = getIntent().getExtras();
        price = Integer.toString(bundle.getInt("price"));
        btBuyBuy = findViewById(R.id.btBuyBuy);
        btBuyBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btBuyBuy)){
            bundle.putString("price", price+"€");
            Alertadialogo alertadialogo = new Alertadialogo(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            alertadialogo.show(fragmentManager, "Confirmar compra");
        }
    }

     */
}