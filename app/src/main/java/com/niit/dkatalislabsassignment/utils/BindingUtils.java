package com.niit.dkatalislabsassignment.utils;

import android.content.Context;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.niit.dkatalislabsassignment.data.model.db.Favorites;
import com.niit.dkatalislabsassignment.data.model.db.PersonInfo;
import com.niit.dkatalislabsassignment.ui.favorites.FavoritesAdapter;
import com.niit.dkatalislabsassignment.ui.main.MainViewModel;
import com.niit.dkatalislabsassignment.ui.main.PersonInfoCard;

import java.util.List;

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addFavoriteItems(RecyclerView recyclerView, List<Favorites> favorites) {
        FavoritesAdapter adapter = (FavoritesAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(favorites);
        }
    }

    @BindingAdapter({"adapter", "action","callback"})
    public static void addPersonInfoItems(SwipePlaceHolderView mCardsContainerView, List<PersonInfo> mPersonInfoList, int mAction,PersonInfoCard.CardCallback callback) {
        if (mAction == MainViewModel.ACTION_ADD_ALL) {
            if (mPersonInfoList != null) {
                mCardsContainerView.removeAllViews();
                for (PersonInfo peresonInfo : mPersonInfoList) {
                        mCardsContainerView.addView(new PersonInfoCard(peresonInfo,callback));
                }
                ViewAnimationUtils.scaleAnimateView(mCardsContainerView);
            }
        }
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }
}
