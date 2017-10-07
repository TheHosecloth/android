package com.example.eidolon.beedlesshopship;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingActivity extends AppCompatActivity {

    List<ShopItem> shopItems;
    ShopItemListAdapter adapter;
    Button startCheckoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        shopItems = populateShopItems();
        adapter = new ShopItemListAdapter(getApplicationContext(), R.layout.shop_item, shopItems);
        populateListView();

        startCheckoutButton = (Button) findViewById(R.id.StartCheckoutButton);
        startCheckoutButton.setText(R.string.start_checkout_button_text);
        startCheckoutButton.setOnClickListener(startCheckoutActivity);
    }

    private List<ShopItem> populateShopItems() {
        List<ShopItem> shopItems = new ArrayList<>();

        final TypedArray icons = getResources().obtainTypedArray(R.array.shop_item_icons);
        String[] names = getResources().getStringArray(R.array.shop_item_names);
        String[] priceTags = getResources().getStringArray(R.array.shop_item_price_tags);

        for (int i = 0; i < icons.length(); i++) {
            shopItems.add(new ShopItem(icons.getResourceId(i, -1), names[i], priceTags[i]));
        }

        return shopItems;
    }

    private void populateListView() {
        ListView list = (ListView) findViewById(R.id.ShopItemListView);
        list.setAdapter(adapter);
    }

    View.OnClickListener startCheckoutActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), CheckoutActivity.class);
            intent.putExtra("shopping cart receipt", generateShoppingCartReceipt());
            startActivity(intent);
        }
    };

    private String generateShoppingCartReceipt() {
        String receipt = getResources().getString(R.string.shopping_cart_receipt_base);

        int[] itemPrices = getResources().getIntArray(R.array.shop_item_prices);
        String[] itemNames = getResources().getStringArray(R.array.shop_item_names);

        HashMap<Integer, Integer> shoppingCart = adapter.getShoppingCart();

        int totalCost = 0;

        for (Integer itemNumber : shoppingCart.keySet()) {
            int itemQuantity = shoppingCart.get(itemNumber);
            int itemPrice = itemPrices[itemNumber];

            receipt += itemQuantity + " " + itemNames[itemNumber] + " - " + (itemQuantity * itemPrice) + " Rupees\n";

            totalCost += itemQuantity * itemPrice;
        }

        receipt += "\nTotal: " + totalCost + " Rupees";

        return receipt;
    }
}
