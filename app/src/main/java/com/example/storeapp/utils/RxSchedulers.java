package com.example.storeapp.utils;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Scheduler;

public class RxSchedulers {
    @NonNull
    public Scheduler io;
    @NonNull
    public Scheduler main;

    @Inject
    public RxSchedulers (@NonNull Scheduler io, @NonNull Scheduler main) {
        this.io = io;
        this.main = main;
    }
}
