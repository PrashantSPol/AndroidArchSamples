package com.polstech.library.androidarchsamples.ui.sellingList;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.polstech.library.androidarchsamples.AndroidArchSampleApp;
import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.ui.sellingList.inSale.InSaleSellingFragment;
import com.polstech.library.androidarchsamples.ui.sellingList.soldOut.SoldOutSellingFragment;

/**
 * Created by prashant.pol on 2/21/2018.
 */

public class SellingListPagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private int mCount;

    public SellingListPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
        mCount = 0;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return InSaleSellingFragment.newInstance();
        } else if(position == 1) {
            return SoldOutSellingFragment.newInstance();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0 : return mContext.getString(R.string.str_in_sale);
            case 1 : return mContext.getString(R.string.str_sold_out);
        }
        return null;
    }

    @Override
    public int getCount() {
        return mCount;
    }

    public void setCount(int mCount) {
        this.mCount = mCount;
    }
}
