package com.example.storeapp.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.storeapp.R;
import com.example.storeapp.data.network.GetAppsResponse;
import com.example.storeapp.data.repository.AppsRepository;
import com.example.storeapp.data.resourcemanager.ResourceManager;
import com.example.storeapp.domain.mappers.AppsListMapper;
import com.example.storeapp.domain.models.AppsListItemModel;
import com.example.storeapp.utils.RxSchedulers;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

/**
 * ViewModel for screen with list of all apps
 */
public class AllAppsViewModel extends ViewModel {
    @NonNull
    private final AppsRepository repository;
    @NonNull
    private final RxSchedulers rxSchedulers;
    @NonNull
    private final CompositeDisposable disposable;
    @NonNull
    private final AppsListMapper mapper;
    @NonNull
    private final ResourceManager resourceManager;
    @NonNull
    private final MutableLiveData<List<AppsListItemModel>> appsList = new MutableLiveData<>();
    @NonNull
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();

    @Inject
    public AllAppsViewModel (
            @NonNull AppsRepository repository,
            @NonNull RxSchedulers rxSchedulers,
            @NonNull AppsListMapper mapper,
            @NonNull ResourceManager resourceManager
    ) {
        this.repository = repository;
        this.rxSchedulers = rxSchedulers;
        this.mapper = mapper;
        this.resourceManager = resourceManager;
        disposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared () {
        disposable.dispose();
        super.onCleared();
    }

    public void fetchAppsList () {
        disposable.add(
                repository.getAvailableApps()
                        .subscribeOn(rxSchedulers.io)
                        .observeOn(rxSchedulers.main)
                        .subscribe(this::onSuccessLoad, this::onErrorLoad)
        );
    }

    private void onSuccessLoad (List<GetAppsResponse> getAppsResponses) {
        Observable.fromIterable(getAppsResponses)
                .map(mapper::convert)
                .toList()
                .blockingSubscribe(appsList::setValue);
    }

    private void onErrorLoad (Throwable throwable) {
        errorMessage.postValue(resourceManager.getString(R.string.something_wrong_error));
    }

    public LiveData<List<AppsListItemModel>> getAppsList () {
        return appsList;
    }

    public LiveData<String> getErrorMessage () {
        return errorMessage;
    }
}
