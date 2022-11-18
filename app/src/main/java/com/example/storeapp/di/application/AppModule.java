package com.example.storeapp.di.application;

import android.app.Application;

import com.example.storeapp.StoreApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final StoreApplication application;

    public AppModule(StoreApplication application) {
        this.application = application;
    }

    @ApplicationScope
    @Provides
    public StoreApplication provideApplication() {
        return application;
    }
}
