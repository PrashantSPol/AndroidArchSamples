package com.polstech.library.androidarchsamples.ui.quote.dialog;

import android.databinding.ObservableField;
import android.util.Log;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.ui.common.BaseViewModel;
import com.polstech.library.androidarchsamples.util.ToastUtil;

import javax.inject.Inject;

/**
 * Created by polprashant on 19/02/18.
 */

public class QuoteDialogViewModel extends BaseViewModel<QuoteDialogCallback> {
    ObservableField<String> quote = new ObservableField<>();
    public String quoteStr;

    DataManager mDataManager;

    public QuoteDialogViewModel(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    void actionToAdd(String quote) {

        mDataManager.addQuote(quote).subscribe(() -> {
            mNavigator.complete();
        });
    }

    void actionToCancel() {
        mNavigator.cancel();
    }

    public ObservableField<String> getQuote() {
        return quote;
    }


}
