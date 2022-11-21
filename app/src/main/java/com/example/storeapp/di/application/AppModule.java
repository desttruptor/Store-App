package com.example.storeapp.di.application;

import android.app.Application;

import com.example.storeapp.data.resourcemanager.ResourceManagerImpl;
import com.example.storeapp.di.qualifiers.IOScheduler;
import com.example.storeapp.di.qualifiers.MainThreadScheduler;
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
    @MainThreadScheduler
    public Scheduler provideMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @ApplicationScope
    @IOScheduler
    @Provides
    public Scheduler provideIOScheduler() {
        return Schedulers.io();
    }

    @ApplicationScope
    @Provides
    public RxSchedulers provideRxSchedulers(
            @IOScheduler Scheduler ioScheduler,
            @MainThreadScheduler Scheduler mainThreadScheduler
    ) {
        return new RxSchedulers(ioScheduler, mainThreadScheduler);
    }

    @ApplicationScope
    @Provides
    public ResourceManagerImpl provideResourceManagerImpl(Application context) {
        return new ResourceManagerImpl(context);
    }

    @ApplicationScope
    @Provides
    public AppsListMapper provideAppsListMapper() {
        return new AppsListMapper();
    }
}
