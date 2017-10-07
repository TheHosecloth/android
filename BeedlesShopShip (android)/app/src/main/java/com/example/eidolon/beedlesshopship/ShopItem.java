package com.example.eidolon.beedlesshopship;

/*
 * Created by Eidolon on 4/28/17.
 */

public class ShopItem {
    private int iconID;
    private String name;
    private String priceTag;

    public ShopItem(int iconID, String name, String priceTag) {
        this.iconID = iconID;
        this.name = name;
        this.priceTag = priceTag;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(String priceTag) {
        this.priceTag = priceTag;
    }
}
