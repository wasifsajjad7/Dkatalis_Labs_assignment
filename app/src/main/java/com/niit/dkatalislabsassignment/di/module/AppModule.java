package com.niit.dkatalislabsassignment.di.module;

import android.app.Application;
import android.content.Context;
import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.dkatalislabsassignment.data.AppDataManager;
import com.niit.dkatalislabsassignment.data.DataManager;
import com.niit.dkatalislabsassignment.data.local.db.AppDatabase;
import com.niit.dkatalislabsassignment.data.local.db.AppDbHelper;
import com.niit.dkatalislabsassignment.data.local.db.DbHelper;
import com.niit.dkatalislabsassignment.data.local.prefs.AppPreferencesHelper;
import com.niit.dkatalislabsassignment.data.local.prefs.PreferencesHelper;
import com.niit.dkatalislabsassignment.data.remote.ApiHelper;
import com.niit.dkatalislabsassignment.data.remote.AppApiHelper;
import com.niit.dkatalislabsassignment.di.DatabaseInfo;
import com.niit.dkatalislabsassignment.di.PreferenceInfo;
import com.niit.dkatalislabsassignment.utils.AppConstants;
import com.niit.dkatalislabsassignment.utils.rx.AppSchedulerProvider;
import com.niit.dkatalislabsassignment.utils.rx.SchedulerProvider;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }


    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


}
