package com.example.storeapp.data.filesystem.cache;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "applications")
public class AppEntity {
    @NonNull
    public String link;
    @NonNull
    public String version;
    @NonNull
    @PrimaryKey
    public String type;
    @NonNull
    public String logo50Link;
    @NonNull
    public String logo200Link;
    @NonNull
    public String title;
    @NonNull
    public String description;
}
