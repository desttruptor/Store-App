package com.example.storeapp.domain.models;

/**
 * Model representing item in list of all apps
 */
public class AppsListItemModel {
    private final String type;
    private final String logo200Link;
    private final String title;
    private String status;

    public AppsListItemModel (String type, String logo200Link, String title) {
        this.type = type;
        this.logo200Link = logo200Link;
        this.title = title;
    }

    public String getType () {
        return type;
    }

    public String getLogo200Link () {
        return logo200Link;
    }

    public String getTitle () {
        return title;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }
}
