package com.polstech.library.androidarchsamples.ui.sellingList;

import android.content.Context;

import com.polstech.library.androidarchsamples.data.db.helper.IDbHelper;
import com.polstech.library.androidarchsamples.di.qualifier.AppContext;
import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.network.RetrofitFactory;
import com.polstech.library.androidarchsamples.network.schedulers.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prashant.pol on 2/21/2018.
 */
@Module
public class SellingListActivityModule {

    @Provides
    SellingListViewModel providesSellingListViewModel() {
        return new SellingListViewModel();
    }

    @Provides
    SellingListPagerAdapter providesSellingListPagerAdapter(@AppContext Context context, SellingListActivity sellingListActivity) {
        return new SellingListPagerAdapter(context, sellingListActivity.getSupportFragmentManager());
    }
}
