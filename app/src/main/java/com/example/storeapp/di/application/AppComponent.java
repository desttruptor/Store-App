package com.example.storeapp.di.application;

import com.example.storeapp.ui.viewmodels.AppsListViewModel;

import dagger.Component;

@ApplicationScope
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        AppBindings.class,
        DomainModule.class,
        RxSchedulersModule.class
})
public interface AppComponent {
    void inject (AppsListViewModel viewModel);
}
