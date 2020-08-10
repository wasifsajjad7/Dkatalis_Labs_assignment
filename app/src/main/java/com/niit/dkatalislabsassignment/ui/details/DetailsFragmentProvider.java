package com.niit.dkatalislabsassignment.ui.details;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DetailsFragmentProvider {

    @ContributesAndroidInjector
    abstract DetailsFragment provideAboutFragmentFactory();
}
