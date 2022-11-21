package com.example.storeapp.data.repository;

import androidx.annotation.NonNull;

import com.example.storeapp.data.filesystem.cache.AppEntity;
import com.example.storeapp.data.filesystem.cache.AppsDao;
import com.example.storeapp.data.network.AvailableAppsApi;
import com.example.storeapp.data.network.GetAppsResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class AppsRepositoryImpl implements AppsRepository {

    @NonNull
    private final AvailableAppsApi availableAppsApi;
    @NonNull
    private final AppsDao appsDao;

    @Inject
    public AppsRepositoryImpl(
            @NonNull AvailableAppsApi availableAppsApi,
            @NonNull AppsDao appsDao
    ) {
        this.availableAppsApi = availableAppsApi;
        this.appsDao = appsDao;
    }

    @Override
    public Single<List<GetAppsResponse>> getAvailableApps() {
        return availableAppsApi.getAppsData();
    }

    @Override
    public Single<List<AppEntity>> getAppsListFromDB() {
        return appsDao.getAppsListFromDB();
    }

    @Override
    public Single<AppEntity> getAppByTitleFromDB (String title) {
        return appsDao.getAppByTitle(title);
    }

    @Override
    public void deleteAllAppsFromDB () {
        appsDao.deleteAllApps();
    }
}
