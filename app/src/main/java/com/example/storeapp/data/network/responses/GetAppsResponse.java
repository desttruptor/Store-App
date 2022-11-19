package com.example.storeapp.data.network.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Response model for "software/latest/all" endpoint
 */
public class GetAppsResponse {

    @SerializedName("link")
    private String link;

    @SerializedName("version")
    private String version;

    @SerializedName("type")
    private String type;

    @SerializedName("logo50Link")
    private String logo50Link;

    @SerializedName("logo200Link")
    private String logo200Link;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogo50Link() {
        return logo50Link;
    }

    public void setLogo50Link(String logo50Link) {
        this.logo50Link = logo50Link;
    }

    public String getLogo200Link() {
        return logo200Link;
    }

    public void setLogo200Link(String logo200Link) {
        this.logo200Link = logo200Link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}