package com.example.storeapp.data.resourcemanager;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.storeapp.StoreApplication;

import javax.inject.Inject;

public class ResourceManagerImpl implements ResourceManager {

    // this is application context
    private final Context context;

    @Inject
    public ResourceManagerImpl (
            StoreApplication context
    ) {
        this.context = context;
    }

    @NonNull
    @Override
    public String getString (int stringRes) {
        return context.getString(stringRes);
    }
}
