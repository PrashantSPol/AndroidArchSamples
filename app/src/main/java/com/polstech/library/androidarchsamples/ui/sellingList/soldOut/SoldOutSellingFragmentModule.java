package com.polstech.library.androidarchsamples.ui.sellingList.soldOut;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prashant.pol on 2/21/2018.
 */
@Module
public class SoldOutSellingFragmentModule {

    @Provides
    SoldOutSellingFragmentViewModel providesSoldOutSellingFragmentViewModel() {
        return new SoldOutSellingFragmentViewModel();
    }
}
