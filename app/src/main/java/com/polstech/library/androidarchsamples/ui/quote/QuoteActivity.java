package com.polstech.library.androidarchsamples.ui.quote;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.SimpleAdapter;

import com.polstech.library.androidarchsamples.BR;
import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.databinding.ActivityQuoteBinding;
import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.ui.common.BaseActivity;
import com.polstech.library.androidarchsamples.ui.common.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.BindsInstance;

/**
 * Created by polprashant on 14/02/18.
 */

public class QuoteActivity extends BaseActivity<ViewDataBinding, QuoteViewModel> implements View.OnClickListener, QuoteActivityNavigator {

    @Inject
    DataManager dataManager;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    QuoteRecyclerAdapter quoteRecyclerAdapter;

    private RecyclerView rvQuotes;
    private FloatingActionButton fabAdd;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp();
        loadData();
    }

    void loadData() {
        mViewModel.loadQuoteList();
        mViewModel.getMutableQuoteList().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> quotes) {
                mViewModel.setObservableList(quotes);
            }
        });
    }

    void setUp() {
        rvQuotes = findViewById(R.id.rv_quote);
        fabAdd = findViewById(R.id.fab_add);

        fabAdd.setOnClickListener(this);

        rvQuotes.setAdapter(quoteRecyclerAdapter);
        rvQuotes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_quote;
    }

    @Override
    protected QuoteViewModel getViewModel() {
        return ViewModelProviders.of(this, viewModelFactory).get(QuoteViewModel.class);
    }

    @Override
    protected int getBindingVariable() {
        return BR.quoteListViewModel;
    }

    @BindingAdapter({"adapter"})
    public static void bindingAdapter(RecyclerView recyclerView, List<String> quotes) {
        QuoteRecyclerAdapter quoteRecyclerAdapter = (QuoteRecyclerAdapter) recyclerView.getAdapter();
        if(quotes != null) {
            quoteRecyclerAdapter.setQuoteData(quotes);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.fab_add) {
            mViewModel.actionToAddQuote();
        }
    }

    @Override
    public void showDialogToGetQuote() {

    }
}
