package com.example.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.library.http.MyHttp;

import org.xutils.x;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 14:55
 */
public class BaseActvity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    public MyHttp http(){
        return App.getApp().http();
    }
}
