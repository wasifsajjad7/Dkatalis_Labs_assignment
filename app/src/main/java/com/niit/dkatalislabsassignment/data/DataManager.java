package com.niit.dkatalislabsassignment.data;


import com.niit.dkatalislabsassignment.data.local.db.DbHelper;
import com.niit.dkatalislabsassignment.data.local.prefs.PreferencesHelper;
import com.niit.dkatalislabsassignment.data.model.db.Favorites;
import com.niit.dkatalislabsassignment.data.model.db.PersonInfo;
import com.niit.dkatalislabsassignment.data.remote.ApiHelper;

import java.util.List;

import io.reactivex.Observable;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

    Observable<Boolean> seedDatabasePersonInfo();
    Observable<List<PersonInfo>> getAllPersonInfo();

    Observable<Boolean> saveFavorites(Favorites favorites);
    Observable<List<Favorites>> getFavorites();


}