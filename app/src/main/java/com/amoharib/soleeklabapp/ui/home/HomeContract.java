package com.amoharib.soleeklabapp.ui.home;

import com.amoharib.soleeklabapp.app.base.BasePresenter;
import com.amoharib.soleeklabapp.app.base.BaseView;
import com.amoharib.soleeklabapp.app.data.Country;

import java.util.List;

public interface HomeContract {
    interface View extends BaseView<Presenter> {

        void updateListWith(List<Country> countries);

        void goToLoginActivity();
    }

    interface Presenter extends BasePresenter<View> {

        void logout();

    }
}
