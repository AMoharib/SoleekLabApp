package com.amoharib.soleeklabapp.app.data;

import android.app.Activity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public interface DataRepository {

    void loginUser(Activity activity, String email, String password, Action success, Consumer<String> error);

    void registerUser(Activity activity, String email, String password, Action success, Consumer<String> error);

    boolean getCurrentUser();

    void getCountries(Consumer<List<Country>> result, Consumer<String> onError);

    void logout();
}
