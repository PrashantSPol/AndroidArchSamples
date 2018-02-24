package com.polstech.library.androidarchsamples.ui.sellingList.soldOut;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.polstech.library.androidarchsamples.ui.sellingList.common.SellingListAdapter;
import com.polstech.library.androidarchsamples.ui.sellingList.inSale.InSaleSellingFragment;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prashant.pol on 2/24/2018.
 */
@Module
public class SoldOutSellingFragmentModule {

    @Provides
    public SellingListAdapter providesSellingListAdapter(SoldOutSellingFragment baseFragment) {
        return new SellingListAdapter(baseFragment.getContext(), new ArrayList<>());
    }

    @Provides
    public RecyclerView.LayoutManager providesLayoutManager(SoldOutSellingFragment baseFragment) {
        return new LinearLayoutManager(baseFragment.getContext());
    }
}
