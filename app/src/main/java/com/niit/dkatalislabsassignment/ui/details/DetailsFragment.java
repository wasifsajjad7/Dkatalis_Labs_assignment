package com.niit.dkatalislabsassignment.ui.details;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProviders;
import com.niit.dkatalislabsassignment.R;
import com.niit.dkatalislabsassignment.ViewModelProviderFactory;
import com.niit.dkatalislabsassignment.data.model.db.PersonInfo;
import com.niit.dkatalislabsassignment.databinding.FragmentDetailsBinding;
import com.niit.dkatalislabsassignment.ui.base.BaseFragment;
import com.niit.dkatalislabsassignment.utils.AppConstants;

import javax.inject.Inject;

public class DetailsFragment extends BaseFragment<FragmentDetailsBinding, DetailsViewModel> implements DetailsNavigator {

    public static final String TAG = DetailsFragment.class.getSimpleName();
    @Inject
    ViewModelProviderFactory factory;
    private DetailsViewModel mDetailsViewModel;

    public static DetailsFragment newInstance(PersonInfo personInfo) {
        Bundle args = new Bundle();
        args.putParcelable(AppConstants.PERSON_DETAILS,personInfo);
        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_details;
    }

    @Override
    public DetailsViewModel getViewModel() {
        mDetailsViewModel = ViewModelProviders.of(this,factory).get(DetailsViewModel.class);
        return mDetailsViewModel;
    }

    @Override
    public void goBack() {
        getBaseActivity().onFragmentDetached(TAG);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetailsViewModel.setNavigator(this);
        mDetailsViewModel.setPersonDetails(getArguments().getParcelable(AppConstants.PERSON_DETAILS));
    }
}
