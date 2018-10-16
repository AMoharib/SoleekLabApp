package com.amoharib.soleeklabapp.ui.register;


import android.app.Activity;

import com.amoharib.soleeklabapp.app.di.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class RegistrationModule {

    @ActivityScope
    @Provides
    static Activity activity(RegistrationActivity registrationActivity) {
        return registrationActivity;
    }

    @ActivityScope
    @Binds
    abstract RegistrationContract.Presenter presenter(RegistrationPresenter presenter);

}
