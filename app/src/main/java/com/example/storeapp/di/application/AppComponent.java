package com.example.storeapp.di.application;

import android.app.Application;

import com.example.storeapp.StoreApplication;
import com.example.storeapp.di.viewmodels.ViewModelFactoryBindingsModule;
import com.example.storeapp.di.viewmodels.ViewModelsModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;

@ApplicationScope
@Component(modules = {
        AppModule.class,
        AppBindings.class,
        NetworkModule.class,
        ViewModelFactoryBindingsModule.class,
        ViewModelsModule.class
})
public interface AppComponent extends AndroidInjector<StoreApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application (Application application);

        AppComponent build ();
    }
}
