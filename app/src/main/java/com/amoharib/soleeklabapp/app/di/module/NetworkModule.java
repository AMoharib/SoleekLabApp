package com.amoharib.soleeklabapp.app.di.module;

import com.amoharib.soleeklabapp.app.data.CountriesAPI;
import com.amoharib.soleeklabapp.app.data.DataRepository;
import com.amoharib.soleeklabapp.app.data.DataRepositoryImpl;
import com.amoharib.soleeklabapp.app.di.ApplicationScope;
import com.amoharib.soleeklabapp.ext.Constants;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @ApplicationScope
    @Provides
    Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @ApplicationScope
    @Provides
    CountriesAPI api(Retrofit retrofit) {
        return retrofit.create(CountriesAPI.class);
    }

    @ApplicationScope
    @Provides
    DataRepository dataRepository(CountriesAPI api) {
        return new DataRepositoryImpl(api);
    }
}
