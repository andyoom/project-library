package com.example.library.image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 16:11
 */
public class GlideImageLoader implements IImageLoader {
    @Override
    public void display(String imageUrl, ImageView imageView) {
        display(imageView.getContext(),imageUrl,imageView);
    }

    @Override
    public void display(Context context, String imageUrl, ImageView imageView) {
        Glide.with(context).load(imageUrl).into(imageView);
    }
}
