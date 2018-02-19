package com.polstech.library.androidarchsamples.ui.quote.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.ui.common.BaseActivity;

import javax.inject.Inject;

/**
 * Created by polprashant on 19/02/18.
 */

public class QuoteDialog extends DialogFragment {
    @Inject
    DataManager dataManager;

    BaseActivity mBaseActivity;
    Dialog dialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof BaseActivity) {
            mBaseActivity = (BaseActivity) context;
            mBaseActivity.onAttachFragment(this);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = new Dialog(mBaseActivity);
        dialog.setContentView(R.layout.dialog_quote);



        return dialog;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        dialog.show();
    }
}
