package com.niit.dkatalislabsassignment.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.niit.dkatalislabsassignment.data.local.db.dao.FavoritesDao;
import com.niit.dkatalislabsassignment.data.local.db.dao.PersonInfoDao;
import com.niit.dkatalislabsassignment.data.model.db.PersonInfo;


@Database(entities = {PersonInfo.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonInfoDao personInfoDao();
    public abstract FavoritesDao favoritesDao();
}
