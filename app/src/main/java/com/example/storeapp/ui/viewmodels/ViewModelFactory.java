package com.example.storeapp.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.storeapp.utils.CustomSupplier;

public class dViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    private final CustomSupplier<? extends ViewModel> vmInstance;
    @NonNull
    private final Class<? extends ViewModel> supplier;


    public ViewModelFactory(
            @NonNull Class<? extends ViewModel> viewModelClass,
            @NonNull CustomSupplier<? extends ViewModel> supplier
    ) {
        this.vmInstance = supplier;
        this.supplier = viewModelClass;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (!modelClass.isAssignableFrom(supplier)) {
            throw new IllegalArgumentException("ViewModel type is non assignable");
        }
        return (T) vmInstance.get();
    }
}
