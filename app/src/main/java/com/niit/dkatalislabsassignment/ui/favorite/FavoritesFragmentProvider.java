package com.niit.dkatalislabsassignment.ui.favorite;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FavoritesFragmentProvider {

    @ContributesAndroidInjector
    abstract FavoritesFragment provideAboutFragmentFactory();
}
