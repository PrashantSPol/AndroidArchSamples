package com.polstech.library.androidarchsamples.ui.sellingList.inSale;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by prashant.pol on 2/21/2018.
 */
@Module
public abstract class InSaleSellingFragmentProvider {
    @ContributesAndroidInjector(modules = InSaleSellingFragmentModule.class)
    abstract InSaleSellingFragment bindInSaleSellingFragment();
}
