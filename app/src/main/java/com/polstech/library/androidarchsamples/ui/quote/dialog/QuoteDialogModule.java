package com.polstech.library.androidarchsamples.ui.quote.dialog;

import com.polstech.library.androidarchsamples.logic.DataManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by polprashant on 19/02/18.
 */
@Module
public class QuoteDialogModule {

    @Provides
    DataManager providesDataManager() {
        return new DataManager();
    }
}
