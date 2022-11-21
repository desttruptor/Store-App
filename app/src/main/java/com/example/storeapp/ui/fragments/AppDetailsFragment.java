package com.example.storeapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.storeapp.databinding.FragmentAppDetailsBinding;
import com.example.storeapp.ui.MainActivity;
import com.example.storeapp.ui.viewmodels.AppDetailsViewModel;

public class AppDetailsFragment extends Fragment {

    public static String APP_KEY = "app_key";

    private String currentApp;
    private FragmentAppDetailsBinding binding;
    private AppDetailsViewModel viewModel;

    public static AppDetailsFragment newInstance (String parameter) {
        AppDetailsFragment fragment = new AppDetailsFragment();
        Bundle arguments = new Bundle();
        arguments.putString(APP_KEY, parameter);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onAttach (@NonNull Context context) {
        ((MainActivity) requireActivity()).getAppComponent().inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAppDetailsBinding.inflate(inflater, container, false);
        currentApp = requireArguments().getString(APP_KEY);
        setupViewModel();
        return binding.getRoot();
    }

    @Override
    public void onDestroyView () {
        binding = null;
        super.onDestroyView();
    }

    private void setupViewModel () {
        
    }
}
