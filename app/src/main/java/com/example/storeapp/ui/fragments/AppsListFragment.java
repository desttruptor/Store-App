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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeapp.R;
import com.example.storeapp.data.repository.AppsRepository;
import com.example.storeapp.data.resourcemanager.ResourceManager;
import com.example.storeapp.databinding.FragmentScrollableContentBinding;
import com.example.storeapp.domain.mappers.AppsListMapper;
import com.example.storeapp.domain.models.AppsListItemModel;
import com.example.storeapp.ui.MainActivity;
import com.example.storeapp.ui.adapters.AppsListAdapter;
import com.example.storeapp.ui.viewmodels.AllAppsViewModel;
import com.example.storeapp.ui.viewmodels.CommonViewModelFactory;
import com.example.storeapp.utils.RxSchedulers;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import javax.inject.Inject;

/**
 * I know that is bad approach but Dagger multibinding doesn't work
 */
public class AppsListFragment extends Fragment {

    @Inject
    AppsRepository repository;

    @Inject
    RxSchedulers rxSchedulers;

    @Inject
    AppsListMapper mapper;

    @Inject
    ResourceManager resourceManager;

    private FragmentScrollableContentBinding binding;
    private AllAppsViewModel viewModel;
    private AppsListAdapter listAdapter;

    @NonNull
    public static AppsListFragment newInstance() {
        return new AppsListFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        ((MainActivity) requireActivity()).getAppComponent().inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(
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
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setUpViewModel() {
        CommonViewModelFactory factory = new CommonViewModelFactory(
                AllAppsViewModel.class,
                () -> new AllAppsViewModel(repository, rxSchedulers, mapper, resourceManager)
        );
        viewModel = new ViewModelProvider(this, factory).get(AllAppsViewModel.class);
        viewModel.getAppsList().observe(getViewLifecycleOwner(), this::onAppsListUpdate);
        viewModel.getErrorMessage().observe(getViewLifecycleOwner(), this::onError);
        viewModel.fetchAppsList();
    }

    private void setUpView() {
        binding.toolbar.setTitle(getString(R.string.toolbar_title));
        listAdapter = new AppsListAdapter(this::onListItemClick);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        binding.scrollableContent.setLayoutManager(layoutManager);
        binding.scrollableContent.setAdapter(listAdapter);
    }

    private void onListItemClick(String s) {
        ((MainActivity) requireActivity()).navigateToFragment(AppDetailsFragment.newInstance(s));
    }

    private void onAppsListUpdate(List<AppsListItemModel> appsListItemModels) {
        listAdapter.submitNewList(appsListItemModels);
    }

    private void onError(String s) {
        showSnackBar(s);
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(binding.getRoot(), message, Snackbar.LENGTH_SHORT);
        snackbar.setAction(getString(R.string.retry), view -> viewModel.fetchAppsList());
        snackbar.show();
    }
}
