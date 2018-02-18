package com.polstech.library.androidarchsamples.di;

import com.polstech.library.androidarchsamples.ui.quote.QuoteActivity;
import com.polstech.library.androidarchsamples.ui.quote.QuoteActivityModule;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by polprashant on 14/02/18.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = QuoteActivityModule.class)
    abstract public QuoteActivity bindQuoteActivity();
}
