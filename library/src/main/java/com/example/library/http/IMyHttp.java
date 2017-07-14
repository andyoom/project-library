package com.example.library.http;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 14:23
 */
public interface IMyHttp {
    /**
     * Xutils的get请求封装
     * @param urlPath  请求的URL
     * @param map     请求的参数
     * @param cls     gson转换的类类型
     * @param callback 回调处理接口  需要实现
     */
    void get(String urlPath, Map<String,Object> map,
                     Class<?> cls, MyCallback callback);
    void get(String urlPath, Class<?> cls, MyCallback callback);
    void get(String urlPath, MyCallback callback);

    void post(String urlPath, Map<String,Object> map,
             Class<?> cls, MyCallback callback);
    void post(String urlPath, Class<?> cls, MyCallback callback);
    void post(String urlPath, MyCallback callback);

    void upload(String urlPath, Map<String,Object> map,List<File> uploadFiles,
             Class<?> cls, MyCallback callback);
    void upload(String urlPath, Map<String,Object> map,File uploadFile,
                Class<?> cls, MyCallback callback);
}
