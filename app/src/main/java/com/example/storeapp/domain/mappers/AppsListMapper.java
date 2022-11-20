package com.example.storeapp.domain.mappers;

import com.example.storeapp.data.network.GetAppsResponse;
import com.example.storeapp.domain.models.AppsListItemModel;

public class AppsListMapper implements BaseMapper<GetAppsResponse, AppsListItemModel> {

    @Override
    public AppsListItemModel convert (GetAppsResponse getAppsResponse) {
        return new AppsListItemModel(
                getAppsResponse.getType(),
                getAppsResponse.getLogo200Link(),
                getAppsResponse.getTitle()
        );
    }
}
