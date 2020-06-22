package com.enaz.bitazza.ui.main;

import com.enaz.bitazza.ui.activity.ActivityFragment;
import com.enaz.bitazza.ui.login.LoginFragment;
import com.enaz.bitazza.ui.market.MarketFragment;
import com.enaz.bitazza.ui.news.NewsFragment;
import com.enaz.bitazza.ui.settings.SettingsFragment;
import com.enaz.bitazza.ui.wallet.WalletFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract LoginFragment provideLoginFragment();

    @ContributesAndroidInjector
    abstract MarketFragment provideMarketFragment();

    @ContributesAndroidInjector
    abstract WalletFragment provideWalletFragment();

    @ContributesAndroidInjector
    abstract NewsFragment provideNewsFragment();

    @ContributesAndroidInjector
    abstract ActivityFragment provideActivityFragment();

    @ContributesAndroidInjector
    abstract SettingsFragment provideSettingsFragment();
}
