package com.amoharib.soleeklabapp.app.base;

public interface BasePresenter<T> {
    void subscribe(T view);

    void unsubscribe();
}
