package com.niit.dkatalislabsassignment.ui.favorites;

import androidx.databinding.ObservableField;

import com.niit.dkatalislabsassignment.data.model.db.Favorites;

public class FavoritesItemViewModel {

    public final ObservableField<String> address;

    public final ObservableField<String> imageUrl;

    public final ObservableField<String> name;


    public FavoritesItemViewModel(Favorites personInfo) {
        imageUrl = new ObservableField<>(personInfo.imgUrl);
        address = new ObservableField<>(personInfo.personAddress);
        name = new ObservableField<>(personInfo.personName);
    }
}
