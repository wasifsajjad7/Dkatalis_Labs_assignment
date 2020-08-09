package com.niit.dkatalislabsassignment.di.builder;


import com.niit.dkatalislabsassignment.ui.favorite.FavoritesFragmentProvider;
import com.niit.dkatalislabsassignment.ui.main.MainActivity;
import com.niit.dkatalislabsassignment.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = {
            FavoritesFragmentProvider.class})
    abstract MainActivity bindMainActivity();
}
