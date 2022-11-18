package com.example.storeapp;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.storeapp.di.application.AppComponent;
import com.example.storeapp.di.application.AppModule;
import com.example.storeapp.di.application.DaggerAppComponent;
import com.example.storeapp.di.application.NetworkModule;

public class StoreApplication extends Application {

    private AppComponent daggerAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        daggerAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    @NonNull
    public AppComponent getDaggerAppComponent() {
        return daggerAppComponent;
    }
}
