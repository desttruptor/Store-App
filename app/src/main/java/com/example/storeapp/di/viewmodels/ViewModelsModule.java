package com.example.storeapp.di.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.storeapp.ui.viewmodels.AllAppsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AllAppsViewModel.class)
    abstract ViewModel bindAllAppsViewModel (AllAppsViewModel allAppsViewModel);
}
