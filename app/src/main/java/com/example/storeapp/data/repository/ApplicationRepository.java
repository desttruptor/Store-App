package com.example.storeapp.data.repository;

import com.example.storeapp.data.filesystem.AppStatusResponse;
import com.example.storeapp.data.network.responses.GetAppsResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface ApplicationRepository {
    /**
     * Get list of all available apps on market
     *
     * @return list of apps
     */
    Single<List<GetAppsResponse>> getAllAppsList ();

    /**
     * Get list of applications status
     *
     * @return list of statuses
     */
    Single<List<AppStatusResponse>> getAppsStatusList ();
}
