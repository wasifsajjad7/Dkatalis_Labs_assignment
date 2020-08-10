package com.niit.dkatalislabsassignment.ui.favorites;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.niit.dkatalislabsassignment.data.DataManager;
import com.niit.dkatalislabsassignment.data.model.db.Favorites;
import com.niit.dkatalislabsassignment.ui.base.BaseViewModel;
import com.niit.dkatalislabsassignment.utils.rx.SchedulerProvider;

import java.util.List;


public class FavoritesViewModel extends BaseViewModel<FavoritesNavigator> {

    private final MutableLiveData<List<Favorites>> favoriteListLiveData;

    public FavoritesViewModel(DataManager dataManager,
                              SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        favoriteListLiveData = new MutableLiveData<>();
        fetchFavorites();
    }

    public void fetchFavorites() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getFavorites()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(favoriteResponse -> {
                    if (favoriteResponse != null) {
                        favoriteListLiveData.setValue(favoriteResponse);
                    }
                }, throwable -> {
                    getNavigator().handleError(throwable);
                }));
    }

    public LiveData<List<Favorites>> getFavoriteListLiveData() {
        return favoriteListLiveData;
    }

    public void onNavBackClick() {
        getNavigator().goBack();
    }
}
