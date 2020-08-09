package com.niit.dkatalislabsassignment.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.niit.dkatalislabsassignment.data.model.db.PersonInfo;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface PersonInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PersonInfo personInfo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<PersonInfo> personInfos);

    @Query("SELECT * FROM personInfo")
    Single<List<PersonInfo>> loadAll();
}
