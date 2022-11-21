package com.example.storeapp;

import android.app.Application;

import com.example.storeapp.di.application.AppComponent;
import com.example.storeapp.di.application.DaggerAppComponent;

public class StoreApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
