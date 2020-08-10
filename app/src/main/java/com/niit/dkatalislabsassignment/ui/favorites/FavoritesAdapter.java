package com.niit.dkatalislabsassignment.ui.favorites;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.niit.dkatalislabsassignment.data.model.db.Favorites;
import com.niit.dkatalislabsassignment.databinding.ItemFavoriteViewBinding;
import com.niit.dkatalislabsassignment.ui.base.BaseViewHolder;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Favorites> mFavoriteResponseList;

    public FavoritesAdapter(List<Favorites> favoriteResponseList) {
        this.mFavoriteResponseList = favoriteResponseList;
    }

    @Override
    public int getItemCount() {
        if (mFavoriteResponseList != null && mFavoriteResponseList.size() > 0) {
            return mFavoriteResponseList.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                ItemFavoriteViewBinding favoriteViewBinding = ItemFavoriteViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new FavoriteViewHolder(favoriteViewBinding);

    }

    public void addItems(List<Favorites> favoriteList) {
        mFavoriteResponseList.addAll(favoriteList);
        notifyDataSetChanged();
    }
    public void clearItems() {
        mFavoriteResponseList.clear();
    }

    public class FavoriteViewHolder extends BaseViewHolder {

        private ItemFavoriteViewBinding mBinding;

        private FavoritesItemViewModel mFavoritesItemViewModel;

        public FavoriteViewHolder(ItemFavoriteViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final Favorites favorites = mFavoriteResponseList.get(position);
            mFavoritesItemViewModel = new FavoritesItemViewModel(favorites);
            mBinding.setViewModel(mFavoritesItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }
    }


}