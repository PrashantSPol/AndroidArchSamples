package com.polstech.library.androidarchsamples.ui.common;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.ui.quote.QuoteViewModel;

import javax.inject.Inject;

/**
 * Created by polprashant on 18/02/18.
 */

public class ViewModelFactory implements ViewModelProvider.Factory {
    DataManager dataManager;

    @Inject
    public ViewModelFactory(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new QuoteViewModel(dataManager);
    }
}
