package com.amoharib.soleeklabapp.app.di;

import android.app.Application;

import com.amoharib.soleeklabapp.app.SoleekLapApplication;
import com.amoharib.soleeklabapp.app.di.module.ActivityBindingModule;
import com.amoharib.soleeklabapp.app.di.module.NetworkModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@ApplicationScope
@Component(modules = {
        NetworkModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface ApplicationComponent extends AndroidInjector<SoleekLapApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
