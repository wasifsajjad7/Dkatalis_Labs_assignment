package com.niit.dkatalislabsassignment.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.niit.dkatalislabsassignment.di.PreferenceInfo;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

}
