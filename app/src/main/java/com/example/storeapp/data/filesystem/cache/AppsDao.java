package com.example.storeapp.data.filesystem.cache;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface AppsDao {
    @Query("SELECT * FROM applications")
    Single<List<AppEntity>> getAppsListFromDB();

    @Query("SELECT * FROM applications WHERE title = :title")
    Single<AppEntity> getAppByTitle(String title);

    @Query("DELETE FROM applications")
    void deleteAllApps();
}
