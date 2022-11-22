package com.example.storeapp.ui.viewmodels;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.storeapp.R;
import com.example.storeapp.data.resourcemanager.ResourceManager;

import java.io.File;

import javax.inject.Inject;

public class AppDetailsViewModel extends ViewModel {

    private final MutableLiveData<DownloadManager.Request> requestMutableLiveData = new MutableLiveData<>();
    @NonNull
    private final ResourceManager resourceManager;

    @Inject
    public AppDetailsViewModel(
            @NonNull ResourceManager resourceManager
    ) {
        this.resourceManager = resourceManager;
    }

    public void downloadApk(String url, Context context) {
        File file = new File(context.getFilesDir(), makeFileName(url));

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url))
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setDestinationUri(Uri.fromFile(file))
                .setTitle(resourceManager.getString(R.string.download_in_progress))
                .setAllowedOverMetered(true)
                .setAllowedOverRoaming(false);
        requestMutableLiveData.setValue(request);
    }

    private String makeFileName(String path) {
        String[] fileName = path.split("/");
        return fileName[fileName.length - 1];
    }

    public LiveData<DownloadManager.Request> getRequestMutableLiveData() {
        return requestMutableLiveData;
    }
}
