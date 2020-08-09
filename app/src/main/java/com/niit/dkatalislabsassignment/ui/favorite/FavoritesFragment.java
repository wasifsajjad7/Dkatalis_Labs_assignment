package com.niit.dkatalislabsassignment.ui.favorite;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProviders;


import com.niit.dkatalislabsassignment.R;
import com.niit.dkatalislabsassignment.ViewModelProviderFactory;
import com.niit.dkatalislabsassignment.databinding.FragmentAboutBinding;
import com.niit.dkatalislabsassignment.ui.base.BaseFragment;

import javax.inject.Inject;

public class FavoritesFragment extends BaseFragment<FragmentAboutBinding, FavoritesViewModel> implements FavoritesNavigator {

    public static final String TAG = FavoritesFragment.class.getSimpleName();
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
        return R.layout.fragment_about;
    }

    @Override
    public FavoritesViewModel getViewModel() {
        mFavoritesViewModel = ViewModelProviders.of(this,factory).get(FavoritesViewModel.class);
        return mFavoritesViewModel;
    }

    @Override
    public void goBack() {
        getBaseActivity().onFragmentDetached(TAG);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFavoritesViewModel.setNavigator(this);
    }
}
