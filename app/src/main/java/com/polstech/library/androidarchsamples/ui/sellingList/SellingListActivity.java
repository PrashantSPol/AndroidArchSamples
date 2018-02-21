package com.polstech.library.androidarchsamples.ui.sellingList;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.polstech.library.androidarchsamples.BR;
import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.databinding.ActivitySellingListBinding;
import com.polstech.library.androidarchsamples.ui.common.BaseActivity;

import javax.inject.Inject;

/**
 * Created by prashant.pol on 2/21/2018.
 */

public class SellingListActivity extends BaseActivity<ActivitySellingListBinding, SellingListViewModel> {
    @Inject
    SellingListViewModel sellingListViewModel;

    @Inject
    SellingListPagerAdapter sellingListPagerAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setup();
    }

    void setup() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_selling_list;
    }

    @Override
    protected SellingListViewModel getViewModel() {
        return sellingListViewModel;
    }

    @Override
    protected int getBindingVariable() {
        return BR.sellingListVM;
    }
}
