package com.polstech.library.androidarchsamples.ui.sellingList.soldOut;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.databinding.FragmentSoldOutSellingBinding;
import com.polstech.library.androidarchsamples.ui.common.BaseFragment;

import javax.inject.Inject;

/**
 * Created by prashant.pol on 2/21/2018.
 */

public class SoldOutSellingFragment extends BaseFragment<FragmentSoldOutSellingBinding, SoldOutSellingFragmentViewModel> {

    public static SoldOutSellingFragment newInstance() {
        return new SoldOutSellingFragment();
    }

    @Inject
    SoldOutSellingFragmentViewModel soldOutSellingFragmentViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sold_out_selling;
    }

    @Override
    protected SoldOutSellingFragmentViewModel getViewModel() {
        return soldOutSellingFragmentViewModel;
    }
}
