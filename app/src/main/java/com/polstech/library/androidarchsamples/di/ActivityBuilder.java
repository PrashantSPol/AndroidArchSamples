package com.polstech.library.androidarchsamples.di;

import com.polstech.library.androidarchsamples.ui.quote.QuoteActivity;
import com.polstech.library.androidarchsamples.ui.quote.QuoteActivityModule;
import com.polstech.library.androidarchsamples.ui.quote.dialog.QuoteDialogModule;
import com.polstech.library.androidarchsamples.ui.quote.dialog.QuoteDialogProvider;
import com.polstech.library.androidarchsamples.ui.sellingList.SellingListActivity;
import com.polstech.library.androidarchsamples.ui.sellingList.SellingListActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by polprashant on 14/02/18.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {QuoteActivityModule.class,
            QuoteDialogProvider.class})
    abstract public QuoteActivity bindQuoteActivity();

    @ContributesAndroidInjector(modules = {SellingListActivityModule.class})
    abstract public SellingListActivity bindSellingListActivity();
}
