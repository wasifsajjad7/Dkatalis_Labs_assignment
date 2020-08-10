package com.niit.dkatalislabsassignment.data.local.db;

import com.niit.dkatalislabsassignment.data.model.db.Favorites;
import com.niit.dkatalislabsassignment.data.model.db.PersonInfo;
import java.util.List;
import io.reactivex.Observable;

public interface DbHelper {

    Observable<List<PersonInfo>> getAllPersonInfo();

    Observable<Boolean> savePersonInfoList(List<PersonInfo> personInfoList);

    Observable<Boolean> saveFavorites(Favorites personInfo);

    Observable<List<Favorites>> getFavorites();

    Observable<Boolean> isPersonInfoEmpty();
}