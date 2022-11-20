package com.example.storeapp.data.repository;

import androidx.annotation.NonNull;

import com.example.storeapp.data.network.AvailableAppsApi;
import com.example.storeapp.data.network.GetAppsResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class AppsRepositoryImpl implements AppsRepository {

    @NonNull
    private final AvailableAppsApi availableAppsApi;

    @Inject
    public AppsRepositoryImpl (@NonNull AvailableAppsApi availableAppsApi) {
        this.availableAppsApi = availableAppsApi;
    }

    @Override
    public Single<List<GetAppsResponse>> getAvailableApps () {
        return availableAppsApi.getAppsData();
    }
}
