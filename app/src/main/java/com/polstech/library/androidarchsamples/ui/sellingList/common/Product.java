package com.polstech.library.androidarchsamples.ui.sellingList.common;

/**
 * Created by prashant.pol on 2/23/2018.
 */

public class Product {
    public String productName;
    public int imageUrl;
    public int price;
    public boolean isInSale;

    public Product(String productName, int imageUrl, int price, boolean isInSale) {
        this.productName = productName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.isInSale = isInSale;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", imageUrl=" + imageUrl +
                ", price=" + price +
                ", isInSale=" + isInSale +
                '}';
    }
}
