package com.amoharib.soleeklabapp.ui.login;

import android.app.Activity;
import android.content.Context;

import com.amoharib.soleeklabapp.app.di.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class LoginModule {

    @ActivityScope
    @Provides
    static Activity activity(LoginActivity loginActivity) {
        return loginActivity;
    }

    @ActivityScope
    @Binds
    abstract LoginContract.Presenter presenter(LoginPresenter presenter);
}
