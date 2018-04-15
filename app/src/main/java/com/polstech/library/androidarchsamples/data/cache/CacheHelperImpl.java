package com.polstech.library.androidarchsamples.data.cache;

import com.polstech.library.androidarchsamples.data.cache.CacheHelper;
import com.polstech.library.androidarchsamples.ui.sellingList.common.Product;

import java.util.List;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public class CacheHelperImpl implements CacheHelper {

    private List<String> quoteList;
    private List<Product> inSaleProductList;
    private List<Product> soldOutProductList;

    @Override
    public List<String> getQuoteList() {
        return quoteList;
    }

    @Override
    public void setQuoteList(List<String> quoteList) {
        this.quoteList = quoteList;
    }

    @Override
    public void addQuote(String quote) {
        if(quoteList == null) {
            throw new IllegalStateException("Nothing in cache to add");
        }
        getQuoteList().add(quote);
    }

    @Override
    public List<Product> getInSaleProducts() {
        return inSaleProductList;
    }

    @Override
    public void setInSaleProducts(List<Product> productList) {
        this.inSaleProductList = productList;
    }

    @Override
    public List<Product> getSoldOutProducts() {
        return soldOutProductList;
    }

    @Override
    public void setSoldOutProducts(List<Product> soldOutProducts) {
        this.soldOutProductList = soldOutProducts;
    }
}
