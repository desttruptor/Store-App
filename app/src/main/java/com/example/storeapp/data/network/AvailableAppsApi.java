package com.example.storeapp.data.network;

import com.example.storeapp.data.network.responses.GetAppsResponse;
import com.example.storeapp.utils.Constants;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface AvailableAppsApi {

    @GET(Constants.LATEST_ALL_ENDPOINT)
    Single<List<GetAppsResponse>> getAppsData ();
}
