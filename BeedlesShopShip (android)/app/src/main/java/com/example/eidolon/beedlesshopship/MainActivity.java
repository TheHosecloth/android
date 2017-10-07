package com.example.eidolon.beedlesshopship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView introductionTextView = (TextView) findViewById(R.id.IntroductionTextView);
        introductionTextView.setText(R.string.introduction_text);

        Button startShoppingButton = (Button) findViewById(R.id.StartShoppingButton);
        startShoppingButton.setText(R.string.start_shopping_button_text);
        startShoppingButton.setOnClickListener(startShoppingActivity);
    }

    View.OnClickListener startShoppingActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ShoppingActivity.class);
            startActivity(intent);
        }
    };
}
