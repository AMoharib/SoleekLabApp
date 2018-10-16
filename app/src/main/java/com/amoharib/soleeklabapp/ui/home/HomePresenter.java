package com.amoharib.soleeklabapp.ui.home;

import com.amoharib.soleeklabapp.app.data.DataRepository;

import javax.inject.Inject;

public class HomePresenter implements HomeContract.Presenter {

    @Inject
    DataRepository model;

    HomeContract.View view;

    @Inject
    HomePresenter() {

    }

    @Override
    public void subscribe(HomeContract.View view) {
        this.view = view;
        getCountries();
    }

    private void getCountries() {
        model.getCountries(countries -> {
            view.updateListWith(countries);
        }, error -> {
            view.showMessage("Error while fetching data");
        });
    }

    @Override
    public void unsubscribe() {

    }


    @Override
    public void logout() {
        model.logout();
        view.goToLoginActivity();
    }
}
