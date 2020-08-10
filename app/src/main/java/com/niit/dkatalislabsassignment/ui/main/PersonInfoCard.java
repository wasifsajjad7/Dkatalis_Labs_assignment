package com.niit.dkatalislabsassignment.ui.main;

import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.niit.dkatalislabsassignment.R;
import com.niit.dkatalislabsassignment.data.model.db.PersonInfo;
import de.hdodenhof.circleimageview.CircleImageView;

@NonReusable
@Layout(R.layout.card_layout)
public class PersonInfoCard {


    private PersonInfo mPersonInfoCardData;

    @View(R.id.tv_person_name_txt)
    private TextView mPersonInfoTextView;

    @View(R.id.tv_person_address_txt)
    private TextView mPersonAddressTextView;

    @View(R.id.profile_image)
    private CircleImageView mProfileImage;

    private CardCallback callback;

    public PersonInfoCard(PersonInfo personInfoCardData ,CardCallback callback) {
        mPersonInfoCardData = personInfoCardData;
        this.callback = callback;
    }

    @Resolve
    private void onResolved() {
        mPersonInfoTextView.setText(mPersonInfoCardData.personName);
        mPersonAddressTextView.setText(mPersonInfoCardData.personAddress);
        Glide.with(mProfileImage.getContext()).load(mPersonInfoCardData.imgUrl).into(mProfileImage);
    }

    @SwipeOut
    public void onSwipedOut() {
        callback.onSwipeLeft(mPersonInfoCardData);
    }

    @SwipeIn
    public void onSwipeIn() {
        callback.onSwipeRight(mPersonInfoCardData);
    }

    public interface CardCallback{
        void onSwipeRight(PersonInfo mPersonInfoCardData);
        void onSwipeLeft(PersonInfo mPersonInfoCardData);
    }

}
