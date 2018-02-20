package com.polstech.library.androidarchsamples.ui.quote;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.ui.common.BaseViewModel;

import java.util.List;

/**
 * Created by polprashant on 18/02/18.
 */

public class QuoteViewModel extends BaseViewModel {
    public ObservableList<String> observableList = new ObservableArrayList<>();

    private MutableLiveData<List<String>> mutableQuoteList = new MutableLiveData<>();

    private DataManager dataManager;
    private QuoteActivityNavigator quoteActivityNavigator;

    public QuoteViewModel(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void loadQuoteList() {
        dataManager.getQuoteList().subscribe(val -> {
            Thread.sleep(2000);
            mutableQuoteList.setValue(val);
        });
    }

    public void actionToAddQuote() {
        quoteActivityNavigator.showDialogToGetQuote();
    }

    void setQuoteActivityNavigator(QuoteActivityNavigator quoteActivityNavigator) {
        this.quoteActivityNavigator = quoteActivityNavigator;
    }

    public ObservableList<String> getObservableList() {
        return observableList;
    }

    public void setObservableList(List<String> quotes) {
        observableList.clear();
        observableList.addAll(quotes);
    }

    public void setObservableList(ObservableList<String> observableList) {
        this.observableList = observableList;
    }

    public MutableLiveData<List<String>> getMutableQuoteList() {
        return mutableQuoteList;
    }
}
