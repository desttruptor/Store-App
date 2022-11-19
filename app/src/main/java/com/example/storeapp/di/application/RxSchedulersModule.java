package com.example.storeapp.di.application;

import com.example.storeapp.utils.schedulers.RxSchedulers;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Module
public class RxSchedulersModule {

    @Provides
    @ApplicationScope
    @Named("mainThreadScheduler")
    public Scheduler provideAndroidMainThreadScheduler () {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @ApplicationScope
    @Named("ioScheduler")
    public Scheduler provideIoScheduler () {
        return Schedulers.io();
    }

    @Provides
    @ApplicationScope
    public RxSchedulers provideShedulersContainer (
            @Named("mainThreadScheduler") Scheduler mainThreadScheduler,
            @Named("ioScheduler") Scheduler ioScheduler
    ) {
        return new RxSchedulers(mainThreadScheduler, ioScheduler);
    }
}
