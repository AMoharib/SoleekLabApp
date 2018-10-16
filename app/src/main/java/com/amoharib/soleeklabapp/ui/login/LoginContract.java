package com.amoharib.soleeklabapp.ui.login;

import com.amoharib.soleeklabapp.app.base.BasePresenter;
import com.amoharib.soleeklabapp.app.base.BaseView;

public interface LoginContract {
    interface View extends BaseView<Presenter> {

        void notifyEmptyOrBadEmail();

        void notifyBadPassword();

        void goToHomePage();

        void showProgress();

        void hideProgress();
    }

    interface Presenter extends BasePresenter<View> {

        void loginUser(String email, String password);
    }
}
