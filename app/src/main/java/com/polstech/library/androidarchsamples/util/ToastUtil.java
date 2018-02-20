package com.polstech.library.androidarchsamples.util;

import android.content.Context;
import android.widget.Toast;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.di.qualifier.AppContext;

import javax.inject.Inject;

/**
 * Created by prashant.pol on 2/20/2018.
 */

public class ToastUtil {


    Context mContext;

    public ToastUtil(Context context) {
        mContext = context;
    }

    public void showToast(int stringRes) {
        Toast.makeText(mContext, stringRes, Toast.LENGTH_SHORT).show();
    }

    private void showToast(String msg, int duration) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
