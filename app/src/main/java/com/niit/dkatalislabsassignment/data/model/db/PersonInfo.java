package com.niit.dkatalislabsassignment.data.model.db;


import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "personInfo")
public class PersonInfo implements Parcelable {

    public PersonInfo(){

    }

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    public String createdAt;

    @Expose
    @PrimaryKey
    public Long id;

    @Expose
    @SerializedName("person_img_url")
    @ColumnInfo(name = "person_img_url")
    public String imgUrl;

    @Expose
    @SerializedName("person_name")
    @ColumnInfo(name = "person_name")
    public String personName;

    @Expose
    @SerializedName("person_address")
    @ColumnInfo(name = "person_address")
    public String personAddress;

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    public String updatedAt;

    protected PersonInfo(Parcel in) {
        createdAt = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        imgUrl = in.readString();
        personName = in.readString();
        personAddress = in.readString();
        updatedAt = in.readString();
    }

    public static final Creator<PersonInfo> CREATOR = new Creator<PersonInfo>() {
        @Override
        public PersonInfo createFromParcel(Parcel in) {
            return new PersonInfo(in);
        }

        @Override
        public PersonInfo[] newArray(int size) {
            return new PersonInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(createdAt);
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeString(imgUrl);
        parcel.writeString(personName);
        parcel.writeString(personAddress);
        parcel.writeString(updatedAt);
    }
}
