package com.polstech.library.androidarchsamples.data;

import com.polstech.library.androidarchsamples.ui.sellingList.common.Product;

import java.util.List;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public interface CacheHelper {
    public List<String> getQuoteList();
    public void setQuoteList(List<String> quoteList);
    public void addQuote(String quote);

    public List<Product> getInSaleProducts();
    public void setInSaleProducts(List<Product> productList);

    public List<Product> getSoldOutProducts();
    public void setSoldOutProducts(List<Product> soldOutProducts);
}
