package com.example.library.http;

import android.util.Log;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 11:35
 */
public class XutilsHttp implements IMyHttp{

    @Override
    public void get(String urlPath, Map<String, Object> map, Class<?> cls, MyCallback callback) {
        x.http().get(getRequestParams(urlPath,map),new MyCommonCallback(cls,callback));
    }

    @Override
    public void post(String urlPath, Map<String, Object> map, Class<?> cls, MyCallback callback) {
        x.http().post(getRequestParams(urlPath,map),new MyCommonCallback(cls,callback));
    }

    @Override
    public void get(String urlPath, Class<?> cls, MyCallback callback) {
        get(urlPath,null,cls,callback);
    }

    @Override
    public void post(String urlPath, Class<?> cls, MyCallback callback) {
        post(urlPath,null,cls,callback);
    }

    @Override
    public void get(String urlPath, MyCallback callback) {
        get(urlPath,getClass(callback),callback);
    }

    @Override
    public void post(String urlPath, MyCallback callback) {
        post(urlPath,getClass(callback),callback);
    }

    @Override
    public void upload(String urlPath, Map<String, Object> map, List<File> uploadFiles,
                       Class<?> cls, MyCallback callback) {
        RequestParams params=getRequestParams(urlPath,map);
        params.setMultipart(true);
        addUploadFiles(params,uploadFiles);
        x.http().post(params,new MyCommonCallback(cls,callback));
    }

    private void addUploadFiles(RequestParams params, List<File> uploadFiles) {
        if(uploadFiles!=null&&uploadFiles.size()>0){
            for (File file:uploadFiles){
                params.addBodyParameter("file",file);
            }
        }
    }

    @Override
    public void upload(String urlPath, Map<String, Object> map, File uploadFile, Class<?> cls, MyCallback callback) {
        List<File> files = new ArrayList<>();
        files.add(uploadFile);
        upload(urlPath,map,files,cls,callback);
    }


    private RequestParams getRequestParams(String urlPath,Map<String, Object> map){
        RequestParams params =new RequestParams(urlPath);
        if(map!=null&&map.size()>0){
            for (String key : map.keySet()){
                params.addQueryStringParameter(key,map.get(key)+"");
            }
        }
        return params;
    }

    private Class getClass(MyCallback callback){
        Class classCls = callback.getClass();
        Method[] methods= classCls.getDeclaredMethods();
        if(methods!=null&&methods.length>0) {
            for (Method method : methods) {
                if (method.getName().equals("success")) {
                    Type[] types = method.getGenericParameterTypes();
                    if (types != null && types.length > 0) {
                        for (Type type : types) {
                            String typeName = type.toString();
                            if (!typeName.contains("java.lang.Object")) {
                                return (Class) type;
                            }
                        }
                    }
                }
            }
        }
        Log.e("getByXutils", "getByXutils: 获取解析类型失败："+callback);
        return null;
    }


}
