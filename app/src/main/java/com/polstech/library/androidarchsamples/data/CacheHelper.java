package com.polstech.library.androidarchsamples.data;

import java.util.List;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public interface CacheHelper {
    public List<String> getQuoteList();
    public void setQuoteList(List<String> quoteList);
    public void addQuote(String quote);
}
