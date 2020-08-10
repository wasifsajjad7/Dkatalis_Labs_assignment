package com.niit.dkatalislabsassignment;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.niit.dkatalislabsassignment.data.DataManager;
import com.niit.dkatalislabsassignment.ui.favorites.FavoritesViewModel;
import com.niit.dkatalislabsassignment.ui.details.DetailsViewModel;
import com.niit.dkatalislabsassignment.ui.main.MainViewModel;
import com.niit.dkatalislabsassignment.ui.splash.SplashViewModel;
import com.niit.dkatalislabsassignment.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

  private final DataManager dataManager;
  private final SchedulerProvider schedulerProvider;

  @Inject
  public ViewModelProviderFactory(DataManager dataManager,
                                  SchedulerProvider schedulerProvider) {
    this.dataManager = dataManager;
    this.schedulerProvider = schedulerProvider;
  }


  @Override
  public <T extends ViewModel> T create(Class<T> modelClass) {
   if (modelClass.isAssignableFrom(SplashViewModel.class)) {
      //noinspection unchecked
      return (T) new SplashViewModel(dataManager,schedulerProvider);
    }else if (modelClass.isAssignableFrom(MainViewModel.class)) {
       //noinspection unchecked
       return (T) new MainViewModel(dataManager,schedulerProvider);
   }else  if (modelClass.isAssignableFrom(FavoritesViewModel.class)) {
       //noinspection unchecked
       return (T) new FavoritesViewModel(dataManager,schedulerProvider);
   }else  if (modelClass.isAssignableFrom(DetailsViewModel.class)) {
       //noinspection unchecked
       return (T) new DetailsViewModel(dataManager,schedulerProvider);
   }else if (modelClass.isAssignableFrom(FavoritesViewModel.class)) {
       //noinspection unchecked
       return (T) new FavoritesViewModel(dataManager,schedulerProvider);
   }
      throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
  }
}