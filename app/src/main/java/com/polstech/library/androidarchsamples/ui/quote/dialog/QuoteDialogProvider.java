package com.polstech.library.androidarchsamples.ui.quote.dialog;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by prashant.pol on 2/20/2018.
 */
@Module
public abstract class QuoteDialogProvider {

    @ContributesAndroidInjector(modules = QuoteDialogModule.class)
    public abstract QuoteDialog bindQuoteDialog();
}
