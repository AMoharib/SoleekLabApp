package com.amoharib.soleeklabapp.ui.login;

import android.app.Activity;

import com.amoharib.soleeklabapp.app.data.DataRepository;


import org.apache.commons.validator.routines.EmailValidator;

import javax.inject.Inject;

public class LoginPresenter implements LoginContract.Presenter {

    @Inject
    DataRepository model;

    LoginContract.View view;
    private Activity activity;

    @Inject
    public LoginPresenter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void subscribe(LoginContract.View view) {
        this.view = view;
        checkCurrentUser();
    }

    private void checkCurrentUser() {
        if (model.getCurrentUser()) {
            view.goToHomePage();
        }
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void loginUser(String email, String password) {
        if (!checkEmptyAndValidity(email, password)) return;

        view.showProgress();
        model.loginUser(activity, email, password,
                () -> {
                    view.hideProgress();
                    view.goToHomePage();
                }, error -> {
                    view.hideProgress();
                    view.showMessage(error);
                });
    }


    private boolean checkEmptyAndValidity(String email, String password) {
        if (email.isEmpty() || !EmailValidator.getInstance().isValid(email)) {
            view.notifyEmptyOrBadEmail();
            return false;
        }
        if (password.length() < 8) {
            view.notifyBadPassword();
            return false;
        }
        return true;
    }


}
