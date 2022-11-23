package com.example.storeapp.data.systemapps;

import java.util.List;

public interface SystemAppsRepository {
    List<String> getInstalledPackageNames ();

    boolean checkIfSpecifiedPackageInstalled (String packageName);
}
