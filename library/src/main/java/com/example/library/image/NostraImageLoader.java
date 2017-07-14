package com.example.library.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.library.App;
import com.example.library.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;



/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 16:20
 */
public class NostraImageLoader implements IImageLoader{
    private ImageLoader imageLoader;
    private DisplayImageOptions options;
    public NostraImageLoader() {
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(App.getApp())
                .build();
        imageLoader= ImageLoader.getInstance();
        imageLoader.init(configuration);

        options=new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_launcher)
                .showImageOnFail(R.drawable.ic_launcher)
                .showImageForEmptyUri(R.drawable.ic_launcher)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
    }

    @Override
    public void display(String imageUrl, ImageView imageView) {
        imageLoader.displayImage(imageUrl,imageView,options);
    }

    @Override
    public void display(Context context, String imageUrl, ImageView imageView) {
        imageLoader.displayImage(imageUrl,imageView,options);
    }
}
