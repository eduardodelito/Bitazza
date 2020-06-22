package com.enaz.bitazza.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.enaz.bitazza.di.util.ViewModelKey;
import com.enaz.bitazza.ui.activity.ActivityViewModel;
import com.enaz.bitazza.ui.login.LoginViewModel;
import com.enaz.bitazza.ui.market.MarketViewModel;
import com.enaz.bitazza.ui.news.NewsViewModel;
import com.enaz.bitazza.ui.settings.SettingsViewModel;
import com.enaz.bitazza.ui.wallet.WalletViewModel;
import com.enaz.bitazza.util.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MarketViewModel.class)
    abstract ViewModel bindMarketViewModel(MarketViewModel marketViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(WalletViewModel.class)
    abstract ViewModel bindWalletViewModel(WalletViewModel walletViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel.class)
    abstract ViewModel bindNewsViewModel(NewsViewModel newsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ActivityViewModel.class)
    abstract ViewModel bindActivityViewModel(ActivityViewModel activityViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel.class)
    abstract ViewModel bindSettingsViewModel(SettingsViewModel settingsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
