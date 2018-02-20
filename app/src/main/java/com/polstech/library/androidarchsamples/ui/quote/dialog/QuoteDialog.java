package com.polstech.library.androidarchsamples.ui.quote.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.databinding.DialogQuoteBinding;
import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.ui.common.BaseActivity;
import com.polstech.library.androidarchsamples.ui.quote.QuoteActivity;
import com.polstech.library.androidarchsamples.util.ToastUtil;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by polprashant on 19/02/18.
 */

public class QuoteDialog extends DialogFragment implements View.OnClickListener, QuoteDialogCallback {
    @Inject
    DataManager dataManager;

    @Inject
    QuoteDialogViewModel quoteDialogViewModel;

    @Inject ToastUtil toastUtil;

    QuoteActivity mQuoteActivity;
    Dialog dialog;
    EditText editQuote;

    public static QuoteDialog newInstance() {
        return new QuoteDialog();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof BaseActivity) {
            mQuoteActivity = (QuoteActivity) context;
            mQuoteActivity.onAttachFragment(this);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = new Dialog(mQuoteActivity);
        View view = new RelativeLayout(mQuoteActivity);
        view.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        if(dialog.getWindow() != null) {
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);

        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        DialogQuoteBinding binding = DataBindingUtil.inflate(inflater, R.layout.dialog_quote, container, true);

        View view = binding.getRoot();

        AndroidInjection.inject(this);

        binding.setQuoteDialogViewModel(quoteDialogViewModel);
        quoteDialogViewModel.setNavigator(this);

        view.findViewById(R.id.btn_add).setOnClickListener(this);
        view.findViewById(R.id.btn_cancel).setOnClickListener(this);

        editQuote = view.findViewById(R.id.edit_quote);

        return binding.getRoot();
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        Fragment previousFragment = manager.findFragmentByTag(tag);
        if(previousFragment != null) {
            fragmentTransaction.remove(previousFragment);
        }
        fragmentTransaction.addToBackStack(null);

        show(fragmentTransaction, tag);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add :
                if(editQuote.getText() == null || editQuote.getText().length() == 0) {
                    toastUtil.showToast(R.string.msg_enter_quote);
                } else {
                    quoteDialogViewModel.actionToAdd(editQuote.getText().toString());
                }

                break;
            case R.id.btn_cancel :
                quoteDialogViewModel.actionToCancel();
                break;
        }
    }


    @Override
    public void complete() {
        toastUtil.showToast(R.string.msg_quote_add_success);
        mQuoteActivity.loadData();
        dismiss();
    }

    @Override
    public void cancel() {
        dismiss();
    }

    @Override
    public void dismiss() {
        dialog.dismiss();
        super.dismiss();
    }
}
