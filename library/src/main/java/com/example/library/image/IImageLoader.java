package com.example.library.image;

import android.content.Context;
import android.widget.ImageView;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 16:09
 */
public interface IImageLoader {
    void display(String imageUrl, ImageView imageView);
    void display(Context context,String imageUrl, ImageView imageView);
}
