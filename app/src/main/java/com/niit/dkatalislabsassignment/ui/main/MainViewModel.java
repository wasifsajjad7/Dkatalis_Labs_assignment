package com.niit.dkatalislabsassignment.ui.main;

import android.util.Log;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.niit.dkatalislabsassignment.data.DataManager;
import com.niit.dkatalislabsassignment.data.model.db.Favorites;
import com.niit.dkatalislabsassignment.data.model.db.PersonInfo;
import com.niit.dkatalislabsassignment.ui.base.BaseViewModel;
import com.niit.dkatalislabsassignment.utils.rx.SchedulerProvider;

import java.util.List;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    private static final String TAG = "MainViewModel";

    public static final int NO_ACTION = -1, ACTION_ADD_ALL = 0, ACTION_DELETE_SINGLE = 1;


    private final MutableLiveData<List<PersonInfo>> personInfoCardData;

    private final ObservableList<PersonInfo> personInfoDataList = new ObservableArrayList<>();


    private int action = NO_ACTION;

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        personInfoCardData = new MutableLiveData<>();
        loadPersonInfoCards();
    }

    public int getAction() {
        return action;
    }


    public LiveData<List<PersonInfo>> getPersonInfoCardData() {
        return personInfoCardData;
    }

    public ObservableList<PersonInfo> getPersonInfoDataList() {
        return personInfoDataList;
    }

    public void setPersonInfoDataList(List<PersonInfo> personInfoCardData) {
        action = ACTION_ADD_ALL;
        personInfoDataList.clear();
        personInfoDataList.addAll(personInfoCardData);
    }


    public void loadPersonInfoCards() {
        getCompositeDisposable().add(getDataManager()
                .getAllPersonInfo()
                .doOnNext(list -> Log.d(TAG, "loadPersonInfoCards: " + list.size()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(personInfoList -> {
                    if (personInfoList != null) {
                        Log.d(TAG, "loadPersonInfoCards: " + personInfoList.size());
                        action = ACTION_ADD_ALL;
                        personInfoCardData.setValue(personInfoList);
                    }
                }, throwable -> {
                    Log.d(TAG, "loadPersonInfoCards: " + throwable);
                }));
    }

    public void saveFavorites(Favorites favorites) {
        getCompositeDisposable().add(getDataManager()
                .saveFavorites(favorites)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(aBoolean -> {
                    /* Work after save favorites*/
                }, throwable -> {
                    /* Work after save favorites*/
                }));
    }


    public void onNavMenuCreated() {
    }

    public void removePersonInfoCard() {
        action = ACTION_DELETE_SINGLE;

    }


}
