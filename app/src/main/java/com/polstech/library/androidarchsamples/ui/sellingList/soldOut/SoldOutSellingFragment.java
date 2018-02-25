package com.polstech.library.androidarchsamples.ui.sellingList.soldOut;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.polstech.library.androidarchsamples.BR;
import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.databinding.FragmentSellingBinding;
import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.ui.common.BaseFragment;
import com.polstech.library.androidarchsamples.ui.sellingList.common.SellingFragmentViewModel;
import com.polstech.library.androidarchsamples.ui.sellingList.common.SellingListAdapter;

import javax.inject.Inject;

/**
 * Created by prashant.pol on 2/21/2018.
 */

public class SoldOutSellingFragment extends BaseFragment<FragmentSellingBinding, SellingFragmentViewModel> {

    public static SoldOutSellingFragment newInstance() {
        return new SoldOutSellingFragment();
    }

    @Inject
    DataManager dataManager;

    @Inject
    SellingListAdapter sellingListAdapter;

    @Inject
    RecyclerView.LayoutManager layoutManager;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setup();
        loadData();
    }


    void setup() {
        mViewDataBinding.rvProducts.setLayoutManager(layoutManager);
        mViewDataBinding.rvProducts.setAdapter(sellingListAdapter);

        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
    }

    void loadData() {
        mViewModel.productLiveData.observe(this, list -> {
            mViewModel.setProductList(list);
        });

        mViewModel.loadSoldOutProducts(dataManager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_selling;
    }

    @Override
    protected SellingFragmentViewModel getViewModel() {
        return ViewModelProviders.of(this).get(SellingFragmentViewModel.class);
    }

    @Override
    protected int getBindingVariable() {
        return BR.inSaleVM;
    }
}
