package com.amoharib.soleeklabapp.ui.register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.widget.Toast;

import com.amoharib.soleeklabapp.R;
import com.amoharib.soleeklabapp.ui.home.HomeActivity;
import com.amoharib.soleeklabapp.ui.login.LoginActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

public class RegistrationActivity extends DaggerAppCompatActivity implements RegistrationContract.View {

    @BindView(R.id.username)
    TextInputEditText username;
    @BindView(R.id.password)
    TextInputEditText password;
    @BindView(R.id.confirm_password)
    TextInputEditText confirmPassword;

    ProgressDialog progressDialog;


    @Inject
    RegistrationContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setUpProgressBar();
        ButterKnife.bind(this);
        presenter.subscribe(this);
    }

    private void setUpProgressBar() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.creating_new_user));
        progressDialog.setCancelable(false);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.signup_btn)
    public void onSignupBtnClicked() {
        presenter.signUp(username.getText().toString(), password.getText().toString(), confirmPassword.getText().toString());
    }

    @OnClick(R.id.signin_tv)
    public void onSigninTvClicked() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void notifyBadOrEmptyEmail() {
        username.setError("Invalid username format");
    }

    @Override
    public void notifyBadPassword() {
        password.setError("Password must not be less than 8 characters");
    }

    @Override
    public void goToHomePage() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }
}
