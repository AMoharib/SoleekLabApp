package com.amoharib.soleeklabapp.app.data;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CountriesAPI {

    @GET("rest/v2/all")
    Observable<List<Country>> getCountries();
}
