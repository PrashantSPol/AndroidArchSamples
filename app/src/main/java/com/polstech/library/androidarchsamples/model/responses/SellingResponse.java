package com.polstech.library.androidarchsamples.model.responses;

import com.polstech.library.androidarchsamples.ui.sellingList.common.Product;

import java.util.List;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public class SellingResponse {
    public List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
