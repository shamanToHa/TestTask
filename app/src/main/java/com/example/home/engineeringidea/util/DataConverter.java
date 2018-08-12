package com.example.home.engineeringidea.util;

import android.arch.persistence.room.TypeConverter;

import com.example.home.engineeringidea.model.Friend;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class DataConverter implements Serializable {
    @TypeConverter
    public String fromFriendList(List<Friend> friends) {
        if (friends == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Friend>>() {
        }.getType();
        String json = gson.toJson(friends, type);
        return json;
    }

    @TypeConverter
    public List<Friend> toFriendsList(String friendString) {
        if (friendString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Friend>>() {
        }.getType();
        List<Friend> friends = gson.fromJson(friendString, type);
        return friends;
    }

    @TypeConverter
    public String fromTagList(List<String> tags) {
        if (tags == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        String json = gson.toJson(tags, type);
        return json;
    }

    @TypeConverter
    public List<String> toTagsList(String tags) {
        if (tags == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        List<String> tagsList = gson.fromJson(tags, type);
        return tagsList;
    }
}
