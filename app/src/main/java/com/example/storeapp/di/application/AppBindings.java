package com.example.storeapp.di.application;

import com.example.storeapp.data.repository.AppsRepository;
import com.example.storeapp.data.repository.AppsRepositoryImpl;
import com.example.storeapp.data.resourcemanager.ResourceManager;
import com.example.storeapp.data.resourcemanager.ResourceManagerImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppBindings {

    @Binds
    public abstract AppsRepository bindAppsRepository (AppsRepositoryImpl appsRepository);

    @Binds
    public abstract ResourceManager bindResourceManager (ResourceManagerImpl resourceManagerImpl);
}
