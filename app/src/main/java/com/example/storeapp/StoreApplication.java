package com.example.storeapp;

import com.example.storeapp.di.application.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class StoreApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector () {
        return DaggerAppComponent.builder()
                .application(this)
                .build();
    }
}
