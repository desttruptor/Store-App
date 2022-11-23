package com.example.storeapp.data.systemapps;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class SystemAppsRepositoryImpl implements SystemAppsRepository {

    private final Application application;

    @Inject
    SystemAppsRepositoryImpl (Application application) {
        this.application = application;
    }

    @Override
    public List<String> getInstalledPackageNames () {
        PackageManager pm = application.getPackageManager();
        List<PackageInfo> packagesList = pm.getInstalledPackages(PackageManager.GET_META_DATA);
        return Observable.fromIterable(packagesList)
                .map(packageInfo -> packageInfo.packageName)
                .toList()
                .blockingGet();
    }

    @Override
    public boolean checkIfSpecifiedPackageInstalled (String packageName) {
        return Observable.fromIterable(getInstalledPackageNames())
                .filter(installedPackageName -> installedPackageName.equals(packageName))
                .defaultIfEmpty("")
                .map(installedPackageName -> !packageName.isEmpty())
                .blockingFirst();
    }
}
