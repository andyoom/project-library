package com.example.library.http;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 14:25
 */
public class MyHttp{
    private IMyHttp http;

    public MyHttp() {
        this.http = new XutilsHttp();
    }

    public MyHttp(IMyHttp http) {
        this.http = http;
    }

    public void get(String urlPath, Map<String, Object> map, Class<?> cls, MyCallback callback) {
        http.get(urlPath,map,cls,callback);
    }

    public void get(String urlPath, Class<?> cls, MyCallback callback) {
        http.get(urlPath,cls,callback);
    }

    public void get(String urlPath, MyCallback callback) {
        http.get(urlPath,callback);
    }

    public void post(String urlPath, Map<String, Object> map, Class<?> cls, MyCallback callback) {
        http.post(urlPath,map,cls,callback);
    }

    public void post(String urlPath, Class<?> cls, MyCallback callback) {
        http.post(urlPath,cls,callback);
    }

    public void post(String urlPath, MyCallback callback) {
        http.post(urlPath,callback);
    }

    public void upload(String urlPath, Map<String, Object> map, List<File> uploadFiles, Class<?> cls, MyCallback callback) {
        http.upload(urlPath,map,uploadFiles,cls,callback);
    }

    public void upload(String urlPath, Map<String, Object> map, File uploadFile, Class<?> cls, MyCallback callback) {
        http.upload(urlPath,map,uploadFile,cls,callback);
    }
}
