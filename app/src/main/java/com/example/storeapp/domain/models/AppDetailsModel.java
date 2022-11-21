package com.example.storeapp.domain.models;

import androidx.annotation.NonNull;

/**
 * Model to use with {@link com.example.storeapp.ui.fragments.AppDetailsFragment}
 */
public class AppDetailsModel {
    @NonNull
    private final String link;
    @NonNull
    private final String version;
    @NonNull
    private final String type;
    @NonNull
    private final String logo50Link;
    @NonNull
    private final String logo200Link;
    @NonNull
    private final String title;
    @NonNull
    private final String description;

    public AppDetailsModel(@NonNull String link, @NonNull String version, @NonNull String type, @NonNull String logo50Link, @NonNull String logo200Link, @NonNull String title, @NonNull String description) {
        this.link = link;
        this.version = version;
        this.type = type;
        this.logo50Link = logo50Link;
        this.logo200Link = logo200Link;
        this.title = title;
        this.description = description;
    }

    @NonNull
    public String getLink() {
        return link;
    }

    @NonNull
    public String getVersion() {
        return version;
    }

    @NonNull
    public String getType() {
        return type;
    }

    @NonNull
    public String getLogo50Link() {
        return logo50Link;
    }

    @NonNull
    public String getLogo200Link() {
        return logo200Link;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getDescription() {
        return description;
    }
}
