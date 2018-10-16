package com.amoharib.soleeklabapp.ui.register;

import android.app.Activity;

import com.amoharib.soleeklabapp.app.data.DataRepository;

import org.apache.commons.validator.routines.EmailValidator;

import javax.inject.Inject;

public class RegistrationPresenter implements RegistrationContract.Presenter {

    private Activity activity;

    @Inject
    DataRepository model;
    private RegistrationContract.View view;

    @Inject
    public RegistrationPresenter(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void subscribe(RegistrationContract.View view) {
        this.view = view;
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void signUp(String email, String password, String confirmPassword) {
        if (!checkValidity(email, password, confirmPassword)) return;

        view.showProgress();
        model.registerUser(activity, email, password,
                () -> {
                    view.hideProgress();
                    view.goToHomePage();
                }, error -> {
                    view.hideProgress();
                    view.showMessage(error);
                });
    }

    private boolean checkValidity(String email, String password, String confirmPassword) {
        if (email.isEmpty() || !EmailValidator.getInstance().isValid(email)) {
            view.notifyBadOrEmptyEmail();
            return false;
        }
        if (password.length() < 8) {
            view.notifyBadPassword();
            return false;
        }
        if (!password.equals(confirmPassword)) {
            view.showMessage("The passwords must be matched");
            return false;
        }

        return true;
    }
}
