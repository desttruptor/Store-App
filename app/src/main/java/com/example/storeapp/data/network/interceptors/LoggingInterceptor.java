package com.example.storeapp.data.network.interceptors;

import static com.example.storeapp.utils.Constants.LOG_TAG_HTTP;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * An interceptor to log http API requests and responses
 */
public class LoggingInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        String requestLogMessage = "Sending request to " + chain.request().url();
        Log.v(LOG_TAG_HTTP, requestLogMessage);
        Response response = chain.proceed(chain.request());
        String responseLogMessage = "Received response body: \n" + response.peekBody(4096).string();
        Log.v(LOG_TAG_HTTP, responseLogMessage);
        return response;
    }
}
