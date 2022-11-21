package com.example.storeapp.di.application;

import android.app.Application;

import androidx.room.Room;

import com.example.storeapp.data.filesystem.cache.AppsDao;
import com.example.storeapp.data.filesystem.cache.AppsDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @ApplicationScope
    public AppsDatabase provideAppsDatabase(Application application) {
        return Room.databaseBuilder(application, AppsDatabase.class, "apps-database")
                .build();
    }

    @Provides
    @ApplicationScope
    public AppsDao provideAppsDao(AppsDatabase appsDatabase) {
        return appsDatabase.appsDao();
    }
}
