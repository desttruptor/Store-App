package com.example.storeapp.di.viewmodels;

import androidx.lifecycle.ViewModelProvider;

import com.example.storeapp.ui.viewmodels.ViewModelFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryBindingsModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory (ViewModelFactory factory);
}
