package com.example.storeapp.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.storeapp.domain.models.AppsUiModel;
import com.example.storeapp.domain.usecases.FetchAllAppsListUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * ViewModel for {@link com.example.storeapp.ui.fragments.AppsListFragment}
 */
public class AppsListViewModel extends ViewModel {

    @Inject
    public FetchAllAppsListUseCase useCase;

    private final MutableLiveData<List<AppsUiModel>> appsList = new MutableLiveData<>();
    /**
     * If viewModel will be destroyed the background execution will be stopped
     */
    private CompositeDisposable disposable;

    @Override
    protected void onCleared () {
        disposable.dispose();
        super.onCleared();
    }

    public void fetchAllAppsList () {
//        appsList.setValue(useCase.execute(disposable));
    }

    public LiveData<List<AppsUiModel>> getAppsList () {
        return appsList;
    }
}
