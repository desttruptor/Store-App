package com.example.storeapp.data.repository;

import androidx.annotation.NonNull;

import com.example.storeapp.data.filesystem.AppStatusResponse;
import com.example.storeapp.data.network.AvailableAppsApi;
import com.example.storeapp.data.network.responses.GetAppsResponse;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class ApplicationRepositoryImpl implements ApplicationRepository {

    AvailableAppsApi availableAppsApi;

    @Inject
    public ApplicationRepositoryImpl (@NonNull AvailableAppsApi availableAppsApi) {
        this.availableAppsApi = availableAppsApi;
    }

    @Override
    @NonNull
    public Single<List<GetAppsResponse>> getAllAppsList () {
        return availableAppsApi.getAppsData();
    }

    @Override
    public Single<List<AppStatusResponse>> getAppsStatusList () {
        return Single.just(Collections.emptyList());
    }
}
