package com.niit.dkatalislabsassignment.di.component;

import android.app.Application;

import com.niit.dkatalislabsassignment.DkatailsApp;
import com.niit.dkatalislabsassignment.di.builder.ActivityBuilder;
import com.niit.dkatalislabsassignment.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(DkatailsApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
