package com.example.storeapp.di.application;

import com.example.storeapp.data.repository.ApplicationRepository;
import com.example.storeapp.domain.converters.ApplicationListConverter;
import com.example.storeapp.domain.usecases.FetchAllAppsListUseCase;
import com.example.storeapp.utils.schedulers.RxSchedulers;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainModule {

    @Provides
    public FetchAllAppsListUseCase provideFetchAllAppsListUseCase (
            ApplicationRepository repository,
            ApplicationListConverter converter,
            RxSchedulers schedulers
    ) {
        return new FetchAllAppsListUseCase(repository, converter, schedulers);
    }

    @Provides
    public ApplicationListConverter provideApplicationListConverter () {
        return new ApplicationListConverter();
    }

}
