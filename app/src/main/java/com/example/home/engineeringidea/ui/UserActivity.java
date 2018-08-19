package com.example.home.engineeringidea.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.home.engineeringidea.R;
import com.example.home.engineeringidea.databinding.ActivityUserBinding;
import com.example.home.engineeringidea.model.User;

public class UserActivity extends AppCompatActivity {

    private final static String KEY = "key";


    public static void start(Context context, User user) {
        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra(KEY, user);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        User user = (User) getIntent().getSerializableExtra(KEY);

        ActivityUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user);
        binding.setUser(user);
    }
}
