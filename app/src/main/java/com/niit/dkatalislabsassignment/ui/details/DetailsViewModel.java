package com.niit.dkatalislabsassignment.ui.details;

import android.text.TextUtils;

import androidx.databinding.ObservableField;

import com.niit.dkatalislabsassignment.data.DataManager;
import com.niit.dkatalislabsassignment.data.model.db.PersonInfo;
import com.niit.dkatalislabsassignment.ui.base.BaseViewModel;
import com.niit.dkatalislabsassignment.utils.rx.SchedulerProvider;

public class DetailsViewModel extends BaseViewModel<DetailsNavigator> {

    public final ObservableField<String> address = new ObservableField<>();

    public final ObservableField<String> imageUrl = new ObservableField<>();

    public final ObservableField<String> name = new ObservableField<>();

    public DetailsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void setPersonDetails(PersonInfo personInfo) {
        final String personName = personInfo.personName;
        if (!TextUtils.isEmpty(personName)) {
            name.set(personName);
        }

        final String personAddress = personInfo.personAddress;
        if (!TextUtils.isEmpty(personAddress)) {
            address.set(personAddress);
        }

        final String imgUrl = personInfo.imgUrl;
        if (!TextUtils.isEmpty(imgUrl)) {
            imageUrl.set(imgUrl);
        }
    }



    public void onNavBackClick() {
        getNavigator().goBack();
    }
}
