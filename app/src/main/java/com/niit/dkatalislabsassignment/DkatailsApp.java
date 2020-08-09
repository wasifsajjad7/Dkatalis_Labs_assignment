package com.niit.dkatalislabsassignment;

import android.app.Activity;
import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.niit.dkatalislabsassignment.di.component.DaggerAppComponent;
import com.niit.dkatalislabsassignment.utils.AppLogger;
import javax.inject.Inject;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
//import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class DkatailsApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

//    @Inject
//    CalligraphyConfig mCalligraphyConfig;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

//        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }
}
