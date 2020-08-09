package com.niit.dkatalislabsassignment.ui.favorite;

import com.niit.dkatalislabsassignment.data.DataManager;
import com.niit.dkatalislabsassignment.ui.base.BaseViewModel;
import com.niit.dkatalislabsassignment.utils.rx.SchedulerProvider;

public class FavoritesViewModel extends BaseViewModel<FavoritesNavigator> {

    public FavoritesViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }



    public void onNavBackClick() {
        getNavigator().goBack();
    }
}
