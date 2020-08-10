package com.niit.dkatalislabsassignment.data.model.db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "favorites")
public class Favorites {

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    public String createdAt;

    @Expose
    @PrimaryKey
    public Long id;

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

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
}
