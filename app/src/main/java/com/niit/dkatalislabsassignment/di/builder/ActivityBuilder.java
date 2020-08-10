package com.niit.dkatalislabsassignment.di.builder;


import com.niit.dkatalislabsassignment.ui.favorites.FavoritesFragmentProvider;
import com.niit.dkatalislabsassignment.ui.details.DetailsFragmentProvider;
import com.niit.dkatalislabsassignment.ui.main.MainActivity;
import com.niit.dkatalislabsassignment.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = {
            DetailsFragmentProvider.class,
            FavoritesFragmentProvider.class,
            FavoritesFragmentProvider.class})
    abstract MainActivity bindMainActivity();
}
