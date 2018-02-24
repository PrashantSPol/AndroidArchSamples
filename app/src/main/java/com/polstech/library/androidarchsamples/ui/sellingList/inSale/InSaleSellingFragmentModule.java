package com.polstech.library.androidarchsamples.ui.sellingList.inSale;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.ui.common.BaseFragment;
import com.polstech.library.androidarchsamples.ui.sellingList.common.SellingListAdapter;
import com.polstech.library.androidarchsamples.ui.sellingList.inSale.InSaleSellingFragment;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prashant.pol on 2/24/2018.
 */
@Module
public class InSaleSellingFragmentModule {

    @Provides
    public SellingListAdapter providesSellingListAdapter(InSaleSellingFragment baseFragment) {
        return new SellingListAdapter(baseFragment.getContext(), new ArrayList<>());
    }

    @Provides
    public RecyclerView.LayoutManager providesLayoutManager(InSaleSellingFragment baseFragment) {
        return new LinearLayoutManager(baseFragment.getContext());
    }
}
