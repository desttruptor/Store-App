package com.example.storeapp.data.network;

import io.reactivex.rxjava3.core.Single;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface DownloadAppApi {

    @Streaming
    @GET
    Single<Response<ResponseBody>> downloadApkFile (@Url String fileUrl);
}
