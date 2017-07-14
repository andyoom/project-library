package com.example.library.http;

import android.util.Log;

import com.google.gson.Gson;

import org.xutils.common.Callback;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 11:41
 */
public class MyCommonCallback implements Callback.CommonCallback<String>{
    private Class<?> clsType;
    private MyCallback callback;

    public MyCommonCallback(Class<?> cls,MyCallback callback) {
        this.clsType=cls;
        this.callback=callback;
    }

    @Override
    public void onSuccess(String result) {
        if(result!=null){
            Gson gson=new Gson();
           callback.success(gson.fromJson(result,clsType));
        }
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        callback.error(ex);
    }

    @Override
    public void onCancelled(CancelledException cex) {
        Log.e("onCancelled", "onCancelled: "+"用户取消操作---"+cex.getMessage());
    }

    @Override
    public void onFinished() {

    }
}
