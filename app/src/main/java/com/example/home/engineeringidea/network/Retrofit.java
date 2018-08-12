package com.example.home.engineeringidea.network;

import com.example.home.engineeringidea.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

public class Retrofit {
    private static final String ENDPOINT = "http://www.mocky.io";
    private static ApiInterface apiInterface;

    static {
        initialize();
    }

    interface ApiInterface {
        @GET("/v2/59c92a123f0000780183f72d")
        void getUsers(Callback<List<User>> callback);

    }

    private static void initialize() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        apiInterface = restAdapter.create(ApiInterface.class);
    }

    public static void getUsers(Callback<List<User>> callback) {
        apiInterface.getUsers(callback);
    }
}
