package com.niit.dkatalislabsassignment.ui.favorites;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class FavoritesFragmentModule {

    @Provides
    FavoritesAdapter provideFavoriteAdapter() {
        return new FavoritesAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(FavoritesFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
