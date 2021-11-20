package com.pmdm.almenzarjimenezsergio.bryanair;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class PrivacyConfigActivity extends AppCompatActivity {
    //instance vars
    Button btExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_config);
        initialize();
    }

    /**
     * components init
     */
    private void initialize() {
        btExit = findViewById(R.id.btExit);
        btExit.setOnClickListener(view -> finish());
    }
}