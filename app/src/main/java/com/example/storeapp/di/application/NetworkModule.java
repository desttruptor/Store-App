package com.example.storeapp.di.application;

import static retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory.create;

import androidx.annotation.NonNull;

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
    @Provides
    @ApplicationScope
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .callTimeout(10L, TimeUnit.SECONDS)
                .connectTimeout(10L, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient client) {
        var factory = RxJava3CallAdapterFactory.create();
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.UPDATE_PAYMOB_RU_BASE_URL)
                .addCallAdapterFactory(factory)
                .build();
    }
}
