package com.example.storeapp.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.storeapp.utils.CustomSupplier;

public class CommonViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    private final Class<? extends ViewModel> viewModelClass;
    @NonNull
    private final CustomSupplier<? extends ViewModel> viewModelSupplier;

    public CommonViewModelFactory (
            @NonNull Class<? extends ViewModel> viewModelClass,
            @NonNull CustomSupplier<? extends ViewModel> viewModelSupplier
    ) {
        this.viewModelClass = viewModelClass;
        this.viewModelSupplier = viewModelSupplier;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create (@NonNull Class<T> modelClass) {
        if (!viewModelClass.isAssignableFrom(modelClass)) {
            throw new IllegalArgumentException("Invalid viewModel class");
        }
        //noinspection unchecked
        return (T) viewModelSupplier.get();
    }
}
