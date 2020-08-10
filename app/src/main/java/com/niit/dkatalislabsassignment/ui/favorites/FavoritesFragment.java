package com.niit.dkatalislabsassignment.ui.favorites;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.niit.dkatalislabsassignment.R;
import com.niit.dkatalislabsassignment.ViewModelProviderFactory;
import com.niit.dkatalislabsassignment.databinding.FragmentFavoriteBinding;
import com.niit.dkatalislabsassignment.ui.base.BaseFragment;


import javax.inject.Inject;

public class FavoritesFragment extends BaseFragment<FragmentFavoriteBinding, FavoritesViewModel>
        implements FavoritesNavigator {
    public static final String TAG = FavoritesFragment.class.getSimpleName();
    @Inject
    FavoritesAdapter mFavoritesAdapter;
    FragmentFavoriteBinding mFragmentFavoriteBinding;
    @Inject
    LinearLayoutManager mLayoutManager;
    @Inject
    ViewModelProviderFactory factory;
    private FavoritesViewModel mFavoritesViewModel;

    public static FavoritesFragment newInstance() {
        Bundle args = new Bundle();
        FavoritesFragment fragment = new FavoritesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_favorite;
    }

    @Override
    public FavoritesViewModel getViewModel() {
        mFavoritesViewModel = ViewModelProviders.of(this, factory).get(FavoritesViewModel.class);
        return mFavoritesViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFavoritesViewModel.setNavigator(this);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentFavoriteBinding = getViewDataBinding();
        setUp();
    }


    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentFavoriteBinding.favoriteRecyclerView.setLayoutManager(mLayoutManager);
        mFragmentFavoriteBinding.favoriteRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFragmentFavoriteBinding.favoriteRecyclerView.setAdapter(mFavoritesAdapter);
    }
    @Override
    public void goBack() {
        getBaseActivity().onFragmentDetached(TAG);
    }
}
