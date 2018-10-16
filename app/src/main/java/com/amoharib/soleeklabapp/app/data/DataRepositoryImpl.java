package com.amoharib.soleeklabapp.app.data;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DataRepositoryImpl implements DataRepository {

    private static final String TAG = "DataRepositoryImpl";

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private CountriesAPI countriesAPI;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public DataRepositoryImpl(CountriesAPI countriesAPI) {
        this.countriesAPI = countriesAPI;
    }


    @Override
    public void loginUser(Activity activity, String email, String password, Action success, Consumer<String> error) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity, task -> {
            try {
                if (task.isSuccessful()) {
                    success.run();
                } else {
                    error.accept(Objects.requireNonNull(task.getException()).getLocalizedMessage());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void registerUser(Activity activity, String email, String password, Action success, Consumer<String> error) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(activity, task -> {
            try {
                if (task.isSuccessful()) {
                    success.run();
                } else {
                    error.accept(Objects.requireNonNull(task.getException()).getLocalizedMessage());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public boolean getCurrentUser() {
        return firebaseAuth.getCurrentUser() != null;
    }

    @Override
    public void getCountries(Consumer<List<Country>> result, Consumer<String> onError) {
        compositeDisposable.add(countriesAPI.getCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result, error -> onError.accept(error.getLocalizedMessage())));
    }

    @Override
    public void logout() {
        firebaseAuth.signOut();
    }
}
