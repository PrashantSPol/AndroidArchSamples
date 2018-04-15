package com.polstech.library.androidarchsamples.ui.quote;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.polstech.library.androidarchsamples.data.db.helper.IDbHelper;
import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.logic.DataProvider;
import com.polstech.library.androidarchsamples.network.RetrofitFactory;
import com.polstech.library.androidarchsamples.network.schedulers.SchedulerProvider;
import com.polstech.library.androidarchsamples.ui.common.ViewModelFactory;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by polprashant on 14/02/18.
 */
@Module
public class QuoteActivityModule {

    @Provides
    ViewModelProvider.Factory providesViewModelFactory(DataManager dataManager) {
        return new ViewModelFactory(dataManager);
    }

    @Provides
    QuoteRecyclerAdapter providesQuoteRecyclerAdapter(QuoteActivity quoteActivity){
        return new QuoteRecyclerAdapter(quoteActivity, new ArrayList<>());
    }
}
