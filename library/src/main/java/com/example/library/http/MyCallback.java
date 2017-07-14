package com.example.library.http;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 11:46
 */
public interface MyCallback<T> {
    void success(T t);
    void error(Throwable ex);
}
