package com.example.eidolon.beedlesshopship;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Eidolon on 4/28/17.
 */

public class ShopItemListAdapter extends ArrayAdapter<ShopItem> {

    private HashMap<Integer, Integer> shoppingCart = new HashMap<>();

    public ShopItemListAdapter(Context context, int layout, List<ShopItem> shopItemList) {
        super(context, layout, shopItemList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View shopItemView = convertView;

        if (shopItemView == null) { // make new view
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            shopItemView = inflater.inflate(R.layout.shop_item, parent, false);

            EditText currentEditText = (EditText) shopItemView.findViewById(R.id.quantityEditText);
            currentEditText.setTag(position);
            currentEditText.addTextChangedListener(new GenericTextWatcher(currentEditText));
        }

        ShopItem currentShopItem = getItem(position);

        ImageView iconImageView = (ImageView) shopItemView.findViewById(R.id.IconImageView);
        iconImageView.setImageResource(currentShopItem.getIconID());

        TextView nameTextView = (TextView) shopItemView.findViewById(R.id.NameTextView);
        nameTextView.setText(currentShopItem.getName());

        TextView priceTagTextView = (TextView) shopItemView.findViewById(R.id.PriceTagTextView);
        priceTagTextView.setText(currentShopItem.getPriceTag());

        return shopItemView;
    }

    private class GenericTextWatcher implements TextWatcher {

        private View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            Integer itemNumber = Integer.parseInt(view.getTag().toString());
            Integer itemQuantity = Integer.parseInt(s.toString());
            shoppingCart.put(itemNumber, itemQuantity);
//            Toast.makeText(getContext(), "Customer wants " + itemQuantity + "units of item " + itemNumber, Toast.LENGTH_SHORT).show();
        }
    }

    public String foo() {
        return "foo";
    }

    public HashMap<Integer, Integer> getShoppingCart() {
        return shoppingCart;
    }
}
