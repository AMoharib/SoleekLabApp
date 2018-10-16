package com.amoharib.soleeklabapp.app.di.module;

import com.amoharib.soleeklabapp.app.di.ActivityScope;
import com.amoharib.soleeklabapp.ui.home.HomeActivity;
import com.amoharib.soleeklabapp.ui.home.HomeModule;
import com.amoharib.soleeklabapp.ui.login.LoginActivity;
import com.amoharib.soleeklabapp.ui.login.LoginModule;
import com.amoharib.soleeklabapp.ui.register.RegistrationActivity;
import com.amoharib.soleeklabapp.ui.register.RegistrationModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity loginActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = RegistrationModule.class)
    abstract RegistrationActivity registrationActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity homeActivity();
}
