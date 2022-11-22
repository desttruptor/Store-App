package com.example.storeapp.data.repository;

import com.example.storeapp.data.filesystem.cache.AppEntity;
import com.example.storeapp.data.network.GetAppsResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Interface to interact with data-layer entities
 */
public interface AppsRepository {

    Single<List<GetAppsResponse>> getAvailableApps();

    Single<List<AppEntity>> getAppsListFromDB();

    Single<AppEntity> getAppByTitleFromDB(String title);

    void deleteAllAppsFromDB();
}
