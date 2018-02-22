package com.polstech.library.androidarchsamples.ui.sellingList.inSale;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prashant.pol on 2/21/2018.
 */
@Module
public class InSaleSellingFragmentModule {
    @Provides
    InSaleSellingFragmentViewModel providesInSaleSellingFragmentViewModel(){
        return new InSaleSellingFragmentViewModel();
    }
}
