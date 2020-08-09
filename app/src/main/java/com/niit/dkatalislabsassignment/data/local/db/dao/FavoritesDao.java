package com.niit.dkatalislabsassignment.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.niit.dkatalislabsassignment.data.model.db.Favorites;
import java.util.List;
import io.reactivex.Single;

@Dao
public interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Favorites favorites);

    @Query("SELECT * FROM personInfo")
    Single<List<Favorites>> loadAll();
}
