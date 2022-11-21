package com.example.storeapp.di.application;

import com.example.storeapp.data.network.AvailableAppsApi;
import com.example.storeapp.data.network.DownloadAppApi;
import com.example.storeapp.data.network.interceptors.LoggingInterceptor;
import com.example.storeapp.utils.Constants;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @ApplicationScope
    @Provides
    public LoggingInterceptor provideLoggingInterceptor () {
        return new LoggingInterceptor();
    }

    @ApplicationScope
    @Provides
    public OkHttpClient provideOkHttpClient (LoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .callTimeout(10L, TimeUnit.SECONDS)
                .connectTimeout(10L, TimeUnit.SECONDS)
                .build();
    }

    @ApplicationScope
    @Provides
    public Retrofit provideRetrofit (OkHttpClient client) {
        var factory = RxJava3CallAdapterFactory.create();
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.UPDATE_PAYMOB_RU_BASE_URL)
                .addCallAdapterFactory(factory)
                .build();
    }

    @ApplicationScope
    @Provides
    public AvailableAppsApi provideAvailableAppsApi (Retrofit retrofit) {
        return retrofit.create(AvailableAppsApi.class);
    }

    @ApplicationScope
    @Provides
    public DownloadAppApi provideDownloadAppApi (Retrofit retrofit) {
        return retrofit.create(DownloadAppApi.class);
    }
}
