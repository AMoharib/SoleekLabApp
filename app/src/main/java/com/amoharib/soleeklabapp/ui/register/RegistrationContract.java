package com.amoharib.soleeklabapp.ui.register;

import com.amoharib.soleeklabapp.app.base.BasePresenter;
import com.amoharib.soleeklabapp.app.base.BaseView;

public interface RegistrationContract {
    interface Presenter extends BasePresenter<View> {

        void signUp(String email, String password, String confirmPassword);
    }

    interface View extends BaseView<Presenter> {

        void notifyBadOrEmptyEmail();

        void notifyBadPassword();

        void goToHomePage();

        void showProgress();

        void hideProgress();
    }
}
