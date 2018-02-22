package com.polstech.library.androidarchsamples.ui.sellingList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.polstech.library.androidarchsamples.BR;
import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.databinding.ActivitySellingListBinding;
import com.polstech.library.androidarchsamples.ui.common.BaseActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by prashant.pol on 2/21/2018.
 */

public class SellingListActivity extends BaseActivity<ActivitySellingListBinding, SellingListViewModel> implements HasSupportFragmentInjector {
    @Inject
    SellingListViewModel sellingListViewModel;

    @Inject
    SellingListPagerAdapter sellingListPagerAdapter;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setup();
    }

    void setup() {

        setSupportActionBar(mDataBindingUtil.toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        sellingListPagerAdapter.setCount(2);
        mDataBindingUtil.tablayout.addTab(mDataBindingUtil.tablayout.newTab().setText(R.string.str_in_sale));
        mDataBindingUtil.tablayout.addTab(mDataBindingUtil.tablayout.newTab().setText(R.string.str_sold_out));

        mDataBindingUtil.tablayout.setupWithViewPager(mDataBindingUtil.viewpager);
        mDataBindingUtil.viewpager.setAdapter(sellingListPagerAdapter);

        mDataBindingUtil.viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mDataBindingUtil.tablayout));

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

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
