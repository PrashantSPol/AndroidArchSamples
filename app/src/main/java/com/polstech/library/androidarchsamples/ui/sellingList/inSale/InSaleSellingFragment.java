package com.polstech.library.androidarchsamples.ui.sellingList.inSale;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.databinding.FragmentInSaleSellingBinding;
import com.polstech.library.androidarchsamples.ui.common.BaseFragment;

import javax.inject.Inject;

/**
 * Created by prashant.pol on 2/21/2018.
 */

public class InSaleSellingFragment extends BaseFragment<FragmentInSaleSellingBinding, InSaleSellingFragmentViewModel> {

    public static InSaleSellingFragment newInstance() {
        return new InSaleSellingFragment();
    }

    @Inject
    InSaleSellingFragmentViewModel inSaleSellingFragmentViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_in_sale_selling;
    }

    @Override
    protected InSaleSellingFragmentViewModel getViewModel() {
        return inSaleSellingFragmentViewModel;
    }
}
