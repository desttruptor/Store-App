package com.example.storeapp.di.application;

import com.example.storeapp.data.repository.ApplicationRepository;
import com.example.storeapp.data.repository.ApplicationRepositoryImpl;

import dagger.Binds;
import dagger.Module;

@Module
public interface AppBindings {

    @Binds
    public ApplicationRepository bindRepositoryImpl_to_Repository (ApplicationRepositoryImpl repository);
}
