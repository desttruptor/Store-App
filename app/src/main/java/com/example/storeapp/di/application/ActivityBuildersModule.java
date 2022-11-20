package com.example.storeapp.di.application;

import com.example.storeapp.di.viewmodels.ViewModelsModule;
import com.example.storeapp.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {
            ViewModelsModule.class
    })
    abstract MainActivity mainActivity ();
}
