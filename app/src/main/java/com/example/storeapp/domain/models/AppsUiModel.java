package com.example.storeapp.domain.models;

public class AppsUiModel {
    private final String link;
    private final String version;
    private final String type;
    private final String logo200Link;
    private final String title;
    private final String description;
    private String installationStatus;

    public AppsUiModel (String link, String version, String type, String logo200Link, String title, String description) {
        this.link = link;
        this.version = version;
        this.type = type;
        this.logo200Link = logo200Link;
        this.title = title;
        this.description = description;
    }

    public String getLink () {
        return link;
    }

    public String getVersion () {
        return version;
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

    public String getDescription () {
        return description;
    }

    public String getInstallationStatus () {
        return installationStatus;
    }

    public void setInstallationStatus (String installationStatus) {
        this.installationStatus = installationStatus;
    }
}
