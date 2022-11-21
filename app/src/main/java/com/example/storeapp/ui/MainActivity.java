package com.example.storeapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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

    public void navigateToFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(activityMainBinding.fragmentContainer.getId(), fragment)
                .addToBackStack(null)
                .commit();
    }

    private void setUpFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(activityMainBinding.fragmentContainer.getId(), AppsListFragment.newInstance())
                .commit();
    }
}