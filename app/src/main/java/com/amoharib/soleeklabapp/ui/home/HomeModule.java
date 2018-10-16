package com.amoharib.soleeklabapp.ui.home;

import com.amoharib.soleeklabapp.app.di.ActivityScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class HomeModule {

    @ActivityScope
    @Binds
    abstract HomeContract.Presenter presenter(HomePresenter presenter);
}
