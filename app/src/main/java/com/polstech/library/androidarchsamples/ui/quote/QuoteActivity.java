package com.polstech.library.androidarchsamples.ui.quote;

import android.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleAdapter;

import com.polstech.library.androidarchsamples.BR;
import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.databinding.ActivityQuoteBinding;
import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.ui.common.BaseActivity;
import com.polstech.library.androidarchsamples.ui.common.BaseViewModel;
import com.polstech.library.androidarchsamples.ui.quote.dialog.QuoteDialog;
import com.polstech.library.androidarchsamples.ui.sellingList.SellingListActivity;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import dagger.BindsInstance;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Created by polprashant on 14/02/18.
 */

public class QuoteActivity extends BaseActivity<ActivityQuoteBinding, QuoteViewModel> implements View.OnClickListener, QuoteActivityNavigator, HasFragmentInjector {

    @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
     @Inject DataManager dataManager;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    QuoteRecyclerAdapter quoteRecyclerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp();
        loadData();
    }

    public void loadData() {
        mViewModel.loadQuoteList();
        mViewModel.getMutableQuoteList().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> quotes) {
                mViewModel.setObservableList(quotes);
            }
        });
    }

    void setUp() {
        setSupportActionBar(mDataBindingUtil.toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        setupNavigation();

        mDataBindingUtil.fabAdd.setOnClickListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDataBindingUtil.rvQuote.setLayoutManager(layoutManager);
        mDataBindingUtil.rvQuote.setAdapter(quoteRecyclerAdapter);

        mViewModel.setQuoteActivityNavigator(this);
    }

    void  setupNavigation() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDataBindingUtil.drawerlayout, mDataBindingUtil.toolbar, R.string.str_drawer_open, R.string.str_drawer_close);
        toggle.syncState();

        mDataBindingUtil.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_quote :
                        break;
                    case R.id.menu_selling_list :
                        startActivity(SellingListActivity.newInstance(QuoteActivity.this));
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_quote :
                Log.i("CHECK_", "quotes selected");
                break;
            case R.id.menu_selling_list :
                Log.i("CHECK_", "selling list selected");
                break;
        }
        return true;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_drawer, menu);

        return true;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.fab_add) {
            mViewModel.actionToAddQuote();
        }
    }

    @Override
    public void showDialogToGetQuote() {
        QuoteDialog.newInstance().show(getFragmentManager(), "QuoteDialog");
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
