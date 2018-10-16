package com.amoharib.soleeklabapp.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.amoharib.soleeklabapp.R;
import com.amoharib.soleeklabapp.ui.home.HomeActivity;
import com.amoharib.soleeklabapp.ui.register.RegistrationActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

public class LoginActivity extends DaggerAppCompatActivity implements LoginContract.View {

    @Inject
    LoginContract.Presenter presenter;
    @BindView(R.id.username)
    TextInputEditText username;
    @BindView(R.id.password)
    TextInputEditText password;
    @BindView(R.id.login_btn)
    Button loginBtn;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setUpProgressBar();
        presenter.subscribe(this);
    }

    private void setUpProgressBar() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.logging_in_message));
        progressDialog.setCancelable(false);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void notifyEmptyOrBadEmail() {
        username.setError("Invalid username format");
    }

    @Override
    public void notifyBadPassword() {
        password.setError("Password must not be less than 8 characters");
    }

    @Override
    public void goToHomePage() {
        Intent intent = new Intent(this, HomeActivity.class);
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

    @OnClick(R.id.login_btn)
    public void onLoginBtnClicked() {
        presenter.loginUser(username.getText().toString(), password.getText().toString());
    }

    @OnClick(R.id.signup_tv)
    public void onRegistrationClicked() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}
