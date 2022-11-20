package com.example.storeapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.storeapp.databinding.FragmentScrollableContentBinding;
import com.example.storeapp.domain.models.AppsListItemModel;
import com.example.storeapp.ui.MainActivity;
import com.example.storeapp.ui.viewmodels.AllAppsViewModel;

import java.util.List;

import javax.inject.Inject;

public class AppsListFragment extends Fragment {

//    @Inject
//    public ViewModelProvider.Factory factory;

    private FragmentScrollableContentBinding binding;
    private AllAppsViewModel viewModel;

    @NonNull
    public static AppsListFragment newInstance () {
        return new AppsListFragment();
    }

    @Override
    public void onAttach (@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView (
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentScrollableContentBinding.inflate(inflater, container, false);
        setUpViewModel();
        setUpView();
        return binding.getRoot();
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }

    private void setUpViewModel () {
//        viewModel = new ViewModelProvider(this, factory).get(AllAppsViewModel.class);
//        viewModel.getAppsList().observe(getViewLifecycleOwner(), this::onAppsListUpdate);
//        viewModel.getErrorMessage().observe(getViewLifecycleOwner(), this::onError);
    }

    private void setUpView () {
    }

    private void onAppsListUpdate (List<AppsListItemModel> appsListItemModels) {

    }

    private void onError (String s) {
    }
}
