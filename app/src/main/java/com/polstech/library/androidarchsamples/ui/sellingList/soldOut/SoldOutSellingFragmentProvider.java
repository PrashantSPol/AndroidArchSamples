package com.polstech.library.androidarchsamples.ui.sellingList.soldOut;

import com.polstech.library.androidarchsamples.ui.sellingList.inSale.InSaleSellingFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by prashant.pol on 2/21/2018.
 */
@Module
public abstract class SoldOutSellingFragmentProvider {
    @ContributesAndroidInjector(modules = SoldOutSellingFragmentModule.class)
    abstract SoldOutSellingFragment bindSoldOutSellingFragment();
}
