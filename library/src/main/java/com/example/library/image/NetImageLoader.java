package com.example.library.image;

import android.content.Context;
import android.widget.ImageView;



/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 16:09
 */
public class NetImageLoader{
    private IImageLoader mImageLoader;
    private static NetImageLoader sImageLoader;

    public static NetImageLoader getInstance(){
        if(sImageLoader==null){
            synchronized (NetImageLoader.class){
                if(sImageLoader==null){
                    sImageLoader=new NetImageLoader();
                }
            }
        }
        return sImageLoader;
    }

    private NetImageLoader() {
        mImageLoader=new GlideImageLoader();
    }

    public void init(IImageLoader imageLoader){
        if(imageLoader!=null)
            mImageLoader=imageLoader;
    }

    public void display(String imageUrl, ImageView imageView) {
        mImageLoader.display(imageUrl,imageView);
    }

    public void display(Context context, String imageUrl, ImageView imageView) {
        mImageLoader.display(context,imageUrl,imageView);
    }
}
