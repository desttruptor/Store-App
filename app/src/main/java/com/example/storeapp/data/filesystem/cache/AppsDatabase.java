package com.example.storeapp.data.filesystem.cache;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AppEntity.class}, version = 1, exportSchema = false)
public abstract class AppsDatabase extends RoomDatabase {
    public abstract AppsDao appsDao();
}
