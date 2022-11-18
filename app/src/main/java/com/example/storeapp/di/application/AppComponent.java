package com.example.storeapp.di.application;

import dagger.Component;

@ApplicationScope
@Component(modules = {
        AppModule.class,
        NetworkModule.class
})
public interface AppComponent {

}
