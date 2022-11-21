package com.example.storeapp.data.resourcemanager;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import javax.inject.Inject;

public class ResourceManagerImpl implements ResourceManager {

    @NonNull
    private final Context context;

    @Inject
    public ResourceManagerImpl(
            @NonNull Application context
    ) {
        this.context = context;
    }

    @NonNull
    @Override
    public String getString(int stringRes) {
        return context.getString(stringRes);
    }
}
