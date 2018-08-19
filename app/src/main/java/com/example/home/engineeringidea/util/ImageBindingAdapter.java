package com.example.home.engineeringidea.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.home.engineeringidea.R;
import com.squareup.picasso.Picasso;

public class ImageBindingAdapter {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView,String url){
        if(!url.equals("")){
            Picasso.with(imageView.getContext())
                    .load(url)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(imageView);
        }
    }
}
