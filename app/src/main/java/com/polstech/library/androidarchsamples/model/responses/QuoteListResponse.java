package com.polstech.library.androidarchsamples.model.responses;

import java.util.List;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public class QuoteListResponse {
    List<String> quotes;

    public List<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }
}
