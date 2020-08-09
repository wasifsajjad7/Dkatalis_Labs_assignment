package com.niit.dkatalislabsassignment.data.model.db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "personInfo")
public class PersonInfo {

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
}
