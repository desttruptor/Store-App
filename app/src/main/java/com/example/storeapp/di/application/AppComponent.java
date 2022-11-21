package com.example.storeapp.di.application;

import android.app.Application;

import com.example.storeapp.ui.fragments.AppDetailsFragment;
import com.example.storeapp.ui.fragments.AppsListFragment;

import dagger.BindsInstance;
import dagger.Component;

@ApplicationScope
@Component(modules = {
        AppModule.class,
        AppBindings.class,
        NetworkModule.class,
        DatabaseModule.class
})
public interface AppComponent {
    void inject(AppsListFragment appsListFragment);

    void inject(AppDetailsFragment appDetailsFragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
