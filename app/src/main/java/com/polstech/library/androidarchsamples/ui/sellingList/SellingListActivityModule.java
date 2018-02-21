package com.polstech.library.androidarchsamples.ui.sellingList;

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
}
