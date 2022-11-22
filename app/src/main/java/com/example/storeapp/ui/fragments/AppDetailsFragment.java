package com.example.storeapp.ui.fragments;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.storeapp.R;
import com.example.storeapp.databinding.FragmentAppDetailsBinding;
import com.example.storeapp.domain.models.AppDetailsModel;
import com.example.storeapp.ui.MainActivity;
import com.example.storeapp.ui.viewmodels.AppDetailsViewModel;
import com.example.storeapp.ui.viewmodels.CommonViewModelFactory;
import com.example.storeapp.utils.UIUtils;

import javax.inject.Inject;

public class AppDetailsFragment extends Fragment {

    public static String APP_TITLE_KEY = "app_title_key";

    @Inject
    AppDetailsViewModel appDetailsViewModel;

    private String currentAppTitle;
    private FragmentAppDetailsBinding binding;
    private AppDetailsViewModel viewModel;
    private long nowLoading;
    private final BroadcastReceiver onDownloadComplete = new BroadcastReceiver() {
        @Override
        public void onReceive (Context context, Intent intent) {
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            if (nowLoading == id) {
            }
        }
    };

    public static AppDetailsFragment newInstance (String appTitle) {
        AppDetailsFragment fragment = new AppDetailsFragment();
        Bundle arguments = new Bundle();
        arguments.putString(APP_TITLE_KEY, appTitle);
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
        currentAppTitle = requireArguments().getString(APP_TITLE_KEY);
        setupView();
        setupViewModel();
        return binding.getRoot();
    }

    @Override
    public void onDestroyView () {
        binding = null;
        super.onDestroyView();
    }

    private void setupView () {
        binding.downloadingGroup.setVisibility(UIUtils.isVisibleOrGone(false));
        binding.btnStopLoading.setOnClickListener(this::stopApplicationLoading);
        binding.buttonPositiveAction.setOnClickListener(this::onPositiveButtonClicked);
        binding.buttonNegativeAction.setOnClickListener(this::onNegativeButtonClicked);
    }

    private void stopApplicationLoading (View view) {

    }

    private void onNegativeButtonClicked (View view) {

    }

    private void onPositiveButtonClicked (View view) {

    }

    private void setupViewModel () {
        CommonViewModelFactory factory = new CommonViewModelFactory(appDetailsViewModel.getClass(), () -> appDetailsViewModel);
        viewModel = new ViewModelProvider(this, factory).get(appDetailsViewModel.getClass());
        viewModel.getRequestMutableLiveData().observe(this.getViewLifecycleOwner(), this::onDownloadRequestCreated);
        viewModel.getSelectedAppDetailsLiveData().observe(this.getViewLifecycleOwner(), this::onSuccessLoadAppDetails);
    }

    private void onSuccessLoadAppDetails (AppDetailsModel appDetailsModel) {
        Glide.with(this)
                .load(appDetailsModel.getLogo200Link())
                .apply(getRequestOptions())
                .into(binding.ivAppLogo);
        binding.tvAppTitle.setText(appDetailsModel.getTitle());
        binding.tvAppDescription.setText(appDetailsModel.getDescription());
    }

    private void onDownloadRequestCreated (DownloadManager.Request request) {
        DownloadManager downloadManager = (DownloadManager) requireActivity().getSystemService(Context.DOWNLOAD_SERVICE);
        nowLoading = downloadManager.enqueue(request);
        downloadManager.remove();
    }

    private RequestOptions getRequestOptions () {
        return new RequestOptions()
                .circleCrop()
                .placeholder(R.drawable.ic_outline_get_app_24);
    }
}
