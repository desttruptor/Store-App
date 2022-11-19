package com.example.storeapp.domain.converters;

import static com.example.storeapp.utils.StringUtils.isNotBlank;

import com.example.storeapp.data.network.responses.GetAppsResponse;
import com.example.storeapp.domain.models.AppsUiModel;

public class ApplicationListConverter implements BaseConverter<GetAppsResponse, AppsUiModel> {
    @Override
    public AppsUiModel convert (GetAppsResponse appsResponse) {
        return new AppsUiModel(
                isNotBlank(appsResponse.getLink()),
                isNotBlank(appsResponse.getVersion()),
                isNotBlank(appsResponse.getType()),
                isNotBlank(appsResponse.getLogo200Link()),
                isNotBlank(appsResponse.getTitle()),
                isNotBlank(appsResponse.getDescription())
        );
    }
}
