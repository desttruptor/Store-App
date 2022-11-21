package com.example.storeapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storeapp.StoreApplication;
import com.example.storeapp.databinding.ActivityMainBinding;
import com.example.storeapp.di.application.AppComponent;
import com.example.storeapp.ui.fragments.AppsListFragment;

public class MainActivity extends AppCompatActivity {

    private AppComponent appComponent;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        appComponent = ((StoreApplication) getApplication()).getAppComponent();
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        setUpFragment();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void setUpFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(activityMainBinding.fragmentContainer.getId(), AppsListFragment.newInstance())
                .commit();
    }
}