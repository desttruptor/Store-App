package com.example.storeapp.di.application;

import com.example.storeapp.StoreApplication;
import com.example.storeapp.data.resourcemanager.ResourceManagerImpl;
import com.example.storeapp.domain.mappers.AppsListMapper;
import com.example.storeapp.utils.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Module
public class AppModule {

    @ApplicationScope
    @Provides
    public Scheduler provideMainThreadScheduler () {
        return AndroidSchedulers.mainThread();
    }

    @ApplicationScope
    @Provides
    public Scheduler provideIOScheduler () {
        return Schedulers.io();
    }

    @ApplicationScope
    @Provides
    public RxSchedulers provideRxSchedulers (
            Scheduler androidScheduler,
            Scheduler ioScheduler
    ) {
        return new RxSchedulers(androidScheduler, ioScheduler);
    }

    @ApplicationScope
    @Provides
    public ResourceManagerImpl provideResourceManagerImpl (StoreApplication context) {
        return new ResourceManagerImpl(context);
    }

    @ApplicationScope
    @Provides
    public AppsListMapper provideAppsListMapper () {
        return new AppsListMapper();
    }
}
