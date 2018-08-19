package com.example.home.engineeringidea.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.home.engineeringidea.R;
import com.example.home.engineeringidea.adapter.UsersAdapter;
import com.example.home.engineeringidea.data.UserDao;
import com.example.home.engineeringidea.data.UserDataBase;
import com.example.home.engineeringidea.model.User;
import com.example.home.engineeringidea.network.Retrofit;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.users_recycler_view)
    RecyclerView usersList;
    UserDao userDao;
    List<User> users = new ArrayList<>();

    private UsersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new UsersAdapter(users, this);
        usersList.setAdapter(adapter);
        usersList.setLayoutManager(new LinearLayoutManager(this));
        userDao = UserDataBase.getInstance(getApplication()).getUserDao();

        new Thread(() -> {
            users.addAll(userDao.getAllUsers());
            if (users.isEmpty()) {
                downloadUsers();
            } else {
                runOnUiThread(() -> adapter.notifyDataSetChanged());
            }
        }).start();
    }

    private void downloadUsers() {
        Retrofit.getUsers(new Callback<List<User>>() {
            @Override
            public void success(List<User> users, Response response) {
                adapter.setUsers(users);
                new Thread(() -> {
                    for (User user : users) {
                        userDao.saveUser(user);
                    }
                }).start();
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }
}
