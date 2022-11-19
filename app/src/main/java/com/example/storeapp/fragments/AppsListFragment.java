package com.example.storeapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.storeapp.databinding.FragmentScrollableContentBinding;
import com.example.storeapp.ui.MainActivity;
import com.example.storeapp.ui.viewmodels.AppsListViewModel;

public class AppsListFragment extends Fragment {

    private FragmentScrollableContentBinding binding;
    private ViewModel viewModel;

    @NonNull
    public static AppsListFragment newInstance () {
        return new AppsListFragment();
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
//        setUpScreen();
        return binding.getRoot();
    }

    private void setUpViewModel () {
        viewModel = new ViewModelProvider(this).get(AppsListViewModel.class);
        ((MainActivity) requireActivity()).getAppComponent().inject((AppsListViewModel) viewModel);
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }
}
