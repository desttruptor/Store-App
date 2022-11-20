package com.example.storeapp.ui;

import android.os.Bundle;

import com.example.storeapp.databinding.ActivityMainBinding;
import com.example.storeapp.ui.fragments.AppsListFragment;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        setUpFragment();
    }

    private void setUpFragment () {
        getSupportFragmentManager()
                .beginTransaction()
                .add(activityMainBinding.fragmentContainer.getId(), AppsListFragment.newInstance())
                .commit();
    }
}