package com.example.eidolon.beedlesshopship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        TextView shoppingCartReceiptTextView = (TextView) findViewById(R.id.shoppingCartReceiptTextView);
        shoppingCartReceiptTextView.setText(getIntent().getStringExtra("shopping cart receipt"));

        Button submitOrderButton = (Button) findViewById(R.id.SubmitOrderButton);
        submitOrderButton.setText(R.string.submit_order_button_text);
        submitOrderButton.setOnClickListener(startSubmitOrderActivity);
    }

    View.OnClickListener startSubmitOrderActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), SubmitOrderActivity.class);
            startActivity(intent);
        }
    };
}
