package com.niit.dkatalislabsassignment.ui.splash;

import com.niit.dkatalislabsassignment.data.DataManager;
import com.niit.dkatalislabsassignment.ui.base.BaseViewModel;
import com.niit.dkatalislabsassignment.utils.rx.SchedulerProvider;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void startSeeding() {
        getCompositeDisposable().add(getDataManager()
                .seedDatabasePersonInfo()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(aBoolean -> {
                    decideNextActivity();
                }, throwable -> {
                    decideNextActivity();
                }));

    }

    private void decideNextActivity() {
        getNavigator().openMainActivity();
    }
}
