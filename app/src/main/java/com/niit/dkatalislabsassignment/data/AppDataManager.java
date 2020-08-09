package com.niit.dkatalislabsassignment.data;


import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Types;
import com.niit.dkatalislabsassignment.data.local.db.DbHelper;
import com.niit.dkatalislabsassignment.data.local.prefs.PreferencesHelper;
import com.niit.dkatalislabsassignment.data.model.db.Favorites;
import com.niit.dkatalislabsassignment.data.model.db.PersonInfo;
import com.niit.dkatalislabsassignment.data.remote.ApiHelper;
import com.niit.dkatalislabsassignment.utils.AppConstants;
import com.niit.dkatalislabsassignment.utils.CommonUtils;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Observable;

@Singleton
public class AppDataManager implements DataManager {


    private static final String TAG = "AppDataManager";

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final DbHelper mDbHelper;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mGson = gson;
    }


    @Override
    public Observable<List<PersonInfo>> getAllPersonInfo() {
        return mDbHelper.getAllPersonInfo();
    }

    @Override
    public Observable<Boolean> saveFavorites(Favorites favorites) {
        return mDbHelper.saveFavorites(favorites);
    }

    @Override
    public Observable<List<Favorites>> getFavorites() {
        return mDbHelper.getFavorites();
    }


    @Override
    public Observable<Boolean> savePersonInfoList(List<PersonInfo> personInfoList) {
        return mDbHelper.savePersonInfoList(personInfoList);
    }

    @Override
    public Observable<Boolean> isPersonInfoEmpty() {
        return mDbHelper.isPersonInfoEmpty();
    }

    @Override
    public Observable<Boolean> seedDatabasePersonInfo() {
        return mDbHelper.isPersonInfoEmpty()
                .concatMap(isEmpty -> {
                    if (isEmpty) {
                        Type type = $Gson$Types.newParameterizedTypeWithOwner(null, List.class, PersonInfo.class);
                        List<PersonInfo> personInfoList = mGson
                                .fromJson(CommonUtils.loadJSONFromAsset(mContext, AppConstants.SEED_DATABASE_PERSON_INFO), type);
                        return savePersonInfoList(personInfoList);
                    }
                    return Observable.just(false);
                });
    }
}
