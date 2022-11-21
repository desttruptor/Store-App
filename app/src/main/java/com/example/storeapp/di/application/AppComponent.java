package com.example.storeapp.di.application;

import android.app.Application;

import com.example.storeapp.ui.fragments.AppsListFragment;

import dagger.BindsInstance;
import dagger.Component;

@ApplicationScope
@Component(modules = {
        AppModule.class,
        AppBindings.class,
        NetworkModule.class
})
public interface AppComponent {
    void inject(AppsListFragment appsListFragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
