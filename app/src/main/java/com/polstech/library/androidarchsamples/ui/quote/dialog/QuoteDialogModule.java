package com.polstech.library.androidarchsamples.ui.quote.dialog;

import android.content.Context;
import android.util.Log;

import com.polstech.library.androidarchsamples.logic.DataManager;

import java.util.logging.Logger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by polprashant on 19/02/18.
 */
@Module
public class QuoteDialogModule {
    @Provides
    QuoteDialogViewModel providesQuoteDialogViewModel(DataManager dataManager) {
        return new QuoteDialogViewModel(dataManager);
    }
}
