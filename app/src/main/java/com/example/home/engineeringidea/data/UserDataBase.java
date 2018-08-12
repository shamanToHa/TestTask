package com.example.home.engineeringidea.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.home.engineeringidea.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {

    private static final Object lock = new Object();
    private static UserDataBase INSTANCE;

    public abstract UserDao getUserDao();

    public static UserDataBase getInstance(Context context) {
        synchronized (lock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        UserDataBase.class, "Users.db").build();
            }
            return INSTANCE;
        }
    }
}
