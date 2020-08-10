package com.niit.dkatalislabsassignment.ui.favorites;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FavoritesFragmentProvider {

    @ContributesAndroidInjector(modules = FavoritesFragmentModule.class)
    abstract FavoritesFragment provideFavoriteFragmentFactory();
}
