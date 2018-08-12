package com.example.home.engineeringidea.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home.engineeringidea.R;
import com.example.home.engineeringidea.model.User;
import com.example.home.engineeringidea.util.DataConverter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity {
    private final static String KEY = "key";
    private DataConverter dataConverter = new DataConverter();
    @BindView(R.id.user_name)
    TextView name;
    @BindView(R.id.user_picture)
    ImageView picture;
    @BindView(R.id.user_id)
    TextView id;
    @BindView(R.id.user_isActive)
    TextView active;
    @BindView(R.id.user_balance)
    TextView balance;
    @BindView(R.id.user_age)
    TextView age;
    @BindView(R.id.user_eyeColor)
    TextView color;
    @BindView(R.id.user_gender)
    TextView gender;
    @BindView(R.id.user_company)
    TextView company;
    @BindView(R.id.user_email)
    TextView email;
    @BindView(R.id.user_phone)
    TextView phone;
    @BindView(R.id.user_address)
    TextView address;
    @BindView(R.id.user_about)
    TextView about;
    @BindView(R.id.user_registered)
    TextView registered;
    @BindView(R.id.user_friend)
    TextView friend;
    @BindView(R.id.user_tag)
    TextView tag;


    public static void start(Context context, User user) {
        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra(KEY, user);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        User user = (User) getIntent().getSerializableExtra(KEY);

        if (user != null) {

            name.setText(user.getName());
            id.setText(String.valueOf(user.getId()));
            active.setText(String.valueOf(user.isActive()));
            balance.setText(user.getBalance());
            age.setText(String.valueOf(user.getAge()));
            color.setText(user.getEyeColor());
            gender.setText(user.getGender());
            company.setText(user.getCompany());
            email.setText(user.getEmail());
            phone.setText(user.getPhone());
            address.setText(user.getAddress());
            about.setText(user.getAbout());
            registered.setText(user.getRegistered());
            friend.setText(dataConverter.fromFriendList(user.getFriends()));
            tag.setText(dataConverter.fromTagList(user.getTags()));
            Picasso.with(this)
                    .load(user.getPicture())
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(picture);
        }
    }
}
