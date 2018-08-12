package com.example.home.engineeringidea.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.home.engineeringidea.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveUser(User... users);

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("DELETE FROM user")
    void deleteAllUsers();

}
