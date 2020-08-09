package com.niit.dkatalislabsassignment.data.local.db;

import com.niit.dkatalislabsassignment.data.model.db.Favorites;
import com.niit.dkatalislabsassignment.data.model.db.PersonInfo;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<List<PersonInfo>> getAllPersonInfo() {
        return mAppDatabase.personInfoDao().loadAll()
                .toObservable();
    }

    @Override
    public Observable<Boolean> savePersonInfoList(final List<PersonInfo> personInfoList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.personInfoDao().insertAll(personInfoList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveFavorites(Favorites favorites) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.favoritesDao().insert(favorites);
                return true;
            }
        });
    }

    @Override
    public Observable<List<Favorites>> getFavorites() {
        return mAppDatabase.favoritesDao().loadAll()
                .toObservable();
    }

    @Override
    public Observable<Boolean> isPersonInfoEmpty() {
        return mAppDatabase.personInfoDao().loadAll()
                .flatMapObservable(personInfo -> Observable.just(personInfo.isEmpty()));

    }

}
