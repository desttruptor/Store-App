package com.example.storeapp.data.repository;

import com.example.storeapp.data.network.GetAppsResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface AppsRepository {
    /**
     * Fetch all available apps
     * @return list of available apps
     */
    Single<List<GetAppsResponse>> getAvailableApps();
}
