package com.polstech.library.androidarchsamples.data;

import java.util.List;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public class CacheHelperImpl implements CacheHelper {

    List<String> quoteList;

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
}
