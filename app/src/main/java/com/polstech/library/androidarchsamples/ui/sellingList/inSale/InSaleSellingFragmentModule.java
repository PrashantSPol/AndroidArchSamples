package com.polstech.library.androidarchsamples.ui.sellingList.inSale;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.polstech.library.androidarchsamples.di.qualifier.ActivityContext;
import com.polstech.library.androidarchsamples.ui.common.BaseActivity;
import com.polstech.library.androidarchsamples.ui.common.BaseFragment;
import com.polstech.library.androidarchsamples.ui.sellingList.common.SellingListAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prashant.pol on 2/21/2018.
 */
@Module
public class InSaleSellingFragmentModule {

    @Provides
    SellingListAdapter providesSellingListAdapter(InSaleSellingFragment fragment){
        return new SellingListAdapter(fragment.getContext(), new ArrayList<>());
    }

    @Provides
    RecyclerView.LayoutManager providesLayoutManager(InSaleSellingFragment fragment) {
        return new LinearLayoutManager(fragment.getContext());
    }
}
