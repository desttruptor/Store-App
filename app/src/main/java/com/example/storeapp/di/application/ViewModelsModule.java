package com.example.storeapp.di.application;

import com.example.storeapp.data.repository.AppsRepository;
import com.example.storeapp.data.resourcemanager.ResourceManager;
import com.example.storeapp.domain.mappers.AppsListMapper;
import com.example.storeapp.ui.viewmodels.AllAppsViewModel;
import com.example.storeapp.ui.viewmodels.AppDetailsViewModel;
import com.example.storeapp.utils.RxSchedulers;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelsModule {
    @Provides
    public AllAppsViewModel provideAllAppsViewModel (
            AppsRepository appsRepository,
            RxSchedulers rxSchedulers,
            AppsListMapper appsListMapper,
            ResourceManager resourceManager
    ) {
        return new AllAppsViewModel(
                appsRepository,
                rxSchedulers,
                appsListMapper,
                resourceManager
        );
    }

    @Provides
    public AppDetailsViewModel provideAppDetailsViewModel (
            ResourceManager resourceManager
    ) {
        return new AppDetailsViewModel(
                resourceManager
        );
    }
}
