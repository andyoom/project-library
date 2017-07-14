package com.example.library;

import android.app.Application;

import com.example.library.http.MyHttp;
import com.example.library.image.NetImageLoader;
import com.example.library.image.NostraImageLoader;

import org.xutils.x;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 11:32
 */
public class App extends Application{
    private MyHttp mHttp;

    private static App sApp;
    @Override
    public void onCreate() {
        super.onCreate();
        sApp=this;

        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

        mHttp=new MyHttp();

        NetImageLoader.getInstance().init(new NostraImageLoader());
    }

    public static App getApp(){
        return sApp;
    }

    public MyHttp http(){
        return mHttp;
    }
}
