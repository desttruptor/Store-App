package com.example.storeapp.utils.schedulers;

import io.reactivex.rxjava3.core.Scheduler;

public class RxSchedulers {

    public Scheduler mainThread;
    public Scheduler io;

    public RxSchedulers (Scheduler mainThreadScheduler, Scheduler ioScheduler) {
        mainThread = mainThreadScheduler;
        io = ioScheduler;
    }
}
