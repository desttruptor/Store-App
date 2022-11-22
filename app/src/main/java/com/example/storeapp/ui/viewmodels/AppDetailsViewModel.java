package com.example.storeapp.ui.viewmodels;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.storeapp.R;
import com.example.storeapp.data.repository.AppsRepository;
import com.example.storeapp.data.resourcemanager.ResourceManager;
import com.example.storeapp.domain.models.AppDetailsModel;
import com.example.storeapp.utils.RxSchedulers;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class AppDetailsViewModel extends ViewModel {

    @NonNull
    private final MutableLiveData<DownloadManager.Request> requestMutableLiveData = new MutableLiveData<>();
    @NonNull
    private final MutableLiveData<AppDetailsModel> selectedAppDetailsLiveData = new MutableLiveData<>();
    @NonNull
    private final MutableLiveData<String> errorLoadingSelectedAppDetailsLiveData = new MutableLiveData<>();
    @NonNull
    private final ResourceManager resourceManager;
    @NonNull
    private final AppsRepository appsRepository;
    @NonNull
    private final RxSchedulers rxSchedulers;
    @NonNull
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public AppDetailsViewModel (
            @NonNull ResourceManager resourceManager,
            @NonNull AppsRepository appsRepository,
            @NonNull RxSchedulers rxSchedulers
    ) {
        this.resourceManager = resourceManager;
        this.appsRepository = appsRepository;
        this.rxSchedulers = rxSchedulers;
    }

    @Override
    protected void onCleared () {
        compositeDisposable.dispose();
        super.onCleared();
    }

    public void loadSelectedAppInfo (String appTitle) {
        compositeDisposable.add(
                appsRepository.getAvailableApps()
                        .map(appsList -> Observable.fromIterable(appsList)
                                .filter(app -> app.getTitle().equals(appTitle))
                                .map(selectedApp -> new AppDetailsModel(
                                        selectedApp.getLink(),
                                        selectedApp.getVersion(),
                                        selectedApp.getType(),
                                        selectedApp.getLogo50Link(),
                                        selectedApp.getLogo200Link(),
                                        selectedApp.getTitle(),
                                        selectedApp.getDescription()
                                ))
                                .firstOrError()
                                .blockingGet())
                        .subscribeOn(rxSchedulers.io)
                        .observeOn(rxSchedulers.main)
                        .subscribe(this::onSuccessLoadSelectedApp, this::onErrorLoadSelectedApp)
        );
    }

    public void downloadApk (String url, Context context) {
        File file = new File(context.getFilesDir(), makeFileName(url));

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url))
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationUri(Uri.fromFile(file))
                .setTitle(resourceManager.getString(R.string.download_in_progress))
                .setAllowedOverMetered(true)
                .setAllowedOverRoaming(false);
        requestMutableLiveData.setValue(request);
    }

    private void onErrorLoadSelectedApp (Throwable throwable) {
        errorLoadingSelectedAppDetailsLiveData.setValue(resourceManager.getString(R.string.something_wrong_error));
    }

    private void onSuccessLoadSelectedApp (AppDetailsModel appDetailsModel) {
        selectedAppDetailsLiveData.setValue(appDetailsModel);
    }

    @NonNull
    public LiveData<DownloadManager.Request> getRequestMutableLiveData () {
        return requestMutableLiveData;
    }

    @NonNull
    public LiveData<AppDetailsModel> getSelectedAppDetailsLiveData () {
        return selectedAppDetailsLiveData;
    }

    @NonNull
    public LiveData<String> getErrorLoadingSelectedAppDetailsLiveData () {
        return errorLoadingSelectedAppDetailsLiveData;
    }

    @NonNull
    private String makeFileName (String path) {
        String[] fileName = path.split("/");
        return fileName[fileName.length - 1];
    }
}
