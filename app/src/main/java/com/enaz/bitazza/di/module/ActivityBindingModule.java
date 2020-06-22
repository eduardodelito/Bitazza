package com.enaz.bitazza.di.module;

import com.enaz.bitazza.ui.main.MainActivity;
import com.enaz.bitazza.ui.main.MainFragmentBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}
